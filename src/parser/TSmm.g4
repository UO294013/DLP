/* GRAMMAR NAME */
grammar TSmm;

/* OPTIONS (Imports) */
@header {
    import ast.*;
    import ast.types.*;
    import ast.statements.*;
    import ast.locatables.*;
    import ast.locatables.expressions.*;
    import ast.locatables.definitions.*;
    import java.util.*;
}

/* SYNTACTIC ANALYZER */

program returns [Program ast = new Program(new ArrayList<Definition>())]:
    (definition { $ast.getDefinitions().addAll($definition.ast); })* main { $ast.getDefinitions().add($main.ast); } EOF
    ;

expression returns [Expression ast]:
    ID '(' arguments ')' { $ast = new FunctionCall($ID.getLine(), $ID.getCharPositionInLine() + 1, new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine() + 1), $arguments.ast); }
    | '(' expression ')' { $ast = $expression.ast; }
    | exp1=expression '[' exp2=expression ']' { $ast = new ArrayAccess($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast); }
    | ex1=expression '.' ID { $ast = new FieldAccess($ID.text, $ex1.ast, $ex1.ast.getLine(), $ex1.ast.getColumn()); }
    | '(' expression 'as' type ')' { $ast = new Cast($expression.ast, $type.ast, $expression.ast.getLine(), $expression.ast.getColumn()); }
    | '-' expression { $ast = new UnaryMinus($expression.ast, $expression.ast.getLine(), $expression.ast.getColumn()); }
    | '!' expression { $ast = new UnaryNot($expression.ast, $expression.ast.getLine(), $expression.ast.getColumn()); }
    | exp1=expression op=('*'|'/'|'%') exp2=expression { $ast = new ArithmeticOperation($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $op.text); }
    | exp1=expression op=('+'|'-') exp2=expression { $ast = new ArithmeticOperation($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $op.text); }
    | exp1=expression op=('>'|'>='|'<'|'<='|'!='|'==') exp2=expression { $ast = new ComparisonOperation($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $op.text); }
    | exp1=expression op=('&&'|'||') exp2=expression { $ast = new LogicOperation($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast, $op.text); }
    | INT_CONSTANT { $ast = new IntLiteral(LexerHelper.lexemeToInt($INT_CONSTANT.text), $INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1); }
    | REAL_CONSTANT { $ast = new NumberLiteral(LexerHelper.lexemeToReal($REAL_CONSTANT.text), $REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine() + 1); }
    | CHAR_CONSTANT { $ast = new CharLiteral(LexerHelper.lexemeToChar($CHAR_CONSTANT.text), $CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine() + 1); }
    | ID { $ast = new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine() + 1); }
    ;

type returns [Type ast] locals [List<RecordField> fields = new ArrayList<>()]:
    returntype { $ast = $returntype.ast; }
    | '[' INT_CONSTANT ']' type { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.text), $type.ast); }
    | '[' (recordfield { $fields = $recordfield.ast; })+ ']' { $ast = new RecordType($fields); }
    ;

vartype returns [Type ast] locals [List<RecordField> fields = new ArrayList<>()]:
    builtin { $ast = $builtin.ast; }
    | '[' INT_CONSTANT ']' vartype { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.text), $vartype.ast); }
    | '[' (recordfield { $recordfield.ast.forEach( rf -> { if ($fields.contains(rf)) { new ErrorType("Error: RecordField '" + rf.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) rf); } else { $fields.add(rf); } }); })+ ']' { $ast = new RecordType($fields); }
    ;

returntype returns [Type ast]:
    builtin { $ast = $builtin.ast; }
    | 'void' { $ast = VoidType.getInstance(); }
    ;

builtin returns [Type ast]:
    'int' { $ast = IntType.getInstance(); }
    | 'number' { $ast = NumberType.getInstance(); }
    | 'char' { $ast = CharType.getInstance(); }
    ;

statement returns [List<Statement> ast = new ArrayList<>()]:
    nonreturnstatement { $ast.addAll($nonreturnstatement.ast); }
    | 'return' expression ';' { $ast.add(new Return($expression.ast, $expression.ast.getLine(), $expression.ast.getColumn())); }
    ;

nonreturnstatement returns [List<Statement> ast = new ArrayList<>()] locals [List<Expression> expressions = new ArrayList<>(), List<Statement> elseBlock = new ArrayList<>()]:
    'log' exp1=expression { $expressions.add($exp1.ast); } (',' exp2=expression { $expressions.add($exp2.ast); })* ';' { $expressions.forEach( exp -> $ast.add(new Write(exp, exp.getLine(), exp.getColumn()))); }
    | 'input' exp1=expression { $expressions.add($exp1.ast); } (',' exp2=expression { $expressions.add($exp2.ast); })* ';' { $expressions.forEach( exp -> $ast.add(new Read(exp, exp.getLine(), exp.getColumn()))); }
    | exp1=expression '=' exp2=expression ';' { $ast.add(new Assignment($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast)); }
    | 'if' '(' expression ')' b1=block ('else' b2=block { if ($b2.statements != null) $elseBlock = $b2.statements; })? { $ast.add(new IfElse($expression.ast, $b1.statements, $elseBlock, $expression.ast.getLine(), $expression.ast.getColumn())); }
    | 'while' '(' expression ')' block { $ast.add(new While($expression.ast, $block.statements, $expression.ast.getLine(), $expression.ast.getColumn())); }
    | ID '(' arguments ')' ';' { $ast.add(new FunctionCall($ID.getLine(), $ID.getCharPositionInLine() + 1, new Variable($ID.text, $ID.getLine(), $ID.getCharPositionInLine() + 1), $arguments.ast)); }
    ;

definition returns [List<Definition> ast = new ArrayList<>()]:
    vardefinition { $ast.addAll($vardefinition.ast); }
    | funcdefinition { $ast.add($funcdefinition.ast); }
    ;

vardefinition returns [List<VariableDefinition> ast = new ArrayList<>()] locals [List<Variable> vars = new ArrayList<>()]:
    'let' id1=ID { $vars.add(new Variable($id1.text, $id1.getLine(), $id1.getCharPositionInLine() + 1)); } (',' id2=ID { Variable var = new Variable($id2.text, $id2.getLine(), $id2.getCharPositionInLine() + 1); if ($vars.contains(var)) { new ErrorType("Error: Variable '" + var.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) var); } else { $vars.add(var); }; })* ':' vartype ';' { $vars.forEach( var -> $ast.add(new VariableDefinition(var.getName(), $vartype.ast, var.getLine(), var.getColumn()))); }
    ;

funcdefinition returns [Definition ast] locals [List<VariableDefinition> args = new ArrayList<>(), List<VariableDefinition> defs = new ArrayList<>(), List<Statement> stmts = new ArrayList<>()]:
    'function' ID '(' (parameters { $args = $parameters.ast; })? ')' ':' returntype '{' (vardefinition { $defs.addAll($vardefinition.ast); })* (statement { $stmts.addAll($statement.ast); })* '}' { $ast = new FunctionDefinition($ID.text, new FunctionType($args, $returntype.ast), $defs, $stmts, $ID.getLine(), $ID.getCharPositionInLine() + 1); }
    ;

main returns [Definition ast] locals [List<VariableDefinition> args = new ArrayList<>(), List<VariableDefinition> defs = new ArrayList<>(), List<Statement> stmts = new ArrayList<>()]:
    'function' 'main' '(' ')' ':' 'void' '{' (vardefinition { $defs.addAll($vardefinition.ast); })* (nonreturnstatement { $stmts.addAll($nonreturnstatement.ast); })* '}' { $ast = new FunctionDefinition("main", new FunctionType(new ArrayList(), VoidType.getInstance()), $defs, $stmts, $start.getLine(), $start.getCharPositionInLine() + 1); }
    ;

arguments returns [List<Expression> ast = new ArrayList<>()]:
    (exp1=expression { $ast.add($exp1.ast); }|exp2=expression { $ast.add($exp2.ast); }(',' exp3=expression { $ast.add($exp3.ast); })+)?
    ;

recordfield returns [List<RecordField> ast = new ArrayList<>()] locals [List<Variable> vars = new ArrayList<>()]:
    'let' id1=ID { $vars.add(new Variable($id1.text, $id1.getLine(), $id1.getCharPositionInLine() + 1)); } (',' id2=ID { $vars.add(new Variable($id2.text, $id2.getLine(), $id2.getCharPositionInLine() + 1)); })* ':' vartype ';' { $vars.forEach( var -> $ast.add(new RecordField(var.getName(), $vartype.ast, var.getLine(), var.getColumn()))); }
    ;

parameters returns [List<VariableDefinition> ast = new ArrayList<>()]:
    id1=ID ':' b1=builtin { $ast.add(new VariableDefinition($id1.text, $b1.ast, $id1.getLine(), $id1.getCharPositionInLine() + 1)); } (',' id2=ID ':' b2=builtin { $ast.add(new VariableDefinition($id2.text, $b2.ast, $id2.getLine(), $id2.getCharPositionInLine() + 1)); })*
    ;

block returns [List<Statement> statements = new ArrayList<>()]:
    ('{' st1=statement { $statements.addAll($st1.ast); } (st2=statement { $statements.addAll($st2.ast); })* '}'|st3=statement { $statements.addAll($st3.ast); })?
    ;

/* LEXICAL ANALYZER */

fragment
DIGIT: [0-9]
     ;

fragment
EXPONENT: [Ee] [+-]? DIGIT+
        ;

INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;

REAL_CONSTANT: DIGIT+ '.' DIGIT* EXPONENT?
             | '.' DIGIT+ EXPONENT?
             | DIGIT+ EXPONENT
             ;

CHAR_CONSTANT: '\'' . '\''
             | '\'\\' ('n'|'t'|INT_CONSTANT) '\''
             ;

ID: ('_'|[A-Za-z]) ([A-Za-z]|'_'|DIGIT)*
  ;

WHITE_SPACE: [ \t\r\n\f]+ -> skip
           ;

SINGLE_LINE_COMMENT: '//' ~[\r\n]* -> skip
                   ;

MULTILINE_COMMENT: '/*' .*? '*/' -> skip
                 ;

package semantic;

import ast.Program;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.RecordField;
import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP, TR> {

    // PROGRAM
    TR visit(Program program, TP param);

    // EXPRESSIONS
    TR visit(ArithmeticOperation a, TP paramType);
    TR visit(ArrayAccess a, TP paramType);
    TR visit(Cast a, TP paramType);
    TR visit(CharLiteral a, TP paramType);
    TR visit(ComparisonOperation a, TP paramType);
    TR visit(FieldAccess f, TP paramType);
    TR visit(FunctionCall f, TP paramType);
    TR visit(IntLiteral i, TP paramType);
    TR visit(LogicOperation l, TP paramType);
    TR visit(NumberLiteral n, TP paramType);
    TR visit(UnaryMinus u, TP paramType);
    TR visit(UnaryNot u, TP paramType);
    TR visit(Variable v, TP paramType);

    // STATEMENTS
    TR visit(Assignment a, TP paramType);
    TR visit(For f, TP param);
    TR visit(IfElse i, TP paramType);
    TR visit(Read r, TP paramType);
    TR visit(Return r, TP paramType);
    TR visit(While w, TP paramType);
    TR visit(Write w, TP paramType);

    // DEFINITIONS
    TR visit(FunctionDefinition f, TP paramType);
    TR visit(RecordField r, TP paramType);
    TR visit(VariableDefinition v, TP paramType);

    // TYPES
    TR visit(ArrayType a, TP paramType);
    TR visit(CharType c, TP paramType);
    TR visit(ErrorType e, TP paramType);
    TR visit(FunctionType f, TP paramType);
    TR visit(IntType i, TP paramType);
    TR visit(NumberType n, TP paramType);
    TR visit(RecordType r, TP paramType);
    TR visit(VoidType v, TP paramType);
}

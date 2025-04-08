package codegen;

import ast.locatables.expressions.*;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    public AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    /**
     * value[[Arithmetic: exp1 → exp2 (+|-|*|/) exp3]]():
     *   value[[exp2]]
     *   exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(exp1.type) // cg.convert(exp3.type, exp1.type)
     *   switch (exp1.operator) {
     *     case "+": <add> exp1.type.suffix() break;
     *     case "-": <sub> exp1.type.suffix() break;
     *     case "*": <div> exp1.type.suffix() break;
     *     case "/": <mul> exp1.type.suffix() break;
     *   }
     */
    @Override
    public Void visit(ArithmeticOperation a, Void arg) {
        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Void arg) {
        return null;
    }

    /**
     * execute[[Cast: exp1 -> exp2 type]]():
     *   value[[exp2]]
     *   if (type.suffix().equals("b") && exp2.type.suffix().equals("f")) {
     *     <f2i>
     *     <i2b>
     *   } else if (type.suffix().equals("f") && exp2.type.suffix().equals("b")) {
     *     <b2i>
     *     <i2f>
     *   } else {
     *     exp2.type.suffix <2> type.suffix()
     *   }
     */
    @Override
    public Void visit(Cast c, Void arg) {
        return null;
    }

    /**
     * execute[[CharLiteral: exp -> CHAR_CONSTANT]]():
     *   <pushb> exp.value
     */
    @Override
    public Void visit(CharLiteral c, Void arg) {
        return null;
    }

    /**
     * value[[Comparison: exp1 → exp2 (>|>=|<|<=|==|!=) exp3]]():
     *   value[[exp2]]
     *   exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(exp1.type) // cg.convert(exp3.type, exp1.type)
     *   switch (exp1.operator) {
     *     case ">": <gt> exp1.type.suffix() break;
     *     case ">=": <ge> exp1.type.suffix() break;
     *     case "<": <lt> exp1.type.suffix() break;
     *     case "<=": <le> exp1.type.suffix() break;
     *     case "==": <eq> exp1.type.suffix() break;
     *     case "!=": <ne> exp1.type.suffix() break;
     *   }
     */
    @Override
    public Void visit(ComparisonOperation c, Void arg) {
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void arg) {
        return null;
    }

    @Override
    public Void visit(FunctionCall f, Void arg) {
        return null;
    }

    /**
     * execute[[IntLiteral: exp -> INT_CONSTANT]]():
     *   <pushi> exp.value
     */
    @Override
    public Void visit(IntLiteral i, Void arg) {
        return null;
    }

    @Override
    public Void visit(LogicOperation l, Void arg) {
        return null;
    }

    /**
     * execute[[NumberLiteral: exp -> REAL_CONSTANT]]():
     *   <pushf> exp.value
     */
    @Override
    public Void visit(NumberLiteral n, Void arg) {
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Void arg) {
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Void arg) {
        return null;
    }

    /**
     * execute[[Variable: exp -> ID]]():
     *   address[[exp]]
     *   <load> exp.type.suffix()
     */
    @Override
    public Void visit(Variable v, Void arg) {
        return null;
    }
}

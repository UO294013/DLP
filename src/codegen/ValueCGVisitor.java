package codegen;

import ast.locatables.expressions.*;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

    public AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    /**
     * value[[Arithmetic: exp1 → exp2 ("+"|"-"|"*"|"/"|"%") exp3]]():
     *   value[[exp2]]
     *   exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(exp1.type) // cg.convert(exp3.type, exp1.type)
     *   switch (exp1.operator) { // cg.arithmetic(exp1.getOperator(), exp1.getType())
     *     case "+": <add> exp1.type.suffix() break;
     *     case "-": <sub> exp1.type.suffix() break;
     *     case "*": <div> exp1.type.suffix() break;
     *     case "/": <mul> exp1.type.suffix() break;
     *     case "%": <mod> exp1.type.suffix() break;
     *   }
     */
    @Override
    public Void visit(ArithmeticOperation a, Void arg) {
        a.getLeftOperand().accept(this, null);
        codeGenerator.convertTo(a.getLeftOperand().getType(), a.getType());
        a.getRightOperand().accept(this, null);
        codeGenerator.convertTo(a.getRightOperand().getType(), a.getType());
        codeGenerator.arithmetic(a.getOperatorName(), a.getType());
        return null;
    }

    /**
     * execute[[ArrayAccess: exp1 -> exp2 exp3]]():
     *     // TODO: How can we implement the array access?
     */
    @Override
    public Void visit(ArrayAccess a, Void arg) {
        return null;
    }

    /**
     * execute[[Cast: exp1 -> exp2 type]]():
     *   value[[exp2]]
     *   // cg.convertTo(exp2.type, type)
     *   if (type.suffix().equals("b") && exp2.type.suffix().equals("f")) {
     *     <f2i>
     *     <i2b>
     *   } else if (type.suffix().equals("f") && exp2.type.suffix().equals("b")) {
     *     <b2i>
     *     <i2f>
     *   } else {
     *     exp2.type.suffix() <2> type.suffix()
     *   }
     */
    @Override
    public Void visit(Cast c, Void arg) {
        c.getExpression().accept(this, null);
        codeGenerator.convertTo(c.getExpression().getType(), c.getType());
        return null;
    }

    /**
     * execute[[CharLiteral: exp -> CHAR_CONSTANT]]():
     *   <pushb> exp.value
     */
    @Override
    public Void visit(CharLiteral c, Void arg) {
        codeGenerator.pushb(c.getValue());
        return null;
    }

    /**
     * value[[Comparison: exp1 → exp2 (">"|">="|"<"|"<="|"=="|"!=") exp3]]():
     *   value[[exp2]]
     *   exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(exp1.type) // cg.convert(exp3.type, exp1.type)
     *   switch (exp1.operator) {  // cg.comparison(exp1.getOperator(), exp1.getType())
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
        c.getLeftOperand().accept(this, null);
        codeGenerator.convertTo(c.getLeftOperand().getType(), c.getType());
        c.getRightOperand().accept(this, null);
        codeGenerator.convertTo(c.getRightOperand().getType(), c.getType());
        codeGenerator.comparison(c.getOperatorName(), c.getType());
        return null;
    }

    /**
     * execute[[FieldAccess: exp1 -> exp2 ID]]():
     *     // TODO: Acabar
     */
    @Override
    public Void visit(FieldAccess f, Void arg) {
        return null;
    }

    /**
     * execute[[FieldCall: statement -> ID expression*]]():
     *     // TODO: Acabar
     */
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
        codeGenerator.pushi(i.getValue());
        return null;
    }

    /**
     * value[[Logic: exp1 → exp2 ("&&"|"||"|"!") exp3]]():
     *   value[[exp2]]
     *   exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(exp1.type) // cg.convert(exp3.type, exp1.type)
     *   switch (exp1.operator) {  // cg.logic(exp1.getOperator(), exp1.getType())
     *     case "&&": <and> break;
     *     case "||": <or> break;
     *     case "!": <not> break;
     *   }
     */
    @Override
    public Void visit(LogicOperation l, Void arg) {
        l.getLeftOperand().accept(this, null);
        codeGenerator.convertTo(l.getLeftOperand().getType(), l.getType());
        l.getRightOperand().accept(this, null);
        codeGenerator.convertTo(l.getRightOperand().getType(), l.getType());
        codeGenerator.logic(l.getOperatorName());
        return null;
    }

    /**
     * execute[[NumberLiteral: exp -> REAL_CONSTANT]]():
     *   <pushf> exp.value
     */
    @Override
    public Void visit(NumberLiteral n, Void arg) {
        codeGenerator.pushf(n.getValue());
        return null;
    }

    /**
     * execute[[UnaryMinus: exp1 -> exp2]]():
     *     // TODO: Acabar.
     */
    @Override
    public Void visit(UnaryMinus u, Void arg) {
        return null;
    }

    /**
     * execute[[UnaryNot: exp1 -> exp2]]():
     *     // TODO: Acabar. El operador lógico (!) se debe quitar de "logic"?
     */
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
        addressCGVisitor.visit(v, arg);
        codeGenerator.load(v.getType());
        return null;
    }
}

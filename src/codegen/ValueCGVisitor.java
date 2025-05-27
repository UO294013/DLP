package codegen;

import ast.locatables.expressions.*;
import ast.types.NumberType;
import ast.types.Type;

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
     * value[[ArrayAccess: exp1 -> exp2 exp3]]():
     *     address[[exp1]]
     *     <load> exp1.type.suffix()
     */
    @Override
    public Void visit(ArrayAccess a, Void arg) {
        a.accept(addressCGVisitor, null);
        codeGenerator.load(a.getType());
        return null;
    }

    /**
     * value[[Cast: exp1 -> exp2 type]]():
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
     * value[[CharLiteral: exp -> CHAR_CONSTANT]]():
     *   <pushb> exp.value
     */
    @Override
    public Void visit(CharLiteral c, Void arg) {
        codeGenerator.pushb(c.getValue());
        return null;
    }

    /**
     * value[[Comparison: exp1 → exp2 (">"|">="|"<"|"<="|"=="|"!=") exp3]]():
     *   Type typeComp = exp1.type;
     *   if (exp2.type.suffix().equals("f") {
     *       typeComp = NumberType.getInstance(); // Ensure comparison of doubles
     *   }
     *   value[[exp2]]
     *   exp2.type.convertTo(typeComp) // cg.convert(exp2.type, exp1.type)
     *   value[[exp3]]
     *   exp3.type.convertTo(typeComp) // cg.convert(exp3.type, exp1.type)
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
        Type typeComp = c.getType();
        if (c.getLeftOperand().getType().suffix().equals("f")) {
            typeComp = NumberType.getInstance();
        }
        c.getLeftOperand().accept(this, arg);
        codeGenerator.convertTo(c.getLeftOperand().getType(), typeComp);
        c.getRightOperand().accept(this, arg);
        codeGenerator.convertTo(c.getRightOperand().getType(), typeComp);
        codeGenerator.comparison(c.getOperatorName(), typeComp);
        return null;
    }

    /**
     * value[[FieldAccess: exp1 -> exp2 ID]]():
     *   address[[exp1]]
     *   <load> exp1.type.suffix()
     */
    @Override
    public Void visit(FieldAccess f, Void arg) {
        f.accept(addressCGVisitor, null);
        codeGenerator.load(f.getType());
        return null;
    }

    /**
     * value[[FunctionCall: exp1 -> exp2 exp3*]]():
     *   for (Expression ex : exp3*) {
     *       value[[ex]]
     *   }
     *   <call> exp2
     */
    @Override
    public Void visit(FunctionCall f, Void arg) {
        for (Expression exp : f.getArguments()) {
            exp.accept(this, null);
        }
        codeGenerator.call(f.getFunctionName().getName());
        return null;
    }

    /**
     * value[[IntLiteral: exp -> INT_CONSTANT]]():
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
     * value[[NumberLiteral: exp -> REAL_CONSTANT]]():
     *   <pushf> exp.value
     */
    @Override
    public Void visit(NumberLiteral n, Void arg) {
        codeGenerator.pushf(n.getValue());
        return null;
    }

    /**
     * value[[UnaryMinus: exp1 -> exp2]]():
     *     <pushi 0> // <push> exp2.type.suffix() < 0>
     *     value[[exp2]]
     *     exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *     <subi> // <sub> exp2.type.suffix()
     */
    @Override
    public Void visit(UnaryMinus u, Void arg) {
        codeGenerator.pushi(0); // push(u.getExpression().getType(), 0);
        u.getExpression().accept(this, null);
        codeGenerator.convertTo(u.getExpression().getType(), u.getType());
        codeGenerator.subi(); // sub(u.getExpression().getType()); Only applicable to int and char
        return null;
    }

    /**
     * value[[UnaryNot: exp1 -> exp2]]():
     *     value[[exp2]]
     *     exp2.type.convertTo(exp1.type) // cg.convert(exp2.type, exp1.type)
     *     <not>
     */
    @Override
    public Void visit(UnaryNot u, Void arg) {
        u.getExpression().accept(this, null);
        codeGenerator.convertTo(u.getExpression().getType(), u.getType());
        codeGenerator.not();
        return null;
    }

    /**
     * value[[Variable: exp -> ID]]():
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

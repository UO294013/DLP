package ast.locatables.expressions;

import semantic.Visitor;

public class ArithmeticOperation extends AbstractBinaryExpression {

    public Expression result;

    public ArithmeticOperation(int row, int column, Expression lExp, Expression rExp, String operator) {
        super(operator, lExp, rExp, row, column);
    }

    public Expression getResult() {
        return result;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArithmeticOperation [leftExp=" + super.getLeftOperand()
                + ", operator=" + super.getOperatorName()
                + ", rightExp=" + super.getRightOperand()
                + ", result=" + result
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

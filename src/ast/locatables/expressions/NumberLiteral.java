package ast.locatables.expressions;

import semantic.Visitor;

public class NumberLiteral extends AbstractExpression {

    public double value;

    public NumberLiteral(double val, int row, int column) {
        super(row, column);
        this.value = val;
    }

    public double getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "NumberLiteral [value=" + value
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

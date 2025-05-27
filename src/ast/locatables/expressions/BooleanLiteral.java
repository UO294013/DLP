package ast.locatables.expressions;

import semantic.Visitor;

public class BooleanLiteral extends AbstractExpression {

    public Boolean value;

    public BooleanLiteral(Boolean val, int row, int column) {
        super(row, column);
        this.value = val;
    }

    public int getValue() {
        return value ? 1 : 0;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "BooleanLiteral [value=" + value
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

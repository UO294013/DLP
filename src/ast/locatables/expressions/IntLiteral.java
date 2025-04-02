package ast.locatables.expressions;

import visitor.Visitor;

public class IntLiteral extends AbstractExpression {

    public int value;

    public IntLiteral(int val, int row, int column) {
        super(row, column);
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntLiteral [value=" + value
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

package ast.locatables.expressions;

import semantic.Visitor;

public class ArrayAccess extends AbstractExpression {

    public Expression arrayExpression;
    public Expression indexExpression;

    public ArrayAccess(int row, int column, Expression arrayExpression, Expression index) {
        super(row, column);
        this.arrayExpression = arrayExpression;
        this.indexExpression = index;
    }

    public Expression getArrayExpression() {
        return arrayExpression;
    }

    public Expression getIndexExpression() {
        return indexExpression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayAccess [arrayExpression=" + arrayExpression
                + ", indexExpression=" + indexExpression
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

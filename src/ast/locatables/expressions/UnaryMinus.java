package ast.locatables.expressions;

import visitor.Visitor;

public class UnaryMinus extends AbstractExpression {

    public Expression expression;

    public UnaryMinus(Expression exp, int row, int column) {
        super(row, column);
        this.expression = exp;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "UnaryMinus [expression=" + expression
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

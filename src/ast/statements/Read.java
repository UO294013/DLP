package ast.statements;

import ast.locatables.expressions.Expression;
import semantic.Visitor;

public class Read extends AbstractStatement {

    public Expression expression;

    public Read(Expression expression, int row, int column) {
        super(row, column);
        this.expression = expression;
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
        return "Read [expression=" + expression
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

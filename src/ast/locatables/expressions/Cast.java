package ast.locatables.expressions;

import ast.types.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

    public Expression expression;
    public Type type;

    public Cast(Expression expression, Type type, int row, int column) {
        super(row, column);
        this.expression = expression;
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getType() {
        return type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Cast [expression=" + expression
                + ", type=" + type
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

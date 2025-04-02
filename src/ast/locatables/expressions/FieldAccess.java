package ast.locatables.expressions;

import visitor.Visitor;

public class FieldAccess extends AbstractExpression {

    public String field;
    public Expression expression;

    public FieldAccess(String fieldName, Expression expression, int row, int column) {
        super(row, column);
        this.field = fieldName;
        this.expression = expression;
    }

    public String getField() {
        return this.field;
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
        return "FieldAccess [field=" + field
                + ", expression=" + expression
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

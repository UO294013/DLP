package ast.locatables.expressions;

import visitor.Visitor;

public class CharLiteral extends AbstractExpression {

    public char value;

    public CharLiteral(char val, int row, int column) {
        super(row, column);
        this.value = val;
    }

    public char getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "CharLiteral [value=" + value
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

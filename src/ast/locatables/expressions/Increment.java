package ast.locatables.expressions;

import ast.statements.Statement;
import semantic.Visitor;

public class Increment extends AbstractExpression implements Statement {

    public Variable id;
    public String op;
    public char pos;

    public Increment(Variable id, String operator, char position, int row, int column) {
        super(row, column);
        this.id = id;
        this.op = operator;
        this.pos = position;
    }

    public Expression getId() {
        return id;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        if (pos == 'l') {
            return "Increment [Expression=" + op + id
                    + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
        } else if (pos == 'r') {
            return "Increment [Expression=" + op + id
                    + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
        }
        return "Increment [Expression=" + id
                + ", operator=" + op
                + ", position=" + pos
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

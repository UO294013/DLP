package ast.statements;

import ast.locatables.expressions.Expression;
import semantic.Visitor;

public class Assignment extends AbstractStatement {

    public Expression lExp;
    public Expression rExp;

    public Assignment(int row, int column, Expression lExp, Expression rExp) {
        super(row, column);
        this.lExp = lExp;
        this.rExp = rExp;
    }

    public Expression getLExp() {
        return lExp;
    }

    public Expression getRExp() {
        return rExp;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Assignment [lExp=" + lExp + ", rExp=" + rExp
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

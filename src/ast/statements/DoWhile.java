package ast.statements;

import ast.locatables.expressions.Expression;
import semantic.Visitor;

import java.util.List;

public class DoWhile extends AbstractStatement {

    public List<Statement> statements;
    public Expression condition;

    public DoWhile(List<Statement> statements, Expression condition, int row, int column) {
        super(row, column);
        this.statements = statements;
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "DoWhile [statements=" + statements
                + ", condition=" + condition
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

package ast.statements;

import ast.locatables.expressions.Expression;
import visitor.Visitor;

import java.util.List;

public class While extends AbstractStatement {

    public Expression condition;
    public List<Statement> statements;

    public While(Expression condition, List<Statement> statements, int row, int column) {
        super(row, column);
        this.condition = condition;
        this.statements = statements;
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
        return "While [condition=" + condition
                + ", statements=" + statements
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

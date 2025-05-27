package ast.statements;

import ast.locatables.expressions.Expression;
import semantic.Visitor;

import java.util.List;

public class For extends AbstractStatement {

    public Statement init;
    public Expression condition;
    public Statement increment;
    public List<Statement> statements;

    public For(Statement init, Expression condition, Statement increment, List<Statement> statements, int row, int column) {
        super(row, column);
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.statements = statements;
    }

    public Statement getInit() {
        return init;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getIncrement() {
        return increment;
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
        return "For [init=" + init
                + ", condition=" + condition
                + ", increment=" + increment
                + ", statements=" + statements
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

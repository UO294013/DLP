package ast.statements;

import ast.locatables.expressions.Expression;
import semantic.Visitor;

import java.util.List;

public class IfElse extends AbstractStatement {

    public Expression condition;
    public List<Statement> ifBody;
    public List<Statement> elseBody;

    public IfElse(Expression condition, List<Statement> ifBody, List<Statement> elseBody, int row, int column) {
        super(row, column);
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IfElse [condition=" + condition
                + ", ifBody=" + ifBody
                + ", elseBody=" + elseBody
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

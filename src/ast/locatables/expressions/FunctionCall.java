package ast.locatables.expressions;

import ast.statements.Statement;
import semantic.Visitor;

import java.util.List;

public class FunctionCall extends AbstractExpression implements Statement {

    public Variable functionName;
    public List<Expression> arguments;

    public FunctionCall(int row, int column, Variable functionName, List<Expression> args) {
        super(row, column);
        this.functionName = functionName;
        this.arguments = args;
    }

    public Variable getFunctionName() {
        return functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionCall [functionName=" + functionName
                + ", arguments=" + arguments
                + ", row=" + super.getLine() + ", column=" + super.getColumn() + "]";
    }
}

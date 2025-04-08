package ast.locatables.expressions;

import ast.types.Type;
import semantic.Visitor;

public class AbstractExpression implements Expression {

    public int row;
    public int column;
    public boolean lValue;
    public Type type;

    public AbstractExpression(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int getLine() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public boolean getLValue() {
        return this.lValue;
    }

    @Override
    public void setLValue(boolean value) {
        this.lValue = value;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP paramType) {
        return null;
    }
}

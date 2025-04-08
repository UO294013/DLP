package ast.locatables.definitions;

import ast.types.Type;
import semantic.Visitor;

public class AbstractDefinition implements Definition {

    public String name;
    public Type type;
    public int row;
    public int column;
    public int scope;

    public AbstractDefinition(String name, Type type, int row, int column) {
        this.name = name;
        this.type = type;
        this.row = row;
        this.column = column;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP paramType) {
        return null;
    }
}

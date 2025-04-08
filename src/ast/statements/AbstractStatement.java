package ast.statements;

import semantic.Visitor;

public class AbstractStatement implements Statement {

    public int row;
    public int column;

    public AbstractStatement(int row, int column) {
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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP paramType) {
        return null;
    }
}

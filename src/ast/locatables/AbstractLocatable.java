package ast.locatables;

public abstract class AbstractLocatable implements Locatable {

    public int row;
    public int column;

    public AbstractLocatable(int row, int column) {
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
}

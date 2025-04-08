package ast.locatables.definitions;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {

    public int offset;

    public VariableDefinition(String varName, Type type, int row, int column) {
        super(varName, type, row, column);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VariableDefinition [name=" + super.getName()
                +", type=" + super.getType()
                + ", row=" + row + ", column=" + column + "]";
    }
}

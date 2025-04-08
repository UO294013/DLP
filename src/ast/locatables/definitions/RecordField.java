package ast.locatables.definitions;

import ast.types.Type;
import semantic.Visitor;
import java.util.Objects;

public class RecordField extends AbstractDefinition {

    public int offset;

    public RecordField(String id, Type type, int row, int column) {
        super(id, type, row, column);
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
        return "RecordField [name=" + super.getName()
                + ", type=" + super.getType()
                + ", row=" + row + ", column=" + column + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RecordField other = (RecordField) obj;
        return Objects.equals(super.getName(), other.getName());
    }
}

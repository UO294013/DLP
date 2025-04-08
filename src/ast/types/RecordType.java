package ast.types;

import ast.locatables.Locatable;
import ast.locatables.definitions.RecordField;
import semantic.Visitor;

import java.util.List;

public class RecordType extends AbstractType {

    public List<RecordField> fields;

    public RecordType(List<RecordField> fields) {
        this.fields = fields;
    }

    public List<RecordField> getRecordFields() {
        return this.fields;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type dot(String name, Locatable l) {
        for (RecordField field : fields){
            if (field.getName().equals(name)){
                return field.getType();
            }
        }
        return super.dot(name, l);
    }

    @Override
    public String toString() {
        return "RecordType [fields=" + fields + '}';
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (RecordField field : fields){
            totalSize += field.getType().getSize();
        }
        return totalSize; // Size of the types of the stored elements
    }
}

package ast.types;

import ast.locatables.Locatable;
import semantic.Visitor;

public class ArrayType extends AbstractType {

    public int arraySize;
    public Type type;

    public ArrayType(int arraySize, Type type) {
        this.arraySize = arraySize;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Type squareBrackets(Type type, Locatable l) {
        if (type == IntType.getInstance() || type instanceof ErrorType){
            return this.type;
        }
        return super.squareBrackets(type, l);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Array [Size: " + arraySize + ", Type: " + type + "]";
    }

    @Override
    public int getSize() {
        return arraySize * type.getSize(); // Size of the stored elements' types * number of elements
    }
}

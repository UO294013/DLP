package ast.types;

import ast.locatables.Locatable;
import visitor.Visitor;

public class ArrayType extends AbstractType {

    public int arraySize;
    public Type type;

    public ArrayType(int arraySize, Type type) {
        this.arraySize = arraySize;
        this.type = type;
    }

    public int getArraySize() {
        return arraySize;
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
        return "ArrayType [Size: " + arraySize + ", Type: " + type + "]";
    }

    @Override
    public int getSize() {
        return arraySize * type.getSize(); // Size of the type of the stored elements times (*) number of elements
    }
}

package ast.types;

import ast.locatables.Locatable;
import visitor.Visitor;

public class IntType extends AbstractType {

    private static IntType instance;

    private IntType() {
    }

    public static IntType getInstance() {
        if (instance == null) {
            instance = new IntType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type rExpType, Locatable l) {
        if (rExpType == IntType.getInstance()) { // TODO: Is it equivalent to rExpType.equals(this)?
            return this;
        }
        if (rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.arithmetic(rExpType, l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return this;
    }

    @Override
    public Type comparison(Type rExpType, Locatable l) {
        if (rExpType == IntType.getInstance() || rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.comparison(rExpType, l);
    }

    @Override
    public Type logic(Type rExpType, Locatable l) {
        if (rExpType == IntType.getInstance() || rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.logic(rExpType, l);
    }

    @Override
    public Type logic(Locatable l) {
        return this;
    }

    @Override
    public void mustPromoteTo(Type lExpType, Locatable l) {
        if (!(lExpType == IntType.getInstance() || lExpType == NumberType.getInstance() || lExpType instanceof ErrorType)) {
            super.mustPromoteTo(lExpType, l);
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable l) { }

    @Override
    public Type canBeCast(Type type, Locatable l) {
        if (type == IntType.getInstance() || type == NumberType.getInstance() || type == CharType.getInstance()) {
            return this;
        }
        return super.canBeCast(type, l);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntType";
    }

    @Override
    public int getSize() {
        return 2; // int is 2 bytes
    }
}

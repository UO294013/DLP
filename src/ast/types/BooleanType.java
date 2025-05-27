package ast.types;

import ast.locatables.Locatable;
import semantic.Visitor;

public class BooleanType extends AbstractType {

    private static BooleanType instance;

    private BooleanType() {
    }

    public static BooleanType getInstance() {
        if (instance == null) {
            instance = new BooleanType();
        }
        return instance;
    }

    @Override
    public Type logic(Type rExpType, Locatable l) {
        if (rExpType == BooleanType.getInstance()) {
            return this;
        }
        if (rExpType instanceof ErrorType) {
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
        if (!(lExpType == BooleanType.getInstance() || lExpType instanceof ErrorType)) {
            super.mustPromoteTo(lExpType, l);
        }
    }

    @Override
    public void mustBeBuiltIn(Locatable l) { }

    @Override
    public void mustBeLogical(Locatable l) { }

    @Override
    public Type canBeCast(Type type, Locatable l) {
        if (type == BooleanType.getInstance()) {
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
        return "boolean";
    }

    @Override
    public int getSize() {
        return 2; // boolean == int (2 bytes)
    }

    @Override
    public String suffix() {
        return "i";
    }
}

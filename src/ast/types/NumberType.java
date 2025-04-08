package ast.types;

import ast.locatables.Locatable;
import semantic.Visitor;

public class NumberType extends AbstractType {

    private static NumberType instance;

    private NumberType() {
    }

    public static NumberType getInstance() {
        if (instance == null) {
            instance = new NumberType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type rExpType, Locatable l) {
        if (rExpType == NumberType.getInstance()) {
            return IntType.getInstance();
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
        if (rExpType == NumberType.getInstance()) {
            return IntType.getInstance();
        }
        if (rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.comparison(rExpType, l);
    }

    @Override
    public void mustPromoteTo(Type lExpType, Locatable l) {
        if (!(lExpType == NumberType.getInstance() || lExpType instanceof ErrorType)) {
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
        return "real";
    }

    @Override
    public int getSize() {
        return 4; // Number is 4 bytes
    }

    @Override
    public String suffix() {
        return "f";
    }
}

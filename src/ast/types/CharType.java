package ast.types;

import ast.locatables.Locatable;
import semantic.Visitor;

public class CharType extends AbstractType {

    private static CharType instance;

    private CharType() {
    }

    public static CharType getInstance() {
        if (instance == null) {
            instance = new CharType();
        }
        return instance;
    }

    @Override
    public Type arithmetic(Type rExpType, Locatable l) {
        if (rExpType == CharType.getInstance()) {
            return IntType.getInstance();
        }
        if (rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.arithmetic(rExpType, l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return IntType.getInstance();
    }

    @Override
    public Type comparison(Type rExpType, Locatable l) {
        if (rExpType == CharType.getInstance()) {
            return IntType.getInstance();
        }
        if (rExpType instanceof ErrorType) {
            return rExpType;
        }
        return super.comparison(rExpType, l);
    }

    @Override
    public void mustPromoteTo(Type lExpType, Locatable l) {
        if (!(lExpType == CharType.getInstance() || lExpType == IntType.getInstance() ||
                lExpType == NumberType.getInstance() || lExpType instanceof ErrorType)) {
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
        return "char";
    }

    @Override
    public int getSize() {
        return 1; // Char is 1 byte
    }

    @Override
    public String suffix() {
        return "b";
    }
}

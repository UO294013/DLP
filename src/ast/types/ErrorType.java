package ast.types;

import ast.locatables.Locatable;
import errorhandler.ErrorHandler;
import semantic.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    public String message;
    public Locatable locatable;

    public ErrorType(String message, Locatable locatable) {
        this.message = message;
        this.locatable = locatable;
        ErrorHandler.addError(this);
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public void mustBeLogical(Locatable l) {
    }

    @Override
    public Type arithmetic(Type rExpType, Locatable l) {
        return this;
    }

    @Override
    public Type arithmetic(Locatable l) {
        return this;
    }

    @Override
    public Type logic(Type rExpType, Locatable l) {
        return this;
    }

    @Override
    public Type logic(Locatable l) {
        return this;
    }

    @Override
    public Type comparison(Type rExpType, Locatable l) {
        return this;
    }

    @Override
    public void mustPromoteTo(Type rExpType, Locatable l) {
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
    }

    @Override
    public Type canBeCast(Type t, Locatable l) {
        return this;
    }

    @Override
    public Type squareBrackets(Type t, Locatable l) {
        return this;
    }

    @Override
    public Type dot(String field, Locatable l) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        return this;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ErrorType [" + getMessage() + " (in line: " + this.locatable.getLine() + ", column: " +
                this.locatable.getColumn() + ")]";
    }
}

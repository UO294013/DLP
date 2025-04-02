package ast.types;

import ast.locatables.Locatable;
import errorhandler.ErrorHandler;
import visitor.Visitor;

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
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ErrorType [" + getMessage() + " (in line: " + this.locatable.getLine() + ", column: " +
                this.locatable.getColumn() + ")]";
    }
}

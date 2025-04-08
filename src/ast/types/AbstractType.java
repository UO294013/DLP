package ast.types;

import ast.locatables.Locatable;
import semantic.Visitor;

import java.util.List;

public class AbstractType implements Type {

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP paramType) {
        return null;
    }

    @Override
    public void mustBeLogical(Locatable l) {
        new ErrorType("Error: Unsupported operation. Can not apply unary logical operation to type " +
                this, l);
    }

    @Override
    public Type arithmetic(Type rExpType, Locatable l) {
        return new ErrorType("Error: Unsupported operation between types. Arithmetic between " +
                this + " and " + rExpType.toString(), l);
    }

    @Override
    public Type arithmetic(Locatable l) {
        return new ErrorType("Error: Unsupported operation. Arithmetic can not be applied to " +
                this, l);
    }

    @Override
    public Type logic(Type rExpType, Locatable l) {
        return new ErrorType("Error: Unsupported operation between types. Logic between " +
                this + " and " + rExpType.toString(), l);
    }

    @Override
    public Type logic(Locatable l) {
        return new ErrorType("Error: Unsupported operation. Logic can not be applied to " +
                this, l);
    }

    @Override
    public Type comparison(Type rExpType, Locatable l) {
        return new ErrorType("Error: Unsupported operation between types. Comparison between " +
                this + " and " + rExpType.toString(), l);
    }

    @Override
    public void mustPromoteTo(Type rExpType, Locatable l) {
        new ErrorType("Error: Unsupported operation. " + this + " cannot be promoted to " + rExpType, l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        new ErrorType("Error: Unsupported operation. Not a built-in type (" + this + ")", l);
    }

    @Override
    public Type canBeCast(Type t, Locatable l) {
        return new ErrorType("Error: Unsupported operation. Can not cast " + this + " to " + t, l);
    }

    @Override
    public Type squareBrackets(Type t, Locatable l) {
        return new ErrorType("Error: Unsupported operation. Array access can not be applied to " + this, l);
    }

    @Override
    public Type dot(String field, Locatable l) {
        return new ErrorType("Error: Unsupported operation. Can not access field " + field, l);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        return new ErrorType("Error: Unsupported operation. Invalid use of parenthesis (function call) " +
                "on variable defined with type " + this, l);
    }

    @Override
    public void mustBeMain(String name, Locatable l) {
        new ErrorType("Error: Unsupported operation. Function " + name + " with type" + this +
                "is not main", l);
    }

    @Override
    public int getSize() {
        return 0;
    }
}

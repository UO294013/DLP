package ast.types;

import ast.ASTNode;
import ast.locatables.Locatable;

import java.util.List;

public interface Type extends ASTNode {
    void mustBeLogical(Locatable l);
    Type arithmetic(Type rExpType, Locatable l);
    Type arithmetic(Locatable l);
    Type logic(Type rExpType, Locatable l);
    Type logic(Locatable l);
    Type comparison(Type rExpType, Locatable l);
    void mustPromoteTo(Type rExpType, Locatable l);
    void mustBeBuiltIn(Locatable l);
    Type canBeCast(Type t, Locatable l);
    Type squareBrackets(Type t, Locatable l);
    Type dot(String field, Locatable l);
    Type parenthesis(List<Type> types, Locatable l);
    void mustBeMain(String name, Locatable l);

    int getSize();
}

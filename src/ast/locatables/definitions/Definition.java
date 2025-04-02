package ast.locatables.definitions;

import ast.locatables.Locatable;
import ast.types.Type;

public interface Definition extends Locatable {

    String getName();
    Type getType();
    int getScope();
    void setScope(int scope);
}

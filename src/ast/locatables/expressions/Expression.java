package ast.locatables.expressions;

import ast.locatables.Locatable;
import ast.types.Type;

public interface Expression extends Locatable {

    boolean getLValue();
    void setLValue(boolean value);
    Type getType();
    void setType(Type type);
}

package ast.types;

import ast.locatables.Locatable;
import ast.locatables.definitions.VariableDefinition;
import visitor.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {

    public Type returnType;
    public List<VariableDefinition> parameters;

    public FunctionType(List<VariableDefinition> params, Type returnType) {
        this.parameters = params;
        this.returnType = returnType;
    }

    public List<VariableDefinition> getParameters() {
        return parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> types, Locatable l) {
        if (parameters.size() != types.size()) {
            super.parenthesis(types, l);
        }
        for (int i = 0; i < types.size(); i++) {
            parameters.get(i).getType().mustPromoteTo(types.get(i), l);
        }
        return this.returnType;
    }

    @Override
    public String toString() {
        return "FunctionType";
    }

    // TODO: Size of the FunctionType?
}

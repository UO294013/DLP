package semantic;

import ast.locatables.definitions.Definition;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    public SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(Variable v, Void paramType) {
        Definition def = symbolTable.find(v.getName());
        if (def == null) {
            new ErrorType("Error: Variable '" + v.getName() +
                    "' can not be accessed from current scope (Maybe it is not defined)", v);
        } else {
            v.def = def;
            v.setType(def.getType());
        }
        super.visit(v, paramType);
        return null;
    }

    // DEFINITIONS

    @Override
    public Void visit(FunctionDefinition f, Void paramType) {
        if (!symbolTable.insert(f)) {
            new ErrorType("Error: Function '" + f.getName() +
                    "' could not be defined! (there is already a Definition with the same name in the same scope)", f);
        }
        symbolTable.set();
        super.visit(f, paramType);
        symbolTable.reset();
        return null;
    }

    @Override
    public Void visit(VariableDefinition v, Void paramType) {
        if (!symbolTable.insert(v)) {
            new ErrorType("Error: Variable '" + v.getName() +
                    "' could not be defined! (there is already a Definition with the same name in the same scope)", v);
        }
        super.visit(v, paramType);
        return null;
    }
}

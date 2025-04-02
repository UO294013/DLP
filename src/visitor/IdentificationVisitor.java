package visitor;

import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.FunctionCall;
import ast.locatables.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    public SymbolTable symbolTable = new SymbolTable();

    @Override
    public Void visit(FunctionCall f, Void paramType) {
        if (symbolTable.find(f.getFunctionName().getName()) == null) {
            ErrorType error = new ErrorType("Error: Function '" + f.getFunctionName().getName() +
                    "' can not be called (It is not defined or accessible from current scope)", f);
        }
        // super.visit(f, paramType); // Descomentar esta línea lanza también error por Variable
        return null;
    }

    @Override
    public Void visit(Variable v, Void paramType) {
        if (symbolTable.find(v.getName()) == null) {
            ErrorType error = new ErrorType("Error: Variable '" + v.getName() +
                    "' can not be accessed from current scope (Maybe it is not defined)", v);
        }
        super.visit(v, paramType);
        return null;
    }

    // DEFINITIONS

    @Override
    public Void visit(FunctionDefinition f, Void paramType) {
        if (!symbolTable.insert(f)) {
            ErrorType error = new ErrorType("Error: Function '" + f.getName() +
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
            ErrorType error = new ErrorType("Error: Variable '" + v.getName() +
                    "' could not be defined! (there is already a Definition with the same name in the same scope)", v);
        }
        symbolTable.set();
        super.visit(v, paramType);
        symbolTable.reset();
        return null;
    }
}

package ast.locatables.definitions;

import ast.statements.Statement;
import ast.types.Type;
import semantic.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    public List<VariableDefinition> variableDefinitions;
    public List<Statement> statements;
    public int bytesOfLocals;
    public int bytesOfParams;
    public int bytesToReturn;

    public FunctionDefinition(String functionName, Type type, List<VariableDefinition> varDefs, List<Statement> statements, int row, int column) {
        super(functionName, type, row, column);
        this.variableDefinitions = varDefs;
        this.statements = statements;
    }

    public List<VariableDefinition> getVariableDefinitions() {
        return variableDefinitions;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FunctionDefinition [functionName=" + super.getName()
                + ", type=" + super.getType()
                + ", variableDefinitions=" + variableDefinitions
                + ", statements=" + statements
                + ", row=" + row + ", column=" + column + "]";
    }
}

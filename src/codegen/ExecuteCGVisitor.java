package codegen;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.VariableDefinition;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    public AddressCGVisitor addressCGVisitor;
    public ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    @Override
    public Void visit(Program p, Void arg) {
        for (Definition def : p.getDefinitions()) {
            if (def instanceof VariableDefinition) {
                def.accept(this, arg);
            }
        }
        codeGenerator.main();
        codeGenerator.halt();
        for (Definition def : p.getDefinitions()) {
            if (def instanceof FunctionDefinition) {
                def.accept(this, arg);
            }
        }
        return null;
    }

    @Override
    public Void visit(VariableDefinition vd, Void arg) {
        return null;
    }

    @Override
    public Void visit(FunctionDefinition vd, Void arg) {
        return null;
    }
}

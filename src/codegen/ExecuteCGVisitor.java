package codegen;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.*;
import ast.statements.*;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    public AddressCGVisitor addressCGVisitor;
    public ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    // PROGRAM

    /**
     * execute[[Program: program -> definition*]]():
     *   ' * Global variables:
     *   for (Definition def : definition*) {
     * 	   if (def instanceof VariableDefinition) {
     * 	     execute[[def]]()
     * 	   }
     * 	 }
     *   <call main>
     *   <halt>
     *   for (Definition def : definition*) {
     * 	   if (def instanceof FunctionDefinition) {
     * 	     execute[[def]]()
     * 	   }
     *   }
     */
    @Override
    public Void visit(Program p, Void arg) {
        codeGenerator.comment("Global variables:");
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

    // DEFINITIONS

    /**
     *  execute[[VarDefinition: varDefinition → type ID]]():
     *    <' *> type.toString() ID <(offset> varDefinition.type.offset  <)>
     */
    @Override
    public Void visit(VariableDefinition vd, Void arg) {
        return null;
    }

    /**
     * execute[[FunctionDefinition: definition -> ID varDefinition* type varDefinition* statement*]]():
     *   ID<:>
     *   <' * Parameters:>
     *   execute[[type]]
     *   <' * Local variables:>
     *   for (VariableDefinition vd : varDefinition*) {
     *       execute[[vd]]
     *   }
     *   for (Statement stmt : statement*) {
     *     cg.line(stmt.getLine())
     *     execute[[stmt]]
     *   }
     *   if (varDefinition*.size() > 0) {
     *     <enter> -varDefinition*.get(varDefinition*.size() - 1).offset
     *   }
     */
    @Override
    public Void visit(FunctionDefinition vd, Void arg) {
        return null;
    }

    @Override
    public Void visit(RecordField rf, Void arg) {
        return null;
    }

    // STATEMENTS

    @Override
    public Void visit(Assignment a, Void arg) {
        return null;
    }

    @Override
    public Void visit(IfElse ie, Void arg) {
        return null;
    }

    /**
     * execute[[Read: statement -> expression]]():
     *   ' * Read
     *   address[[expression]]
     *   <in>expression.type.suffix()
     *   <store>expression.type.suffix()
     */
    @Override
    public Void visit(Read r, Void arg) {
        return null;
    }

    @Override
    public Void visit(Return r, Void arg) {
        return null;
    }

    @Override
    public Void visit(While w, Void arg) {
        return null;
    }

    /**
     * execute[[Write: statement -> expression]]():
     *   ' * Write
     *   value[[expression]]
     *   <out>expression.type.suffix()
     */
    @Override
    public Void visit(Write w, Void arg) {
        return null;
    }
}

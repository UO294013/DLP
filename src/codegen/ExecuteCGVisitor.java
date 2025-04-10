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
        codeGenerator.comment("\n' * " + "Global variables:");
        for (Definition def : p.getDefinitions()) {
            if (def instanceof VariableDefinition) {
                def.accept(this, arg);
            }
        }
        codeGenerator.callMain();
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
        codeGenerator.comment("\n' * " + vd.getType().toString() + " " + vd.getName()
                + " (offset " + vd.offset + ")");
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
        codeGenerator.comment(vd.getName() + ":");
        codeGenerator.comment("\n' * Parameters:");
        vd.getType().accept(this, arg);
        codeGenerator.comment("\n' * Local variables:");
        for (VariableDefinition varDef : vd.getVariableDefinitions()) {
            varDef.accept(this, arg);
        }
        for (Statement stmt : vd.getStatements()) {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, arg);
        }
        if (!vd.getVariableDefinitions().isEmpty()) {
            int enterValue = -vd.getVariableDefinitions().getLast().offset;
            codeGenerator.enter(enterValue);
        }
        return null;
    }

    /**
     * execute[[RecordField: definition -> ID type]]():
     *   <' *> type.toString() ID <(offset> varDefinition.type.offset  <)>
     */
    @Override
    public Void visit(RecordField rf, Void arg) {
        codeGenerator.comment("\n' * " + rf.getType().toString() + " " + rf.getName()
                + " (offset " + rf.offset + ")");
        return null;
    }

    // STATEMENTS

    /**
     * execute[[Assignment: statement -> exp1 exp2]]():
     *     <' * Assignment>
     *     address[[exp1]]
     *     value[[exp2]]
     *     <store>exp1.type.suffix()
     */
    @Override
    public Void visit(Assignment a, Void arg) {
        a.getLExp().accept(addressCGVisitor, arg);
        a.getRExp().accept(valueCGVisitor, arg);
        codeGenerator.store(a.getLExp().getType());
        return null;
    }

    /**
     * execute[[IfElse: statement1 -> exp statement2* statement3*]]():
     *     <' * IfElse>
     *     value[[exp]]
     *     <jz else>
     *     for (Statement st : statement2*) {
     *         execute[[st]]
     *     }
     *     <jmp exit>
     *     else:
     *         for (Statement st : statement3*) {
     *             execute[[st]]
     *         }
     *     exit:
     */
    @Override
    public Void visit(IfElse ie, Void arg) {
        codeGenerator.comment("' * IfElse");
        String elseLabel = codeGenerator.nextLabel();
        String exitLabel = codeGenerator.nextLabel();
        ie.getCondition().accept(valueCGVisitor, arg);
        codeGenerator.jz(elseLabel);
        for (Statement st : ie.getIfBody()) {
            st.accept(this, arg);
        }
        codeGenerator.jmp(exitLabel);
        codeGenerator.addLabel(elseLabel);
        for (Statement st : ie.getElseBody()) {
            st.accept(this, arg);
        }
        codeGenerator.addLabel(exitLabel);
        return null;
    }

    /**
     * execute[[Read: statement -> expression]]():
     *   <' * Read>
     *   address[[expression]]
     *   <in>expression.type.suffix()
     *   <store>expression.type.suffix()
     */
    @Override
    public Void visit(Read r, Void arg) {
        codeGenerator.comment("' * Read");
        r.getExpression().accept(addressCGVisitor, arg);
        codeGenerator.in(r.getExpression().getType());
        codeGenerator.store(r.getExpression().getType());
        return null;
    }

    /** TODO: How can we do the return statement?
     * execute[[Read: statement -> expression]]():
     *   <' * Read>
     *   address[[expression]]
     *   <in>expression.type.suffix()
     *   <store>expression.type.suffix()
     */
    @Override
    public Void visit(Return r, Void arg) {
        return null;
    }

    /**
     * execute[[While: statement1 -> exp statement2*]]():
     *     <' * While>
     *     condition:
     *     value[[exp]]
     *     <jz exit>
     *     for (Statement st : statement2*) {
     *         execute[[st]]
     *     }
     *     <jmp condition>
     *     exit:
     */
    @Override
    public Void visit(While w, Void arg) {
        codeGenerator.comment("' * While");
        String conditionLabel = codeGenerator.nextLabel();
        String exitLabel = codeGenerator.nextLabel();
        codeGenerator.addLabel(conditionLabel);
        w.getCondition().accept(valueCGVisitor, arg);
        codeGenerator.jz(exitLabel);
        for (Statement st : w.getStatements()) {
            st.accept(this, arg);
        }
        codeGenerator.jmp(conditionLabel);
        codeGenerator.addLabel(exitLabel);
        return null;
    }

    /**
     * execute[[Write: statement -> expression]]():
     *   <' * Write>
     *   value[[expression]]
     *   <out>expression.type.suffix()
     */
    @Override
    public Void visit(Write w, Void arg) {
        codeGenerator.comment("' * Write");
        w.getExpression().accept(valueCGVisitor, arg);
        codeGenerator.out(w.getExpression().getType());
        return null;
    }
}

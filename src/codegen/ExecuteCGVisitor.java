package codegen;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.*;
import ast.statements.*;
import ast.types.FunctionType;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    public AddressCGVisitor addressCGVisitor;
    public ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
        this.addressCGVisitor = new AddressCGVisitor(cg);
        this.valueCGVisitor = new ValueCGVisitor(cg);

        this.addressCGVisitor.valueCGVisitor = this.valueCGVisitor;
        this.valueCGVisitor.addressCGVisitor = this.addressCGVisitor;
    }

    // PROGRAM

    /**
     * execute[[Program: program -> definition*]]():
     *   // ' * Global variables:
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
        // codeGenerator.comment("\n' * " + "Global variables:");
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
     *    <' *> type.toString() ID <(offset> varDefinition.type.offset<)>
     */
    @Override
    public Void visit(VariableDefinition vd, Void arg) {
        codeGenerator.comment("\n\t' * " + vd.getType().toString() + " " + vd.getName()
                + " (offset " + vd.offset + ")");
        return null;
    }

    /**
     * execute[[FunctionDefinition: definition -> ID varDefinition* type varDefinition* stmt*]]():
     *   ID<:>
     *   <' * Parameters:>
     *   execute[[type]]
     *   <' * Local variables:>
     *   for (VariableDefinition vd : varDefinition*) {
     *       execute[[vd]]
     *   }
     *   for (Statement stmt : stmt*) {
     *     cg.line(stmt.getLine())
     *     execute[[stmt]]
     *   }
     *   if (varDefinition*.size() > 0) {
     *     <enter> -varDefinition*.get(varDefinition*.size() - 1).offset
     *   }
     */
    @Override
    public Void visit(FunctionDefinition vd, Void arg) {
        codeGenerator.line(vd.getLine());
        codeGenerator.comment("\n\n " + vd.getName() + ":");
        codeGenerator.comment("\n\t' * Parameters:");
        vd.getType().accept(this, arg);
        codeGenerator.comment("\n\t' * Local variables:");
        for (VariableDefinition varDef : vd.getVariableDefinitions()) {
            varDef.accept(this, arg);
        }
        if (!vd.getVariableDefinitions().isEmpty()) {
            int enterValue = -vd.getVariableDefinitions().getLast().offset;
            codeGenerator.enter(enterValue);
        }
        for (Statement stmt : vd.getStatements()) {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, arg);
        }
        codeGenerator.ret(0, 54, 0); // TODO: Remove hardcoded
        return null;
    }

    /**
     * execute[[FunctionType: type1 -> varDefinition* type2]]():
     *     for (VariableDefinition vd : varDefinition*) {
     *         execute[[vd]]
     *     }
     */
    @Override
    public Void visit(FunctionType f, Void arg) {
        for (VariableDefinition vd : f.getParameters()) {
            vd.accept(this, arg);
        }
        return null;
    }

    /**
     * execute[[RecordField: definition -> ID type]]():
     *   <' *> type.toString() ID <(offset> varDefinition.type.offset<)>
     */
    @Override
    public Void visit(RecordField rf, Void arg) {
        codeGenerator.comment("\n\t' * " + rf.getType().toString() + " " + rf.getName()
                + " (offset " + rf.offset + ")");
        return null;
    }

    // STATEMENTS

    /**
     * execute[[Assignment: stmt -> exp1 exp2]]():
     *     <' * Assignment>
     *     address[[exp1]]
     *     value[[exp2]]
     *     <store>exp1.type.suffix()
     */
    @Override
    public Void visit(Assignment a, Void arg) {
        codeGenerator.comment("\n\t' * Assignment");
        a.getLExp().accept(addressCGVisitor, arg);
        a.getRExp().accept(valueCGVisitor, arg);
        codeGenerator.store(a.getLExp().getType());
        return null;
    }

    /**
     * execute[[IfElse: stmt1 -> exp stmt2* stmt3*]]():
     *   <' * IfElse>
     *   int label1 = cg.getLabels(3)
     *   value[[exp]]
     *   <jz label>label1
     *   for (Statement st : stmt2*) {
     *       execute[[st]]
     *   }
     *   <jmp label>label1 + 2
     *   <label>label1 + 1<:>
     *   for (Statement st : stmt3*) {
     *       execute[[st]]
     *   }
     *   <label>label1 + 2<:>
     */
    @Override
    public Void visit(IfElse ifElse, Void arg) {
        codeGenerator.comment("\n\t' * IfElse");
        int label1 = codeGenerator.getLabels(2);
        ifElse.getCondition().accept(valueCGVisitor, arg);
        codeGenerator.jz(label1); // Jump to else if condition false
        codeGenerator.comment("\n\t' * If body");
        for (Statement st : ifElse.getIfBody()) {
            codeGenerator.line(st.getLine());
            st.accept(this, arg);
        }
        codeGenerator.jmp(label1 + 1);
        codeGenerator.addLabel(label1); // Else
        codeGenerator.comment("\n\t' * Else body");
        for (Statement st : ifElse.getElseBody()) {
            codeGenerator.line(st.getLine());
            st.accept(this, arg);
        }
        codeGenerator.addLabel(label1 + 1);
        return null;
    }

    /**
     * execute[[Read: stmt -> exp]]():
     *   <' * Read>
     *   address[[exp]]
     *   <in>exp.type.suffix()
     *   <store>exp.type.suffix()
     */
    @Override
    public Void visit(Read r, Void arg) {
        codeGenerator.comment("\n\t' * Read");
        r.getExpression().accept(addressCGVisitor, arg);
        codeGenerator.in(r.getExpression().getType());
        codeGenerator.store(r.getExpression().getType());
        return null;
    }

    /**
     * execute[[Return: stmt -> exp]]():
     *   <' * Return>
     *   value[[exp]]
     *   <ret> ?, ?, ?
     */
    @Override
    public Void visit(Return r, Void arg) { // TODO: This is hardcoded right now
        r.getExpression().accept(valueCGVisitor, arg);
        codeGenerator.ret(0, 0, 0); // TODO: Remove hardcoded
        return null;
    }

    /**
     * execute[[While: stmt -> exp stmt2*]]():
     *   <' * While>
     *   int label1 = cg.getLabels(2)
     *   <label>label1<:>
     *   value[[exp]]
     *   <jz label>label1 + 1
     *   for (Statement st : stmt2*) {
     *       execute[[st]]
     *   }
     *   <jmp label>label1
     *   <label>label1 + 1<:>
     */
    @Override
    public Void visit(While w, Void arg) {
        codeGenerator.comment("\n\t' * While");
        int label1 = codeGenerator.getLabels(2);
        codeGenerator.addLabel(label1);
        w.getCondition().accept(valueCGVisitor, arg);
        codeGenerator.jz(label1 + 1);
        codeGenerator.comment("\n\t' * While body");
        for (Statement stmt : w.getStatements()) {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, arg);
        }
        codeGenerator.jmp(label1);
        codeGenerator.addLabel(label1 + 1);
        return null;
    }

    /**
     * execute[[Write: stmt -> exp]]():
     *   <' * Write>
     *   value[[exp]]
     *   <out>exp.type.suffix()
     */
    @Override
    public Void visit(Write w, Void arg) {
        codeGenerator.comment("\n\t' * Write");
        w.getExpression().accept(valueCGVisitor, arg);
        codeGenerator.out(w.getExpression().getType());
        return null;
    }
}

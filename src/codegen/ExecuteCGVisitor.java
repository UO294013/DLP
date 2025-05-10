package codegen;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.*;
import ast.locatables.expressions.FunctionCall;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

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
     * execute[[FunctionDefinition: definition -> ID type varDefinition* stmt*]]():
     *   ID<:>
     *   <' * Local variables:>
     *   for (VariableDefinition vd : varDefinition*) {
     *     execute[[vd]]
     *   }
     *   int bytesOfLocals = varDefinition*.isEmpty() ? 0 : -varDefinition*.get(varDefinition*.size() - 1).offset;
     *   <enter> bytesOfLocals
     *   <' * Parameters:>
     *   int bytesOfParams = type.parameters.stream().mapToInt(param -> param.type.size()).sum();
     *   execute[[type]]
     *   int bytesToReturn = definition.type.getSize();
     *   for (Statement stmt : stmt*) {
     *     cg.line(stmt.getLine())
     *     execute[[stmt]] // (bytesOfLocals, bytesOfParams, bytesToReturn)
     *   }
     *   if (type.returnType instanceOf VoidType) {
     *     <ret> bytesToReturn <, > bytesOfLocals <, > bytesOfParams
     *   }
     */
    @Override
    public Void visit(FunctionDefinition fd, Void arg) {
        codeGenerator.line(fd.getLine());
        codeGenerator.comment("\n\n " + fd.getName() + ":");
        codeGenerator.comment("\n\t' * Local variables:");
        for (VariableDefinition varDef : fd.getVariableDefinitions()) {
            varDef.accept(this, arg);
        }
        // ret a, b, c -> Setting the 'b' (bytesOfLocals)
        int bytesOfLocals = fd.getVariableDefinitions().isEmpty() ? 0 : -fd.getVariableDefinitions().getLast().offset;
        codeGenerator.enter(bytesOfLocals);

        codeGenerator.comment("\n\t' * Parameters:");
        // ret a, b, c -> Setting the 'c' (bytesOfParams)
        int bytesOfParams = ((FunctionType) fd.getType()).getParameters().stream().mapToInt(param ->
                param.getType().getSize()).sum();
        fd.getType().accept(this, arg);

        // ret a, b, c -> Setting the 'a' (bytesToReturn)
        int bytesToReturn = fd.getType().getSize();

        for (Statement stmt : fd.getStatements()) {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, arg);
        }
        if (((FunctionType) fd.getType()).returnType instanceof VoidType) {
            codeGenerator.ret(bytesToReturn, bytesOfLocals, bytesOfParams);
        }
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
     *   <' * Assignment>
     *   address[[exp1]]
     *   value[[exp2]]
     *   <store>exp1.type.suffix()
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
     * execute[[FunctionCall: stmt -> exp1 exp2*]]():
     *   for (Expression ex : exp2*) {
     *      value[[ex]]
     *   }
     *   if (!stmt.type instanceof VoidType) {
     *      <pop>stmt.type.suffix()
     *   }
     */
    @Override
    public Void visit(FunctionCall f, Void arg) {
        f.accept(valueCGVisitor, arg);
        if (!(f.getType() instanceof VoidType)) {
            codeGenerator.pop(f.getType()); // TODO: Check if it is the type of the exp1
        }
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
     * execute[[Return: stmt -> exp]](int bytesOfLocals, int bytesOfParams, int bytesToReturn):
     *   <' * Return>
     *   value[[exp]]
     *   <ret> bytesToReturn <, > bytesOfLocals <, > bytesOfParams
     */
    @Override
    public Void visit(Return r, Void arg) {
        codeGenerator.comment("\n\t' * Return");
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

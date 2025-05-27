package codegen;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.*;
import ast.locatables.expressions.FunctionCall;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<FunctionDefinition, Void> {

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
     *   // <' * Global variables:>
     *   for (Definition def : definition*) {
     * 	   if (def instanceof VariableDefinition) {
     * 	     execute[[def]]
     * 	   }
     * 	 }
     *   <call main>
     *   <halt>
     *   for (Definition def : definition*) {
     * 	   if (def instanceof FunctionDefinition) {
     * 	     execute[[def]]
     * 	   }
     *   }
     */
    @Override
    public Void visit(Program p, FunctionDefinition arg) {
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
    public Void visit(VariableDefinition vd, FunctionDefinition arg) {
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
     *     <ret> 0 <, > bytesOfLocals <, > bytesOfParams
     *   }
     */
    @Override
    public Void visit(FunctionDefinition fd, FunctionDefinition arg) {
        FunctionType funcType = ((FunctionType) fd.getType());
        codeGenerator.line(fd.getLine());
        codeGenerator.comment("\n\n " + fd.getName() + ":");

        codeGenerator.comment("\n\t' * Parameters:");
        // ret a, b, c -> Setting the 'c' (bytesOfParams)
        funcType.bytesOfParams = funcType.getParameters().stream().mapToInt(
                param -> param.getType().getSize()).sum();
        fd.getType().accept(this, fd);

        codeGenerator.comment("\n\t' * Local variables:");
        for (VariableDefinition varDef : fd.getVariableDefinitions()) {
            varDef.accept(this, fd);
        }
        // ret a, b, c -> Setting the 'b' (bytesOfLocals)
        fd.bytesOfLocals = fd.getVariableDefinitions().isEmpty() ? 0 : -fd.getVariableDefinitions().getLast().offset;
        codeGenerator.enter(fd.bytesOfLocals);

        // ret a, b, c -> Setting the 'a' (bytesToReturn)
        fd.bytesToReturn = funcType.returnType.getSize();

        for (Statement stmt : fd.getStatements()) {
            codeGenerator.line(stmt.getLine());
            stmt.accept(this, fd);
        }
        if (funcType.returnType instanceof VoidType) {
            codeGenerator.ret(0, fd.bytesOfLocals, funcType.bytesOfParams);
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
    public Void visit(FunctionType f, FunctionDefinition arg) {
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
    public Void visit(RecordField rf, FunctionDefinition arg) {
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
    public Void visit(Assignment a, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * Assignment");
        a.getLExp().accept(addressCGVisitor, null);
        a.getRExp().accept(valueCGVisitor, null);
        codeGenerator.store(a.getLExp().getType());
        return null;
    }

    /**
     * execute[[ForStatement: stmt1 → stmt2 exp stmt3 stmt4*]]():
     *   <' * ForStatement>
     *   int label1 = cg.getLabels(2)
     *   int label2 = label1 + 1
     *   execute[[stmt2]]
     *   <label1 :>
     *   value[[exp]]
     *   <jz>label2
     *   stmt4*.forEach(st -> execute[[st]])
     *   execute[[stmt3]]
     *   <jmp>label1
     *   <label2 :>
     */
    @Override
    public Void visit(For f, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * For");
        int label1 = codeGenerator.getLabels(2);
        int label2 = label1 + 1;
        f.getInit().accept(this, arg);
        codeGenerator.addLabel(label1);
        f.getCondition().accept(valueCGVisitor, null);
        codeGenerator.jz(label2);
        for (Statement st : f.getStatements()) {
            codeGenerator.line(st.getLine());
            st.accept(this, arg);
        }
        f.getIncrement().accept(this, arg);
        codeGenerator.jmp(label1);
        codeGenerator.addLabel(label2);
        return null;
    }

    /**
     * execute[[FunctionCall: stmt -> exp1 exp2*]]():
     *   value[[stmt]]
     *   if (!(stmt.type.returnType instanceof VoidType)) {
     *      <pop>stmt.type.returnType.suffix()
     *   }
     */
    @Override
    public Void visit(FunctionCall f, FunctionDefinition arg) {
        f.accept(valueCGVisitor, null);
        if (!(f.getType() instanceof VoidType)) {
            codeGenerator.pop(f.getType());
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
    public Void visit(IfElse ifElse, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * IfElse");
        int label1 = codeGenerator.getLabels(2);
        ifElse.getCondition().accept(valueCGVisitor, null);
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
    public Void visit(Read r, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * Read");
        r.getExpression().accept(addressCGVisitor, null);
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
    public Void visit(Return r, FunctionDefinition fd) {
        codeGenerator.comment("\n\t' * Return");
        r.getExpression().accept(valueCGVisitor, null);
        codeGenerator.ret(fd.bytesToReturn, fd.bytesOfLocals, ((FunctionType) fd.getType()).bytesOfParams);
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
    public Void visit(While w, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * While");
        int label1 = codeGenerator.getLabels(2);
        codeGenerator.addLabel(label1);
        w.getCondition().accept(valueCGVisitor, null);
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
    public Void visit(Write w, FunctionDefinition arg) {
        codeGenerator.comment("\n\t' * Write");
        w.getExpression().accept(valueCGVisitor, null);
        codeGenerator.out(w.getExpression().getType());
        return null;
    }
}

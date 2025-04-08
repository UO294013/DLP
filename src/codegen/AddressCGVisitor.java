package codegen;

import ast.locatables.expressions.ArrayAccess;
import ast.locatables.expressions.FieldAccess;
import ast.locatables.expressions.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    public ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    @Override
    public Void visit(ArrayAccess a, Void arg) {
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void arg) {
        return null;
    }

    /**
     * address[[Variable: exp → ID]]():
     *   if (exp.definition.scope == 0) {
     *     <pusha> exp.definition.offset
     *   } else {
     *     <push bp>
     *     <pushi> exp.definition.offset
     *     <addi>
     *   }
     *   // cg.pushAddress(exp.definition);
     */
    @Override
    public Void visit(Variable v, Void arg) {
        return null;
    }
}

package codegen;

import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.ArrayAccess;
import ast.locatables.expressions.FieldAccess;
import ast.locatables.expressions.Variable;
import ast.types.RecordType;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    public ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        this.codeGenerator = cg;
    }

    /**
     * address[[ArrayAccess: exp1 → exp2 exp3]]():
     *     address[[expression2]]
     *     value[[expression3]]
     *     <pushi> expression1.type.numberOfBytes()
     *     <muli>
     *     <addi>
     */
    @Override
    public Void visit(ArrayAccess a, Void arg) {
        a.getArrayExpression().accept(this, arg);
        a.getIndexExpression().accept(valueCGVisitor, arg);
        codeGenerator.pushi(a.getType().getSize());
        codeGenerator.muli();
        codeGenerator.addi();
        return null;
    }

    /**
     * address[[FieldAccess: exp1 → exp2 ID]]():
     *     address[[exp2]]
     *     <pushi> exp.definition.offset
     *     <addi>
     */
    @Override
    public Void visit(FieldAccess f, Void arg) {
        f.getExpression().accept(this, arg);
        codeGenerator.pushi(((RecordType) f.getExpression().getType()).getField(f.field).offset);
        codeGenerator.addi();
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
     */
    @Override
    public Void visit(Variable v, Void arg) {
        if (v.def.getScope() == 0) { // Global variables
            codeGenerator.pusha(((VariableDefinition) v.def).offset);
        } else { // Local variables
            codeGenerator.pushBP();
            codeGenerator.pushi(((VariableDefinition) v.def).offset);
            codeGenerator.addi();
        }
        return null;
    }
}

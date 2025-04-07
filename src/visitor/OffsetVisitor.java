package visitor;

import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.RecordField;
import ast.locatables.definitions.VariableDefinition;
import ast.types.FunctionType;
import ast.types.RecordType;

/*
 * Offsets:
 * - Globals: Sum of the sizes of previous definitions' types
 * Intercept the children in the FunctionType and prevent visiting them to calculate the offset
 * - Locals: 4 (function constants) + Sum of the next definitions' types sizes
 * - Parameters: MINUS (-) Sum of the previous definitions' types sizes (including itself)
 * - RecordFields: Use as reference the address of the Record. Intercept them in the visit of RecordType
 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    public int globalBytesSum = 0;

    @Override
    public Void visit(VariableDefinition vd, Void arg) {
        super.visit(vd, null);
        // Global variables
        if (vd.getScope() == 0) {
            vd.setOffset(globalBytesSum);
            globalBytesSum += vd.getType().getSize();
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fd, Void arg) {
        super.visit(fd, null);
        int localVariablesBytesSum = 0;
        // Parameters
        for (VariableDefinition varDef : fd.getVariableDefinitions()) {
            localVariablesBytesSum += varDef.getType().getSize();
            varDef.setOffset(-localVariablesBytesSum);
        }
        return null;
    }

    @Override
    public Void visit(FunctionType ft, Void p){
        int paramsBytesSum = 0;
        // Local variables
        for (int i = ft.getParameters().size() - 1 ; i >= 0 ; i--) {
            VariableDefinition var = ft.getParameters().get(i);
            var.setOffset(4 + paramsBytesSum);
            paramsBytesSum += var.getType().getSize();
        }
        return null;
    }

    @Override
    public Void visit(RecordType rt, Void p){
        int fieldsBytesSum = 0;
        // Record fields
        for (RecordField rf : rt.getRecordFields()) {
            rf.setOffset(fieldsBytesSum);
            fieldsBytesSum += rf.getType().getSize();
        }
        return null;
    }
}

package visitor;

import ast.locatables.definitions.VariableDefinition;

/*
 * Offsets:
 * - Globals: Sum of the sizes of previous definitions' types
 * Intercept the children in the FunctionType and prevent visiting them to calculate the offset
 * - Locals: 4 (function constants) + Sum of the next definitions' types sizes
 * - Parameters: MINUS (-) Sum of the previous definitions' types sizes (including itself)
 * - RecordFields: Use as reference the address of the Record. Intercept them in the visit of RecordType
 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    public int counter = 0;

    @Override
    public Void visit(VariableDefinition vd, Void arg) {
        // Global variables
        if (vd.getScope() == 0) {

        } else { // Local or param?

        }

        return null;
    }
}

package semantic;

import ast.locatables.expressions.*;
import ast.statements.*;
import ast.types.ErrorType;

public class LValueVisitor extends AbstractVisitor<Void, Void> {

    // EXPRESSIONS

    @Override
    public Void visit(ArithmeticOperation a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(true);
        return null;
    }

    @Override
    public Void visit(BooleanLiteral a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Cast a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(ComparisonOperation a, Void paramType) {
        super.visit(a, paramType);
        a.setLValue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void paramType) {
        super.visit(f, paramType);
        f.setLValue(true);
        return null;
    }

    @Override
    public Void visit(FunctionCall f, Void paramType) {
        super.visit(f, paramType);
        f.setLValue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral i, Void paramType) {
        super.visit(i, paramType);
        i.setLValue(false);
        return null;
    }

    @Override
    public Void visit(LogicOperation l, Void paramType) {
        super.visit(l, paramType);
        l.setLValue(false);
        return null;
    }

    @Override
    public Void visit(NumberLiteral n, Void paramType) {
        super.visit(n, paramType);
        n.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Void paramType) {
        super.visit(u, paramType);
        u.setLValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Void paramType) {
        super.visit(u, paramType);
        u.setLValue(false);
        return null;
    }

    @Override
    public Void visit(Variable v, Void paramType) {
        super.visit(v, paramType);
        v.setLValue(true);
        return null;
    }

    // STATEMENTS

    @Override
    public Void visit(Assignment a, Void paramType) {
        super.visit(a, paramType);
        if (!a.getLExp().getLValue()) {
            ErrorType error = new ErrorType("Error: Expression '" + a.getLExp() + "' is not L-Value valid", a);
        }
        return null;
    }

    @Override
    public Void visit(Read r, Void paramType) {
        super.visit(r, paramType);
        if (!r.getExpression().getLValue()) {
            ErrorType error = new ErrorType("Error: Expression '" + r.getExpression() + "' is not L-Value valid", r);
        }
        return null;
    }
}

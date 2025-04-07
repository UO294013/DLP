package visitor;

import ast.Program;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    // PROGRAM

    @Override
    public Void visit(Program program, Type param) {
        super.visit(program, param);
        return null;
    }

    // EXPRESSIONS

    @Override
    public Void visit(ArithmeticOperation a, Type paramType) {
        super.visit(a, paramType);
        a.setType(a.getLeftOperand().getType().arithmetic(a.getRightOperand().getType(), a));
        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Type paramType) {
        super.visit(a, paramType);
        a.setType(a.getArrayExpression().getType().squareBrackets(a.getIndexExpression().getType(), a));
        return null;
    }

    @Override
    public Void visit(Cast a, Type paramType) {
        super.visit(a, paramType);
        a.setType(a.getExpression().getType().canBeCast(paramType, a));
        return null;
    }

    @Override
    public Void visit(CharLiteral a, Type paramType) {
        a.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Void visit(ComparisonOperation a, Type paramType) {
        super.visit(a, paramType);
        a.setType(a.getLeftOperand().getType().comparison(a.getRightOperand().getType(), a));
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Type paramType) {
        super.visit(f, paramType);
        f.setType(f.getExpression().getType().dot(f.getField(), f));
        return null;
    }

    @Override
    public Void visit(FunctionCall f, Type paramType) {
        super.visit(f, paramType);
        if (f.getFunctionName().getType() == null) {
            /* new ErrorType("Function '" + f.getFunctionName().getName() + "' does not have a valid type.", f);
            */ // Ya se lanza el error desde el IdentificationVisitor
            return null;
        }
        List<Type> types = new ArrayList<Type>();
        for(Expression e : f.getArguments()) {
            types.add(e.getType());
        }
        f.setType(f.getFunctionName().getType().parenthesis(types, f));
        return null;
    }

    @Override
    public Void visit(IntLiteral i, Type paramType) {
        i.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(LogicOperation l, Type paramType) {
        super.visit(l, paramType);
        l.setType(l.getLeftOperand().getType().logic(l.getRightOperand().getType(), l));
        return null;
    }

    @Override
    public Void visit(NumberLiteral n, Type paramType) {
        n.setType(NumberType.getInstance());
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Type paramType) {
        super.visit(u, paramType);
        u.setType(u.getExpression().getType().arithmetic(u));
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Type paramType) {
        super.visit(u, paramType);
        u.setType(u.getExpression().getType().logic(u));
        return null;
    }

    @Override
    public Void visit(Variable v, Type paramType) {
        super.visit(v, paramType);
        if (v.def != null) {
            v.setType(v.def.getType());
        } /* else { // Ya se lanza el error desde el IdentificationVisitor
            // new ErrorType("Variable: " + v.getName() + " not defined.", v);
        } */
        return null;
    }

    // STATEMENTS

    @Override
    public Void visit(Assignment a, Type paramType) {
        super.visit(a, paramType);
        a.getRExp().getType().mustPromoteTo(a.getLExp().getType(), a);
        return null;
    }

    @Override
    public Void visit(IfElse i, Type paramType) {
        super.visit(i, paramType);
        i.getCondition().getType().mustBeLogical(i);
        return null;
    }

    @Override
    public Void visit(Return r, Type paramType) {
        super.visit(r, paramType);
        if (r.getExpression().getType() != null && paramType != null) {
            r.getExpression().getType().mustPromoteTo(paramType, r);
        }
        return null;
    }

    @Override
    public Void visit(While w, Type paramType) {
        super.visit(w, paramType);
        w.getCondition().getType().mustBeLogical(w);
        return null;
    }

    @Override
    public Void visit(Write w, Type paramType) {
        super.visit(w, paramType);
        w.getExpression().getType().mustBeBuiltIn(w);
        return null;
    }

    // DEFINITIONS

    @Override
    public Void visit(FunctionDefinition fd, Type paramType) {
        Type retType = ((FunctionType) fd.getType()).getReturnType();
        super.visit(fd, retType);
        return null;
    }
}

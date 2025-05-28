package semantic;

import ast.Program;
import ast.locatables.definitions.Definition;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.RecordField;
import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.*;
import ast.statements.*;
import ast.types.*;

public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {

    // PROGRAM

    @Override
    public TR visit(Program program, TP param) {
        for (Definition definition: program.getDefinitions()) {
            definition.accept(this, param);
        }
        return null;
    }

    // EXPRESSIONS

    @Override
    public TR visit(ArithmeticOperation a, TP paramType) {
        a.getLeftOperand().accept(this, paramType);
        a.getRightOperand().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(ArrayAccess a, TP paramType) {
        a.getArrayExpression().accept(this, paramType);
        a.getIndexExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(Cast a, TP paramType) {
        a.getExpression().accept(this, paramType);
        a.getType().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(CharLiteral a, TP paramType) {
        return null;
    }

    @Override
    public TR visit(ComparisonOperation a, TP paramType) {
        a.getLeftOperand().accept(this, paramType);
        a.getRightOperand().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(FieldAccess f, TP paramType) {
        f.getExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(FunctionCall f, TP paramType) {
        f.getFunctionName().accept(this, paramType);
        for (Expression exp: f.getArguments()) {
            exp.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(IntLiteral i, TP paramType) {
        return null;
    }

    @Override
    public TR visit(LogicOperation l, TP paramType) {
        l.getLeftOperand().accept(this, paramType);
        l.getRightOperand().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(NumberLiteral n, TP paramType) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus u, TP paramType) {
        u.getExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(UnaryNot u, TP paramType) {
        u.getExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(Variable v, TP paramType) {
        return null;
    }

    // STATEMENTS

    @Override
    public TR visit(Assignment a, TP paramType) {
        a.getLExp().accept(this, paramType);
        a.getRExp().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(DoWhile dw, TP paramType) {
        for (Statement st : dw.getStatements()) {
            st.accept(this, paramType);
        }
        dw.getCondition().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(IfElse i, TP paramType) {
        i.getCondition().accept(this, paramType);
        for (Statement st : i.getIfBody()) {
            st.accept(this, paramType);
        }
        for (Statement st : i.getElseBody()) {
            st.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(Read r, TP paramType) {
        r.getExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(Return r, TP paramType) {
        r.getExpression().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(While w, TP paramType) {
        w.getCondition().accept(this, paramType);
        for (Statement st : w.getStatements()) {
            st.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(Write w, TP paramType) {
        w.getExpression().accept(this, paramType);
        return null;
    }

    // DEFINITIONS

    @Override
    public TR visit(FunctionDefinition f, TP paramType) {
        f.getType().accept(this, paramType);
        for (VariableDefinition vd : f.getVariableDefinitions()) {
            vd.accept(this, paramType);
        }
        for (Statement st :  f.getStatements()) {
            st.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(RecordField r, TP paramType) {
        r.getType().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(VariableDefinition v, TP paramType) {
        v.getType().accept(this, paramType);
        return null;
    }

    // TYPES

    @Override
    public TR visit(ArrayType a, TP paramType) {
        a.getType().accept(this, paramType);
        return null;
    }

    @Override
    public TR visit(CharType c, TP paramType) {
        return null;
    }

    @Override
    public TR visit(ErrorType e, TP paramType) {
        return null;
    }

    @Override
    public TR visit(FunctionType f, TP paramType) {
        f.getReturnType().accept(this, paramType);
        for (VariableDefinition v : f.getParameters()) {
            v.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(IntType i, TP paramType) {
        return null;
    }

    @Override
    public TR visit(NumberType n, TP paramType) {
        return null;
    }

    @Override
    public TR visit(RecordType r, TP paramType) {
        for (RecordField rf : r.getRecordFields()) {
            rf.accept(this, paramType);
        }
        return null;
    }

    @Override
    public TR visit(VoidType v, TP paramType) {
        return null;
    }
}

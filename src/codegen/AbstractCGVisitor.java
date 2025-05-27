package codegen;

import ast.Program;
import ast.locatables.definitions.FunctionDefinition;
import ast.locatables.definitions.RecordField;
import ast.locatables.definitions.VariableDefinition;
import ast.locatables.expressions.*;
import ast.statements.*;
import ast.types.*;
import semantic.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    public CodeGenerator codeGenerator;

    // PROGRAM

    @Override
    public TR visit(Program program, TP param) {
        throw new IllegalStateException("Program should not have been visited");
    }

    // EXPRESSIONS

    @Override
    public TR visit(ArithmeticOperation a, TP paramType) {
        throw new IllegalStateException("ArithmeticOperation should not have been visited");
    }

    @Override
    public TR visit(ArrayAccess a, TP paramType) {
        throw new IllegalStateException("ArrayAccess should not have been visited");
    }

    @Override
    public TR visit(Cast a, TP paramType) {
        throw new IllegalStateException("Cast should not have been visited");
    }

    @Override
    public TR visit(CharLiteral a, TP paramType) {
        throw new IllegalStateException("CharLiteral should not have been visited");
    }

    @Override
    public TR visit(ComparisonOperation a, TP paramType) {
        throw new IllegalStateException("ComparisonOperation should not have been visited");
    }

    @Override
    public TR visit(FieldAccess f, TP paramType) {
        throw new IllegalStateException("FieldAccess should not have been visited");
    }

    @Override
    public TR visit(FunctionCall f, TP paramType) {
        throw new IllegalStateException("FunctionCall should not have been visited");
    }

    @Override
    public TR visit(IntLiteral i, TP paramType) {
        throw new IllegalStateException("IntLiteral should not have been visited");
    }

    @Override
    public TR visit(LogicOperation l, TP paramType) {
        throw new IllegalStateException("LogicOperation should not have been visited");
    }

    @Override
    public TR visit(NumberLiteral n, TP paramType) {
        throw new IllegalStateException("NumberLiteral should not have been visited");
    }

    @Override
    public TR visit(UnaryMinus u, TP paramType) {
        throw new IllegalStateException("UnaryMinus should not have been visited");
    }

    @Override
    public TR visit(UnaryNot u, TP paramType) {
        throw new IllegalStateException("UnaryNot should not have been visited");
    }

    @Override
    public TR visit(Variable v, TP paramType) {
        throw new IllegalStateException("Variable should not have been visited");
    }

    // STATEMENTS

    @Override
    public TR visit(Assignment a, TP paramType) {
        throw new IllegalStateException("Assignment should not have been visited");
    }

    @Override
    public TR visit(IfElse i, TP paramType) {
        throw new IllegalStateException("IfElse should not have been visited");
    }

    @Override
    public TR visit(Read r, TP paramType) {
        throw new IllegalStateException("Read should not have been visited");
    }

    @Override
    public TR visit(Return r, TP paramType) {
        throw new IllegalStateException("Return should not have been visited");
    }

    @Override
    public TR visit(While w, TP paramType) {
        throw new IllegalStateException("While should not have been visited");
    }

    @Override
    public TR visit(Write w, TP paramType) {
        throw new IllegalStateException("Write should not have been visited");
    }

    // DEFINITIONS

    @Override
    public TR visit(FunctionDefinition f, TP paramType) {
        throw new IllegalStateException("FunctionDefinition should not have been visited");
    }

    @Override
    public TR visit(RecordField r, TP paramType) {
        throw new IllegalStateException("RecordField should not have been visited");
    }

    @Override
    public TR visit(VariableDefinition v, TP paramType) {
        throw new IllegalStateException("VariableDefinition should not have been visited");
    }

    // TYPES

    @Override
    public TR visit(ArrayType a, TP paramType) {
        throw new IllegalStateException("ArrayType should not have been visited");
    }

    @Override
    public TR visit(CharType c, TP paramType) {
        throw new IllegalStateException("CharType should not have been visited");
    }

    @Override
    public TR visit(ErrorType e, TP paramType) {
        throw new IllegalStateException("ErrorType should not have been visited");
    }

    @Override
    public TR visit(FunctionType f, TP paramType) {
        throw new IllegalStateException("FunctionType should not have been visited");
    }

    @Override
    public TR visit(IntType i, TP paramType) {
        throw new IllegalStateException("IntType should not have been visited");
    }

    @Override
    public TR visit(NumberType n, TP paramType) {
        throw new IllegalStateException("NumberType should not have been visited");
    }

    @Override
    public TR visit(RecordType r, TP paramType) {
        throw new IllegalStateException("RecordType should not have been visited");
    }

    @Override
    public TR visit(VoidType v, TP paramType) {
        throw new IllegalStateException("VoidType should not have been visited");
    }
}

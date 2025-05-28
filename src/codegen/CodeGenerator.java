package codegen;

import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    FileWriter out;
    private int labels = 1;

    public CodeGenerator(String outputFile, String inputFile) {
        try {
            out = new FileWriter(outputFile, false);
            source(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Low-level instructions:

    public void load(Type type) {
        template("\n\tload" + type.suffix());
    }

    public void store(Type type) {
        template("\n\tstore" + type.suffix());
    }

    public void enter(int enterValue) {
        template("\n\tenter\t" + enterValue);
    }

    public void jmp(int labelNum) {
        template("\n\tjmp\tlabel" + labelNum);
    }

    public void jz(int labelNum) {
        template("\n\tjz\tlabel" + labelNum);
    }

    public void jnz(int labelNum) { template("\n\tjnz\tlabel" + labelNum); }

    public void in(Type type) {
        template("\n\tin" + type.suffix());
    }

    public void out(Type type) {
        template("\n\tout" + type.suffix());
    }

    public void pusha(int offset) {
        template("\n\tpusha\t" + offset);
    }

    public void pushBP(){
        template("\n\tpush\tbp");
    }

    public void pushi(int val) {
        template("\n\tpushi\t" + val);
    }

    public void pushb(char value) {
        template("\n\tpushb\t" + (int) value);
    }

    public void pushf(double value) {
        template("\n\tpushf\t" + value);
    }

    public void push(Type type, int value) {
        template("\n\tpush" + type.suffix() + "\t" + value);
    }

    public void pop(Type type) {
        template("\n\tpop" + type.suffix());
    }

    public void addi() {
        template("\n\taddi");
    }

    public void muli() {
        template("\n\tmuli");
    }

    public void subi() {
        template("\n\tsubi");
    }

    public void ret(int bytesToReturn, int bytesOfLocals, int bytesOfParams) {
        template("\n\tret " + bytesToReturn + ", " + bytesOfLocals + ", " + bytesOfParams);
    }

    // Call to main and halt:

    public void callMain() {
        template("\n\n' Invocation to the main function\ncall main");
    }

    public void halt() {
        template("\nhalt\n");
    }

    // Directives (#) and Comments (' *):

    public void line(int lineNumber) {
        template("\n\n#line\t" + lineNumber);
    }

    public void source(String inputFileName) {
        template("\n#source\t\"" + inputFileName + "\"\n");
    }

    public void comment(String s) {
        template(s);
    }

    // Utility methods:

    /* Alternative to getLabels()
    public String nextLabel() {
        return "label" + this.labels++;
    }
    */

    public int getLabels(int size) {
        int temp = labels;
        labels += size;
        return temp;
    }

    public void addLabel(int labelNum) {
        template("\nlabel" + labelNum + ":");
    }

    public void call(String funcName) {
        template("\n\tcall\t" + funcName);
    }

    /**
     * Types of convert operations:
     *     b2i -> Transforms a char into an int
     *     i2f -> Transforms an int into a float
     *     f2i -> Transforms a float into an int
     *     i2b -> Transforms an int into a char
     */
    public void convertTo(Type operandType, Type resultType) {
        if (!resultType.suffix().equals(operandType.suffix())) {
            if (resultType.suffix().equals("b") && operandType.suffix().equals("f")) {
                template("\n\tf2i\n\ti2b");
            } else if (resultType.suffix().equals("f") && operandType.suffix().equals("b")) {
                template("\n\tb2i\n\ti2f");
            } else {
                template("\n\t" + operandType.suffix() + "2" + resultType.suffix());
            }
        }
    }

    /**
     * Valid arithmetic operations:
     *     + -> Addition
     *     - -> Subtraction
     *     * -> Multiplication
     *     / -> Division
     *     % -> Modulus
     */
    public void arithmetic(String operator, Type type) {
        switch (operator) {
            case "+":
                template("\n\tadd" + type.suffix());
                break;
            case "-":
                template("\n\tsub" + type.suffix());
                break;
            case "*":
                template("\n\tmul" + type.suffix());
                break;
            case "/":
                template("\n\tdiv" + type.suffix());
                break;
            case "%":
                template("\n\tmod" + type.suffix());
                break;
        }
    }

    /**
     * Valid comparison operations:
     *     >  -> Greater than
     *     >= -> Greater or equal than
     *     <  -> Lower than
     *     <= -> Lower or equal than
     *     == -> Equals
     *     != -> Different
     */
    public void comparison(String operator, Type type) {
        switch (operator) {
            case ">":
                template("\n\tgt" + type.suffix());
                break;
            case ">=":
                template("\n\tge" + type.suffix());
                break;
            case "<":
                template("\n\tlt" + type.suffix());
                break;
            case "<=":
                template("\n\tle" + type.suffix());
                break;
            case "==":
                template("\n\teq" + type.suffix());
                break;
            case "!=":
                template("\n\tne" + type.suffix());
                break;
        }
    }

    /**
     * Valid logic BINARY operations:
     *     && -> Logic AND
     *     || -> Logic OR
     */
    public void logic(String operator) {
        switch (operator) {
            case "&&":
                template("\n\tand");
                break;
            case "||":
                template("\n\tor");
                break;
        }
    }

    /**
     * Valid logic UNARY operations:
     *     !  -> Unary logic NOT
     */
    public void not() {
        template("\n\tnot");
    }

    // Template to avoid code repetition:
    public void template(String instructions) {
        try {
            out.write(instructions);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

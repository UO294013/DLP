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
        try {
            out.write("\n\tload" + type.suffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void store(Type type) {
        try {
            out.write("\n\tstore" + type.suffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enter(int enterValue) {
        try {
            out.write("\n\tenter\t" + enterValue);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jmp(String label) {
        try {
            out.write("\n\tjmp\t" + label);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void jz(String label) {
        try {
            out.write("\n\tjz\t" + label);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void in(Type type) {
        try {
            out.write("\n\tin" + type.suffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void out(Type type) {
        try {
            out.write("\n\tout" + type.suffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pusha(int offset) {
        try {
            out.write("\n\tpusha\t" + offset);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushBP(){
        try {
            out.write("\n\tpush\tbp");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushi(int val) {
        try {
            out.write("\n\tpushi\t" + val);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushb(char value) {
        try {
            out.write("\n\tpushb\t" + (int) value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void pushf(double value) {
        try {
            out.write("\n\tpushf\t" + value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void push(Type type, int value) {
        try {
            out.write("\n\tpush" + type.suffix() + "\t" + value);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addi() {
        try {
            out.write("\n\taddi");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void muli() {
        try {
            out.write("\n\tmuli");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sub(Type type) {
        try {
            out.write("\n\tsub" + type.suffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void ret(int bytesToReturn, int bytesOfLocalVariables, int bytesOfArgs) {
        try {
            out.write("\n\tret " + bytesToReturn + ", " + bytesOfLocalVariables + ", " + bytesOfArgs);
            out.write("\n");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Call to main and halt:

    public void callMain() {
        try {
            out.write("\n");
            out.write("\n' Invocation to the main function");
            out.write("\ncall main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void halt() {
        try {
            out.write("\nhalt");
            out.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Directives (#) and Comments (' *):

    public void line(int lineNumber) {
        try {
            out.write("\n");
            out.write("\n#line\t" + lineNumber);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void source(String inputFileName) {
        try {
            out.write("\n#source\t\"" + inputFileName + "\"");
            out.write("\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void comment(String s) {
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility methods:

    public String nextLabel() {
        return "label" + this.labels++;
    }

    public void addLabel(String label) {
        try {
            out.write("\n" + label + ":");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void call(String funcName) {
        try {
            out.write("\n\tcall\t" + funcName);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Types of convert operations:
     *     b2i -> Transforms a char into an int
     *     i2f -> Transforms an int into a float
     *     f2i -> Transforms a float into an int
     *     i2b -> Transforms an int into a char
     */
    public void convertTo(Type operandType, Type resultType) {
        try {
            if (!resultType.suffix().equals(operandType.suffix())) {
                if (resultType.suffix().equals("b") && operandType.suffix().equals("f")) {
                    out.write("\n\tf2i");
                    out.write("\n\ti2b");
                } else if (resultType.suffix().equals("f") && operandType.suffix().equals("b")) {
                    out.write("\n\tb2i");
                    out.write("\n\ti2f");
                } else {
                    out.write("\n\t" + operandType.suffix() + "2" + resultType.suffix());
                }
                out.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
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
        try {
            switch (operator) {
                case "+":
                    out.write("\n\tadd" + type.suffix());
                    break;
                case "-":
                    out.write("\n\tsub" + type.suffix());
                    break;
                case "*":
                    out.write("\n\tmul" + type.suffix());
                    break;
                case "/":
                    out.write("\n\tdiv" + type.suffix());
                    break;
                case "%":
                    out.write("\n\tmod" + type.suffix());
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
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
        try {
            switch (operator) {
                case ">":
                    out.write("\n\tgt" + type.suffix());
                    break;
                case ">=":
                    out.write("\n\tge" + type.suffix());
                    break;
                case "<":
                    out.write("\n\tlt" + type.suffix());
                    break;
                case "<=":
                    out.write("\n\tle" + type.suffix());
                    break;
                case "==":
                    out.write("\n\teq" + type.suffix());
                    break;
                case "!=":
                    out.write("\n\tne" + type.suffix());
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Valid logic BINARY operations:
     *     && -> Logic AND
     *     || -> Logic OR
     */
    public void logic(String operator) {
        try {
            switch (operator) {
                case "&&":
                    out.write("\n\tand");
                    break;
                case "||":
                    out.write("\n\tor");
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Valid logic UNARY operations:
     *     !  -> Unary logic NOT
     */
    public void not() {
        try {
            out.write("\n\tnot");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

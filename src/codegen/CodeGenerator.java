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
            out.write("\n\tload\t" + type.suffix());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void store(Type type) {
        try {
            out.write("\n\tstore\t" + type.suffix());
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
            out.write("\n\tin\t" + type.suffix());
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void out(Type type) {
        try {
            out.write("\n\tout\t" + type.suffix());
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
        try{
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

    public void addi(){
        try{
            out.write("\n\taddi");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void muli(){
        try{
            out.write("\n\tmuli");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Call to main and halt:

    public void callMain() {
        try {
            out.write("\ncall main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void halt() {
        try {
            out.write("\nhalt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Directives (#) and Comments (' *):

    public void line(int lineNumber) {
        try {
            out.write("\n#line\t" + lineNumber);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void source(String inputFileName) {
        try {
            out.write("\n#source\t\"" + inputFileName + "\"");
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
        try{
            out.write("\n" + label + ":");
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void convertTo(Type lExpType, Type rExpType) {

    }

    public void arithmetic(String operator, Type type) {

    }
}

package codegen;

import ast.types.Type;

import static java.lang.System.out;

public class CodeGenerator {

    public CodeGenerator(String outputFile, String inputFile) {

    }



    public void load(Type type) {
        out.println("\tload" + type.suffix());
        out.flush();
    }




    public void main() {
        out.println("\ncall main");
    }

    public void halt() {
        out.println("\nhalt");
    }

    // Directives (#)

    public void line(int lineNumber) {
        out.println("\n#line\t\"" + lineNumber + "\"");
        out.flush();
    }

    public void source(String inputFileName) {
        out.println("\n#source\t\"" + inputFileName + "\"");
        out.flush();
    }

    public void comment(String s) {
        out.println("\n' * " + s);
    }
}

import codegen.CodeGenerator;
import codegen.ExecuteCGVisitor;
import codegen.OffsetVisitor;
import org.antlr.v4.runtime.*;

import ast.ASTNode;
import errorhandler.ErrorHandler;
import parser.*;
import semantic.IdentificationVisitor;
import semantic.LValueVisitor;
import semantic.TypeCheckingVisitor;

public class Main {

    public static void main(String... args) throws Exception {
        if (args.length < 2) {
            System.err.println("Please, specify the input and output files.");
            return;
        }

        // Create a lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName(args[0]);
        TSmmLexer lexer = new TSmmLexer(input);

        // Create a parser that feeds off the tokens buffer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TSmmParser parser = new TSmmParser(tokens);
        ASTNode ast = parser.program().ast;

        ast.accept(new LValueVisitor(), null);
        ast.accept(new IdentificationVisitor(), null);
        ast.accept(new TypeCheckingVisitor(), null);

        // * Check errors
        if (ErrorHandler.getInstance().anyError()) {
            // * Show errors
            ErrorHandler.getInstance().showErrors(System.err);
        } else {
            // * The AST is shown
            ast.accept(new OffsetVisitor(), null);
            ast.accept(new ExecuteCGVisitor(new CodeGenerator(args[1], args[0])), null);
//            IntrospectorModel model = new IntrospectorModel("Program", ast);
//            new IntrospectorView("Introspector", model);
        }
    }
}

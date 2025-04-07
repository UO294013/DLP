import org.antlr.v4.runtime.*;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import ast.ASTNode;
import errorhandler.ErrorHandler;
import parser.TSmmLexer;
import parser.TSmmParser;
import visitor.*;

public class Main {

	public static void main(String... args) throws Exception {
		if (args.length < 1) {
			System.err.println("Please, pass me the input file.");
			return;
	    }

	    // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		TSmmLexer lexer = new TSmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		TSmmParser parser = new TSmmParser(tokens);
		ASTNode ast = parser.program().ast;

		Visitor lValueVisitor = new LValueVisitor();
		Visitor identificationVisitor = new IdentificationVisitor();
		Visitor typeCheckingVisitor = new TypeCheckingVisitor();
		ast.accept(lValueVisitor, null);
		ast.accept(identificationVisitor, null);
		ast.accept(typeCheckingVisitor, null);

		// * Check errors
		if (ErrorHandler.getInstance().anyError()){
			// * Show errors
			ErrorHandler.getInstance().showErrors(System.err);
		}
		else {
			// * The AST is shown
			Visitor offsetVisitor = new OffsetVisitor();
			ast.accept(offsetVisitor, null);
			IntrospectorModel model = new IntrospectorModel("Program", ast);
			new IntrospectorView("Introspector", model);
		}
	}
}

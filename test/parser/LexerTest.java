package parser;

import org.antlr.v4.runtime.*;

public class LexerTest {

    public static void main(String... args) throws Exception {

        // creates a lexer that feeds off of input CharStream
        CharStream input = CharStreams.fromFileName("input.txt");

        // creates a buffer of tokens pulled from the lexer
        TSmmLexer lexer = new TSmmLexer(input);

        // tests the lexer for the given input file
        Token token;
        int i = 0;
        while ((token = lexer.nextToken()).getType() != TSmmLexer.EOF) {
            // We get the semantic value of the token
            Object semanticValue = null;
            switch (token.getType()) {
                case TSmmLexer.INT_CONSTANT:
                    semanticValue = LexerHelper.lexemeToInt(token.getText());
                    break;
                case TSmmLexer.CHAR_CONSTANT:
                    semanticValue = LexerHelper.lexemeToChar(token.getText());
                    break;
                case TSmmLexer.REAL_CONSTANT:
                    semanticValue = LexerHelper.lexemeToReal(token.getText());
                    break;
                default:
                    semanticValue = token.getText();
            }
            // We test the token
            if (i >= expectedTokens.length) {
                System.err.println("Found more tokens than expected in the array 'expectedTokens'.");
                return;
            }
            expectedTokens[i].assertEquals(token.getLine(), token.getCharPositionInLine() + 1, token.getText(), token.getType(), semanticValue);
            i++;
        }
    }

    private static LexicalInfo[] expectedTokens = new LexicalInfo[]{
            new LexicalInfo(6, 5, "0", TSmmLexer.INT_CONSTANT, 0),
            new LexicalInfo(6, 7, "123", TSmmLexer.INT_CONSTANT, 123),
            new LexicalInfo(7, 5, "0", TSmmLexer.INT_CONSTANT, 0),
            new LexicalInfo(7, 6, "120", TSmmLexer.INT_CONSTANT, 120),

			new LexicalInfo(11, 5, "12.3", TSmmLexer.REAL_CONSTANT, 12.3),
			new LexicalInfo(11, 11, "2.", TSmmLexer.REAL_CONSTANT, 2.0),
			new LexicalInfo(11, 15, ".34", TSmmLexer.REAL_CONSTANT, 0.34),
			new LexicalInfo(12, 5, "34.12E-3", TSmmLexer.REAL_CONSTANT, 0.03412),
			new LexicalInfo(12, 15, "3e3", TSmmLexer.REAL_CONSTANT, 3000.0),
			new LexicalInfo(12, 20, "0.0003", TSmmLexer.REAL_CONSTANT, .0003),

			new LexicalInfo(16, 5, "var1", TSmmLexer.ID, "var1"),
			new LexicalInfo(16, 11, "_var_1", TSmmLexer.ID, "_var_1"),
			new LexicalInfo(16, 19, "VAR_1_AB_2", TSmmLexer.ID, "VAR_1_AB_2"),

			new LexicalInfo(20, 5, "'a'", TSmmLexer.CHAR_CONSTANT, 'a'),
			new LexicalInfo(20, 10, "'b'", TSmmLexer.CHAR_CONSTANT, 'b'),
			new LexicalInfo(20, 15, "'.'", TSmmLexer.CHAR_CONSTANT, '.'),
			new LexicalInfo(20, 20, "'-'", TSmmLexer.CHAR_CONSTANT, '-'),
			new LexicalInfo(20, 25, "'~'", TSmmLexer.CHAR_CONSTANT, '~'),
			new LexicalInfo(21, 5, "'\\n'", TSmmLexer.CHAR_CONSTANT, '\n'),
			new LexicalInfo(21, 11, "'\\t'", TSmmLexer.CHAR_CONSTANT, '\t'),
			new LexicalInfo(22, 5, "'\\126'", TSmmLexer.CHAR_CONSTANT, '~'),
    };
}

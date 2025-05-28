// Generated from C:/Users/Vicente/Desktop/DLP/src/parser/TSmm.g4 by ANTLR 4.13.2
package parser;

    import ast.*;
    import ast.types.*;
    import ast.statements.*;
    import ast.locatables.*;
    import ast.locatables.expressions.*;
    import ast.locatables.definitions.*;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TSmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, INT_CONSTANT=43, REAL_CONSTANT=44, 
		CHAR_CONSTANT=45, ID=46, WHITE_SPACE=47, SINGLE_LINE_COMMENT=48, MULTILINE_COMMENT=49;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_type = 2, RULE_vartype = 3, 
		RULE_returntype = 4, RULE_builtin = 5, RULE_statement = 6, RULE_nonreturnstatement = 7, 
		RULE_definition = 8, RULE_vardefinition = 9, RULE_funcdefinition = 10, 
		RULE_main = 11, RULE_arguments = 12, RULE_recordfield = 13, RULE_parameters = 14, 
		RULE_block = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "type", "vartype", "returntype", "builtin", 
			"statement", "nonreturnstatement", "definition", "vardefinition", "funcdefinition", 
			"main", "arguments", "recordfield", "parameters", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'.'", "'as'", "'-'", "'!'", "'++'", 
			"'--'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", 
			"'=='", "'&&'", "'||'", "'void'", "'int'", "'number'", "'char'", "'return'", 
			"';'", "'log'", "','", "'input'", "'='", "'if'", "'else'", "'while'", 
			"'for'", "'let'", "':'", "'function'", "'{'", "'}'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", 
			"CHAR_CONSTANT", "ID", "WHITE_SPACE", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TSmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TSmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast = new Program(new ArrayList<Definition>());
		public DefinitionContext definition;
		public MainContext main;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TSmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					((ProgramContext)_localctx).definition = definition();
					 _localctx.ast.getDefinitions().addAll(((ProgramContext)_localctx).definition.ast); 
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(40);
			((ProgramContext)_localctx).main = main();
			 _localctx.ast.getDefinitions().add(((ProgramContext)_localctx).main.ast); 
			setState(42);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext exp1;
		public ExpressionContext ex1;
		public Token ID;
		public ArgumentsContext arguments;
		public ExpressionContext expression;
		public TypeContext type;
		public Token op;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public ExpressionContext exp2;
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(TSmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(TSmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(TSmmParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(45);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(46);
				match(T__0);
				setState(47);
				((ExpressionContext)_localctx).arguments = arguments();
				setState(48);
				match(T__1);
				 ((ExpressionContext)_localctx).ast =  new FunctionCall(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1, new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1), ((ExpressionContext)_localctx).arguments.ast); 
				}
				break;
			case 2:
				{
				setState(51);
				match(T__0);
				setState(52);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(53);
				match(T__1);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				}
				break;
			case 3:
				{
				setState(56);
				match(T__0);
				setState(57);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(58);
				match(T__5);
				setState(59);
				((ExpressionContext)_localctx).type = type();
				setState(60);
				match(T__1);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).type.ast, ((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn()); 
				}
				break;
			case 4:
				{
				setState(63);
				match(T__6);
				setState(64);
				((ExpressionContext)_localctx).expression = expression(12);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn()); 
				}
				break;
			case 5:
				{
				setState(67);
				match(T__7);
				setState(68);
				((ExpressionContext)_localctx).expression = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn()); 
				}
				break;
			case 6:
				{
				setState(71);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(72);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Increment(new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), 'l', ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1); 
				}
				break;
			case 7:
				{
				setState(74);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(75);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 ((ExpressionContext)_localctx).ast =  new Increment(new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), 'r', ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1); 
				}
				break;
			case 8:
				{
				setState(77);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)), ((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 9:
				{
				setState(79);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new NumberLiteral(LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)), ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 10:
				{
				setState(81);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)), ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 11:
				{
				setState(83);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(88);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(89);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(93);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__13) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(98);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new ComparisonOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(103);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(6);
						 ((ExpressionContext)_localctx).ast =  new LogicOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(108);
						match(T__2);
						setState(109);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(110);
						match(T__3);
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(114);
						match(T__4);
						setState(115);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn()); 
						}
						break;
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> fields = new ArrayList<>();
		public ReturntypeContext returntype;
		public Token INT_CONSTANT;
		public TypeContext type;
		public RecordfieldContext recordfield;
		public ReturntypeContext returntype() {
			return getRuleContext(ReturntypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(TSmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<RecordfieldContext> recordfield() {
			return getRuleContexts(RecordfieldContext.class);
		}
		public RecordfieldContext recordfield(int i) {
			return getRuleContext(RecordfieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				((TypeContext)_localctx).returntype = returntype();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).returntype.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(T__2);
				setState(126);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(127);
				match(T__3);
				setState(128);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)), ((TypeContext)_localctx).type.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(T__2);
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					((TypeContext)_localctx).recordfield = recordfield();
					 ((TypeContext)_localctx).fields =  ((TypeContext)_localctx).recordfield.ast; 
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__36 );
				setState(139);
				match(T__3);
				 ((TypeContext)_localctx).ast =  new RecordType(_localctx.fields); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VartypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> fields = new ArrayList<>();
		public BuiltinContext builtin;
		public Token INT_CONSTANT;
		public VartypeContext vartype;
		public RecordfieldContext recordfield;
		public BuiltinContext builtin() {
			return getRuleContext(BuiltinContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(TSmmParser.INT_CONSTANT, 0); }
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<RecordfieldContext> recordfield() {
			return getRuleContexts(RecordfieldContext.class);
		}
		public RecordfieldContext recordfield(int i) {
			return getRuleContext(RecordfieldContext.class,i);
		}
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vartype);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				((VartypeContext)_localctx).builtin = builtin();
				 ((VartypeContext)_localctx).ast =  ((VartypeContext)_localctx).builtin.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(T__2);
				setState(148);
				((VartypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(149);
				match(T__3);
				setState(150);
				((VartypeContext)_localctx).vartype = vartype();
				 ((VartypeContext)_localctx).ast =  new ArrayType(LexerHelper.lexemeToInt((((VartypeContext)_localctx).INT_CONSTANT!=null?((VartypeContext)_localctx).INT_CONSTANT.getText():null)), ((VartypeContext)_localctx).vartype.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(T__2);
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					((VartypeContext)_localctx).recordfield = recordfield();
					 ((VartypeContext)_localctx).recordfield.ast.forEach( rf -> { if (_localctx.fields.contains(rf)) { new ErrorType("Error: RecordField '" + rf.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) rf); } else { _localctx.fields.add(rf); } }); 
					}
					}
					setState(159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__36 );
				setState(161);
				match(T__3);
				 ((VartypeContext)_localctx).ast =  new RecordType(_localctx.fields); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturntypeContext extends ParserRuleContext {
		public Type ast;
		public BuiltinContext builtin;
		public BuiltinContext builtin() {
			return getRuleContext(BuiltinContext.class,0);
		}
		public ReturntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returntype; }
	}

	public final ReturntypeContext returntype() throws RecognitionException {
		ReturntypeContext _localctx = new ReturntypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returntype);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				((ReturntypeContext)_localctx).builtin = builtin();
				 ((ReturntypeContext)_localctx).ast =  ((ReturntypeContext)_localctx).builtin.ast; 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(T__22);
				 ((ReturntypeContext)_localctx).ast =  VoidType.getInstance(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltinContext extends ParserRuleContext {
		public Type ast;
		public BuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin; }
	}

	public final BuiltinContext builtin() throws RecognitionException {
		BuiltinContext _localctx = new BuiltinContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_builtin);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(T__23);
				 ((BuiltinContext)_localctx).ast =  IntType.getInstance(); 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(T__24);
				 ((BuiltinContext)_localctx).ast =  NumberType.getInstance(); 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(T__25);
				 ((BuiltinContext)_localctx).ast =  CharType.getInstance(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public NonreturnstatementContext nonreturnstatement;
		public ExpressionContext expression;
		public NonreturnstatementContext nonreturnstatement() {
			return getRuleContext(NonreturnstatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__28:
			case T__30:
			case T__32:
			case T__34:
			case T__35:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((StatementContext)_localctx).nonreturnstatement = nonreturnstatement();
				 _localctx.ast.addAll(((StatementContext)_localctx).nonreturnstatement.ast); 
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(T__26);
				setState(185);
				((StatementContext)_localctx).expression = expression(0);
				setState(186);
				match(T__27);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).expression.ast.getLine(), ((StatementContext)_localctx).expression.ast.getColumn())); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonreturnstatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public List<Expression> expressions = new ArrayList<>();
		public List<Statement> elseBlock = new ArrayList<>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext expression;
		public BlockContext b1;
		public BlockContext b2;
		public BlockContext block;
		public ExpressionContext exp3;
		public StatementContext stmt;
		public BlockContext b;
		public Token ID;
		public ArgumentsContext arguments;
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NonreturnstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonreturnstatement; }
	}

	public final NonreturnstatementContext nonreturnstatement() throws RecognitionException {
		NonreturnstatementContext _localctx = new NonreturnstatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nonreturnstatement);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(T__28);
				setState(192);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp1.ast); 
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__29) {
					{
					{
					setState(194);
					match(T__29);
					setState(195);
					((NonreturnstatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp2.ast); 
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				match(T__27);
				 _localctx.expressions.forEach( exp -> _localctx.ast.add(new Write(exp, exp.getLine(), exp.getColumn()))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(T__30);
				setState(207);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp1.ast); 
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__29) {
					{
					{
					setState(209);
					match(T__29);
					setState(210);
					((NonreturnstatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp2.ast); 
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(218);
				match(T__27);
				 _localctx.expressions.forEach( exp -> _localctx.ast.add(new Read(exp, exp.getLine(), exp.getColumn()))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				setState(222);
				match(T__31);
				setState(223);
				((NonreturnstatementContext)_localctx).exp2 = expression(0);
				setState(224);
				match(T__27);
				 _localctx.ast.add(new Assignment(((NonreturnstatementContext)_localctx).exp1.ast.getLine(), ((NonreturnstatementContext)_localctx).exp1.ast.getColumn(), ((NonreturnstatementContext)_localctx).exp1.ast, ((NonreturnstatementContext)_localctx).exp2.ast)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(T__32);
				setState(228);
				match(T__0);
				setState(229);
				((NonreturnstatementContext)_localctx).expression = expression(0);
				setState(230);
				match(T__1);
				setState(231);
				((NonreturnstatementContext)_localctx).b1 = block();
				setState(236);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(232);
					match(T__33);
					setState(233);
					((NonreturnstatementContext)_localctx).b2 = block();
					 if (((NonreturnstatementContext)_localctx).b2.statements != null) ((NonreturnstatementContext)_localctx).elseBlock =  ((NonreturnstatementContext)_localctx).b2.statements; 
					}
					break;
				}
				 _localctx.ast.add(new IfElse(((NonreturnstatementContext)_localctx).expression.ast, ((NonreturnstatementContext)_localctx).b1.statements, _localctx.elseBlock, ((NonreturnstatementContext)_localctx).expression.ast.getLine(), ((NonreturnstatementContext)_localctx).expression.ast.getColumn())); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(T__34);
				setState(241);
				match(T__0);
				setState(242);
				((NonreturnstatementContext)_localctx).expression = expression(0);
				setState(243);
				match(T__1);
				setState(244);
				((NonreturnstatementContext)_localctx).block = block();
				 _localctx.ast.add(new While(((NonreturnstatementContext)_localctx).expression.ast, ((NonreturnstatementContext)_localctx).block.statements, ((NonreturnstatementContext)_localctx).expression.ast.getLine(), ((NonreturnstatementContext)_localctx).expression.ast.getColumn())); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				match(T__35);
				setState(248);
				match(T__0);
				setState(249);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				setState(250);
				match(T__31);
				setState(251);
				((NonreturnstatementContext)_localctx).exp2 = expression(0);
				setState(252);
				match(T__27);
				setState(253);
				((NonreturnstatementContext)_localctx).exp3 = expression(0);
				setState(254);
				match(T__27);
				setState(255);
				((NonreturnstatementContext)_localctx).stmt = statement();
				setState(256);
				match(T__1);
				setState(257);
				((NonreturnstatementContext)_localctx).b = block();
				 _localctx.ast.add(new For(new Assignment(((NonreturnstatementContext)_localctx).exp1.ast.getLine(), ((NonreturnstatementContext)_localctx).exp1.ast.getColumn(), ((NonreturnstatementContext)_localctx).exp1.ast, ((NonreturnstatementContext)_localctx).exp2.ast), ((NonreturnstatementContext)_localctx).exp3.ast, ((NonreturnstatementContext)_localctx).stmt.ast.get(0), ((NonreturnstatementContext)_localctx).b.statements, ((NonreturnstatementContext)_localctx).exp3.ast.getLine(), ((NonreturnstatementContext)_localctx).exp3.ast.getColumn())); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				((NonreturnstatementContext)_localctx).ID = match(ID);
				setState(261);
				match(T__0);
				setState(262);
				((NonreturnstatementContext)_localctx).arguments = arguments();
				setState(263);
				match(T__1);
				setState(264);
				match(T__27);
				 _localctx.ast.add(new FunctionCall(((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1, new Variable((((NonreturnstatementContext)_localctx).ID!=null?((NonreturnstatementContext)_localctx).ID.getText():null), ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1), ((NonreturnstatementContext)_localctx).arguments.ast)); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
				((NonreturnstatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((NonreturnstatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(268);
				((NonreturnstatementContext)_localctx).ID = match(ID);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(269);
					match(T__27);
					}
				}

				 _localctx.ast.add(new Increment(new Variable((((NonreturnstatementContext)_localctx).ID!=null?((NonreturnstatementContext)_localctx).ID.getText():null), ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1), (((NonreturnstatementContext)_localctx).op!=null?((NonreturnstatementContext)_localctx).op.getText():null), 'l', ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1)); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(273);
				((NonreturnstatementContext)_localctx).ID = match(ID);
				setState(274);
				((NonreturnstatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((NonreturnstatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(275);
					match(T__27);
					}
				}

				 _localctx.ast.add(new Increment(new Variable((((NonreturnstatementContext)_localctx).ID!=null?((NonreturnstatementContext)_localctx).ID.getText():null), ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1), (((NonreturnstatementContext)_localctx).op!=null?((NonreturnstatementContext)_localctx).op.getText():null), 'r', ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1)); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<>();
		public VardefinitionContext vardefinition;
		public FuncdefinitionContext funcdefinition;
		public VardefinitionContext vardefinition() {
			return getRuleContext(VardefinitionContext.class,0);
		}
		public FuncdefinitionContext funcdefinition() {
			return getRuleContext(FuncdefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_definition);
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				((DefinitionContext)_localctx).vardefinition = vardefinition();
				 _localctx.ast.addAll(((DefinitionContext)_localctx).vardefinition.ast); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				((DefinitionContext)_localctx).funcdefinition = funcdefinition();
				 _localctx.ast.add(((DefinitionContext)_localctx).funcdefinition.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VardefinitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public List<Variable> vars = new ArrayList<>();
		public Token id1;
		public Token id2;
		public VartypeContext vartype;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(TSmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TSmmParser.ID, i);
		}
		public VardefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardefinition; }
	}

	public final VardefinitionContext vardefinition() throws RecognitionException {
		VardefinitionContext _localctx = new VardefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vardefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__36);
			setState(290);
			((VardefinitionContext)_localctx).id1 = match(ID);
			 _localctx.vars.add(new Variable((((VardefinitionContext)_localctx).id1!=null?((VardefinitionContext)_localctx).id1.getText():null), ((VardefinitionContext)_localctx).id1.getLine(), ((VardefinitionContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(292);
				match(T__29);
				setState(293);
				((VardefinitionContext)_localctx).id2 = match(ID);
				 Variable var = new Variable((((VardefinitionContext)_localctx).id2!=null?((VardefinitionContext)_localctx).id2.getText():null), ((VardefinitionContext)_localctx).id2.getLine(), ((VardefinitionContext)_localctx).id2.getCharPositionInLine() + 1); if (_localctx.vars.contains(var)) { new ErrorType("Error: Variable '" + var.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) var); } else { _localctx.vars.add(var); }; 
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			match(T__37);
			setState(301);
			((VardefinitionContext)_localctx).vartype = vartype();
			setState(302);
			match(T__27);
			 _localctx.vars.forEach( var -> _localctx.ast.add(new VariableDefinition(var.getName(), ((VardefinitionContext)_localctx).vartype.ast, var.getLine(), var.getColumn()))); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncdefinitionContext extends ParserRuleContext {
		public Definition ast;
		public List<VariableDefinition> args = new ArrayList<>();
		public List<VariableDefinition> defs = new ArrayList<>();
		public List<Statement> stmts = new ArrayList<>();
		public Token ID;
		public ParametersContext parameters;
		public ReturntypeContext returntype;
		public VardefinitionContext vardefinition;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(TSmmParser.ID, 0); }
		public ReturntypeContext returntype() {
			return getRuleContext(ReturntypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<VardefinitionContext> vardefinition() {
			return getRuleContexts(VardefinitionContext.class);
		}
		public VardefinitionContext vardefinition(int i) {
			return getRuleContext(VardefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncdefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdefinition; }
	}

	public final FuncdefinitionContext funcdefinition() throws RecognitionException {
		FuncdefinitionContext _localctx = new FuncdefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcdefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__38);
			setState(306);
			((FuncdefinitionContext)_localctx).ID = match(ID);
			setState(307);
			match(T__0);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(308);
				((FuncdefinitionContext)_localctx).parameters = parameters();
				 ((FuncdefinitionContext)_localctx).args =  ((FuncdefinitionContext)_localctx).parameters.ast; 
				}
			}

			setState(313);
			match(T__1);
			setState(314);
			match(T__37);
			setState(315);
			((FuncdefinitionContext)_localctx).returntype = returntype();
			setState(316);
			match(T__39);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(317);
				((FuncdefinitionContext)_localctx).vardefinition = vardefinition();
				 _localctx.defs.addAll(((FuncdefinitionContext)_localctx).vardefinition.ast); 
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 132055883057026L) != 0)) {
				{
				{
				setState(325);
				((FuncdefinitionContext)_localctx).statement = statement();
				 _localctx.stmts.addAll(((FuncdefinitionContext)_localctx).statement.ast); 
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
			match(T__40);
			 ((FuncdefinitionContext)_localctx).ast =  new FunctionDefinition((((FuncdefinitionContext)_localctx).ID!=null?((FuncdefinitionContext)_localctx).ID.getText():null), new FunctionType(_localctx.args, ((FuncdefinitionContext)_localctx).returntype.ast), _localctx.defs, _localctx.stmts, ((FuncdefinitionContext)_localctx).ID.getLine(), ((FuncdefinitionContext)_localctx).ID.getCharPositionInLine() + 1); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public Definition ast;
		public List<VariableDefinition> args = new ArrayList<>();
		public List<VariableDefinition> defs = new ArrayList<>();
		public List<Statement> stmts = new ArrayList<>();
		public VardefinitionContext vardefinition;
		public NonreturnstatementContext nonreturnstatement;
		public List<VardefinitionContext> vardefinition() {
			return getRuleContexts(VardefinitionContext.class);
		}
		public VardefinitionContext vardefinition(int i) {
			return getRuleContext(VardefinitionContext.class,i);
		}
		public List<NonreturnstatementContext> nonreturnstatement() {
			return getRuleContexts(NonreturnstatementContext.class);
		}
		public NonreturnstatementContext nonreturnstatement(int i) {
			return getRuleContext(NonreturnstatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(T__38);
			setState(337);
			match(T__41);
			setState(338);
			match(T__0);
			setState(339);
			match(T__1);
			setState(340);
			match(T__37);
			setState(341);
			match(T__22);
			setState(342);
			match(T__39);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(343);
				((MainContext)_localctx).vardefinition = vardefinition();
				 _localctx.defs.addAll(((MainContext)_localctx).vardefinition.ast); 
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 132055748839298L) != 0)) {
				{
				{
				setState(351);
				((MainContext)_localctx).nonreturnstatement = nonreturnstatement();
				 _localctx.stmts.addAll(((MainContext)_localctx).nonreturnstatement.ast); 
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(359);
			match(T__40);
			 ((MainContext)_localctx).ast =  new FunctionDefinition("main", new FunctionType(new ArrayList(), VoidType.getInstance()), _localctx.defs, _localctx.stmts, _localctx.start.getLine(), _localctx.start.getCharPositionInLine() + 1); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public ExpressionContext exp3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(362);
				((ArgumentsContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).exp1.ast); 
				}
				break;
			case 2:
				{
				setState(365);
				((ArgumentsContext)_localctx).exp2 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).exp2.ast); 
				setState(371); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(367);
					match(T__29);
					setState(368);
					((ArgumentsContext)_localctx).exp3 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).exp3.ast); 
					}
					}
					setState(373); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__29 );
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordfieldContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<>();
		public List<Variable> vars = new ArrayList<>();
		public Token id1;
		public Token id2;
		public VartypeContext vartype;
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(TSmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TSmmParser.ID, i);
		}
		public RecordfieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordfield; }
	}

	public final RecordfieldContext recordfield() throws RecognitionException {
		RecordfieldContext _localctx = new RecordfieldContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_recordfield);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(T__36);
			setState(378);
			((RecordfieldContext)_localctx).id1 = match(ID);
			 _localctx.vars.add(new Variable((((RecordfieldContext)_localctx).id1!=null?((RecordfieldContext)_localctx).id1.getText():null), ((RecordfieldContext)_localctx).id1.getLine(), ((RecordfieldContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(380);
				match(T__29);
				setState(381);
				((RecordfieldContext)_localctx).id2 = match(ID);
				 _localctx.vars.add(new Variable((((RecordfieldContext)_localctx).id2!=null?((RecordfieldContext)_localctx).id2.getText():null), ((RecordfieldContext)_localctx).id2.getLine(), ((RecordfieldContext)_localctx).id2.getCharPositionInLine() + 1)); 
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			match(T__37);
			setState(389);
			((RecordfieldContext)_localctx).vartype = vartype();
			setState(390);
			match(T__27);
			 _localctx.vars.forEach( var -> _localctx.ast.add(new RecordField(var.getName(), ((RecordfieldContext)_localctx).vartype.ast, var.getLine(), var.getColumn()))); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public Token id1;
		public BuiltinContext b1;
		public Token id2;
		public BuiltinContext b2;
		public List<TerminalNode> ID() { return getTokens(TSmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TSmmParser.ID, i);
		}
		public List<BuiltinContext> builtin() {
			return getRuleContexts(BuiltinContext.class);
		}
		public BuiltinContext builtin(int i) {
			return getRuleContext(BuiltinContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			((ParametersContext)_localctx).id1 = match(ID);
			setState(394);
			match(T__37);
			setState(395);
			((ParametersContext)_localctx).b1 = builtin();
			 _localctx.ast.add(new VariableDefinition((((ParametersContext)_localctx).id1!=null?((ParametersContext)_localctx).id1.getText():null), ((ParametersContext)_localctx).b1.ast, ((ParametersContext)_localctx).id1.getLine(), ((ParametersContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(397);
				match(T__29);
				setState(398);
				((ParametersContext)_localctx).id2 = match(ID);
				setState(399);
				match(T__37);
				setState(400);
				((ParametersContext)_localctx).b2 = builtin();
				 _localctx.ast.add(new VariableDefinition((((ParametersContext)_localctx).id2!=null?((ParametersContext)_localctx).id2.getText():null), ((ParametersContext)_localctx).b2.ast, ((ParametersContext)_localctx).id2.getLine(), ((ParametersContext)_localctx).id2.getCharPositionInLine() + 1)); 
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> statements = new ArrayList<>();
		public StatementContext st1;
		public StatementContext st2;
		public StatementContext st3;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(408);
				match(T__39);
				setState(409);
				((BlockContext)_localctx).st1 = statement();
				 _localctx.statements.addAll(((BlockContext)_localctx).st1.ast); 
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 132055883057026L) != 0)) {
					{
					{
					setState(411);
					((BlockContext)_localctx).st2 = statement();
					 _localctx.statements.addAll(((BlockContext)_localctx).st2.ast); 
					}
					}
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(419);
				match(T__40);
				}
				break;
			case 2:
				{
				setState(421);
				((BlockContext)_localctx).st3 = statement();
				 _localctx.statements.addAll(((BlockContext)_localctx).st3.ast); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00011\u01ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001v\b\u0001\n\u0001\f\u0001y\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"\u0088\b\u0002\u000b\u0002\f\u0002\u0089\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u008f\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u009e\b\u0003\u000b"+
		"\u0003\f\u0003\u009f\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a5"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00ac\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00b4\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00be\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00c7\b\u0007\n\u0007\f\u0007"+
		"\u00ca\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u00d6\b\u0007\n\u0007\f\u0007\u00d9\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ed\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u010f\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0115\b\u0007\u0001\u0007\u0003\u0007\u0118"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0120"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0128\b\t"+
		"\n\t\f\t\u012b\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0138\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0141\b\n\n\n\f\n\u0144\t\n"+
		"\u0001\n\u0001\n\u0001\n\u0005\n\u0149\b\n\n\n\f\n\u014c\t\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u015b\b\u000b\n\u000b\f\u000b\u015e\t\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u0163\b\u000b\n\u000b\f\u000b\u0166\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0004\f\u0174\b\f\u000b\f\f\f\u0175\u0003\f"+
		"\u0178\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0180"+
		"\b\r\n\r\f\r\u0183\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0194\b\u000e\n\u000e"+
		"\f\u000e\u0197\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u019f\b\u000f\n\u000f\f\u000f\u01a2"+
		"\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u01a9\b\u000f\u0001\u000f\u0000\u0001\u0002\u0010\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000"+
		"\u0005\u0001\u0000\t\n\u0001\u0000\u000b\r\u0002\u0000\u0007\u0007\u000e"+
		"\u000e\u0001\u0000\u000f\u0014\u0001\u0000\u0015\u0016\u01d1\u0000%\u0001"+
		"\u0000\u0000\u0000\u0002U\u0001\u0000\u0000\u0000\u0004\u008e\u0001\u0000"+
		"\u0000\u0000\u0006\u00a4\u0001\u0000\u0000\u0000\b\u00ab\u0001\u0000\u0000"+
		"\u0000\n\u00b3\u0001\u0000\u0000\u0000\f\u00bd\u0001\u0000\u0000\u0000"+
		"\u000e\u0117\u0001\u0000\u0000\u0000\u0010\u011f\u0001\u0000\u0000\u0000"+
		"\u0012\u0121\u0001\u0000\u0000\u0000\u0014\u0131\u0001\u0000\u0000\u0000"+
		"\u0016\u0150\u0001\u0000\u0000\u0000\u0018\u0177\u0001\u0000\u0000\u0000"+
		"\u001a\u0179\u0001\u0000\u0000\u0000\u001c\u0189\u0001\u0000\u0000\u0000"+
		"\u001e\u01a8\u0001\u0000\u0000\u0000 !\u0003\u0010\b\u0000!\"\u0006\u0000"+
		"\uffff\uffff\u0000\"$\u0001\u0000\u0000\u0000# \u0001\u0000\u0000\u0000"+
		"$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0003\u0016"+
		"\u000b\u0000)*\u0006\u0000\uffff\uffff\u0000*+\u0005\u0000\u0000\u0001"+
		"+\u0001\u0001\u0000\u0000\u0000,-\u0006\u0001\uffff\uffff\u0000-.\u0005"+
		".\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0003\u0018\f\u000001\u0005"+
		"\u0002\u0000\u000012\u0006\u0001\uffff\uffff\u00002V\u0001\u0000\u0000"+
		"\u000034\u0005\u0001\u0000\u000045\u0003\u0002\u0001\u000056\u0005\u0002"+
		"\u0000\u000067\u0006\u0001\uffff\uffff\u00007V\u0001\u0000\u0000\u0000"+
		"89\u0005\u0001\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0005\u0006\u0000"+
		"\u0000;<\u0003\u0004\u0002\u0000<=\u0005\u0002\u0000\u0000=>\u0006\u0001"+
		"\uffff\uffff\u0000>V\u0001\u0000\u0000\u0000?@\u0005\u0007\u0000\u0000"+
		"@A\u0003\u0002\u0001\fAB\u0006\u0001\uffff\uffff\u0000BV\u0001\u0000\u0000"+
		"\u0000CD\u0005\b\u0000\u0000DE\u0003\u0002\u0001\u000bEF\u0006\u0001\uffff"+
		"\uffff\u0000FV\u0001\u0000\u0000\u0000GH\u0007\u0000\u0000\u0000HI\u0005"+
		".\u0000\u0000IV\u0006\u0001\uffff\uffff\u0000JK\u0005.\u0000\u0000KL\u0007"+
		"\u0000\u0000\u0000LV\u0006\u0001\uffff\uffff\u0000MN\u0005+\u0000\u0000"+
		"NV\u0006\u0001\uffff\uffff\u0000OP\u0005,\u0000\u0000PV\u0006\u0001\uffff"+
		"\uffff\u0000QR\u0005-\u0000\u0000RV\u0006\u0001\uffff\uffff\u0000ST\u0005"+
		".\u0000\u0000TV\u0006\u0001\uffff\uffff\u0000U,\u0001\u0000\u0000\u0000"+
		"U3\u0001\u0000\u0000\u0000U8\u0001\u0000\u0000\u0000U?\u0001\u0000\u0000"+
		"\u0000UC\u0001\u0000\u0000\u0000UG\u0001\u0000\u0000\u0000UJ\u0001\u0000"+
		"\u0000\u0000UM\u0001\u0000\u0000\u0000UO\u0001\u0000\u0000\u0000UQ\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000Vw\u0001\u0000\u0000\u0000"+
		"WX\n\b\u0000\u0000XY\u0007\u0001\u0000\u0000YZ\u0003\u0002\u0001\tZ[\u0006"+
		"\u0001\uffff\uffff\u0000[v\u0001\u0000\u0000\u0000\\]\n\u0007\u0000\u0000"+
		"]^\u0007\u0002\u0000\u0000^_\u0003\u0002\u0001\b_`\u0006\u0001\uffff\uffff"+
		"\u0000`v\u0001\u0000\u0000\u0000ab\n\u0006\u0000\u0000bc\u0007\u0003\u0000"+
		"\u0000cd\u0003\u0002\u0001\u0007de\u0006\u0001\uffff\uffff\u0000ev\u0001"+
		"\u0000\u0000\u0000fg\n\u0005\u0000\u0000gh\u0007\u0004\u0000\u0000hi\u0003"+
		"\u0002\u0001\u0006ij\u0006\u0001\uffff\uffff\u0000jv\u0001\u0000\u0000"+
		"\u0000kl\n\u000f\u0000\u0000lm\u0005\u0003\u0000\u0000mn\u0003\u0002\u0001"+
		"\u0000no\u0005\u0004\u0000\u0000op\u0006\u0001\uffff\uffff\u0000pv\u0001"+
		"\u0000\u0000\u0000qr\n\u000e\u0000\u0000rs\u0005\u0005\u0000\u0000st\u0005"+
		".\u0000\u0000tv\u0006\u0001\uffff\uffff\u0000uW\u0001\u0000\u0000\u0000"+
		"u\\\u0001\u0000\u0000\u0000ua\u0001\u0000\u0000\u0000uf\u0001\u0000\u0000"+
		"\u0000uk\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000vy\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0003"+
		"\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0003\b\u0004\u0000"+
		"{|\u0006\u0002\uffff\uffff\u0000|\u008f\u0001\u0000\u0000\u0000}~\u0005"+
		"\u0003\u0000\u0000~\u007f\u0005+\u0000\u0000\u007f\u0080\u0005\u0004\u0000"+
		"\u0000\u0080\u0081\u0003\u0004\u0002\u0000\u0081\u0082\u0006\u0002\uffff"+
		"\uffff\u0000\u0082\u008f\u0001\u0000\u0000\u0000\u0083\u0087\u0005\u0003"+
		"\u0000\u0000\u0084\u0085\u0003\u001a\r\u0000\u0085\u0086\u0006\u0002\uffff"+
		"\uffff\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0084\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0005\u0004\u0000\u0000\u008c\u008d\u0006\u0002"+
		"\uffff\uffff\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008ez\u0001\u0000"+
		"\u0000\u0000\u008e}\u0001\u0000\u0000\u0000\u008e\u0083\u0001\u0000\u0000"+
		"\u0000\u008f\u0005\u0001\u0000\u0000\u0000\u0090\u0091\u0003\n\u0005\u0000"+
		"\u0091\u0092\u0006\u0003\uffff\uffff\u0000\u0092\u00a5\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u0003\u0000\u0000\u0094\u0095\u0005+\u0000\u0000"+
		"\u0095\u0096\u0005\u0004\u0000\u0000\u0096\u0097\u0003\u0006\u0003\u0000"+
		"\u0097\u0098\u0006\u0003\uffff\uffff\u0000\u0098\u00a5\u0001\u0000\u0000"+
		"\u0000\u0099\u009d\u0005\u0003\u0000\u0000\u009a\u009b\u0003\u001a\r\u0000"+
		"\u009b\u009c\u0006\u0003\uffff\uffff\u0000\u009c\u009e\u0001\u0000\u0000"+
		"\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0004\u0000"+
		"\u0000\u00a2\u00a3\u0006\u0003\uffff\uffff\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u0090\u0001\u0000\u0000\u0000\u00a4\u0093\u0001\u0000"+
		"\u0000\u0000\u00a4\u0099\u0001\u0000\u0000\u0000\u00a5\u0007\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0003\n\u0005\u0000\u00a7\u00a8\u0006\u0004\uffff"+
		"\uffff\u0000\u00a8\u00ac\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0017"+
		"\u0000\u0000\u00aa\u00ac\u0006\u0004\uffff\uffff\u0000\u00ab\u00a6\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\t\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\u0018\u0000\u0000\u00ae\u00b4\u0006\u0005"+
		"\uffff\uffff\u0000\u00af\u00b0\u0005\u0019\u0000\u0000\u00b0\u00b4\u0006"+
		"\u0005\uffff\uffff\u0000\u00b1\u00b2\u0005\u001a\u0000\u0000\u00b2\u00b4"+
		"\u0006\u0005\uffff\uffff\u0000\u00b3\u00ad\u0001\u0000\u0000\u0000\u00b3"+
		"\u00af\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4"+
		"\u000b\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003\u000e\u0007\u0000\u00b6"+
		"\u00b7\u0006\u0006\uffff\uffff\u0000\u00b7\u00be\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0005\u001b\u0000\u0000\u00b9\u00ba\u0003\u0002\u0001\u0000"+
		"\u00ba\u00bb\u0005\u001c\u0000\u0000\u00bb\u00bc\u0006\u0006\uffff\uffff"+
		"\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b5\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00be\r\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0005\u001d\u0000\u0000\u00c0\u00c1\u0003\u0002\u0001\u0000"+
		"\u00c1\u00c8\u0006\u0007\uffff\uffff\u0000\u00c2\u00c3\u0005\u001e\u0000"+
		"\u0000\u00c3\u00c4\u0003\u0002\u0001\u0000\u00c4\u00c5\u0006\u0007\uffff"+
		"\uffff\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u001c"+
		"\u0000\u0000\u00cc\u00cd\u0006\u0007\uffff\uffff\u0000\u00cd\u0118\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005\u001f\u0000\u0000\u00cf\u00d0\u0003"+
		"\u0002\u0001\u0000\u00d0\u00d7\u0006\u0007\uffff\uffff\u0000\u00d1\u00d2"+
		"\u0005\u001e\u0000\u0000\u00d2\u00d3\u0003\u0002\u0001\u0000\u00d3\u00d4"+
		"\u0006\u0007\uffff\uffff\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0005\u001c\u0000\u0000\u00db\u00dc\u0006\u0007\uffff\uffff\u0000"+
		"\u00dc\u0118\u0001\u0000\u0000\u0000\u00dd\u00de\u0003\u0002\u0001\u0000"+
		"\u00de\u00df\u0005 \u0000\u0000\u00df\u00e0\u0003\u0002\u0001\u0000\u00e0"+
		"\u00e1\u0005\u001c\u0000\u0000\u00e1\u00e2\u0006\u0007\uffff\uffff\u0000"+
		"\u00e2\u0118\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005!\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0001\u0000\u0000\u00e5\u00e6\u0003\u0002\u0001\u0000\u00e6"+
		"\u00e7\u0005\u0002\u0000\u0000\u00e7\u00ec\u0003\u001e\u000f\u0000\u00e8"+
		"\u00e9\u0005\"\u0000\u0000\u00e9\u00ea\u0003\u001e\u000f\u0000\u00ea\u00eb"+
		"\u0006\u0007\uffff\uffff\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0006\u0007\uffff\uffff\u0000"+
		"\u00ef\u0118\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005#\u0000\u0000\u00f1"+
		"\u00f2\u0005\u0001\u0000\u0000\u00f2\u00f3\u0003\u0002\u0001\u0000\u00f3"+
		"\u00f4\u0005\u0002\u0000\u0000\u00f4\u00f5\u0003\u001e\u000f\u0000\u00f5"+
		"\u00f6\u0006\u0007\uffff\uffff\u0000\u00f6\u0118\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005$\u0000\u0000\u00f8\u00f9\u0005\u0001\u0000\u0000\u00f9"+
		"\u00fa\u0003\u0002\u0001\u0000\u00fa\u00fb\u0005 \u0000\u0000\u00fb\u00fc"+
		"\u0003\u0002\u0001\u0000\u00fc\u00fd\u0005\u001c\u0000\u0000\u00fd\u00fe"+
		"\u0003\u0002\u0001\u0000\u00fe\u00ff\u0005\u001c\u0000\u0000\u00ff\u0100"+
		"\u0003\f\u0006\u0000\u0100\u0101\u0005\u0002\u0000\u0000\u0101\u0102\u0003"+
		"\u001e\u000f\u0000\u0102\u0103\u0006\u0007\uffff\uffff\u0000\u0103\u0118"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0005.\u0000\u0000\u0105\u0106\u0005"+
		"\u0001\u0000\u0000\u0106\u0107\u0003\u0018\f\u0000\u0107\u0108\u0005\u0002"+
		"\u0000\u0000\u0108\u0109\u0005\u001c\u0000\u0000\u0109\u010a\u0006\u0007"+
		"\uffff\uffff\u0000\u010a\u0118\u0001\u0000\u0000\u0000\u010b\u010c\u0007"+
		"\u0000\u0000\u0000\u010c\u010e\u0005.\u0000\u0000\u010d\u010f\u0005\u001c"+
		"\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0118\u0006\u0007"+
		"\uffff\uffff\u0000\u0111\u0112\u0005.\u0000\u0000\u0112\u0114\u0007\u0000"+
		"\u0000\u0000\u0113\u0115\u0005\u001c\u0000\u0000\u0114\u0113\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u0006\u0007\uffff\uffff\u0000\u0117\u00bf\u0001"+
		"\u0000\u0000\u0000\u0117\u00ce\u0001\u0000\u0000\u0000\u0117\u00dd\u0001"+
		"\u0000\u0000\u0000\u0117\u00e3\u0001\u0000\u0000\u0000\u0117\u00f0\u0001"+
		"\u0000\u0000\u0000\u0117\u00f7\u0001\u0000\u0000\u0000\u0117\u0104\u0001"+
		"\u0000\u0000\u0000\u0117\u010b\u0001\u0000\u0000\u0000\u0117\u0111\u0001"+
		"\u0000\u0000\u0000\u0118\u000f\u0001\u0000\u0000\u0000\u0119\u011a\u0003"+
		"\u0012\t\u0000\u011a\u011b\u0006\b\uffff\uffff\u0000\u011b\u0120\u0001"+
		"\u0000\u0000\u0000\u011c\u011d\u0003\u0014\n\u0000\u011d\u011e\u0006\b"+
		"\uffff\uffff\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u0119\u0001"+
		"\u0000\u0000\u0000\u011f\u011c\u0001\u0000\u0000\u0000\u0120\u0011\u0001"+
		"\u0000\u0000\u0000\u0121\u0122\u0005%\u0000\u0000\u0122\u0123\u0005.\u0000"+
		"\u0000\u0123\u0129\u0006\t\uffff\uffff\u0000\u0124\u0125\u0005\u001e\u0000"+
		"\u0000\u0125\u0126\u0005.\u0000\u0000\u0126\u0128\u0006\t\uffff\uffff"+
		"\u0000\u0127\u0124\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000\u0000"+
		"\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000"+
		"\u0000\u012a\u012c\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\u0005&\u0000\u0000\u012d\u012e\u0003\u0006\u0003\u0000"+
		"\u012e\u012f\u0005\u001c\u0000\u0000\u012f\u0130\u0006\t\uffff\uffff\u0000"+
		"\u0130\u0013\u0001\u0000\u0000\u0000\u0131\u0132\u0005\'\u0000\u0000\u0132"+
		"\u0133\u0005.\u0000\u0000\u0133\u0137\u0005\u0001\u0000\u0000\u0134\u0135"+
		"\u0003\u001c\u000e\u0000\u0135\u0136\u0006\n\uffff\uffff\u0000\u0136\u0138"+
		"\u0001\u0000\u0000\u0000\u0137\u0134\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0005\u0002\u0000\u0000\u013a\u013b\u0005&\u0000\u0000\u013b\u013c\u0003"+
		"\b\u0004\u0000\u013c\u0142\u0005(\u0000\u0000\u013d\u013e\u0003\u0012"+
		"\t\u0000\u013e\u013f\u0006\n\uffff\uffff\u0000\u013f\u0141\u0001\u0000"+
		"\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000"+
		"\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000"+
		"\u0000\u0000\u0143\u014a\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0003\f\u0006\u0000\u0146\u0147\u0006\n\uffff"+
		"\uffff\u0000\u0147\u0149\u0001\u0000\u0000\u0000\u0148\u0145\u0001\u0000"+
		"\u0000\u0000\u0149\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000"+
		"\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014d\u0001\u0000"+
		"\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u014e\u0005)\u0000"+
		"\u0000\u014e\u014f\u0006\n\uffff\uffff\u0000\u014f\u0015\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0005\'\u0000\u0000\u0151\u0152\u0005*\u0000\u0000"+
		"\u0152\u0153\u0005\u0001\u0000\u0000\u0153\u0154\u0005\u0002\u0000\u0000"+
		"\u0154\u0155\u0005&\u0000\u0000\u0155\u0156\u0005\u0017\u0000\u0000\u0156"+
		"\u015c\u0005(\u0000\u0000\u0157\u0158\u0003\u0012\t\u0000\u0158\u0159"+
		"\u0006\u000b\uffff\uffff\u0000\u0159\u015b\u0001\u0000\u0000\u0000\u015a"+
		"\u0157\u0001\u0000\u0000\u0000\u015b\u015e\u0001\u0000\u0000\u0000\u015c"+
		"\u015a\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"+
		"\u0164\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0003\u000e\u0007\u0000\u0160\u0161\u0006\u000b\uffff\uffff\u0000"+
		"\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u015f\u0001\u0000\u0000\u0000"+
		"\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0167\u0001\u0000\u0000\u0000"+
		"\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u0168\u0005)\u0000\u0000\u0168"+
		"\u0169\u0006\u000b\uffff\uffff\u0000\u0169\u0017\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0003\u0002\u0001\u0000\u016b\u016c\u0006\f\uffff\uffff\u0000"+
		"\u016c\u0178\u0001\u0000\u0000\u0000\u016d\u016e\u0003\u0002\u0001\u0000"+
		"\u016e\u0173\u0006\f\uffff\uffff\u0000\u016f\u0170\u0005\u001e\u0000\u0000"+
		"\u0170\u0171\u0003\u0002\u0001\u0000\u0171\u0172\u0006\f\uffff\uffff\u0000"+
		"\u0172\u0174\u0001\u0000\u0000\u0000\u0173\u016f\u0001\u0000\u0000\u0000"+
		"\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000"+
		"\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000"+
		"\u0177\u016a\u0001\u0000\u0000\u0000\u0177\u016d\u0001\u0000\u0000\u0000"+
		"\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u0019\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0005%\u0000\u0000\u017a\u017b\u0005.\u0000\u0000\u017b\u0181"+
		"\u0006\r\uffff\uffff\u0000\u017c\u017d\u0005\u001e\u0000\u0000\u017d\u017e"+
		"\u0005.\u0000\u0000\u017e\u0180\u0006\r\uffff\uffff\u0000\u017f\u017c"+
		"\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181\u017f"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0184"+
		"\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0005&\u0000\u0000\u0185\u0186\u0003\u0006\u0003\u0000\u0186\u0187\u0005"+
		"\u001c\u0000\u0000\u0187\u0188\u0006\r\uffff\uffff\u0000\u0188\u001b\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0005.\u0000\u0000\u018a\u018b\u0005&\u0000"+
		"\u0000\u018b\u018c\u0003\n\u0005\u0000\u018c\u0195\u0006\u000e\uffff\uffff"+
		"\u0000\u018d\u018e\u0005\u001e\u0000\u0000\u018e\u018f\u0005.\u0000\u0000"+
		"\u018f\u0190\u0005&\u0000\u0000\u0190\u0191\u0003\n\u0005\u0000\u0191"+
		"\u0192\u0006\u000e\uffff\uffff\u0000\u0192\u0194\u0001\u0000\u0000\u0000"+
		"\u0193\u018d\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000"+
		"\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000"+
		"\u0196\u001d\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0198\u0199\u0005(\u0000\u0000\u0199\u019a\u0003\f\u0006\u0000\u019a"+
		"\u01a0\u0006\u000f\uffff\uffff\u0000\u019b\u019c\u0003\f\u0006\u0000\u019c"+
		"\u019d\u0006\u000f\uffff\uffff\u0000\u019d\u019f\u0001\u0000\u0000\u0000"+
		"\u019e\u019b\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a3\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a4\u0005)\u0000\u0000\u01a4\u01a9\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a6\u0003\f\u0006\u0000\u01a6\u01a7\u0006\u000f\uffff\uffff\u0000\u01a7"+
		"\u01a9\u0001\u0000\u0000\u0000\u01a8\u0198\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9"+
		"\u001f\u0001\u0000\u0000\u0000\u001e%Uuw\u0089\u008e\u009f\u00a4\u00ab"+
		"\u00b3\u00bd\u00c8\u00d7\u00ec\u010e\u0114\u0117\u011f\u0129\u0137\u0142"+
		"\u014a\u015c\u0164\u0175\u0177\u0181\u0195\u01a0\u01a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
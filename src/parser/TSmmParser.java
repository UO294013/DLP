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
		T__38=39, INT_CONSTANT=40, REAL_CONSTANT=41, CHAR_CONSTANT=42, ID=43, 
		WHITE_SPACE=44, SINGLE_LINE_COMMENT=45, MULTILINE_COMMENT=46;
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
			null, "'('", "')'", "'['", "']'", "'.'", "'as'", "'-'", "'!'", "'*'", 
			"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", 
			"'||'", "'void'", "'int'", "'number'", "'char'", "'return'", "';'", "'log'", 
			"','", "'input'", "'='", "'if'", "'else'", "'while'", "'let'", "':'", 
			"'function'", "'{'", "'}'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"ID", "WHITE_SPACE", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT"
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
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token op;
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
			setState(79);
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
				((ExpressionContext)_localctx).expression = expression(10);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn()); 
				}
				break;
			case 5:
				{
				setState(67);
				match(T__7);
				setState(68);
				((ExpressionContext)_localctx).expression = expression(9);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn()); 
				}
				break;
			case 6:
				{
				setState(71);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)), ((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 7:
				{
				setState(73);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new NumberLiteral(LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)), ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 8:
				{
				setState(75);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)), ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1); 
				}
				break;
			case 9:
				{
				setState(77);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(81);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(82);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(83);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(87);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(92);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new ComparisonOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(97);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(6);
						 ((ExpressionContext)_localctx).ast =  new LogicOperation(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(102);
						match(T__2);
						setState(103);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(104);
						match(T__3);
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).exp1.ast.getLine(), ((ExpressionContext)_localctx).exp1.ast.getColumn(), ((ExpressionContext)_localctx).exp1.ast, ((ExpressionContext)_localctx).exp2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.ex1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(108);
						match(T__4);
						setState(109);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).ex1.ast, ((ExpressionContext)_localctx).ex1.ast.getLine(), ((ExpressionContext)_localctx).ex1.ast.getColumn()); 
						}
						break;
					}
					} 
				}
				setState(115);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((TypeContext)_localctx).returntype = returntype();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).returntype.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(T__2);
				setState(120);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(121);
				match(T__3);
				setState(122);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)), ((TypeContext)_localctx).type.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(T__2);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					((TypeContext)_localctx).recordfield = recordfield();
					 ((TypeContext)_localctx).fields =  ((TypeContext)_localctx).recordfield.ast; 
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__33 );
				setState(133);
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
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				((VartypeContext)_localctx).builtin = builtin();
				 ((VartypeContext)_localctx).ast =  ((VartypeContext)_localctx).builtin.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__2);
				setState(142);
				((VartypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(143);
				match(T__3);
				setState(144);
				((VartypeContext)_localctx).vartype = vartype();
				 ((VartypeContext)_localctx).ast =  new ArrayType(LexerHelper.lexemeToInt((((VartypeContext)_localctx).INT_CONSTANT!=null?((VartypeContext)_localctx).INT_CONSTANT.getText():null)), ((VartypeContext)_localctx).vartype.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(T__2);
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(148);
					((VartypeContext)_localctx).recordfield = recordfield();
					 ((VartypeContext)_localctx).recordfield.ast.forEach( rf -> { if (_localctx.fields.contains(rf)) { new ErrorType("Error: RecordField '" + rf.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) rf); } else { _localctx.fields.add(rf); } }); 
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__33 );
				setState(155);
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
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				((ReturntypeContext)_localctx).builtin = builtin();
				 ((ReturntypeContext)_localctx).ast =  ((ReturntypeContext)_localctx).builtin.ast; 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(T__20);
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
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__21);
				 ((BuiltinContext)_localctx).ast =  IntType.getInstance(); 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(T__22);
				 ((BuiltinContext)_localctx).ast =  NumberType.getInstance(); 
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__23);
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
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__26:
			case T__28:
			case T__30:
			case T__32:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				((StatementContext)_localctx).nonreturnstatement = nonreturnstatement();
				 _localctx.ast.addAll(((StatementContext)_localctx).nonreturnstatement.ast); 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(T__24);
				setState(179);
				((StatementContext)_localctx).expression = expression(0);
				setState(180);
				match(T__25);
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
		public Token ID;
		public ArgumentsContext arguments;
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
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(T__26);
				setState(186);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp1.ast); 
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(188);
					match(T__27);
					setState(189);
					((NonreturnstatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp2.ast); 
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
				match(T__25);
				 _localctx.expressions.forEach( exp -> _localctx.ast.add(new Write(exp, exp.getLine(), exp.getColumn()))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__28);
				setState(201);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp1.ast); 
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(203);
					match(T__27);
					setState(204);
					((NonreturnstatementContext)_localctx).exp2 = expression(0);
					 _localctx.expressions.add(((NonreturnstatementContext)_localctx).exp2.ast); 
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
				match(T__25);
				 _localctx.expressions.forEach( exp -> _localctx.ast.add(new Read(exp, exp.getLine(), exp.getColumn()))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				((NonreturnstatementContext)_localctx).exp1 = expression(0);
				setState(216);
				match(T__29);
				setState(217);
				((NonreturnstatementContext)_localctx).exp2 = expression(0);
				setState(218);
				match(T__25);
				 _localctx.ast.add(new Assignment(((NonreturnstatementContext)_localctx).exp1.ast.getLine(), ((NonreturnstatementContext)_localctx).exp1.ast.getColumn(), ((NonreturnstatementContext)_localctx).exp1.ast, ((NonreturnstatementContext)_localctx).exp2.ast)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				match(T__30);
				setState(222);
				match(T__0);
				setState(223);
				((NonreturnstatementContext)_localctx).expression = expression(0);
				setState(224);
				match(T__1);
				setState(225);
				((NonreturnstatementContext)_localctx).b1 = block();
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(226);
					match(T__31);
					setState(227);
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
				setState(234);
				match(T__32);
				setState(235);
				match(T__0);
				setState(236);
				((NonreturnstatementContext)_localctx).expression = expression(0);
				setState(237);
				match(T__1);
				setState(238);
				((NonreturnstatementContext)_localctx).block = block();
				 _localctx.ast.add(new While(((NonreturnstatementContext)_localctx).expression.ast, ((NonreturnstatementContext)_localctx).block.statements, ((NonreturnstatementContext)_localctx).expression.ast.getLine(), ((NonreturnstatementContext)_localctx).expression.ast.getColumn())); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(241);
				((NonreturnstatementContext)_localctx).ID = match(ID);
				setState(242);
				match(T__0);
				setState(243);
				((NonreturnstatementContext)_localctx).arguments = arguments();
				setState(244);
				match(T__1);
				setState(245);
				match(T__25);
				 _localctx.ast.add(new FunctionCall(((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1, new Variable((((NonreturnstatementContext)_localctx).ID!=null?((NonreturnstatementContext)_localctx).ID.getText():null), ((NonreturnstatementContext)_localctx).ID.getLine(), ((NonreturnstatementContext)_localctx).ID.getCharPositionInLine() + 1), ((NonreturnstatementContext)_localctx).arguments.ast)); 
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
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				((DefinitionContext)_localctx).vardefinition = vardefinition();
				 _localctx.ast.addAll(((DefinitionContext)_localctx).vardefinition.ast); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
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
			setState(258);
			match(T__33);
			setState(259);
			((VardefinitionContext)_localctx).id1 = match(ID);
			 _localctx.vars.add(new Variable((((VardefinitionContext)_localctx).id1!=null?((VardefinitionContext)_localctx).id1.getText():null), ((VardefinitionContext)_localctx).id1.getLine(), ((VardefinitionContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(261);
				match(T__27);
				setState(262);
				((VardefinitionContext)_localctx).id2 = match(ID);
				 Variable var = new Variable((((VardefinitionContext)_localctx).id2!=null?((VardefinitionContext)_localctx).id2.getText():null), ((VardefinitionContext)_localctx).id2.getLine(), ((VardefinitionContext)_localctx).id2.getCharPositionInLine() + 1); if (_localctx.vars.contains(var)) { new ErrorType("Error: Variable '" + var.getName() + "' could not be defined! (there is already a Definition with the same name in the same scope)", (Locatable) var); } else { _localctx.vars.add(var); }; 
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			match(T__34);
			setState(270);
			((VardefinitionContext)_localctx).vartype = vartype();
			setState(271);
			match(T__25);
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
			setState(274);
			match(T__35);
			setState(275);
			((FuncdefinitionContext)_localctx).ID = match(ID);
			setState(276);
			match(T__0);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(277);
				((FuncdefinitionContext)_localctx).parameters = parameters();
				 ((FuncdefinitionContext)_localctx).args =  ((FuncdefinitionContext)_localctx).parameters.ast; 
				}
			}

			setState(282);
			match(T__1);
			setState(283);
			match(T__34);
			setState(284);
			((FuncdefinitionContext)_localctx).returntype = returntype();
			setState(285);
			match(T__36);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(286);
				((FuncdefinitionContext)_localctx).vardefinition = vardefinition();
				 _localctx.defs.addAll(((FuncdefinitionContext)_localctx).vardefinition.ast); 
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16504116478338L) != 0)) {
				{
				{
				setState(294);
				((FuncdefinitionContext)_localctx).statement = statement();
				 _localctx.stmts.addAll(((FuncdefinitionContext)_localctx).statement.ast); 
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			match(T__37);
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
			setState(305);
			match(T__35);
			setState(306);
			match(T__38);
			setState(307);
			match(T__0);
			setState(308);
			match(T__1);
			setState(309);
			match(T__34);
			setState(310);
			match(T__20);
			setState(311);
			match(T__36);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(312);
				((MainContext)_localctx).vardefinition = vardefinition();
				 _localctx.defs.addAll(((MainContext)_localctx).vardefinition.ast); 
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16504082923906L) != 0)) {
				{
				{
				setState(320);
				((MainContext)_localctx).nonreturnstatement = nonreturnstatement();
				 _localctx.stmts.addAll(((MainContext)_localctx).nonreturnstatement.ast); 
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			match(T__37);
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
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(331);
				((ArgumentsContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).exp1.ast); 
				}
				break;
			case 2:
				{
				setState(334);
				((ArgumentsContext)_localctx).exp2 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).exp2.ast); 
				setState(340); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(336);
					match(T__27);
					setState(337);
					((ArgumentsContext)_localctx).exp3 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).exp3.ast); 
					}
					}
					setState(342); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__27 );
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
			setState(346);
			match(T__33);
			setState(347);
			((RecordfieldContext)_localctx).id1 = match(ID);
			 _localctx.vars.add(new Variable((((RecordfieldContext)_localctx).id1!=null?((RecordfieldContext)_localctx).id1.getText():null), ((RecordfieldContext)_localctx).id1.getLine(), ((RecordfieldContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(349);
				match(T__27);
				setState(350);
				((RecordfieldContext)_localctx).id2 = match(ID);
				 _localctx.vars.add(new Variable((((RecordfieldContext)_localctx).id2!=null?((RecordfieldContext)_localctx).id2.getText():null), ((RecordfieldContext)_localctx).id2.getLine(), ((RecordfieldContext)_localctx).id2.getCharPositionInLine() + 1)); 
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357);
			match(T__34);
			setState(358);
			((RecordfieldContext)_localctx).vartype = vartype();
			setState(359);
			match(T__25);
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
			setState(362);
			((ParametersContext)_localctx).id1 = match(ID);
			setState(363);
			match(T__34);
			setState(364);
			((ParametersContext)_localctx).b1 = builtin();
			 _localctx.ast.add(new VariableDefinition((((ParametersContext)_localctx).id1!=null?((ParametersContext)_localctx).id1.getText():null), ((ParametersContext)_localctx).b1.ast, ((ParametersContext)_localctx).id1.getLine(), ((ParametersContext)_localctx).id1.getCharPositionInLine() + 1)); 
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(366);
				match(T__27);
				setState(367);
				((ParametersContext)_localctx).id2 = match(ID);
				setState(368);
				match(T__34);
				setState(369);
				((ParametersContext)_localctx).b2 = builtin();
				 _localctx.ast.add(new VariableDefinition((((ParametersContext)_localctx).id2!=null?((ParametersContext)_localctx).id2.getText():null), ((ParametersContext)_localctx).b2.ast, ((ParametersContext)_localctx).id2.getLine(), ((ParametersContext)_localctx).id2.getCharPositionInLine() + 1)); 
				}
				}
				setState(376);
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
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(377);
				match(T__36);
				setState(378);
				((BlockContext)_localctx).st1 = statement();
				 _localctx.statements.addAll(((BlockContext)_localctx).st1.ast); 
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16504116478338L) != 0)) {
					{
					{
					setState(380);
					((BlockContext)_localctx).st2 = statement();
					 _localctx.statements.addAll(((BlockContext)_localctx).st2.ast); 
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(388);
				match(T__37);
				}
				break;
			case 2:
				{
				setState(390);
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
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u018c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001P\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001p\b\u0001\n\u0001\f\u0001s\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"\u0082\b\u0002\u000b\u0002\f\u0002\u0083\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u0089\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u0098\b\u0003\u000b"+
		"\u0003\f\u0003\u0099\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009f"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00a6\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00ae\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00b8\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00c1\b\u0007\n\u0007\f\u0007"+
		"\u00c4\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u00d0\b\u0007\n\u0007\f\u0007\u00d3\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00e7\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00f9\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0101\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0109\b\t\n\t\f\t\u010c\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0119\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0122\b\n\n\n\f\n\u0125\t\n\u0001\n\u0001\n"+
		"\u0001\n\u0005\n\u012a\b\n\n\n\f\n\u012d\t\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u013c\b\u000b\n"+
		"\u000b\f\u000b\u013f\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0144\b\u000b\n\u000b\f\u000b\u0147\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u0155\b\f\u000b\f\f\f\u0156\u0003\f\u0159\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0161\b\r\n\r\f\r\u0164"+
		"\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0175\b\u000e\n\u000e\f\u000e\u0178\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0180\b\u000f\n\u000f\f\u000f\u0183\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u018a\b\u000f\u0001"+
		"\u000f\u0000\u0001\u0002\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\t\u000b"+
		"\u0002\u0000\u0007\u0007\f\f\u0001\u0000\r\u0012\u0001\u0000\u0013\u0014"+
		"\u01ab\u0000%\u0001\u0000\u0000\u0000\u0002O\u0001\u0000\u0000\u0000\u0004"+
		"\u0088\u0001\u0000\u0000\u0000\u0006\u009e\u0001\u0000\u0000\u0000\b\u00a5"+
		"\u0001\u0000\u0000\u0000\n\u00ad\u0001\u0000\u0000\u0000\f\u00b7\u0001"+
		"\u0000\u0000\u0000\u000e\u00f8\u0001\u0000\u0000\u0000\u0010\u0100\u0001"+
		"\u0000\u0000\u0000\u0012\u0102\u0001\u0000\u0000\u0000\u0014\u0112\u0001"+
		"\u0000\u0000\u0000\u0016\u0131\u0001\u0000\u0000\u0000\u0018\u0158\u0001"+
		"\u0000\u0000\u0000\u001a\u015a\u0001\u0000\u0000\u0000\u001c\u016a\u0001"+
		"\u0000\u0000\u0000\u001e\u0189\u0001\u0000\u0000\u0000 !\u0003\u0010\b"+
		"\u0000!\"\u0006\u0000\uffff\uffff\u0000\"$\u0001\u0000\u0000\u0000# \u0001"+
		"\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000"+
		"\u0000()\u0003\u0016\u000b\u0000)*\u0006\u0000\uffff\uffff\u0000*+\u0005"+
		"\u0000\u0000\u0001+\u0001\u0001\u0000\u0000\u0000,-\u0006\u0001\uffff"+
		"\uffff\u0000-.\u0005+\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0003\u0018"+
		"\f\u000001\u0005\u0002\u0000\u000012\u0006\u0001\uffff\uffff\u00002P\u0001"+
		"\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0003\u0002\u0001\u0000"+
		"56\u0005\u0002\u0000\u000067\u0006\u0001\uffff\uffff\u00007P\u0001\u0000"+
		"\u0000\u000089\u0005\u0001\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0005"+
		"\u0006\u0000\u0000;<\u0003\u0004\u0002\u0000<=\u0005\u0002\u0000\u0000"+
		"=>\u0006\u0001\uffff\uffff\u0000>P\u0001\u0000\u0000\u0000?@\u0005\u0007"+
		"\u0000\u0000@A\u0003\u0002\u0001\nAB\u0006\u0001\uffff\uffff\u0000BP\u0001"+
		"\u0000\u0000\u0000CD\u0005\b\u0000\u0000DE\u0003\u0002\u0001\tEF\u0006"+
		"\u0001\uffff\uffff\u0000FP\u0001\u0000\u0000\u0000GH\u0005(\u0000\u0000"+
		"HP\u0006\u0001\uffff\uffff\u0000IJ\u0005)\u0000\u0000JP\u0006\u0001\uffff"+
		"\uffff\u0000KL\u0005*\u0000\u0000LP\u0006\u0001\uffff\uffff\u0000MN\u0005"+
		"+\u0000\u0000NP\u0006\u0001\uffff\uffff\u0000O,\u0001\u0000\u0000\u0000"+
		"O3\u0001\u0000\u0000\u0000O8\u0001\u0000\u0000\u0000O?\u0001\u0000\u0000"+
		"\u0000OC\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000OI\u0001\u0000"+
		"\u0000\u0000OK\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000Pq\u0001"+
		"\u0000\u0000\u0000QR\n\b\u0000\u0000RS\u0007\u0000\u0000\u0000ST\u0003"+
		"\u0002\u0001\tTU\u0006\u0001\uffff\uffff\u0000Up\u0001\u0000\u0000\u0000"+
		"VW\n\u0007\u0000\u0000WX\u0007\u0001\u0000\u0000XY\u0003\u0002\u0001\b"+
		"YZ\u0006\u0001\uffff\uffff\u0000Zp\u0001\u0000\u0000\u0000[\\\n\u0006"+
		"\u0000\u0000\\]\u0007\u0002\u0000\u0000]^\u0003\u0002\u0001\u0007^_\u0006"+
		"\u0001\uffff\uffff\u0000_p\u0001\u0000\u0000\u0000`a\n\u0005\u0000\u0000"+
		"ab\u0007\u0003\u0000\u0000bc\u0003\u0002\u0001\u0006cd\u0006\u0001\uffff"+
		"\uffff\u0000dp\u0001\u0000\u0000\u0000ef\n\r\u0000\u0000fg\u0005\u0003"+
		"\u0000\u0000gh\u0003\u0002\u0001\u0000hi\u0005\u0004\u0000\u0000ij\u0006"+
		"\u0001\uffff\uffff\u0000jp\u0001\u0000\u0000\u0000kl\n\f\u0000\u0000l"+
		"m\u0005\u0005\u0000\u0000mn\u0005+\u0000\u0000np\u0006\u0001\uffff\uffff"+
		"\u0000oQ\u0001\u0000\u0000\u0000oV\u0001\u0000\u0000\u0000o[\u0001\u0000"+
		"\u0000\u0000o`\u0001\u0000\u0000\u0000oe\u0001\u0000\u0000\u0000ok\u0001"+
		"\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u0003\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tu\u0003\b\u0004\u0000uv\u0006\u0002\uffff\uffff\u0000v\u0089"+
		"\u0001\u0000\u0000\u0000wx\u0005\u0003\u0000\u0000xy\u0005(\u0000\u0000"+
		"yz\u0005\u0004\u0000\u0000z{\u0003\u0004\u0002\u0000{|\u0006\u0002\uffff"+
		"\uffff\u0000|\u0089\u0001\u0000\u0000\u0000}\u0081\u0005\u0003\u0000\u0000"+
		"~\u007f\u0003\u001a\r\u0000\u007f\u0080\u0006\u0002\uffff\uffff\u0000"+
		"\u0080\u0082\u0001\u0000\u0000\u0000\u0081~\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005\u0004\u0000\u0000\u0086\u0087\u0006\u0002\uffff\uffff\u0000"+
		"\u0087\u0089\u0001\u0000\u0000\u0000\u0088t\u0001\u0000\u0000\u0000\u0088"+
		"w\u0001\u0000\u0000\u0000\u0088}\u0001\u0000\u0000\u0000\u0089\u0005\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0003\n\u0005\u0000\u008b\u008c\u0006\u0003"+
		"\uffff\uffff\u0000\u008c\u009f\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\u0003\u0000\u0000\u008e\u008f\u0005(\u0000\u0000\u008f\u0090\u0005\u0004"+
		"\u0000\u0000\u0090\u0091\u0003\u0006\u0003\u0000\u0091\u0092\u0006\u0003"+
		"\uffff\uffff\u0000\u0092\u009f\u0001\u0000\u0000\u0000\u0093\u0097\u0005"+
		"\u0003\u0000\u0000\u0094\u0095\u0003\u001a\r\u0000\u0095\u0096\u0006\u0003"+
		"\uffff\uffff\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0094\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005\u0004\u0000\u0000\u009c\u009d\u0006"+
		"\u0003\uffff\uffff\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u008a"+
		"\u0001\u0000\u0000\u0000\u009e\u008d\u0001\u0000\u0000\u0000\u009e\u0093"+
		"\u0001\u0000\u0000\u0000\u009f\u0007\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0003\n\u0005\u0000\u00a1\u00a2\u0006\u0004\uffff\uffff\u0000\u00a2\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0015\u0000\u0000\u00a4\u00a6"+
		"\u0006\u0004\uffff\uffff\u0000\u00a5\u00a0\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a6\t\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0016\u0000\u0000\u00a8\u00ae\u0006\u0005\uffff\uffff\u0000\u00a9"+
		"\u00aa\u0005\u0017\u0000\u0000\u00aa\u00ae\u0006\u0005\uffff\uffff\u0000"+
		"\u00ab\u00ac\u0005\u0018\u0000\u0000\u00ac\u00ae\u0006\u0005\uffff\uffff"+
		"\u0000\u00ad\u00a7\u0001\u0000\u0000\u0000\u00ad\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u000b\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0003\u000e\u0007\u0000\u00b0\u00b1\u0006\u0006\uffff"+
		"\uffff\u0000\u00b1\u00b8\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0019"+
		"\u0000\u0000\u00b3\u00b4\u0003\u0002\u0001\u0000\u00b4\u00b5\u0005\u001a"+
		"\u0000\u0000\u00b5\u00b6\u0006\u0006\uffff\uffff\u0000\u00b6\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b7\u00af\u0001\u0000\u0000\u0000\u00b7\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b8\r\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u001b"+
		"\u0000\u0000\u00ba\u00bb\u0003\u0002\u0001\u0000\u00bb\u00c2\u0006\u0007"+
		"\uffff\uffff\u0000\u00bc\u00bd\u0005\u001c\u0000\u0000\u00bd\u00be\u0003"+
		"\u0002\u0001\u0000\u00be\u00bf\u0006\u0007\uffff\uffff\u0000\u00bf\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u001a\u0000\u0000\u00c6\u00c7"+
		"\u0006\u0007\uffff\uffff\u0000\u00c7\u00f9\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\u001d\u0000\u0000\u00c9\u00ca\u0003\u0002\u0001\u0000\u00ca"+
		"\u00d1\u0006\u0007\uffff\uffff\u0000\u00cb\u00cc\u0005\u001c\u0000\u0000"+
		"\u00cc\u00cd\u0003\u0002\u0001\u0000\u00cd\u00ce\u0006\u0007\uffff\uffff"+
		"\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00cb\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u001a\u0000"+
		"\u0000\u00d5\u00d6\u0006\u0007\uffff\uffff\u0000\u00d6\u00f9\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0003\u0002\u0001\u0000\u00d8\u00d9\u0005\u001e"+
		"\u0000\u0000\u00d9\u00da\u0003\u0002\u0001\u0000\u00da\u00db\u0005\u001a"+
		"\u0000\u0000\u00db\u00dc\u0006\u0007\uffff\uffff\u0000\u00dc\u00f9\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0005\u001f\u0000\u0000\u00de\u00df\u0005"+
		"\u0001\u0000\u0000\u00df\u00e0\u0003\u0002\u0001\u0000\u00e0\u00e1\u0005"+
		"\u0002\u0000\u0000\u00e1\u00e6\u0003\u001e\u000f\u0000\u00e2\u00e3\u0005"+
		" \u0000\u0000\u00e3\u00e4\u0003\u001e\u000f\u0000\u00e4\u00e5\u0006\u0007"+
		"\uffff\uffff\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0006\u0007\uffff\uffff\u0000\u00e9\u00f9"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005!\u0000\u0000\u00eb\u00ec\u0005"+
		"\u0001\u0000\u0000\u00ec\u00ed\u0003\u0002\u0001\u0000\u00ed\u00ee\u0005"+
		"\u0002\u0000\u0000\u00ee\u00ef\u0003\u001e\u000f\u0000\u00ef\u00f0\u0006"+
		"\u0007\uffff\uffff\u0000\u00f0\u00f9\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005+\u0000\u0000\u00f2\u00f3\u0005\u0001\u0000\u0000\u00f3\u00f4\u0003"+
		"\u0018\f\u0000\u00f4\u00f5\u0005\u0002\u0000\u0000\u00f5\u00f6\u0005\u001a"+
		"\u0000\u0000\u00f6\u00f7\u0006\u0007\uffff\uffff\u0000\u00f7\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f8\u00b9\u0001\u0000\u0000\u0000\u00f8\u00c8\u0001"+
		"\u0000\u0000\u0000\u00f8\u00d7\u0001\u0000\u0000\u0000\u00f8\u00dd\u0001"+
		"\u0000\u0000\u0000\u00f8\u00ea\u0001\u0000\u0000\u0000\u00f8\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f9\u000f\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003"+
		"\u0012\t\u0000\u00fb\u00fc\u0006\b\uffff\uffff\u0000\u00fc\u0101\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0003\u0014\n\u0000\u00fe\u00ff\u0006\b"+
		"\uffff\uffff\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fa\u0001"+
		"\u0000\u0000\u0000\u0100\u00fd\u0001\u0000\u0000\u0000\u0101\u0011\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0005\"\u0000\u0000\u0103\u0104\u0005+"+
		"\u0000\u0000\u0104\u010a\u0006\t\uffff\uffff\u0000\u0105\u0106\u0005\u001c"+
		"\u0000\u0000\u0106\u0107\u0005+\u0000\u0000\u0107\u0109\u0006\t\uffff"+
		"\uffff\u0000\u0108\u0105\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0005#\u0000\u0000\u010e\u010f\u0003\u0006\u0003"+
		"\u0000\u010f\u0110\u0005\u001a\u0000\u0000\u0110\u0111\u0006\t\uffff\uffff"+
		"\u0000\u0111\u0013\u0001\u0000\u0000\u0000\u0112\u0113\u0005$\u0000\u0000"+
		"\u0113\u0114\u0005+\u0000\u0000\u0114\u0118\u0005\u0001\u0000\u0000\u0115"+
		"\u0116\u0003\u001c\u000e\u0000\u0116\u0117\u0006\n\uffff\uffff\u0000\u0117"+
		"\u0119\u0001\u0000\u0000\u0000\u0118\u0115\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a"+
		"\u011b\u0005\u0002\u0000\u0000\u011b\u011c\u0005#\u0000\u0000\u011c\u011d"+
		"\u0003\b\u0004\u0000\u011d\u0123\u0005%\u0000\u0000\u011e\u011f\u0003"+
		"\u0012\t\u0000\u011f\u0120\u0006\n\uffff\uffff\u0000\u0120\u0122\u0001"+
		"\u0000\u0000\u0000\u0121\u011e\u0001\u0000\u0000\u0000\u0122\u0125\u0001"+
		"\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124\u0001"+
		"\u0000\u0000\u0000\u0124\u012b\u0001\u0000\u0000\u0000\u0125\u0123\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0003\f\u0006\u0000\u0127\u0128\u0006\n"+
		"\uffff\uffff\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0126\u0001"+
		"\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012e\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u012f\u0005"+
		"&\u0000\u0000\u012f\u0130\u0006\n\uffff\uffff\u0000\u0130\u0015\u0001"+
		"\u0000\u0000\u0000\u0131\u0132\u0005$\u0000\u0000\u0132\u0133\u0005\'"+
		"\u0000\u0000\u0133\u0134\u0005\u0001\u0000\u0000\u0134\u0135\u0005\u0002"+
		"\u0000\u0000\u0135\u0136\u0005#\u0000\u0000\u0136\u0137\u0005\u0015\u0000"+
		"\u0000\u0137\u013d\u0005%\u0000\u0000\u0138\u0139\u0003\u0012\t\u0000"+
		"\u0139\u013a\u0006\u000b\uffff\uffff\u0000\u013a\u013c\u0001\u0000\u0000"+
		"\u0000\u013b\u0138\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000"+
		"\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000"+
		"\u0000\u013e\u0145\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0003\u000e\u0007\u0000\u0141\u0142\u0006\u000b\uffff"+
		"\uffff\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0140\u0001\u0000"+
		"\u0000\u0000\u0144\u0147\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0148\u0001\u0000"+
		"\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0148\u0149\u0005&\u0000"+
		"\u0000\u0149\u014a\u0006\u000b\uffff\uffff\u0000\u014a\u0017\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0003\u0002\u0001\u0000\u014c\u014d\u0006\f\uffff"+
		"\uffff\u0000\u014d\u0159\u0001\u0000\u0000\u0000\u014e\u014f\u0003\u0002"+
		"\u0001\u0000\u014f\u0154\u0006\f\uffff\uffff\u0000\u0150\u0151\u0005\u001c"+
		"\u0000\u0000\u0151\u0152\u0003\u0002\u0001\u0000\u0152\u0153\u0006\f\uffff"+
		"\uffff\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154\u0150\u0001\u0000"+
		"\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000"+
		"\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0001\u0000"+
		"\u0000\u0000\u0158\u014b\u0001\u0000\u0000\u0000\u0158\u014e\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u0019\u0001\u0000"+
		"\u0000\u0000\u015a\u015b\u0005\"\u0000\u0000\u015b\u015c\u0005+\u0000"+
		"\u0000\u015c\u0162\u0006\r\uffff\uffff\u0000\u015d\u015e\u0005\u001c\u0000"+
		"\u0000\u015e\u015f\u0005+\u0000\u0000\u015f\u0161\u0006\r\uffff\uffff"+
		"\u0000\u0160\u015d\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000\u0000"+
		"\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000"+
		"\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0005#\u0000\u0000\u0166\u0167\u0003\u0006\u0003\u0000"+
		"\u0167\u0168\u0005\u001a\u0000\u0000\u0168\u0169\u0006\r\uffff\uffff\u0000"+
		"\u0169\u001b\u0001\u0000\u0000\u0000\u016a\u016b\u0005+\u0000\u0000\u016b"+
		"\u016c\u0005#\u0000\u0000\u016c\u016d\u0003\n\u0005\u0000\u016d\u0176"+
		"\u0006\u000e\uffff\uffff\u0000\u016e\u016f\u0005\u001c\u0000\u0000\u016f"+
		"\u0170\u0005+\u0000\u0000\u0170\u0171\u0005#\u0000\u0000\u0171\u0172\u0003"+
		"\n\u0005\u0000\u0172\u0173\u0006\u000e\uffff\uffff\u0000\u0173\u0175\u0001"+
		"\u0000\u0000\u0000\u0174\u016e\u0001\u0000\u0000\u0000\u0175\u0178\u0001"+
		"\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176\u0177\u0001"+
		"\u0000\u0000\u0000\u0177\u001d\u0001\u0000\u0000\u0000\u0178\u0176\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0005%\u0000\u0000\u017a\u017b\u0003\f"+
		"\u0006\u0000\u017b\u0181\u0006\u000f\uffff\uffff\u0000\u017c\u017d\u0003"+
		"\f\u0006\u0000\u017d\u017e\u0006\u000f\uffff\uffff\u0000\u017e\u0180\u0001"+
		"\u0000\u0000\u0000\u017f\u017c\u0001\u0000\u0000\u0000\u0180\u0183\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001"+
		"\u0000\u0000\u0000\u0182\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0005&\u0000\u0000\u0185\u018a\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0003\f\u0006\u0000\u0187\u0188\u0006\u000f\uffff"+
		"\uffff\u0000\u0188\u018a\u0001\u0000\u0000\u0000\u0189\u0179\u0001\u0000"+
		"\u0000\u0000\u0189\u0186\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000"+
		"\u0000\u0000\u018a\u001f\u0001\u0000\u0000\u0000\u001c%Ooq\u0083\u0088"+
		"\u0099\u009e\u00a5\u00ad\u00b7\u00c2\u00d1\u00e6\u00f8\u0100\u010a\u0118"+
		"\u0123\u012b\u013d\u0145\u0156\u0158\u0162\u0176\u0181\u0189";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
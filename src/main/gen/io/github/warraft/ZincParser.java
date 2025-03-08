// Generated from io/github/warraft/Zinc.g4 by ANTLR 4.13.2
package io.github.warraft;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ZincParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RAWVAL=1, STRING=2, CONSTANT=3, DEBUG=4, ELSE=5, FALSE=6, FOR=7, FUNCTION=8, 
		IF=9, LIBRARY=10, METHOD=11, NATIVE=12, NULL=13, PUBLIC=14, PRIVATE=15, 
		REQUIRES=16, RETURN=17, STATIC=18, STRUCT=19, TRUE=20, WHILE=21, RETURNS=22, 
		NOT=23, DOT=24, COMMA=25, EQ_EQ=26, NEQ=27, EQ=28, ADD_EQ=29, SUB_EQ=30, 
		MUL_EQ=31, DIV_EQ=32, LT_EQ=33, LT=34, GT_EQ=35, GT=36, ADD=37, SUB=38, 
		MUL=39, DIV=40, AND_AND=41, OR_OR=42, LPAREN=43, RPAREN=44, LBRACK=45, 
		RBRACK=46, LBRACE=47, RBRACE=48, SEMI=49, ID=50, INTVAL=51, HEXVAL=52, 
		REALVAL=53, WS=54, NL=55, COMMENT=56, LINE_COMMENT=57;
	public static final int
		RULE_root = 0, RULE_rootItem = 1, RULE_lib = 2, RULE_vis = 3, RULE_typename = 4, 
		RULE_varname = 5, RULE_param = 6, RULE_function = 7, RULE_left = 8, RULE_stmt = 9, 
		RULE_elseRule = 10, RULE_expr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "rootItem", "lib", "vis", "typename", "varname", "param", "function", 
			"left", "stmt", "elseRule", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'constant'", "'debug'", "'else'", "'false'", "'for'", 
			"'function'", "'if'", "'library'", "'method'", "'native'", "'null'", 
			"'public'", "'private'", "'requires'", "'return'", "'static'", "'struct'", 
			"'true'", "'while'", "'->'", "'!'", "'.'", "','", "'=='", "'!='", "'='", 
			"'+='", "'-='", "'*='", "'/='", "'<='", "'<'", "'>='", "'>'", "'+'", 
			"'-'", "'*'", "'/'", "'&&'", "'||'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "CONSTANT", "DEBUG", "ELSE", "FALSE", "FOR", 
			"FUNCTION", "IF", "LIBRARY", "METHOD", "NATIVE", "NULL", "PUBLIC", "PRIVATE", 
			"REQUIRES", "RETURN", "STATIC", "STRUCT", "TRUE", "WHILE", "RETURNS", 
			"NOT", "DOT", "COMMA", "EQ_EQ", "NEQ", "EQ", "ADD_EQ", "SUB_EQ", "MUL_EQ", 
			"DIV_EQ", "LT_EQ", "LT", "GT_EQ", "GT", "ADD", "SUB", "MUL", "DIV", "AND_AND", 
			"OR_OR", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", 
			"SEMI", "ID", "INTVAL", "HEXVAL", "REALVAL", "WS", "NL", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Zinc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZincParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ZincParser.EOF, 0); }
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909914520L) != 0)) {
				{
				{
				setState(24);
				rootItem();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
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
	public static class RootItemContext extends ParserRuleContext {
		public LibContext lib() {
			return getRuleContext(LibContext.class,0);
		}
		public VisContext vis() {
			return getRuleContext(VisContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public RootItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootItem; }
	}

	public final RootItemContext rootItem() throws RecognitionException {
		RootItemContext _localctx = new RootItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rootItem);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				lib();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				vis();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				function();
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
	public static class LibContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ZincParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZincParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public TerminalNode LIBRARY() { return getToken(ZincParser.LIBRARY, 0); }
		public TerminalNode STRUCT() { return getToken(ZincParser.STRUCT, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(ZincParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ZincParser.LBRACK, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ZincParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ZincParser.RBRACK, i);
		}
		public TerminalNode REQUIRES() { return getToken(ZincParser.REQUIRES, 0); }
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZincParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZincParser.COMMA, i);
		}
		public LibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lib; }
	}

	public final LibContext lib() throws RecognitionException {
		LibContext _localctx = new LibContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !(_la==LIBRARY || _la==STRUCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(39);
				match(LBRACK);
				setState(40);
				expr(0);
				setState(41);
				match(RBRACK);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REQUIRES) {
				{
				setState(49);
				match(REQUIRES);
				setState(50);
				match(ID);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(51);
					match(COMMA);
					setState(52);
					match(ID);
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(60);
			match(LBRACE);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909914520L) != 0)) {
				{
				{
				setState(61);
				rootItem();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(RBRACE);
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
	public static class VisContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ZincParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(ZincParser.PRIVATE, 0); }
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public VisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vis; }
	}

	public final VisContext vis() throws RecognitionException {
		VisContext _localctx = new VisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vis);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==PRIVATE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSTANT:
			case DEBUG:
			case FOR:
			case FUNCTION:
			case IF:
			case LIBRARY:
			case METHOD:
			case NATIVE:
			case PUBLIC:
			case PRIVATE:
			case RETURN:
			case STATIC:
			case STRUCT:
			case WHILE:
			case ID:
				{
				setState(70);
				rootItem();
				}
				break;
			case LBRACE:
				{
				{
				setState(71);
				match(LBRACE);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909914520L) != 0)) {
					{
					{
					setState(72);
					rootItem();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(RBRACE);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ID);
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
	public static class VarnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(ID);
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
	public static class ParamContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			typename();
			setState(86);
			varname();
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
	public static class FunctionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ZincParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ZincParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public TerminalNode NATIVE() { return getToken(ZincParser.NATIVE, 0); }
		public TerminalNode FUNCTION() { return getToken(ZincParser.FUNCTION, 0); }
		public TerminalNode METHOD() { return getToken(ZincParser.METHOD, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode RETURNS() { return getToken(ZincParser.RETURNS, 0); }
		public List<TerminalNode> STATIC() { return getTokens(ZincParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(ZincParser.STATIC, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(ZincParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(ZincParser.CONSTANT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZincParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZincParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONSTANT || _la==STATIC) {
				{
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==CONSTANT || _la==STATIC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6400L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(95);
			match(ID);
			setState(96);
			match(LPAREN);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(97);
				param();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(98);
					match(COMMA);
					setState(99);
					param();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(107);
			match(RPAREN);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(108);
				match(RETURNS);
				setState(109);
				match(ID);
				}
			}

			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSTANT:
			case DEBUG:
			case FOR:
			case IF:
			case RETURN:
			case STATIC:
			case WHILE:
			case ID:
				{
				setState(112);
				stmt();
				}
				break;
			case LBRACE:
				{
				setState(113);
				match(LBRACE);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909333656L) != 0)) {
					{
					{
					setState(114);
					stmt();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class LeftContext extends ParserRuleContext {
		public LeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left; }
	 
		public LeftContext() { }
		public void copyFrom(LeftContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftCallContext extends LeftContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZincParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZincParser.COMMA, i);
		}
		public LeftCallContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftArrContext extends LeftContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(ZincParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ZincParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeftArrContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftIdContext extends LeftContext {
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public LeftIdContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftCommaContext extends LeftContext {
		public List<LeftContext> left() {
			return getRuleContexts(LeftContext.class);
		}
		public LeftContext left(int i) {
			return getRuleContext(LeftContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ZincParser.COMMA, 0); }
		public LeftCommaContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftTypeContext extends LeftContext {
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public LeftTypeContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftDotContext extends LeftContext {
		public List<LeftContext> left() {
			return getRuleContexts(LeftContext.class);
		}
		public LeftContext left(int i) {
			return getRuleContext(LeftContext.class,i);
		}
		public TerminalNode DOT() { return getToken(ZincParser.DOT, 0); }
		public LeftDotContext(LeftContext ctx) { copyFrom(ctx); }
	}

	public final LeftContext left() throws RecognitionException {
		return left(0);
	}

	private LeftContext left(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LeftContext _localctx = new LeftContext(_ctx, _parentState);
		LeftContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_left, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new LeftIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(124);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new LeftTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(ID);
				setState(126);
				left(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(154);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new LeftCommaContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(129);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(130);
						match(COMMA);
						setState(131);
						left(5);
						}
						break;
					case 2:
						{
						_localctx = new LeftDotContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(132);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(133);
						match(DOT);
						setState(134);
						left(2);
						}
						break;
					case 3:
						{
						_localctx = new LeftCallContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(135);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(136);
						match(LPAREN);
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16897569583014214L) != 0)) {
							{
							setState(137);
							expr(0);
							setState(142);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(138);
								match(COMMA);
								setState(139);
								expr(0);
								}
								}
								setState(144);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(147);
						match(RPAREN);
						}
						break;
					case 4:
						{
						_localctx = new LeftArrContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(148);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(149);
						match(LBRACK);
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16897569583014214L) != 0)) {
							{
							setState(150);
							expr(0);
							}
						}

						setState(153);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtIfContext extends StmtContext {
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public TerminalNode IF() { return getToken(ZincParser.IF, 0); }
		public TerminalNode WHILE() { return getToken(ZincParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(ZincParser.FOR, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElseRuleContext elseRule() {
			return getRuleContext(ElseRuleContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(ZincParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(ZincParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtModContext extends StmtContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public List<TerminalNode> DEBUG() { return getTokens(ZincParser.DEBUG); }
		public TerminalNode DEBUG(int i) {
			return getToken(ZincParser.DEBUG, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(ZincParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(ZincParser.STATIC, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(ZincParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(ZincParser.CONSTANT, i);
		}
		public StmtModContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLeftContext extends StmtContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ZincParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ZincParser.EQ, 0); }
		public TerminalNode ADD_EQ() { return getToken(ZincParser.ADD_EQ, 0); }
		public TerminalNode SUB_EQ() { return getToken(ZincParser.SUB_EQ, 0); }
		public TerminalNode MUL_EQ() { return getToken(ZincParser.MUL_EQ, 0); }
		public TerminalNode DIV_EQ() { return getToken(ZincParser.DIV_EQ, 0); }
		public StmtLeftContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		int _la;
		try {
			int _alt;
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new StmtLeftContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				left(0);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8321499136L) != 0)) {
					{
					setState(160);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8321499136L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(161);
					expr(0);
					}
				}

				setState(164);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(RETURN);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16897569583014214L) != 0)) {
					{
					setState(167);
					expr(0);
					}
				}

				setState(170);
				match(SEMI);
				}
				break;
			case FOR:
			case IF:
			case WHILE:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097792L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(172);
				match(LPAREN);
				setState(173);
				expr(0);
				setState(174);
				match(RPAREN);
				setState(184);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONSTANT:
				case DEBUG:
				case FOR:
				case IF:
				case RETURN:
				case STATIC:
				case WHILE:
				case ID:
					{
					setState(175);
					stmt();
					}
					break;
				case LBRACE:
					{
					{
					setState(176);
					match(LBRACE);
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909333656L) != 0)) {
						{
						{
						setState(177);
						stmt();
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(183);
					match(RBRACE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(187);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(186);
					elseRule();
					}
					break;
				}
				}
				break;
			case CONSTANT:
			case DEBUG:
			case STATIC:
				_localctx = new StmtModContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(190); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(189);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262168L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(192); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(194);
				stmt();
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
	public static class ElseRuleContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ZincParser.ELSE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public ElseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseRule; }
	}

	public final ElseRuleContext elseRule() throws RecognitionException {
		ElseRuleContext _localctx = new ElseRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ELSE);
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSTANT:
			case DEBUG:
			case FOR:
			case IF:
			case RETURN:
			case STATIC:
			case WHILE:
			case ID:
				{
				setState(198);
				stmt();
				}
				break;
			case LBRACE:
				{
				{
				setState(199);
				match(LBRACE);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909333656L) != 0)) {
					{
					{
					setState(200);
					stmt();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(RBRACE);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIntContext extends ExprContext {
		public TerminalNode INTVAL() { return getToken(ZincParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(ZincParser.HEXVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(ZincParser.RAWVAL, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ZincParser.STRING, 0); }
		public ExprStrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(ZincParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(ZincParser.NOT, 0); }
		public ExprUnContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVarContext extends ExprContext {
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public ExprVarContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ_EQ() { return getToken(ZincParser.EQ_EQ, 0); }
		public TerminalNode NEQ() { return getToken(ZincParser.NEQ, 0); }
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLambdaContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(ZincParser.FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(ZincParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZincParser.RBRACE, 0); }
		public TerminalNode RETURNS() { return getToken(ZincParser.RETURNS, 0); }
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExprLambdaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprDotContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(ZincParser.DOT, 0); }
		public ExprDotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(ZincParser.NULL, 0); }
		public ExprNullContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFunContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(ZincParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(ZincParser.ID, 0); }
		public ExprFunContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLtContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(ZincParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(ZincParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(ZincParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(ZincParser.GT_EQ, 0); }
		public ExprLtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCallContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(ZincParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZincParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ZincParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZincParser.COMMA, i);
		}
		public ExprCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMulContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ZincParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ZincParser.DIV, 0); }
		public ExprMulContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(ZincParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(ZincParser.ADD, 0); }
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprArrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(ZincParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ZincParser.RBRACK, 0); }
		public ExprArrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(ZincParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ZincParser.FALSE, 0); }
		public ExprBoolContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_AND() { return getToken(ZincParser.AND_AND, 0); }
		public TerminalNode OR_OR() { return getToken(ZincParser.OR_OR, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REALVAL() { return getToken(ZincParser.REALVAL, 0); }
		public ExprRealContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(210);
				match(LPAREN);
				setState(211);
				expr(0);
				setState(212);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				expr(16);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 5:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6755399441055746L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new ExprRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(FUNCTION);
				setState(222);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new ExprLambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(FUNCTION);
				setState(224);
				match(LPAREN);
				setState(225);
				match(RPAREN);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RETURNS) {
					{
					setState(226);
					match(RETURNS);
					setState(227);
					match(ID);
					}
				}

				setState(230);
				match(LBRACE);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899909333656L) != 0)) {
					{
					{
					setState(231);
					stmt();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				match(RBRACE);
				}
				break;
			case 10:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExprDotContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(242);
						match(DOT);
						setState(243);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(245);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(248);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(251);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(254);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(257);
						_la = _input.LA(1);
						if ( !(_la==AND_AND || _la==OR_OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprArrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(260);
						match(LBRACK);
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16897569583014214L) != 0)) {
							{
							setState(261);
							expr(0);
							}
						}

						setState(264);
						match(RBRACK);
						}
						break;
					case 8:
						{
						_localctx = new ExprCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(266);
						match(LPAREN);
						setState(275);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16897569583014214L) != 0)) {
							{
							setState(267);
							expr(0);
							setState(272);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(268);
								match(COMMA);
								setState(269);
								expr(0);
								}
								}
								setState(274);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(277);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return left_sempred((LeftContext)_localctx, predIndex);
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean left_sempred(LeftContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u011c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"%\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002,\b\u0002\n\u0002\f\u0002/\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00026\b\u0002\n\u0002\f\u0002"+
		"9\t\u0002\u0003\u0002;\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002?\b"+
		"\u0002\n\u0002\f\u0002B\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003J\b\u0003\n\u0003\f\u0003M\t"+
		"\u0003\u0001\u0003\u0003\u0003P\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0005"+
		"\u0007Z\b\u0007\n\u0007\f\u0007]\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007e\b\u0007\n\u0007"+
		"\f\u0007h\t\u0007\u0003\u0007j\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007o\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"t\b\u0007\n\u0007\f\u0007w\t\u0007\u0001\u0007\u0003\u0007z\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0080\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u008d"+
		"\b\b\n\b\f\b\u0090\t\b\u0003\b\u0092\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0098\b\b\u0001\b\u0005\b\u009b\b\b\n\b\f\b\u009e\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00a3\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00a9\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00b3\b\t\n\t\f\t\u00b6\t\t\u0001\t\u0003\t\u00b9\b\t\u0001"+
		"\t\u0003\t\u00bc\b\t\u0001\t\u0004\t\u00bf\b\t\u000b\t\f\t\u00c0\u0001"+
		"\t\u0003\t\u00c4\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00ca\b\n"+
		"\n\n\f\n\u00cd\t\n\u0001\n\u0003\n\u00d0\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e5"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e9\b\u000b\n\u000b\f\u000b"+
		"\u00ec\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f0\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u010f"+
		"\b\u000b\n\u000b\f\u000b\u0112\t\u000b\u0003\u000b\u0114\b\u000b\u0001"+
		"\u000b\u0005\u000b\u0117\b\u000b\n\u000b\f\u000b\u011a\t\u000b\u0001\u000b"+
		"\u0000\u0002\u0010\u0016\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u000f\u0002\u0000\n\n\u0013\u0013\u0001\u0000\u000e"+
		"\u000f\u0002\u0000\u0003\u0003\u0012\u0012\u0002\u0000\b\b\u000b\f\u0001"+
		"\u0000\u001c \u0003\u0000\u0007\u0007\t\t\u0015\u0015\u0002\u0000\u0003"+
		"\u0004\u0012\u0012\u0002\u0000\u0017\u0017&&\u0002\u0000\u0006\u0006\u0014"+
		"\u0014\u0002\u0000\u0001\u000134\u0001\u0000\'(\u0001\u0000%&\u0001\u0000"+
		"!$\u0001\u0000\u001a\u001b\u0001\u0000)*\u0148\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000"+
		"\u0006E\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nS\u0001\u0000"+
		"\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000"+
		"\u0010\u007f\u0001\u0000\u0000\u0000\u0012\u00c3\u0001\u0000\u0000\u0000"+
		"\u0014\u00c5\u0001\u0000\u0000\u0000\u0016\u00ef\u0001\u0000\u0000\u0000"+
		"\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000"+
		"\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001e\u0001\u0000\u0000\u0000"+
		"\u001d\u001b\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0000\u0000\u0001"+
		"\u001f\u0001\u0001\u0000\u0000\u0000 %\u0003\u0004\u0002\u0000!%\u0003"+
		"\u0006\u0003\u0000\"%\u0003\u0012\t\u0000#%\u0003\u000e\u0007\u0000$ "+
		"\u0001\u0000\u0000\u0000$!\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000$#\u0001\u0000\u0000\u0000%\u0003\u0001\u0000\u0000\u0000&-\u0007"+
		"\u0000\u0000\u0000\'(\u0005-\u0000\u0000()\u0003\u0016\u000b\u0000)*\u0005"+
		".\u0000\u0000*,\u0001\u0000\u0000\u0000+\'\u0001\u0000\u0000\u0000,/\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u00000:\u00052\u0000\u0000"+
		"12\u0005\u0010\u0000\u000027\u00052\u0000\u000034\u0005\u0019\u0000\u0000"+
		"46\u00052\u0000\u000053\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008;\u0001\u0000\u0000"+
		"\u000097\u0001\u0000\u0000\u0000:1\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<@\u0005/\u0000\u0000=?\u0003\u0002"+
		"\u0001\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000CD\u00050\u0000\u0000D\u0005\u0001\u0000\u0000"+
		"\u0000EO\u0007\u0001\u0000\u0000FP\u0003\u0002\u0001\u0000GK\u0005/\u0000"+
		"\u0000HJ\u0003\u0002\u0001\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u00050\u0000\u0000OF\u0001"+
		"\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000P\u0007\u0001\u0000\u0000"+
		"\u0000QR\u00052\u0000\u0000R\t\u0001\u0000\u0000\u0000ST\u00052\u0000"+
		"\u0000T\u000b\u0001\u0000\u0000\u0000UV\u0003\b\u0004\u0000VW\u0003\n"+
		"\u0005\u0000W\r\u0001\u0000\u0000\u0000XZ\u0007\u0002\u0000\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^_\u0007\u0003\u0000\u0000_`\u00052\u0000\u0000`i\u0005+\u0000\u0000"+
		"af\u0003\f\u0006\u0000bc\u0005\u0019\u0000\u0000ce\u0003\f\u0006\u0000"+
		"db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000ia\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kn\u0005,\u0000\u0000lm\u0005\u0016\u0000\u0000mo\u0005"+
		"2\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oy\u0001"+
		"\u0000\u0000\u0000pz\u0003\u0012\t\u0000qu\u0005/\u0000\u0000rt\u0003"+
		"\u0012\t\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000xz\u00050\u0000\u0000yp\u0001\u0000\u0000\u0000"+
		"yq\u0001\u0000\u0000\u0000z\u000f\u0001\u0000\u0000\u0000{|\u0006\b\uffff"+
		"\uffff\u0000|\u0080\u00052\u0000\u0000}~\u00052\u0000\u0000~\u0080\u0003"+
		"\u0010\b\u0005\u007f{\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000"+
		"\u0000\u0080\u009c\u0001\u0000\u0000\u0000\u0081\u0082\n\u0004\u0000\u0000"+
		"\u0082\u0083\u0005\u0019\u0000\u0000\u0083\u009b\u0003\u0010\b\u0005\u0084"+
		"\u0085\n\u0001\u0000\u0000\u0085\u0086\u0005\u0018\u0000\u0000\u0086\u009b"+
		"\u0003\u0010\b\u0002\u0087\u0088\n\u0003\u0000\u0000\u0088\u0091\u0005"+
		"+\u0000\u0000\u0089\u008e\u0003\u0016\u000b\u0000\u008a\u008b\u0005\u0019"+
		"\u0000\u0000\u008b\u008d\u0003\u0016\u000b\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000"+
		"\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0089\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u009b\u0005,\u0000\u0000\u0094\u0095\n\u0002\u0000"+
		"\u0000\u0095\u0097\u0005-\u0000\u0000\u0096\u0098\u0003\u0016\u000b\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0005.\u0000\u0000\u009a"+
		"\u0081\u0001\u0000\u0000\u0000\u009a\u0084\u0001\u0000\u0000\u0000\u009a"+
		"\u0087\u0001\u0000\u0000\u0000\u009a\u0094\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u0011\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009f\u00a2\u0003\u0010\b\u0000\u00a0\u00a1"+
		"\u0007\u0004\u0000\u0000\u00a1\u00a3\u0003\u0016\u000b\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u00051\u0000\u0000\u00a5\u00c4\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a8\u0005\u0011\u0000\u0000\u00a7\u00a9\u0003"+
		"\u0016\u000b\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00c4\u0005"+
		"1\u0000\u0000\u00ab\u00ac\u0007\u0005\u0000\u0000\u00ac\u00ad\u0005+\u0000"+
		"\u0000\u00ad\u00ae\u0003\u0016\u000b\u0000\u00ae\u00b8\u0005,\u0000\u0000"+
		"\u00af\u00b9\u0003\u0012\t\u0000\u00b0\u00b4\u0005/\u0000\u0000\u00b1"+
		"\u00b3\u0003\u0012\t\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b9\u00050\u0000\u0000\u00b8\u00af\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b0\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0003\u0014\n\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c4\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0007\u0006\u0000\u0000\u00be\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0003\u0012\t\u0000\u00c3\u009f\u0001\u0000\u0000"+
		"\u0000\u00c3\u00a6\u0001\u0000\u0000\u0000\u00c3\u00ab\u0001\u0000\u0000"+
		"\u0000\u00c3\u00be\u0001\u0000\u0000\u0000\u00c4\u0013\u0001\u0000\u0000"+
		"\u0000\u00c5\u00cf\u0005\u0005\u0000\u0000\u00c6\u00d0\u0003\u0012\t\u0000"+
		"\u00c7\u00cb\u0005/\u0000\u0000\u00c8\u00ca\u0003\u0012\t\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u00050\u0000\u0000\u00cf\u00c6\u0001\u0000\u0000\u0000\u00cf\u00c7"+
		"\u0001\u0000\u0000\u0000\u00d0\u0015\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0006\u000b\uffff\uffff\u0000\u00d2\u00d3\u0005+\u0000\u0000\u00d3\u00d4"+
		"\u0003\u0016\u000b\u0000\u00d4\u00d5\u0005,\u0000\u0000\u00d5\u00f0\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0007\u0007\u0000\u0000\u00d7\u00f0\u0003"+
		"\u0016\u000b\u0010\u00d8\u00f0\u0005\r\u0000\u0000\u00d9\u00f0\u0007\b"+
		"\u0000\u0000\u00da\u00f0\u0007\t\u0000\u0000\u00db\u00f0\u00055\u0000"+
		"\u0000\u00dc\u00f0\u0005\u0002\u0000\u0000\u00dd\u00de\u0005\b\u0000\u0000"+
		"\u00de\u00f0\u00052\u0000\u0000\u00df\u00e0\u0005\b\u0000\u0000\u00e0"+
		"\u00e1\u0005+\u0000\u0000\u00e1\u00e4\u0005,\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0016\u0000\u0000\u00e3\u00e5\u00052\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00ea\u0005/\u0000\u0000\u00e7\u00e9\u0003\u0012\t"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ed\u00f0\u00050\u0000\u0000\u00ee\u00f0\u00052\u0000\u0000\u00ef"+
		"\u00d1\u0001\u0000\u0000\u0000\u00ef\u00d6\u0001\u0000\u0000\u0000\u00ef"+
		"\u00d8\u0001\u0000\u0000\u0000\u00ef\u00d9\u0001\u0000\u0000\u0000\u00ef"+
		"\u00da\u0001\u0000\u0000\u0000\u00ef\u00db\u0001\u0000\u0000\u0000\u00ef"+
		"\u00dc\u0001\u0000\u0000\u0000\u00ef\u00dd\u0001\u0000\u0000\u0000\u00ef"+
		"\u00df\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0"+
		"\u0118\u0001\u0000\u0000\u0000\u00f1\u00f2\n\u0012\u0000\u0000\u00f2\u00f3"+
		"\u0005\u0018\u0000\u0000\u00f3\u0117\u0003\u0016\u000b\u0013\u00f4\u00f5"+
		"\n\u000f\u0000\u0000\u00f5\u00f6\u0007\n\u0000\u0000\u00f6\u0117\u0003"+
		"\u0016\u000b\u0010\u00f7\u00f8\n\u000e\u0000\u0000\u00f8\u00f9\u0007\u000b"+
		"\u0000\u0000\u00f9\u0117\u0003\u0016\u000b\u000f\u00fa\u00fb\n\r\u0000"+
		"\u0000\u00fb\u00fc\u0007\f\u0000\u0000\u00fc\u0117\u0003\u0016\u000b\u000e"+
		"\u00fd\u00fe\n\f\u0000\u0000\u00fe\u00ff\u0007\r\u0000\u0000\u00ff\u0117"+
		"\u0003\u0016\u000b\r\u0100\u0101\n\u000b\u0000\u0000\u0101\u0102\u0007"+
		"\u000e\u0000\u0000\u0102\u0117\u0003\u0016\u000b\f\u0103\u0104\n\u0005"+
		"\u0000\u0000\u0104\u0106\u0005-\u0000\u0000\u0105\u0107\u0003\u0016\u000b"+
		"\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0117\u0005.\u0000\u0000"+
		"\u0109\u010a\n\u0004\u0000\u0000\u010a\u0113\u0005+\u0000\u0000\u010b"+
		"\u0110\u0003\u0016\u000b\u0000\u010c\u010d\u0005\u0019\u0000\u0000\u010d"+
		"\u010f\u0003\u0016\u000b\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f"+
		"\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0113\u010b\u0001\u0000\u0000\u0000\u0113"+
		"\u0114\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115"+
		"\u0117\u0005,\u0000\u0000\u0116\u00f1\u0001\u0000\u0000\u0000\u0116\u00f4"+
		"\u0001\u0000\u0000\u0000\u0116\u00f7\u0001\u0000\u0000\u0000\u0116\u00fa"+
		"\u0001\u0000\u0000\u0000\u0116\u00fd\u0001\u0000\u0000\u0000\u0116\u0100"+
		"\u0001\u0000\u0000\u0000\u0116\u0103\u0001\u0000\u0000\u0000\u0116\u0109"+
		"\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u0017"+
		"\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000%\u001b$-"+
		"7:@KO[finuy\u007f\u008e\u0091\u0097\u009a\u009c\u00a2\u00a8\u00b4\u00b8"+
		"\u00bb\u00c0\u00c3\u00cb\u00cf\u00e4\u00ea\u00ef\u0106\u0110\u0113\u0116"+
		"\u0118";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
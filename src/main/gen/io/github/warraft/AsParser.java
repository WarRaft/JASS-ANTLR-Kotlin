// Generated from io/github/warraft/As.g4 by ANTLR 4.13.2
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
public class AsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RAWVAL=1, STRING=2, INCLUDE=3, NAMESPACE=4, COL_COL=5, AT=6, CONST=7, 
		ELSE=8, FOR=9, FUNCDEF=10, IF=11, PUBLIC=12, PRIVATE=13, RETURN=14, WHILE=15, 
		NOT=16, DOT=17, COMMA=18, EQ_EQ=19, NEQ=20, EQ=21, ADD_EQ=22, SUB_EQ=23, 
		MUL_EQ=24, DIV_EQ=25, LT_EQ=26, LT=27, GT_EQ=28, GT=29, ADD_ADD=30, ADD=31, 
		SUB=32, MUL=33, DIV=34, AND_AND=35, OR_OR=36, LPAREN=37, RPAREN=38, LBRACK=39, 
		RBRACK=40, LBRACE=41, RBRACE=42, SEMI=43, ID=44, INTVAL=45, HEXVAL=46, 
		REALVAL=47, WS=48, NL=49, COMMENT=50, LINE_COMMENT=51;
	public static final int
		RULE_root = 0, RULE_rootItem = 1, RULE_include = 2, RULE_namespace = 3, 
		RULE_typename = 4, RULE_varname = 5, RULE_param = 6, RULE_funcdef = 7, 
		RULE_func = 8, RULE_left = 9, RULE_stmt = 10, RULE_elseRule = 11, RULE_expr = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "rootItem", "include", "namespace", "typename", "varname", "param", 
			"funcdef", "func", "left", "stmt", "elseRule", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'#include'", "'namespace'", "'::'", "'@'", "'const'", 
			"'else'", "'for'", "'funcdef'", "'if'", "'public'", "'private'", "'return'", 
			"'while'", "'!'", "'.'", "','", "'=='", "'!='", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'<='", "'<'", "'>='", "'>'", "'++'", "'+'", "'-'", "'*'", 
			"'/'", "'&&'", "'||'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "INCLUDE", "NAMESPACE", "COL_COL", "AT", "CONST", 
			"ELSE", "FOR", "FUNCDEF", "IF", "PUBLIC", "PRIVATE", "RETURN", "WHILE", 
			"NOT", "DOT", "COMMA", "EQ_EQ", "NEQ", "EQ", "ADD_EQ", "SUB_EQ", "MUL_EQ", 
			"DIV_EQ", "LT_EQ", "LT", "GT_EQ", "GT", "ADD_ADD", "ADD", "SUB", "MUL", 
			"DIV", "AND_AND", "OR_OR", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "SEMI", "ID", "INTVAL", "HEXVAL", "REALVAL", "WS", "NL", "COMMENT", 
			"LINE_COMMENT"
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
	public String getGrammarFileName() { return "As.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AsParser.EOF, 0); }
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186097272L) != 0)) {
				{
				{
				setState(26);
				rootItem();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
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
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				include();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				namespace();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				funcdef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				func();
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
	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(AsParser.INCLUDE, 0); }
		public TerminalNode STRING() { return getToken(AsParser.STRING, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(INCLUDE);
			setState(42);
			match(STRING);
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
	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode NAMESPACE() { return getToken(AsParser.NAMESPACE, 0); }
		public List<TerminalNode> ID() { return getTokens(AsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AsParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
		public List<TerminalNode> COL_COL() { return getTokens(AsParser.COL_COL); }
		public TerminalNode COL_COL(int i) {
			return getToken(AsParser.COL_COL, i);
		}
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(NAMESPACE);
			setState(45);
			match(ID);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COL_COL) {
				{
				{
				setState(46);
				match(COL_COL);
				setState(47);
				match(ID);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(LBRACE);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186097272L) != 0)) {
				{
				{
				setState(54);
				rootItem();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AsParser.ID, 0); }
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
			setState(62);
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
		public TerminalNode ID() { return getToken(AsParser.ID, 0); }
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
			setState(64);
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
			setState(66);
			typename();
			setState(67);
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
	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode FUNCDEF() { return getToken(AsParser.FUNCDEF, 0); }
		public List<TerminalNode> ID() { return getTokens(AsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AsParser.ID, i);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(AsParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AsParser.COMMA, i);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(FUNCDEF);
			setState(70);
			match(ID);
			setState(71);
			varname();
			setState(72);
			match(LPAREN);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(73);
				match(ID);
				}
			}

			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76);
				match(COMMA);
				setState(77);
				match(ID);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(RPAREN);
			setState(84);
			match(SEMI);
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
	public static class FuncContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AsParser.COMMA, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			typename();
			setState(87);
			varname();
			setState(88);
			match(LPAREN);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(89);
				param();
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(90);
					match(COMMA);
					setState(91);
					param();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(99);
			match(RPAREN);
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COL_COL:
			case AT:
			case FOR:
			case IF:
			case RETURN:
			case WHILE:
			case ID:
				{
				setState(100);
				stmt();
				}
				break;
			case LBRACE:
				{
				setState(101);
				match(LBRACE);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186096224L) != 0)) {
					{
					{
					setState(102);
					stmt();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
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
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AsParser.COMMA, i);
		}
		public LeftCallContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftColContext extends LeftContext {
		public TerminalNode COL_COL() { return getToken(AsParser.COL_COL, 0); }
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public LeftColContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftArrContext extends LeftContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(AsParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(AsParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeftArrContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftIdContext extends LeftContext {
		public TerminalNode ID() { return getToken(AsParser.ID, 0); }
		public TerminalNode AT() { return getToken(AsParser.AT, 0); }
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
		public TerminalNode COMMA() { return getToken(AsParser.COMMA, 0); }
		public LeftCommaContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftTypeContext extends LeftContext {
		public TerminalNode ID() { return getToken(AsParser.ID, 0); }
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
		public TerminalNode DOT() { return getToken(AsParser.DOT, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_left, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new LeftIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(112);
					match(AT);
					}
				}

				setState(115);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new LeftTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(ID);
				setState(117);
				left(6);
				}
				break;
			case 3:
				{
				_localctx = new LeftColContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(COL_COL);
				setState(119);
				left(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new LeftCommaContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(122);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(123);
						match(COMMA);
						setState(124);
						left(6);
						}
						break;
					case 2:
						{
						_localctx = new LeftDotContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(125);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(126);
						match(DOT);
						setState(127);
						left(3);
						}
						break;
					case 3:
						{
						_localctx = new LeftCallContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(128);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(129);
						match(LPAREN);
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
							{
							setState(130);
							expr(0);
							setState(135);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(131);
								match(COMMA);
								setState(132);
								expr(0);
								}
								}
								setState(137);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(140);
						match(RPAREN);
						}
						break;
					case 4:
						{
						_localctx = new LeftArrContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(141);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(142);
						match(LBRACK);
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
							{
							setState(143);
							expr(0);
							}
						}

						setState(146);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class StmtForContext extends StmtContext {
		public TerminalNode FOR() { return getToken(AsParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(AsParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(AsParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
		public StmtForContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtIfContext extends StmtContext {
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public TerminalNode IF() { return getToken(AsParser.IF, 0); }
		public TerminalNode WHILE() { return getToken(AsParser.WHILE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElseRuleContext elseRule() {
			return getRuleContext(ElseRuleContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(AsParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(AsParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLeftContext extends StmtContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AsParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AsParser.EQ, 0); }
		public TerminalNode ADD_EQ() { return getToken(AsParser.ADD_EQ, 0); }
		public TerminalNode SUB_EQ() { return getToken(AsParser.SUB_EQ, 0); }
		public TerminalNode MUL_EQ() { return getToken(AsParser.MUL_EQ, 0); }
		public TerminalNode DIV_EQ() { return getToken(AsParser.DIV_EQ, 0); }
		public StmtLeftContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COL_COL:
			case AT:
			case ID:
				_localctx = new StmtLeftContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				left(0);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65011712L) != 0)) {
					{
					setState(153);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65011712L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(154);
					expr(0);
					}
				}

				setState(157);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(RETURN);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
					{
					setState(160);
					expr(0);
					}
				}

				setState(163);
				match(SEMI);
				}
				break;
			case FOR:
				_localctx = new StmtForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(FOR);
				setState(165);
				match(LPAREN);
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(166);
					stmt();
					}
					break;
				case 2:
					{
					setState(167);
					expr(0);
					}
					break;
				case 3:
					{
					setState(168);
					match(SEMI);
					}
					break;
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
					{
					setState(171);
					expr(0);
					}
				}

				setState(174);
				match(SEMI);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
					{
					setState(175);
					expr(0);
					}
				}

				setState(178);
				match(RPAREN);
				setState(188);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COL_COL:
				case AT:
				case FOR:
				case IF:
				case RETURN:
				case WHILE:
				case ID:
					{
					setState(179);
					stmt();
					}
					break;
				case LBRACE:
					{
					{
					setState(180);
					match(LBRACE);
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186096224L) != 0)) {
						{
						{
						setState(181);
						stmt();
						}
						}
						setState(186);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(187);
					match(RBRACE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case IF:
			case WHILE:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==IF || _la==WHILE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				match(LPAREN);
				setState(192);
				expr(0);
				setState(193);
				match(RPAREN);
				setState(203);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COL_COL:
				case AT:
				case FOR:
				case IF:
				case RETURN:
				case WHILE:
				case ID:
					{
					setState(194);
					stmt();
					}
					break;
				case LBRACE:
					{
					{
					setState(195);
					match(LBRACE);
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186096224L) != 0)) {
						{
						{
						setState(196);
						stmt();
						}
						}
						setState(201);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(202);
					match(RBRACE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(205);
					elseRule();
					}
					break;
				}
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
		public TerminalNode ELSE() { return getToken(AsParser.ELSE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
		public ElseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseRule; }
	}

	public final ElseRuleContext elseRule() throws RecognitionException {
		ElseRuleContext _localctx = new ElseRuleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ELSE);
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COL_COL:
			case AT:
			case FOR:
			case IF:
			case RETURN:
			case WHILE:
			case ID:
				{
				setState(211);
				stmt();
				}
				break;
			case LBRACE:
				{
				{
				setState(212);
				match(LBRACE);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186096224L) != 0)) {
					{
					{
					setState(213);
					stmt();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
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
		public TerminalNode INTVAL() { return getToken(AsParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(AsParser.HEXVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(AsParser.RAWVAL, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(AsParser.STRING, 0); }
		public ExprStrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVarContext extends ExprContext {
		public TerminalNode ID() { return getToken(AsParser.ID, 0); }
		public TerminalNode AT() { return getToken(AsParser.AT, 0); }
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
		public TerminalNode EQ_EQ() { return getToken(AsParser.EQ_EQ, 0); }
		public TerminalNode NEQ() { return getToken(AsParser.NEQ, 0); }
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLambdaContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(AsParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AsParser.RBRACE, 0); }
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
		public TerminalNode DOT() { return getToken(AsParser.DOT, 0); }
		public ExprDotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprColContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COL_COL() { return getToken(AsParser.COL_COL, 0); }
		public ExprColContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPreContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(AsParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(AsParser.NOT, 0); }
		public ExprPreContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLtContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(AsParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(AsParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(AsParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(AsParser.GT_EQ, 0); }
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
		public TerminalNode LPAREN() { return getToken(AsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AsParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AsParser.COMMA, i);
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
		public TerminalNode MUL() { return getToken(AsParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(AsParser.DIV, 0); }
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
		public TerminalNode SUB() { return getToken(AsParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(AsParser.ADD, 0); }
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
		public TerminalNode LBRACK() { return getToken(AsParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(AsParser.RBRACK, 0); }
		public ExprArrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_AND() { return getToken(AsParser.AND_AND, 0); }
		public TerminalNode OR_OR() { return getToken(AsParser.OR_OR, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPostContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ADD_ADD() { return getToken(AsParser.ADD_ADD, 0); }
		public ExprPostContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REALVAL() { return getToken(AsParser.REALVAL, 0); }
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
				match(LPAREN);
				setState(224);
				expr(0);
				setState(225);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprPreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(228);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 105553116266498L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new ExprRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(REALVAL);
				}
				break;
			case 5:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(STRING);
				}
				break;
			case 6:
				{
				_localctx = new ExprLambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(LPAREN);
				setState(233);
				match(RPAREN);
				setState(234);
				match(LBRACE);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592186096224L) != 0)) {
					{
					{
					setState(235);
					stmt();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(RBRACE);
				}
				break;
			case 7:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(242);
					match(AT);
					}
				}

				setState(245);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(290);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new ExprDotContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(249);
						match(DOT);
						setState(250);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(252);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(255);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(256);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(258);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632960L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(260);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(261);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(262);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(264);
						_la = _input.LA(1);
						if ( !(_la==AND_AND || _la==OR_OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(265);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprColContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(267);
						match(COL_COL);
						setState(268);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprPostContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						{
						setState(270);
						match(ADD_ADD);
						}
						}
						break;
					case 9:
						{
						_localctx = new ExprArrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(272);
						match(LBRACK);
						setState(274);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
							{
							setState(273);
							expr(0);
							}
						}

						setState(276);
						match(RBRACK);
						}
						break;
					case 10:
						{
						_localctx = new ExprCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						match(LPAREN);
						setState(287);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264024524652614L) != 0)) {
							{
							setState(279);
							expr(0);
							setState(284);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(280);
								match(COMMA);
								setState(281);
								expr(0);
								}
								}
								setState(286);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(289);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		case 9:
			return left_sempred((LeftContext)_localctx, predIndex);
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean left_sempred(LeftContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u0128\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00031\b"+
		"\u0003\n\u0003\f\u00034\t\u0003\u0001\u0003\u0001\u0003\u0005\u00038\b"+
		"\u0003\n\u0003\f\u0003;\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007K\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007O\b\u0007\n\u0007\f\u0007R\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b]\b\b\n\b\f\b`\t\b\u0003\bb\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\bh\b\b\n\b\f\bk\t\b\u0001\b\u0003\bn\b\b\u0001"+
		"\t\u0001\t\u0003\tr\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\ty\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u0086\b\t\n\t\f\t\u0089\t\t\u0003\t"+
		"\u008b\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0091\b\t\u0001\t\u0005"+
		"\t\u0094\b\t\n\t\f\t\u0097\t\t\u0001\n\u0001\n\u0001\n\u0003\n\u009c\b"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a2\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00aa\b\n\u0001\n\u0003\n\u00ad\b\n"+
		"\u0001\n\u0001\n\u0003\n\u00b1\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00b7\b\n\n\n\f\n\u00ba\t\n\u0001\n\u0003\n\u00bd\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00c6\b\n\n\n\f\n\u00c9"+
		"\t\n\u0001\n\u0003\n\u00cc\b\n\u0001\n\u0003\n\u00cf\b\n\u0003\n\u00d1"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d7"+
		"\b\u000b\n\u000b\f\u000b\u00da\t\u000b\u0001\u000b\u0003\u000b\u00dd\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ed\b\f\n\f"+
		"\f\f\u00f0\t\f\u0001\f\u0001\f\u0003\f\u00f4\b\f\u0001\f\u0003\f\u00f7"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0113\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u011b"+
		"\b\f\n\f\f\f\u011e\t\f\u0003\f\u0120\b\f\u0001\f\u0005\f\u0123\b\f\n\f"+
		"\f\f\u0126\t\f\u0001\f\u0000\u0002\u0012\u0018\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\t\u0001\u0000\u0015\u0019"+
		"\u0002\u0000\u000b\u000b\u000f\u000f\u0002\u0000\u0010\u0010  \u0002\u0000"+
		"\u0001\u0001-.\u0001\u0000!\"\u0001\u0000\u001f \u0001\u0000\u001a\u001d"+
		"\u0001\u0000\u0013\u0014\u0001\u0000#$\u0156\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000"+
		"\u0006,\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\n@\u0001\u0000"+
		"\u0000\u0000\fB\u0001\u0000\u0000\u0000\u000eE\u0001\u0000\u0000\u0000"+
		"\u0010V\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000\u0000\u0014\u00d0"+
		"\u0001\u0000\u0000\u0000\u0016\u00d2\u0001\u0000\u0000\u0000\u0018\u00f6"+
		"\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0005\u0000\u0000"+
		"\u0001!\u0001\u0001\u0000\u0000\u0000\"(\u0003\u0004\u0002\u0000#(\u0003"+
		"\u0006\u0003\u0000$(\u0003\u0014\n\u0000%(\u0003\u000e\u0007\u0000&(\u0003"+
		"\u0010\b\u0000\'\"\u0001\u0000\u0000\u0000\'#\u0001\u0000\u0000\u0000"+
		"\'$\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001\u0000"+
		"\u0000\u0000(\u0003\u0001\u0000\u0000\u0000)*\u0005\u0003\u0000\u0000"+
		"*+\u0005\u0002\u0000\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0005\u0004"+
		"\u0000\u0000-2\u0005,\u0000\u0000./\u0005\u0005\u0000\u0000/1\u0005,\u0000"+
		"\u00000.\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000059\u0005)\u0000\u000068\u0003\u0002\u0001\u000076\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000<=\u0005*\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005,\u0000"+
		"\u0000?\t\u0001\u0000\u0000\u0000@A\u0005,\u0000\u0000A\u000b\u0001\u0000"+
		"\u0000\u0000BC\u0003\b\u0004\u0000CD\u0003\n\u0005\u0000D\r\u0001\u0000"+
		"\u0000\u0000EF\u0005\n\u0000\u0000FG\u0005,\u0000\u0000GH\u0003\n\u0005"+
		"\u0000HJ\u0005%\u0000\u0000IK\u0005,\u0000\u0000JI\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KP\u0001\u0000\u0000\u0000LM\u0005\u0012\u0000"+
		"\u0000MO\u0005,\u0000\u0000NL\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0005&\u0000\u0000TU\u0005+\u0000"+
		"\u0000U\u000f\u0001\u0000\u0000\u0000VW\u0003\b\u0004\u0000WX\u0003\n"+
		"\u0005\u0000Xa\u0005%\u0000\u0000Y^\u0003\f\u0006\u0000Z[\u0005\u0012"+
		"\u0000\u0000[]\u0003\f\u0006\u0000\\Z\u0001\u0000\u0000\u0000]`\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000aY\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cm\u0005&\u0000"+
		"\u0000dn\u0003\u0014\n\u0000ei\u0005)\u0000\u0000fh\u0003\u0014\n\u0000"+
		"gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000ln\u0005*\u0000\u0000md\u0001\u0000\u0000\u0000me\u0001\u0000"+
		"\u0000\u0000n\u0011\u0001\u0000\u0000\u0000oq\u0006\t\uffff\uffff\u0000"+
		"pr\u0005\u0006\u0000\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000sy\u0005,\u0000\u0000tu\u0005,\u0000\u0000"+
		"uy\u0003\u0012\t\u0006vw\u0005\u0005\u0000\u0000wy\u0003\u0012\t\u0001"+
		"xo\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000y\u0095\u0001\u0000\u0000\u0000z{\n\u0005\u0000\u0000{|\u0005\u0012"+
		"\u0000\u0000|\u0094\u0003\u0012\t\u0006}~\n\u0002\u0000\u0000~\u007f\u0005"+
		"\u0011\u0000\u0000\u007f\u0094\u0003\u0012\t\u0003\u0080\u0081\n\u0004"+
		"\u0000\u0000\u0081\u008a\u0005%\u0000\u0000\u0082\u0087\u0003\u0018\f"+
		"\u0000\u0083\u0084\u0005\u0012\u0000\u0000\u0084\u0086\u0003\u0018\f\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u0082\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0094\u0005&\u0000\u0000\u008d"+
		"\u008e\n\u0003\u0000\u0000\u008e\u0090\u0005\'\u0000\u0000\u008f\u0091"+
		"\u0003\u0018\f\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0005"+
		"(\u0000\u0000\u0093z\u0001\u0000\u0000\u0000\u0093}\u0001\u0000\u0000"+
		"\u0000\u0093\u0080\u0001\u0000\u0000\u0000\u0093\u008d\u0001\u0000\u0000"+
		"\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0013\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u009b\u0003\u0012\t\u0000"+
		"\u0099\u009a\u0007\u0000\u0000\u0000\u009a\u009c\u0003\u0018\f\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005+\u0000\u0000\u009e\u00d1"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0005\u000e\u0000\u0000\u00a0\u00a2"+
		"\u0003\u0018\f\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00d1\u0005"+
		"+\u0000\u0000\u00a4\u00a5\u0005\t\u0000\u0000\u00a5\u00a9\u0005%\u0000"+
		"\u0000\u00a6\u00aa\u0003\u0014\n\u0000\u00a7\u00aa\u0003\u0018\f\u0000"+
		"\u00a8\u00aa\u0005+\u0000\u0000\u00a9\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003\u0018\f\u0000\u00ac\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005+\u0000\u0000\u00af\u00b1\u0003"+
		"\u0018\f\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00bc\u0005&\u0000"+
		"\u0000\u00b3\u00bd\u0003\u0014\n\u0000\u00b4\u00b8\u0005)\u0000\u0000"+
		"\u00b5\u00b7\u0003\u0014\n\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7"+
		"\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b8\u0001\u0000\u0000\u0000\u00bb\u00bd\u0005*\u0000\u0000\u00bc\u00b3"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b4\u0001\u0000\u0000\u0000\u00bd\u00d1"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0007\u0001\u0000\u0000\u00bf\u00c0"+
		"\u0005%\u0000\u0000\u00c0\u00c1\u0003\u0018\f\u0000\u00c1\u00cb\u0005"+
		"&\u0000\u0000\u00c2\u00cc\u0003\u0014\n\u0000\u00c3\u00c7\u0005)\u0000"+
		"\u0000\u00c4\u00c6\u0003\u0014\n\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cc\u0005*\u0000\u0000\u00cb"+
		"\u00c2\u0001\u0000\u0000\u0000\u00cb\u00c3\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cf\u0003\u0016\u000b\u0000\u00ce"+
		"\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d0\u0098\u0001\u0000\u0000\u0000\u00d0"+
		"\u009f\u0001\u0000\u0000\u0000\u00d0\u00a4\u0001\u0000\u0000\u0000\u00d0"+
		"\u00be\u0001\u0000\u0000\u0000\u00d1\u0015\u0001\u0000\u0000\u0000\u00d2"+
		"\u00dc\u0005\b\u0000\u0000\u00d3\u00dd\u0003\u0014\n\u0000\u00d4\u00d8"+
		"\u0005)\u0000\u0000\u00d5\u00d7\u0003\u0014\n\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dd\u0005"+
		"*\u0000\u0000\u00dc\u00d3\u0001\u0000\u0000\u0000\u00dc\u00d4\u0001\u0000"+
		"\u0000\u0000\u00dd\u0017\u0001\u0000\u0000\u0000\u00de\u00df\u0006\f\uffff"+
		"\uffff\u0000\u00df\u00e0\u0005%\u0000\u0000\u00e0\u00e1\u0003\u0018\f"+
		"\u0000\u00e1\u00e2\u0005&\u0000\u0000\u00e2\u00f7\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0007\u0002\u0000\u0000\u00e4\u00f7\u0003\u0018\f\u000f\u00e5"+
		"\u00f7\u0007\u0003\u0000\u0000\u00e6\u00f7\u0005/\u0000\u0000\u00e7\u00f7"+
		"\u0005\u0002\u0000\u0000\u00e8\u00e9\u0005%\u0000\u0000\u00e9\u00ea\u0005"+
		"&\u0000\u0000\u00ea\u00ee\u0005)\u0000\u0000\u00eb\u00ed\u0003\u0014\n"+
		"\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f7\u0005*\u0000\u0000\u00f2\u00f4\u0005\u0006\u0000\u0000"+
		"\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f7\u0005,\u0000\u0000\u00f6"+
		"\u00de\u0001\u0000\u0000\u0000\u00f6\u00e3\u0001\u0000\u0000\u0000\u00f6"+
		"\u00e5\u0001\u0000\u0000\u0000\u00f6\u00e6\u0001\u0000\u0000\u0000\u00f6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00f6\u00e8\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f7\u0124\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\n\u0011\u0000\u0000\u00f9\u00fa\u0005\u0011\u0000\u0000\u00fa\u0123"+
		"\u0003\u0018\f\u0012\u00fb\u00fc\n\r\u0000\u0000\u00fc\u00fd\u0007\u0004"+
		"\u0000\u0000\u00fd\u0123\u0003\u0018\f\u000e\u00fe\u00ff\n\f\u0000\u0000"+
		"\u00ff\u0100\u0007\u0005\u0000\u0000\u0100\u0123\u0003\u0018\f\r\u0101"+
		"\u0102\n\u000b\u0000\u0000\u0102\u0103\u0007\u0006\u0000\u0000\u0103\u0123"+
		"\u0003\u0018\f\f\u0104\u0105\n\n\u0000\u0000\u0105\u0106\u0007\u0007\u0000"+
		"\u0000\u0106\u0123\u0003\u0018\f\u000b\u0107\u0108\n\t\u0000\u0000\u0108"+
		"\u0109\u0007\b\u0000\u0000\u0109\u0123\u0003\u0018\f\n\u010a\u010b\n\b"+
		"\u0000\u0000\u010b\u010c\u0005\u0005\u0000\u0000\u010c\u0123\u0003\u0018"+
		"\f\t\u010d\u010e\n\u000e\u0000\u0000\u010e\u0123\u0005\u001e\u0000\u0000"+
		"\u010f\u0110\n\u0004\u0000\u0000\u0110\u0112\u0005\'\u0000\u0000\u0111"+
		"\u0113\u0003\u0018\f\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0123"+
		"\u0005(\u0000\u0000\u0115\u0116\n\u0003\u0000\u0000\u0116\u011f\u0005"+
		"%\u0000\u0000\u0117\u011c\u0003\u0018\f\u0000\u0118\u0119\u0005\u0012"+
		"\u0000\u0000\u0119\u011b\u0003\u0018\f\u0000\u011a\u0118\u0001\u0000\u0000"+
		"\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000"+
		"\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0117\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000"+
		"\u0000\u0121\u0123\u0005&\u0000\u0000\u0122\u00f8\u0001\u0000\u0000\u0000"+
		"\u0122\u00fb\u0001\u0000\u0000\u0000\u0122\u00fe\u0001\u0000\u0000\u0000"+
		"\u0122\u0101\u0001\u0000\u0000\u0000\u0122\u0104\u0001\u0000\u0000\u0000"+
		"\u0122\u0107\u0001\u0000\u0000\u0000\u0122\u010a\u0001\u0000\u0000\u0000"+
		"\u0122\u010d\u0001\u0000\u0000\u0000\u0122\u010f\u0001\u0000\u0000\u0000"+
		"\u0122\u0115\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000"+
		"\u0125\u0019\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"&\u001d\'29JP^aimqx\u0087\u008a\u0090\u0093\u0095\u009b\u00a1\u00a9\u00ac"+
		"\u00b0\u00b8\u00bc\u00c7\u00cb\u00ce\u00d0\u00d8\u00dc\u00ee\u00f3\u00f6"+
		"\u0112\u011c\u011f\u0122\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
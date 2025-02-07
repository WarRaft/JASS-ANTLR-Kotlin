// Generated from io/github/warraft/Vjass.g4 by ANTLR 4.13.2
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
public class VjassParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RAWVAL=1, STRING=2, AND=3, ARRAY=4, CALL=5, CONSTANT=6, DEBUG=7, ELSE=8, 
		ELSEIF=9, ENDFUNCTION=10, ENDIF=11, ENDLOOP=12, ENDGLOBALS=13, ENDLIBRARY=14, 
		EXTENDS=15, EXITWHEN=16, FALSE=17, FUNCTION=18, GLOBALS=19, IF=20, INITIALIZER=21, 
		LIBRARY=22, LOCAL=23, LOOP=24, NATIVE=25, NOT=26, NOTHING=27, NULL=28, 
		OR=29, PUBLIC=30, PRIVATE=31, RETURNS=32, RETURN=33, SET=34, TAKES=35, 
		THEN=36, TRUE=37, TYPE=38, USES=39, COMMA=40, EQ_EQ=41, EQ=42, NEQ=43, 
		LT_EQ=44, LT=45, GT_EQ=46, GT=47, PLUS=48, MINUS=49, MUL=50, DIV=51, LPAREN=52, 
		RPAREN=53, LBRACK=54, RBRACK=55, ID=56, INTVAL=57, HEXVAL=58, REALVAL=59, 
		WS=60, NL=61, COMMENT=62, LINE_COMMENT=63;
	public static final int
		RULE_root = 0, RULE_library = 1, RULE_rootItem = 2, RULE_typename = 3, 
		RULE_varname = 4, RULE_globals = 5, RULE_variable = 6, RULE_param = 7, 
		RULE_params = 8, RULE_takes = 9, RULE_returnsRule = 10, RULE_nativeRule = 11, 
		RULE_function = 12, RULE_stmt = 13, RULE_brackExpr = 14, RULE_set = 15, 
		RULE_call = 16, RULE_returnRule = 17, RULE_ifRule = 18, RULE_elseif = 19, 
		RULE_elseRule = 20, RULE_loop = 21, RULE_exitwhen = 22, RULE_expr = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "library", "rootItem", "typename", "varname", "globals", "variable", 
			"param", "params", "takes", "returnsRule", "nativeRule", "function", 
			"stmt", "brackExpr", "set", "call", "returnRule", "ifRule", "elseif", 
			"elseRule", "loop", "exitwhen", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'and'", "'array'", "'call'", "'constant'", "'debug'", 
			"'else'", "'elseif'", "'endfunction'", "'endif'", "'endloop'", "'endglobals'", 
			"'endlibrary'", "'extends'", "'exitwhen'", "'false'", "'function'", "'globals'", 
			"'if'", "'initializer'", "'library'", "'local'", "'loop'", "'native'", 
			"'not'", "'nothing'", "'null'", "'or'", "'public'", "'private'", "'returns'", 
			"'return'", "'set'", "'takes'", "'then'", "'true'", "'type'", "'uses'", 
			"','", "'=='", "'='", "'!='", "'<='", "'<'", "'>='", "'>'", "'+'", "'-'", 
			"'*'", "'/'", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "AND", "ARRAY", "CALL", "CONSTANT", "DEBUG", 
			"ELSE", "ELSEIF", "ENDFUNCTION", "ENDIF", "ENDLOOP", "ENDGLOBALS", "ENDLIBRARY", 
			"EXTENDS", "EXITWHEN", "FALSE", "FUNCTION", "GLOBALS", "IF", "INITIALIZER", 
			"LIBRARY", "LOCAL", "LOOP", "NATIVE", "NOT", "NOTHING", "NULL", "OR", 
			"PUBLIC", "PRIVATE", "RETURNS", "RETURN", "SET", "TAKES", "THEN", "TRUE", 
			"TYPE", "USES", "COMMA", "EQ_EQ", "EQ", "NEQ", "LT_EQ", "LT", "GT_EQ", 
			"GT", "PLUS", "MINUS", "MUL", "DIV", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
			"ID", "INTVAL", "HEXVAL", "REALVAL", "WS", "NL", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Vjass.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VjassParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(VjassParser.EOF, 0); }
		public List<LibraryContext> library() {
			return getRuleContexts(LibraryContext.class);
		}
		public LibraryContext library(int i) {
			return getRuleContext(LibraryContext.class,i);
		}
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
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3259760704L) != 0)) {
				{
				setState(50);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LIBRARY:
					{
					setState(48);
					library();
					}
					break;
				case CONSTANT:
				case FUNCTION:
				case GLOBALS:
				case NATIVE:
				case PUBLIC:
				case PRIVATE:
					{
					setState(49);
					rootItem();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
	public static class LibraryContext extends ParserRuleContext {
		public TerminalNode LIBRARY() { return getToken(VjassParser.LIBRARY, 0); }
		public List<TerminalNode> ID() { return getTokens(VjassParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(VjassParser.ID, i);
		}
		public TerminalNode ENDLIBRARY() { return getToken(VjassParser.ENDLIBRARY, 0); }
		public TerminalNode INITIALIZER() { return getToken(VjassParser.INITIALIZER, 0); }
		public TerminalNode USES() { return getToken(VjassParser.USES, 0); }
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VjassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VjassParser.COMMA, i);
		}
		public LibraryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_library; }
	}

	public final LibraryContext library() throws RecognitionException {
		LibraryContext _localctx = new LibraryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_library);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LIBRARY);
			setState(58);
			match(ID);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIALIZER) {
				{
				setState(59);
				match(INITIALIZER);
				setState(60);
				match(ID);
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USES) {
				{
				setState(63);
				match(USES);
				setState(64);
				match(ID);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(65);
					match(COMMA);
					setState(66);
					match(ID);
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3255566400L) != 0)) {
				{
				{
				setState(74);
				rootItem();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(ENDLIBRARY);
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
		public NativeRuleContext nativeRule() {
			return getRuleContext(NativeRuleContext.class,0);
		}
		public GlobalsContext globals() {
			return getRuleContext(GlobalsContext.class,0);
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
		enterRule(_localctx, 4, RULE_rootItem);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				nativeRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				globals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
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
	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
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
	public static class GlobalsContext extends ParserRuleContext {
		public TerminalNode GLOBALS() { return getToken(VjassParser.GLOBALS, 0); }
		public TerminalNode ENDGLOBALS() { return getToken(VjassParser.ENDGLOBALS, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public GlobalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globals; }
	}

	public final GlobalsContext globals() throws RecognitionException {
		GlobalsContext _localctx = new GlobalsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_globals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(GLOBALS);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057597267542080L) != 0)) {
				{
				{
				setState(92);
				variable();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(ENDGLOBALS);
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
	public static class VariableContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(VjassParser.CONSTANT, 0); }
		public TerminalNode LOCAL() { return getToken(VjassParser.LOCAL, 0); }
		public TerminalNode ARRAY() { return getToken(VjassParser.ARRAY, 0); }
		public List<BrackExprContext> brackExpr() {
			return getRuleContexts(BrackExprContext.class);
		}
		public BrackExprContext brackExpr(int i) {
			return getRuleContext(BrackExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(VjassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(VjassParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(VjassParser.PRIVATE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(100);
				_la = _input.LA(1);
				if ( !(_la==PUBLIC || _la==PRIVATE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(103);
				match(CONSTANT);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(106);
				match(LOCAL);
				}
			}

			setState(109);
			typename();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARRAY) {
				{
				setState(110);
				match(ARRAY);
				}
			}

			setState(113);
			varname();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(114);
				brackExpr();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(120);
				match(EQ);
				setState(121);
				expr(0);
				}
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
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			typename();
			setState(125);
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
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VjassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VjassParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			param();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(128);
				match(COMMA);
				setState(129);
				param();
				}
				}
				setState(134);
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
	public static class TakesContext extends ParserRuleContext {
		public TerminalNode TAKES() { return getToken(VjassParser.TAKES, 0); }
		public TerminalNode NOTHING() { return getToken(VjassParser.NOTHING, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TakesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_takes; }
	}

	public final TakesContext takes() throws RecognitionException {
		TakesContext _localctx = new TakesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_takes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(TAKES);
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(136);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(137);
				params();
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
	public static class ReturnsRuleContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(VjassParser.RETURNS, 0); }
		public TerminalNode NOTHING() { return getToken(VjassParser.NOTHING, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public ReturnsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsRule; }
	}

	public final ReturnsRuleContext returnsRule() throws RecognitionException {
		ReturnsRuleContext _localctx = new ReturnsRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnsRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(RETURNS);
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==NOTHING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class NativeRuleContext extends ParserRuleContext {
		public TerminalNode NATIVE() { return getToken(VjassParser.NATIVE, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public ReturnsRuleContext returnsRule() {
			return getRuleContext(ReturnsRuleContext.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(VjassParser.CONSTANT, 0); }
		public NativeRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeRule; }
	}

	public final NativeRuleContext nativeRule() throws RecognitionException {
		NativeRuleContext _localctx = new NativeRuleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nativeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(143);
				match(CONSTANT);
				}
			}

			setState(146);
			match(NATIVE);
			setState(147);
			match(ID);
			setState(148);
			takes();
			setState(149);
			returnsRule();
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
		public TerminalNode FUNCTION() { return getToken(VjassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public ReturnsRuleContext returnsRule() {
			return getRuleContext(ReturnsRuleContext.class,0);
		}
		public TerminalNode ENDFUNCTION() { return getToken(VjassParser.ENDFUNCTION, 0); }
		public TerminalNode CONSTANT() { return getToken(VjassParser.CONSTANT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode PUBLIC() { return getToken(VjassParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(VjassParser.PRIVATE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==PUBLIC || _la==PRIVATE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(154);
				match(CONSTANT);
				}
			}

			setState(157);
			match(FUNCTION);
			setState(158);
			match(ID);
			setState(159);
			takes();
			setState(160);
			returnsRule();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72057597267542080L) != 0)) {
				{
				{
				setState(161);
				variable();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25787695264L) != 0)) {
				{
				{
				setState(167);
				stmt();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(ENDFUNCTION);
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
		public IfRuleContext ifRule() {
			return getRuleContext(IfRuleContext.class,0);
		}
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtCallContext extends StmtContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public StmtCallContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtExitWhenContext extends StmtContext {
		public ExitwhenContext exitwhen() {
			return getRuleContext(ExitwhenContext.class,0);
		}
		public StmtExitWhenContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLoopContext extends StmtContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public StmtLoopContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtSetContext extends StmtContext {
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public StmtSetContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public ReturnRuleContext returnRule() {
			return getRuleContext(ReturnRuleContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				_localctx = new StmtSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				set();
				}
				break;
			case CALL:
			case DEBUG:
				_localctx = new StmtCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				call();
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				returnRule();
				}
				break;
			case IF:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				ifRule();
				}
				break;
			case LOOP:
				_localctx = new StmtLoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				loop();
				}
				break;
			case EXITWHEN:
				_localctx = new StmtExitWhenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				exitwhen();
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
	public static class BrackExprContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(VjassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(VjassParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BrackExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brackExpr; }
	}

	public final BrackExprContext brackExpr() throws RecognitionException {
		BrackExprContext _localctx = new BrackExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_brackExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(LBRACK);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1085930597924601862L) != 0)) {
				{
				setState(184);
				expr(0);
				}
			}

			setState(187);
			match(RBRACK);
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
	public static class SetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(VjassParser.SET, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TerminalNode EQ() { return getToken(VjassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BrackExprContext brackExpr() {
			return getRuleContext(BrackExprContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(SET);
			setState(190);
			match(ID);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(191);
				brackExpr();
				}
			}

			setState(194);
			match(EQ);
			setState(195);
			expr(0);
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
	public static class CallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(VjassParser.CALL, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(VjassParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VjassParser.RPAREN, 0); }
		public TerminalNode DEBUG() { return getToken(VjassParser.DEBUG, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VjassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VjassParser.COMMA, i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEBUG) {
				{
				setState(197);
				match(DEBUG);
				}
			}

			setState(200);
			match(CALL);
			setState(201);
			match(ID);
			setState(202);
			match(LPAREN);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1085930597924601862L) != 0)) {
				{
				setState(203);
				expr(0);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(204);
					match(COMMA);
					setState(205);
					expr(0);
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(213);
			match(RPAREN);
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
	public static class ReturnRuleContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(VjassParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnRule; }
	}

	public final ReturnRuleContext returnRule() throws RecognitionException {
		ReturnRuleContext _localctx = new ReturnRuleContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(RETURN);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1085930597924601862L) != 0)) {
				{
				setState(216);
				expr(0);
				}
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
	public static class IfRuleContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(VjassParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(VjassParser.THEN, 0); }
		public TerminalNode ENDIF() { return getToken(VjassParser.ENDIF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<ElseifContext> elseif() {
			return getRuleContexts(ElseifContext.class);
		}
		public ElseifContext elseif(int i) {
			return getRuleContext(ElseifContext.class,i);
		}
		public ElseRuleContext elseRule() {
			return getRuleContext(ElseRuleContext.class,0);
		}
		public IfRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifRule; }
	}

	public final IfRuleContext ifRule() throws RecognitionException {
		IfRuleContext _localctx = new IfRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(IF);
			setState(220);
			expr(0);
			setState(221);
			match(THEN);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25787695264L) != 0)) {
				{
				{
				setState(222);
				stmt();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(228);
				elseif();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(234);
				elseRule();
				}
			}

			setState(237);
			match(ENDIF);
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
	public static class ElseifContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(VjassParser.ELSEIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(VjassParser.THEN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(ELSEIF);
			setState(240);
			expr(0);
			setState(241);
			match(THEN);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25787695264L) != 0)) {
				{
				{
				setState(242);
				stmt();
				}
				}
				setState(247);
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
	public static class ElseRuleContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(VjassParser.ELSE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElseRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseRule; }
	}

	public final ElseRuleContext elseRule() throws RecognitionException {
		ElseRuleContext _localctx = new ElseRuleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(ELSE);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25787695264L) != 0)) {
				{
				{
				setState(249);
				stmt();
				}
				}
				setState(254);
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
	public static class LoopContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(VjassParser.LOOP, 0); }
		public TerminalNode ENDLOOP() { return getToken(VjassParser.ENDLOOP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(LOOP);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25787695264L) != 0)) {
				{
				{
				setState(256);
				stmt();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
			match(ENDLOOP);
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
	public static class ExitwhenContext extends ParserRuleContext {
		public TerminalNode EXITWHEN() { return getToken(VjassParser.EXITWHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExitwhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitwhen; }
	}

	public final ExitwhenContext exitwhen() throws RecognitionException {
		ExitwhenContext _localctx = new ExitwhenContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exitwhen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(EXITWHEN);
			setState(265);
			expr(0);
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
		public TerminalNode INTVAL() { return getToken(VjassParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(VjassParser.HEXVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(VjassParser.RAWVAL, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(VjassParser.STRING, 0); }
		public ExprStrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(VjassParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(VjassParser.NOT, 0); }
		public ExprUnContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVarContext extends ExprContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
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
		public TerminalNode EQ_EQ() { return getToken(VjassParser.EQ_EQ, 0); }
		public TerminalNode NEQ() { return getToken(VjassParser.NEQ, 0); }
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(VjassParser.NULL, 0); }
		public ExprNullContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFunContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(VjassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public ExprFunContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(VjassParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VjassParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(VjassParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VjassParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(VjassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VjassParser.COMMA, i);
		}
		public ExprCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLtContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(VjassParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(VjassParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(VjassParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(VjassParser.GT_EQ, 0); }
		public ExprLtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMulContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(VjassParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(VjassParser.DIV, 0); }
		public ExprMulContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprArrContext extends ExprContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(VjassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(VjassParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprArrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(VjassParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(VjassParser.PLUS, 0); }
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(VjassParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(VjassParser.FALSE, 0); }
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
		public TerminalNode AND() { return getToken(VjassParser.AND, 0); }
		public TerminalNode OR() { return getToken(VjassParser.OR, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REALVAL() { return getToken(VjassParser.REALVAL, 0); }
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(268);
				match(LPAREN);
				setState(269);
				expr(0);
				setState(270);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(273);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
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
				setState(276);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 432345564227567618L) != 0)) ) {
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
				setState(277);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(ID);
				setState(280);
				match(LBRACK);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1085930597924601862L) != 0)) {
					{
					setState(281);
					expr(0);
					}
				}

				setState(284);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(ID);
				setState(286);
				match(LPAREN);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1085930597924601862L) != 0)) {
					{
					setState(287);
					expr(0);
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(288);
						match(COMMA);
						setState(289);
						expr(0);
						}
						}
						setState(294);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(297);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(FUNCTION);
				setState(299);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(318);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(304);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(305);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(310);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(311);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(312);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(313);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(314);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(315);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(316);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(317);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u0144\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001D\b\u0001"+
		"\n\u0001\f\u0001G\t\u0001\u0003\u0001I\b\u0001\u0001\u0001\u0005\u0001"+
		"L\b\u0001\n\u0001\f\u0001O\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002V\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005^\b\u0005"+
		"\n\u0005\f\u0005a\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006"+
		"f\b\u0006\u0001\u0006\u0003\u0006i\b\u0006\u0001\u0006\u0003\u0006l\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006t\b\u0006\n\u0006\f\u0006w\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006{\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0083\b\b\n\b\f\b\u0086\t\b\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u008b\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0003\u000b"+
		"\u0091\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0003\f\u0099\b\f\u0001\f\u0003\f\u009c\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00a3\b\f\n\f\f\f\u00a6\t\f\u0001\f\u0005\f"+
		"\u00a9\b\f\n\f\f\f\u00ac\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00b6\b\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00ba\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00c1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0003\u0010\u00c7\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00cf\b\u0010\n\u0010\f\u0010\u00d2"+
		"\t\u0010\u0003\u0010\u00d4\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00da\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u00e0\b\u0012\n\u0012\f\u0012\u00e3\t\u0012\u0001"+
		"\u0012\u0005\u0012\u00e6\b\u0012\n\u0012\f\u0012\u00e9\t\u0012\u0001\u0012"+
		"\u0003\u0012\u00ec\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00f4\b\u0013\n\u0013\f\u0013\u00f7"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u00fb\b\u0014\n\u0014\f\u0014"+
		"\u00fe\t\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0102\b\u0015\n\u0015"+
		"\f\u0015\u0105\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u011b\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u0123\b\u0017\n\u0017\f\u0017\u0126\t\u0017\u0003\u0017\u0128"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u012e"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u013f\b\u0017\n"+
		"\u0017\f\u0017\u0142\t\u0017\u0001\u0017\u0000\u0001.\u0018\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.\u0000\n\u0001\u0000\u001e\u001f\u0002\u0000\u001b\u001b88\u0002"+
		"\u0000\u001a\u001a11\u0002\u0000\u0011\u0011%%\u0002\u0000\u0001\u0001"+
		"9:\u0001\u000023\u0001\u000001\u0001\u0000,/\u0002\u0000))++\u0002\u0000"+
		"\u0003\u0003\u001d\u001d\u0164\u00004\u0001\u0000\u0000\u0000\u00029\u0001"+
		"\u0000\u0000\u0000\u0004U\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000"+
		"\u0000\bY\u0001\u0000\u0000\u0000\n[\u0001\u0000\u0000\u0000\fe\u0001"+
		"\u0000\u0000\u0000\u000e|\u0001\u0000\u0000\u0000\u0010\u007f\u0001\u0000"+
		"\u0000\u0000\u0012\u0087\u0001\u0000\u0000\u0000\u0014\u008c\u0001\u0000"+
		"\u0000\u0000\u0016\u0090\u0001\u0000\u0000\u0000\u0018\u0098\u0001\u0000"+
		"\u0000\u0000\u001a\u00b5\u0001\u0000\u0000\u0000\u001c\u00b7\u0001\u0000"+
		"\u0000\u0000\u001e\u00bd\u0001\u0000\u0000\u0000 \u00c6\u0001\u0000\u0000"+
		"\u0000\"\u00d7\u0001\u0000\u0000\u0000$\u00db\u0001\u0000\u0000\u0000"+
		"&\u00ef\u0001\u0000\u0000\u0000(\u00f8\u0001\u0000\u0000\u0000*\u00ff"+
		"\u0001\u0000\u0000\u0000,\u0108\u0001\u0000\u0000\u0000.\u012d\u0001\u0000"+
		"\u0000\u000003\u0003\u0002\u0001\u000013\u0003\u0004\u0002\u000020\u0001"+
		"\u0000\u0000\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000078\u0005\u0000\u0000\u00018\u0001\u0001"+
		"\u0000\u0000\u00009:\u0005\u0016\u0000\u0000:=\u00058\u0000\u0000;<\u0005"+
		"\u0015\u0000\u0000<>\u00058\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>H\u0001\u0000\u0000\u0000?@\u0005\'\u0000\u0000@E\u0005"+
		"8\u0000\u0000AB\u0005(\u0000\u0000BD\u00058\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"H?\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IM\u0001\u0000\u0000"+
		"\u0000JL\u0003\u0004\u0002\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001"+
		"\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\u000e\u0000\u0000"+
		"Q\u0003\u0001\u0000\u0000\u0000RV\u0003\u0016\u000b\u0000SV\u0003\n\u0005"+
		"\u0000TV\u0003\u0018\f\u0000UR\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UT\u0001\u0000\u0000\u0000V\u0005\u0001\u0000\u0000\u0000WX\u0005"+
		"8\u0000\u0000X\u0007\u0001\u0000\u0000\u0000YZ\u00058\u0000\u0000Z\t\u0001"+
		"\u0000\u0000\u0000[_\u0005\u0013\u0000\u0000\\^\u0003\f\u0006\u0000]\\"+
		"\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000bc\u0005\r\u0000\u0000c\u000b\u0001\u0000\u0000\u0000df\u0007"+
		"\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"fh\u0001\u0000\u0000\u0000gi\u0005\u0006\u0000\u0000hg\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jl\u0005\u0017"+
		"\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mo\u0003\u0006\u0003\u0000np\u0005\u0004\u0000\u0000"+
		"on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qu\u0003\b\u0004\u0000rt\u0003\u001c\u000e\u0000sr\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vz\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0005"+
		"*\u0000\u0000y{\u0003.\u0017\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{\r\u0001\u0000\u0000\u0000|}\u0003\u0006\u0003\u0000}~\u0003"+
		"\b\u0004\u0000~\u000f\u0001\u0000\u0000\u0000\u007f\u0084\u0003\u000e"+
		"\u0007\u0000\u0080\u0081\u0005(\u0000\u0000\u0081\u0083\u0003\u000e\u0007"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000"+
		"\u0000\u0085\u0011\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0087\u008a\u0005#\u0000\u0000\u0088\u008b\u0005\u001b\u0000\u0000"+
		"\u0089\u008b\u0003\u0010\b\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u0089\u0001\u0000\u0000\u0000\u008b\u0013\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005 \u0000\u0000\u008d\u008e\u0007\u0001\u0000\u0000\u008e\u0015"+
		"\u0001\u0000\u0000\u0000\u008f\u0091\u0005\u0006\u0000\u0000\u0090\u008f"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0019\u0000\u0000\u0093\u0094"+
		"\u00058\u0000\u0000\u0094\u0095\u0003\u0012\t\u0000\u0095\u0096\u0003"+
		"\u0014\n\u0000\u0096\u0017\u0001\u0000\u0000\u0000\u0097\u0099\u0007\u0000"+
		"\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u009c\u0005\u0006"+
		"\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0012"+
		"\u0000\u0000\u009e\u009f\u00058\u0000\u0000\u009f\u00a0\u0003\u0012\t"+
		"\u0000\u00a0\u00a4\u0003\u0014\n\u0000\u00a1\u00a3\u0003\f\u0006\u0000"+
		"\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00aa\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a9\u0003\u001a\r\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\n\u0000\u0000\u00ae\u0019"+
		"\u0001\u0000\u0000\u0000\u00af\u00b6\u0003\u001e\u000f\u0000\u00b0\u00b6"+
		"\u0003 \u0010\u0000\u00b1\u00b6\u0003\"\u0011\u0000\u00b2\u00b6\u0003"+
		"$\u0012\u0000\u00b3\u00b6\u0003*\u0015\u0000\u00b4\u00b6\u0003,\u0016"+
		"\u0000\u00b5\u00af\u0001\u0000\u0000\u0000\u00b5\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u001b\u0001\u0000\u0000\u0000\u00b7\u00b9\u00056\u0000\u0000"+
		"\u00b8\u00ba\u0003.\u0017\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u00057\u0000\u0000\u00bc\u001d\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0005\"\u0000\u0000\u00be\u00c0\u00058\u0000\u0000\u00bf\u00c1\u0003"+
		"\u001c\u000e\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"*\u0000\u0000\u00c3\u00c4\u0003.\u0017\u0000\u00c4\u001f\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c7\u0005\u0007\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0005\u0005\u0000\u0000\u00c9\u00ca\u00058\u0000\u0000"+
		"\u00ca\u00d3\u00054\u0000\u0000\u00cb\u00d0\u0003.\u0017\u0000\u00cc\u00cd"+
		"\u0005(\u0000\u0000\u00cd\u00cf\u0003.\u0017\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00cb\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u00055\u0000\u0000\u00d6!\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d9\u0005!\u0000\u0000\u00d8\u00da\u0003.\u0017\u0000\u00d9\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da#\u0001"+
		"\u0000\u0000\u0000\u00db\u00dc\u0005\u0014\u0000\u0000\u00dc\u00dd\u0003"+
		".\u0017\u0000\u00dd\u00e1\u0005$\u0000\u0000\u00de\u00e0\u0003\u001a\r"+
		"\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e7\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e6\u0003&\u0013\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000"+
		"\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003(\u0014\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u000b\u0000\u0000\u00ee"+
		"%\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\t\u0000\u0000\u00f0\u00f1"+
		"\u0003.\u0017\u0000\u00f1\u00f5\u0005$\u0000\u0000\u00f2\u00f4\u0003\u001a"+
		"\r\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f6\'\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f8\u00fc\u0005\b\u0000\u0000\u00f9\u00fb\u0003\u001a\r\u0000\u00fa"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd"+
		")\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0103"+
		"\u0005\u0018\u0000\u0000\u0100\u0102\u0003\u001a\r\u0000\u0101\u0100\u0001"+
		"\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001"+
		"\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0107\u0005"+
		"\f\u0000\u0000\u0107+\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0010"+
		"\u0000\u0000\u0109\u010a\u0003.\u0017\u0000\u010a-\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0006\u0017\uffff\uffff\u0000\u010c\u010d\u00054\u0000\u0000"+
		"\u010d\u010e\u0003.\u0017\u0000\u010e\u010f\u00055\u0000\u0000\u010f\u012e"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0007\u0002\u0000\u0000\u0111\u012e"+
		"\u0003.\u0017\u000f\u0112\u012e\u0005\u001c\u0000\u0000\u0113\u012e\u0007"+
		"\u0003\u0000\u0000\u0114\u012e\u0007\u0004\u0000\u0000\u0115\u012e\u0005"+
		";\u0000\u0000\u0116\u012e\u0005\u0002\u0000\u0000\u0117\u0118\u00058\u0000"+
		"\u0000\u0118\u011a\u00056\u0000\u0000\u0119\u011b\u0003.\u0017\u0000\u011a"+
		"\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u0001\u0000\u0000\u0000\u011c\u012e\u00057\u0000\u0000\u011d\u011e"+
		"\u00058\u0000\u0000\u011e\u0127\u00054\u0000\u0000\u011f\u0124\u0003."+
		"\u0017\u0000\u0120\u0121\u0005(\u0000\u0000\u0121\u0123\u0003.\u0017\u0000"+
		"\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000"+
		"\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u0127\u011f\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012e\u00055\u0000\u0000\u012a"+
		"\u012b\u0005\u0012\u0000\u0000\u012b\u012e\u00058\u0000\u0000\u012c\u012e"+
		"\u00058\u0000\u0000\u012d\u010b\u0001\u0000\u0000\u0000\u012d\u0110\u0001"+
		"\u0000\u0000\u0000\u012d\u0112\u0001\u0000\u0000\u0000\u012d\u0113\u0001"+
		"\u0000\u0000\u0000\u012d\u0114\u0001\u0000\u0000\u0000\u012d\u0115\u0001"+
		"\u0000\u0000\u0000\u012d\u0116\u0001\u0000\u0000\u0000\u012d\u0117\u0001"+
		"\u0000\u0000\u0000\u012d\u011d\u0001\u0000\u0000\u0000\u012d\u012a\u0001"+
		"\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0140\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\n\u000e\u0000\u0000\u0130\u0131\u0007\u0005"+
		"\u0000\u0000\u0131\u013f\u0003.\u0017\u000f\u0132\u0133\n\r\u0000\u0000"+
		"\u0133\u0134\u0007\u0006\u0000\u0000\u0134\u013f\u0003.\u0017\u000e\u0135"+
		"\u0136\n\f\u0000\u0000\u0136\u0137\u0007\u0007\u0000\u0000\u0137\u013f"+
		"\u0003.\u0017\r\u0138\u0139\n\u000b\u0000\u0000\u0139\u013a\u0007\b\u0000"+
		"\u0000\u013a\u013f\u0003.\u0017\f\u013b\u013c\n\n\u0000\u0000\u013c\u013d"+
		"\u0007\t\u0000\u0000\u013d\u013f\u0003.\u0017\u000b\u013e\u012f\u0001"+
		"\u0000\u0000\u0000\u013e\u0132\u0001\u0000\u0000\u0000\u013e\u0135\u0001"+
		"\u0000\u0000\u0000\u013e\u0138\u0001\u0000\u0000\u0000\u013e\u013b\u0001"+
		"\u0000\u0000\u0000\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141/\u0001\u0000"+
		"\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000(24=EHMU_ehkouz\u0084"+
		"\u008a\u0090\u0098\u009b\u00a4\u00aa\u00b5\u00b9\u00c0\u00c6\u00d0\u00d3"+
		"\u00d9\u00e1\u00e7\u00eb\u00f5\u00fc\u0103\u011a\u0124\u0127\u012d\u013e"+
		"\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
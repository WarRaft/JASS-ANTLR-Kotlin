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
		ENDSCOPE=15, EXTENDS=16, EXITWHEN=17, FALSE=18, FUNCTION=19, GLOBALS=20, 
		IF=21, INITIALIZER=22, LIBRARY=23, LOCAL=24, LOOP=25, NATIVE=26, NEEDS=27, 
		NOT=28, NOTHING=29, NULL=30, OR=31, PUBLIC=32, PRIVATE=33, REQUIRES=34, 
		RETURNS=35, RETURN=36, SET=37, SCOPE=38, STATIC=39, TAKES=40, THEN=41, 
		TRUE=42, TYPE=43, USES=44, DOT=45, COMMA=46, EQ_EQ=47, NEQ=48, EQ=49, 
		ADD_EQ=50, SUB_EQ=51, MUL_EQ=52, DIV_EQ=53, LT_EQ=54, LT=55, GT_EQ=56, 
		GT=57, ADD=58, SUB=59, MUL=60, DIV=61, LPAREN=62, RPAREN=63, LBRACK=64, 
		RBRACK=65, ID=66, INTVAL=67, HEXVAL=68, REALVAL=69, WS=70, NL=71, COMMENT=72, 
		LINE_COMMENT=73;
	public static final int
		RULE_root = 0, RULE_rootItem = 1, RULE_library = 2, RULE_typename = 3, 
		RULE_varname = 4, RULE_globals = 5, RULE_param = 6, RULE_takes = 7, RULE_returnsRule = 8, 
		RULE_nativeRule = 9, RULE_function = 10, RULE_left = 11, RULE_stmt = 12, 
		RULE_brackExpr = 13, RULE_elseif = 14, RULE_elseRule = 15, RULE_expr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "rootItem", "library", "typename", "varname", "globals", "param", 
			"takes", "returnsRule", "nativeRule", "function", "left", "stmt", "brackExpr", 
			"elseif", "elseRule", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'and'", "'array'", "'call'", "'constant'", "'debug'", 
			"'else'", "'elseif'", "'endfunction'", "'endif'", "'endloop'", "'endglobals'", 
			"'endlibrary'", "'endscope'", "'extends'", "'exitwhen'", "'false'", "'function'", 
			"'globals'", "'if'", "'initializer'", "'library'", "'local'", "'loop'", 
			"'native'", "'needs'", "'not'", "'nothing'", "'null'", "'or'", "'public'", 
			"'private'", "'requires'", "'returns'", "'return'", "'set'", "'scope'", 
			"'static'", "'takes'", "'then'", "'true'", "'type'", "'uses'", "'.'", 
			"','", "'=='", "'!='", "'='", "'+='", "'-='", "'*='", "'/='", "'<='", 
			"'<'", "'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "AND", "ARRAY", "CALL", "CONSTANT", "DEBUG", 
			"ELSE", "ELSEIF", "ENDFUNCTION", "ENDIF", "ENDLOOP", "ENDGLOBALS", "ENDLIBRARY", 
			"ENDSCOPE", "EXTENDS", "EXITWHEN", "FALSE", "FUNCTION", "GLOBALS", "IF", 
			"INITIALIZER", "LIBRARY", "LOCAL", "LOOP", "NATIVE", "NEEDS", "NOT", 
			"NOTHING", "NULL", "OR", "PUBLIC", "PRIVATE", "REQUIRES", "RETURNS", 
			"RETURN", "SET", "SCOPE", "STATIC", "TAKES", "THEN", "TRUE", "TYPE", 
			"USES", "DOT", "COMMA", "EQ_EQ", "NEQ", "EQ", "ADD_EQ", "SUB_EQ", "MUL_EQ", 
			"DIV_EQ", "LT_EQ", "LT", "GT_EQ", "GT", "ADD", "SUB", "MUL", "DIV", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "ID", "INTVAL", "HEXVAL", "REALVAL", "WS", 
			"NL", "COMMENT", "LINE_COMMENT"
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 287839879232L) != 0)) {
				{
				setState(36);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					library();
					}
					break;
				case 2:
					{
					setState(35);
					rootItem();
					}
					break;
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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
		public NativeRuleContext nativeRule() {
			return getRuleContext(NativeRuleContext.class,0);
		}
		public GlobalsContext globals() {
			return getRuleContext(GlobalsContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public LibraryContext library() {
			return getRuleContext(LibraryContext.class,0);
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
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				nativeRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				globals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				function();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				library();
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
	public static class LibraryContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(VjassParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(VjassParser.ID, i);
		}
		public TerminalNode LIBRARY() { return getToken(VjassParser.LIBRARY, 0); }
		public TerminalNode SCOPE() { return getToken(VjassParser.SCOPE, 0); }
		public TerminalNode ENDLIBRARY() { return getToken(VjassParser.ENDLIBRARY, 0); }
		public TerminalNode ENDSCOPE() { return getToken(VjassParser.ENDSCOPE, 0); }
		public TerminalNode INITIALIZER() { return getToken(VjassParser.INITIALIZER, 0); }
		public List<RootItemContext> rootItem() {
			return getRuleContexts(RootItemContext.class);
		}
		public RootItemContext rootItem(int i) {
			return getRuleContext(RootItemContext.class,i);
		}
		public TerminalNode REQUIRES() { return getToken(VjassParser.REQUIRES, 0); }
		public TerminalNode NEEDS() { return getToken(VjassParser.NEEDS, 0); }
		public TerminalNode USES() { return getToken(VjassParser.USES, 0); }
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
		enterRule(_localctx, 4, RULE_library);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==LIBRARY || _la==SCOPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIALIZER) {
				{
				setState(51);
				match(INITIALIZER);
				setState(52);
				match(ID);
				}
			}

			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17609500131328L) != 0)) {
				{
				setState(55);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17609500131328L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(56);
				match(ID);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(57);
					match(COMMA);
					setState(58);
					match(ID);
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 287839879232L) != 0)) {
				{
				{
				setState(66);
				rootItem();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==ENDLIBRARY || _la==ENDSCOPE) ) {
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
			setState(74);
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
			setState(76);
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
			setState(78);
			match(GLOBALS);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
				{
				{
				setState(79);
				stmt();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
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
			setState(87);
			typename();
			setState(88);
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
	public static class TakesContext extends ParserRuleContext {
		public TerminalNode TAKES() { return getToken(VjassParser.TAKES, 0); }
		public TerminalNode NOTHING() { return getToken(VjassParser.NOTHING, 0); }
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
		public TakesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_takes; }
	}

	public final TakesContext takes() throws RecognitionException {
		TakesContext _localctx = new TakesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_takes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TAKES);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(91);
				match(NOTHING);
				}
				break;
			case ID:
				{
				{
				setState(92);
				param();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(93);
					match(COMMA);
					setState(94);
					param();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 16, RULE_returnsRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(RETURNS);
			setState(103);
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
		enterRule(_localctx, 18, RULE_nativeRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(105);
				match(CONSTANT);
				}
			}

			setState(108);
			match(NATIVE);
			setState(109);
			match(ID);
			setState(110);
			takes();
			setState(111);
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
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(113);
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

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(116);
				match(CONSTANT);
				}
			}

			setState(119);
			match(FUNCTION);
			setState(120);
			match(ID);
			setState(121);
			takes();
			setState(122);
			returnsRule();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
				{
				{
				setState(123);
				stmt();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
		public LeftCallContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftArrContext extends LeftContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(VjassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(VjassParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LeftArrContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftIdContext extends LeftContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
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
		public TerminalNode COMMA() { return getToken(VjassParser.COMMA, 0); }
		public LeftCommaContext(LeftContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftTypeContext extends LeftContext {
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
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
		public TerminalNode DOT() { return getToken(VjassParser.DOT, 0); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_left, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new LeftIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(132);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new LeftTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(ID);
				setState(134);
				left(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(162);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new LeftCommaContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(137);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(138);
						match(COMMA);
						setState(139);
						left(5);
						}
						break;
					case 2:
						{
						_localctx = new LeftDotContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(140);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(141);
						match(DOT);
						setState(142);
						left(2);
						}
						break;
					case 3:
						{
						_localctx = new LeftCallContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(143);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(144);
						match(LPAREN);
						setState(153);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5188151170120286214L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 15L) != 0)) {
							{
							setState(145);
							expr(0);
							setState(150);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(146);
								match(COMMA);
								setState(147);
								expr(0);
								}
								}
								setState(152);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(155);
						match(RPAREN);
						}
						break;
					case 4:
						{
						_localctx = new LeftArrContext(new LeftContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_left);
						setState(156);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(157);
						match(LBRACK);
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5188151170120286214L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 15L) != 0)) {
							{
							setState(158);
							expr(0);
							}
						}

						setState(161);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(166);
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
		public StmtIfContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtExitWhenContext extends StmtContext {
		public TerminalNode EXITWHEN() { return getToken(VjassParser.EXITWHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtExitWhenContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtVarContext extends StmtContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
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
		public StmtVarContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLoopContext extends StmtContext {
		public TerminalNode LOOP() { return getToken(VjassParser.LOOP, 0); }
		public TerminalNode ENDLOOP() { return getToken(VjassParser.ENDLOOP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtLoopContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(VjassParser.RETURN, 0); }
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
		public List<TerminalNode> DEBUG() { return getTokens(VjassParser.DEBUG); }
		public TerminalNode DEBUG(int i) {
			return getToken(VjassParser.DEBUG, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(VjassParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(VjassParser.STATIC, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(VjassParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(VjassParser.CONSTANT, i);
		}
		public List<TerminalNode> PUBLIC() { return getTokens(VjassParser.PUBLIC); }
		public TerminalNode PUBLIC(int i) {
			return getToken(VjassParser.PUBLIC, i);
		}
		public List<TerminalNode> PRIVATE() { return getTokens(VjassParser.PRIVATE); }
		public TerminalNode PRIVATE(int i) {
			return getToken(VjassParser.PRIVATE, i);
		}
		public StmtModContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLeftContext extends StmtContext {
		public LeftContext left() {
			return getRuleContext(LeftContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SET() { return getTokens(VjassParser.SET); }
		public TerminalNode SET(int i) {
			return getToken(VjassParser.SET, i);
		}
		public List<TerminalNode> CALL() { return getTokens(VjassParser.CALL); }
		public TerminalNode CALL(int i) {
			return getToken(VjassParser.CALL, i);
		}
		public TerminalNode EQ() { return getToken(VjassParser.EQ, 0); }
		public TerminalNode ADD_EQ() { return getToken(VjassParser.ADD_EQ, 0); }
		public TerminalNode SUB_EQ() { return getToken(VjassParser.SUB_EQ, 0); }
		public TerminalNode MUL_EQ() { return getToken(VjassParser.MUL_EQ, 0); }
		public TerminalNode DIV_EQ() { return getToken(VjassParser.DIV_EQ, 0); }
		public StmtLeftContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		int _la;
		try {
			int _alt;
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new StmtLeftContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CALL || _la==SET) {
					{
					{
					setState(167);
					_la = _input.LA(1);
					if ( !(_la==CALL || _la==SET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				left(0);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17451448556060672L) != 0)) {
					{
					setState(174);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17451448556060672L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(175);
					expr(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(RETURN);
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(179);
					expr(0);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(IF);
				setState(183);
				expr(0);
				setState(184);
				match(THEN);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
					{
					{
					setState(185);
					stmt();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(191);
					elseif();
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(197);
					elseRule();
					}
				}

				setState(200);
				match(ENDIF);
				}
				break;
			case 4:
				_localctx = new StmtLoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				match(LOOP);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
					{
					{
					setState(203);
					stmt();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209);
				match(ENDLOOP);
				}
				break;
			case 5:
				_localctx = new StmtExitWhenContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				match(EXITWHEN);
				setState(211);
				expr(0);
				}
				break;
			case 6:
				_localctx = new StmtVarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(212);
					match(LOCAL);
					}
				}

				setState(215);
				typename();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARRAY) {
					{
					setState(216);
					match(ARRAY);
					}
				}

				setState(219);
				varname();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(220);
					brackExpr();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(226);
					match(EQ);
					setState(227);
					expr(0);
					}
				}

				}
				break;
			case 7:
				_localctx = new StmtModContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(231); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(230);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562640715968L) != 0)) ) {
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
					setState(233); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(235);
				stmt();
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
		enterRule(_localctx, 26, RULE_brackExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LBRACK);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5188151170120286214L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 15L) != 0)) {
				{
				setState(239);
				expr(0);
				}
			}

			setState(242);
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
		enterRule(_localctx, 28, RULE_elseif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(ELSEIF);
			setState(245);
			expr(0);
			setState(246);
			match(THEN);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
				{
				{
				setState(247);
				stmt();
				}
				}
				setState(252);
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
		enterRule(_localctx, 30, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(ELSE);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 2305843033240309767L) != 0)) {
				{
				{
				setState(254);
				stmt();
				}
				}
				setState(259);
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
		public TerminalNode SUB() { return getToken(VjassParser.SUB, 0); }
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
	public static class ExprDotContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(VjassParser.DOT, 0); }
		public ExprDotContext(ExprContext ctx) { copyFrom(ctx); }
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
		public TerminalNode SUB() { return getToken(VjassParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(VjassParser.ADD, 0); }
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(261);
				match(LPAREN);
				setState(262);
				expr(0);
				setState(263);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(266);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
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
				setState(269);
				_la = _input.LA(1);
				if ( !(_la==RAWVAL || _la==INTVAL || _la==HEXVAL) ) {
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
				setState(270);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(ID);
				setState(273);
				match(LBRACK);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5188151170120286214L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 15L) != 0)) {
					{
					setState(274);
					expr(0);
					}
				}

				setState(277);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(ID);
				setState(279);
				match(LPAREN);
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5188151170120286214L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 15L) != 0)) {
					{
					setState(280);
					expr(0);
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(281);
						match(COMMA);
						setState(282);
						expr(0);
						}
						}
						setState(287);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(290);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(FUNCTION);
				setState(292);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(314);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new ExprDotContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(296);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(297);
						match(DOT);
						setState(298);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(299);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(300);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(301);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(302);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(303);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(304);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(305);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(306);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270215977642229760L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(307);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(308);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(309);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(310);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(312);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(313);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		case 11:
			return left_sempred((LeftContext)_localctx, predIndex);
		case 16:
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
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001I\u0140\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0005\u0000%\b\u0000"+
		"\n\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002<\b\u0002\n\u0002\f\u0002?\t\u0002"+
		"\u0003\u0002A\b\u0002\u0001\u0002\u0005\u0002D\b\u0002\n\u0002\f\u0002"+
		"G\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005Q\b\u0005\n\u0005\f\u0005"+
		"T\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"`\b\u0007\n\u0007\f\u0007c\t\u0007\u0003\u0007e\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0003\tk\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0003\ns\b\n\u0001\n\u0003\nv\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n}\b\n\n\n\f\n\u0080\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0088\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0095\b\u000b"+
		"\n\u000b\f\u000b\u0098\t\u000b\u0003\u000b\u009a\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a0\b\u000b\u0001\u000b\u0005"+
		"\u000b\u00a3\b\u000b\n\u000b\f\u000b\u00a6\t\u000b\u0001\f\u0005\f\u00a9"+
		"\b\f\n\f\f\f\u00ac\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b1\b\f\u0001"+
		"\f\u0001\f\u0003\f\u00b5\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00bb"+
		"\b\f\n\f\f\f\u00be\t\f\u0001\f\u0005\f\u00c1\b\f\n\f\f\f\u00c4\t\f\u0001"+
		"\f\u0003\f\u00c7\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00cd\b\f"+
		"\n\f\f\f\u00d0\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d6\b\f\u0001"+
		"\f\u0001\f\u0003\f\u00da\b\f\u0001\f\u0001\f\u0005\f\u00de\b\f\n\f\f\f"+
		"\u00e1\t\f\u0001\f\u0001\f\u0003\f\u00e5\b\f\u0001\f\u0004\f\u00e8\b\f"+
		"\u000b\f\f\f\u00e9\u0001\f\u0003\f\u00ed\b\f\u0001\r\u0001\r\u0003\r\u00f1"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00f9\b\u000e\n\u000e\f\u000e\u00fc\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0100\b\u000f\n\u000f\f\u000f\u0103\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0114\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u011c\b\u0010\n"+
		"\u0010\f\u0010\u011f\t\u0010\u0003\u0010\u0121\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0127\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u013b"+
		"\b\u0010\n\u0010\f\u0010\u013e\t\u0010\u0001\u0010\u0000\u0002\u0016 "+
		"\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \u0000\u0010\u0002\u0000\u0017\u0017&&\u0003\u0000"+
		"\u001b\u001b\"\",,\u0001\u0000\u000e\u000f\u0002\u0000\u001d\u001dBB\u0001"+
		"\u0000 !\u0002\u0000\u0005\u0005%%\u0001\u000015\u0003\u0000\u0006\u0007"+
		" !\'\'\u0002\u0000\u001c\u001c;;\u0002\u0000\u0012\u0012**\u0002\u0000"+
		"\u0001\u0001CD\u0001\u0000<=\u0001\u0000:;\u0001\u000069\u0001\u0000/"+
		"0\u0002\u0000\u0003\u0003\u001f\u001f\u016e\u0000&\u0001\u0000\u0000\u0000"+
		"\u0002/\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u0006J"+
		"\u0001\u0000\u0000\u0000\bL\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000"+
		"\u0000\fW\u0001\u0000\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010"+
		"f\u0001\u0000\u0000\u0000\u0012j\u0001\u0000\u0000\u0000\u0014r\u0001"+
		"\u0000\u0000\u0000\u0016\u0087\u0001\u0000\u0000\u0000\u0018\u00ec\u0001"+
		"\u0000\u0000\u0000\u001a\u00ee\u0001\u0000\u0000\u0000\u001c\u00f4\u0001"+
		"\u0000\u0000\u0000\u001e\u00fd\u0001\u0000\u0000\u0000 \u0126\u0001\u0000"+
		"\u0000\u0000\"%\u0003\u0004\u0002\u0000#%\u0003\u0002\u0001\u0000$\"\u0001"+
		"\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000)*\u0005\u0000\u0000\u0001*\u0001\u0001"+
		"\u0000\u0000\u0000+0\u0003\u0012\t\u0000,0\u0003\n\u0005\u0000-0\u0003"+
		"\u0014\n\u0000.0\u0003\u0004\u0002\u0000/+\u0001\u0000\u0000\u0000/,\u0001"+
		"\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u0000"+
		"0\u0003\u0001\u0000\u0000\u000012\u0007\u0000\u0000\u000025\u0005B\u0000"+
		"\u000034\u0005\u0016\u0000\u000046\u0005B\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u00006@\u0001\u0000\u0000\u000078\u0007\u0001"+
		"\u0000\u00008=\u0005B\u0000\u00009:\u0005.\u0000\u0000:<\u0005B\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000@7\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AE\u0001\u0000\u0000\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000"+
		"\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0007"+
		"\u0002\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0005B\u0000\u0000"+
		"K\u0007\u0001\u0000\u0000\u0000LM\u0005B\u0000\u0000M\t\u0001\u0000\u0000"+
		"\u0000NR\u0005\u0014\u0000\u0000OQ\u0003\u0018\f\u0000PO\u0001\u0000\u0000"+
		"\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005"+
		"\r\u0000\u0000V\u000b\u0001\u0000\u0000\u0000WX\u0003\u0006\u0003\u0000"+
		"XY\u0003\b\u0004\u0000Y\r\u0001\u0000\u0000\u0000Zd\u0005(\u0000\u0000"+
		"[e\u0005\u001d\u0000\u0000\\a\u0003\f\u0006\u0000]^\u0005.\u0000\u0000"+
		"^`\u0003\f\u0006\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000be\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000d[\u0001\u0000\u0000\u0000d\\\u0001\u0000"+
		"\u0000\u0000e\u000f\u0001\u0000\u0000\u0000fg\u0005#\u0000\u0000gh\u0007"+
		"\u0003\u0000\u0000h\u0011\u0001\u0000\u0000\u0000ik\u0005\u0006\u0000"+
		"\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0005\u001a\u0000\u0000mn\u0005B\u0000\u0000no\u0003\u000e"+
		"\u0007\u0000op\u0003\u0010\b\u0000p\u0013\u0001\u0000\u0000\u0000qs\u0007"+
		"\u0004\u0000\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"su\u0001\u0000\u0000\u0000tv\u0005\u0006\u0000\u0000ut\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0005\u0013"+
		"\u0000\u0000xy\u0005B\u0000\u0000yz\u0003\u000e\u0007\u0000z~\u0003\u0010"+
		"\b\u0000{}\u0003\u0018\f\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005\n\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0006\u000b\uffff\uffff\u0000\u0084\u0088\u0005B\u0000\u0000\u0085"+
		"\u0086\u0005B\u0000\u0000\u0086\u0088\u0003\u0016\u000b\u0005\u0087\u0083"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u00a4"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\n\u0004\u0000\u0000\u008a\u008b\u0005"+
		".\u0000\u0000\u008b\u00a3\u0003\u0016\u000b\u0005\u008c\u008d\n\u0001"+
		"\u0000\u0000\u008d\u008e\u0005-\u0000\u0000\u008e\u00a3\u0003\u0016\u000b"+
		"\u0002\u008f\u0090\n\u0003\u0000\u0000\u0090\u0099\u0005>\u0000\u0000"+
		"\u0091\u0096\u0003 \u0010\u0000\u0092\u0093\u0005.\u0000\u0000\u0093\u0095"+
		"\u0003 \u0010\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00a3\u0005"+
		"?\u0000\u0000\u009c\u009d\n\u0002\u0000\u0000\u009d\u009f\u0005@\u0000"+
		"\u0000\u009e\u00a0\u0003 \u0010\u0000\u009f\u009e\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0005A\u0000\u0000\u00a2\u0089\u0001\u0000\u0000\u0000\u00a2"+
		"\u008c\u0001\u0000\u0000\u0000\u00a2\u008f\u0001\u0000\u0000\u0000\u00a2"+
		"\u009c\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u0017\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a9\u0007\u0005\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0\u0003\u0016\u000b\u0000\u00ae"+
		"\u00af\u0007\u0006\u0000\u0000\u00af\u00b1\u0003 \u0010\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00ed"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005$\u0000\u0000\u00b3\u00b5\u0003"+
		" \u0010\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00ed\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0015"+
		"\u0000\u0000\u00b7\u00b8\u0003 \u0010\u0000\u00b8\u00bc\u0005)\u0000\u0000"+
		"\u00b9\u00bb\u0003\u0018\f\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c2\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c1\u0003\u001c\u000e\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c7\u0003\u001e\u000f\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\u000b\u0000\u0000\u00c9\u00ed\u0001\u0000\u0000\u0000\u00ca"+
		"\u00ce\u0005\u0019\u0000\u0000\u00cb\u00cd\u0003\u0018\f\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00ed"+
		"\u0005\f\u0000\u0000\u00d2\u00d3\u0005\u0011\u0000\u0000\u00d3\u00ed\u0003"+
		" \u0010\u0000\u00d4\u00d6\u0005\u0018\u0000\u0000\u00d5\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d9\u0003\u0006\u0003\u0000\u00d8\u00da\u0005\u0004"+
		"\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00df\u0003\b\u0004"+
		"\u0000\u00dc\u00de\u0003\u001a\r\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u00051\u0000\u0000\u00e3"+
		"\u00e5\u0003 \u0010\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00ed\u0001\u0000\u0000\u0000\u00e6\u00e8"+
		"\u0007\u0007\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed"+
		"\u0003\u0018\f\u0000\u00ec\u00aa\u0001\u0000\u0000\u0000\u00ec\u00b2\u0001"+
		"\u0000\u0000\u0000\u00ec\u00b6\u0001\u0000\u0000\u0000\u00ec\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ec\u00d2\u0001\u0000\u0000\u0000\u00ec\u00d5\u0001"+
		"\u0000\u0000\u0000\u00ec\u00e7\u0001\u0000\u0000\u0000\u00ed\u0019\u0001"+
		"\u0000\u0000\u0000\u00ee\u00f0\u0005@\u0000\u0000\u00ef\u00f1\u0003 \u0010"+
		"\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005A\u0000\u0000"+
		"\u00f3\u001b\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\t\u0000\u0000\u00f5"+
		"\u00f6\u0003 \u0010\u0000\u00f6\u00fa\u0005)\u0000\u0000\u00f7\u00f9\u0003"+
		"\u0018\f\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb\u001d\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fd\u0101\u0005\b\u0000\u0000\u00fe\u0100\u0003\u0018\f"+
		"\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u0102\u001f\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0006\u0010\uffff\uffff\u0000\u0105\u0106\u0005>\u0000"+
		"\u0000\u0106\u0107\u0003 \u0010\u0000\u0107\u0108\u0005?\u0000\u0000\u0108"+
		"\u0127\u0001\u0000\u0000\u0000\u0109\u010a\u0007\b\u0000\u0000\u010a\u0127"+
		"\u0003 \u0010\u000f\u010b\u0127\u0005\u001e\u0000\u0000\u010c\u0127\u0007"+
		"\t\u0000\u0000\u010d\u0127\u0007\n\u0000\u0000\u010e\u0127\u0005E\u0000"+
		"\u0000\u010f\u0127\u0005\u0002\u0000\u0000\u0110\u0111\u0005B\u0000\u0000"+
		"\u0111\u0113\u0005@\u0000\u0000\u0112\u0114\u0003 \u0010\u0000\u0113\u0112"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0001\u0000\u0000\u0000\u0115\u0127\u0005A\u0000\u0000\u0116\u0117\u0005"+
		"B\u0000\u0000\u0117\u0120\u0005>\u0000\u0000\u0118\u011d\u0003 \u0010"+
		"\u0000\u0119\u011a\u0005.\u0000\u0000\u011a\u011c\u0003 \u0010\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u0118\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"\u0122\u0001\u0000\u0000\u0000\u0122\u0127\u0005?\u0000\u0000\u0123\u0124"+
		"\u0005\u0013\u0000\u0000\u0124\u0127\u0005B\u0000\u0000\u0125\u0127\u0005"+
		"B\u0000\u0000\u0126\u0104\u0001\u0000\u0000\u0000\u0126\u0109\u0001\u0000"+
		"\u0000\u0000\u0126\u010b\u0001\u0000\u0000\u0000\u0126\u010c\u0001\u0000"+
		"\u0000\u0000\u0126\u010d\u0001\u0000\u0000\u0000\u0126\u010e\u0001\u0000"+
		"\u0000\u0000\u0126\u010f\u0001\u0000\u0000\u0000\u0126\u0110\u0001\u0000"+
		"\u0000\u0000\u0126\u0116\u0001\u0000\u0000\u0000\u0126\u0123\u0001\u0000"+
		"\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0127\u013c\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\n\u0011\u0000\u0000\u0129\u012a\u0005-\u0000"+
		"\u0000\u012a\u013b\u0003 \u0010\u0012\u012b\u012c\n\u000e\u0000\u0000"+
		"\u012c\u012d\u0007\u000b\u0000\u0000\u012d\u013b\u0003 \u0010\u000f\u012e"+
		"\u012f\n\r\u0000\u0000\u012f\u0130\u0007\f\u0000\u0000\u0130\u013b\u0003"+
		" \u0010\u000e\u0131\u0132\n\f\u0000\u0000\u0132\u0133\u0007\r\u0000\u0000"+
		"\u0133\u013b\u0003 \u0010\r\u0134\u0135\n\u000b\u0000\u0000\u0135\u0136"+
		"\u0007\u000e\u0000\u0000\u0136\u013b\u0003 \u0010\f\u0137\u0138\n\n\u0000"+
		"\u0000\u0138\u0139\u0007\u000f\u0000\u0000\u0139\u013b\u0003 \u0010\u000b"+
		"\u013a\u0128\u0001\u0000\u0000\u0000\u013a\u012b\u0001\u0000\u0000\u0000"+
		"\u013a\u012e\u0001\u0000\u0000\u0000\u013a\u0131\u0001\u0000\u0000\u0000"+
		"\u013a\u0134\u0001\u0000\u0000\u0000\u013a\u0137\u0001\u0000\u0000\u0000"+
		"\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0001\u0000\u0000\u0000\u013d!\u0001\u0000\u0000\u0000\u013e"+
		"\u013c\u0001\u0000\u0000\u0000*$&/5=@ERadjru~\u0087\u0096\u0099\u009f"+
		"\u00a2\u00a4\u00aa\u00b0\u00b4\u00bc\u00c2\u00c6\u00ce\u00d5\u00d9\u00df"+
		"\u00e4\u00e9\u00ec\u00f0\u00fa\u0101\u0113\u011d\u0120\u0126\u013a\u013c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
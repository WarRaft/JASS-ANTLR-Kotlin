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
		LIBRARY=22, LOCAL=23, LOOP=24, NATIVE=25, NEEDS=26, NOT=27, NOTHING=28, 
		NULL=29, OR=30, PUBLIC=31, PRIVATE=32, REQUIRES=33, RETURNS=34, RETURN=35, 
		SET=36, TAKES=37, THEN=38, TRUE=39, TYPE=40, USES=41, COMMA=42, EQ_EQ=43, 
		EQ=44, NEQ=45, LT_EQ=46, LT=47, GT_EQ=48, GT=49, PLUS=50, MINUS=51, MUL=52, 
		DIV=53, LPAREN=54, RPAREN=55, LBRACK=56, RBRACK=57, ID=58, INTVAL=59, 
		HEXVAL=60, REALVAL=61, WS=62, NL=63, COMMENT=64, LINE_COMMENT=65;
	public static final int
		RULE_root = 0, RULE_library = 1, RULE_rootItem = 2, RULE_typename = 3, 
		RULE_varname = 4, RULE_globals = 5, RULE_param = 6, RULE_takes = 7, RULE_returnsRule = 8, 
		RULE_nativeRule = 9, RULE_function = 10, RULE_stmt = 11, RULE_brackExpr = 12, 
		RULE_elseif = 13, RULE_elseRule = 14, RULE_expr = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "library", "rootItem", "typename", "varname", "globals", "param", 
			"takes", "returnsRule", "nativeRule", "function", "stmt", "brackExpr", 
			"elseif", "elseRule", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'and'", "'array'", "'call'", "'constant'", "'debug'", 
			"'else'", "'elseif'", "'endfunction'", "'endif'", "'endloop'", "'endglobals'", 
			"'endlibrary'", "'extends'", "'exitwhen'", "'false'", "'function'", "'globals'", 
			"'if'", "'initializer'", "'library'", "'local'", "'loop'", "'native'", 
			"'needs'", "'not'", "'nothing'", "'null'", "'or'", "'public'", "'private'", 
			"'requires'", "'returns'", "'return'", "'set'", "'takes'", "'then'", 
			"'true'", "'type'", "'uses'", "','", "'=='", "'='", "'!='", "'<='", "'<'", 
			"'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "AND", "ARRAY", "CALL", "CONSTANT", "DEBUG", 
			"ELSE", "ELSEIF", "ENDFUNCTION", "ENDIF", "ENDLOOP", "ENDGLOBALS", "ENDLIBRARY", 
			"EXTENDS", "EXITWHEN", "FALSE", "FUNCTION", "GLOBALS", "IF", "INITIALIZER", 
			"LIBRARY", "LOCAL", "LOOP", "NATIVE", "NEEDS", "NOT", "NOTHING", "NULL", 
			"OR", "PUBLIC", "PRIVATE", "REQUIRES", "RETURNS", "RETURN", "SET", "TAKES", 
			"THEN", "TRUE", "TYPE", "USES", "COMMA", "EQ_EQ", "EQ", "NEQ", "LT_EQ", 
			"LT", "GT_EQ", "GT", "PLUS", "MINUS", "MUL", "DIV", "LPAREN", "RPAREN", 
			"LBRACK", "RBRACK", "ID", "INTVAL", "HEXVAL", "REALVAL", "WS", "NL", 
			"COMMENT", "LINE_COMMENT"
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
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6480986176L) != 0)) {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LIBRARY:
					{
					setState(32);
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
					setState(33);
					rootItem();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
		enterRule(_localctx, 2, RULE_library);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(LIBRARY);
			setState(42);
			match(ID);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIALIZER) {
				{
				setState(43);
				match(INITIALIZER);
				setState(44);
				match(ID);
				}
			}

			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2207680299008L) != 0)) {
				{
				setState(47);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2207680299008L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(48);
				match(ID);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(49);
					match(COMMA);
					setState(50);
					match(ID);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6476791872L) != 0)) {
				{
				{
				setState(58);
				rootItem();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
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
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				nativeRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				globals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
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
			setState(71);
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
			setState(73);
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
			setState(75);
			match(GLOBALS);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(76);
				stmt();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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
			setState(84);
			typename();
			setState(85);
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
			setState(87);
			match(TAKES);
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(88);
				match(NOTHING);
				}
				break;
			case ID:
				{
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
			setState(99);
			match(RETURNS);
			setState(100);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(102);
				match(CONSTANT);
				}
			}

			setState(105);
			match(NATIVE);
			setState(106);
			match(ID);
			setState(107);
			takes();
			setState(108);
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(110);
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

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(113);
				match(CONSTANT);
				}
			}

			setState(116);
			match(FUNCTION);
			setState(117);
			match(ID);
			setState(118);
			takes();
			setState(119);
			returnsRule();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(120);
				stmt();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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
	public static class StmtCallContext extends StmtContext {
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
		public StmtCallContext(StmtContext ctx) { copyFrom(ctx); }
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
	public static class StmtSetContext extends StmtContext {
		public TerminalNode SET() { return getToken(VjassParser.SET, 0); }
		public TerminalNode ID() { return getToken(VjassParser.ID, 0); }
		public TerminalNode EQ() { return getToken(VjassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BrackExprContext brackExpr() {
			return getRuleContext(BrackExprContext.class,0);
		}
		public StmtSetContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(VjassParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				_localctx = new StmtSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(SET);
				setState(129);
				match(ID);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(130);
					brackExpr();
					}
				}

				setState(133);
				match(EQ);
				setState(134);
				expr(0);
				}
				break;
			case CALL:
			case DEBUG:
				_localctx = new StmtCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEBUG) {
					{
					setState(135);
					match(DEBUG);
					}
				}

				setState(138);
				match(CALL);
				setState(139);
				match(ID);
				setState(140);
				match(LPAREN);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(141);
					expr(0);
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(142);
						match(COMMA);
						setState(143);
						expr(0);
						}
						}
						setState(148);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(151);
				match(RPAREN);
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(RETURN);
				setState(154);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(153);
					expr(0);
					}
					break;
				}
				}
				break;
			case IF:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(IF);
				setState(157);
				expr(0);
				setState(158);
				match(THEN);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
					{
					{
					setState(159);
					stmt();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(165);
					elseif();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(171);
					elseRule();
					}
				}

				setState(174);
				match(ENDIF);
				}
				break;
			case LOOP:
				_localctx = new StmtLoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match(LOOP);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
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
				match(ENDLOOP);
				}
				break;
			case EXITWHEN:
				_localctx = new StmtExitWhenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(EXITWHEN);
				setState(185);
				expr(0);
				}
				break;
			case CONSTANT:
			case LOCAL:
			case PUBLIC:
			case PRIVATE:
			case ID:
				_localctx = new StmtVarContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUBLIC || _la==PRIVATE) {
					{
					setState(186);
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

				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(189);
					match(CONSTANT);
					}
				}

				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(192);
					match(LOCAL);
					}
				}

				setState(195);
				typename();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARRAY) {
					{
					setState(196);
					match(ARRAY);
					}
				}

				setState(199);
				varname();
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(200);
					brackExpr();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(206);
					match(EQ);
					setState(207);
					expr(0);
					}
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
		enterRule(_localctx, 24, RULE_brackExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LBRACK);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
				{
				setState(213);
				expr(0);
				}
			}

			setState(216);
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
		enterRule(_localctx, 26, RULE_elseif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(ELSEIF);
			setState(219);
			expr(0);
			setState(220);
			match(THEN);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(221);
				stmt();
				}
				}
				setState(226);
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
		enterRule(_localctx, 28, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ELSE);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(228);
				stmt();
				}
				}
				setState(233);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(235);
				match(LPAREN);
				setState(236);
				expr(0);
				setState(237);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
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
				setState(243);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729382256910270466L) != 0)) ) {
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
				setState(244);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(ID);
				setState(247);
				match(LBRACK);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(248);
					expr(0);
					}
				}

				setState(251);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(ID);
				setState(253);
				match(LPAREN);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(254);
					expr(0);
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(255);
						match(COMMA);
						setState(256);
						expr(0);
						}
						}
						setState(261);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(264);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(FUNCTION);
				setState(266);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(285);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(271);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(272);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(274);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(277);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1055531162664960L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(280);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(281);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(283);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		case 15:
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
		"\u0004\u0001A\u0123\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001.\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0003\u00019\b\u0001\u0001"+
		"\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001?\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002F\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005"+
		"\u0005N\b\u0005\n\u0005\f\u0005Q\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007]\b\u0007\n\u0007\f\u0007`\t\u0007\u0003"+
		"\u0007b\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0003\th\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0003\np\b\n\u0001\n\u0003\ns\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\nz\b\n\n\n\f\n}\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0084\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0089\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0091"+
		"\b\u000b\n\u000b\f\u000b\u0094\t\u000b\u0003\u000b\u0096\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009b\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a1\b\u000b\n\u000b\f\u000b"+
		"\u00a4\t\u000b\u0001\u000b\u0005\u000b\u00a7\b\u000b\n\u000b\f\u000b\u00aa"+
		"\t\u000b\u0001\u000b\u0003\u000b\u00ad\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00b3\b\u000b\n\u000b\f\u000b\u00b6"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00bc"+
		"\b\u000b\u0001\u000b\u0003\u000b\u00bf\b\u000b\u0001\u000b\u0003\u000b"+
		"\u00c2\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c6\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00ca\b\u000b\n\u000b\f\u000b\u00cd\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00d1\b\u000b\u0003\u000b\u00d3\b"+
		"\u000b\u0001\f\u0001\f\u0003\f\u00d7\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u00df\b\r\n\r\f\r\u00e2\t\r\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00e6\b\u000e\n\u000e\f\u000e\u00e9\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00fa\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0102\b\u000f"+
		"\n\u000f\f\u000f\u0105\t\u000f\u0003\u000f\u0107\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u010d\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u011e\b\u000f\n\u000f\f\u000f\u0121\t\u000f"+
		"\u0001\u000f\u0000\u0001\u001e\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u000b\u0003\u0000"+
		"\u001a\u001a!!))\u0002\u0000\u001c\u001c::\u0001\u0000\u001f \u0002\u0000"+
		"\u001b\u001b33\u0002\u0000\u0011\u0011\'\'\u0002\u0000\u0001\u0001;<\u0001"+
		"\u000045\u0001\u000023\u0001\u0000.1\u0002\u0000++--\u0002\u0000\u0003"+
		"\u0003\u001e\u001e\u014b\u0000$\u0001\u0000\u0000\u0000\u0002)\u0001\u0000"+
		"\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000"+
		"\bI\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000\u0000\fT\u0001\u0000"+
		"\u0000\u0000\u000eW\u0001\u0000\u0000\u0000\u0010c\u0001\u0000\u0000\u0000"+
		"\u0012g\u0001\u0000\u0000\u0000\u0014o\u0001\u0000\u0000\u0000\u0016\u00d2"+
		"\u0001\u0000\u0000\u0000\u0018\u00d4\u0001\u0000\u0000\u0000\u001a\u00da"+
		"\u0001\u0000\u0000\u0000\u001c\u00e3\u0001\u0000\u0000\u0000\u001e\u010c"+
		"\u0001\u0000\u0000\u0000 #\u0003\u0002\u0001\u0000!#\u0003\u0004\u0002"+
		"\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000"+
		"\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005\u0000\u0000\u0001"+
		"(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0016\u0000\u0000*-\u0005:\u0000"+
		"\u0000+,\u0005\u0015\u0000\u0000,.\u0005:\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.8\u0001\u0000\u0000\u0000/0\u0007\u0000"+
		"\u0000\u000005\u0005:\u0000\u000012\u0005*\u0000\u000024\u0005:\u0000"+
		"\u000031\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u00008/\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9=\u0001\u0000\u0000\u0000:<\u0003\u0004\u0002\u0000;:\u0001\u0000\u0000"+
		"\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005"+
		"\u000e\u0000\u0000A\u0003\u0001\u0000\u0000\u0000BF\u0003\u0012\t\u0000"+
		"CF\u0003\n\u0005\u0000DF\u0003\u0014\n\u0000EB\u0001\u0000\u0000\u0000"+
		"EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000F\u0005\u0001\u0000"+
		"\u0000\u0000GH\u0005:\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IJ\u0005"+
		":\u0000\u0000J\t\u0001\u0000\u0000\u0000KO\u0005\u0013\u0000\u0000LN\u0003"+
		"\u0016\u000b\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000RS\u0005\r\u0000\u0000S\u000b\u0001\u0000"+
		"\u0000\u0000TU\u0003\u0006\u0003\u0000UV\u0003\b\u0004\u0000V\r\u0001"+
		"\u0000\u0000\u0000Wa\u0005%\u0000\u0000Xb\u0005\u001c\u0000\u0000Y^\u0003"+
		"\f\u0006\u0000Z[\u0005*\u0000\u0000[]\u0003\f\u0006\u0000\\Z\u0001\u0000"+
		"\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"aX\u0001\u0000\u0000\u0000aY\u0001\u0000\u0000\u0000b\u000f\u0001\u0000"+
		"\u0000\u0000cd\u0005\"\u0000\u0000de\u0007\u0001\u0000\u0000e\u0011\u0001"+
		"\u0000\u0000\u0000fh\u0005\u0006\u0000\u0000gf\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005\u0019\u0000"+
		"\u0000jk\u0005:\u0000\u0000kl\u0003\u000e\u0007\u0000lm\u0003\u0010\b"+
		"\u0000m\u0013\u0001\u0000\u0000\u0000np\u0007\u0002\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qs\u0005\u0006\u0000\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tu\u0005\u0012\u0000\u0000uv\u0005:\u0000"+
		"\u0000vw\u0003\u000e\u0007\u0000w{\u0003\u0010\b\u0000xz\u0003\u0016\u000b"+
		"\u0000yx\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\n\u0000\u0000\u007f\u0015\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005$\u0000\u0000\u0081\u0083\u0005:\u0000\u0000"+
		"\u0082\u0084\u0003\u0018\f\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005,\u0000\u0000\u0086\u00d3\u0003\u001e\u000f\u0000\u0087\u0089"+
		"\u0005\u0007\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005\u0005\u0000\u0000\u008b\u008c\u0005:\u0000\u0000\u008c\u0095\u0005"+
		"6\u0000\u0000\u008d\u0092\u0003\u001e\u000f\u0000\u008e\u008f\u0005*\u0000"+
		"\u0000\u008f\u0091\u0003\u001e\u000f\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u008d\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u00d3\u00057\u0000\u0000\u0098\u009a\u0005#\u0000\u0000\u0099"+
		"\u009b\u0003\u001e\u000f\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u00d3\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0005\u0014\u0000\u0000\u009d\u009e\u0003\u001e\u000f\u0000\u009e"+
		"\u00a2\u0005&\u0000\u0000\u009f\u00a1\u0003\u0016\u000b\u0000\u00a0\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7"+
		"\u0003\u001a\r\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ad\u0003\u001c\u000e\u0000\u00ac\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005\u000b\u0000\u0000\u00af\u00d3\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b4\u0005\u0018\u0000\u0000\u00b1\u00b3\u0003"+
		"\u0016\u000b\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b7\u00d3\u0005\f\u0000\u0000\u00b8\u00b9\u0005\u0010"+
		"\u0000\u0000\u00b9\u00d3\u0003\u001e\u000f\u0000\u00ba\u00bc\u0007\u0002"+
		"\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\u0006"+
		"\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00c2\u0005\u0017"+
		"\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003\u0006"+
		"\u0003\u0000\u00c4\u00c6\u0005\u0004\u0000\u0000\u00c5\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00cb\u0003\b\u0004\u0000\u00c8\u00ca\u0003\u0018\f"+
		"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cc\u00d0\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005,\u0000\u0000\u00cf\u00d1\u0003\u001e\u000f\u0000"+
		"\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u0080\u0001\u0000\u0000\u0000"+
		"\u00d2\u0088\u0001\u0000\u0000\u0000\u00d2\u0098\u0001\u0000\u0000\u0000"+
		"\u00d2\u009c\u0001\u0000\u0000\u0000\u00d2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00d2\u00b8\u0001\u0000\u0000\u0000\u00d2\u00bb\u0001\u0000\u0000\u0000"+
		"\u00d3\u0017\u0001\u0000\u0000\u0000\u00d4\u00d6\u00058\u0000\u0000\u00d5"+
		"\u00d7\u0003\u001e\u000f\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u00059\u0000\u0000\u00d9\u0019\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0005\t\u0000\u0000\u00db\u00dc\u0003\u001e\u000f\u0000\u00dc\u00e0\u0005"+
		"&\u0000\u0000\u00dd\u00df\u0003\u0016\u000b\u0000\u00de\u00dd\u0001\u0000"+
		"\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u001b\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e7\u0005\b\u0000"+
		"\u0000\u00e4\u00e6\u0003\u0016\u000b\u0000\u00e5\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u001d\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00eb\u0006\u000f\uffff"+
		"\uffff\u0000\u00eb\u00ec\u00056\u0000\u0000\u00ec\u00ed\u0003\u001e\u000f"+
		"\u0000\u00ed\u00ee\u00057\u0000\u0000\u00ee\u010d\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0007\u0003\u0000\u0000\u00f0\u010d\u0003\u001e\u000f\u000f"+
		"\u00f1\u010d\u0005\u001d\u0000\u0000\u00f2\u010d\u0007\u0004\u0000\u0000"+
		"\u00f3\u010d\u0007\u0005\u0000\u0000\u00f4\u010d\u0005=\u0000\u0000\u00f5"+
		"\u010d\u0005\u0002\u0000\u0000\u00f6\u00f7\u0005:\u0000\u0000\u00f7\u00f9"+
		"\u00058\u0000\u0000\u00f8\u00fa\u0003\u001e\u000f\u0000\u00f9\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fb\u010d\u00059\u0000\u0000\u00fc\u00fd\u0005:\u0000"+
		"\u0000\u00fd\u0106\u00056\u0000\u0000\u00fe\u0103\u0003\u001e\u000f\u0000"+
		"\u00ff\u0100\u0005*\u0000\u0000\u0100\u0102\u0003\u001e\u000f\u0000\u0101"+
		"\u00ff\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103"+
		"\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104"+
		"\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106"+
		"\u00fe\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108\u010d\u00057\u0000\u0000\u0109\u010a"+
		"\u0005\u0012\u0000\u0000\u010a\u010d\u0005:\u0000\u0000\u010b\u010d\u0005"+
		":\u0000\u0000\u010c\u00ea\u0001\u0000\u0000\u0000\u010c\u00ef\u0001\u0000"+
		"\u0000\u0000\u010c\u00f1\u0001\u0000\u0000\u0000\u010c\u00f2\u0001\u0000"+
		"\u0000\u0000\u010c\u00f3\u0001\u0000\u0000\u0000\u010c\u00f4\u0001\u0000"+
		"\u0000\u0000\u010c\u00f5\u0001\u0000\u0000\u0000\u010c\u00f6\u0001\u0000"+
		"\u0000\u0000\u010c\u00fc\u0001\u0000\u0000\u0000\u010c\u0109\u0001\u0000"+
		"\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010d\u011f\u0001\u0000"+
		"\u0000\u0000\u010e\u010f\n\u000e\u0000\u0000\u010f\u0110\u0007\u0006\u0000"+
		"\u0000\u0110\u011e\u0003\u001e\u000f\u000f\u0111\u0112\n\r\u0000\u0000"+
		"\u0112\u0113\u0007\u0007\u0000\u0000\u0113\u011e\u0003\u001e\u000f\u000e"+
		"\u0114\u0115\n\f\u0000\u0000\u0115\u0116\u0007\b\u0000\u0000\u0116\u011e"+
		"\u0003\u001e\u000f\r\u0117\u0118\n\u000b\u0000\u0000\u0118\u0119\u0007"+
		"\t\u0000\u0000\u0119\u011e\u0003\u001e\u000f\f\u011a\u011b\n\n\u0000\u0000"+
		"\u011b\u011c\u0007\n\u0000\u0000\u011c\u011e\u0003\u001e\u000f\u000b\u011d"+
		"\u010e\u0001\u0000\u0000\u0000\u011d\u0111\u0001\u0000\u0000\u0000\u011d"+
		"\u0114\u0001\u0000\u0000\u0000\u011d\u0117\u0001\u0000\u0000\u0000\u011d"+
		"\u011a\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f"+
		"\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u001f\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\'\""+
		"$-58=EO^agor{\u0083\u0088\u0092\u0095\u009a\u00a2\u00a8\u00ac\u00b4\u00bb"+
		"\u00be\u00c1\u00c5\u00cb\u00d0\u00d2\u00d6\u00e0\u00e7\u00f9\u0103\u0106"+
		"\u010c\u011d\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		RULE_varname = 4, RULE_globals = 5, RULE_param = 6, RULE_params = 7, RULE_takes = 8, 
		RULE_returnsRule = 9, RULE_nativeRule = 10, RULE_function = 11, RULE_stmt = 12, 
		RULE_brackExpr = 13, RULE_elseif = 14, RULE_elseRule = 15, RULE_expr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "library", "rootItem", "typename", "varname", "globals", "param", 
			"params", "takes", "returnsRule", "nativeRule", "function", "stmt", "brackExpr", 
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6480986176L) != 0)) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LIBRARY:
					{
					setState(34);
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
					setState(35);
					rootItem();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
			setState(43);
			match(LIBRARY);
			setState(44);
			match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INITIALIZER) {
				{
				setState(45);
				match(INITIALIZER);
				setState(46);
				match(ID);
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2207680299008L) != 0)) {
				{
				setState(49);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2207680299008L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6476791872L) != 0)) {
				{
				{
				setState(60);
				rootItem();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				nativeRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				globals();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
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
			setState(75);
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
			setState(77);
			match(GLOBALS);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(78);
				stmt();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
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
			setState(86);
			typename();
			setState(87);
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
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
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
		enterRule(_localctx, 16, RULE_takes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(TAKES);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(98);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(99);
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
		enterRule(_localctx, 18, RULE_returnsRule);
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
		enterRule(_localctx, 20, RULE_nativeRule);
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
		enterRule(_localctx, 22, RULE_function);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
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
		enterRule(_localctx, 24, RULE_stmt);
		int _la;
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				_localctx = new StmtSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(SET);
				setState(132);
				match(ID);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(133);
					brackExpr();
					}
				}

				setState(136);
				match(EQ);
				setState(137);
				expr(0);
				}
				break;
			case CALL:
			case DEBUG:
				_localctx = new StmtCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEBUG) {
					{
					setState(138);
					match(DEBUG);
					}
				}

				setState(141);
				match(CALL);
				setState(142);
				match(ID);
				setState(143);
				match(LPAREN);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(144);
					expr(0);
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(145);
						match(COMMA);
						setState(146);
						expr(0);
						}
						}
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(154);
				match(RPAREN);
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(RETURN);
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(156);
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
				setState(159);
				match(IF);
				setState(160);
				expr(0);
				setState(161);
				match(THEN);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
					{
					{
					setState(162);
					stmt();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(168);
					elseif();
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(174);
					elseRule();
					}
				}

				setState(177);
				match(ENDIF);
				}
				break;
			case LOOP:
				_localctx = new StmtLoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(LOOP);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
					{
					{
					setState(180);
					stmt();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(ENDLOOP);
				}
				break;
			case EXITWHEN:
				_localctx = new StmtExitWhenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				match(EXITWHEN);
				setState(188);
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
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUBLIC || _la==PRIVATE) {
					{
					setState(189);
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

				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(192);
					match(CONSTANT);
					}
				}

				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(195);
					match(LOCAL);
					}
				}

				setState(198);
				typename();
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARRAY) {
					{
					setState(199);
					match(ARRAY);
					}
				}

				setState(202);
				varname();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(203);
					brackExpr();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(209);
					match(EQ);
					setState(210);
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
		enterRule(_localctx, 26, RULE_brackExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(LBRACK);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
				{
				setState(216);
				expr(0);
				}
			}

			setState(219);
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
			setState(221);
			match(ELSEIF);
			setState(222);
			expr(0);
			setState(223);
			match(THEN);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
				{
				{
				setState(224);
				stmt();
				}
				}
				setState(229);
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
			setState(230);
			match(ELSE);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230485699657952L) != 0)) {
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(238);
				match(LPAREN);
				setState(239);
				expr(0);
				setState(240);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(243);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
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
				setState(246);
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
				setState(247);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(ID);
				setState(250);
				match(LBRACK);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(251);
					expr(0);
					}
				}

				setState(254);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(ID);
				setState(256);
				match(LPAREN);
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4343722391026139142L) != 0)) {
					{
					setState(257);
					expr(0);
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(258);
						match(COMMA);
						setState(259);
						expr(0);
						}
						}
						setState(264);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(267);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(FUNCTION);
				setState(269);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(288);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(274);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(277);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(280);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1055531162664960L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(281);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(282);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(283);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(286);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(287);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(292);
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
		case 16:
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
		"\u0004\u0001A\u0126\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0005\u0000%\b\u0000"+
		"\n\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u00019\t\u0001"+
		"\u0003\u0001;\b\u0001\u0001\u0001\u0005\u0001>\b\u0001\n\u0001\f\u0001"+
		"A\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005P\b\u0005\n\u0005\f\u0005S\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007]\b\u0007\n\u0007\f\u0007`\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0003\be\b\b\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0003\nk\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0003"+
		"\u000bs\b\u000b\u0001\u000b\u0003\u000bv\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b}\b\u000b\n\u000b\f\u000b"+
		"\u0080\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f"+
		"\u0087\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u008c\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u0094\b\f\n\f\f\f\u0097\t\f\u0003\f"+
		"\u0099\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u009e\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u00a4\b\f\n\f\f\f\u00a7\t\f\u0001\f\u0005\f\u00aa\b"+
		"\f\n\f\f\f\u00ad\t\f\u0001\f\u0003\f\u00b0\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u00b6\b\f\n\f\f\f\u00b9\t\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00bf\b\f\u0001\f\u0003\f\u00c2\b\f\u0001\f\u0003\f\u00c5\b"+
		"\f\u0001\f\u0001\f\u0003\f\u00c9\b\f\u0001\f\u0001\f\u0005\f\u00cd\b\f"+
		"\n\f\f\f\u00d0\t\f\u0001\f\u0001\f\u0003\f\u00d4\b\f\u0003\f\u00d6\b\f"+
		"\u0001\r\u0001\r\u0003\r\u00da\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00e2\b\u000e\n\u000e\f\u000e\u00e5"+
		"\t\u000e\u0001\u000f\u0001\u000f\u0005\u000f\u00e9\b\u000f\n\u000f\f\u000f"+
		"\u00ec\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00fd\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u0105\b\u0010\n\u0010\f\u0010\u0108\t\u0010\u0003\u0010\u010a"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0110"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0121\b\u0010\n"+
		"\u0010\f\u0010\u0124\t\u0010\u0001\u0010\u0000\u0001 \u0011\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \u0000\u000b\u0003\u0000\u001a\u001a!!))\u0002\u0000\u001c\u001c::\u0001"+
		"\u0000\u001f \u0002\u0000\u001b\u001b33\u0002\u0000\u0011\u0011\'\'\u0002"+
		"\u0000\u0001\u0001;<\u0001\u000045\u0001\u000023\u0001\u0000.1\u0002\u0000"+
		"++--\u0002\u0000\u0003\u0003\u001e\u001e\u014d\u0000&\u0001\u0000\u0000"+
		"\u0000\u0002+\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006"+
		"I\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000"+
		"\u0000\fV\u0001\u0000\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010"+
		"a\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014j\u0001"+
		"\u0000\u0000\u0000\u0016r\u0001\u0000\u0000\u0000\u0018\u00d5\u0001\u0000"+
		"\u0000\u0000\u001a\u00d7\u0001\u0000\u0000\u0000\u001c\u00dd\u0001\u0000"+
		"\u0000\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u010f\u0001\u0000\u0000"+
		"\u0000\"%\u0003\u0002\u0001\u0000#%\u0003\u0004\u0002\u0000$\"\u0001\u0000"+
		"\u0000\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000)*\u0005\u0000\u0000\u0001*\u0001\u0001\u0000"+
		"\u0000\u0000+,\u0005\u0016\u0000\u0000,/\u0005:\u0000\u0000-.\u0005\u0015"+
		"\u0000\u0000.0\u0005:\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u00000:\u0001\u0000\u0000\u000012\u0007\u0000\u0000\u000027\u0005"+
		":\u0000\u000034\u0005*\u0000\u000046\u0005:\u0000\u000053\u0001\u0000"+
		"\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":1\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;?\u0001\u0000\u0000"+
		"\u0000<>\u0003\u0004\u0002\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u000e\u0000\u0000"+
		"C\u0003\u0001\u0000\u0000\u0000DH\u0003\u0014\n\u0000EH\u0003\n\u0005"+
		"\u0000FH\u0003\u0016\u000b\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000"+
		"IJ\u0005:\u0000\u0000J\u0007\u0001\u0000\u0000\u0000KL\u0005:\u0000\u0000"+
		"L\t\u0001\u0000\u0000\u0000MQ\u0005\u0013\u0000\u0000NP\u0003\u0018\f"+
		"\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0005\r\u0000\u0000U\u000b\u0001\u0000\u0000\u0000"+
		"VW\u0003\u0006\u0003\u0000WX\u0003\b\u0004\u0000X\r\u0001\u0000\u0000"+
		"\u0000Y^\u0003\f\u0006\u0000Z[\u0005*\u0000\u0000[]\u0003\f\u0006\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_\u000f\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000ad\u0005%\u0000\u0000be\u0005\u001c\u0000\u0000ce\u0003"+
		"\u000e\u0007\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"e\u0011\u0001\u0000\u0000\u0000fg\u0005\"\u0000\u0000gh\u0007\u0001\u0000"+
		"\u0000h\u0013\u0001\u0000\u0000\u0000ik\u0005\u0006\u0000\u0000ji\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"lm\u0005\u0019\u0000\u0000mn\u0005:\u0000\u0000no\u0003\u0010\b\u0000"+
		"op\u0003\u0012\t\u0000p\u0015\u0001\u0000\u0000\u0000qs\u0007\u0002\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tv\u0005\u0006\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0005\u0012\u0000\u0000"+
		"xy\u0005:\u0000\u0000yz\u0003\u0010\b\u0000z~\u0003\u0012\t\u0000{}\u0003"+
		"\u0018\f\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005"+
		"\n\u0000\u0000\u0082\u0017\u0001\u0000\u0000\u0000\u0083\u0084\u0005$"+
		"\u0000\u0000\u0084\u0086\u0005:\u0000\u0000\u0085\u0087\u0003\u001a\r"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005,\u0000\u0000"+
		"\u0089\u00d6\u0003 \u0010\u0000\u008a\u008c\u0005\u0007\u0000\u0000\u008b"+
		"\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0005\u0000\u0000\u008e"+
		"\u008f\u0005:\u0000\u0000\u008f\u0098\u00056\u0000\u0000\u0090\u0095\u0003"+
		" \u0010\u0000\u0091\u0092\u0005*\u0000\u0000\u0092\u0094\u0003 \u0010"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000"+
		"\u0000\u0098\u0090\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00d6\u00057\u0000\u0000"+
		"\u009b\u009d\u0005#\u0000\u0000\u009c\u009e\u0003 \u0010\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00d6"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0014\u0000\u0000\u00a0\u00a1"+
		"\u0003 \u0010\u0000\u00a1\u00a5\u0005&\u0000\u0000\u00a2\u00a4\u0003\u0018"+
		"\f\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00ab\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00aa\u0003\u001c\u000e\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b0\u0003\u001e\u000f"+
		"\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u000b\u0000"+
		"\u0000\u00b2\u00d6\u0001\u0000\u0000\u0000\u00b3\u00b7\u0005\u0018\u0000"+
		"\u0000\u00b4\u00b6\u0003\u0018\f\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00d6\u0005\f\u0000\u0000\u00bb"+
		"\u00bc\u0005\u0010\u0000\u0000\u00bc\u00d6\u0003 \u0010\u0000\u00bd\u00bf"+
		"\u0007\u0002\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00c2"+
		"\u0005\u0006\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c5"+
		"\u0005\u0017\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8"+
		"\u0003\u0006\u0003\u0000\u00c7\u00c9\u0005\u0004\u0000\u0000\u00c8\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00ce\u0003\b\u0004\u0000\u00cb\u00cd\u0003"+
		"\u001a\r\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d3\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0005,\u0000\u0000\u00d2\u00d4\u0003 \u0010\u0000"+
		"\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u0083\u0001\u0000\u0000\u0000"+
		"\u00d5\u008b\u0001\u0000\u0000\u0000\u00d5\u009b\u0001\u0000\u0000\u0000"+
		"\u00d5\u009f\u0001\u0000\u0000\u0000\u00d5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00d5\u00bb\u0001\u0000\u0000\u0000\u00d5\u00be\u0001\u0000\u0000\u0000"+
		"\u00d6\u0019\u0001\u0000\u0000\u0000\u00d7\u00d9\u00058\u0000\u0000\u00d8"+
		"\u00da\u0003 \u0010\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u00059\u0000\u0000\u00dc\u001b\u0001\u0000\u0000\u0000\u00dd\u00de\u0005"+
		"\t\u0000\u0000\u00de\u00df\u0003 \u0010\u0000\u00df\u00e3\u0005&\u0000"+
		"\u0000\u00e0\u00e2\u0003\u0018\f\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u001d\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00ea\u0005\b\u0000\u0000\u00e7"+
		"\u00e9\u0003\u0018\f\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0001\u0000\u0000\u0000\u00eb\u001f\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0006\u0010\uffff\uffff\u0000\u00ee"+
		"\u00ef\u00056\u0000\u0000\u00ef\u00f0\u0003 \u0010\u0000\u00f0\u00f1\u0005"+
		"7\u0000\u0000\u00f1\u0110\u0001\u0000\u0000\u0000\u00f2\u00f3\u0007\u0003"+
		"\u0000\u0000\u00f3\u0110\u0003 \u0010\u000f\u00f4\u0110\u0005\u001d\u0000"+
		"\u0000\u00f5\u0110\u0007\u0004\u0000\u0000\u00f6\u0110\u0007\u0005\u0000"+
		"\u0000\u00f7\u0110\u0005=\u0000\u0000\u00f8\u0110\u0005\u0002\u0000\u0000"+
		"\u00f9\u00fa\u0005:\u0000\u0000\u00fa\u00fc\u00058\u0000\u0000\u00fb\u00fd"+
		"\u0003 \u0010\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0110\u0005"+
		"9\u0000\u0000\u00ff\u0100\u0005:\u0000\u0000\u0100\u0109\u00056\u0000"+
		"\u0000\u0101\u0106\u0003 \u0010\u0000\u0102\u0103\u0005*\u0000\u0000\u0103"+
		"\u0105\u0003 \u0010\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0108"+
		"\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106"+
		"\u0001\u0000\u0000\u0000\u0109\u0101\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0110"+
		"\u00057\u0000\u0000\u010c\u010d\u0005\u0012\u0000\u0000\u010d\u0110\u0005"+
		":\u0000\u0000\u010e\u0110\u0005:\u0000\u0000\u010f\u00ed\u0001\u0000\u0000"+
		"\u0000\u010f\u00f2\u0001\u0000\u0000\u0000\u010f\u00f4\u0001\u0000\u0000"+
		"\u0000\u010f\u00f5\u0001\u0000\u0000\u0000\u010f\u00f6\u0001\u0000\u0000"+
		"\u0000\u010f\u00f7\u0001\u0000\u0000\u0000\u010f\u00f8\u0001\u0000\u0000"+
		"\u0000\u010f\u00f9\u0001\u0000\u0000\u0000\u010f\u00ff\u0001\u0000\u0000"+
		"\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u010f\u010e\u0001\u0000\u0000"+
		"\u0000\u0110\u0122\u0001\u0000\u0000\u0000\u0111\u0112\n\u000e\u0000\u0000"+
		"\u0112\u0113\u0007\u0006\u0000\u0000\u0113\u0121\u0003 \u0010\u000f\u0114"+
		"\u0115\n\r\u0000\u0000\u0115\u0116\u0007\u0007\u0000\u0000\u0116\u0121"+
		"\u0003 \u0010\u000e\u0117\u0118\n\f\u0000\u0000\u0118\u0119\u0007\b\u0000"+
		"\u0000\u0119\u0121\u0003 \u0010\r\u011a\u011b\n\u000b\u0000\u0000\u011b"+
		"\u011c\u0007\t\u0000\u0000\u011c\u0121\u0003 \u0010\f\u011d\u011e\n\n"+
		"\u0000\u0000\u011e\u011f\u0007\n\u0000\u0000\u011f\u0121\u0003 \u0010"+
		"\u000b\u0120\u0111\u0001\u0000\u0000\u0000\u0120\u0114\u0001\u0000\u0000"+
		"\u0000\u0120\u0117\u0001\u0000\u0000\u0000\u0120\u011a\u0001\u0000\u0000"+
		"\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000"+
		"\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000"+
		"\u0000\u0123!\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000"+
		"\'$&/7:?GQ^djru~\u0086\u008b\u0095\u0098\u009d\u00a5\u00ab\u00af\u00b7"+
		"\u00be\u00c1\u00c4\u00c8\u00ce\u00d3\u00d5\u00d9\u00e3\u00ea\u00fc\u0106"+
		"\u0109\u010f\u0120\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
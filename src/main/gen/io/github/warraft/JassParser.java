// Generated from io/github/warraft/Jass.g4 by ANTLR 4.13.2
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
public class JassParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RAWVAL=1, STRING=2, AND=3, ARRAY=4, CALL=5, CONSTANT=6, DEBUG=7, ELSE=8, 
		ELSEIF=9, ENDFUNCTION=10, ENDIF=11, ENDLOOP=12, ENDGLOBALS=13, EXTENDS=14, 
		EXITWHEN=15, FALSE=16, FUNCTION=17, GLOBALS=18, IF=19, LOCAL=20, LOOP=21, 
		NATIVE=22, NOT=23, NOTHING=24, NULL=25, OR=26, RETURNS=27, RETURN=28, 
		SET=29, TAKES=30, THEN=31, TRUE=32, TYPE=33, COMMA=34, EQ_EQ=35, EQ=36, 
		NEQ=37, LT_EQ=38, LT=39, GT_EQ=40, GT=41, PLUS=42, MINUS=43, MUL=44, DIV=45, 
		LPAREN=46, RPAREN=47, LBRACK=48, RBRACK=49, ID=50, INTVAL=51, HEXVAL=52, 
		REALVAL=53, WS=54, NL=55, LINE_COMMENT=56;
	public static final int
		RULE_root = 0, RULE_typename = 1, RULE_varname = 2, RULE_type = 3, RULE_extendsRule = 4, 
		RULE_globals = 5, RULE_variable = 6, RULE_param = 7, RULE_params = 8, 
		RULE_takes = 9, RULE_returnsRule = 10, RULE_nativeRule = 11, RULE_function = 12, 
		RULE_stmt = 13, RULE_setBrack = 14, RULE_elseif = 15, RULE_elseRule = 16, 
		RULE_expr = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "typename", "varname", "type", "extendsRule", "globals", "variable", 
			"param", "params", "takes", "returnsRule", "nativeRule", "function", 
			"stmt", "setBrack", "elseif", "elseRule", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'and'", "'array'", "'call'", "'constant'", "'debug'", 
			"'else'", "'elseif'", "'endfunction'", "'endif'", "'endloop'", "'endglobals'", 
			"'extends'", "'exitwhen'", "'false'", "'function'", "'globals'", "'if'", 
			"'local'", "'loop'", "'native'", "'not'", "'nothing'", "'null'", "'or'", 
			"'returns'", "'return'", "'set'", "'takes'", "'then'", "'true'", "'type'", 
			"','", "'=='", "'='", "'!='", "'<='", "'<'", "'>='", "'>'", "'+'", "'-'", 
			"'*'", "'/'", "'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RAWVAL", "STRING", "AND", "ARRAY", "CALL", "CONSTANT", "DEBUG", 
			"ELSE", "ELSEIF", "ENDFUNCTION", "ENDIF", "ENDLOOP", "ENDGLOBALS", "EXTENDS", 
			"EXITWHEN", "FALSE", "FUNCTION", "GLOBALS", "IF", "LOCAL", "LOOP", "NATIVE", 
			"NOT", "NOTHING", "NULL", "OR", "RETURNS", "RETURN", "SET", "TAKES", 
			"THEN", "TRUE", "TYPE", "COMMA", "EQ_EQ", "EQ", "NEQ", "LT_EQ", "LT", 
			"GT_EQ", "GT", "PLUS", "MINUS", "MUL", "DIV", "LPAREN", "RPAREN", "LBRACK", 
			"RBRACK", "ID", "INTVAL", "HEXVAL", "REALVAL", "WS", "NL", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Jass.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JassParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JassParser.EOF, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<NativeRuleContext> nativeRule() {
			return getRuleContexts(NativeRuleContext.class);
		}
		public NativeRuleContext nativeRule(int i) {
			return getRuleContext(NativeRuleContext.class,i);
		}
		public List<GlobalsContext> globals() {
			return getRuleContexts(GlobalsContext.class);
		}
		public GlobalsContext globals(int i) {
			return getRuleContext(GlobalsContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
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
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8594522176L) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					type();
					}
					break;
				case 2:
					{
					setState(37);
					nativeRule();
					}
					break;
				case 3:
					{
					setState(38);
					globals();
					}
					break;
				case 4:
					{
					setState(39);
					function();
					}
					break;
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(JassParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public ExtendsRuleContext extendsRule() {
			return getRuleContext(ExtendsRuleContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(TYPE);
			setState(52);
			match(ID);
			setState(53);
			extendsRule();
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
	public static class ExtendsRuleContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(JassParser.EXTENDS, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public ExtendsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsRule; }
	}

	public final ExtendsRuleContext extendsRule() throws RecognitionException {
		ExtendsRuleContext _localctx = new ExtendsRuleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extendsRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(EXTENDS);
			setState(56);
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
		public TerminalNode GLOBALS() { return getToken(JassParser.GLOBALS, 0); }
		public TerminalNode ENDGLOBALS() { return getToken(JassParser.ENDGLOBALS, 0); }
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
			setState(58);
			match(GLOBALS);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899907891264L) != 0)) {
				{
				{
				setState(59);
				variable();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
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
		public TerminalNode CONSTANT() { return getToken(JassParser.CONSTANT, 0); }
		public TerminalNode LOCAL() { return getToken(JassParser.LOCAL, 0); }
		public TerminalNode ARRAY() { return getToken(JassParser.ARRAY, 0); }
		public TerminalNode EQ() { return getToken(JassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(67);
				match(CONSTANT);
				}
			}

			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(70);
				match(LOCAL);
				}
			}

			setState(73);
			typename();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARRAY) {
				{
				setState(74);
				match(ARRAY);
				}
			}

			setState(77);
			varname();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(78);
				match(EQ);
				setState(79);
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
			setState(82);
			typename();
			setState(83);
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
		public List<TerminalNode> COMMA() { return getTokens(JassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JassParser.COMMA, i);
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
			setState(85);
			param();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86);
				match(COMMA);
				setState(87);
				param();
				}
				}
				setState(92);
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
		public TerminalNode TAKES() { return getToken(JassParser.TAKES, 0); }
		public TerminalNode NOTHING() { return getToken(JassParser.NOTHING, 0); }
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
			setState(93);
			match(TAKES);
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(94);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(95);
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
		public TerminalNode RETURNS() { return getToken(JassParser.RETURNS, 0); }
		public TerminalNode NOTHING() { return getToken(JassParser.NOTHING, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
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
			setState(98);
			match(RETURNS);
			setState(99);
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
		public TerminalNode NATIVE() { return getToken(JassParser.NATIVE, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public ReturnsRuleContext returnsRule() {
			return getRuleContext(ReturnsRuleContext.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(JassParser.CONSTANT, 0); }
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
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(101);
				match(CONSTANT);
				}
			}

			setState(104);
			match(NATIVE);
			setState(105);
			match(ID);
			setState(106);
			takes();
			setState(107);
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
		public TerminalNode FUNCTION() { return getToken(JassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public ReturnsRuleContext returnsRule() {
			return getRuleContext(ReturnsRuleContext.class,0);
		}
		public TerminalNode ENDFUNCTION() { return getToken(JassParser.ENDFUNCTION, 0); }
		public TerminalNode CONSTANT() { return getToken(JassParser.CONSTANT, 0); }
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
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(109);
				match(CONSTANT);
				}
			}

			setState(112);
			match(FUNCTION);
			setState(113);
			match(ID);
			setState(114);
			takes();
			setState(115);
			returnsRule();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899907891264L) != 0)) {
				{
				{
				setState(116);
				variable();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
				{
				{
				setState(122);
				stmt();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
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
		public TerminalNode IF() { return getToken(JassParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(JassParser.THEN, 0); }
		public TerminalNode ENDIF() { return getToken(JassParser.ENDIF, 0); }
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
		public TerminalNode CALL() { return getToken(JassParser.CALL, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(JassParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JassParser.RPAREN, 0); }
		public TerminalNode DEBUG() { return getToken(JassParser.DEBUG, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JassParser.COMMA, i);
		}
		public StmtCallContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtExitWhenContext extends StmtContext {
		public TerminalNode EXITWHEN() { return getToken(JassParser.EXITWHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtExitWhenContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtLoopContext extends StmtContext {
		public TerminalNode LOOP() { return getToken(JassParser.LOOP, 0); }
		public TerminalNode ENDLOOP() { return getToken(JassParser.ENDLOOP, 0); }
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
		public TerminalNode SET() { return getToken(JassParser.SET, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TerminalNode EQ() { return getToken(JassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SetBrackContext setBrack() {
			return getRuleContext(SetBrackContext.class,0);
		}
		public StmtSetContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtReturnContext extends StmtContext {
		public TerminalNode RETURN() { return getToken(JassParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtReturnContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				_localctx = new StmtSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(SET);
				setState(131);
				match(ID);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(132);
					setBrack();
					}
				}

				setState(135);
				match(EQ);
				setState(136);
				expr(0);
				}
				break;
			case CALL:
			case DEBUG:
				_localctx = new StmtCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEBUG) {
					{
					setState(137);
					match(DEBUG);
					}
				}

				setState(140);
				match(CALL);
				setState(141);
				match(ID);
				setState(142);
				match(LPAREN);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(143);
					expr(0);
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(144);
						match(COMMA);
						setState(145);
						expr(0);
						}
						}
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(153);
				match(RPAREN);
				}
				break;
			case RETURN:
				_localctx = new StmtReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(RETURN);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(155);
					expr(0);
					}
				}

				}
				break;
			case IF:
				_localctx = new StmtIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				match(IF);
				setState(159);
				expr(0);
				setState(160);
				match(THEN);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
					{
					{
					setState(161);
					stmt();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELSEIF) {
					{
					{
					setState(167);
					elseif();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(173);
					elseRule();
					}
				}

				setState(176);
				match(ENDIF);
				}
				break;
			case LOOP:
				_localctx = new StmtLoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(LOOP);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
					{
					{
					setState(179);
					stmt();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(185);
				match(ENDLOOP);
				}
				break;
			case EXITWHEN:
				_localctx = new StmtExitWhenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				match(EXITWHEN);
				setState(187);
				expr(0);
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
	public static class SetBrackContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(JassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JassParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SetBrackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setBrack; }
	}

	public final SetBrackContext setBrack() throws RecognitionException {
		SetBrackContext _localctx = new SetBrackContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_setBrack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(LBRACK);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
				{
				setState(191);
				expr(0);
				}
			}

			setState(194);
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
		public TerminalNode ELSEIF() { return getToken(JassParser.ELSEIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(JassParser.THEN, 0); }
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
		enterRule(_localctx, 30, RULE_elseif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(ELSEIF);
			setState(197);
			expr(0);
			setState(198);
			match(THEN);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
				{
				{
				setState(199);
				stmt();
				}
				}
				setState(204);
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
		public TerminalNode ELSE() { return getToken(JassParser.ELSE, 0); }
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
		enterRule(_localctx, 32, RULE_elseRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(ELSE);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
				{
				{
				setState(206);
				stmt();
				}
				}
				setState(211);
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
		public TerminalNode INTVAL() { return getToken(JassParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(JassParser.HEXVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(JassParser.RAWVAL, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(JassParser.STRING, 0); }
		public ExprStrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(JassParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(JassParser.NOT, 0); }
		public ExprUnContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVarContext extends ExprContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
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
		public TerminalNode EQ_EQ() { return getToken(JassParser.EQ_EQ, 0); }
		public TerminalNode NEQ() { return getToken(JassParser.NEQ, 0); }
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(JassParser.NULL, 0); }
		public ExprNullContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFunContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(JassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public ExprFunContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(JassParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JassParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(JassParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JassParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JassParser.COMMA, i);
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
		public TerminalNode LT() { return getToken(JassParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(JassParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(JassParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(JassParser.GT_EQ, 0); }
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
		public TerminalNode MUL() { return getToken(JassParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JassParser.DIV, 0); }
		public ExprMulContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprArrContext extends ExprContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(JassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JassParser.RBRACK, 0); }
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
		public TerminalNode MINUS() { return getToken(JassParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(JassParser.PLUS, 0); }
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(JassParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JassParser.FALSE, 0); }
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
		public TerminalNode AND() { return getToken(JassParser.AND, 0); }
		public TerminalNode OR() { return getToken(JassParser.OR, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REALVAL() { return getToken(JassParser.REALVAL, 0); }
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				match(LPAREN);
				setState(214);
				expr(0);
				setState(215);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
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
				setState(221);
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
				setState(222);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(ID);
				setState(225);
				match(LBRACK);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(226);
					expr(0);
					}
				}

				setState(229);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(ID);
				setState(231);
				match(LPAREN);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(232);
					expr(0);
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(233);
						match(COMMA);
						setState(234);
						expr(0);
						}
						}
						setState(239);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(242);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				match(FUNCTION);
				setState(244);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(263);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(249);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(252);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
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
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(255);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
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
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(258);
						_la = _input.LA(1);
						if ( !(_la==EQ_EQ || _la==NEQ) ) {
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
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(260);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(261);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
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
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		case 17:
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
		"\u0004\u00018\u010d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005=\b\u0005\n\u0005\f\u0005"+
		"@\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006E\b\u0006\u0001"+
		"\u0006\u0003\u0006H\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006L\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006Q\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bY\b\b\n\b\f\b"+
		"\\\t\b\u0001\t\u0001\t\u0001\t\u0003\ta\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0003\u000bg\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0003\fo\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\fv\b\f\n\f\f\fy\t\f\u0001\f\u0005\f|\b\f\n\f\f\f\u007f"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\r\u0086\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u008b\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0093\b\r\n\r\f\r\u0096\t\r\u0003\r\u0098\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u009d\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00a3\b\r\n\r\f\r\u00a6\t\r\u0001\r\u0005\r\u00a9\b\r\n\r\f\r\u00ac"+
		"\t\r\u0001\r\u0003\r\u00af\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u00b5\b\r\n\r\f\r\u00b8\t\r\u0001\r\u0001\r\u0001\r\u0003\r\u00bd\b\r"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00c1\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00c9\b\u000f"+
		"\n\u000f\f\u000f\u00cc\t\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00d0"+
		"\b\u0010\n\u0010\f\u0010\u00d3\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00e4\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00ec\b\u0011\n\u0011\f\u0011\u00ef"+
		"\t\u0011\u0003\u0011\u00f1\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00f7\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0108\b\u0011\n\u0011\f\u0011\u010b\t\u0011\u0001\u0011\u0000"+
		"\u0001\"\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"\u0000\t\u0002\u0000\u0018\u001822\u0002\u0000"+
		"\u0017\u0017++\u0002\u0000\u0010\u0010  \u0002\u0000\u0001\u000134\u0001"+
		"\u0000,-\u0001\u0000*+\u0001\u0000&)\u0002\u0000##%%\u0002\u0000\u0003"+
		"\u0003\u001a\u001a\u012c\u0000*\u0001\u0000\u0000\u0000\u0002/\u0001\u0000"+
		"\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000"+
		"\b7\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000\u0000\fD\u0001\u0000"+
		"\u0000\u0000\u000eR\u0001\u0000\u0000\u0000\u0010U\u0001\u0000\u0000\u0000"+
		"\u0012]\u0001\u0000\u0000\u0000\u0014b\u0001\u0000\u0000\u0000\u0016f"+
		"\u0001\u0000\u0000\u0000\u0018n\u0001\u0000\u0000\u0000\u001a\u00bc\u0001"+
		"\u0000\u0000\u0000\u001c\u00be\u0001\u0000\u0000\u0000\u001e\u00c4\u0001"+
		"\u0000\u0000\u0000 \u00cd\u0001\u0000\u0000\u0000\"\u00f6\u0001\u0000"+
		"\u0000\u0000$)\u0003\u0006\u0003\u0000%)\u0003\u0016\u000b\u0000&)\u0003"+
		"\n\u0005\u0000\')\u0003\u0018\f\u0000($\u0001\u0000\u0000\u0000(%\u0001"+
		"\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000"+
		"),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0005\u0000"+
		"\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/0\u00052\u0000\u00000\u0003"+
		"\u0001\u0000\u0000\u000012\u00052\u0000\u00002\u0005\u0001\u0000\u0000"+
		"\u000034\u0005!\u0000\u000045\u00052\u0000\u000056\u0003\b\u0004\u0000"+
		"6\u0007\u0001\u0000\u0000\u000078\u0005\u000e\u0000\u000089\u00052\u0000"+
		"\u00009\t\u0001\u0000\u0000\u0000:>\u0005\u0012\u0000\u0000;=\u0003\f"+
		"\u0006\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000AB\u0005\r\u0000\u0000B\u000b\u0001\u0000\u0000"+
		"\u0000CE\u0005\u0006\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000EG\u0001\u0000\u0000\u0000FH\u0005\u0014\u0000\u0000GF\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IK\u0003\u0002\u0001\u0000JL\u0005\u0004\u0000\u0000KJ\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MP\u0003\u0004"+
		"\u0002\u0000NO\u0005$\u0000\u0000OQ\u0003\"\u0011\u0000PN\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\r\u0001\u0000\u0000\u0000RS\u0003"+
		"\u0002\u0001\u0000ST\u0003\u0004\u0002\u0000T\u000f\u0001\u0000\u0000"+
		"\u0000UZ\u0003\u000e\u0007\u0000VW\u0005\"\u0000\u0000WY\u0003\u000e\u0007"+
		"\u0000XV\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u0011\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]`\u0005\u001e\u0000\u0000^a\u0005\u0018\u0000"+
		"\u0000_a\u0003\u0010\b\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000"+
		"\u0000a\u0013\u0001\u0000\u0000\u0000bc\u0005\u001b\u0000\u0000cd\u0007"+
		"\u0000\u0000\u0000d\u0015\u0001\u0000\u0000\u0000eg\u0005\u0006\u0000"+
		"\u0000fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0005\u0016\u0000\u0000ij\u00052\u0000\u0000jk\u0003\u0012"+
		"\t\u0000kl\u0003\u0014\n\u0000l\u0017\u0001\u0000\u0000\u0000mo\u0005"+
		"\u0006\u0000\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pq\u0005\u0011\u0000\u0000qr\u00052\u0000\u0000"+
		"rs\u0003\u0012\t\u0000sw\u0003\u0014\n\u0000tv\u0003\f\u0006\u0000ut\u0001"+
		"\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000x}\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000z|\u0003\u001a\r\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		"\n\u0000\u0000\u0081\u0019\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u001d"+
		"\u0000\u0000\u0083\u0085\u00052\u0000\u0000\u0084\u0086\u0003\u001c\u000e"+
		"\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0005$\u0000\u0000"+
		"\u0088\u00bd\u0003\"\u0011\u0000\u0089\u008b\u0005\u0007\u0000\u0000\u008a"+
		"\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0005\u0000\u0000\u008d"+
		"\u008e\u00052\u0000\u0000\u008e\u0097\u0005.\u0000\u0000\u008f\u0094\u0003"+
		"\"\u0011\u0000\u0090\u0091\u0005\"\u0000\u0000\u0091\u0093\u0003\"\u0011"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0097\u008f\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u00bd\u0005/\u0000\u0000"+
		"\u009a\u009c\u0005\u001c\u0000\u0000\u009b\u009d\u0003\"\u0011\u0000\u009c"+
		"\u009b\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u00bd\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0013\u0000\u0000\u009f"+
		"\u00a0\u0003\"\u0011\u0000\u00a0\u00a4\u0005\u001f\u0000\u0000\u00a1\u00a3"+
		"\u0003\u001a\r\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00aa\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u0003\u001e\u000f\u0000\u00a8\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00af\u0003"+
		" \u0010\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u000b"+
		"\u0000\u0000\u00b1\u00bd\u0001\u0000\u0000\u0000\u00b2\u00b6\u0005\u0015"+
		"\u0000\u0000\u00b3\u00b5\u0003\u001a\r\u0000\u00b4\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bd\u0005\f\u0000\u0000"+
		"\u00ba\u00bb\u0005\u000f\u0000\u0000\u00bb\u00bd\u0003\"\u0011\u0000\u00bc"+
		"\u0082\u0001\u0000\u0000\u0000\u00bc\u008a\u0001\u0000\u0000\u0000\u00bc"+
		"\u009a\u0001\u0000\u0000\u0000\u00bc\u009e\u0001\u0000\u0000\u0000\u00bc"+
		"\u00b2\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd"+
		"\u001b\u0001\u0000\u0000\u0000\u00be\u00c0\u00050\u0000\u0000\u00bf\u00c1"+
		"\u0003\"\u0011\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"1\u0000\u0000\u00c3\u001d\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\t"+
		"\u0000\u0000\u00c5\u00c6\u0003\"\u0011\u0000\u00c6\u00ca\u0005\u001f\u0000"+
		"\u0000\u00c7\u00c9\u0003\u001a\r\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u001f\u0001\u0000\u0000\u0000"+
		"\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00d1\u0005\b\u0000\u0000\u00ce"+
		"\u00d0\u0003\u001a\r\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d2!\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0006\u0011\uffff\uffff\u0000\u00d5\u00d6"+
		"\u0005.\u0000\u0000\u00d6\u00d7\u0003\"\u0011\u0000\u00d7\u00d8\u0005"+
		"/\u0000\u0000\u00d8\u00f7\u0001\u0000\u0000\u0000\u00d9\u00da\u0007\u0001"+
		"\u0000\u0000\u00da\u00f7\u0003\"\u0011\u000f\u00db\u00f7\u0005\u0019\u0000"+
		"\u0000\u00dc\u00f7\u0007\u0002\u0000\u0000\u00dd\u00f7\u0007\u0003\u0000"+
		"\u0000\u00de\u00f7\u00055\u0000\u0000\u00df\u00f7\u0005\u0002\u0000\u0000"+
		"\u00e0\u00e1\u00052\u0000\u0000\u00e1\u00e3\u00050\u0000\u0000\u00e2\u00e4"+
		"\u0003\"\u0011\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00f7\u0005"+
		"1\u0000\u0000\u00e6\u00e7\u00052\u0000\u0000\u00e7\u00f0\u0005.\u0000"+
		"\u0000\u00e8\u00ed\u0003\"\u0011\u0000\u00e9\u00ea\u0005\"\u0000\u0000"+
		"\u00ea\u00ec\u0003\"\u0011\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f0\u00e8\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f7\u0005/\u0000\u0000\u00f3\u00f4\u0005\u0011\u0000\u0000\u00f4\u00f7"+
		"\u00052\u0000\u0000\u00f5\u00f7\u00052\u0000\u0000\u00f6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00f6\u00d9\u0001\u0000\u0000\u0000\u00f6\u00db\u0001\u0000"+
		"\u0000\u0000\u00f6\u00dc\u0001\u0000\u0000\u0000\u00f6\u00dd\u0001\u0000"+
		"\u0000\u0000\u00f6\u00de\u0001\u0000\u0000\u0000\u00f6\u00df\u0001\u0000"+
		"\u0000\u0000\u00f6\u00e0\u0001\u0000\u0000\u0000\u00f6\u00e6\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f7\u0109\u0001\u0000\u0000\u0000\u00f8\u00f9\n\u000e\u0000"+
		"\u0000\u00f9\u00fa\u0007\u0004\u0000\u0000\u00fa\u0108\u0003\"\u0011\u000f"+
		"\u00fb\u00fc\n\r\u0000\u0000\u00fc\u00fd\u0007\u0005\u0000\u0000\u00fd"+
		"\u0108\u0003\"\u0011\u000e\u00fe\u00ff\n\f\u0000\u0000\u00ff\u0100\u0007"+
		"\u0006\u0000\u0000\u0100\u0108\u0003\"\u0011\r\u0101\u0102\n\u000b\u0000"+
		"\u0000\u0102\u0103\u0007\u0007\u0000\u0000\u0103\u0108\u0003\"\u0011\f"+
		"\u0104\u0105\n\n\u0000\u0000\u0105\u0106\u0007\b\u0000\u0000\u0106\u0108"+
		"\u0003\"\u0011\u000b\u0107\u00f8\u0001\u0000\u0000\u0000\u0107\u00fb\u0001"+
		"\u0000\u0000\u0000\u0107\u00fe\u0001\u0000\u0000\u0000\u0107\u0101\u0001"+
		"\u0000\u0000\u0000\u0107\u0104\u0001\u0000\u0000\u0000\u0108\u010b\u0001"+
		"\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010a#\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000 (*>DGKPZ`fnw}\u0085\u008a\u0094\u0097\u009c\u00a4\u00aa\u00ae"+
		"\u00b6\u00bc\u00c0\u00ca\u00d1\u00e3\u00ed\u00f0\u00f6\u0107\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from /Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/main/raft/war/grammar/Jass.g4 by ANTLR 4.13.2
package raft.war.grammar.Jass;
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
		RULE_root = 0, RULE_typename = 1, RULE_varname = 2, RULE_funname = 3, 
		RULE_type = 4, RULE_extends = 5, RULE_globals = 6, RULE_variable = 7, 
		RULE_param = 8, RULE_params = 9, RULE_takes = 10, RULE_returns_ = 11, 
		RULE_native = 12, RULE_function = 13, RULE_stmt = 14, RULE_set = 15, RULE_call = 16, 
		RULE_return = 17, RULE_if = 18, RULE_elseif = 19, RULE_else = 20, RULE_loop = 21, 
		RULE_exitwhen = 22, RULE_expr = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "typename", "varname", "funname", "type", "extends", "globals", 
			"variable", "param", "params", "takes", "returns_", "native", "function", 
			"stmt", "set", "call", "return", "if", "elseif", "else", "loop", "exitwhen", 
			"expr"
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
		public List<NativeContext> native_() {
			return getRuleContexts(NativeContext.class);
		}
		public NativeContext native_(int i) {
			return getRuleContext(NativeContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8594522176L) != 0)) {
				{
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(48);
					type();
					}
					break;
				case 2:
					{
					setState(49);
					native_();
					}
					break;
				case 3:
					{
					setState(50);
					globals();
					}
					break;
				case 4:
					{
					setState(51);
					function();
					}
					break;
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterTypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitTypename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitTypename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterVarname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitVarname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitVarname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
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
	public static class FunnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public FunnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterFunname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitFunname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitFunname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunnameContext funname() throws RecognitionException {
		FunnameContext _localctx = new FunnameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
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
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ExtendsContext extends_() {
			return getRuleContext(ExtendsContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(TYPE);
			setState(66);
			typename();
			setState(67);
			extends_();
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
	public static class ExtendsContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(JassParser.EXTENDS, 0); }
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExtends(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExtends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsContext extends_() throws RecognitionException {
		ExtendsContext _localctx = new ExtendsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(EXTENDS);
			setState(70);
			typename();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterGlobals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitGlobals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitGlobals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalsContext globals() throws RecognitionException {
		GlobalsContext _localctx = new GlobalsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_globals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(GLOBALS);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899907891264L) != 0)) {
				{
				{
				setState(73);
				variable();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(81);
				match(CONSTANT);
				}
			}

			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(84);
				match(LOCAL);
				}
			}

			setState(87);
			typename();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARRAY) {
				{
				setState(88);
				match(ARRAY);
				}
			}

			setState(91);
			varname();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(92);
				match(EQ);
				setState(93);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			typename();
			setState(97);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			param();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				param();
				}
				}
				setState(106);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterTakes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitTakes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitTakes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TakesContext takes() throws RecognitionException {
		TakesContext _localctx = new TakesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_takes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(TAKES);
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(108);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(109);
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
	public static class Returns_Context extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(JassParser.RETURNS, 0); }
		public TerminalNode NOTHING() { return getToken(JassParser.NOTHING, 0); }
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public Returns_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returns_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterReturns_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitReturns_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitReturns_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Returns_Context returns_() throws RecognitionException {
		Returns_Context _localctx = new Returns_Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_returns_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(RETURNS);
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(113);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(114);
				typename();
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
	public static class NativeContext extends ParserRuleContext {
		public TerminalNode NATIVE() { return getToken(JassParser.NATIVE, 0); }
		public FunnameContext funname() {
			return getRuleContext(FunnameContext.class,0);
		}
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public Returns_Context returns_() {
			return getRuleContext(Returns_Context.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(JassParser.CONSTANT, 0); }
		public NativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_native; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterNative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitNative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitNative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeContext native_() throws RecognitionException {
		NativeContext _localctx = new NativeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_native);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(117);
				match(CONSTANT);
				}
			}

			setState(120);
			match(NATIVE);
			setState(121);
			funname();
			setState(122);
			takes();
			setState(123);
			returns_();
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
		public FunnameContext funname() {
			return getRuleContext(FunnameContext.class,0);
		}
		public TakesContext takes() {
			return getRuleContext(TakesContext.class,0);
		}
		public Returns_Context returns_() {
			return getRuleContext(Returns_Context.class,0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(125);
				match(CONSTANT);
				}
			}

			setState(128);
			match(FUNCTION);
			setState(129);
			funname();
			setState(130);
			takes();
			setState(131);
			returns_();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899907891264L) != 0)) {
				{
				{
				setState(132);
				variable();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
				{
				{
				setState(138);
				stmt();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ExitwhenContext exitwhen() {
			return getRuleContext(ExitwhenContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				set();
				}
				break;
			case CALL:
			case DEBUG:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				call();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				return_();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				if_();
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				loop();
				}
				break;
			case EXITWHEN:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
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
	public static class SetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(JassParser.SET, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(JassParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(JassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JassParser.RBRACK, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(SET);
			setState(155);
			varname();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(156);
				match(LBRACK);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(157);
					expr(0);
					}
				}

				setState(160);
				match(RBRACK);
				}
			}

			setState(163);
			match(EQ);
			setState(164);
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
		public TerminalNode CALL() { return getToken(JassParser.CALL, 0); }
		public FunnameContext funname() {
			return getRuleContext(FunnameContext.class,0);
		}
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
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEBUG) {
				{
				setState(166);
				match(DEBUG);
				}
			}

			setState(169);
			match(CALL);
			setState(170);
			funname();
			setState(171);
			match(LPAREN);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
				{
				setState(172);
				expr(0);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(173);
					match(COMMA);
					setState(174);
					expr(0);
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(182);
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
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(JassParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(RETURN);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
				{
				setState(185);
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(JassParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(JassParser.ENDIF, 0); }
		public TerminalNode THEN() { return getToken(JassParser.THEN, 0); }
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
		public List<ElseContext> else_() {
			return getRuleContexts(ElseContext.class);
		}
		public ElseContext else_(int i) {
			return getRuleContext(ElseContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(IF);
			setState(189);
			expr(0);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEN) {
				{
				setState(190);
				match(THEN);
				}
			}

			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807961504L) != 0)) {
				{
				setState(196);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CALL:
				case DEBUG:
				case EXITWHEN:
				case IF:
				case LOOP:
				case RETURN:
				case SET:
					{
					setState(193);
					stmt();
					}
					break;
				case ELSEIF:
					{
					setState(194);
					elseif();
					}
					break;
				case ELSE:
					{
					setState(195);
					else_();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitElseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseif);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(ELSEIF);
			setState(204);
			expr(0);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEN) {
				{
				setState(205);
				match(THEN);
				}
			}

			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					stmt();
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(JassParser.ELSE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_else);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(ELSE);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(215);
					stmt();
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		public TerminalNode LOOP() { return getToken(JassParser.LOOP, 0); }
		public TerminalNode ENDLOOP() { return getToken(JassParser.ENDLOOP, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(LOOP);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 807960736L) != 0)) {
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
			setState(228);
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
		public TerminalNode EXITWHEN() { return getToken(JassParser.EXITWHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExitwhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitwhen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExitwhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExitwhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExitwhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitwhenContext exitwhen() throws RecognitionException {
		ExitwhenContext _localctx = new ExitwhenContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exitwhen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(EXITWHEN);
			setState(231);
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
		public TerminalNode INTVAL() { return getToken(JassParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(JassParser.HEXVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(JassParser.RAWVAL, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLtEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT_EQ() { return getToken(JassParser.LT_EQ, 0); }
		public ExprLtEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprLtEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprLtEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprLtEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(JassParser.STRING, 0); }
		public ExprStrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprStr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(JassParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(JassParser.NOT, 0); }
		public ExprUnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprUn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprUn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprUn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprGtEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT_EQ() { return getToken(JassParser.GT_EQ, 0); }
		public ExprGtEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprGtEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprGtEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprGtEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVarContext extends ExprContext {
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public ExprVarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprVar(this);
			else return visitor.visitChildren(this);
		}
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
		public ExprEqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprGtContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(JassParser.GT, 0); }
		public ExprGtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprGt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprGt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(JassParser.NULL, 0); }
		public ExprNullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFunContext extends ExprContext {
		public TerminalNode FUNCTION() { return getToken(JassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public ExprFunContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprFun(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(JassParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JassParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(JassParser.OR, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprCall(this);
			else return visitor.visitChildren(this);
		}
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
		public ExprLtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprLt(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprMul(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprArr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprArr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprArr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(JassParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JassParser.FALSE, 0); }
		public ExprBoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprBool(this);
			else return visitor.visitChildren(this);
		}
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
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealContext extends ExprContext {
		public TerminalNode REALVAL() { return getToken(JassParser.REALVAL, 0); }
		public ExprRealContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprReal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNeqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(JassParser.NEQ, 0); }
		public ExprNeqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExprNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExprNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExprNeq(this);
			else return visitor.visitChildren(this);
		}
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
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(234);
				match(LPAREN);
				setState(235);
				expr(0);
				setState(236);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ExprUnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(239);
				expr(20);
				}
				break;
			case 3:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(NULL);
				}
				break;
			case 4:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
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
				setState(242);
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
				setState(243);
				match(REALVAL);
				}
				break;
			case 7:
				{
				_localctx = new ExprStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprArrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(ID);
				setState(246);
				match(LBRACK);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(247);
					expr(0);
					}
				}

				setState(250);
				match(RBRACK);
				}
				break;
			case 9:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(ID);
				setState(252);
				match(LPAREN);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16967667776946182L) != 0)) {
					{
					setState(253);
					expr(0);
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(254);
						match(COMMA);
						setState(255);
						expr(0);
						}
						}
						setState(260);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(263);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ExprFunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(FUNCTION);
				setState(265);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ExprVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(270);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(271);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(273);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(274);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(275);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(276);
						match(EQ_EQ);
						setState(277);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprNeqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(278);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(279);
						match(NEQ);
						setState(280);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprLtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(282);
						match(LT);
						setState(283);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprLtEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(284);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(285);
						match(LT_EQ);
						setState(286);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprGtContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(287);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(288);
						match(GT);
						setState(289);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new ExprGtEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(290);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(291);
						match(GT_EQ);
						setState(292);
						expr(13);
						}
						break;
					case 9:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(293);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(294);
						match(OR);
						setState(295);
						expr(12);
						}
						break;
					case 10:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(296);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(297);
						match(AND);
						setState(298);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
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
		"\u0004\u00018\u0131\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u00005\b\u0000\n\u0000\f\u00008\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006"+
		"K\b\u0006\n\u0006\f\u0006N\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0003\u0007S\b\u0007\u0001\u0007\u0003\u0007V\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007Z\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007_\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\tg\b\t\n\t\f\tj\t\t\u0001\n\u0001\n\u0001\n\u0003\no\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000bt\b\u000b\u0001\f\u0003\fw\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0003\r\u007f\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u0086\b\r\n\r\f\r\u0089\t\r\u0001\r"+
		"\u0005\r\u008c\b\r\n\r\f\r\u008f\t\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0099"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u009f"+
		"\b\u000f\u0001\u000f\u0003\u000f\u00a2\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0003\u0010\u00a8\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00b0\b\u0010"+
		"\n\u0010\f\u0010\u00b3\t\u0010\u0003\u0010\u00b5\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00bb\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00c0\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u00c5\b\u0012\n\u0012\f\u0012\u00c8\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00cf\b\u0013"+
		"\u0001\u0013\u0005\u0013\u00d2\b\u0013\n\u0013\f\u0013\u00d5\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u00d9\b\u0014\n\u0014\f\u0014\u00dc\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u00e0\b\u0015\n\u0015\f\u0015\u00e3"+
		"\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00f9\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0101"+
		"\b\u0017\n\u0017\f\u0017\u0104\t\u0017\u0003\u0017\u0106\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u010c\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u012c\b\u0017\n\u0017\f\u0017\u012f\t\u0017\u0001\u0017\u0000\u0001"+
		".\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.\u0000\u0005\u0002\u0000\u0017\u0017++\u0002"+
		"\u0000\u0010\u0010  \u0002\u0000\u0001\u000134\u0001\u0000,-\u0001\u0000"+
		"*+\u0152\u00006\u0001\u0000\u0000\u0000\u0002;\u0001\u0000\u0000\u0000"+
		"\u0004=\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bA\u0001"+
		"\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000\fH\u0001\u0000\u0000\u0000"+
		"\u000eR\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000\u0000\u0012c"+
		"\u0001\u0000\u0000\u0000\u0014k\u0001\u0000\u0000\u0000\u0016p\u0001\u0000"+
		"\u0000\u0000\u0018v\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000"+
		"\u001c\u0098\u0001\u0000\u0000\u0000\u001e\u009a\u0001\u0000\u0000\u0000"+
		" \u00a7\u0001\u0000\u0000\u0000\"\u00b8\u0001\u0000\u0000\u0000$\u00bc"+
		"\u0001\u0000\u0000\u0000&\u00cb\u0001\u0000\u0000\u0000(\u00d6\u0001\u0000"+
		"\u0000\u0000*\u00dd\u0001\u0000\u0000\u0000,\u00e6\u0001\u0000\u0000\u0000"+
		".\u010b\u0001\u0000\u0000\u000005\u0003\b\u0004\u000015\u0003\u0018\f"+
		"\u000025\u0003\f\u0006\u000035\u0003\u001a\r\u000040\u0001\u0000\u0000"+
		"\u000041\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000043\u0001\u0000"+
		"\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u000079\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"9:\u0005\u0000\u0000\u0001:\u0001\u0001\u0000\u0000\u0000;<\u00052\u0000"+
		"\u0000<\u0003\u0001\u0000\u0000\u0000=>\u00052\u0000\u0000>\u0005\u0001"+
		"\u0000\u0000\u0000?@\u00052\u0000\u0000@\u0007\u0001\u0000\u0000\u0000"+
		"AB\u0005!\u0000\u0000BC\u0003\u0002\u0001\u0000CD\u0003\n\u0005\u0000"+
		"D\t\u0001\u0000\u0000\u0000EF\u0005\u000e\u0000\u0000FG\u0003\u0002\u0001"+
		"\u0000G\u000b\u0001\u0000\u0000\u0000HL\u0005\u0012\u0000\u0000IK\u0003"+
		"\u000e\u0007\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000OP\u0005\r\u0000\u0000P\r\u0001\u0000"+
		"\u0000\u0000QS\u0005\u0006\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TV\u0005\u0014\u0000\u0000"+
		"UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WY\u0003\u0002\u0001\u0000XZ\u0005\u0004\u0000\u0000YX\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0003"+
		"\u0004\u0002\u0000\\]\u0005$\u0000\u0000]_\u0003.\u0017\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u000f\u0001\u0000\u0000"+
		"\u0000`a\u0003\u0002\u0001\u0000ab\u0003\u0004\u0002\u0000b\u0011\u0001"+
		"\u0000\u0000\u0000ch\u0003\u0010\b\u0000de\u0005\"\u0000\u0000eg\u0003"+
		"\u0010\b\u0000fd\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0013\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000kn\u0005\u001e\u0000\u0000lo\u0005\u0018"+
		"\u0000\u0000mo\u0003\u0012\t\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000"+
		"\u0000\u0000o\u0015\u0001\u0000\u0000\u0000ps\u0005\u001b\u0000\u0000"+
		"qt\u0005\u0018\u0000\u0000rt\u0003\u0002\u0001\u0000sq\u0001\u0000\u0000"+
		"\u0000sr\u0001\u0000\u0000\u0000t\u0017\u0001\u0000\u0000\u0000uw\u0005"+
		"\u0006\u0000\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xy\u0005\u0016\u0000\u0000yz\u0003\u0006\u0003"+
		"\u0000z{\u0003\u0014\n\u0000{|\u0003\u0016\u000b\u0000|\u0019\u0001\u0000"+
		"\u0000\u0000}\u007f\u0005\u0006\u0000\u0000~}\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\u0011\u0000\u0000\u0081\u0082\u0003\u0006\u0003\u0000\u0082"+
		"\u0083\u0003\u0014\n\u0000\u0083\u0087\u0003\u0016\u000b\u0000\u0084\u0086"+
		"\u0003\u000e\u0007\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u008d\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008c\u0003\u001c\u000e\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\n\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000\u0092\u0099\u0003"+
		"\u001e\u000f\u0000\u0093\u0099\u0003 \u0010\u0000\u0094\u0099\u0003\""+
		"\u0011\u0000\u0095\u0099\u0003$\u0012\u0000\u0096\u0099\u0003*\u0015\u0000"+
		"\u0097\u0099\u0003,\u0016\u0000\u0098\u0092\u0001\u0000\u0000\u0000\u0098"+
		"\u0093\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0098"+
		"\u0095\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u001d\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\u001d\u0000\u0000\u009b\u00a1\u0003\u0004\u0002\u0000\u009c"+
		"\u009e\u00050\u0000\u0000\u009d\u009f\u0003.\u0017\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u00051\u0000\u0000\u00a1\u009c\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0005$\u0000\u0000\u00a4\u00a5\u0003.\u0017\u0000"+
		"\u00a5\u001f\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005\u0007\u0000\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0005\u0000\u0000"+
		"\u00aa\u00ab\u0003\u0006\u0003\u0000\u00ab\u00b4\u0005.\u0000\u0000\u00ac"+
		"\u00b1\u0003.\u0017\u0000\u00ad\u00ae\u0005\"\u0000\u0000\u00ae\u00b0"+
		"\u0003.\u0017\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b4\u00ac\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"/\u0000\u0000\u00b7!\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005\u001c\u0000"+
		"\u0000\u00b9\u00bb\u0003.\u0017\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb#\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0005\u0013\u0000\u0000\u00bd\u00bf\u0003.\u0017\u0000\u00be\u00c0"+
		"\u0005\u001f\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c6\u0001\u0000\u0000\u0000\u00c1\u00c5"+
		"\u0003\u001c\u000e\u0000\u00c2\u00c5\u0003&\u0013\u0000\u00c3\u00c5\u0003"+
		"(\u0014\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0005\u000b\u0000\u0000\u00ca%\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0005\t\u0000\u0000\u00cc\u00ce\u0003.\u0017\u0000"+
		"\u00cd\u00cf\u0005\u001f\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0003\u001c\u000e\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\'\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d6\u00da\u0005\b\u0000\u0000\u00d7\u00d9"+
		"\u0003\u001c\u000e\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db)\u0001\u0000\u0000\u0000\u00dc\u00da\u0001"+
		"\u0000\u0000\u0000\u00dd\u00e1\u0005\u0015\u0000\u0000\u00de\u00e0\u0003"+
		"\u001c\u000e\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0005\f\u0000\u0000\u00e5+\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0005\u000f\u0000\u0000\u00e7\u00e8\u0003.\u0017"+
		"\u0000\u00e8-\u0001\u0000\u0000\u0000\u00e9\u00ea\u0006\u0017\uffff\uffff"+
		"\u0000\u00ea\u00eb\u0005.\u0000\u0000\u00eb\u00ec\u0003.\u0017\u0000\u00ec"+
		"\u00ed\u0005/\u0000\u0000\u00ed\u010c\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0007\u0000\u0000\u0000\u00ef\u010c\u0003.\u0017\u0014\u00f0\u010c\u0005"+
		"\u0019\u0000\u0000\u00f1\u010c\u0007\u0001\u0000\u0000\u00f2\u010c\u0007"+
		"\u0002\u0000\u0000\u00f3\u010c\u00055\u0000\u0000\u00f4\u010c\u0005\u0002"+
		"\u0000\u0000\u00f5\u00f6\u00052\u0000\u0000\u00f6\u00f8\u00050\u0000\u0000"+
		"\u00f7\u00f9\u0003.\u0017\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u010c\u00051\u0000\u0000\u00fb\u00fc\u00052\u0000\u0000\u00fc\u0105\u0005"+
		".\u0000\u0000\u00fd\u0102\u0003.\u0017\u0000\u00fe\u00ff\u0005\"\u0000"+
		"\u0000\u00ff\u0101\u0003.\u0017\u0000\u0100\u00fe\u0001\u0000\u0000\u0000"+
		"\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000"+
		"\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u00fd\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000"+
		"\u0107\u010c\u0005/\u0000\u0000\u0108\u0109\u0005\u0011\u0000\u0000\u0109"+
		"\u010c\u00052\u0000\u0000\u010a\u010c\u00052\u0000\u0000\u010b\u00e9\u0001"+
		"\u0000\u0000\u0000\u010b\u00ee\u0001\u0000\u0000\u0000\u010b\u00f0\u0001"+
		"\u0000\u0000\u0000\u010b\u00f1\u0001\u0000\u0000\u0000\u010b\u00f2\u0001"+
		"\u0000\u0000\u0000\u010b\u00f3\u0001\u0000\u0000\u0000\u010b\u00f4\u0001"+
		"\u0000\u0000\u0000\u010b\u00f5\u0001\u0000\u0000\u0000\u010b\u00fb\u0001"+
		"\u0000\u0000\u0000\u010b\u0108\u0001\u0000\u0000\u0000\u010b\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\u012d\u0001\u0000\u0000\u0000\u010d\u010e\n\u0013"+
		"\u0000\u0000\u010e\u010f\u0007\u0003\u0000\u0000\u010f\u012c\u0003.\u0017"+
		"\u0014\u0110\u0111\n\u0012\u0000\u0000\u0111\u0112\u0007\u0004\u0000\u0000"+
		"\u0112\u012c\u0003.\u0017\u0013\u0113\u0114\n\u0011\u0000\u0000\u0114"+
		"\u0115\u0005#\u0000\u0000\u0115\u012c\u0003.\u0017\u0012\u0116\u0117\n"+
		"\u0010\u0000\u0000\u0117\u0118\u0005%\u0000\u0000\u0118\u012c\u0003.\u0017"+
		"\u0011\u0119\u011a\n\u000f\u0000\u0000\u011a\u011b\u0005\'\u0000\u0000"+
		"\u011b\u012c\u0003.\u0017\u0010\u011c\u011d\n\u000e\u0000\u0000\u011d"+
		"\u011e\u0005&\u0000\u0000\u011e\u012c\u0003.\u0017\u000f\u011f\u0120\n"+
		"\r\u0000\u0000\u0120\u0121\u0005)\u0000\u0000\u0121\u012c\u0003.\u0017"+
		"\u000e\u0122\u0123\n\f\u0000\u0000\u0123\u0124\u0005(\u0000\u0000\u0124"+
		"\u012c\u0003.\u0017\r\u0125\u0126\n\u000b\u0000\u0000\u0126\u0127\u0005"+
		"\u001a\u0000\u0000\u0127\u012c\u0003.\u0017\f\u0128\u0129\n\n\u0000\u0000"+
		"\u0129\u012a\u0005\u0003\u0000\u0000\u012a\u012c\u0003.\u0017\u000b\u012b"+
		"\u010d\u0001\u0000\u0000\u0000\u012b\u0110\u0001\u0000\u0000\u0000\u012b"+
		"\u0113\u0001\u0000\u0000\u0000\u012b\u0116\u0001\u0000\u0000\u0000\u012b"+
		"\u0119\u0001\u0000\u0000\u0000\u012b\u011c\u0001\u0000\u0000\u0000\u012b"+
		"\u011f\u0001\u0000\u0000\u0000\u012b\u0122\u0001\u0000\u0000\u0000\u012b"+
		"\u0125\u0001\u0000\u0000\u0000\u012b\u0128\u0001\u0000\u0000\u0000\u012c"+
		"\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0001\u0000\u0000\u0000\u012e/\u0001\u0000\u0000\u0000\u012f\u012d"+
		"\u0001\u0000\u0000\u0000\"46LRUY^hnsv~\u0087\u008d\u0098\u009e\u00a1\u00a7"+
		"\u00b1\u00b4\u00ba\u00bf\u00c4\u00c6\u00ce\u00d3\u00da\u00e1\u00f8\u0102"+
		"\u0105\u010b\u012b\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
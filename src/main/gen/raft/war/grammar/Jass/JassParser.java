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
		RULE_exitwhen = 22, RULE_expr = 23, RULE_prim = 24, RULE_primcall = 25, 
		RULE_primarr = 26, RULE_primfun = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "typename", "varname", "funname", "type", "extends", "globals", 
			"variable", "param", "params", "takes", "returns_", "native", "function", 
			"stmt", "set", "call", "return", "if", "elseif", "else", "loop", "exitwhen", 
			"expr", "prim", "primcall", "primarr", "primfun"
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
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8594522176L) != 0)) {
				{
				setState(60);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(56);
					type();
					}
					break;
				case 2:
					{
					setState(57);
					native_();
					}
					break;
				case 3:
					{
					setState(58);
					globals();
					}
					break;
				case 4:
					{
					setState(59);
					function();
					}
					break;
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
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
			setState(67);
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
			setState(69);
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
			setState(73);
			match(TYPE);
			setState(74);
			typename();
			setState(75);
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
			setState(77);
			match(EXTENDS);
			setState(78);
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
			setState(80);
			match(GLOBALS);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125899907891264L) != 0)) {
				{
				{
				setState(81);
				variable();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(89);
				match(CONSTANT);
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL) {
				{
				setState(92);
				match(LOCAL);
				}
			}

			setState(95);
			typename();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARRAY) {
				{
				setState(96);
				match(ARRAY);
				}
			}

			setState(99);
			varname();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(100);
				match(EQ);
				setState(101);
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
			setState(104);
			typename();
			setState(105);
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
			setState(107);
			param();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(108);
				match(COMMA);
				setState(109);
				param();
				}
				}
				setState(114);
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
			setState(115);
			match(TAKES);
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(116);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(117);
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
			setState(120);
			match(RETURNS);
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTHING:
				{
				setState(121);
				match(NOTHING);
				}
				break;
			case ID:
				{
				setState(122);
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
			match(NATIVE);
			setState(129);
			funname();
			setState(130);
			takes();
			setState(131);
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
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTANT) {
				{
				setState(133);
				match(CONSTANT);
				}
			}

			setState(136);
			match(FUNCTION);
			setState(137);
			funname();
			setState(138);
			takes();
			setState(139);
			returns_();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125900715852000L) != 0)) {
				{
				{
				setState(140);
				stmt();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSTANT:
			case LOCAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				variable();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				set();
				}
				break;
			case CALL:
			case DEBUG:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				call();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				return_();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				if_();
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				loop();
				}
				break;
			case EXITWHEN:
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
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
		public TerminalNode EQ() { return getToken(JassParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrimarrContext primarr() {
			return getRuleContext(PrimarrContext.class,0);
		}
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(SET);
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(158);
				primarr();
				}
				break;
			case 2:
				{
				setState(159);
				varname();
				}
				break;
			}
			setState(162);
			match(EQ);
			setState(163);
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
		public PrimcallContext primcall() {
			return getRuleContext(PrimcallContext.class,0);
		}
		public TerminalNode DEBUG() { return getToken(JassParser.DEBUG, 0); }
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
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEBUG) {
				{
				setState(165);
				match(DEBUG);
				}
			}

			setState(168);
			match(CALL);
			setState(169);
			primcall();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(RETURN);
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(172);
				expr(0);
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
			setState(175);
			match(IF);
			setState(176);
			expr(0);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEN) {
				{
				setState(177);
				match(THEN);
				}
			}

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125900715852768L) != 0)) {
				{
				setState(183);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CALL:
				case CONSTANT:
				case DEBUG:
				case EXITWHEN:
				case IF:
				case LOCAL:
				case LOOP:
				case RETURN:
				case SET:
				case ID:
					{
					setState(180);
					stmt();
					}
					break;
				case ELSEIF:
					{
					setState(181);
					elseif();
					}
					break;
				case ELSE:
					{
					setState(182);
					else_();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
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
			setState(190);
			match(ELSEIF);
			setState(191);
			expr(0);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEN) {
				{
				setState(192);
				match(THEN);
				}
			}

			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					stmt();
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
			setState(201);
			match(ELSE);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(202);
					stmt();
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
			setState(208);
			match(LOOP);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125900715852000L) != 0)) {
				{
				{
				setState(209);
				stmt();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
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
			setState(217);
			match(EXITWHEN);
			setState(218);
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
		public TerminalNode MUL() { return getToken(JassParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(JassParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(JassParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(JassParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(JassParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(JassParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JassParser.RPAREN, 0); }
		public PrimContext prim() {
			return getRuleContext(PrimContext.class,0);
		}
		public TerminalNode EQ_EQ() { return getToken(JassParser.EQ_EQ, 0); }
		public TerminalNode NEQ() { return getToken(JassParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(JassParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(JassParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(JassParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(JassParser.GT_EQ, 0); }
		public TerminalNode OR() { return getToken(JassParser.OR, 0); }
		public TerminalNode AND() { return getToken(JassParser.AND, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitExpr(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
				{
				setState(221);
				match(MUL);
				setState(222);
				expr(15);
				}
				break;
			case DIV:
				{
				setState(223);
				match(DIV);
				setState(224);
				expr(14);
				}
				break;
			case PLUS:
				{
				setState(225);
				match(PLUS);
				setState(226);
				expr(13);
				}
				break;
			case MINUS:
				{
				setState(227);
				match(MINUS);
				setState(228);
				expr(12);
				}
				break;
			case NOT:
				{
				setState(229);
				match(NOT);
				setState(230);
				expr(11);
				}
				break;
			case LPAREN:
				{
				setState(231);
				match(LPAREN);
				setState(232);
				expr(0);
				setState(233);
				match(RPAREN);
				}
				break;
			case RAWVAL:
			case STRING:
			case FALSE:
			case FUNCTION:
			case NULL:
			case TRUE:
			case ID:
			case INTVAL:
			case HEXVAL:
			case REALVAL:
				{
				setState(235);
				prim();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(239);
						match(PLUS);
						setState(240);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(242);
						match(MINUS);
						setState(243);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(245);
						match(MUL);
						setState(246);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(248);
						match(DIV);
						setState(249);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(251);
						match(EQ_EQ);
						setState(252);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(254);
						match(NEQ);
						setState(255);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(257);
						match(LT);
						setState(258);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(260);
						match(LT_EQ);
						setState(261);
						expr(8);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(263);
						match(GT);
						setState(264);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(266);
						match(GT_EQ);
						setState(267);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(269);
						match(OR);
						setState(270);
						expr(5);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(272);
						match(AND);
						setState(273);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(278);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimContext extends ParserRuleContext {
		public PrimarrContext primarr() {
			return getRuleContext(PrimarrContext.class,0);
		}
		public PrimcallContext primcall() {
			return getRuleContext(PrimcallContext.class,0);
		}
		public PrimfunContext primfun() {
			return getRuleContext(PrimfunContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(JassParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(JassParser.NULL, 0); }
		public TerminalNode TRUE() { return getToken(JassParser.TRUE, 0); }
		public TerminalNode INTVAL() { return getToken(JassParser.INTVAL, 0); }
		public TerminalNode HEXVAL() { return getToken(JassParser.HEXVAL, 0); }
		public TerminalNode REALVAL() { return getToken(JassParser.REALVAL, 0); }
		public TerminalNode RAWVAL() { return getToken(JassParser.RAWVAL, 0); }
		public TerminalNode STRING() { return getToken(JassParser.STRING, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public PrimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterPrim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitPrim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitPrim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimContext prim() throws RecognitionException {
		PrimContext _localctx = new PrimContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_prim);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				primarr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				primcall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				primfun();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				match(NULL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				match(TRUE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				match(INTVAL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(286);
				match(HEXVAL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
				match(REALVAL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(288);
				match(RAWVAL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(289);
				match(STRING);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(290);
				match(ID);
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
	public static class PrimcallContext extends ParserRuleContext {
		public FunnameContext funname() {
			return getRuleContext(FunnameContext.class,0);
		}
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
		public PrimcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterPrimcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitPrimcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitPrimcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimcallContext primcall() throws RecognitionException {
		PrimcallContext _localctx = new PrimcallContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_primcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			funname();
			setState(294);
			match(LPAREN);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17024842381590534L) != 0)) {
				{
				setState(295);
				expr(0);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(296);
					match(COMMA);
					setState(297);
					expr(0);
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(305);
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
	public static class PrimarrContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(JassParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JassParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrimarrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primarr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterPrimarr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitPrimarr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitPrimarr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimarrContext primarr() throws RecognitionException {
		PrimarrContext _localctx = new PrimarrContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primarr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			varname();
			setState(308);
			match(LBRACK);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17024842381590534L) != 0)) {
				{
				setState(309);
				expr(0);
				}
			}

			setState(312);
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
	public static class PrimfunContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(JassParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(JassParser.ID, 0); }
		public PrimfunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primfun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).enterPrimfun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JassListener ) ((JassListener)listener).exitPrimfun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JassVisitor ) return ((JassVisitor<? extends T>)visitor).visitPrimfun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimfunContext primfun() throws RecognitionException {
		PrimfunContext _localctx = new PrimfunContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_primfun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(FUNCTION);
			setState(315);
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
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u013e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000=\b\u0000"+
		"\n\u0000\f\u0000@\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0003\u0007[\b\u0007\u0001\u0007\u0003\u0007"+
		"^\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007g\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0005\to\b\t\n\t\f\tr\t\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\nw\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b|\b\u000b\u0001"+
		"\f\u0003\f\u007f\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0003"+
		"\r\u0087\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008e\b\r"+
		"\n\r\f\r\u0091\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u009c\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a1\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0003\u0010\u00a7\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00ae\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b3\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00b8\b\u0012\n\u0012\f\u0012\u00bb"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00c2\b\u0013\u0001\u0013\u0005\u0013\u00c5\b\u0013\n\u0013\f\u0013"+
		"\u00c8\t\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u00cc\b\u0014\n\u0014"+
		"\f\u0014\u00cf\t\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00d3\b\u0015"+
		"\n\u0015\f\u0015\u00d6\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00ed\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0113\b\u0017\n\u0017\f\u0017\u0116\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0124\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u012b\b\u0019\n\u0019\f\u0019\u012e\t\u0019\u0003"+
		"\u0019\u0130\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0137\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0000\u0001.\u001c\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"0246\u0000\u0000\u0161\u0000>\u0001\u0000\u0000\u0000\u0002C\u0001\u0000"+
		"\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000"+
		"\bI\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fP\u0001\u0000"+
		"\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010h\u0001\u0000\u0000\u0000"+
		"\u0012k\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016x"+
		"\u0001\u0000\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u0086\u0001"+
		"\u0000\u0000\u0000\u001c\u009b\u0001\u0000\u0000\u0000\u001e\u009d\u0001"+
		"\u0000\u0000\u0000 \u00a6\u0001\u0000\u0000\u0000\"\u00ab\u0001\u0000"+
		"\u0000\u0000$\u00af\u0001\u0000\u0000\u0000&\u00be\u0001\u0000\u0000\u0000"+
		"(\u00c9\u0001\u0000\u0000\u0000*\u00d0\u0001\u0000\u0000\u0000,\u00d9"+
		"\u0001\u0000\u0000\u0000.\u00ec\u0001\u0000\u0000\u00000\u0123\u0001\u0000"+
		"\u0000\u00002\u0125\u0001\u0000\u0000\u00004\u0133\u0001\u0000\u0000\u0000"+
		"6\u013a\u0001\u0000\u0000\u00008=\u0003\b\u0004\u00009=\u0003\u0018\f"+
		"\u0000:=\u0003\f\u0006\u0000;=\u0003\u001a\r\u0000<8\u0001\u0000\u0000"+
		"\u0000<9\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<;\u0001\u0000"+
		"\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"AB\u0005\u0000\u0000\u0001B\u0001\u0001\u0000\u0000\u0000CD\u00052\u0000"+
		"\u0000D\u0003\u0001\u0000\u0000\u0000EF\u00052\u0000\u0000F\u0005\u0001"+
		"\u0000\u0000\u0000GH\u00052\u0000\u0000H\u0007\u0001\u0000\u0000\u0000"+
		"IJ\u0005!\u0000\u0000JK\u0003\u0002\u0001\u0000KL\u0003\n\u0005\u0000"+
		"L\t\u0001\u0000\u0000\u0000MN\u0005\u000e\u0000\u0000NO\u0003\u0002\u0001"+
		"\u0000O\u000b\u0001\u0000\u0000\u0000PT\u0005\u0012\u0000\u0000QS\u0003"+
		"\u000e\u0007\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000WX\u0005\r\u0000\u0000X\r\u0001\u0000"+
		"\u0000\u0000Y[\u0005\u0006\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\^\u0005\u0014\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_a\u0003\u0002\u0001\u0000`b\u0005\u0004\u0000\u0000a`\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cf\u0003"+
		"\u0004\u0002\u0000de\u0005$\u0000\u0000eg\u0003.\u0017\u0000fd\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000g\u000f\u0001\u0000\u0000\u0000"+
		"hi\u0003\u0002\u0001\u0000ij\u0003\u0004\u0002\u0000j\u0011\u0001\u0000"+
		"\u0000\u0000kp\u0003\u0010\b\u0000lm\u0005\"\u0000\u0000mo\u0003\u0010"+
		"\b\u0000nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000q\u0013\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000sv\u0005\u001e\u0000\u0000tw\u0005\u0018\u0000"+
		"\u0000uw\u0003\u0012\t\u0000vt\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000"+
		"\u0000w\u0015\u0001\u0000\u0000\u0000x{\u0005\u001b\u0000\u0000y|\u0005"+
		"\u0018\u0000\u0000z|\u0003\u0002\u0001\u0000{y\u0001\u0000\u0000\u0000"+
		"{z\u0001\u0000\u0000\u0000|\u0017\u0001\u0000\u0000\u0000}\u007f\u0005"+
		"\u0006\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0016\u0000"+
		"\u0000\u0081\u0082\u0003\u0006\u0003\u0000\u0082\u0083\u0003\u0014\n\u0000"+
		"\u0083\u0084\u0003\u0016\u000b\u0000\u0084\u0019\u0001\u0000\u0000\u0000"+
		"\u0085\u0087\u0005\u0006\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u0011\u0000\u0000\u0089\u008a\u0003\u0006\u0003\u0000"+
		"\u008a\u008b\u0003\u0014\n\u0000\u008b\u008f\u0003\u0016\u000b\u0000\u008c"+
		"\u008e\u0003\u001c\u000e\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005\n\u0000\u0000\u0093\u001b"+
		"\u0001\u0000\u0000\u0000\u0094\u009c\u0003\u000e\u0007\u0000\u0095\u009c"+
		"\u0003\u001e\u000f\u0000\u0096\u009c\u0003 \u0010\u0000\u0097\u009c\u0003"+
		"\"\u0011\u0000\u0098\u009c\u0003$\u0012\u0000\u0099\u009c\u0003*\u0015"+
		"\u0000\u009a\u009c\u0003,\u0016\u0000\u009b\u0094\u0001\u0000\u0000\u0000"+
		"\u009b\u0095\u0001\u0000\u0000\u0000\u009b\u0096\u0001\u0000\u0000\u0000"+
		"\u009b\u0097\u0001\u0000\u0000\u0000\u009b\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u001d\u0001\u0000\u0000\u0000\u009d\u00a0\u0005\u001d\u0000\u0000"+
		"\u009e\u00a1\u00034\u001a\u0000\u009f\u00a1\u0003\u0004\u0002\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005$\u0000\u0000\u00a3\u00a4"+
		"\u0003.\u0017\u0000\u00a4\u001f\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005"+
		"\u0007\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"\u0005\u0000\u0000\u00a9\u00aa\u00032\u0019\u0000\u00aa!\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0005\u001c\u0000\u0000\u00ac\u00ae\u0003.\u0017\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae#\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0013\u0000\u0000\u00b0"+
		"\u00b2\u0003.\u0017\u0000\u00b1\u00b3\u0005\u001f\u0000\u0000\u00b2\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b8\u0003\u001c\u000e\u0000\u00b5\u00b8"+
		"\u0003&\u0013\u0000\u00b6\u00b8\u0003(\u0014\u0000\u00b7\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u000b"+
		"\u0000\u0000\u00bd%\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\t\u0000"+
		"\u0000\u00bf\u00c1\u0003.\u0017\u0000\u00c0\u00c2\u0005\u001f\u0000\u0000"+
		"\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c6\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003\u001c\u000e\u0000"+
		"\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\'\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cd\u0005\b\u0000\u0000\u00ca\u00cc\u0003\u001c\u000e\u0000\u00cb\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce)\u0001"+
		"\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d4\u0005"+
		"\u0015\u0000\u0000\u00d1\u00d3\u0003\u001c\u000e\u0000\u00d2\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"\f\u0000\u0000\u00d8+\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u000f"+
		"\u0000\u0000\u00da\u00db\u0003.\u0017\u0000\u00db-\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0006\u0017\uffff\uffff\u0000\u00dd\u00de\u0005,\u0000\u0000"+
		"\u00de\u00ed\u0003.\u0017\u000f\u00df\u00e0\u0005-\u0000\u0000\u00e0\u00ed"+
		"\u0003.\u0017\u000e\u00e1\u00e2\u0005*\u0000\u0000\u00e2\u00ed\u0003."+
		"\u0017\r\u00e3\u00e4\u0005+\u0000\u0000\u00e4\u00ed\u0003.\u0017\f\u00e5"+
		"\u00e6\u0005\u0017\u0000\u0000\u00e6\u00ed\u0003.\u0017\u000b\u00e7\u00e8"+
		"\u0005.\u0000\u0000\u00e8\u00e9\u0003.\u0017\u0000\u00e9\u00ea\u0005/"+
		"\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00ed\u00030\u0018"+
		"\u0000\u00ec\u00dc\u0001\u0000\u0000\u0000\u00ec\u00df\u0001\u0000\u0000"+
		"\u0000\u00ec\u00e1\u0001\u0000\u0000\u0000\u00ec\u00e3\u0001\u0000\u0000"+
		"\u0000\u00ec\u00e5\u0001\u0000\u0000\u0000\u00ec\u00e7\u0001\u0000\u0000"+
		"\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u0114\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\n\u0013\u0000\u0000\u00ef\u00f0\u0005*\u0000\u0000"+
		"\u00f0\u0113\u0003.\u0017\u0014\u00f1\u00f2\n\u0012\u0000\u0000\u00f2"+
		"\u00f3\u0005+\u0000\u0000\u00f3\u0113\u0003.\u0017\u0013\u00f4\u00f5\n"+
		"\u0011\u0000\u0000\u00f5\u00f6\u0005,\u0000\u0000\u00f6\u0113\u0003.\u0017"+
		"\u0012\u00f7\u00f8\n\u0010\u0000\u0000\u00f8\u00f9\u0005-\u0000\u0000"+
		"\u00f9\u0113\u0003.\u0017\u0011\u00fa\u00fb\n\n\u0000\u0000\u00fb\u00fc"+
		"\u0005#\u0000\u0000\u00fc\u0113\u0003.\u0017\u000b\u00fd\u00fe\n\t\u0000"+
		"\u0000\u00fe\u00ff\u0005%\u0000\u0000\u00ff\u0113\u0003.\u0017\n\u0100"+
		"\u0101\n\b\u0000\u0000\u0101\u0102\u0005\'\u0000\u0000\u0102\u0113\u0003"+
		".\u0017\t\u0103\u0104\n\u0007\u0000\u0000\u0104\u0105\u0005&\u0000\u0000"+
		"\u0105\u0113\u0003.\u0017\b\u0106\u0107\n\u0006\u0000\u0000\u0107\u0108"+
		"\u0005)\u0000\u0000\u0108\u0113\u0003.\u0017\u0007\u0109\u010a\n\u0005"+
		"\u0000\u0000\u010a\u010b\u0005(\u0000\u0000\u010b\u0113\u0003.\u0017\u0006"+
		"\u010c\u010d\n\u0004\u0000\u0000\u010d\u010e\u0005\u001a\u0000\u0000\u010e"+
		"\u0113\u0003.\u0017\u0005\u010f\u0110\n\u0003\u0000\u0000\u0110\u0111"+
		"\u0005\u0003\u0000\u0000\u0111\u0113\u0003.\u0017\u0004\u0112\u00ee\u0001"+
		"\u0000\u0000\u0000\u0112\u00f1\u0001\u0000\u0000\u0000\u0112\u00f4\u0001"+
		"\u0000\u0000\u0000\u0112\u00f7\u0001\u0000\u0000\u0000\u0112\u00fa\u0001"+
		"\u0000\u0000\u0000\u0112\u00fd\u0001\u0000\u0000\u0000\u0112\u0100\u0001"+
		"\u0000\u0000\u0000\u0112\u0103\u0001\u0000\u0000\u0000\u0112\u0106\u0001"+
		"\u0000\u0000\u0000\u0112\u0109\u0001\u0000\u0000\u0000\u0112\u010c\u0001"+
		"\u0000\u0000\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0113\u0116\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115/\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000"+
		"\u0000\u0000\u0117\u0124\u00034\u001a\u0000\u0118\u0124\u00032\u0019\u0000"+
		"\u0119\u0124\u00036\u001b\u0000\u011a\u0124\u0005\u0010\u0000\u0000\u011b"+
		"\u0124\u0005\u0019\u0000\u0000\u011c\u0124\u0005 \u0000\u0000\u011d\u0124"+
		"\u00053\u0000\u0000\u011e\u0124\u00054\u0000\u0000\u011f\u0124\u00055"+
		"\u0000\u0000\u0120\u0124\u0005\u0001\u0000\u0000\u0121\u0124\u0005\u0002"+
		"\u0000\u0000\u0122\u0124\u00052\u0000\u0000\u0123\u0117\u0001\u0000\u0000"+
		"\u0000\u0123\u0118\u0001\u0000\u0000\u0000\u0123\u0119\u0001\u0000\u0000"+
		"\u0000\u0123\u011a\u0001\u0000\u0000\u0000\u0123\u011b\u0001\u0000\u0000"+
		"\u0000\u0123\u011c\u0001\u0000\u0000\u0000\u0123\u011d\u0001\u0000\u0000"+
		"\u0000\u0123\u011e\u0001\u0000\u0000\u0000\u0123\u011f\u0001\u0000\u0000"+
		"\u0000\u0123\u0120\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000"+
		"\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u01241\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\u0003\u0006\u0003\u0000\u0126\u012f\u0005.\u0000\u0000\u0127"+
		"\u012c\u0003.\u0017\u0000\u0128\u0129\u0005\"\u0000\u0000\u0129\u012b"+
		"\u0003.\u0017\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012e\u0001"+
		"\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001"+
		"\u0000\u0000\u0000\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012c\u0001"+
		"\u0000\u0000\u0000\u012f\u0127\u0001\u0000\u0000\u0000\u012f\u0130\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0005"+
		"/\u0000\u0000\u01323\u0001\u0000\u0000\u0000\u0133\u0134\u0003\u0004\u0002"+
		"\u0000\u0134\u0136\u00050\u0000\u0000\u0135\u0137\u0003.\u0017\u0000\u0136"+
		"\u0135\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u00051\u0000\u0000\u01395\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0005\u0011\u0000\u0000\u013b\u013c\u0005"+
		"2\u0000\u0000\u013c7\u0001\u0000\u0000\u0000\u001f<>TZ]afpv{~\u0086\u008f"+
		"\u009b\u00a0\u00a6\u00ad\u00b2\u00b7\u00b9\u00c1\u00c6\u00cd\u00d4\u00ec"+
		"\u0112\u0114\u0123\u012c\u012f\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
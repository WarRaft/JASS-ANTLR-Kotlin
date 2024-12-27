// Generated from /Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/main/raft/war/grammar/Jass.g4 by ANTLR 4.13.2
package raft.war.grammar.Jass;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JassParser}.
 */
public interface JassListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JassParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(JassParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(JassParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(JassParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(JassParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#varname}.
	 * @param ctx the parse tree
	 */
	void enterVarname(JassParser.VarnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#varname}.
	 * @param ctx the parse tree
	 */
	void exitVarname(JassParser.VarnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funname}.
	 * @param ctx the parse tree
	 */
	void enterFunname(JassParser.FunnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funname}.
	 * @param ctx the parse tree
	 */
	void exitFunname(JassParser.FunnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JassParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JassParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#extends}.
	 * @param ctx the parse tree
	 */
	void enterExtends(JassParser.ExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#extends}.
	 * @param ctx the parse tree
	 */
	void exitExtends(JassParser.ExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#globals}.
	 * @param ctx the parse tree
	 */
	void enterGlobals(JassParser.GlobalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#globals}.
	 * @param ctx the parse tree
	 */
	void exitGlobals(JassParser.GlobalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(JassParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(JassParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(JassParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(JassParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(JassParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(JassParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#takes}.
	 * @param ctx the parse tree
	 */
	void enterTakes(JassParser.TakesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#takes}.
	 * @param ctx the parse tree
	 */
	void exitTakes(JassParser.TakesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#returns_}.
	 * @param ctx the parse tree
	 */
	void enterReturns_(JassParser.Returns_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#returns_}.
	 * @param ctx the parse tree
	 */
	void exitReturns_(JassParser.Returns_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#native}.
	 * @param ctx the parse tree
	 */
	void enterNative(JassParser.NativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#native}.
	 * @param ctx the parse tree
	 */
	void exitNative(JassParser.NativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(JassParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(JassParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(JassParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(JassParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(JassParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(JassParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(JassParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(JassParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(JassParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(JassParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(JassParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(JassParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(JassParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(JassParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(JassParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(JassParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(JassParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(JassParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#exitwhen}.
	 * @param ctx the parse tree
	 */
	void enterExitwhen(JassParser.ExitwhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#exitwhen}.
	 * @param ctx the parse tree
	 */
	void exitExitwhen(JassParser.ExitwhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JassParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JassParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#prim}.
	 * @param ctx the parse tree
	 */
	void enterPrim(JassParser.PrimContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#prim}.
	 * @param ctx the parse tree
	 */
	void exitPrim(JassParser.PrimContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#primcall}.
	 * @param ctx the parse tree
	 */
	void enterPrimcall(JassParser.PrimcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#primcall}.
	 * @param ctx the parse tree
	 */
	void exitPrimcall(JassParser.PrimcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#primarr}.
	 * @param ctx the parse tree
	 */
	void enterPrimarr(JassParser.PrimarrContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#primarr}.
	 * @param ctx the parse tree
	 */
	void exitPrimarr(JassParser.PrimarrContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#primfun}.
	 * @param ctx the parse tree
	 */
	void enterPrimfun(JassParser.PrimfunContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#primfun}.
	 * @param ctx the parse tree
	 */
	void exitPrimfun(JassParser.PrimfunContext ctx);
}
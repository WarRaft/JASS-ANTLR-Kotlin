// Generated from /Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/.main/raft/war/antlr/grammar/Jass.g4 by ANTLR 4.13.2
package raft.war.antlr.grammar.Jass;
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
	 * Enter a parse tree produced by {@link JassParser#setBrack}.
	 * @param ctx the parse tree
	 */
	void enterSetBrack(JassParser.SetBrackContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#setBrack}.
	 * @param ctx the parse tree
	 */
	void exitSetBrack(JassParser.SetBrackContext ctx);
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
	 * Enter a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(JassParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(JassParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprStr(JassParser.ExprStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprStr(JassParser.ExprStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUn}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUn(JassParser.ExprUnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUn}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUn(JassParser.ExprUnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVar(JassParser.ExprVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVar(JassParser.ExprVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprEq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprEq(JassParser.ExprEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprEq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprEq(JassParser.ExprEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNull(JassParser.ExprNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNull(JassParser.ExprNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFun}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFun(JassParser.ExprFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFun}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFun(JassParser.ExprFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(JassParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(JassParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCall}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCall(JassParser.ExprCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCall}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCall(JassParser.ExprCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLt(JassParser.ExprLtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLt(JassParser.ExprLtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMul}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMul(JassParser.ExprMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMul}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMul(JassParser.ExprMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprArr(JassParser.ExprArrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprArr(JassParser.ExprArrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(JassParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(JassParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprBool}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprBool(JassParser.ExprBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprBool}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprBool(JassParser.ExprBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(JassParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(JassParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprReal}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReal(JassParser.ExprRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprReal}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReal(JassParser.ExprRealContext ctx);
}

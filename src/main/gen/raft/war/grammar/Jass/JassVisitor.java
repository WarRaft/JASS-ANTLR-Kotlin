// Generated from /Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/main/raft/war/grammar/Jass.g4 by ANTLR 4.13.2
package raft.war.grammar.Jass;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JassVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JassParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(JassParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(JassParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#varname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarname(JassParser.VarnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#funname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunname(JassParser.FunnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JassParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#extends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtends(JassParser.ExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#globals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobals(JassParser.GlobalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(JassParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(JassParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(JassParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#takes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTakes(JassParser.TakesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#returns_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturns_(JassParser.Returns_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#native}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNative(JassParser.NativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(JassParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(JassParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(JassParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(JassParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(JassParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(JassParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#elseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseif(JassParser.ElseifContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(JassParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(JassParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#exitwhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitwhen(JassParser.ExitwhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInt(JassParser.ExprIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLtEq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLtEq(JassParser.ExprLtEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStr(JassParser.ExprStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUn}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUn(JassParser.ExprUnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGtEq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGtEq(JassParser.ExprGtEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVar}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVar(JassParser.ExprVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprEq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEq(JassParser.ExprEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprGt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprGt(JassParser.ExprGtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNull(JassParser.ExprNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFun}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFun(JassParser.ExprFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(JassParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(JassParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCall}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCall(JassParser.ExprCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLt}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLt(JassParser.ExprLtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMul}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMul(JassParser.ExprMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArr}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArr(JassParser.ExprArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAdd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(JassParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBool}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBool(JassParser.ExprBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(JassParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprReal}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReal(JassParser.ExprRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNeq}
	 * labeled alternative in {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNeq(JassParser.ExprNeqContext ctx);
}
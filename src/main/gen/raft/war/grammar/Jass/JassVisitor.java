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
	 * Visit a parse tree produced by {@link JassParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JassParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrim(JassParser.PrimContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#primcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimcall(JassParser.PrimcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#primarr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimarr(JassParser.PrimarrContext ctx);
	/**
	 * Visit a parse tree produced by {@link JassParser#primfun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimfun(JassParser.PrimfunContext ctx);
}
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
	 * Enter a parse tree produced by {@link JassParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(JassParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(JassParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(JassParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(JassParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void enterTypeDef(JassParser.TypeDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#typeDef}.
	 * @param ctx the parse tree
	 */
	void exitTypeDef(JassParser.TypeDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#typeExt}.
	 * @param ctx the parse tree
	 */
	void enterTypeExt(JassParser.TypeExtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#typeExt}.
	 * @param ctx the parse tree
	 */
	void exitTypeExt(JassParser.TypeExtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(JassParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(JassParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#glob}.
	 * @param ctx the parse tree
	 */
	void enterGlob(JassParser.GlobContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#glob}.
	 * @param ctx the parse tree
	 */
	void exitGlob(JassParser.GlobContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#varDefGlob}.
	 * @param ctx the parse tree
	 */
	void enterVarDefGlob(JassParser.VarDefGlobContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#varDefGlob}.
	 * @param ctx the parse tree
	 */
	void exitVarDefGlob(JassParser.VarDefGlobContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(JassParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(JassParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(JassParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(JassParser.FunCallContext ctx);
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
	 * Enter a parse tree produced by {@link JassParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(JassParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(JassParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funTake}.
	 * @param ctx the parse tree
	 */
	void enterFunTake(JassParser.FunTakeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funTake}.
	 * @param ctx the parse tree
	 */
	void exitFunTake(JassParser.FunTakeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funRet}.
	 * @param ctx the parse tree
	 */
	void enterFunRet(JassParser.FunRetContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funRet}.
	 * @param ctx the parse tree
	 */
	void exitFunRet(JassParser.FunRetContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(JassParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(JassParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funHead}.
	 * @param ctx the parse tree
	 */
	void enterFunHead(JassParser.FunHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funHead}.
	 * @param ctx the parse tree
	 */
	void exitFunHead(JassParser.FunHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#nativ}.
	 * @param ctx the parse tree
	 */
	void enterNativ(JassParser.NativContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#nativ}.
	 * @param ctx the parse tree
	 */
	void exitNativ(JassParser.NativContext ctx);
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
	 * Enter a parse tree produced by {@link JassParser#varDefLoc}.
	 * @param ctx the parse tree
	 */
	void enterVarDefLoc(JassParser.VarDefLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#varDefLoc}.
	 * @param ctx the parse tree
	 */
	void exitVarDefLoc(JassParser.VarDefLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmt(JassParser.SetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmt(JassParser.SetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(JassParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(JassParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(JassParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(JassParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(JassParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(JassParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStmt(JassParser.ElseIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStmt(JassParser.ElseIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(JassParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(JassParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(JassParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(JassParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#exitWhenStmt}.
	 * @param ctx the parse tree
	 */
	void enterExitWhenStmt(JassParser.ExitWhenStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#exitWhenStmt}.
	 * @param ctx the parse tree
	 */
	void exitExitWhenStmt(JassParser.ExitWhenStmtContext ctx);
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
	 * Enter a parse tree produced by {@link JassParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(JassParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(JassParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JassParser#funRef}.
	 * @param ctx the parse tree
	 */
	void enterFunRef(JassParser.FunRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link JassParser#funRef}.
	 * @param ctx the parse tree
	 */
	void exitFunRef(JassParser.FunRefContext ctx);
}
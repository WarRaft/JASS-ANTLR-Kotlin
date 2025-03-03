package io.github.warraft.language.vex.state

import io.github.warraft.ZincLexer
import io.github.warraft.ZincParser
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.vex.state.VexState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.TerminalNode

class ZincState : VexState() {
    override fun lexer(stream: CharStream): Lexer = ZincLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = ZincParser(stream)

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)

        rootCtx = (parser as ZincParser).root().also {
            for (itemCtx in it.rootItem()) rootItems(itemCtx)
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }

    fun rootItems(itemCtx: ZincParser.RootItemContext) {
        for (ctx in itemCtx.children) {
            when (ctx) {
                is ZincParser.LibContext -> lib(ctx)
                is ZincParser.VisContext -> vis(ctx)
                is ZincParser.StmtLeftContext -> leftStmt(ctx)
                is ZincParser.FunctionContext -> function(ctx)
                else -> server?.log("root:${ctx.javaClass.simpleName}")
            }
        }
    }

    fun function(ctx: ZincParser.FunctionContext) {
        semanticHub
            .add(ctx.NATIVE(), SemanticTokenType.KEYWORD)
            .add(ctx.FUNCTION(), SemanticTokenType.KEYWORD)
            .add(ctx.METHOD(), SemanticTokenType.KEYWORD)
            .add(ctx.STATIC(), SemanticTokenType.KEYWORD)
            .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
            .add(ctx.RETURNS(), SemanticTokenType.OPERATOR)
            .add(ctx.ID(0), SemanticTokenType.FUNCTION)
            .add(ctx.ID(1), SemanticTokenType.TYPE)

        for (paramCtx in ctx.param()) {
            val typenameCtx: ZincParser.TypenameContext? = paramCtx.typename()
            val varnameCtx: ZincParser.VarnameContext? = paramCtx.varname()

            semanticHub
                .add(typenameCtx?.ID(), SemanticTokenType.TYPE_PARAMETER)
                .add(varnameCtx?.ID(), SemanticTokenType.PARAMETER)
        }

        for (ctx in ctx.stmt()) {
            stmt(ctx)
        }
    }

    fun lib(ctx: ZincParser.LibContext) {
        for (idCtx in ctx.ID()) {
            semanticHub.add(idCtx, SemanticTokenType.NAMESPACE)
        }
        semanticHub
            .add(ctx.LIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.REQUIRES(), SemanticTokenType.KEYWORD)
            .add(ctx.STRUCT(), SemanticTokenType.KEYWORD)

        for (rootCtx in ctx.rootItem()) {
            rootItems(rootCtx)
        }
    }

    fun vis(ctx: ZincParser.VisContext) {
        semanticHub
            .add(ctx.PUBLIC(), SemanticTokenType.KEYWORD)
            .add(ctx.PRIVATE(), SemanticTokenType.KEYWORD)

        for (itemCtx in ctx.rootItem()) {
            rootItems(itemCtx)
        }
    }

    fun leftStmt(ctx: ZincParser.StmtLeftContext) {
        semanticHub
            .add(ctx.DEBUG(), SemanticTokenType.KEYWORD)
            .add(ctx.STATIC(), SemanticTokenType.KEYWORD)
            .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
        left(ctx.left())
    }

    fun left(ctx: ZincParser.LeftContext?) {
        when (ctx) {
            is ZincParser.LeftTypeContext -> {
                semanticHub.add(ctx.ID(), SemanticTokenType.TYPE)
                left(ctx.left())
            }

            is ZincParser.LeftIdContext -> {
                semanticHub.add(ctx.ID(), SemanticTokenType.VARIABLE)
            }

            is ZincParser.LeftDotContext -> {
                for (it in ctx.left()) left(it)
            }

            is ZincParser.LeftCallContext -> {
                left(ctx.left())
                for (it in ctx.expr()) expr(it)
            }

            else -> server?.log("left:${ctx?.javaClass?.simpleName}")
        }
    }

    fun stmt(stmtCtx: ZincParser.StmtContext) {
        when (stmtCtx) {
            is ZincParser.StmtLeftContext -> {
                leftStmt(stmtCtx)
                semanticHub
                    .add(stmtCtx.DEBUG(), SemanticTokenType.VARIABLE)
                    .add(stmtCtx.STATIC(), SemanticTokenType.VARIABLE)
                    .add(stmtCtx.CONSTANT(), SemanticTokenType.VARIABLE)
                    .add(stmtCtx.EQ(), SemanticTokenType.OPERATOR)

                expr(stmtCtx.expr())
            }

            is ZincParser.StmtIfContext -> {
                semanticHub
                    .add(stmtCtx.IF(), SemanticTokenType.KEYWORD)
                    .add(stmtCtx.WHILE(), SemanticTokenType.KEYWORD)
                    .add(stmtCtx.FOR(), SemanticTokenType.KEYWORD)

                expr(stmtCtx.expr())
                stmtCtx.stmt().forEach { stmt(it) }


                val elseCtx: ZincParser.ElseRuleContext? = stmtCtx.elseRule()
                if (elseCtx != null) {
                    semanticHub
                        .add(elseCtx.ELSE(), SemanticTokenType.KEYWORD)
                    stmtCtx.stmt().forEach { stmt(it) }
                }
            }

            is ZincParser.StmtReturnContext -> {
                semanticHub
                    .add(stmtCtx.RETURN(), SemanticTokenType.KEYWORD)

                expr(stmtCtx.expr())
            }

            else -> server?.log("stmt:${stmtCtx.javaClass.simpleName}")
        }
    }

    fun expr(exprsCtx: List<ZincParser.ExprContext>, opsCtx: List<TerminalNode?>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
        for (opCtx in opsCtx) semanticHub.add(opCtx, SemanticTokenType.OPERATOR)
    }

    fun expr(exprCtx: ZincParser.ExprContext?) {
        if (exprCtx == null) return

        when (exprCtx) {
            is ZincParser.ExprEqContext -> expr(exprCtx.expr(), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()))
            is ZincParser.ExprAddContext -> expr(exprCtx.expr(), listOf(exprCtx.PLUS(), exprCtx.MINUS()))
            is ZincParser.ExprMulContext -> expr(exprCtx.expr(), listOf(exprCtx.MUL(), exprCtx.DIV()))
            is ZincParser.ExprLtContext -> expr(exprCtx.expr(), listOf(exprCtx.LT(), exprCtx.LT_EQ(), exprCtx.GT(), exprCtx.GT_EQ()))
            is ZincParser.ExprAndContext -> expr(exprCtx.expr(), listOf(exprCtx.AND_AND(), exprCtx.AND_AND()))

            is ZincParser.ExprLambdaContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.RETURNS(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.ID(), SemanticTokenType.KEYWORD)

                exprCtx.stmt().forEach { stmt(it) }
            }

            is ZincParser.ExprNullContext -> {
                semanticHub
                    .add(exprCtx.NULL(), SemanticTokenType.KEYWORD)
            }

            is ZincParser.ExprStrContext -> {
                semanticHub
                    .add(exprCtx.STRING(), SemanticTokenType.STRING)
            }

            is ZincParser.ExprBoolContext -> {
                semanticHub
                    .add(exprCtx.TRUE(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.FALSE(), SemanticTokenType.KEYWORD)
            }

            is ZincParser.ExprIntContext -> {
                semanticHub
                    .add(exprCtx.INTVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.HEXVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.RAWVAL(), SemanticTokenType.NUMBER)
            }

            is ZincParser.ExprRealContext -> {
                semanticHub.add(exprCtx.REALVAL(), SemanticTokenType.NUMBER)
            }

            is ZincParser.ExprCallContext -> {
                for (e in exprCtx.expr()) expr(e)
            }

            is ZincParser.ExprVarContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)
            }

            is ZincParser.ExprFunContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is ZincParser.ExprUnContext -> {
                semanticHub
                    .add(exprCtx.MINUS(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.NOT(), SemanticTokenType.OPERATOR)

                expr(exprCtx.expr())
            }

            is ZincParser.ExprDotContext -> {
                exprCtx.expr().forEach { expr(it) }
            }

            is ZincParser.ExprArrContext -> {
                exprCtx.expr().forEach { expr(it) }
            }

            else -> server?.log("expr:${exprCtx.javaClass.simpleName}")
        }
    }
}

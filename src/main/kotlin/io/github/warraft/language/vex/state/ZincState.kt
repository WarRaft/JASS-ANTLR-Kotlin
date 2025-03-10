package io.github.warraft.language.vex.state

import io.github.warraft.ZincLexer
import io.github.warraft.ZincParser
import io.github.warraft.ZincParser.*
import io.github.warraft.language._.state.LanguageState
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
            for (itemCtx in it.rootItem()) root(itemCtx)
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }

    fun root(rootCtx: RootItemContext) {
        for (ctx in rootCtx.children) {
            when (ctx) {
                is LibContext -> lib(ctx)
                is VisContext -> vis(ctx)
                is StmtLeftContext -> leftStmt(ctx)
                is FunctionContext -> function(ctx)
                is StmtContext -> stmt(ctx)
                else -> server?.log("$path | root:${ctx.javaClass.simpleName}")
            }
        }
    }

    fun function(ctx: FunctionContext) {
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
            val typenameCtx: TypenameContext? = paramCtx.typename()
            val varnameCtx: VarnameContext? = paramCtx.varname()

            semanticHub
                .add(typenameCtx?.ID(), SemanticTokenType.TYPE_PARAMETER)
                .add(varnameCtx?.ID(), SemanticTokenType.PARAMETER)
        }

        for (ctx in ctx.stmt()) {
            stmt(ctx)
        }
    }

    fun lib(ctx: LibContext) {
        for (idCtx in ctx.ID()) {
            semanticHub.add(idCtx, SemanticTokenType.NAMESPACE)
        }
        semanticHub
            .add(ctx.LIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.REQUIRES(), SemanticTokenType.KEYWORD)
            .add(ctx.STRUCT(), SemanticTokenType.KEYWORD)

        for (rootCtx in ctx.rootItem()) {
            root(rootCtx)
        }
    }

    fun vis(ctx: VisContext) {
        semanticHub
            .add(ctx.PUBLIC(), SemanticTokenType.KEYWORD)
            .add(ctx.PRIVATE(), SemanticTokenType.KEYWORD)

        for (itemCtx in ctx.rootItem()) {
            root(itemCtx)
        }
    }

    fun leftStmt(ctx: StmtLeftContext) {
        left(ctx.left())
        expr(ctx.expr())
    }

    fun left(list: List<LeftContext>) {
        for (ctx in list) left(ctx)
    }

    fun left(ctx: LeftContext?) {
        when (ctx) {
            is LeftTypeContext -> {
                semanticHub.add(ctx.ID(), SemanticTokenType.TYPE)
                left(ctx.left())
            }

            is LeftIdContext -> {
                semanticHub.add(ctx.ID(), SemanticTokenType.VARIABLE)
            }

            is LeftDotContext -> {
                left(ctx.left())
            }

            is LeftCallContext -> {
                left(ctx.left())
                expr(ctx.expr())
            }

            is LeftArrContext -> {
                expr(ctx.expr())
                left(ctx.left())
            }

            is LeftCommaContext -> {
                semanticHub.add(ctx.COMMA(), SemanticTokenType.VARIABLE)
                left(ctx.left())
            }

            is LeftContext -> {}
        }
    }

    fun stmt(list: List<StmtContext>) = list.forEach { stmt(it) }

    fun stmt(ctx: StmtContext) {
        when (ctx) {
            is StmtLeftContext -> {
                leftStmt(ctx)
                semanticHub.add(ctx.EQ(), SemanticTokenType.OPERATOR)

                expr(ctx.expr())
            }

            is StmtIfContext -> {
                semanticHub
                    .add(ctx.IF(), SemanticTokenType.KEYWORD)
                    .add(ctx.WHILE(), SemanticTokenType.KEYWORD)
                    .add(ctx.FOR(), SemanticTokenType.KEYWORD)

                expr(ctx.expr())
                stmt(ctx.stmt())

                val elseCtx: ElseRuleContext? = ctx.elseRule()
                if (elseCtx != null) {
                    semanticHub
                        .add(elseCtx.ELSE(), SemanticTokenType.KEYWORD)
                    stmt(elseCtx.stmt())
                }
            }

            is StmtReturnContext -> {
                semanticHub
                    .add(ctx.RETURN(), SemanticTokenType.KEYWORD)

                expr(ctx.expr())
            }

            is StmtModContext -> {
                semanticHub
                    .add(ctx.DEBUG(), SemanticTokenType.KEYWORD)
                    .add(ctx.STATIC(), SemanticTokenType.KEYWORD)
                    .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
                stmt(ctx.stmt())
            }

            else -> server?.log("$path |stmt:${ctx.javaClass.simpleName}")
        }
    }

    fun expr(exprsCtx: List<ExprContext>, opsCtx: List<TerminalNode?>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
        for (opCtx in opsCtx) semanticHub.add(opCtx, SemanticTokenType.OPERATOR)
    }

    fun expr(exprsCtx: List<ExprContext>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
    }

    fun expr(exprCtx: ExprContext?) {
        if (exprCtx == null) return

        when (exprCtx) {
            is ExprEqContext -> expr(exprCtx.expr(), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()))
            is ExprAddContext -> expr(exprCtx.expr(), listOf(exprCtx.ADD(), exprCtx.SUB()))
            is ExprMulContext -> expr(exprCtx.expr(), listOf(exprCtx.MUL(), exprCtx.DIV()))
            is ExprLtContext -> expr(exprCtx.expr(), listOf(exprCtx.LT(), exprCtx.LT_EQ(), exprCtx.GT(), exprCtx.GT_EQ()))
            is ExprAndContext -> expr(exprCtx.expr(), listOf(exprCtx.AND_AND(), exprCtx.AND_AND()))

            is ExprLambdaContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.RETURNS(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.ID(), SemanticTokenType.KEYWORD)

                exprCtx.stmt().forEach { stmt(it) }
            }

            is ExprNullContext -> {
                semanticHub
                    .add(exprCtx.NULL(), SemanticTokenType.KEYWORD)
            }

            is ExprStrContext -> {
                semanticHub
                    .add(exprCtx.STRING(), SemanticTokenType.STRING)
            }

            is ExprBoolContext -> {
                semanticHub
                    .add(exprCtx.TRUE(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.FALSE(), SemanticTokenType.KEYWORD)
            }

            is ExprIntContext -> {
                semanticHub
                    .add(exprCtx.INTVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.HEXVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.RAWVAL(), SemanticTokenType.NUMBER)
            }

            is ExprRealContext -> {
                semanticHub.add(exprCtx.REALVAL(), SemanticTokenType.NUMBER)
            }

            is ExprCallContext -> {
                for (e in exprCtx.expr()) expr(e)
            }

            is ExprVarContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)
            }

            is ExprFunContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is ExprUnContext -> {
                semanticHub
                    .add(exprCtx.SUB(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.NOT(), SemanticTokenType.OPERATOR)

                expr(exprCtx.expr())
            }

            is ExprDotContext -> expr(exprCtx.expr())
            is ExprArrContext -> expr(exprCtx.expr())
            is ExprParenContext -> expr(exprCtx.expr())


            else -> server?.log("$path | expr:${exprCtx.javaClass.simpleName}")
        }
    }
}

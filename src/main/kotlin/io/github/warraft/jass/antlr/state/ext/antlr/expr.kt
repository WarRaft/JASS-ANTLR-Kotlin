package io.github.warraft.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.ExprAddContext
import io.github.warraft.JassParser.ExprAndContext
import io.github.warraft.JassParser.ExprArrContext
import io.github.warraft.JassParser.ExprBoolContext
import io.github.warraft.JassParser.ExprCallContext
import io.github.warraft.JassParser.ExprContext
import io.github.warraft.JassParser.ExprEqContext
import io.github.warraft.JassParser.ExprFunContext
import io.github.warraft.JassParser.ExprIntContext
import io.github.warraft.JassParser.ExprLtContext
import io.github.warraft.JassParser.ExprMulContext
import io.github.warraft.JassParser.ExprNullContext
import io.github.warraft.JassParser.ExprParenContext
import io.github.warraft.JassParser.ExprRealContext
import io.github.warraft.JassParser.ExprStrContext
import io.github.warraft.JassParser.ExprUnContext
import io.github.warraft.JassParser.ExprVarContext
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.JassBool
import io.github.warraft.jass.antlr.psi.JassCodeType
import io.github.warraft.jass.antlr.psi.JassExpr
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassInt
import io.github.warraft.jass.antlr.psi.JassNull
import io.github.warraft.jass.antlr.psi.JassReal
import io.github.warraft.jass.antlr.psi.JassStr
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

fun JassState.expr(
    ctx: ParserRuleContext,
    a: ExprContext?,
    b: ExprContext?,
    ops: List<TerminalNode?>,
    scope: JassFun?,
): JassExpr? {
    var op: JassExprOp? = null
    var optext: String? = ""
    for (it in ops) {
        semanticHub.add(it, SemanticTokenType.OPERATOR)
        optext = it?.text
        op = JassExprOp.Companion.fromSymbol(optext)
        if (op != null) break
    }

    if (op == null) {
        diagnosticHub.add(a ?: b, JassDiagnosticCode.PLUGIN, "Missing operator")
        return null
    }

    val e = JassExpr(
        op = op,
        a = expr(a, scope),
        b = expr(b, scope)
    )

    if (e.type is JassUndefinedType) {
        diagnosticHub.add(
            ctx,
            JassDiagnosticCode.ERROR,
            "Operation not exists: (${a?.text})->${e.a?.type?.name} $optext (${b?.text})->${e.b?.type?.name}"
        )
    }

    return e
}

fun JassState.expr(ctx: ExprContext?, scope: JassFun?): JassExpr? {
    if (ctx == null) return null

    when (ctx) {
        is ExprFunContext -> {
            val nameCtx: TerminalNode? = ctx.ID()
            if (nameCtx == null) {
                diagnosticHub.add(ctx, JassDiagnosticCode.ERROR, "Missing function name")
                return null
            }

            val name = nameCtx.text
            val node = getNode(name, scope)
            if (node !is JassFun) {
                diagnosticHub.add(
                    nameCtx,
                    JassDiagnosticCode.ERROR,
                    "$name function not exists"
                )
                return null
            }

            semanticHub
                .add(nameCtx, SemanticTokenType.FUNCTION)
                .add(ctx.FUNCTION(), SemanticTokenType.KEYWORD)

            return JassExpr(
                op = JassExprOp.Get,
                a = node.clone(
                    state = this,
                    type = JassCodeType(),
                    ref = true,
                    symbol = nameCtx.symbol
                ).also {
                    tokenTree.add(it)
                }
            )
        }

        is ExprCallContext -> {
            val nameCtx = ctx.ID()
            val name = nameCtx.text
            val node = getNode(name, scope)
            if (node !is JassFun) {
                diagnosticHub.add(
                    nameCtx,
                    JassDiagnosticCode.ERROR,
                    "$name function not exists"
                )
                return null
            }
            semanticHub.add(nameCtx, SemanticTokenType.FUNCTION)

            val fn = node.clone(
                state = this,
                symbol = nameCtx.symbol
            ).also {
                tokenTree.add(it)
            }

            argument(fn, scope, ctx.expr(), ctx.LPAREN(), ctx.RPAREN())

            return JassExpr(
                op = JassExprOp.Get,
                a = fn
            )
        }

        is ExprVarContext -> {
            val idctx = ctx.ID()
            semanticHub.add(idctx, SemanticTokenType.VARIABLE)
            val name = idctx.text
            var node: JassNodeBase? = getNode(name, scope)
            if (node is JassVar) {
                return JassExpr(
                    op = JassExprOp.Get,
                    a = node.clone(
                        state = this,
                        symbol = idctx.symbol,
                    ).also { tokenTree.add(it) }
                )
            }
            diagnosticHub.add(
                idctx,
                JassDiagnosticCode.ERROR,
                "$name is not declared"
            )
            return null
        }

        is ExprArrContext -> {
            val idctx = ctx.ID()
            semanticHub.add(idctx, SemanticTokenType.VARIABLE)

            val name = idctx.text
            var node: JassNodeBase? = getNode(name, scope)
            if (node !is JassVar) {
                diagnosticHub.add(
                    idctx,
                    JassDiagnosticCode.ERROR,
                    "$name array is not declared"
                )
                return null
            }
            return JassExpr(
                op = JassExprOp.Get,
                a = node.clone(
                    state = this,
                    index = expr(ctx.expr(), scope),
                    symbol = idctx.symbol
                ).also { tokenTree.add(it) },
            )
        }

        is ExprUnContext -> return JassExpr(
            op = when (true) {
                (ctx.MINUS() != null) -> JassExprOp.UnSub
                (ctx.NOT() != null) -> JassExprOp.UnNot
                else -> return null
            },
            a = expr(ctx.expr(), scope),
        )

        is ExprIntContext -> {
            semanticHub
                .add(ctx.INTVAL(), SemanticTokenType.NUMBER)
                .add(ctx.HEXVAL(), SemanticTokenType.NUMBER)
                .add(ctx.RAWVAL(), SemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
        }

        is ExprStrContext -> {
            semanticHub.add(ctx.STRING(), SemanticTokenType.STRING)
            return JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
        }

        is ExprBoolContext -> {
            semanticHub
                .add(ctx.TRUE(), SemanticTokenType.KEYWORD)
                .add(ctx.FALSE(), SemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
        }

        is ExprRealContext -> {
            semanticHub.add(ctx.REALVAL(), SemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
        }

        is ExprNullContext -> {
            semanticHub.add(ctx.NULL(), SemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassNull())
        }

        is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), scope))
        is ExprMulContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.MUL(), ctx.DIV()), scope)
        is ExprAddContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.PLUS(), ctx.MINUS()), scope)
        is ExprLtContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()), scope)
        is ExprEqContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.EQ_EQ(), ctx.NEQ()), scope)
        is ExprAndContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.AND(), ctx.OR()), scope)
    }
    diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Undeclared expression")
    return null
}



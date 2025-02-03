package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.psi.IJassNode
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
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

fun JassState.expr(
    ctx: ParserRuleContext,
    a: JassParser.ExprContext?,
    b: JassParser.ExprContext?,
    ops: List<TerminalNode?>,
    scope: JassFun?,
): JassExpr? {
    var op: JassExprOp? = null
    var optext: String? = ""
    for (it in ops) {
        semanticHub.add(it, JassSemanticTokenType.OPERATOR)
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

fun JassState.expr(ctx: JassParser.ExprContext?, scope: JassFun?): JassExpr? {
    if (ctx == null) return null

    when (ctx) {
        is JassParser.ExprFunContext -> {
            val idctx = ctx.ID()
            val name = idctx.text
            val cf = JassFun(
                name = name,
                type = JassCodeType(),
                ref = true,
            )

            semanticHub
                .add(idctx, JassSemanticTokenType.FUNCTION)
                .add(ctx.FUNCTION(), JassSemanticTokenType.KEYWORD)

            return JassExpr(
                op = JassExprOp.Get,
                a = cf
            )
        }

        is JassParser.ExprCallContext -> {
            val idctx = ctx.ID()
            val name = idctx.text
            val node = getNode(name, scope)
            if (node !is JassFun) {
                diagnosticHub.add(
                    idctx,
                    JassDiagnosticCode.ERROR,
                    "$name function not exists"
                )
                return null
            }
            val cf = node.clone()

            semanticHub.add(idctx, JassSemanticTokenType.FUNCTION)

            ctx.expr().forEach {
                val e = expr(it, scope)
                if (e != null) {
                    cf.arg.add(e)
                }
            }

            return JassExpr(
                op = JassExprOp.Get,
                a = cf
            )
        }

        is JassParser.ExprVarContext -> {
            val idctx = ctx.ID()
            semanticHub.add(idctx, JassSemanticTokenType.VARIABLE)
            val name = idctx.text
            var node: IJassNode? = getNode(name, scope)
            if (node is JassVar) {
                return JassExpr(
                    op = JassExprOp.Get,
                    a = node.clone(
                        symbol = idctx.symbol,
                    ).apply { tokenTree.add(this) }
                )
            }
            diagnosticHub.add(
                idctx,
                JassDiagnosticCode.ERROR,
                "$name is not declared"
            )
            return null
        }

        is JassParser.ExprArrContext -> {
            val idctx = ctx.ID()
            semanticHub.add(idctx, JassSemanticTokenType.VARIABLE)

            val name = idctx.text
            var node: IJassNode? = getNode(name, scope)
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
                    index = expr(ctx.expr(), scope),
                    symbol = idctx.symbol
                ).apply { tokenTree.add(this) },
            )
        }

        is JassParser.ExprUnContext -> return JassExpr(
            op = when (true) {
                (ctx.MINUS() != null) -> JassExprOp.UnSub
                (ctx.NOT() != null) -> JassExprOp.UnNot
                else -> return null
            },
            a = expr(ctx.expr(), scope),
        )

        is JassParser.ExprIntContext -> {
            semanticHub
                .add(ctx.INTVAL(), JassSemanticTokenType.NUMBER)
                .add(ctx.HEXVAL(), JassSemanticTokenType.NUMBER)
                .add(ctx.RAWVAL(), JassSemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
        }

        is JassParser.ExprStrContext -> {
            semanticHub.add(ctx.STRING(), JassSemanticTokenType.STRING)
            return JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
        }

        is JassParser.ExprBoolContext -> {
            semanticHub
                .add(ctx.TRUE(), JassSemanticTokenType.KEYWORD)
                .add(ctx.FALSE(), JassSemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
        }

        is JassParser.ExprRealContext -> {
            semanticHub.add(ctx.REALVAL(), JassSemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
        }

        is JassParser.ExprNullContext -> {
            semanticHub.add(ctx.NULL(), JassSemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassNull())
        }

        is JassParser.ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), scope))

        is JassParser.ExprMulContext -> return expr(
            ctx,
            ctx.expr(0),
            ctx.expr(1),
            listOf(ctx.MUL(), ctx.DIV()),
            scope
        )

        is JassParser.ExprAddContext -> return expr(
            ctx,
            ctx.expr(0),
            ctx.expr(1),
            listOf(ctx.PLUS(), ctx.MINUS()),
            scope
        )

        is JassParser.ExprLtContext -> return expr(
            ctx,
            ctx.expr(0),
            ctx.expr(1),
            listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()),
            scope
        )

        is JassParser.ExprEqContext -> return expr(
            ctx,
            ctx.expr(0),
            ctx.expr(1),
            listOf(ctx.EQ_EQ(), ctx.NEQ()),
            scope
        )

        is JassParser.ExprAndContext -> return expr(
            ctx,
            ctx.expr(0),
            ctx.expr(1),
            listOf(ctx.AND(), ctx.OR()),
            scope
        )
    }
    diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Undeclared expression")
    return null
}



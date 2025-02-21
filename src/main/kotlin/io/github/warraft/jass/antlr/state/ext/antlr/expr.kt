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
import io.github.warraft.jass.antlr.psi.JassBool
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
    function: JassFun?,
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
        a = expr(a, function),
        b = expr(b, function)
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

fun JassState.expr(ctx: ExprContext?, function: JassFun?): JassExpr? {
    if (ctx == null) return null
    when (ctx) {

        //region ExprVarContext, ExprArrContext
        is ExprVarContext,
        is ExprArrContext,
            -> {
            val v = JassVar.parse(ctx, function, this) ?: return null
            return JassExpr(op = JassExprOp.Get, a = v)
        }
        //endregion

        //region ExprCallContext, ExprFunContext
        is ExprCallContext,
        is ExprFunContext,
            -> {
            val f = JassFun.parse(ctx, function, this) ?: return null
            return JassExpr(op = JassExprOp.Get, a = f)
        }
        //endregion

        is ExprUnContext -> return JassExpr(
            op = when (true) {
                (ctx.MINUS() != null) -> JassExprOp.UnSub
                (ctx.NOT() != null) -> JassExprOp.UnNot
                else -> return null
            },
            a = expr(ctx.expr(), function),
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

        is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), function))
        is ExprMulContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.MUL(), ctx.DIV()), function)
        is ExprAddContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.PLUS(), ctx.MINUS()), function)
        is ExprLtContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()), function)
        is ExprEqContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.EQ_EQ(), ctx.NEQ()), function)
        is ExprAndContext -> return expr(ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.AND(), ctx.OR()), function)
    }
    diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Undeclared expression")
    return null
}




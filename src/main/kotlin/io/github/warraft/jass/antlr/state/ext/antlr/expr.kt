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

fun JassState.expr(exprCtx: ExprContext?, function: JassFun?): JassExpr? {
    if (exprCtx == null) return null
    when (exprCtx) {

        //region ExprVarContext
        is ExprVarContext -> {
            val idCtx = exprCtx.ID()
            semanticHub.add(idCtx, SemanticTokenType.VARIABLE)
            val name = idCtx.text

            var v: JassNodeBase? = getNode(name, function)
            if (v !is JassVar) {
                diagnosticHub.add(
                    idCtx,
                    JassDiagnosticCode.ERROR,
                    "$name is not declared"
                )
                return null
            }
            return JassExpr(
                op = JassExprOp.Get,
                a = v.clone(
                    state = this,
                    symbol = idCtx.symbol,
                ).also {
                    tokenTree.add(it)
                }
            )
        }
        //endregion

        is ExprFunContext -> {
            val nameCtx: TerminalNode? = exprCtx.ID()
            if (nameCtx == null) {
                diagnosticHub.add(exprCtx, JassDiagnosticCode.ERROR, "Missing function name")
                return null
            }

            val name = nameCtx.text
            val node = getNode(name, function)
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
                .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)

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
            val nameCtx = exprCtx.ID()
            val name = nameCtx.text
            val node = getNode(name, function)
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

            argument(fn, function, exprCtx.expr(), exprCtx.LPAREN(), exprCtx.RPAREN())

            return JassExpr(
                op = JassExprOp.Get,
                a = fn
            )
        }

        is ExprArrContext -> {
            val idctx = exprCtx.ID()
            semanticHub.add(idctx, SemanticTokenType.VARIABLE)

            val name = idctx.text
            var node: JassNodeBase? = getNode(name, function)
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
                    index = expr(exprCtx.expr(), function),
                    symbol = idctx.symbol
                ).also {
                    tokenTree.add(it)
                    it.scope?.link(it)
                },
            )
        }

        is ExprUnContext -> return JassExpr(
            op = when (true) {
                (exprCtx.MINUS() != null) -> JassExprOp.UnSub
                (exprCtx.NOT() != null) -> JassExprOp.UnNot
                else -> return null
            },
            a = expr(exprCtx.expr(), function),
        )

        is ExprIntContext -> {
            semanticHub
                .add(exprCtx.INTVAL(), SemanticTokenType.NUMBER)
                .add(exprCtx.HEXVAL(), SemanticTokenType.NUMBER)
                .add(exprCtx.RAWVAL(), SemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassInt(exprCtx.text))
        }

        is ExprStrContext -> {
            semanticHub.add(exprCtx.STRING(), SemanticTokenType.STRING)
            return JassExpr(op = JassExprOp.Get, a = JassStr(exprCtx.text))
        }

        is ExprBoolContext -> {
            semanticHub
                .add(exprCtx.TRUE(), SemanticTokenType.KEYWORD)
                .add(exprCtx.FALSE(), SemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassBool(exprCtx.text))
        }

        is ExprRealContext -> {
            semanticHub.add(exprCtx.REALVAL(), SemanticTokenType.NUMBER)
            return JassExpr(op = JassExprOp.Get, a = JassReal(exprCtx.text))
        }

        is ExprNullContext -> {
            semanticHub.add(exprCtx.NULL(), SemanticTokenType.KEYWORD)
            return JassExpr(op = JassExprOp.Get, a = JassNull())
        }

        is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(exprCtx.expr(), function))
        is ExprMulContext -> return expr(exprCtx, exprCtx.expr(0), exprCtx.expr(1), listOf(exprCtx.MUL(), exprCtx.DIV()), function)
        is ExprAddContext -> return expr(exprCtx, exprCtx.expr(0), exprCtx.expr(1), listOf(exprCtx.PLUS(), exprCtx.MINUS()), function)
        is ExprLtContext -> return expr(exprCtx, exprCtx.expr(0), exprCtx.expr(1), listOf(exprCtx.LT(), exprCtx.LT_EQ(), exprCtx.GT(), exprCtx.GT_EQ()), function)
        is ExprEqContext -> return expr(exprCtx, exprCtx.expr(0), exprCtx.expr(1), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()), function)
        is ExprAndContext -> return expr(exprCtx, exprCtx.expr(0), exprCtx.expr(1), listOf(exprCtx.AND(), exprCtx.OR()), function)
    }
    diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Undeclared expression")
    return null
}




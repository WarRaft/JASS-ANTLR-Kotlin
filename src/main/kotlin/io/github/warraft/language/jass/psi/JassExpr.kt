package io.github.warraft.language.jass.psi

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
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.language.jass.psi.JassExprOp.*
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticCode
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassExpr(
    override val state: JassState,
    val op: JassExprOp?,
    val a: JassNodeBase? = null,
    val b: JassNodeBase? = null,
) : JassNodeBase() {
    init {
        type = when (op) {
            ADD, SUB,
            MUL, DIV,
            LT, LTEQ,
            GT, GTEQ,
            EQ, NEQ,
            AND, OR,
            SET,
                -> a?.typeCheck(op, b)

            GET -> when (a) {
                is JassNodeBase -> a.type
                else -> null
            }

            UNSUB,
            UNNOT,
            PAREN,
                -> a?.type

            null -> null
        }
    }

    override fun toString(): String {
        return when (op) {
            GET -> "$a"
            else -> return "$type:$op($a, $b)"
        }
    }

    companion object {
        private fun expr(
            state: JassState,
            ctx: ParserRuleContext,
            aCtx: ExprContext?,
            bCtx: ExprContext?,
            ops: List<TerminalNode?>,
            function: JassFun?,
        ): JassExpr? {
            var op: JassExprOp? = null
            var optext: String? = ""
            for (it in ops) {
                state.semanticHub.add(it, SemanticTokenType.OPERATOR)
                optext = it?.text
                op = JassExprOp.Companion.parse(optext)
                if (op != null) break
            }

            if (op == null) {
                Diagnostic(
                    range = Range.of(aCtx ?: bCtx ?: ctx) ?: Range.zero,
                    message = "Missing operator",
                    code = DiagnosticCode.PLUGIN,
                ).also {
                    state.diagnostic.add(it)
                }
                return null
            }

            val a = parse(state, aCtx, function)
            val b = parse(state, bCtx, function)

            return JassExpr(state = state, op = op, a = a, b = b)
        }


        fun parse(state: JassState, ctx: ExprContext?, function: JassFun?): JassExpr? {
            if (ctx == null) return null

            val e = when (ctx) {
                //region ExprVarContext, ExprArrContext
                is ExprVarContext, is ExprArrContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassVar.parse(ctx, function, state)
                )
                //endregion

                //region ExprCallContext, ExprFunContext
                is ExprCallContext, is ExprFunContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassFun.parse(ctx, function, state)
                )
                //endregion

                is ExprUnContext -> JassExpr(
                    state = state,
                    op = when (true) {
                        (ctx.SUB() != null) -> UNSUB
                        (ctx.NOT() != null) -> UNNOT
                        else -> null
                    },
                    a = parse(state, ctx.expr(), function),
                )

                is ExprIntContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassInt(state = state, ctx.text)
                ).also {
                    state.semanticHub
                        .add(ctx.INTVAL(), SemanticTokenType.NUMBER)
                        .add(ctx.HEXVAL(), SemanticTokenType.NUMBER)
                        .add(ctx.RAWVAL(), SemanticTokenType.NUMBER)
                }

                is ExprStrContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassStr(state = state, ctx.text)
                ).also {
                    state.semanticHub.add(ctx.STRING(), SemanticTokenType.STRING)
                }

                is ExprBoolContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassBool(state = state, ctx.text)
                ).also {
                    state.semanticHub
                        .add(ctx.TRUE(), SemanticTokenType.KEYWORD)
                        .add(ctx.FALSE(), SemanticTokenType.KEYWORD)
                }

                is ExprRealContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassReal(state = state, ctx.text)
                ).also {
                    state.semanticHub.add(ctx.REALVAL(), SemanticTokenType.NUMBER)
                }

                is ExprNullContext -> JassExpr(
                    state = state,
                    op = GET,
                    a = JassNull(state)
                ).also {
                    state.semanticHub.add(ctx.NULL(), SemanticTokenType.KEYWORD)
                }

                is ExprParenContext -> JassExpr(
                    state = state,
                    op = PAREN,
                    a = parse(state, ctx.expr(), function)
                )

                is ExprMulContext -> expr(state, ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.MUL(), ctx.DIV()), function)
                is ExprAddContext -> expr(state, ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.ADD(), ctx.SUB()), function)
                is ExprLtContext -> expr(state, ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()), function)
                is ExprEqContext -> expr(state, ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.EQ_EQ(), ctx.NEQ()), function)
                is ExprAndContext -> expr(state, ctx, ctx.expr(0), ctx.expr(1), listOf(ctx.AND(), ctx.OR()), function)
                else -> null
            }

            e.also {
                it?.definition = ctx
            }

            if (e == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Undeclared expression",
                    code = DiagnosticCode.PLUGIN,
                ).also {
                    state.diagnostic.add(it)
                }

            } else if (e.type == null) {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Expression type not found",
                    code = DiagnosticCode.PLUGIN,
                ).also {
                    state.diagnostic.add(it)
                }
            }

            return e
        }
    }
}

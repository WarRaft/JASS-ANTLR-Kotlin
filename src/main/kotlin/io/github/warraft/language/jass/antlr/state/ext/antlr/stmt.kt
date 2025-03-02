package io.github.warraft.language.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.antlr.psi.*
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticCode
import io.github.warraft.lsp.data.Range
import io.github.warraft.lsp.data.semantic.SemanticTokenType

fun JassState.stmt(ctxs: List<StmtContext>, list: MutableList<JassNodeBase>, function: JassFun) {
    for (ctx in ctxs) {
        when (ctx) {

            //region StmtSetContext
            is StmtSetContext -> {
                JassVar.parse(ctx, function, this)
                continue
            }
            //endregion

            //region StmtCallContext
            is StmtCallContext -> {
                val f = JassFun.parse(ctx, function, this) ?: continue
                list.add(f)
            }
            //endregion

            is StmtLoopContext -> {
                semanticHub
                    .add(ctx.LOOP(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDLOOP(), SemanticTokenType.KEYWORD)

                val l = JassLoop(state = this)
                list.add(l)
                stmt(ctx.stmt(), l.stmt, function)
            }

            is StmtExitWhenContext -> {
                semanticHub.add(ctx.EXITWHEN(), SemanticTokenType.KEYWORD)

                val exp = JassExpr.parse(this, ctx.expr(), function)
                if (exp == null) {
                    Diagnostic(
                        range = Range.of(ctx.EXITWHEN()) ?: Range.zero,
                        message = "Missing expression",
                        code = DiagnosticCode.ERROR,
                    ).also {
                        diagnostic.add(it)
                    }
                } else {
                    list.add(JassExitWhen(state = this, expr = exp))
                }
            }

            //region StmtReturnContext
            is StmtReturnContext -> {
                semanticHub.add(ctx.RETURN(), SemanticTokenType.KEYWORD)

                val e = JassExpr.parse(this, ctx.expr(), function)
                if (e != null) {
                    val v = e.a
                    if (v is JassVar && v.array && v.index == null) {
                        Diagnostic(
                            range = Range.of(v.definition) ?: Range.zero,
                            message = "Array return",
                            code = DiagnosticCode.ARRAY_RETURN,
                        ).also {
                            diagnostic.add(it)
                        }
                    }
                }
                list.add(JassReturn(state = this, expr = e))
            }
            //endregion

            //region StmtIfContext
            is StmtIfContext -> {
                val e = JassExpr.parse(this, ctx.expr(), function)
                if (e == null) {
                    Diagnostic(
                        range = Range.of(ctx.IF()) ?: Range.zero,
                        message = "Missing expression",
                        code = DiagnosticCode.ERROR,
                    ).also {
                        diagnostic.add(it)
                    }
                    continue
                }
                val nodeIf = JassIf(state = this, expr = e)

                semanticHub
                    .add(ctx.IF(), SemanticTokenType.KEYWORD)
                    .add(ctx.THEN(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDIF(), SemanticTokenType.KEYWORD)

                list.add(nodeIf)
                stmt(ctx.stmt(), nodeIf.stmt, function)

                for (elseifctx: ElseifContext in ctx.elseif()) {
                    val e = JassExpr.parse(this, elseifctx.expr(), function)
                    semanticHub
                        .add(elseifctx.ELSEIF(), SemanticTokenType.KEYWORD)
                        .add(elseifctx.THEN(), SemanticTokenType.KEYWORD)
                    if (e == null) {
                        Diagnostic(
                            range = Range.of(elseifctx.ELSEIF()) ?: Range.zero,
                            message = "Missing expression",
                            code = DiagnosticCode.ERROR,
                        ).also {
                            diagnostic.add(it)
                        }
                        continue
                    }
                    val nodeElseif = JassIf(state = this, expr = e)
                    nodeIf.elseifs.add(nodeElseif)
                    stmt(elseifctx.stmt(), nodeElseif.stmt, function)
                }

                val elsectx: ElseRuleContext? = ctx.elseRule()
                if (elsectx != null) {
                    semanticHub.add(elsectx.ELSE(), SemanticTokenType.KEYWORD)
                    val elser = JassIf(state = this)
                    nodeIf.elser = elser
                    stmt(elsectx.stmt(), elser.stmt, function)
                }
            }
            //endregion

            else -> {
                Diagnostic(
                    range = Range.of(ctx) ?: Range.zero,
                    message = "Udeclared statement",
                    code = DiagnosticCode.PLUGIN
                ).also {
                    diagnostic.add(it)
                }
            }
        }
    }
}

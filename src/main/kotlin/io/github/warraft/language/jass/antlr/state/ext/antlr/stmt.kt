package io.github.warraft.language.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.antlr.psi.*
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.language._.lsp4j.service.document.semantic.token.SemanticTokenType

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
                    diagnosticHub.add(
                        ctx.EXITWHEN(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
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
                        diagnosticHub.add(
                            v.definition,
                            JassDiagnosticCode.ARRAY_RETURN,
                            "Array return"
                        )
                    }
                }
                list.add(JassReturn(state = this, expr = e))
            }
            //endregion

            //region StmtIfContext
            is StmtIfContext -> {
                val e = JassExpr.parse(this, ctx.expr(), function)
                if (e == null) {
                    diagnosticHub.add(
                        ctx.IF(),
                        JassDiagnosticCode.ERROR,
                        "Missing expression"
                    )
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
                        diagnosticHub.add(
                            elseifctx.ELSEIF(),
                            JassDiagnosticCode.ERROR,
                            "Missing expression"
                        )
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

            else -> diagnosticHub.add(JassDiagnosticCode.PLUGIN, "Udeclared statement")
        }
    }
}

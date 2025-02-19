package io.github.warraft.jass.antlr.state.ext.antlr

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import kotlin.collections.set

fun JassState.global(variableCtx: VariableContext) {
    val varnameCtx = variableCtx.varname()?.ID()
    val tctx = variableCtx.typename()?.ID()
    val cctx = variableCtx.CONSTANT()
    val actx = variableCtx.ARRAY()
    val eqctx = variableCtx.EQ()

    semanticHub
        .add(varnameCtx, SemanticTokenType.VARIABLE, SemanticTokenModifier.DECLARATION)
        .add(tctx, SemanticTokenType.TYPE)
        .add(cctx, SemanticTokenType.KEYWORD)
        .add(actx, SemanticTokenType.KEYWORD)
        .add(eqctx, SemanticTokenType.OPERATOR)


    val v = JassVar(
        state = this,
        name = varnameCtx?.text ?: "",
        constant = cctx != null,
        array = actx != null,
        global = true,
        type = typeFromString(variableCtx.typename().text),
        symbol = varnameCtx?.symbol,
    ).also {
        tokenTree.add(it)
    }

    if (eqctx != null) {
        v.expr = expr(variableCtx.expr(), null)
        if (v.expr == null) {
            diagnosticHub.add(
                eqctx,
                JassDiagnosticCode.ERROR,
                "${v.name} global set missing"
            )
        } else {
            val ta: JassTypeBase = v.type
            val tb: JassTypeBase = v.expr!!.type
            val t = ta.op(JassExprOp.Set, tb)
            if (t is JassUndefinedType) {
                diagnosticHub.add(
                    variableCtx.EQ(),
                    JassDiagnosticCode.ERROR,
                    "${ta.name} + ${tb.name} is ${t.name}"
                )
            }
        }
    }

    if (getNode(v.name, null) != null) {
        diagnosticHub.add(
            varnameCtx,
            JassDiagnosticCode.ERROR,
            "redeclared"
        )
        return
    }

    nodeMap[v.name] = v
    globals.add(v)
}

package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import kotlin.collections.set

fun JassState.global(definitionCtx: JassParser.VariableContext) {
    val nameCtx = definitionCtx.varname()?.ID()
    val tctx = definitionCtx.typename()?.ID()
    val cctx = definitionCtx.CONSTANT()
    val actx = definitionCtx.ARRAY()
    val eqctx = definitionCtx.EQ()

    semanticHub
        .add(nameCtx, JassSemanticTokenType.VARIABLE, JassSemanticTokenModifier.DECLARATION)
        .add(tctx, JassSemanticTokenType.TYPE)
        .add(cctx, JassSemanticTokenType.KEYWORD)
        .add(actx, JassSemanticTokenType.KEYWORD)
        .add(eqctx, JassSemanticTokenType.OPERATOR)


    val v = JassVar(
        state = this,
        name = nameCtx?.text ?: "",
        constant = cctx != null,
        array = actx != null,
        global = true,
        type = typeFromString(definitionCtx.typename().text),
        symbol = nameCtx?.symbol,
        definition = definitionCtx,
    ).also {
        tokenTree.add(it)
    }

    if (eqctx != null) {
        v.expr = expr(definitionCtx.expr(), null)
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
                    definitionCtx.EQ(),
                    JassDiagnosticCode.ERROR,
                    "${ta.name} + ${tb.name} is ${t.name}"
                )
            }
        }
    }

    if (getNode(v.name, null) != null) {
        diagnosticHub.add(
            nameCtx,
            JassDiagnosticCode.ERROR,
            "redeclared"
        )
        return
    }

    nodeMap[v.name] = v
    globals.add(v)
}

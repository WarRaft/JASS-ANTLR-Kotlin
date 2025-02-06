package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser.ExprContext
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import org.antlr.v4.runtime.tree.TerminalNode

fun JassState.argument(fn: JassFun, scope: JassFun?, exprs: List<ExprContext>, lp: TerminalNode?, rp: TerminalNode?) {
    val root: JassFun? = if (fn.base == null) null else fn.root

    val params = mutableListOf<JassVar>()
    root?.param?.forEach {
        if (it.param) params.add(it)
    }
    val need = params.size

    val paren = rp ?: lp

    if (root != null && exprs.size < need) {
        diagnosticHub.add(
            paren,
            JassDiagnosticCode.ERROR,
            "No enought argument. Need $need, pass ${exprs.size}."
        )
    }

    for ((index, it) in exprs.withIndex()) {
        val e = expr(it, scope) ?: continue
        if (index >= need) {
            diagnosticHub.add(
                it,
                JassDiagnosticCode.ERROR,
                "Redudant argument. Need $need, pass ${exprs.size}."
            )
            continue
        }
        fn.arg.add(e)

        val a = params.getOrNull(index)?.type ?: JassUndefinedType()
        val b = e.type
        if (b is JassNullType) continue

        if (a.op(JassExprOp.Set, b) is JassUndefinedType) {
            diagnosticHub.add(
                it,
                JassDiagnosticCode.ERROR,
                "Wrong type. Need ${a.name}, pass ${b.name}."
            )
        }
    }
}

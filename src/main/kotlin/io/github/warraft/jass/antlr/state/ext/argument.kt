package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.JassParser.ExprContext
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.state.JassState

fun JassState.argument(fn: JassFun, scope: JassFun?, exprs: List<ExprContext>) {

    for (it in exprs) {
        val e = expr(it, scope)
        if (e != null) {
            fn.arg.add(e)
        }
    }
}

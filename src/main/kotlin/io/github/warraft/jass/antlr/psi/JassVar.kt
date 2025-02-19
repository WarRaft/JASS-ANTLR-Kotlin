package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.psi.utils.JassVarScope
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.Token

class JassVar(
    val state: JassState,
    var name: String,
    val constant: Boolean = false,
    val global: Boolean = false,
    val array: Boolean = false,
    val local: Boolean = false,
    val param: Boolean = false,
    var index: JassExpr? = null,
    var expr: JassExpr? = null,
    override val type: JassTypeBase,
    val symbol: Token? = null,
) : JassNodeBase() {

    var fakename: String = ""
    var scope: JassVarScope? = null

    fun clone(
        state: JassState,
        index: JassExpr? = null,
        expr: JassExpr? = null,
        symbol: Token? = null,
    ): JassVar = JassVar(
        state = state,
        name = name,
        constant = constant,
        global = global,
        array = array,
        local = local,
        param = param,
        type = type,
        expr = expr ?: this.expr,
        index = index ?: this.index,
        symbol = symbol,
    ).also {
        scope?.link(it)
    }

    override fun toString(): String {
        val list: MutableList<String> = mutableListOf()

        if (global) {
            if (constant) list.add("constant")
            list.add("global")
        }

        if (param) list.add("param")
        else if (local) list.add("local")

        list.add(type.name)

        if (array) list.add("[]")

        var n = ""

        list.add(n + name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }
}

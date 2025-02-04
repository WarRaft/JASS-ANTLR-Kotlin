package io.github.warraft.jass.antlr.psi

import Main.Companion.BLUE
import Main.Companion.RESET
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassObjBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

class JassVar(
    override val state: JassState,
    var name: String,
    val constant: Boolean = false,
    val global: Boolean = false,
    val array: Boolean = false,
    val local: Boolean = false,
    val param: Boolean = false,
    override var base: JassVar? = null,
    var index: JassExpr? = null,
    var expr: JassExpr? = null,
    override val type: JassTypeBase,
    override val symbol: Token? = null,
    override val definition: ParserRuleContext? = null,
) : JassNodeBase(), JassObjBase<JassVar> {

    var fakename: String = ""

    override val root: JassVar
        get() = base ?: this

    override val links = mutableListOf<JassVar>()

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
        base = this,
        expr = expr ?: this.expr,
        index = index ?: this.index,
        symbol = symbol,
    ).also {
        links.add(it)
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
        if (base == null) n += "${BLUE}base:$RESET"

        list.add(n + name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }
}

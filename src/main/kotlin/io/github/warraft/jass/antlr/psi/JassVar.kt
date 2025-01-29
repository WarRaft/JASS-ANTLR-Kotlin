package io.github.warraft.jass.antlr.psi

import org.antlr.v4.runtime.ParserRuleContext

class JassVar(
    var name: String,
    val constant: Boolean = false,
    val global: Boolean = false,
    val array: Boolean = false,
    val local: Boolean = false,
    val param: Boolean = false,
    var base: JassVar? = null,
    var index: JassExpr? = null,
    var expr: JassExpr? = null,
    override val type: IJassType,
    val ctx: ParserRuleContext? = null,
) : IJassNode {

    var fakename: String = ""

    val root: JassVar
        get() = base ?: this

    fun clone(
        index: JassExpr? = null,
        expr: JassExpr? = null,
    ): JassVar = JassVar(
        name = name,
        constant = constant,
        global = global,
        array = array,
        local = local,
        param = param,
        type = type,
        base = this,
        expr = expr ?: this.expr,
        index = index ?: this.index
    )

    override fun toString(): String {
        val list: MutableList<String> = mutableListOf()

        if (global) {
            if (constant) list.add("constant")
            list.add("global")
        }

        if (param) list.add("param")
        else if (local) list.add("local")

        list.add(type.name)

        if (base == null) list.add("<base>")

        if (array) list.add("[]")

        list.add(name)

        if (expr != null) {
            list.add("=")
            list.add(expr!!.toString())
        }

        return return list.joinToString(" ")
    }
}

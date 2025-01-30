package io.github.warraft.jass.antlr.psi

import org.antlr.v4.runtime.ParserRuleContext

class JassFun(
    val name: String,
    val native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    var base: JassFun? = null,
    override var type: IJassType = JassUndefinedType(),
    val ctx: ParserRuleContext? = null,
) : IJassNode {

    var fakename: String = ""

    val root: JassFun
        get() = base ?: this

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    val stmt: MutableList<IJassNode> = mutableListOf()

    fun clone(
        call: Boolean? = null,
        ctx: ParserRuleContext? = null,
    ): JassFun = JassFun(
        name = name,
        native = native,
        call = call ?: this.call,
        ref = ref,
        base = this,
        type = type,
        ctx = ctx,
    )

    override fun toString(): String = "JassFun(name='$name'):$type"
}

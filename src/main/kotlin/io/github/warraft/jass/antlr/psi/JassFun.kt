package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.token.JassToken
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassFun(
    var name: String? = null,
    var native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    var base: JassFun? = null,
    override var type: IJassType = JassUndefinedType(),

    var tname: JassToken? = null,
    var ttype: JassToken? = null,
) : IJassNode() {

    var fakename: String = ""

    val root: JassFun
        get() = base ?: this

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    val stmt: MutableList<IJassNode> = mutableListOf()

    fun clone(
        call: Boolean? = null,
    ): JassFun = JassFun(
        name = name,
        native = native,
        call = call ?: this.call,
        ref = ref,
        base = this,
        type = type,
    )

    override fun toString(): String = "JassFun(name='$name'):$type"
}

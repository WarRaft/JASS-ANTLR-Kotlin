package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.psi.utils.JassVarScope
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

class JassFun(
    val state: JassState,
    var name: String? = null,
    var native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    var base: JassFun? = null,
    override var type: JassTypeBase = JassUndefinedType(),
    var symbol: Token? = null,
    var definition: ParserRuleContext? = null,
) : JassNodeBase() {
    var fakename: String = ""

    val root: JassFun
        get() = base ?: this

    val links = mutableListOf<JassFun>()

    var scopeVar: JassVarScope? = null

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()
    val stmt: MutableList<JassNodeBase> = mutableListOf()

    val comments = StringBuilder()

    fun clone(
        state: JassState,
        call: Boolean? = null,
        symbol: Token? = null,
        ref: Boolean? = null,
        type: JassTypeBase? = null,
    ): JassFun = JassFun(
        state = state,
        name = name,
        native = native,
        call = call ?: this.call,
        ref = ref ?: this.ref,
        base = this,
        type = type ?: this.type,
        symbol = symbol,
    ).also {
        links.add(it)
    }

    override fun toString(): String = "JassFun(name='$name'):$type"
}

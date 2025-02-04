package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassObjBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

class JassFun(
    override val state: JassState,
    var name: String? = null,
    var native: Boolean = false,
    val call: Boolean = false,
    val ref: Boolean = false,
    override var base: JassFun? = null,
    override var type: JassTypeBase = JassUndefinedType(),
    override var symbol: Token? = null,
    override var definition: ParserRuleContext? = null,
) : JassNodeBase(), JassObjBase<JassFun> {

    var fakename: String = ""

    override val root: JassFun
        get() = base ?: this

    override val links = mutableListOf<JassFun>()

    val param: MutableList<JassVar> = mutableListOf()
    val arg: MutableList<JassExpr> = mutableListOf()

    val stmt: MutableList<JassNodeBase> = mutableListOf()

    fun clone(
        state: JassState,
        call: Boolean? = null,
        symbol: Token? = null,
    ): JassFun = JassFun(
        state = state,
        name = name,
        native = native,
        call = call ?: this.call,
        ref = ref,
        base = this,
        type = type,
        symbol = symbol,
    ).also {
        links.add(it)
    }

    override fun toString(): String = "JassFun(name='$name'):$type"
}

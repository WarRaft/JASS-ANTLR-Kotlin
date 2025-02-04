package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassNull : JassNodeBase() {
    override val type: JassTypeBase = JassNullType()

    override fun toString(): String = "$type"
}

package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassBool(val raw: String) : JassNodeBase() {
    override val type: JassTypeBase = JassBoolType()

    override fun toString(): String = "<$type>$raw"
}

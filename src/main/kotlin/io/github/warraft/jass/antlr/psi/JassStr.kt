package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassStr(val raw: String) : JassNodeBase() {
    override val type: JassTypeBase = JassStrType()

    override fun toString(): String = "<$type>$raw"
}

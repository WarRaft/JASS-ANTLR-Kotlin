package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassInt(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(INTEGER)
    }

    override fun toString(): String = "$type:$raw"
}

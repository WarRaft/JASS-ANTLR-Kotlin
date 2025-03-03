package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.JassTypeName.Companion.INTEGER
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassInt(
    override val state: JassState,
    val raw: String,
) : JassNodeBase() {
    init {
        type = JassTypeName(INTEGER)
    }

    override fun toString(): String = "$type:$raw"
}

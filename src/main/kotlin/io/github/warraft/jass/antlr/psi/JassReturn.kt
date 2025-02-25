package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.JassState

class JassReturn(
    override val state: JassState,
    val expr: JassExpr?,
) : JassNodeBase()

package io.github.warraft.language.jass.antlr.psi

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState

class JassReturn(
    override val state: JassState,
    val expr: JassExpr?,
) : JassNodeBase()

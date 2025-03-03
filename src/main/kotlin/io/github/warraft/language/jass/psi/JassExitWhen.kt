package io.github.warraft.language.jass.psi

import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState

class JassExitWhen(
    override val state: JassState,
    val expr: JassExpr,
) : JassNodeBase()

package io.github.warraft.jass.antlr.psi.base

import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.Token

interface JassObjBase<T : JassObjBase<T>> {
    val state: JassState
    val root: T
    val links: MutableList<T>
    val symbol: Token?
}

package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.token.JassTokenHolder

abstract class IJassNode {
    abstract val type: IJassType?
    val token: JassTokenHolder = JassTokenHolder()
}

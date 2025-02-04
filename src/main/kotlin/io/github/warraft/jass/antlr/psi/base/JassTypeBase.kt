package io.github.warraft.jass.antlr.psi.base

import io.github.warraft.jass.antlr.psi.JassExprOp

abstract class JassTypeBase {
    abstract val name: String
    abstract fun op(op: JassExprOp, b: JassTypeBase): JassTypeBase

    override fun toString(): String = "${Main.Companion.BLUE}$name${Main.Companion.RESET}"
}

package io.github.warraft.jass.antlr.psi

import Main.Companion.BLUE
import Main.Companion.RESET

abstract class IJassType {
    abstract val name: String
    abstract fun op(op: JassExprOp, b: IJassType): IJassType

    override fun toString(): String = "$BLUE$name$RESET"
}

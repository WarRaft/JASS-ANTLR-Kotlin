package io.github.warraft.jass.antlr.psi

interface IJassType {
    val name: String
    fun op(op: JassExprOp, b: IJassType): IJassType
}

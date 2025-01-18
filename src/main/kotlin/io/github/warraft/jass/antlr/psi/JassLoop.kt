package io.github.warraft.jass.antlr.psi

class JassLoop : IJassNode {
    override var type: IJassType = JassUndefinedType()

    val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "loop"
}

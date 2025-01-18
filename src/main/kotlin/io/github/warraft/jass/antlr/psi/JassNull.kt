package io.github.warraft.jass.antlr.psi

class JassNull : IJassNode {
    override val type: IJassType = JassNullType()

    override fun toString(): String = "$type"
}

package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.JassParser.LoopContext

class JassLoop(val ctx: LoopContext? = null) : IJassNode {
    override var type: IJassType = JassUndefinedType()

    val stmt: MutableList<IJassNode> = mutableListOf()

    override fun toString(): String = "loop"
}

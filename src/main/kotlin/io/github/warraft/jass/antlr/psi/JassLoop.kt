package io.github.warraft.jass.antlr.psi

import io.github.warraft.JassParser.LoopContext
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassLoop(val ctx: LoopContext? = null) : JassNodeBase() {
    override var type: JassTypeBase = JassUndefinedType()

    val stmt: MutableList<JassNodeBase> = mutableListOf()

    override fun toString(): String = "loop"
}

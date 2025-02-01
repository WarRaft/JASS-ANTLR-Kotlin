package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.token.JassToken
import org.antlr.v4.runtime.tree.TerminalNode

abstract class IJassNode {
    abstract val type: IJassType?

    val tkeywords: MutableList<JassToken> = mutableListOf()
    fun tkeywordsAdd(vararg nodes: TerminalNode?) {
        for (node in nodes) {
            if (node == null) continue
            tkeywords.add(JassToken(node))
        }
    }
}

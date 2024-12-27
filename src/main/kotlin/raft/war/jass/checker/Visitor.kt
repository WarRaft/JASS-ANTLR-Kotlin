package raft.war.jass.checker

import raft.war.grammar.Jass.JassBaseVisitor
import raft.war.grammar.Jass.JassParser.GlobalsContext
import raft.war.grammar.Jass.JassParser.RootContext

class Visitor : JassBaseVisitor<Visitor>() {
    override fun visitRoot(ctx: RootContext): Visitor? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    it.variable().forEach {
                        println("variable: ${it.varname().text}")
                    }
                }

                else -> {
                    //println("child: $it")
                }
            }
        }

        return visitChildren(ctx)
    }
}



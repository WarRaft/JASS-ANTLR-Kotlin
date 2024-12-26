package raft.war.jass.checker

import raft.war.grammar.Jass.JassBaseVisitor
import raft.war.grammar.Jass.JassParser.RootContext

class Visitor : JassBaseVisitor<Visitor>() {
    override fun visitRoot(ctx: RootContext): Visitor? {
        print("visitRoot: " + ctx.text + "\n")
        return visitChildren(ctx)
    }
}



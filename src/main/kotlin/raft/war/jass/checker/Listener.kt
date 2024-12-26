package raft.war.jass.checker

import raft.war.grammar.Jass.JassBaseListener
import raft.war.grammar.Jass.JassParser.RootContext

class Listener : JassBaseListener() {
    override fun enterRoot(ctx: RootContext?) {
        print("enterRoot: $ctx \n")
    }
}



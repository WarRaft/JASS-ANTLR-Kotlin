package raft.war.antlr.jass.psi

class JassExitWhen(val expr: JassExpr) : IJassNode {
    override var type: IJassType = JassUndefinedType()
}

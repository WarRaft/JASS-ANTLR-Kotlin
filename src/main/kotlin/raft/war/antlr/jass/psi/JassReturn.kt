package raft.war.antlr.jass.psi

class JassReturn(val expr: JassExpr?) : IJassNode {
    override var type: IJassType = JassUndefinedType()
}

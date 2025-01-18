package io.github.warraft.jass.antlr.psi

class JassReturn(val expr: JassExpr?) : IJassNode {
    override var type: IJassType = JassUndefinedType()
}

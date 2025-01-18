package io.github.warraft.jass.antlr.psi

class JassExitWhen(val expr: JassExpr) : IJassNode {
    override var type: IJassType = JassUndefinedType()
}

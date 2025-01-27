package io.github.warraft.jass.antlr.psi

class JassUndefinedType : IJassType() {
    override val name: String = "undefined"

    override fun op(op: JassExprOp, b: IJassType): IJassType = JassUndefinedType()
}

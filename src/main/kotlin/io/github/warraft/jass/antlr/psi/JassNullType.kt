package io.github.warraft.jass.antlr.psi

class JassNullType : IJassType {
    override val name: String = "null"
    override fun op(op: JassExprOp, b: IJassType): IJassType = JassUndefinedType()

    override fun toString(): String = "<primitive>$name"
}

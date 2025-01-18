package io.github.warraft.jass.antlr.psi

class JassBoolType : IJassType {
    override val name: String = "boolean"

    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassBoolType -> JassBoolType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }

    override fun toString(): String = "<primitive>$name"
}

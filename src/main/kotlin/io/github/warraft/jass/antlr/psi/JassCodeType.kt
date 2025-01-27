package io.github.warraft.jass.antlr.psi

class JassCodeType() : IJassType() {
    override val name: String = "code"
    override fun op(op: JassExprOp, b: IJassType): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassCodeType,
                is JassNullType,
                    -> JassCodeType()

                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}

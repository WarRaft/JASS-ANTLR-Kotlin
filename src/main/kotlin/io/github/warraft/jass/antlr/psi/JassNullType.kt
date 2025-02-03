package io.github.warraft.jass.antlr.psi

class JassNullType : IJassType() {
    override val name: String = "null"

    override fun op(op: JassExprOp, b: IJassType): IJassType = when (op) {
        JassExprOp.Eq,
        JassExprOp.Neq,
            -> when (b) {
            is JassNullType, is JassIntType, is JassRealType, is JassStrType, is JassHandleType -> JassBoolType()
            else -> JassUndefinedType()
        }

        else -> JassUndefinedType()
    }
}

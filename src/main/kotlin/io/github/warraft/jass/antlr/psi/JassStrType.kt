package io.github.warraft.jass.antlr.psi

class JassStrType : IJassType() {
    override val name: String = "string"

    override fun op(op: JassExprOp, b: IJassType): IJassType = when (op) {
        JassExprOp.Set -> when (b) {
            is JassStrType, is JassNullType -> JassStrType()
            else -> JassUndefinedType()
        }

        JassExprOp.Add -> when (b) {
            is JassIntType, is JassRealType, is JassStrType -> JassStrType()
            else -> JassUndefinedType()
        }

        JassExprOp.Eq,
        JassExprOp.Neq,
            -> when (b) {
            is JassStrType, is JassNullType -> JassBoolType()
            else -> JassUndefinedType()
        }

        else -> JassUndefinedType()
    }
}

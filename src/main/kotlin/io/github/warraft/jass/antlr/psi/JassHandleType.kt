package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassHandleType(
    override val name: String,
) : JassTypeBase() {
    var parent: JassHandleType? = null

    override fun op(
        op: JassExprOp,
        b: JassTypeBase,
    ): JassTypeBase {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassHandleType -> {
                    if (name == b.name) this
                    else JassUndefinedType()
                }

                is JassNullType -> this
                else -> JassUndefinedType()
            }

            JassExprOp.Eq, JassExprOp.Neq -> when (b) {
                is JassHandleType, is JassNullType -> JassBoolType()
                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}

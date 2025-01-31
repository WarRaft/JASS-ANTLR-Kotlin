package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.JassParser.TypeContext

class JassHandleType(
    override val name: String,
    val ctx: TypeContext? = null,
) : IJassType() {
    var parent: JassHandleType? = null

    override fun op(
        op: JassExprOp,
        b: IJassType,
    ): IJassType {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassHandleType -> {
                    if (name == b.name) this
                    else JassUndefinedType()
                }

                is JassNullType -> this

                else -> JassUndefinedType()
            }

            else -> JassUndefinedType()
        }
    }
}

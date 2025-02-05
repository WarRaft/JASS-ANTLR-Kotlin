package io.github.warraft.jass.antlr.psi

import io.github.warraft.jass.antlr.psi.base.JassTypeBase

class JassHandleType(
    override val name: String,
    val parent: JassHandleType? = null,
) : JassTypeBase() {

    val childrens = mutableListOf<JassHandleType>()

    override fun op(
        op: JassExprOp,
        b: JassTypeBase,
    ): JassTypeBase {
        return when (op) {
            JassExprOp.Set -> when (b) {
                is JassHandleType -> {
                    var p: JassHandleType? = b

                    while (p != null) {
                        if (name == p.name) return p.clone()
                        p = p.parent
                    }
                    JassUndefinedType()
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

    override fun clone(): JassHandleType = JassHandleType(
        name = name,
        parent = parent?.clone(),
    ).also {
        it.childrens.addAll(childrens)
    }
}

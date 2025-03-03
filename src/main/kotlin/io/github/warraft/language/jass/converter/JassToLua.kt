@file:Suppress("DuplicatedCode")

package io.github.warraft.language.jass.converter

import io.github.warraft.language.jass.state.JassState
import io.github.warraft.language.jass.psi.*
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.utils.JassFakeName.Companion.LuaKeywords
import java.nio.file.Path

class JassToLua(
    state: JassState,
    output: Path,
    fakename: Boolean = false,
) : JassTo(
    state = state,
    output = output,
    fakename = fakename,
) {

    override fun isKeyword(name: String): Boolean = LuaKeywords.contains(name)


    override fun typename(type: JassTypeName?, array: Boolean): String {
        val a = if (array) "[]" else ""
        return when (type) {
            //is JassBoolType -> "boolean$a"
            //is JassIntType -> "number$a integer"
            //is JassRealType -> "number$a real"
            //is JassCodeType -> "function"
            else -> type?.name ?: "missing"
        }
    }

    override fun global(v: JassVar) {
        if (v.local) builder.append("local ")
        builder.append(varname(v)).append(" = ")
        if (v.expr == null) builder.append(if (v.array) "{}" else "nil")
        else expr(v.expr!!)

        builder
            .append(" ---@type ")
            .append(typename(v.type, v.array))

        if (v.constant) builder.append(" constant")

        builder.append("\n")
    }

    override fun function(f: JassFun) {
        builder.append("\n")
        if (f.native) builder.append("--- native\n")
        f.param.forEach {
            if (it.param) {
                builder.append("---@param ")
                    .append(varname(it))
                    .append(" ")
                    .append(typename(it.type))
                    .append("\n")
            }
        }

        if (f.type == null) {
            builder.append("---@return ${typename(f.type)}\n")
        }

        builder.append("function ")
            .append(funname(f))
            .append("(")
        val list: MutableList<String> = mutableListOf()
        for (it in f.param) {
            if (!it.param) break
            list.add(varname(it))
        }

        builder.append(list.joinToString(", "))
        builder.append(")\n")

        for (it in f.param) {
            if (it.param) continue

            builder
                .append("\tlocal ")
                .append(varname(it))

            if (it.expr != null) {
                builder.append(" = ")
                expr(it.expr!!)
            }

            builder
                .append(" ---@type ")
                .append(typename(it.type))
                .append("\n")
        }

        stmt(f.stmt, 0)

        builder.append("end\n")
    }

    override fun opname(op: JassExprOp, a: JassNodeBase, b: JassNodeBase): String = when (op) {
        JassExprOp.ADD -> {
            if (a.type == b.type) ".."
            else "+"
        }

        else -> super.opname(op, a, b)
    }

    override fun expr(e: JassNodeBase?) {
        if (e == null) return
        when (e) {
            is JassNull -> builder.append("nil")
            is JassBool -> builder.append(e.raw)
            is JassInt -> {
                if (e.raw.startsWith("'")) {
                    builder
                        .append("FourCC(")
                        .append(e.raw)
                        .append(")")
                } else {
                    builder.append(e.raw)
                }
            }

            is JassReal -> builder.append(e.raw)
            is JassStr -> builder.append(e.raw)
            is JassVar -> {
                builder.append(varname(e))
                if (e.index != null) {
                    builder.append("[")
                    expr(e.index)
                    builder.append("]")
                }
            }

            is JassExpr -> when (e.op) {
                JassExprOp.GET -> expr(e.a)
                JassExprOp.SET -> {
                    println("🍒Lua: expr Set!!!")
                }

                JassExprOp.ADD, JassExprOp.SUB,
                JassExprOp.MUL, JassExprOp.DIV,
                JassExprOp.LT, JassExprOp.LTEQ, JassExprOp.GT, JassExprOp.GTEQ,
                JassExprOp.EQ, JassExprOp.NEQ,
                JassExprOp.AND, JassExprOp.OR,
                    -> if (e.a != null && e.b != null)
                    expr(e.op, e.a, e.b)

                JassExprOp.PAREN -> {
                    builder.append("(")
                    expr(e.a)
                    builder.append(")")
                }

                JassExprOp.UNSUB -> {
                    builder.append("-")
                    expr(e.a)
                }

                JassExprOp.UNNOT -> {
                    builder.append("not ")
                    expr(e.a)
                }

                else -> {}
            }

            is JassFun -> {
                builder.append(funname(e))
                if (!e.ref) {
                    builder.append("(")
                    e.arg.forEachIndexed { index, arg ->
                        if (index > 0) builder.append(", ")
                        expr(arg)
                    }
                    builder.append(")")
                }
            }

            else -> null
        }
    }

    @Suppress("DuplicatedCode")
    fun stmt(nodes: List<JassNodeBase>, level: Int) {
        for (node in nodes) {
            when (node) {
                is JassIf -> {
                    tab(level).append("if ")
                    expr(node.expr)
                    builder.append(" then\n")

                    stmt(node.stmt, level + 1)

                    for (eif in node.elseifs) {
                        tab(level).append("elseif ")
                        expr(eif.expr)
                        builder.append(" then\n")
                        stmt(eif.stmt, level + 1)
                    }

                    val elser = node.elser
                    if (elser != null) {
                        tab(level).append("else\n")
                        stmt(elser.stmt, level + 1)
                    }

                    tab(level).append("end")
                }

                is JassVar -> {
                    tab(level)
                    builder.append(varname(node))


                    if (node.index != null) {
                        builder.append("[")
                        expr(node.index)
                        builder.append("]")
                    }
                    builder.append(" = ")
                    expr(node.expr)
                }

                is JassFun -> {
                    tab(level)
                    builder.append(funname(node))
                    builder.append("(")
                    node.arg.forEachIndexed { index, arg ->
                        if (index > 0) builder.append(", ")
                        expr(arg)
                    }
                    builder.append(")")
                }

                is JassLoop -> {
                    tab(level).append("while(true) do\n")

                    stmt(node.stmt, level + 1)

                    tab(level).append("end")
                }

                is JassExitWhen -> {
                    tab(level).append("if (")
                    expr(node.expr)
                    builder.append(") then break end")
                }

                is JassReturn -> {
                    tab(level).append("return")
                    if (node.expr != null) {
                        builder.append(" ")
                        expr(node.expr)
                    }
                }

                else -> println("🔥 Lua missing node: ${node.javaClass.simpleName}")
            }


            builder.append("\n")
        }
    }
}

@file:Suppress("DuplicatedCode")

package io.github.warraft.language.jass.converter

import io.github.warraft.language.jass.state.JassState
import io.github.warraft.language.jass.psi.*
import io.github.warraft.language.jass.psi.base.JassNodeBase
import java.nio.file.Path

class JassToJass(
    state: JassState,
    output: Path,
    fakename: Boolean = false,
) : JassTo(
    state = state,
    output = output,
    fakename = fakename,
) {

    override fun typename(type: JassTypeName?, array: Boolean): String = type?.name ?: "missing"

    override fun global(v: JassVar) {
        builder.append("\t")
        if (v.constant) builder.append("constant ")
        if (v.local) builder.append("local ")
        builder.append(typename(v.type))
        if (v.array) builder.append(" array")
        builder.append(" ").append(varname(v))

        if (v.expr != null) {
            builder.append(" = ")
            expr(v.expr)
        }

        builder.append("\n")
    }

    override fun globals() {
        if (state.varScope.globals.isEmpty()) return
        builder.append("globals\n")
        state.varScope.globals.forEach(::global)
        builder.append("endglobals\n")
    }

    override fun function(f: JassFun) {
        builder.append("\n")

        if (f.native) builder.append("native")
        else builder.append("function")

        builder.append(" ").append(funname(f)).append(" takes ")

        val list: MutableList<String> = mutableListOf()
        for (it in f.param) {
            if (!it.param) break
            list.add("${typename(it.type)} ${varname(it)}")
        }

        if (list.isEmpty()) {
            builder.append("nothing")
        } else {
            builder.append(list.joinToString(", "))
        }

        builder.append(" returns ")
        if (f.type == null) {
            builder.append("nothing")
        } else {
            builder.append(typename(f.type))
        }
        builder.append("\n")

        if (f.native) return

        for (it in f.param) {
            if (it.param) continue

            builder.append("\tlocal ${typename(it.type)} ${varname(it)}")

            if (it.expr != null) {
                builder.append(" = ")
                expr(it.expr!!)
            }

            builder.append("\n")
        }

        stmt(f.stmt, 0)

        builder.append("endfunction\n")
    }

    override fun expr(e: JassNodeBase?) {
        if (e == null) return
        when (e) {
            is JassNull -> builder.append("null")
            is JassBool -> builder.append(e.raw)
            is JassInt -> builder.append(e.raw)
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
                    println("⚠️JassExprOp.Set")
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
                if (e.ref) {
                    builder.append("function ")
                }
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

                    tab(level).append("endif")
                }

                is JassVar -> {
                    tab(level).append("set ").append(varname(node))
                    if (node.index != null) {
                        builder.append("[")
                        expr(node.index)
                        builder.append("]")
                    }
                    builder.append(" = ")
                    expr(node.expr)
                }

                is JassFun -> {
                    tab(level).append("call ").append(funname(node))

                    builder.append("(")
                    node.arg.forEachIndexed { index, arg ->
                        if (index > 0) builder.append(", ")
                        expr(arg)
                    }
                    builder.append(")")
                }

                is JassLoop -> {
                    tab(level).append("loop\n")

                    stmt(node.stmt, level + 1)

                    tab(level).append("endloop")
                }

                is JassExitWhen -> {
                    tab(level).append("exitwhen ")
                    expr(node.expr)
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

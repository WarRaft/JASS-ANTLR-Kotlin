@file:Suppress("DuplicatedCode")

package raft.war.antlr.jass.converter

import raft.war.antlr.jass.JassState
import raft.war.antlr.jass.psi.*
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassJass(
    val state: JassState,
    val output: Path,
    val fakename: Boolean = false,
) {
    val builder = StringBuilder()

    fun tab(c: Int): StringBuilder {
        (0..c).forEach { builder.append("\t") }
        return builder
    }

    fun varname(v: JassVar): String {
        val root = v.root
        var name = root.name
        return if (!fakename) name else root.fakename
    }

    fun funname(f: JassFun): String {
        val root = f.root
        var name = root.name
        return if (!fakename || f.native) name else root.fakename
    }

    fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        val s = when (op) {
            JassExprOp.Mul -> "*"
            JassExprOp.Div -> "/"
            JassExprOp.Add -> "+"
            JassExprOp.Sub -> "-"

            JassExprOp.Lt -> "<"
            JassExprOp.LtEq -> "<="
            JassExprOp.Gt -> ">"
            JassExprOp.GtEq -> ">="

            JassExprOp.Eq -> "=="
            JassExprOp.Neq -> "!="

            JassExprOp.And -> "and"
            JassExprOp.Or -> "or"

            else -> {
                println("⚠️Lua: Missing $op")
                "$op"
            }
        }
        expr(a)
        builder.append(" $s ")
        expr(b)
    }

    fun expr(e: IJassNode?) {
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
                JassExprOp.Get -> expr(e.a)
                JassExprOp.Set -> {
                    println("⚠️JassExprOp.Set")
                }

                JassExprOp.Add, JassExprOp.Sub,
                JassExprOp.Mul, JassExprOp.Div,
                JassExprOp.Lt, JassExprOp.LtEq, JassExprOp.Gt, JassExprOp.GtEq,
                JassExprOp.Eq, JassExprOp.Neq,
                JassExprOp.And, JassExprOp.Or,
                    -> if (e.a != null && e.b != null)
                    expr(e.op, e.a, e.b)

                JassExprOp.Paren -> {
                    builder.append("(")
                    expr(e.a)
                    builder.append(")")
                }

                JassExprOp.UnSub -> {
                    builder.append("-")
                    expr(e.a)
                }

                JassExprOp.UnNot -> {
                    builder.append("not ")
                    expr(e.a)
                }

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

    fun global(v: JassVar) {
        builder.append("\t")
        if (v.constant) builder.append("constant ")
        if (v.local) builder.append("local ")
        builder.append(v.type.name)
        if (v.array) builder.append(" array")
        builder.append(" ").append(varname(v))

        if (v.expr != null) {
            builder.append(" = ")
            expr(v.expr)
        }

        builder.append("\n")
    }

    fun stmt(nodes: List<IJassNode>, level: Int) {
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
                    if (!node.call) continue
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

    fun function(f: JassFun) {
        builder.append("\n")

        if (f.native) builder.append("native")
        else builder.append("function")

        builder.append(" ").append(funname(f)).append(" takes ")

        val list: MutableList<String> = mutableListOf()
        for (it in f.param) {
            if (!it.param) break
            list.add("${it.type.name} ${varname(it)}")
        }

        if (list.isEmpty()) {
            builder.append("nothing")
        } else {
            builder.append(list.joinToString(", "))
        }

        builder.append(" returns ")
        if (f.type is JassUndefinedType) {
            builder.append("nothing")
        } else {
            builder.append(f.type.name)
        }
        builder.append("\n")

        if (f.native) return

        for (it in f.param) {
            if (it.param) continue

            builder.append("\tlocal ${it.type.name} ${varname(it)}")

            if (it.expr != null) {
                builder.append(" = ")
                expr(it.expr!!)
            }

            builder.append("\n")
        }

        stmt(f.stmt, 0)

        builder.append("endfunction\n")
    }

    fun type(t: JassHandleType) {
        builder.append("---@class ${t.name}")

        if (t.parent != null) builder
            .append(":")
            .append(t.parent!!.name)
        builder.append("\n")
    }

    fun convert() {
        builder.clear()

        state.types.forEach(::type)

        state.natives.forEach(::function)

        builder.append("\n")

        if (state.globals.isNotEmpty()) {
            builder.append("globals\n")
            state.globals.forEach(::global)
            builder.append("endglobals\n")
        }

        state.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }

    init {
        convert()
    }
}

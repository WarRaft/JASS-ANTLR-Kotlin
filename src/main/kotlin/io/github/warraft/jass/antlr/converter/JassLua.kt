package io.github.warraft.jass.antlr.converter

import io.github.warraft.jass.antlr.JassFakeName
import io.github.warraft.jass.antlr.psi.IJassNode
import io.github.warraft.jass.antlr.psi.IJassType
import io.github.warraft.jass.antlr.psi.JassExpr
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassIf
import io.github.warraft.jass.antlr.psi.JassInt
import io.github.warraft.jass.antlr.psi.JassLoop
import io.github.warraft.jass.antlr.psi.JassReal
import io.github.warraft.jass.antlr.psi.JassRealType
import io.github.warraft.jass.antlr.psi.JassStr
import io.github.warraft.jass.antlr.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

class JassLua(
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
        return if (fakename || JassFakeName.Companion.LuaKeywords.contains(name)) root.fakename else name
    }

    fun funname(f: JassFun): String {
        val root = f.root
        var name = root.name
        return if ((fakename || JassFakeName.Companion.LuaKeywords.contains(name)) && !f.native) root.fakename else name
    }

    fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        val s = when (op) {
            JassExprOp.Mul -> "*"
            JassExprOp.Div -> "/"
            JassExprOp.Add -> {
                if (a.type is JassStrType || b.type is JassStrType) ".."
                else "+"
            }

            JassExprOp.Sub -> "-"
            JassExprOp.Lt -> "<"
            JassExprOp.LtEq -> "<="
            JassExprOp.Gt -> ">"
            JassExprOp.GtEq -> ">="

            JassExprOp.Eq -> "=="
            JassExprOp.Neq -> "~="

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
                JassExprOp.Get -> expr(e.a)
                JassExprOp.Set -> {
                    println("🍒Lua: expr Set!!!")
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

    fun typeName(type: IJassType, array: Boolean = false): String {
        val a = if (array) "[]" else ""
        return when (type) {
            is JassBoolType -> "boolean$a"
            is JassIntType -> "number$a integer"
            is JassRealType -> "number$a real"
            is JassCodeType -> "function"
            else -> type.name
        }
    }

    fun global(v: JassVar) {
        if (v.local) builder.append("local ")
        builder.append(varname(v)).append(" = ")
        if (v.expr == null) builder.append(if (v.array) "{}" else "nil")
        else expr(v.expr!!)

        builder
            .append(" ---@type ")
            .append(typeName(v.type, v.array))

        if (v.constant) builder.append(" constant")

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
                    if (!node.call) continue
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

    fun function(f: JassFun) {
        builder.append("\n")
        if (f.native) builder.append("--- native\n")
        f.param.forEach {
            if (it.param) {
                builder.append("---@param ")
                    .append(varname(it))
                    .append(" ")
                    .append(typeName(it.type))
                    .append("\n")
            }
        }

        if (f.type !is JassUndefinedType) {
            builder.append("---@return ${typeName(f.type)}\n")
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
                .append(typeName(it.type))
                .append("\n")
        }

        stmt(f.stmt, 0)

        builder.append("end\n")
    }

    fun type(t: JassHandleType) {
        builder.append("---@class ${t.name}")

        if (t.parent != null) builder
            .append(":")
            .append(t.parent!!.name)
        builder.append("\n")
    }

    private fun convert() {
        JassFakeName(state = state)

        builder.clear()

        state.types.forEach(::type)

        state.natives.forEach(::function)

        builder.append("\n")

        state.globals.forEach(::global)

        builder.append("\n")

        state.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }

    init {
        convert()
    }
}

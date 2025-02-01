@file:Suppress("DuplicatedCode")

package io.github.warraft.jass.converter

import io.github.warraft.jass.antlr.JassFakeName.Companion.AsKeywords
import io.github.warraft.jass.antlr.JassState
import io.github.warraft.jass.antlr.psi.*
import java.nio.file.Path

class JassAs(
    state: JassState,
    output: Path,
    fakename: Boolean = false,
) : JassBase(
    state = state,
    output = output,
    fakename = fakename,
) {

    override fun isKeyword(name: String): Boolean = AsKeywords.contains(name)

    override fun type(t: JassHandleType) {
        builder.append("// type ${t.name}")

        if (t.parent != null) builder
            .append(" extends ")
            .append(t.parent!!.name)
        builder.append("\n")
    }

    override fun typename(type: IJassType, array: Boolean): String {
        var s = if (array) "array<" else ""
        s += when (type) {
            is JassBoolType -> "bool"
            is JassIntType -> "int"
            is JassRealType -> "float"
            is JassCodeType -> "CallbackFunc"
            else -> type.name
        }
        return if (array) "$s>" else s
    }

    override fun global(v: JassVar) {
        if (v.constant) builder.append("const ")
        builder.append(typename(v.type, v.array))

        builder
            .append(" ")
            .append(varname(v))

        if (v.expr != null) {
            builder.append(" = ")
            expr(v.expr!!)
        }

        builder.append(";\n")
    }

    override fun function(f: JassFun) {
        if (f.native) builder.append("funcdef ")

        if (f.type is JassUndefinedType) {
            builder.append("void")
        } else {
            builder.append(typename(f.type))
        }
        builder
            .append(" ")
            .append(funname(f))
            .append("(")

        val list: MutableList<String> = mutableListOf()
        for (it in f.param) {
            if (!it.param) break
            list.add("${typename(it.type)} ${varname(it)}")
        }

        builder.append(list.joinToString(", "))
        builder.append(")")

        if (f.native) {
            builder.append(";\n")
            return
        }

        builder.append(" {\n")

        for (it in f.param) {
            if (it.param) continue

            builder
                .append("\t")
                .append(typename(it.type, it.array))
                .append(" ")
                .append(varname(it))

            if (it.expr != null) {
                builder.append(" = ")
                expr(it.expr!!)
            }

            builder.append(";\n")
        }

        stmt(f.stmt, 0)

        builder.append("}\n")
    }

    override fun opname(op: JassExprOp, a: IJassNode, b: IJassNode): String = when (op) {
        JassExprOp.And -> "&&"
        JassExprOp.Or -> "||"

        else -> super.opname(op, a, b)
    }

    override fun expr(op: JassExprOp, a: IJassNode, b: IJassNode) {
        var aa: IJassNode = a
        var bb: IJassNode = b
        when (op) {
            JassExprOp.Eq,
            JassExprOp.Neq,
                -> {
                if (aa.type is JassStrType && bb.type is JassNullType) bb = JassStr("\"\"")
                if (bb.type is JassStrType && aa.type is JassNullType) aa = JassStr("\"\"")
            }

            else -> null
        }
        super.expr(op, aa, bb)
    }

    override fun expr(e: IJassNode?) {
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
                    println("🍒AS: expr Set!!!")
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
                    builder.append("!")
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

    @Suppress("DuplicatedCode")
    fun stmt(nodes: List<IJassNode>, level: Int) {
        for (node in nodes) {
            when (node) {
                is JassIf -> {
                    tab(level).append("if (")
                    expr(node.expr)
                    builder.append(") {\n")

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

                    tab(level).append("}")
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
                    builder.append(";")
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
                    builder.append(");")
                }

                is JassLoop -> {
                    tab(level).append("while (true) {\n")

                    stmt(node.stmt, level + 1)

                    tab(level).append("}")
                }

                is JassExitWhen -> {
                    tab(level).append("if (")
                    expr(node.expr)
                    builder.append(") break;")
                }

                is JassReturn -> {
                    tab(level).append("return")
                    if (node.expr != null) {
                        builder.append(" ")
                        expr(node.expr)
                        builder.append(";")
                    }
                }

                else -> println("🔥 Lua missing node: ${node.javaClass.simpleName}")
            }


            builder.append("\n")
        }
    }
}

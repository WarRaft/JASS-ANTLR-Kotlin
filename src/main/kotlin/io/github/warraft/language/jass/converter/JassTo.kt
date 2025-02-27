package io.github.warraft.language.jass.converter

import io.github.warraft.language.jass.antlr.utils.JassFakeName
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.psi.JassExprOp
import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.psi.JassType
import io.github.warraft.language.jass.antlr.psi.JassTypeName
import io.github.warraft.language.jass.antlr.psi.JassVar
import java.io.File
import java.nio.file.Path
import kotlin.io.path.absolute

abstract class JassTo(
    val state: JassState,
    val output: Path,
    val fakename: Boolean = false,
) {
    val builder = StringBuilder()

    fun tab(c: Int): StringBuilder {
        (0..c).forEach { builder.append("\t") }
        return builder
    }

    open fun isKeyword(s: String): Boolean = false

    fun typename(type: JassType?, array: Boolean = false) = "anal"
    open fun typename(type: JassTypeName?, array: Boolean = false) = "anal"

    fun varname(v: JassVar): String {
        //val root = v.root
        //var name = root.name
        //return if (fakename || isKeyword(name)) root.fakename else name
        return v.name ?: "missing"
    }

    fun funname(f: JassFun): String {
        //val root = f.root
        //var name = root.name ?: ""
        //return if ((fakename || isKeyword(name)) && !f.native) root.fakename else name
        return f.name ?: "missing"
    }

    abstract fun function(f: JassFun)

    abstract fun global(v: JassVar)

    open fun globals() {
        //state.globals.forEach(::global)
    }

    open fun opname(op: JassExprOp, a: JassNodeBase, b: JassNodeBase): String = when (op) {
        JassExprOp.MUL -> "*"
        JassExprOp.DIV -> "/"
        JassExprOp.ADD -> "+"
        JassExprOp.SUB -> "-"

        JassExprOp.LT -> "<"
        JassExprOp.LTEQ -> "<="
        JassExprOp.GT -> ">"
        JassExprOp.GTEQ -> ">="

        JassExprOp.EQ -> "=="
        JassExprOp.NEQ -> "!="

        JassExprOp.AND -> "and"
        JassExprOp.OR -> "or"

        JassExprOp.UNSUB -> "-"
        JassExprOp.UNNOT -> "not "
        JassExprOp.GET,
        JassExprOp.SET,
        JassExprOp.PAREN,
            -> {
            println("⚠️Unexpected operator: $op")
            ""
        }
    }

    abstract fun expr(e: JassNodeBase?)

    open fun expr(op: JassExprOp, a: JassNodeBase, b: JassNodeBase) {
        expr(a)
        builder
            .append(" ")
            .append(opname(op, a, b))
            .append(" ")
        expr(b)
    }

    fun convert() {
        JassFakeName(state = state)

        builder.clear()

        //state.types.forEach(::type)
        builder.append("\n")
        state.funScope.natives.forEach(::function)
        builder.append("\n")
        globals()
        builder.append("\n")
        state.funScope.functions.forEach(::function)

        File(output.absolute().toString()).writeText(builder.toString().trim())
    }

    init {
        convert()
    }
}

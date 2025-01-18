@file:Suppress("DuplicatedCode")

import io.github.warraft.jass.antlr.JassState
import org.antlr.v4.runtime.CharStreams
import io.github.warraft.jass.antlr.converter.JassLua
import java.nio.file.Path
import java.nio.file.Paths

fun jassLuaProcess(args: Array<String>) {
    if (args.isEmpty()) {
        println("⚠️ No file provided")
    }

    val states: MutableList<JassState> = mutableListOf()
    var path: Path? = null

    args.forEachIndexed { index, arg ->
        println("read $arg")

        val s = JassState()
        path = Paths.get(arg)

        println("parse $arg")
        val stream = CharStreams.fromPath(path)

        s.parse(stream, states)
        states.add(s)

        s.errors.forEach { println("⚠️JASS error: $it") }
    }

    if (states.isEmpty()) {
        println("⚠️ No state provided")
        return
    }

    if (path == null) {
        println("⚠️ No path provided")
        return
    }

    val lp = path.resolveSibling(path.fileName.toString().replaceAfterLast('.', "lua"))
    println("convert to $lp")
    JassLua(states.last(), lp)
}

fun main(args: Array<String>) = jassLuaProcess(args)

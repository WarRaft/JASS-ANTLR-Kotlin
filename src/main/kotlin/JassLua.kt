import org.antlr.v4.runtime.CharStreams
import raft.war.antlr.jass.JassState
import raft.war.antlr.lua.JassLua
import java.nio.file.Paths
import kotlin.io.path.absolute

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("⚠️ No file provided")
    }

    val states: MutableList<JassState> = mutableListOf()

    args.forEachIndexed { index, arg ->
        println("read $arg")

        val s = JassState()
        val p = Paths.get(arg)

        println("parse $arg")
        val stream = CharStreams.fromPath(p)

        s.parse(stream, states)
        states.add(s)

        s.errors.forEach { println("⚠️JASS error: $it") }

        val lp = p.resolveSibling(p.fileName.toString().replaceAfterLast('.', "lua"))
        println("convert to $lp")
        JassLua(s, lp).convert()
    }
}

package raft.war.antlr.jass.converter

import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import raft.war.antlr.jass.JassFakeName
import raft.war.antlr.jass.JassState
import raft.war.antlr.jass.psi.JassFun
import java.nio.file.Path
import java.nio.file.Paths

class JassJassTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    fun fromPath(path: Path, states: List<JassState> = listOf()): JassState {
        val state = JassState()
        state.parse(CharStreams.fromPath(path), states)

        state.errors.forEach { println("⚠️ cj: $it") }

        assert(state.errors.isEmpty())

        return state
    }

    @Test
    fun test() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))

        val wjp = Paths.get("src", "test", "resources", "jass", "test.j")
        val wj = fromPath(wjp, listOf(cj, bj))

        JassJass(
            state = wj,
            output = j2l(wjp),
            fakename = true
        )
    }

    @Test
    fun lg() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))
        fromPath(Paths.get("src", "test", "resources", "map", "LastGuard.j"), listOf(cj, bj))
    }

    companion object {
        fun j2l(path: Path): Path = path.resolveSibling(path.fileName.toString().replaceAfterLast('.', "opt.j"))
    }
}

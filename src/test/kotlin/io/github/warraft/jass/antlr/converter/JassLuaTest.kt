package io.github.warraft.jass.antlr.converter

import io.github.warraft.jass.antlr.JassState
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import java.nio.file.Path
import java.nio.file.Paths

class JassLuaTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    fun fromPath(path: Path, states: List<JassState> = listOf()): JassState {
        val state = JassState()
        state.parse(CharStreams.fromPath(path), states)

        state.errors.forEach { println("⚠️ cj: $it") }

        assert(state.errors.isEmpty())

        JassLua(state, j2l(path))

        return state
    }

    @Test
    fun concatenation() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))
        fromPath(Paths.get("src", "test", "resources", "lua", "concatenation.j"), listOf(cj, bj))
    }

    @Test
    fun keyword() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))
        fromPath(Paths.get("src", "test", "resources", "lua", "keyword.j"), listOf(cj, bj))
    }

    @Test
    fun ltd() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))
        fromPath(Paths.get("src", "test", "resources", "map", "LTD.j"), listOf(cj, bj))
    }

    @Test
    fun lg() {
        val cj = fromPath(cjp)
        val bj = fromPath(bjp, listOf(cj))
        fromPath(Paths.get("src", "test", "resources", "map", "LastGuard.j"), listOf(cj, bj))
    }

    companion object {
        fun j2l(path: Path): Path = path.resolveSibling(path.fileName.toString().replaceAfterLast('.', "lua"))
    }
}

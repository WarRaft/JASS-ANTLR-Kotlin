package io.github.warraft.language.jass.converter

import io.github.warraft.language.jass.state.JassState
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Paths
import kotlin.test.Test

class JassToAsTest {
    val cjs = JassState()
    val bjs = JassState()

    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    @Test
    fun a1() {
        cjs.parse(CharStreams.fromPath(cjp), mutableListOf(), 0)
        bjs.parse(CharStreams.fromPath(bjp), mutableListOf(cjs), 0)


    }
}

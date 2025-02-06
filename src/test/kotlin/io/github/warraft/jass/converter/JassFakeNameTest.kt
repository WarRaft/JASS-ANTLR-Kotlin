package io.github.warraft.jass.converter

import io.github.warraft.jass.antlr.utils.JassFakeName
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test

class JassFakeNameTest {
    @Test
    fun next() {
        val a = JassState()
        a.parse(
            CharStreams.fromString(
                """
                globals
                    int a = 1
                endglobals
                """.trimIndent()
            )
        )

        val b = JassState()
        b.parse(
            CharStreams.fromString(
                """
                function b takes nothing returns nothing
                endfunction
                """.trimIndent()
            )
        )

        val c = JassState()
        c.states.clear()
        c.states.add(a)
        c.states.add(b)

        val fakeName = JassFakeName(c)

        val regex = "^[a-zA-Z][a-zA-Z0-9]*$".toRegex()
        val isset = mutableSetOf<String>("a", "b")

        repeat(10000) {
            val s = fakeName.next()
            assert(s.matches(regex)) { "->$s<- not match" }
            assert(!isset.contains(s)) { "->$s<- duplicate" }
            isset.add(s)
        }
    }
}

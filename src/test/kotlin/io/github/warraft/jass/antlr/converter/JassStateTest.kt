package io.github.warraft.jass.antlr.converter

import io.github.warraft.jass.antlr.JassState
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test

class JassStateTest {

    @Test
    fun parseParam() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                type location extends handle
                native GetLocationX takes real x returns real
                native GetLocationY takes real y returns real
                native SquareRoot takes real y returns real
               
                function DistanceBetweenPoints takes location locA, location locB, real dy returns real
                    local real dx = 2
                    local real dx = GetLocationX(locB) - GetLocationX(locA)
                    local real dy = GetLocationY(locB) - GetLocationY(locA)
                    return SquareRoot(dx * dx + dy * dy)
                endfunction
                """.trimIndent()
            )
        )

        state.errors.forEach { println("⚠️ $it") }

        for (f in state.functions) {
            println("=== ${f.name}")
            for (p in f.param) {
                println(p)
            }
        }

        assert(state.errors.isEmpty())
    }
}

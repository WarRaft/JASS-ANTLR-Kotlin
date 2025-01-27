package io.github.warraft.jass.antlr.converter

import io.github.warraft.jass.antlr.JassState
import io.github.warraft.jass.antlr.error.JassErrorId
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test

class JassStateTest {

    @Test
    fun memhack() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                globals
                    integer array l__Array
                endglobals
                
                function TypecastArray takes nothing returns nothing
                    local integer l__Array
                endfunction
                function GetArrayAddress takes nothing returns integer
                    loop
                        return l__Array
                    endloop
                    return 0
                endfunction
                
                function InitArray takes integer vtable returns nothing
                    set l__Array[4] = 0
                    set l__Array[1] = vtable
                    set l__Array[2] = -1
                    set l__Array[3] = -1
                endfunction
                """.trimIndent()
            )
        )

        state.errors.forEach { println("⚠️ $it") }
        assert(state.errors.count() == 1)
        assert(state.errors[0].id == JassErrorId.RETURN_ARRAY)
    }

    @Test
    fun typeTest() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                globals
                    boolean a = "a" != null
                    boolean b = null == "b"   
                endglobals
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

package io.github.warraft.jass.converter

import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.FullDocumentDiagnosticReport
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.lsp.serializer.IntOrString
import kotlinx.serialization.json.Json
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test

class JassStateTest {

    @Test
    fun test1() {
        val s = Json.encodeToString(
            Message(
                id = IntOrString.Ival(1),
                result = Json.encodeToJsonElement(
                    FullDocumentDiagnosticReport.serializer(), FullDocumentDiagnosticReport(
                        items = emptyList(),
                    )
                )
            )
        )
        println(s)
    }


    @Test
    fun funcomment() {
        JassState().apply {
            parse(
                CharStreams.fromString(
                    """
                // 1
                
                //2 
                // 3
                function main takes nothing returns nothing
                endfunction
                """.trimIndent()
                ),
                emptyList(),
                null,
            )
        }
    }

    @Test
    fun test() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                type unit extends handle
                    
                globals
                    unit asuna
                endglobals
                function main takes nothing returns nothing
                    set asuna = 2
                endfunction
                
                """.trimIndent()
            ),
            emptyList(),
            null,
        )
        println("🔥")


        //assert(state.errors.size == 1)
    }

    @Test
    fun missingToken() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                function Anal takes nothing returns anal
                    call
                endfunction
                """.trimIndent()
            ),
            emptyList(),
            null,
        )

        print(SemanticTokenType.entries.map { it ->
            it.name.split("_")
                .mapIndexed { index, s ->
                    if (index == 0) s.lowercase() else s.lowercase().replaceFirstChar { it.uppercaseChar() }
                }
                .joinToString("")
        }.forEach { println(it) })
        //assert(state.errors.size == 1)
    }

    @Test
    fun nullCheck() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                function Anal takes nothing returns nothing
                    local
                    set anal = 2
                endfunction
                """.trimIndent()
            ),
            emptyList(),
            null,
        )
    }


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
            ),
            emptyList(),
            null,
        )

        /*
        state.errors.forEach { println("⚠️ $it") }
        assert(state.errors.count() == 1)
        assert(state.errors[0].id == JassErrorId.RETURN_ARRAY)

         */
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
            ),
            emptyList(),
            null,
        )

        //state.errors.forEach { println("⚠️ $it") }


        //assert(state.errors.isEmpty())
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
            ),
            emptyList(),
            null,
        )

        //state.errors.forEach { println("⚠️ $it") }


        //assert(state.errors.isEmpty())
    }
}

import io.github.warraft.jass.antlr.JassState
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Type {

    fun state(str: String): JassState {
        val s = JassState()
        s.parse(CharStreams.fromString(str))
        return s
    }

    val math = listOf<String>("+", "-", "*", "/")
    val bool = listOf<String>(">", ">=", "<", "<=", "==", "!=")

    @Test
    fun positive() {
        val state = JassState()
        for (gen in listOf(
            Gen(math, "integer", "1", "2"),
            Gen(math, "real", "1", "2."),
            Gen(listOf("+"), "string", "\"a\"", "\"b\""),

            Gen(bool, "boolean", "1", "2"),
            Gen(bool, "boolean", "1", "2."),
        )) {
            state.parse(CharStreams.fromString(gen.code))
            for (g in state.globals) {
                assertEquals(g.type::class, g.expr!!.type::class, g.toString())
            }
            assert(state.diagnosticHub.diagnostics.isEmpty()) {
                state.diagnosticHub.diagnostics.forEach { println(it) }
            }
        }
    }

    @Test
    fun negative() {
        val state = JassState()
        for (gen in listOf(
            Gen(math, "integer", "1", "\"a\""),
        )) {
            state.parse(CharStreams.fromString(gen.code))
            for (g in state.globals) {
                assert(g.expr?.type is JassUndefinedType) { println(g.toString()) }
            }

            val d = state.diagnosticHub.diagnostics
            assert(d.size == state.globals.size * 2) {
                println("🔥${gen.code}")
                d.forEach { println(it.message) }
            }
        }
    }


    companion object {
        private class Gen(list: List<String>, type: String, a: String, b: String) {
            var code = "globals\n"

            init {
                for ((i, op) in list.withIndex()) {
                    code += "$type a$i = $a $op $b\n"
                }
                code += "endglobals"
            }
        }
    }
}

import io.github.warraft.jass.antlr.psi.JassBoolType
import io.github.warraft.jass.antlr.psi.JassExprOp.*
import io.github.warraft.jass.antlr.psi.JassIntType
import io.github.warraft.jass.antlr.psi.JassRealType
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.antlr.typeGet
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class Type {

    fun state(str: String): JassState {
        val s = JassState()
        s.parse(CharStreams.fromString(str))
        return s
    }

    @Test
    fun primitive() {
        val integer = JassIntType()
        val real = JassRealType()

        val m = listOf(Add, Sub, Mul, Div)
        val b = listOf(Lt, LtEq, Gt, GtEq, Eq, Neq)

        for (op in m) assertIs<JassIntType>(integer.op(op, integer))
        for (op in b) assertIs<JassBoolType>(integer.op(op, integer))


        for (op in m) assertIs<JassRealType>(integer.op(op, real))
        for (op in m) assertIs<JassRealType>(real.op(op, real))


    }

    @Test
    fun handle() {
        val state = JassState()
        state.parse(
            CharStreams.fromString(
                """
                type a extends handle
                type b extends a
                type c extends b
                type d extends handle
            """.trimIndent()
            )
        )
        val a = state.typeGet("a")
        assertNotNull(a)
        val b = state.typeGet("b")
        assertNotNull(b)
        val c = state.typeGet("c")
        assertNotNull(c)
        val d = state.typeGet("d")
        assertNotNull(d)

        assertEquals(a.op(Set, c).name, "a")
        assertIs<JassUndefinedType>(a.op(Set, d))
    }

}

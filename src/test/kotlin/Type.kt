import io.github.warraft.language.jass.antlr.psi.JassExprOp.*
import io.github.warraft.language.jass.antlr.state.JassState
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class Type {

    fun state(str: String): JassState = JassState().apply {
        parse(CharStreams.fromString(str), emptyList(), null)
    }

    @Test
    fun test() {
        val state = state(
            """
                type a extends handle
                type b extends a
                type c extends b
                type d extends handle
                type e extends u
            """.trimIndent()
        )

        for (d in state.diagnosticHub.diagnostics) {
            println(d.message)
        }
    }

    @Test
    fun primitive() {
        //val integer = JassIntType()
        //val real = JassRealType()

        //val m = listOf(ADD, SUB, MUL, DIV)
        //val b = listOf(LT, LTEQ, GT, GTEQ, EQ, NEQ)

        //for (op in m) assertIs<JassIntType>(integer.op(op, integer))
        //for (op in b) assertIs<JassBoolType>(integer.op(op, integer))

        //for (op in m) assertIs<JassRealType>(integer.op(op, real))
        //for (op in m) assertIs<JassRealType>(real.op(op, real))
    }

    @Test
    fun handle() {
        val state = state(
            """
                type a extends handle
                type b extends a
                type c extends b
                type d extends handle
            """.trimIndent()
        )
        /*
        val a = state.typeGet()
        assertNotNull(a)
        val b = state.typeGet()
        assertNotNull(b)
        val c = state.typeGet()
        assertNotNull(c)
        val d = state.typeGet()
        assertNotNull(d)

        assertEquals(a.op(SET, c).name, "a")
        assertIs<JassUndefinedType>(a.op(SET, d))

         */
    }

}

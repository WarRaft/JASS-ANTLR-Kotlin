import io.github.warraft.language.jass.psi.JassExprOp.SET
import io.github.warraft.language.jass.state.JassState
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class Type {

    fun state(str: String): JassState = JassState().apply {
        parse(CharStreams.fromString(str), emptyList(), null)
    }

    @Test
    fun test() {
        val state = state(
            """
                globals
	integer a = 2
	anal b = 3
	integer c = a
endglobals
            """.trimIndent()
        )

        for (d in state.diagnostic) {
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

        val a = state.typeScope.definition("a")
        assertNotNull(a)
        val b = state.typeScope.definition("b")
        assertNotNull(b)
        val c = state.typeScope.definition("c")
        assertNotNull(c)
        val d = state.typeScope.definition("d")
        assertNotNull(d)

        a.typeCheck(SET, c)
        assert(state.diagnostic.isEmpty())

    }

}

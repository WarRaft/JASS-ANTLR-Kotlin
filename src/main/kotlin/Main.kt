import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import raft.war.grammar.Jass.JassLexer
import raft.war.grammar.Jass.JassParser
import raft.war.jass.checker.error.Listener
import raft.war.jass.checker.Visitor

fun main() {
    val cs = CharStreams.fromFileName("/Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/test/resources/test.j")

    val errors = Listener()

    // lexer
    val lexer = JassLexer(cs)
    lexer.removeErrorListeners()
    lexer.addErrorListener(errors)

    // tokens
    val tokens = CommonTokenStream(lexer)

    // parser
    val parser = JassParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(errors)
    parser.root().accept(Visitor())

    if (errors.errors.isNotEmpty()) {
        errors.errors.forEach { print("$it \n") }
    }
}

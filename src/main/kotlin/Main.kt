import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import raft.war.grammar.Jass.JassLexer
import raft.war.grammar.Jass.JassParser
import raft.war.jass.checker.ErrorListener
import raft.war.jass.checker.Listener
import raft.war.jass.checker.Visitor

fun main() {
    val cs = CharStreams.fromFileName("/Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin/src/test/resources/test.j")


    val errors = ErrorListener()

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

    val tree = parser.root()

    // listener
    print("💋 Listen:\n")
    ParseTreeWalker().walk(Listener(), tree)

    // visitor
    print("💋 Visit\n")
    val visitor = Visitor()

    tree.accept(visitor)

    if (errors.errors.isNotEmpty()) {
        errors.errors.forEach { print("$it \n") }
    }
}

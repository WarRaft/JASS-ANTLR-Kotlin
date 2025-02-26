import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.converter.JassToAs
import io.github.warraft.jass.converter.JassToJass
import io.github.warraft.jass.converter.JassToLua
import io.github.warraft.lsp.LanguageServer
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.isReadable

class Main(val args: Array<String>) {

    private var action: String? = null

    private val states: MutableList<JassState> = mutableListOf()

    private var path: Path? = null

    private fun process() {
        println("$BOLD${CYAN}JASS ANTLR$RESET")
        val err = "${RED}Error!$RESET"
        val warn = "${YELLOW}Warning!$RESET"

        val files = mutableListOf<String>()

        for (arg in args) {
            when (arg) {
                "-$JASS2JASS" -> action = JASS2JASS
                "-$JASS2LUA" -> action = JASS2LUA
                "-$JASS2AS" -> action = JASS2AS
                else -> {
                    if (arg.startsWith("-")) {
                        println("$warn Unknown argument: $arg")
                    } else {
                        files.add(arg)
                    }
                }
            }
        }

        if (action == null) {
            println("$err No action provided.")
            return
        } else {
            when (action) {
                JASS2JASS -> println("Using $ITALIC${CYAN}JASS to JASS converter$RESET")
                JASS2LUA -> println("Using $ITALIC${CYAN}JASS to Lua converter$RESET")
                JASS2AS -> println("Using $ITALIC${CYAN}JASS to AngelScript converter$RESET")
            }
        }

        if (files.isEmpty()) {
            println("$err No files provided.")
            return
        }

        for (file in files) {
            println("Processing$PURPLE $file$RESET")
            path = Paths.get(file)
            println("Absolute path: $PURPLE ${path!!.toAbsolutePath()}$RESET")

            if (!path!!.isReadable()) {
                println("$err File not readable.")
                return
            }

            val stream = CharStreams.fromPath(path)
            val s = JassState()
            s.parse(stream, states, null)
            states.add(s)

            if (s.diagnosticHub.diagnostics.isEmpty()) {
                println("Checking: ${GREEN}No errors$RESET")
            } else {
                println("Checking: $RED${s.diagnosticHub.diagnostics.count()} error$RESET")
            }

            for (e in s.diagnosticHub.diagnostics) {
                println("⚠️$e")
            }
        }

        if (path == null) {
            println("$err No path avaiable.")
            return
        }

        when (action) {
            JASS2JASS -> {
                val p = ext(path!!, "opt.j")
                println("Output: $PURPLE${p.toAbsolutePath()}$RESET")
                JassToJass(
                    state = states.last(),
                    output = p,
                    fakename = false
                )
            }

            JASS2LUA -> {
                val p = ext(path!!, "lua")
                println("Output: $PURPLE${p.toAbsolutePath()}$RESET")
                JassToLua(
                    state = states.last(),
                    output = p,
                    fakename = false
                )
            }

            JASS2AS -> {
                val p = ext(path!!, "as")
                println("Output: $PURPLE${p.toAbsolutePath()}$RESET")
                JassToAs(
                    state = states.last(),
                    output = p,
                    fakename = false
                )
            }
        }
    }

    init {
        process()
    }

    companion object {
        // "opt.j"
        private fun ext(p: Path, e: String): Path = p.resolveSibling(p.fileName.toString().replaceAfterLast('.', e))


        private const val JASS2JASS = "jass2jass"
        private const val JASS2LUA = "jass2lua"
        private const val JASS2AS = "jass2as"

        const val RESET = "\u001B[0m"

        private const val RED = "\u001b[31m"
        private const val GREEN = "\u001b[32m"
        private const val YELLOW = "\u001b[33m"
        const val BLUE = "\u001b[34m"
        private const val PURPLE = "\u001b[35m"
        private const val CYAN = "\u001b[36m"
        //private const val WHITE = "\u001b[37m"

        private const val BOLD = "\u001b[1m"
        //private const val BOLDOFF = "\u001b[22m"

        private const val ITALIC = "\u001b[3m"
        //private const val ITALICOFF = "\u001b[23m"
    }
}

fun main(args: Array<String>) {
    when (args.firstOrNull()) {
        "-lsp" -> LanguageServer()
        "-ping" -> print("pong")
        else -> Main(args)
    }
}

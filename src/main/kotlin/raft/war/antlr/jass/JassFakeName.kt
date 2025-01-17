package raft.war.antlr.jass

class JassFakeName(val state: JassState) {

    private val generated = mutableSetOf<String>()

    private var index = 0

    private fun valid(name: String): Boolean {
        if (name in AllKeywords) return false
        if (name in generated) return false
        return state.getNode(name, null) == null
    }

    fun next(): String {
        while (true) {
            val result = StringBuilder()
            var number = index

            result.append(FIRST_CHARS[number % FIRST_BASE])
            number /= FIRST_BASE

            while (number > 0) {
                result.append(OTHER_CHARS[number % OTHER_BASE])
                number /= OTHER_BASE
            }

            val name = result.toString()
            if (valid(name)) {
                generated.add(name)
                index++
                return name
            }

            index++
        }
    }

    fun generate() {
        for (g in state.globals) {
            g.fakename = next()
        }

        for (f in state.natives) {
            for (p in f.param.asReversed()) {
                p.fakename = next()
            }
        }

        for (f in state.functions) {
            f.fakename = next()
            for (p in f.param.asReversed()) {
                p.fakename = next()
            }
        }
    }

    init {
        generate()
    }

    companion object {
        private const val FIRST_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        private const val OTHER_CHARS = FIRST_CHARS + "0123456789"

        private const val FIRST_BASE = FIRST_CHARS.length
        private const val OTHER_BASE = OTHER_CHARS.length

        val JassKeywords = setOf<String>(
            "and",
            "array",
            "call",
            "constant",
            "debug",
            "else",
            "elseif",
            "endfunction",
            "endif",
            "endloop",
            "endglobals",
            "extends",
            "exitwhen",
            "false",
            "function",
            "globals",
            "if",
            "local",
            "loop",
            "native",
            "not",
            "nothing",
            "null",
            "or",
            "returns",
            "return",
            "set",
            "takes",
            "then",
            "true",
            "type",
        )

        val LuaKeywords = setOf<String>(
            "and",
            "break",
            "do",
            "else",
            "elseif",
            "end",
            "false",
            "for",
            "function",
            "if",
            "in",
            "local",
            "nil",
            "not",
            "or",
            "repeat",
            "return",
            "then",
            "true",
            "until",
            "while"
        )

        val AllKeywords: Set<String> = JassKeywords.union(LuaKeywords)
    }
}

package io.github.warraft.language.jass.antlr.psi

class JassTypeName(var name: String) {
    companion object {
        const val NULL = "null"
        const val INTEGER = "integer"
        const val REAL = "real"
        const val STRING = "string"
        const val BOOLEAN = "boolean"
        const val CODE = "code"
        const val HANDLE = "handle"
        const val NOTHING = "nothing"
        const val UNDEFINED = "undefined"

        fun isBase(str: String?): Boolean = when (str) {
            INTEGER, REAL, STRING, BOOLEAN, CODE, HANDLE -> true
            else -> false
        }
    }

    override fun toString(): String = "JassTypeName(name=$name)"
}

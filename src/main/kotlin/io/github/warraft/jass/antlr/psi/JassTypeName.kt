package io.github.warraft.jass.antlr.psi

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
    }
}

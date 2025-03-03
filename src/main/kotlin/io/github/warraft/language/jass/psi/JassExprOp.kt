package io.github.warraft.language.jass.psi

enum class JassExprOp {
    UNSUB,
    UNNOT,
    MUL, DIV,
    ADD, SUB,
    LT, LTEQ, GT, GTEQ,
    EQ, NEQ,
    AND, OR,
    GET,
    SET,
    PAREN;

    companion object {
        fun parse(symbol: String?): JassExprOp? = when (symbol) {
            "*" -> MUL
            "/" -> DIV
            "+" -> ADD
            "-" -> SUB
            "<" -> LT
            "<=" -> LTEQ
            ">" -> GT
            ">=" -> GTEQ
            "==" -> EQ
            "!=" -> NEQ
            "and" -> AND
            "or" -> OR
            else -> null
        }
    }
}

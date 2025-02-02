package io.github.warraft.jass.antlr.psi

enum class JassExprOp {
    UnSub,
    UnNot,
    Mul, Div,
    Add, Sub,
    Lt, LtEq, Gt, GtEq,
    Eq, Neq,
    And, Or,
    Get,
    Set,
    Paren;

    companion object {
        fun fromSymbol(symbol: String?): JassExprOp? = when (symbol) {
            "*" -> Mul
            "/" -> Div
            "+" -> Add
            "-" -> Sub
            "<" -> Lt
            "<=" -> LtEq
            ">" -> Gt
            ">=" -> GtEq
            "==" -> Eq
            "!=" -> Neq
            "and" -> And
            "or" -> Or
            else -> null
        }
    }
}

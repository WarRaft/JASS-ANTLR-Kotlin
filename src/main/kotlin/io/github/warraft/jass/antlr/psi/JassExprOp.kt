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
    Paren,
}

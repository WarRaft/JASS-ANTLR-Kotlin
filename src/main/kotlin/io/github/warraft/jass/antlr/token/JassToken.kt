package io.github.warraft.jass.antlr.token

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

@Suppress("unused")
class JassToken(val line: Int, val pos: Int, val len: Int) {
    constructor(token: Token) : this(token.line, token.charPositionInLine, token.stopIndex - token.startIndex + 1)
    constructor(node: TerminalNode) : this(node.symbol)
    constructor(rule: ParserRuleContext) : this(
        rule.start.line,
        rule.start.charPositionInLine,
        rule.start.stopIndex - rule.start.startIndex + 1
    )
}

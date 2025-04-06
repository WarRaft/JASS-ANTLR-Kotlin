package io.github.warraft.language.slk.psi

class SlkValue(val text: SlkToken) {
    val kind: SlkValueKind
    private val numberRegex = Regex("""^(-?(?:\d+\.?\d*|\.\d+))$""")

    var d: Double? = null
    var i: Int? = null
    var b: Boolean? = null
    var s: String? = null

    init {
        val t = text.text
        kind = if (numberRegex.matches(t)) SlkValueKind.Number
        else if (t.startsWith("\"") && t.endsWith("\"")) SlkValueKind.String
        else if (t == "TRUE" || t == "FALSE") SlkValueKind.Boolean
        else SlkValueKind.Other

        when (kind) {
            SlkValueKind.String -> s = t.substring(1, t.length - 1)
            SlkValueKind.Number -> {
                i = t.toIntOrNull()
                d = t.toDoubleOrNull()
            }

            SlkValueKind.Boolean -> b = when (t) {
                "TRUE" -> true
                "FALSE" -> false
                else -> null
            }

            SlkValueKind.Other -> s = t
        }
    }
}

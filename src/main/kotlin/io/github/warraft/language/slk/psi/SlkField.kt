package io.github.warraft.language.slk.psi

class SlkField(
    val name: SlkToken,
) {
    val kind: SlkFieldKind = when (name.text) {
        "X" -> SlkFieldKind.X
        "Y" -> SlkFieldKind.Y
        "K" -> SlkFieldKind.Value
        else -> SlkFieldKind.Other
    }

    var value: SlkValue? = null
}

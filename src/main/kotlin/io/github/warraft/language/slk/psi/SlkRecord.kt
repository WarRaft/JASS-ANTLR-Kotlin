package io.github.warraft.language.slk.psi

import io.github.warraft.lsp.data.Position

class SlkRecord(
    var x: Int,
    var y: Int,
    var name: SlkToken,
) {
    val kind: SlkRecordKind = when (name.text) {
        "ID" -> SlkRecordKind.Init
        "C" -> SlkRecordKind.Column
        "B" -> SlkRecordKind.Bounds
        "E" -> SlkRecordKind.End
        else -> SlkRecordKind.Other
    }

    lateinit var end: Position

    var value: SlkValue? = null

    val field = mutableListOf<SlkField>()
}

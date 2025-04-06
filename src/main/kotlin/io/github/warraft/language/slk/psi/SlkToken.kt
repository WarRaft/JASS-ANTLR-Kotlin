package io.github.warraft.language.slk.psi

import io.github.warraft.lsp.data.Range

data class SlkToken(
    val text: String,
    val range: Range,
    val length: Int,
)

package io.github.warraft.lsp.progress

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#workDoneProgressParams

interface WorkDoneProgressParams {
    val workDoneToken: ProgressToken?
}

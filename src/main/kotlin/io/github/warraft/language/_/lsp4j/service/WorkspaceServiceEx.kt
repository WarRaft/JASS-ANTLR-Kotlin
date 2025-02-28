package io.github.warraft.language._.lsp4j.service

import io.github.warraft.language._.lsp4j.LanguageServerEx
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.services.WorkspaceService

class WorkspaceServiceEx(val server: LanguageServerEx) : WorkspaceService {

    override fun didChangeConfiguration(params: DidChangeConfigurationParams) {}

    override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams) {}
}

package io.github.warraft.jass.lsp4j.service

import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.services.WorkspaceService

class JassWorkspaceService : WorkspaceService {
    override fun didChangeConfiguration(params: DidChangeConfigurationParams) {
        //JassState()

    }

    override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams) {
        //val v: JassVar? = null

    }
}

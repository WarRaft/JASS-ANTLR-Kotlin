package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#serverCapabilities

@Serializable
data class ServerCapabilities(
    val textDocumentSync: TextDocumentSyncOptions? = null,
    val semanticTokensProvider: SemanticTokensOptions? = null,
    val completionProvider: CompletionOptions? = null,
    val documentHighlightProvider: Boolean? = null,
    val documentSymbolProvider: Boolean? = null,
    val diagnosticProvider: DiagnosticOptions? = null,
    val hoverProvider: Boolean? = null,
    val foldingRangeProvider: Boolean? = null,
    val definitionProvider: Boolean? = null,
    val referencesProvider: Boolean? = null,
    val documentFormattingProvider: Boolean? = null,
    val linkedEditingRangeProvider: Boolean? = null,
    val renameProvider: RenameOptions? = null,
    val inlayHintProvider: InlayHintOptions? = null,
) {
    /*

    /**
	 * The position encoding the server picked from the encodings offered
	 * by the client via the client capability `general.positionEncodings`.
	 *
	 * If the client didn't provide any position encodings the only valid
	 * value that a server can return is 'utf-16'.
	 *
	 * If omitted it defaults to 'utf-16'.
	 *
	 * @since 3.17.0
	 */
	positionEncoding?: PositionEncodingKind;

	/**
	 * Defines how notebook documents are synced.
	 *
	 * @since 3.17.0
	 */
	notebookDocumentSync?: NotebookDocumentSyncOptions
		| NotebookDocumentSyncRegistrationOptions;

	/**
	 * The server provides signature help support.
	 */
	signatureHelpProvider?: SignatureHelpOptions;

	/**
	 * The server provides go to declaration support.
	 *
	 * @since 3.14.0
	 */
	declarationProvider?: boolean | DeclarationOptions
		| DeclarationRegistrationOptions;

	/**
	 * The server provides goto type definition support.
	 *
	 * @since 3.6.0
	 */
	typeDefinitionProvider?: boolean | TypeDefinitionOptions
		| TypeDefinitionRegistrationOptions;

	/**
	 * The server provides goto implementation support.
	 *
	 * @since 3.6.0
	 */
	implementationProvider?: boolean | ImplementationOptions
		| ImplementationRegistrationOptions;


	/**
	 * The server provides code actions. The `CodeActionOptions` return type is
	 * only valid if the client signals code action literal support via the
	 * property `textDocument.codeAction.codeActionLiteralSupport`.
	 */
	codeActionProvider?: boolean | CodeActionOptions;

	/**
	 * The server provides code lens.
	 */
	codeLensProvider?: CodeLensOptions;

	/**
	 * The server provides document link support.
	 */
	documentLinkProvider?: DocumentLinkOptions;

	/**
	 * The server provides color provider support.
	 *
	 * @since 3.6.0
	 */
	colorProvider?: boolean | DocumentColorOptions
		| DocumentColorRegistrationOptions;

	/**
	 * The server provides document range formatting.
	 */
	documentRangeFormattingProvider?: boolean | DocumentRangeFormattingOptions;

	/**
	 * The server provides document formatting on typing.
	 */
	documentOnTypeFormattingProvider?: DocumentOnTypeFormattingOptions;


	/**
	 * The server provides execute command support.
	 */
	executeCommandProvider?: ExecuteCommandOptions;

	/**
	 * The server provides selection range support.
	 *
	 * @since 3.15.0
	 */
	selectionRangeProvider?: boolean | SelectionRangeOptions
		| SelectionRangeRegistrationOptions;


	/**
	 * The server provides call hierarchy support.
	 *
	 * @since 3.16.0
	 */
	callHierarchyProvider?: boolean | CallHierarchyOptions
		| CallHierarchyRegistrationOptions;


	/**
	 * Whether server provides moniker support.
	 *
	 * @since 3.16.0
	 */
	monikerProvider?: boolean | MonikerOptions | MonikerRegistrationOptions;

	/**
	 * The server provides type hierarchy support.
	 *
	 * @since 3.17.0
	 */
	typeHierarchyProvider?: boolean | TypeHierarchyOptions
		 | TypeHierarchyRegistrationOptions;

	/**
	 * The server provides inline values.
	 *
	 * @since 3.17.0
	 */
	inlineValueProvider?: boolean | InlineValueOptions | InlineValueRegistrationOptions;

	/**
	 * The server provides workspace symbol support.
	 */
	workspaceSymbolProvider?: boolean | WorkspaceSymbolOptions;

	/**
	 * Workspace specific server capabilities
	 */
	workspace?: {
		/**
		 * The server supports workspace folder.
		 *
		 * @since 3.6.0
		 */
		workspaceFolders?: WorkspaceFoldersServerCapabilities;

		/**
		 * The server is interested in file notifications/requests.
		 *
		 * @since 3.16.0
		 */
		fileOperations?: {
			/**
			 * The server is interested in receiving didCreateFiles
			 * notifications.
			 */
			didCreate?: FileOperationRegistrationOptions;

			/**
			 * The server is interested in receiving willCreateFiles requests.
			 */
			willCreate?: FileOperationRegistrationOptions;

			/**
			 * The server is interested in receiving didRenameFiles
			 * notifications.
			 */
			didRename?: FileOperationRegistrationOptions;

			/**
			 * The server is interested in receiving willRenameFiles requests.
			 */
			willRename?: FileOperationRegistrationOptions;

			/**
			 * The server is interested in receiving didDeleteFiles file
			 * notifications.
			 */
			didDelete?: FileOperationRegistrationOptions;

			/**
			 * The server is interested in receiving willDeleteFiles file
			 * requests.
			 */
			willDelete?: FileOperationRegistrationOptions;
		};
	};

	/**
	 * Experimental server capabilities.
	 */
	experimental?: LSPAny;
     */
}

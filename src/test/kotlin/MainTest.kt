import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.json.Json
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolute
import kotlin.test.Test

class MainTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    private fun jass(path: Path) {
        Main(
            arrayOf(
                "-jass2jass",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun json(){
        val json = Json {
            classDiscriminator = "AnalClassDiscriminator"
            ignoreUnknownKeys = true
            prettyPrint = true
        }

        val c = """
            {"jsonrpc":"2.0","id":0,"method":"initialize","params":{"processId":53848,"clientInfo":{"name":"Visual Studio Code","version":"1.97.2"},"locale":"en","rootPath":"/Users/nazarpunk/Downloads/test","rootUri":"file:///Users/nazarpunk/Downloads/test","capabilities":{"workspace":{"applyEdit":true,"workspaceEdit":{"documentChanges":true,"resourceOperations":["create","rename","delete"],"failureHandling":"textOnlyTransactional","normalizesLineEndings":true,"changeAnnotationSupport":{"groupsOnLabel":true}},"configuration":true,"didChangeWatchedFiles":{"dynamicRegistration":true,"relativePatternSupport":true},"symbol":{"dynamicRegistration":true,"symbolKind":{"valueSet":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]},"tagSupport":{"valueSet":[1]},"resolveSupport":{"properties":["location.range"]}},"codeLens":{"refreshSupport":true},"executeCommand":{"dynamicRegistration":true},"didChangeConfiguration":{"dynamicRegistration":true},"workspaceFolders":true,"foldingRange":{"refreshSupport":true},"semanticTokens":{"refreshSupport":true},"fileOperations":{"dynamicRegistration":true,"didCreate":true,"didRename":true,"didDelete":true,"willCreate":true,"willRename":true,"willDelete":true},"inlineValue":{"refreshSupport":true},"inlayHint":{"refreshSupport":true},"diagnostics":{"refreshSupport":true}},"textDocument":{"publishDiagnostics":{"relatedInformation":true,"versionSupport":false,"tagSupport":{"valueSet":[1,2]},"codeDescriptionSupport":true,"dataSupport":true},"synchronization":{"dynamicRegistration":true,"willSave":true,"willSaveWaitUntil":true,"didSave":true},"completion":{"dynamicRegistration":true,"contextSupport":true,"completionItem":{"snippetSupport":true,"commitCharactersSupport":true,"documentationFormat":["markdown","plaintext"],"deprecatedSupport":true,"preselectSupport":true,"tagSupport":{"valueSet":[1]},"insertReplaceSupport":true,"resolveSupport":{"properties":["documentation","detail","additionalTextEdits"]},"insertTextModeSupport":{"valueSet":[1,2]},"labelDetailsSupport":true},"insertTextMode":2,"completionItemKind":{"valueSet":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]},"completionList":{"itemDefaults":["commitCharacters","editRange","insertTextFormat","insertTextMode","data"]}},"hover":{"dynamicRegistration":true,"contentFormat":["markdown","plaintext"]},"signatureHelp":{"dynamicRegistration":true,"signatureInformation":{"documentationFormat":["markdown","plaintext"],"parameterInformation":{"labelOffsetSupport":true},"activeParameterSupport":true},"contextSupport":true},"definition":{"dynamicRegistration":true,"linkSupport":true},"references":{"dynamicRegistration":true},"documentHighlight":{"dynamicRegistration":true},"documentSymbol":{"dynamicRegistration":true,"symbolKind":{"valueSet":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]},"hierarchicalDocumentSymbolSupport":true,"tagSupport":{"valueSet":[1]},"labelSupport":true},"codeAction":{"dynamicRegistration":true,"isPreferredSupport":true,"disabledSupport":true,"dataSupport":true,"resolveSupport":{"properties":["edit"]},"codeActionLiteralSupport":{"codeActionKind":{"valueSet":["","quickfix","refactor","refactor.extract","refactor.inline","refactor.rewrite","source","source.organizeImports"]}},"honorsChangeAnnotations":true},"codeLens":{"dynamicRegistration":true},"formatting":{"dynamicRegistration":true},"rangeFormatting":{"dynamicRegistration":true,"rangesSupport":true},"onTypeFormatting":{"dynamicRegistration":true},"rename":{"dynamicRegistration":true,"prepareSupport":true,"prepareSupportDefaultBehavior":1,"honorsChangeAnnotations":true},"documentLink":{"dynamicRegistration":true,"tooltipSupport":true},"typeDefinition":{"dynamicRegistration":true,"linkSupport":true},"implementation":{"dynamicRegistration":true,"linkSupport":true},"colorProvider":{"dynamicRegistration":true},"foldingRange":{"dynamicRegistration":true,"rangeLimit":5000,"lineFoldingOnly":true,"foldingRangeKind":{"valueSet":["comment","imports","region"]},"foldingRange":{"collapsedText":false}},"declaration":{"dynamicRegistration":true,"linkSupport":true},"selectionRange":{"dynamicRegistration":true},"callHierarchy":{"dynamicRegistration":true},"semanticTokens":{"dynamicRegistration":true,"tokenTypes":["namespace","type","class","enum","interface","struct","typeParameter","parameter","variable","property","enumMember","event","function","method","macro","keyword","modifier","comment","string","number","regexp","operator","decorator"],"tokenModifiers":["declaration","definition","readonly","static","deprecated","abstract","async","modification","documentation","defaultLibrary"],"formats":["relative"],"requests":{"range":true,"full":{"delta":true}},"multilineTokenSupport":false,"overlappingTokenSupport":false,"serverCancelSupport":true,"augmentsSyntaxTokens":true},"linkedEditingRange":{"dynamicRegistration":true},"typeHierarchy":{"dynamicRegistration":true},"inlineValue":{"dynamicRegistration":true},"inlayHint":{"dynamicRegistration":true,"resolveSupport":{"properties":["tooltip","textEdits","label.tooltip","label.location","label.command"]}},"diagnostic":{"dynamicRegistration":true,"relatedDocumentSupport":false}},"window":{"showMessage":{"messageActionItem":{"additionalPropertiesSupport":true}},"showDocument":{"support":true},"workDoneProgress":true},"general":{"staleRequestSupport":{"cancel":true,"retryOnContentModified":["textDocument/semanticTokens/full","textDocument/semanticTokens/range","textDocument/semanticTokens/full/delta"]},"regularExpressions":{"engine":"ECMAScript","version":"ES2020"},"markdown":{"parser":"marked","version":"1.1.0"},"positionEncodings":["utf-16"]},"notebookDocument":{"synchronization":{"dynamicRegistration":true,"executionSummarySupport":true}}},"initializationOptions":{"settings":{"Warcraft":{"scripts":["/Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin-VSCode/sdk/common.ujapi.j","/Users/nazarpunk/IdeaProjects/JASS-ANTLR-Kotlin-VSCode/sdk/blizzard.j","/Users/nazarpunk/Downloads/test/common.test.j"]}}},"trace":"off","workspaceFolders":[{"uri":"file:///Users/nazarpunk/Downloads/test","name":"test"}],"workDoneToken":"d1e08ef5-7bd0-4de0-bee9-2c7448fc8f59"}}            
        """.trimIndent()


        val m = json.decodeFromString<Message>(c)

println(m)
    }

    @Test
    fun keywordJass() {
        jass(Paths.get("src", "test", "resources", "keyword.j"))
    }

    @Test
    fun testJass() {
        jass(Paths.get("src", "test", "resources", "jass", "test.j"))
    }

    @Test
    fun convertJass() {
        jass(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    @Test
    fun convertLua() {
        lua(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    private fun lua(path: Path) {
        Main(
            arrayOf(
                "-jass2lua",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun keywordLua() {
        lua(Paths.get("src", "test", "resources", "lua", "keyword.j"))
    }

    @Test
    fun concatenationLua() {
        lua(Paths.get("src", "test", "resources", "lua", "concatenation.j"))
    }

    @Test
    fun keyword() {
        lua(Paths.get("src", "test", "resources", "lua", "keyword.j"))
    }

    @Test
    fun ltd() {
        lua(Paths.get("src", "test", "resources", "map", "LTD.j"))
    }

    @Test
    fun lg() {
        lua(Paths.get("src", "test", "resources", "map", "LastGuard.j"))
    }

    private fun ass(path: Path) {
        Main(
            arrayOf(
                "-jass2as",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun convertAs() {
        ass(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    @Test
    fun lgAs() {
        ass(Paths.get("src", "test", "resources", "maps", "LastGuard.j"))
    }

}

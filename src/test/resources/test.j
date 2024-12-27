native MergeUnits takes integer qty, integer a, integer b, integer make returns boolean
native ConvertUnits takes integer qty, integer id returns boolean
native IgnoredUnits takes integer unitid returns integer
globals
    boolean modeMI = false
    boolean modeAH = false
    boolean modeAP = false
    boolean modeAR = false
    boolean modeLI = false
    boolean modeMM = false
    boolean modeSD = false
    boolean modeHG = false

endglobals


function CreateTopPlayersTextTag takes nothing returns nothing
    local texttag tt
    local string topPlayers = "|cffFFcc00   TOP 6 Playersn"
    local texttag tt
    local string topPlayers = "|cffFFcc00   TOP 6 Players\n"
    local texttag tt
    local string topPlayers = "|cffFFcc00   TOP 6 Players\n"+"of the last season:\n \n|r"+playerName1+"\n"+playerName2+"\n"+playerName3+"\n"+playerName4+"\n"+playerName5+"\n"+playerName6
    set tt = CreateTextTag()
    call SetTextTagText(tt, topPlayers, 0.025)
    call SetTextTagPos(tt, -70.0, 4800.0, 0)
    call SetTextTagColor(tt, 255, 255, 255, 255)
    call SetTextTagPermanent(tt, true)
    call SetTextTagVisibility(tt, true)
endfunction
function SetImagePositionForImg takes string filePath, real xpos, real ypos, real zpos, integer imgtype returns nothing
    local image img = CreateImage(filePath, 256*1.4, 256*1.4, 0, xpos, ypos, zpos, 0, 0, 0, 4)
    call SetImageRenderAlways(img, true)
    call ShowImage(img, true)
endfunction
function CreateMosaic takes nothing returns nothing
    local integer xpos = 200
    local integer ypos = 4500
    call SetImagePositionForImg("UI\\Glues\\ScoreScreen\\ScoreScreen-Defeat\\scorescreen-defeat.blp", xpos-612, ypos+612, 0, 0)
    call SetImagePositionForImg("UI\\Glues\\Loading\\Backgrounds\\Campaigns\\NightElfSymbol.blp", xpos, ypos+612, 0, 0)
    call SetImagePositionForImg("UI\\Glues\\Loading\\Backgrounds\\Campaigns\\HumanSymbol.blp", xpos-612, ypos, 0, 1)
    call SetImagePositionForImg("UI\\Glues\\Loading\\Backgrounds\\Campaigns\\UndeadSymbol.blp", xpos, ypos, 0, 0)
endfunction
function setHybridBuilder takes nothing returns nothing
    local integer ie = 0
    local unit ue
    loop
        exitwhen ie>7
        set ue = KV[ie+1]
        if ue !=null and GetPlayerSlotState(Player(ie))==PLAYER_SLOT_STATE_PLAYING then
            call ReplaceUnitBJ_FIX(ue, $75303049, 3)
        endif
        set ie = ie+1
    endloop
    set ue = null
endfunction
function UpdateMaxUnits takes nothing returns nothing
    local integer currentWestUnits = CountUnitsInGroup(MA[1])
    local integer currentEastUnits = CountUnitsInGroup(MA[2])
    if currentWestUnits>maxWestUnits then
        set maxWestUnits = currentWestUnits
    endif
    if currentEastUnits>maxEastUnits then
        set maxEastUnits = currentEastUnits
    endif
endfunction
function ClearTrashTextag takes nothing returns nothing
    local integer TPl = GetPlayerId(GetLocalPlayer())
    local integer i = 0
    local texttag tag
    loop
        exitwhen i>=1000
        if LoadStr(unitDataHash, TPl, i)!="" then
            call SaveStr(unitDataHash, TPl, i, "")
            call SaveInteger(unitDataHash, TPl, 1000+i, 0)
        endif
        set i = i+1
    endloop
    set i = 0
    loop
        exitwhen i>=10
        set tag = LoadTextTagHandle(textTagHash, TPl, i)
        if tag !=null then
            call SetTextTagText(tag, "", 0.03)
            call SaveTextTagHandle(textTagHash, TPl, i, null)
            call DestroyTextTag(tag)
        endif
        set i = i+1
    endloop
endfunction

function InitAllyPriorities takes nothing returns nothing



    set StringUtils_c2s[86] = "V"
    set StringUtils_c2s[87] = "W"
    set StringUtils_c2s[88] = "X"
    set StringUtils_c2s[89] = "Y"
    set StringUtils_c2s[90] = "Z"
    set StringUtils_c2s[91] = "["
    set StringUtils_c2s[92] = "\\"
    set StringUtils_c2s[93] = "]"
    set StringUtils_c2s[94] = "^"
    set StringUtils_c2s[95] = "_"

    set StringUtils_c2s[92] = "\\"
    set StringUtils_c2s[93] = "]"
    call SetStartLocPrioCount(" \\\" cssvv ")

    call SetStartLocPrioCount("
\"
    cssvv
    ")

    if this==0 then
        call error("Nullpointer exception when calling Table.hasString", "when calling error in Table, line 18")
    else
        call error("Called Table.hasString on invalid object.", "when calling error in Table, line 18")
    endif

    set StringUtils_c2s[123] = "{"
    set StringUtils_c2s[124] = "|"
    set StringUtils_c2s[125] = "}"
    set StringUtils_c2s[126] = "~"
    set StringUtils_c2s[127] = ""

    call SetStartLocPrioCount(0., 1)
    call SetStartLocPrio(0, 0, 1, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(1, 1)
    call SetStartLocPrio(1, 0, 0, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(2, 2)
    call SetStartLocPrio(2, 2, 3, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrio(2, 3, 4, MAP_LOC_PRIO_LOW)
    call SetStartLocPrioCount(3, 2)
    call SetStartLocPrio(3, 2, 2, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrio(3, 4, 5, MAP_LOC_PRIO_LOW)
    call SetStartLocPrioCount(4, 2)
    call SetStartLocPrio(4, 2, 2, MAP_LOC_PRIO_LOW)
    call SetStartLocPrio(4, 4, 5, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(5, 2)
    call SetStartLocPrio(5, 3, 3, MAP_LOC_PRIO_LOW)
    call SetStartLocPrio(5, 4, 4, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(6, 1)
    call SetStartLocPrio(6, 6, 7, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(7, 1)
    call SetStartLocPrio(7, 6, 6, MAP_LOC_PRIO_HIGH)
    call SetStartLocPrioCount(8, 0)
    call SetStartLocPrioCount(9, 0)
endfunction
function config takes nothing returns nothing
    call SetMapName("|cff1E90FFLegion TD x20|r |cff7B68EENextGen|r")
    call SetMapDescription("Build your warriors to defend your King vs a horde of menacing enemies.
Changelogs and privileges-(Discord)https:
Edited by Excellent,OZGame Team,G0mez,HappyGhoul,SPK-S,Zemphyrrian420,DrTema,SLAVA_DROM
Luna")
    call SetPlayers(10)
    call SetTeams(2)
    call SetGamePlacement(MAP_PLACEMENT_TEAMS_TOGETHER)
    call DefineStartLocation(0, -7090., 4224.)
    call DefineStartLocation(1, -7090., 1408.)
    call DefineStartLocation(2, -1970., 4224.)
    call DefineStartLocation(3, -1970., 1408.)
    call DefineStartLocation(4, 1970., 4224.)
    call DefineStartLocation(5, 1970., 1408.)
    call DefineStartLocation(6, 7090., 4224.)
    call DefineStartLocation(7, 7090., 1408.)
    call DefineStartLocation(8, -4545., -3260.)
    call DefineStartLocation(9, 4545., -3260.)
    call InitCustomPlayerSlots()
    call InitCustomTeams()
    call InitAllyPriorities()
endfunction



globals



    integer a = 1
    real b = 2
endglobals

native UnitAlive takes unit u returns boolean


function Anal takes nothing returns nothing

endfunction


function Cunt takes nothing returns nothing

endfunction

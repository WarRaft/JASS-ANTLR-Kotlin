//============================================================================
// Native types. All native functions take extended handle types when
// possible to help prevent passing bad values to native functions
//
type agent			    extends     handle  // all reference counted objects
type event              extends     agent  // a reference to an event registration
type player             extends     agent  // a single player reference
type widget             extends     agent  // an interactive game object with life
type unit               extends     widget  // a single unit reference
type destructable       extends     widget
type item               extends     widget
type ability            extends     agent
type buff               extends     ability
type force              extends     agent
type group              extends     agent
type trigger            extends     agent
type triggercondition   extends     agent
type triggeraction      extends     handle
type timer              extends     agent
type location           extends     agent
type region             extends     agent
type rect               extends     agent
type boolexpr           extends     agent
type sound              extends     agent
type conditionfunc      extends     boolexpr
type filterfunc         extends     boolexpr
type unitpool           extends     handle
type itempool           extends     handle
type race               extends     handle
type alliancetype       extends     handle
type racepreference     extends     handle
type gamestate          extends     handle
type igamestate         extends     gamestate
type fgamestate         extends     gamestate
type playerstate        extends     handle
type playerscore        extends     handle
type playergameresult   extends     handle
type unitstate          extends     handle
type aidifficulty       extends     handle

type eventid            extends     handle
type gameevent          extends     eventid
type playerevent        extends     eventid
type playerunitevent    extends     eventid
type unitevent          extends     eventid
type limitop            extends     eventid
type widgetevent        extends     eventid
type dialogevent        extends     eventid
type unittype           extends     handle

type gamespeed          extends     handle
type gamedifficulty     extends     handle
type gametype           extends     handle
type mapflag            extends     handle
type mapvisibility      extends     handle
type mapsetting         extends     handle
type mapdensity         extends     handle
type mapcontrol         extends     handle
type playerslotstate    extends     handle
type volumegroup        extends     handle
type camerafield        extends     handle
type camerasetup        extends     handle
type playercolor        extends     handle
type placement          extends     handle
type startlocprio       extends     handle
type raritycontrol      extends     handle
type blendmode          extends     handle
type texmapflags        extends     handle
type effect             extends     agent
type effecttype         extends     handle
type weathereffect      extends     handle
type terraindeformation extends     handle
type fogstate           extends     handle
type fogmodifier        extends     agent
type dialog             extends     agent
type button             extends     agent
type quest              extends     agent
type questitem          extends     agent
type defeatcondition    extends     agent
type timerdialog        extends     agent
type leaderboard        extends     agent
type multiboard         extends     agent
type multiboarditem     extends     agent
type trackable          extends     agent
type gamecache          extends     agent
type version            extends     handle
type itemtype           extends     handle
type texttag            extends     handle
type attacktype         extends     handle
type damagetype         extends     handle
type weapontype         extends     handle
type soundtype          extends     handle
type lightning          extends     handle
type pathingtype        extends     handle
type image              extends     handle
type ubersplat          extends     handle
type hashtable          extends     agent

constant native ConvertRace                 takes integer i returns race
constant native ConvertAllianceType         takes integer i returns alliancetype
constant native ConvertRacePref             takes integer i returns racepreference
constant native ConvertIGameState           takes integer i returns igamestate
constant native ConvertFGameState           takes integer i returns fgamestate
constant native ConvertPlayerState          takes integer i returns playerstate
constant native ConvertPlayerScore          takes integer i returns playerscore
constant native ConvertPlayerGameResult     takes integer i returns playergameresult
constant native ConvertUnitState            takes integer i returns unitstate
constant native ConvertAIDifficulty         takes integer i returns aidifficulty
constant native ConvertGameEvent            takes integer i returns gameevent
constant native ConvertPlayerEvent          takes integer i returns playerevent
constant native ConvertPlayerUnitEvent      takes integer i returns playerunitevent
constant native ConvertWidgetEvent          takes integer i returns widgetevent
constant native ConvertDialogEvent          takes integer i returns dialogevent
constant native ConvertUnitEvent            takes integer i returns unitevent
constant native ConvertLimitOp              takes integer i returns limitop
constant native ConvertUnitType             takes integer i returns unittype
constant native ConvertGameSpeed            takes integer i returns gamespeed
constant native ConvertPlacement            takes integer i returns placement
constant native ConvertStartLocPrio         takes integer i returns startlocprio
constant native ConvertGameDifficulty       takes integer i returns gamedifficulty
constant native ConvertGameType             takes integer i returns gametype
constant native ConvertMapFlag              takes integer i returns mapflag
constant native ConvertMapVisibility        takes integer i returns mapvisibility
constant native ConvertMapSetting           takes integer i returns mapsetting
constant native ConvertMapDensity           takes integer i returns mapdensity
constant native ConvertMapControl           takes integer i returns mapcontrol
constant native ConvertPlayerColor          takes integer i returns playercolor
constant native ConvertPlayerSlotState      takes integer i returns playerslotstate
constant native ConvertVolumeGroup          takes integer i returns volumegroup
constant native ConvertCameraField          takes integer i returns camerafield
constant native ConvertBlendMode            takes integer i returns blendmode
constant native ConvertRarityControl        takes integer i returns raritycontrol
constant native ConvertTexMapFlags          takes integer i returns texmapflags
constant native ConvertFogState             takes integer i returns fogstate
constant native ConvertEffectType           takes integer i returns effecttype
constant native ConvertVersion              takes integer i returns version
constant native ConvertItemType             takes integer i returns itemtype
constant native ConvertAttackType           takes integer i returns attacktype
constant native ConvertDamageType           takes integer i returns damagetype
constant native ConvertWeaponType           takes integer i returns weapontype
constant native ConvertSoundType            takes integer i returns soundtype
constant native ConvertPathingType          takes integer i returns pathingtype

constant native OrderId                     takes string  orderIdString     returns integer
constant native OrderId2String              takes integer orderId           returns string
constant native UnitId                      takes string  unitIdString      returns integer
constant native UnitId2String               takes integer unitId            returns string

// Not currently working correctly...
constant native AbilityId                   takes string  abilityIdString   returns integer
constant native AbilityId2String            takes integer abilityId         returns string

// Looks up the "name" field for any object (unit, item, ability)
constant native GetObjectName               takes integer objectId          returns string

globals

string s = 1 + 2 + ""

constant real a = 1. + 2 * 3

real d

integer array l__Array

    constant playercolor        PLAYER_COLOR_RED                = ConvertPlayerColor(0)
    constant playercolor        PLAYER_COLOR_BLUE               = ConvertPlayerColor(1)
    constant playercolor        PLAYER_COLOR_CYAN               = ConvertPlayerColor(2)
    constant playercolor        PLAYER_COLOR_PURPLE             = ConvertPlayerColor(3)
    constant playercolor        PLAYER_COLOR_YELLOW             = ConvertPlayerColor(4)
    constant playercolor        PLAYER_COLOR_ORANGE             = ConvertPlayerColor(5)
    constant playercolor        PLAYER_COLOR_GREEN              = ConvertPlayerColor(6)


endglobals



function InitArray takes integer vtable returns nothing
    set l__Array[4] = 0
    set l__Array[1] = vtable
    set l__Array[2] = -1
    set l__Array[3] = -1
endfunction
function TypecastArray takes nothing returns nothing
    local integer l__Array
endfunction
function GetArrayAddress takes nothing returns integer
    loop
        return l__Array
    endloop
    return 0
endfunction

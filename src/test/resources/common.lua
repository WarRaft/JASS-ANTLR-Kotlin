---@class handle
---@class agent:handle
---@class event:agent
---@class player:agent
---@class widget:agent
---@class unit:widget
---@class destructable:widget
---@class item:widget
---@class ability:agent
---@class buff:ability
---@class force:agent
---@class group:agent
---@class trigger:agent
---@class triggercondition:agent
---@class triggeraction:handle
---@class timer:agent
---@class location:agent
---@class region:agent
---@class rect:agent
---@class boolexpr:agent
---@class sound:agent
---@class conditionfunc:boolexpr
---@class filterfunc:boolexpr
---@class unitpool:handle
---@class itempool:handle
---@class race:handle
---@class alliancetype:handle
---@class racepreference:handle
---@class gamestate:handle
---@class igamestate:gamestate
---@class fgamestate:gamestate
---@class playerstate:handle
---@class playerscore:handle
---@class playergameresult:handle
---@class unitstate:handle
---@class aidifficulty:handle
---@class eventid:handle
---@class gameevent:eventid
---@class playerevent:eventid
---@class playerunitevent:eventid
---@class unitevent:eventid
---@class limitop:eventid
---@class widgetevent:eventid
---@class dialogevent:eventid
---@class unittype:handle
---@class gamespeed:handle
---@class gamedifficulty:handle
---@class gametype:handle
---@class mapflag:handle
---@class mapvisibility:handle
---@class mapsetting:handle
---@class mapdensity:handle
---@class mapcontrol:handle
---@class playerslotstate:handle
---@class volumegroup:handle
---@class camerafield:handle
---@class camerasetup:handle
---@class playercolor:handle
---@class placement:handle
---@class startlocprio:handle
---@class raritycontrol:handle
---@class blendmode:handle
---@class texmapflags:handle
---@class effect:agent
---@class effecttype:handle
---@class weathereffect:handle
---@class terraindeformation:handle
---@class fogstate:handle
---@class fogmodifier:agent
---@class dialog:agent
---@class button:agent
---@class quest:agent
---@class questitem:agent
---@class defeatcondition:agent
---@class timerdialog:agent
---@class leaderboard:agent
---@class multiboard:agent
---@class multiboarditem:agent
---@class trackable:agent
---@class gamecache:agent
---@class version:handle
---@class itemtype:handle
---@class texttag:handle
---@class attacktype:handle
---@class damagetype:handle
---@class weapontype:handle
---@class soundtype:handle
---@class lightning:handle
---@class pathingtype:handle
---@class image:handle
---@class ubersplat:handle
---@class hashtable:agent

--- native
---@param i number integer
---@return race
function ConvertRace (i) end

--- native
---@param i number integer
---@return alliancetype
function ConvertAllianceType (i) end

--- native
---@param i number integer
---@return racepreference
function ConvertRacePref (i) end

--- native
---@param i number integer
---@return igamestate
function ConvertIGameState (i) end

--- native
---@param i number integer
---@return fgamestate
function ConvertFGameState (i) end

--- native
---@param i number integer
---@return playerstate
function ConvertPlayerState (i) end

--- native
---@param i number integer
---@return playerscore
function ConvertPlayerScore (i) end

--- native
---@param i number integer
---@return playergameresult
function ConvertPlayerGameResult (i) end

--- native
---@param i number integer
---@return unitstate
function ConvertUnitState (i) end

--- native
---@param i number integer
---@return aidifficulty
function ConvertAIDifficulty (i) end

--- native
---@param i number integer
---@return gameevent
function ConvertGameEvent (i) end

--- native
---@param i number integer
---@return playerevent
function ConvertPlayerEvent (i) end

--- native
---@param i number integer
---@return playerunitevent
function ConvertPlayerUnitEvent (i) end

--- native
---@param i number integer
---@return widgetevent
function ConvertWidgetEvent (i) end

--- native
---@param i number integer
---@return dialogevent
function ConvertDialogEvent (i) end

--- native
---@param i number integer
---@return unitevent
function ConvertUnitEvent (i) end

--- native
---@param i number integer
---@return limitop
function ConvertLimitOp (i) end

--- native
---@param i number integer
---@return unittype
function ConvertUnitType (i) end

--- native
---@param i number integer
---@return gamespeed
function ConvertGameSpeed (i) end

--- native
---@param i number integer
---@return placement
function ConvertPlacement (i) end

--- native
---@param i number integer
---@return startlocprio
function ConvertStartLocPrio (i) end

--- native
---@param i number integer
---@return gamedifficulty
function ConvertGameDifficulty (i) end

--- native
---@param i number integer
---@return gametype
function ConvertGameType (i) end

--- native
---@param i number integer
---@return mapflag
function ConvertMapFlag (i) end

--- native
---@param i number integer
---@return mapvisibility
function ConvertMapVisibility (i) end

--- native
---@param i number integer
---@return mapsetting
function ConvertMapSetting (i) end

--- native
---@param i number integer
---@return mapdensity
function ConvertMapDensity (i) end

--- native
---@param i number integer
---@return mapcontrol
function ConvertMapControl (i) end

--- native
---@param i number integer
---@return playercolor
function ConvertPlayerColor (i) end

--- native
---@param i number integer
---@return playerslotstate
function ConvertPlayerSlotState (i) end

--- native
---@param i number integer
---@return volumegroup
function ConvertVolumeGroup (i) end

--- native
---@param i number integer
---@return camerafield
function ConvertCameraField (i) end

--- native
---@param i number integer
---@return blendmode
function ConvertBlendMode (i) end

--- native
---@param i number integer
---@return raritycontrol
function ConvertRarityControl (i) end

--- native
---@param i number integer
---@return texmapflags
function ConvertTexMapFlags (i) end

--- native
---@param i number integer
---@return fogstate
function ConvertFogState (i) end

--- native
---@param i number integer
---@return effecttype
function ConvertEffectType (i) end

--- native
---@param i number integer
---@return version
function ConvertVersion (i) end

--- native
---@param i number integer
---@return itemtype
function ConvertItemType (i) end

--- native
---@param i number integer
---@return attacktype
function ConvertAttackType (i) end

--- native
---@param i number integer
---@return damagetype
function ConvertDamageType (i) end

--- native
---@param i number integer
---@return weapontype
function ConvertWeaponType (i) end

--- native
---@param i number integer
---@return soundtype
function ConvertSoundType (i) end

--- native
---@param i number integer
---@return pathingtype
function ConvertPathingType (i) end

--- native
---@param orderIdString string
---@return number integer
function OrderId (orderIdString) end

--- native
---@param orderId number integer
---@return string
function OrderId2String (orderId) end

--- native
---@param unitIdString string
---@return number integer
function UnitId (unitIdString) end

--- native
---@param unitId number integer
---@return string
function UnitId2String (unitId) end

--- native
---@param abilityIdString string
---@return number integer
function AbilityId (abilityIdString) end

--- native
---@param abilityId number integer
---@return string
function AbilityId2String (abilityId) end

--- native
---@param objectId number integer
---@return string
function GetObjectName (objectId) end

--- native
---@param degrees number real
---@return number real
function Deg2Rad (degrees) end

--- native
---@param radians number real
---@return number real
function Rad2Deg (radians) end

--- native
---@param radians number real
---@return number real
function Sin (radians) end

--- native
---@param radians number real
---@return number real
function Cos (radians) end

--- native
---@param radians number real
---@return number real
function Tan (radians) end

--- native
---@param y number real
---@return number real
function Asin (y) end

--- native
---@param x number real
---@return number real
function Acos (x) end

--- native
---@param x number real
---@return number real
function Atan (x) end

--- native
---@param y number real
---@param x number real
---@return number real
function Atan2 (y, x) end

--- native
---@param x number real
---@return number real
function SquareRoot (x) end

--- native
---@param x number real
---@param power number real
---@return number real
function Pow (x, power) end

--- native
---@param i number integer
---@return number real
function I2R (i) end

--- native
---@param r number real
---@return number integer
function R2I (r) end

--- native
---@param i number integer
---@return string
function I2S (i) end

--- native
---@param r number real
---@return string
function R2S (r) end

--- native
---@param r number real
---@param width number integer
---@param precision number integer
---@return string
function R2SW (r, width, precision) end

--- native
---@param s string
---@return number integer
function S2I (s) end

--- native
---@param s string
---@return number real
function S2R (s) end

--- native
---@param h handle
---@return number integer
function GetHandleId (h) end

--- native
---@param source string
---@param start number integer
---@param end_ number integer
---@return string
function SubString (source, start, end_) end

--- native
---@param s string
---@return number integer
function StringLength (s) end

--- native
---@param source string
---@param upper boolean
---@return string
function StringCase (source, upper) end

--- native
---@param s string
---@return number integer
function StringHash (s) end

--- native
---@param source string
---@return string
function GetLocalizedString (source) end

--- native
---@param source string
---@return number integer
function GetLocalizedHotkey (source) end

--- native
---@param name string
function SetMapName (name) end

--- native
---@param description string
function SetMapDescription (description) end

--- native
---@param teamcount number integer
function SetTeams (teamcount) end

--- native
---@param playercount number integer
function SetPlayers (playercount) end

--- native
---@param whichStartLoc number integer
---@param x number real
---@param y number real
function DefineStartLocation (whichStartLoc, x, y) end

--- native
---@param whichStartLoc number integer
---@param whichLocation location
function DefineStartLocationLoc (whichStartLoc, whichLocation) end

--- native
---@param whichStartLoc number integer
---@param prioSlotCount number integer
function SetStartLocPrioCount (whichStartLoc, prioSlotCount) end

--- native
---@param whichStartLoc number integer
---@param prioSlotIndex number integer
---@param otherStartLocIndex number integer
---@param priority startlocprio
function SetStartLocPrio (whichStartLoc, prioSlotIndex, otherStartLocIndex, priority) end

--- native
---@param whichStartLoc number integer
---@param prioSlotIndex number integer
---@return number integer
function GetStartLocPrioSlot (whichStartLoc, prioSlotIndex) end

--- native
---@param whichStartLoc number integer
---@param prioSlotIndex number integer
---@return startlocprio
function GetStartLocPrio (whichStartLoc, prioSlotIndex) end

--- native
---@param whichGameType gametype
---@param value boolean
function SetGameTypeSupported (whichGameType, value) end

--- native
---@param whichMapFlag mapflag
---@param value boolean
function SetMapFlag (whichMapFlag, value) end

--- native
---@param whichPlacementType placement
function SetGamePlacement (whichPlacementType) end

--- native
---@param whichspeed gamespeed
function SetGameSpeed (whichspeed) end

--- native
---@param whichdifficulty gamedifficulty
function SetGameDifficulty (whichdifficulty) end

--- native
---@param whichdensity mapdensity
function SetResourceDensity (whichdensity) end

--- native
---@param whichdensity mapdensity
function SetCreatureDensity (whichdensity) end

--- native
---@return number integer
function GetTeams () end

--- native
---@return number integer
function GetPlayers () end

--- native
---@param whichGameType gametype
---@return boolean
function IsGameTypeSupported (whichGameType) end

--- native
---@return gametype
function GetGameTypeSelected () end

--- native
---@param whichMapFlag mapflag
---@return boolean
function IsMapFlagSet (whichMapFlag) end

--- native
---@return placement
function GetGamePlacement () end

--- native
---@return gamespeed
function GetGameSpeed () end

--- native
---@return gamedifficulty
function GetGameDifficulty () end

--- native
---@return mapdensity
function GetResourceDensity () end

--- native
---@return mapdensity
function GetCreatureDensity () end

--- native
---@param whichStartLocation number integer
---@return number real
function GetStartLocationX (whichStartLocation) end

--- native
---@param whichStartLocation number integer
---@return number real
function GetStartLocationY (whichStartLocation) end

--- native
---@param whichStartLocation number integer
---@return location
function GetStartLocationLoc (whichStartLocation) end

--- native
---@param whichPlayer player
---@param whichTeam number integer
function SetPlayerTeam (whichPlayer, whichTeam) end

--- native
---@param whichPlayer player
---@param startLocIndex number integer
function SetPlayerStartLocation (whichPlayer, startLocIndex) end

--- native
---@param whichPlayer player
---@param startLocIndex number integer
function ForcePlayerStartLocation (whichPlayer, startLocIndex) end

--- native
---@param whichPlayer player
---@param color playercolor
function SetPlayerColor (whichPlayer, color) end

--- native
---@param sourcePlayer player
---@param otherPlayer player
---@param whichAllianceSetting alliancetype
---@param value boolean
function SetPlayerAlliance (sourcePlayer, otherPlayer, whichAllianceSetting, value) end

--- native
---@param sourcePlayer player
---@param otherPlayer player
---@param whichResource playerstate
---@param rate number integer
function SetPlayerTaxRate (sourcePlayer, otherPlayer, whichResource, rate) end

--- native
---@param whichPlayer player
---@param whichRacePreference racepreference
function SetPlayerRacePreference (whichPlayer, whichRacePreference) end

--- native
---@param whichPlayer player
---@param value boolean
function SetPlayerRaceSelectable (whichPlayer, value) end

--- native
---@param whichPlayer player
---@param controlType mapcontrol
function SetPlayerController (whichPlayer, controlType) end

--- native
---@param whichPlayer player
---@param name string
function SetPlayerName (whichPlayer, name) end

--- native
---@param whichPlayer player
---@param flag boolean
function SetPlayerOnScoreScreen (whichPlayer, flag) end

--- native
---@param whichPlayer player
---@return number integer
function GetPlayerTeam (whichPlayer) end

--- native
---@param whichPlayer player
---@return number integer
function GetPlayerStartLocation (whichPlayer) end

--- native
---@param whichPlayer player
---@return playercolor
function GetPlayerColor (whichPlayer) end

--- native
---@param whichPlayer player
---@return boolean
function GetPlayerSelectable (whichPlayer) end

--- native
---@param whichPlayer player
---@return mapcontrol
function GetPlayerController (whichPlayer) end

--- native
---@param whichPlayer player
---@return playerslotstate
function GetPlayerSlotState (whichPlayer) end

--- native
---@param sourcePlayer player
---@param otherPlayer player
---@param whichResource playerstate
---@return number integer
function GetPlayerTaxRate (sourcePlayer, otherPlayer, whichResource) end

--- native
---@param whichPlayer player
---@param pref racepreference
---@return boolean
function IsPlayerRacePrefSet (whichPlayer, pref) end

--- native
---@param whichPlayer player
---@return string
function GetPlayerName (whichPlayer) end

--- native
---@return timer
function CreateTimer () end

--- native
---@param whichTimer timer
function DestroyTimer (whichTimer) end

--- native
---@param whichTimer timer
---@param timeout number real
---@param periodic boolean
---@param handlerFunc function
function TimerStart (whichTimer, timeout, periodic, handlerFunc) end

--- native
---@param whichTimer timer
---@return number real
function TimerGetElapsed (whichTimer) end

--- native
---@param whichTimer timer
---@return number real
function TimerGetRemaining (whichTimer) end

--- native
---@param whichTimer timer
---@return number real
function TimerGetTimeout (whichTimer) end

--- native
---@param whichTimer timer
function PauseTimer (whichTimer) end

--- native
---@param whichTimer timer
function ResumeTimer (whichTimer) end

--- native
---@return timer
function GetExpiredTimer () end

--- native
---@return group
function CreateGroup () end

--- native
---@param whichGroup group
function DestroyGroup (whichGroup) end

--- native
---@param whichGroup group
---@param whichUnit unit
function GroupAddUnit (whichGroup, whichUnit) end

--- native
---@param whichGroup group
---@param whichUnit unit
function GroupRemoveUnit (whichGroup, whichUnit) end

--- native
---@param whichGroup group
function GroupClear (whichGroup) end

--- native
---@param whichGroup group
---@param unitname string
---@param filter boolexpr
function GroupEnumUnitsOfType (whichGroup, unitname, filter) end

--- native
---@param whichGroup group
---@param whichPlayer player
---@param filter boolexpr
function GroupEnumUnitsOfPlayer (whichGroup, whichPlayer, filter) end

--- native
---@param whichGroup group
---@param unitname string
---@param filter boolexpr
---@param countLimit number integer
function GroupEnumUnitsOfTypeCounted (whichGroup, unitname, filter, countLimit) end

--- native
---@param whichGroup group
---@param r rect
---@param filter boolexpr
function GroupEnumUnitsInRect (whichGroup, r, filter) end

--- native
---@param whichGroup group
---@param r rect
---@param filter boolexpr
---@param countLimit number integer
function GroupEnumUnitsInRectCounted (whichGroup, r, filter, countLimit) end

--- native
---@param whichGroup group
---@param x number real
---@param y number real
---@param radius number real
---@param filter boolexpr
function GroupEnumUnitsInRange (whichGroup, x, y, radius, filter) end

--- native
---@param whichGroup group
---@param whichLocation location
---@param radius number real
---@param filter boolexpr
function GroupEnumUnitsInRangeOfLoc (whichGroup, whichLocation, radius, filter) end

--- native
---@param whichGroup group
---@param x number real
---@param y number real
---@param radius number real
---@param filter boolexpr
---@param countLimit number integer
function GroupEnumUnitsInRangeCounted (whichGroup, x, y, radius, filter, countLimit) end

--- native
---@param whichGroup group
---@param whichLocation location
---@param radius number real
---@param filter boolexpr
---@param countLimit number integer
function GroupEnumUnitsInRangeOfLocCounted (whichGroup, whichLocation, radius, filter, countLimit) end

--- native
---@param whichGroup group
---@param whichPlayer player
---@param filter boolexpr
function GroupEnumUnitsSelected (whichGroup, whichPlayer, filter) end

--- native
---@param whichGroup group
---@param order string
---@return boolean
function GroupImmediateOrder (whichGroup, order) end

--- native
---@param whichGroup group
---@param order number integer
---@return boolean
function GroupImmediateOrderById (whichGroup, order) end

--- native
---@param whichGroup group
---@param order string
---@param x number real
---@param y number real
---@return boolean
function GroupPointOrder (whichGroup, order, x, y) end

--- native
---@param whichGroup group
---@param order string
---@param whichLocation location
---@return boolean
function GroupPointOrderLoc (whichGroup, order, whichLocation) end

--- native
---@param whichGroup group
---@param order number integer
---@param x number real
---@param y number real
---@return boolean
function GroupPointOrderById (whichGroup, order, x, y) end

--- native
---@param whichGroup group
---@param order number integer
---@param whichLocation location
---@return boolean
function GroupPointOrderByIdLoc (whichGroup, order, whichLocation) end

--- native
---@param whichGroup group
---@param order string
---@param targetWidget widget
---@return boolean
function GroupTargetOrder (whichGroup, order, targetWidget) end

--- native
---@param whichGroup group
---@param order number integer
---@param targetWidget widget
---@return boolean
function GroupTargetOrderById (whichGroup, order, targetWidget) end

--- native
---@param whichGroup group
---@param callback function
function ForGroup (whichGroup, callback) end

--- native
---@param whichGroup group
---@return unit
function FirstOfGroup (whichGroup) end

--- native
---@return force
function CreateForce () end

--- native
---@param whichForce force
function DestroyForce (whichForce) end

--- native
---@param whichForce force
---@param whichPlayer player
function ForceAddPlayer (whichForce, whichPlayer) end

--- native
---@param whichForce force
---@param whichPlayer player
function ForceRemovePlayer (whichForce, whichPlayer) end

--- native
---@param whichForce force
function ForceClear (whichForce) end

--- native
---@param whichForce force
---@param filter boolexpr
function ForceEnumPlayers (whichForce, filter) end

--- native
---@param whichForce force
---@param filter boolexpr
---@param countLimit number integer
function ForceEnumPlayersCounted (whichForce, filter, countLimit) end

--- native
---@param whichForce force
---@param whichPlayer player
---@param filter boolexpr
function ForceEnumAllies (whichForce, whichPlayer, filter) end

--- native
---@param whichForce force
---@param whichPlayer player
---@param filter boolexpr
function ForceEnumEnemies (whichForce, whichPlayer, filter) end

--- native
---@param whichForce force
---@param callback function
function ForForce (whichForce, callback) end

--- native
---@param minx number real
---@param miny number real
---@param maxx number real
---@param maxy number real
---@return rect
function Rect (minx, miny, maxx, maxy) end

--- native
---@param min location
---@param max location
---@return rect
function RectFromLoc (min, max) end

--- native
---@param whichRect rect
function RemoveRect (whichRect) end

--- native
---@param whichRect rect
---@param minx number real
---@param miny number real
---@param maxx number real
---@param maxy number real
function SetRect (whichRect, minx, miny, maxx, maxy) end

--- native
---@param whichRect rect
---@param min location
---@param max location
function SetRectFromLoc (whichRect, min, max) end

--- native
---@param whichRect rect
---@param newCenterX number real
---@param newCenterY number real
function MoveRectTo (whichRect, newCenterX, newCenterY) end

--- native
---@param whichRect rect
---@param newCenterLoc location
function MoveRectToLoc (whichRect, newCenterLoc) end

--- native
---@param whichRect rect
---@return number real
function GetRectCenterX (whichRect) end

--- native
---@param whichRect rect
---@return number real
function GetRectCenterY (whichRect) end

--- native
---@param whichRect rect
---@return number real
function GetRectMinX (whichRect) end

--- native
---@param whichRect rect
---@return number real
function GetRectMinY (whichRect) end

--- native
---@param whichRect rect
---@return number real
function GetRectMaxX (whichRect) end

--- native
---@param whichRect rect
---@return number real
function GetRectMaxY (whichRect) end

--- native
---@return region
function CreateRegion () end

--- native
---@param whichRegion region
function RemoveRegion (whichRegion) end

--- native
---@param whichRegion region
---@param r rect
function RegionAddRect (whichRegion, r) end

--- native
---@param whichRegion region
---@param r rect
function RegionClearRect (whichRegion, r) end

--- native
---@param whichRegion region
---@param x number real
---@param y number real
function RegionAddCell (whichRegion, x, y) end

--- native
---@param whichRegion region
---@param whichLocation location
function RegionAddCellAtLoc (whichRegion, whichLocation) end

--- native
---@param whichRegion region
---@param x number real
---@param y number real
function RegionClearCell (whichRegion, x, y) end

--- native
---@param whichRegion region
---@param whichLocation location
function RegionClearCellAtLoc (whichRegion, whichLocation) end

--- native
---@param x number real
---@param y number real
---@return location
function Location (x, y) end

--- native
---@param whichLocation location
function RemoveLocation (whichLocation) end

--- native
---@param whichLocation location
---@param newX number real
---@param newY number real
function MoveLocation (whichLocation, newX, newY) end

--- native
---@param whichLocation location
---@return number real
function GetLocationX (whichLocation) end

--- native
---@param whichLocation location
---@return number real
function GetLocationY (whichLocation) end

--- native
---@param whichLocation location
---@return number real
function GetLocationZ (whichLocation) end

--- native
---@param whichRegion region
---@param whichUnit unit
---@return boolean
function IsUnitInRegion (whichRegion, whichUnit) end

--- native
---@param whichRegion region
---@param x number real
---@param y number real
---@return boolean
function IsPointInRegion (whichRegion, x, y) end

--- native
---@param whichRegion region
---@param whichLocation location
---@return boolean
function IsLocationInRegion (whichRegion, whichLocation) end

--- native
---@return rect
function GetWorldBounds () end

--- native
---@return trigger
function CreateTrigger () end

--- native
---@param whichTrigger trigger
function DestroyTrigger (whichTrigger) end

--- native
---@param whichTrigger trigger
function ResetTrigger (whichTrigger) end

--- native
---@param whichTrigger trigger
function EnableTrigger (whichTrigger) end

--- native
---@param whichTrigger trigger
function DisableTrigger (whichTrigger) end

--- native
---@param whichTrigger trigger
---@return boolean
function IsTriggerEnabled (whichTrigger) end

--- native
---@param whichTrigger trigger
---@param flag boolean
function TriggerWaitOnSleeps (whichTrigger, flag) end

--- native
---@param whichTrigger trigger
---@return boolean
function IsTriggerWaitOnSleeps (whichTrigger) end

--- native
---@return unit
function GetFilterUnit () end

--- native
---@return unit
function GetEnumUnit () end

--- native
---@return destructable
function GetFilterDestructable () end

--- native
---@return destructable
function GetEnumDestructable () end

--- native
---@return item
function GetFilterItem () end

--- native
---@return item
function GetEnumItem () end

--- native
---@return player
function GetFilterPlayer () end

--- native
---@return player
function GetEnumPlayer () end

--- native
---@return trigger
function GetTriggeringTrigger () end

--- native
---@return eventid
function GetTriggerEventId () end

--- native
---@param whichTrigger trigger
---@return number integer
function GetTriggerEvalCount (whichTrigger) end

--- native
---@param whichTrigger trigger
---@return number integer
function GetTriggerExecCount (whichTrigger) end

--- native
---@param funcName string
function ExecuteFunc (funcName) end

--- native
---@param operandA boolexpr
---@param operandB boolexpr
---@return boolexpr
function And (operandA, operandB) end

--- native
---@param operandA boolexpr
---@param operandB boolexpr
---@return boolexpr
function Or (operandA, operandB) end

--- native
---@param operand boolexpr
---@return boolexpr
function Not (operand) end

--- native
---@param func function
---@return conditionfunc
function Condition (func) end

--- native
---@param c conditionfunc
function DestroyCondition (c) end

--- native
---@param func function
---@return filterfunc
function Filter (func) end

--- native
---@param f filterfunc
function DestroyFilter (f) end

--- native
---@param e boolexpr
function DestroyBoolExpr (e) end

--- native
---@param whichTrigger trigger
---@param varName string
---@param opcode limitop
---@param limitval number real
---@return event
function TriggerRegisterVariableEvent (whichTrigger, varName, opcode, limitval) end

--- native
---@param whichTrigger trigger
---@param timeout number real
---@param periodic boolean
---@return event
function TriggerRegisterTimerEvent (whichTrigger, timeout, periodic) end

--- native
---@param whichTrigger trigger
---@param t timer
---@return event
function TriggerRegisterTimerExpireEvent (whichTrigger, t) end

--- native
---@param whichTrigger trigger
---@param whichState gamestate
---@param opcode limitop
---@param limitval number real
---@return event
function TriggerRegisterGameStateEvent (whichTrigger, whichState, opcode, limitval) end

--- native
---@param whichTrigger trigger
---@param whichDialog dialog
---@return event
function TriggerRegisterDialogEvent (whichTrigger, whichDialog) end

--- native
---@param whichTrigger trigger
---@param whichButton button
---@return event
function TriggerRegisterDialogButtonEvent (whichTrigger, whichButton) end

--- native
---@return gamestate
function GetEventGameState () end

--- native
---@param whichTrigger trigger
---@param whichGameEvent gameevent
---@return event
function TriggerRegisterGameEvent (whichTrigger, whichGameEvent) end

--- native
---@return player
function GetWinningPlayer () end

--- native
---@param whichTrigger trigger
---@param whichRegion region
---@param filter boolexpr
---@return event
function TriggerRegisterEnterRegion (whichTrigger, whichRegion, filter) end

--- native
---@return region
function GetTriggeringRegion () end

--- native
---@return unit
function GetEnteringUnit () end

--- native
---@param whichTrigger trigger
---@param whichRegion region
---@param filter boolexpr
---@return event
function TriggerRegisterLeaveRegion (whichTrigger, whichRegion, filter) end

--- native
---@return unit
function GetLeavingUnit () end

--- native
---@param whichTrigger trigger
---@param t trackable
---@return event
function TriggerRegisterTrackableHitEvent (whichTrigger, t) end

--- native
---@param whichTrigger trigger
---@param t trackable
---@return event
function TriggerRegisterTrackableTrackEvent (whichTrigger, t) end

--- native
---@return trackable
function GetTriggeringTrackable () end

--- native
---@return button
function GetClickedButton () end

--- native
---@return dialog
function GetClickedDialog () end

--- native
---@return number real
function GetTournamentFinishSoonTimeRemaining () end

--- native
---@return number integer
function GetTournamentFinishNowRule () end

--- native
---@return player
function GetTournamentFinishNowPlayer () end

--- native
---@param whichPlayer player
---@return number integer
function GetTournamentScore (whichPlayer) end

--- native
---@return string
function GetSaveBasicFilename () end

--- native
---@param whichTrigger trigger
---@param whichPlayer player
---@param whichPlayerEvent playerevent
---@return event
function TriggerRegisterPlayerEvent (whichTrigger, whichPlayer, whichPlayerEvent) end

--- native
---@return player
function GetTriggerPlayer () end

--- native
---@param whichTrigger trigger
---@param whichPlayer player
---@param whichPlayerUnitEvent playerunitevent
---@param filter boolexpr
---@return event
function TriggerRegisterPlayerUnitEvent (whichTrigger, whichPlayer, whichPlayerUnitEvent, filter) end

--- native
---@return unit
function GetLevelingUnit () end

--- native
---@return unit
function GetLearningUnit () end

--- native
---@return number integer
function GetLearnedSkill () end

--- native
---@return number integer
function GetLearnedSkillLevel () end

--- native
---@return unit
function GetRevivableUnit () end

--- native
---@return unit
function GetRevivingUnit () end

--- native
---@return unit
function GetAttacker () end

--- native
---@return unit
function GetRescuer () end

--- native
---@return unit
function GetDyingUnit () end

--- native
---@return unit
function GetKillingUnit () end

--- native
---@return unit
function GetDecayingUnit () end

--- native
---@return unit
function GetConstructingStructure () end

--- native
---@return unit
function GetCancelledStructure () end

--- native
---@return unit
function GetConstructedStructure () end

--- native
---@return unit
function GetResearchingUnit () end

--- native
---@return number integer
function GetResearched () end

--- native
---@return number integer
function GetTrainedUnitType () end

--- native
---@return unit
function GetTrainedUnit () end

--- native
---@return unit
function GetDetectedUnit () end

--- native
---@return unit
function GetSummoningUnit () end

--- native
---@return unit
function GetSummonedUnit () end

--- native
---@return unit
function GetTransportUnit () end

--- native
---@return unit
function GetLoadedUnit () end

--- native
---@return unit
function GetSellingUnit () end

--- native
---@return unit
function GetSoldUnit () end

--- native
---@return unit
function GetBuyingUnit () end

--- native
---@return item
function GetSoldItem () end

--- native
---@return unit
function GetChangingUnit () end

--- native
---@return player
function GetChangingUnitPrevOwner () end

--- native
---@return unit
function GetManipulatingUnit () end

--- native
---@return item
function GetManipulatedItem () end

--- native
---@return unit
function GetOrderedUnit () end

--- native
---@return number integer
function GetIssuedOrderId () end

--- native
---@return number real
function GetOrderPointX () end

--- native
---@return number real
function GetOrderPointY () end

--- native
---@return location
function GetOrderPointLoc () end

--- native
---@return widget
function GetOrderTarget () end

--- native
---@return destructable
function GetOrderTargetDestructable () end

--- native
---@return item
function GetOrderTargetItem () end

--- native
---@return unit
function GetOrderTargetUnit () end

--- native
---@return unit
function GetSpellAbilityUnit () end

--- native
---@return number integer
function GetSpellAbilityId () end

--- native
---@return ability
function GetSpellAbility () end

--- native
---@return location
function GetSpellTargetLoc () end

--- native
---@return number real
function GetSpellTargetX () end

--- native
---@return number real
function GetSpellTargetY () end

--- native
---@return destructable
function GetSpellTargetDestructable () end

--- native
---@return item
function GetSpellTargetItem () end

--- native
---@return unit
function GetSpellTargetUnit () end

--- native
---@param whichTrigger trigger
---@param whichPlayer player
---@param whichAlliance alliancetype
---@return event
function TriggerRegisterPlayerAllianceChange (whichTrigger, whichPlayer, whichAlliance) end

--- native
---@param whichTrigger trigger
---@param whichPlayer player
---@param whichState playerstate
---@param opcode limitop
---@param limitval number real
---@return event
function TriggerRegisterPlayerStateEvent (whichTrigger, whichPlayer, whichState, opcode, limitval) end

--- native
---@return playerstate
function GetEventPlayerState () end

--- native
---@param whichTrigger trigger
---@param whichPlayer player
---@param chatMessageToDetect string
---@param exactMatchOnly boolean
---@return event
function TriggerRegisterPlayerChatEvent (whichTrigger, whichPlayer, chatMessageToDetect, exactMatchOnly) end

--- native
---@return string
function GetEventPlayerChatString () end

--- native
---@return string
function GetEventPlayerChatStringMatched () end

--- native
---@param whichTrigger trigger
---@param whichWidget widget
---@return event
function TriggerRegisterDeathEvent (whichTrigger, whichWidget) end

--- native
---@return unit
function GetTriggerUnit () end

--- native
---@param whichTrigger trigger
---@param whichUnit unit
---@param whichState unitstate
---@param opcode limitop
---@param limitval number real
---@return event
function TriggerRegisterUnitStateEvent (whichTrigger, whichUnit, whichState, opcode, limitval) end

--- native
---@return unitstate
function GetEventUnitState () end

--- native
---@param whichTrigger trigger
---@param whichUnit unit
---@param whichEvent unitevent
---@return event
function TriggerRegisterUnitEvent (whichTrigger, whichUnit, whichEvent) end

--- native
---@return number real
function GetEventDamage () end

--- native
---@return unit
function GetEventDamageSource () end

--- native
---@return player
function GetEventDetectingPlayer () end

--- native
---@param whichTrigger trigger
---@param whichUnit unit
---@param whichEvent unitevent
---@param filter boolexpr
---@return event
function TriggerRegisterFilterUnitEvent (whichTrigger, whichUnit, whichEvent, filter) end

--- native
---@return unit
function GetEventTargetUnit () end

--- native
---@param whichTrigger trigger
---@param whichUnit unit
---@param range number real
---@param filter boolexpr
---@return event
function TriggerRegisterUnitInRange (whichTrigger, whichUnit, range, filter) end

--- native
---@param whichTrigger trigger
---@param condition boolexpr
---@return triggercondition
function TriggerAddCondition (whichTrigger, condition) end

--- native
---@param whichTrigger trigger
---@param whichCondition triggercondition
function TriggerRemoveCondition (whichTrigger, whichCondition) end

--- native
---@param whichTrigger trigger
function TriggerClearConditions (whichTrigger) end

--- native
---@param whichTrigger trigger
---@param actionFunc function
---@return triggeraction
function TriggerAddAction (whichTrigger, actionFunc) end

--- native
---@param whichTrigger trigger
---@param whichAction triggeraction
function TriggerRemoveAction (whichTrigger, whichAction) end

--- native
---@param whichTrigger trigger
function TriggerClearActions (whichTrigger) end

--- native
---@param timeout number real
function TriggerSleepAction (timeout) end

--- native
---@param s sound
---@param offset number real
function TriggerWaitForSound (s, offset) end

--- native
---@param whichTrigger trigger
---@return boolean
function TriggerEvaluate (whichTrigger) end

--- native
---@param whichTrigger trigger
function TriggerExecute (whichTrigger) end

--- native
---@param whichTrigger trigger
function TriggerExecuteWait (whichTrigger) end

--- native
function TriggerSyncStart () end

--- native
function TriggerSyncReady () end

--- native
---@param whichWidget widget
---@return number real
function GetWidgetLife (whichWidget) end

--- native
---@param whichWidget widget
---@param newLife number real
function SetWidgetLife (whichWidget, newLife) end

--- native
---@param whichWidget widget
---@return number real
function GetWidgetX (whichWidget) end

--- native
---@param whichWidget widget
---@return number real
function GetWidgetY (whichWidget) end

--- native
---@return widget
function GetTriggerWidget () end

--- native
---@param objectid number integer
---@param x number real
---@param y number real
---@param face number real
---@param scale number real
---@param variation number integer
---@return destructable
function CreateDestructable (objectid, x, y, face, scale, variation) end

--- native
---@param objectid number integer
---@param x number real
---@param y number real
---@param z number real
---@param face number real
---@param scale number real
---@param variation number integer
---@return destructable
function CreateDestructableZ (objectid, x, y, z, face, scale, variation) end

--- native
---@param objectid number integer
---@param x number real
---@param y number real
---@param face number real
---@param scale number real
---@param variation number integer
---@return destructable
function CreateDeadDestructable (objectid, x, y, face, scale, variation) end

--- native
---@param objectid number integer
---@param x number real
---@param y number real
---@param z number real
---@param face number real
---@param scale number real
---@param variation number integer
---@return destructable
function CreateDeadDestructableZ (objectid, x, y, z, face, scale, variation) end

--- native
---@param d destructable
function RemoveDestructable (d) end

--- native
---@param d destructable
function KillDestructable (d) end

--- native
---@param d destructable
---@param flag boolean
function SetDestructableInvulnerable (d, flag) end

--- native
---@param d destructable
---@return boolean
function IsDestructableInvulnerable (d) end

--- native
---@param r rect
---@param filter boolexpr
---@param actionFunc function
function EnumDestructablesInRect (r, filter, actionFunc) end

--- native
---@param d destructable
---@return number integer
function GetDestructableTypeId (d) end

--- native
---@param d destructable
---@return number real
function GetDestructableX (d) end

--- native
---@param d destructable
---@return number real
function GetDestructableY (d) end

--- native
---@param d destructable
---@param life number real
function SetDestructableLife (d, life) end

--- native
---@param d destructable
---@return number real
function GetDestructableLife (d) end

--- native
---@param d destructable
---@param max number real
function SetDestructableMaxLife (d, max) end

--- native
---@param d destructable
---@return number real
function GetDestructableMaxLife (d) end

--- native
---@param d destructable
---@param life number real
---@param birth boolean
function DestructableRestoreLife (d, life, birth) end

--- native
---@param d destructable
---@param whichAnimation string
function QueueDestructableAnimation (d, whichAnimation) end

--- native
---@param d destructable
---@param whichAnimation string
function SetDestructableAnimation (d, whichAnimation) end

--- native
---@param d destructable
---@param speedFactor number real
function SetDestructableAnimationSpeed (d, speedFactor) end

--- native
---@param d destructable
---@param flag boolean
function ShowDestructable (d, flag) end

--- native
---@param d destructable
---@return number real
function GetDestructableOccluderHeight (d) end

--- native
---@param d destructable
---@param height number real
function SetDestructableOccluderHeight (d, height) end

--- native
---@param d destructable
---@return string
function GetDestructableName (d) end

--- native
---@return destructable
function GetTriggerDestructable () end

--- native
---@param itemid number integer
---@param x number real
---@param y number real
---@return item
function CreateItem (itemid, x, y) end

--- native
---@param whichItem item
function RemoveItem (whichItem) end

--- native
---@param whichItem item
---@return player
function GetItemPlayer (whichItem) end

--- native
---@param i item
---@return number integer
function GetItemTypeId (i) end

--- native
---@param i item
---@return number real
function GetItemX (i) end

--- native
---@param i item
---@return number real
function GetItemY (i) end

--- native
---@param i item
---@param x number real
---@param y number real
function SetItemPosition (i, x, y) end

--- native
---@param whichItem item
---@param flag boolean
function SetItemDropOnDeath (whichItem, flag) end

--- native
---@param i item
---@param flag boolean
function SetItemDroppable (i, flag) end

--- native
---@param i item
---@param flag boolean
function SetItemPawnable (i, flag) end

--- native
---@param whichItem item
---@param whichPlayer player
---@param changeColor boolean
function SetItemPlayer (whichItem, whichPlayer, changeColor) end

--- native
---@param whichItem item
---@param flag boolean
function SetItemInvulnerable (whichItem, flag) end

--- native
---@param whichItem item
---@return boolean
function IsItemInvulnerable (whichItem) end

--- native
---@param whichItem item
---@param show boolean
function SetItemVisible (whichItem, show) end

--- native
---@param whichItem item
---@return boolean
function IsItemVisible (whichItem) end

--- native
---@param whichItem item
---@return boolean
function IsItemOwned (whichItem) end

--- native
---@param whichItem item
---@return boolean
function IsItemPowerup (whichItem) end

--- native
---@param whichItem item
---@return boolean
function IsItemSellable (whichItem) end

--- native
---@param whichItem item
---@return boolean
function IsItemPawnable (whichItem) end

--- native
---@param itemId number integer
---@return boolean
function IsItemIdPowerup (itemId) end

--- native
---@param itemId number integer
---@return boolean
function IsItemIdSellable (itemId) end

--- native
---@param itemId number integer
---@return boolean
function IsItemIdPawnable (itemId) end

--- native
---@param r rect
---@param filter boolexpr
---@param actionFunc function
function EnumItemsInRect (r, filter, actionFunc) end

--- native
---@param whichItem item
---@return number integer
function GetItemLevel (whichItem) end

--- native
---@param whichItem item
---@return itemtype
function GetItemType (whichItem) end

--- native
---@param whichItem item
---@param unitId number integer
function SetItemDropID (whichItem, unitId) end

--- native
---@param whichItem item
---@return string
function GetItemName (whichItem) end

--- native
---@param whichItem item
---@return number integer
function GetItemCharges (whichItem) end

--- native
---@param whichItem item
---@param charges number integer
function SetItemCharges (whichItem, charges) end

--- native
---@param whichItem item
---@return number integer
function GetItemUserData (whichItem) end

--- native
---@param whichItem item
---@param data number integer
function SetItemUserData (whichItem, data) end

--- native
---@param id player
---@param unitid number integer
---@param x number real
---@param y number real
---@param face number real
---@return unit
function CreateUnit (id, unitid, x, y, face) end

--- native
---@param whichPlayer player
---@param unitname string
---@param x number real
---@param y number real
---@param face number real
---@return unit
function CreateUnitByName (whichPlayer, unitname, x, y, face) end

--- native
---@param id player
---@param unitid number integer
---@param whichLocation location
---@param face number real
---@return unit
function CreateUnitAtLoc (id, unitid, whichLocation, face) end

--- native
---@param id player
---@param unitname string
---@param whichLocation location
---@param face number real
---@return unit
function CreateUnitAtLocByName (id, unitname, whichLocation, face) end

--- native
---@param whichPlayer player
---@param unitid number integer
---@param x number real
---@param y number real
---@param face number real
---@return unit
function CreateCorpse (whichPlayer, unitid, x, y, face) end

--- native
---@param whichUnit unit
function KillUnit (whichUnit) end

--- native
---@param whichUnit unit
function RemoveUnit (whichUnit) end

--- native
---@param whichUnit unit
---@param show boolean
function ShowUnit (whichUnit, show) end

--- native
---@param whichUnit unit
---@param whichUnitState unitstate
---@param newVal number real
function SetUnitState (whichUnit, whichUnitState, newVal) end

--- native
---@param whichUnit unit
---@param newX number real
function SetUnitX (whichUnit, newX) end

--- native
---@param whichUnit unit
---@param newY number real
function SetUnitY (whichUnit, newY) end

--- native
---@param whichUnit unit
---@param newX number real
---@param newY number real
function SetUnitPosition (whichUnit, newX, newY) end

--- native
---@param whichUnit unit
---@param whichLocation location
function SetUnitPositionLoc (whichUnit, whichLocation) end

--- native
---@param whichUnit unit
---@param facingAngle number real
function SetUnitFacing (whichUnit, facingAngle) end

--- native
---@param whichUnit unit
---@param facingAngle number real
---@param duration number real
function SetUnitFacingTimed (whichUnit, facingAngle, duration) end

--- native
---@param whichUnit unit
---@param newSpeed number real
function SetUnitMoveSpeed (whichUnit, newSpeed) end

--- native
---@param whichUnit unit
---@param newHeight number real
---@param rate number real
function SetUnitFlyHeight (whichUnit, newHeight, rate) end

--- native
---@param whichUnit unit
---@param newTurnSpeed number real
function SetUnitTurnSpeed (whichUnit, newTurnSpeed) end

--- native
---@param whichUnit unit
---@param newPropWindowAngle number real
function SetUnitPropWindow (whichUnit, newPropWindowAngle) end

--- native
---@param whichUnit unit
---@param newAcquireRange number real
function SetUnitAcquireRange (whichUnit, newAcquireRange) end

--- native
---@param whichUnit unit
---@param creepGuard boolean
function SetUnitCreepGuard (whichUnit, creepGuard) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitAcquireRange (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitTurnSpeed (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitPropWindow (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitFlyHeight (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitDefaultAcquireRange (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitDefaultTurnSpeed (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitDefaultPropWindow (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitDefaultFlyHeight (whichUnit) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@param changeColor boolean
function SetUnitOwner (whichUnit, whichPlayer, changeColor) end

--- native
---@param whichUnit unit
---@param whichColor playercolor
function SetUnitColor (whichUnit, whichColor) end

--- native
---@param whichUnit unit
---@param scaleX number real
---@param scaleY number real
---@param scaleZ number real
function SetUnitScale (whichUnit, scaleX, scaleY, scaleZ) end

--- native
---@param whichUnit unit
---@param timeScale number real
function SetUnitTimeScale (whichUnit, timeScale) end

--- native
---@param whichUnit unit
---@param blendTime number real
function SetUnitBlendTime (whichUnit, blendTime) end

--- native
---@param whichUnit unit
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetUnitVertexColor (whichUnit, red, green, blue, alpha) end

--- native
---@param whichUnit unit
---@param whichAnimation string
function QueueUnitAnimation (whichUnit, whichAnimation) end

--- native
---@param whichUnit unit
---@param whichAnimation string
function SetUnitAnimation (whichUnit, whichAnimation) end

--- native
---@param whichUnit unit
---@param whichAnimation number integer
function SetUnitAnimationByIndex (whichUnit, whichAnimation) end

--- native
---@param whichUnit unit
---@param whichAnimation string
---@param rarity raritycontrol
function SetUnitAnimationWithRarity (whichUnit, whichAnimation, rarity) end

--- native
---@param whichUnit unit
---@param animProperties string
---@param add boolean
function AddUnitAnimationProperties (whichUnit, animProperties, add) end

--- native
---@param whichUnit unit
---@param whichBone string
---@param lookAtTarget unit
---@param offsetX number real
---@param offsetY number real
---@param offsetZ number real
function SetUnitLookAt (whichUnit, whichBone, lookAtTarget, offsetX, offsetY, offsetZ) end

--- native
---@param whichUnit unit
function ResetUnitLookAt (whichUnit) end

--- native
---@param whichUnit unit
---@param byWhichPlayer player
---@param flag boolean
function SetUnitRescuable (whichUnit, byWhichPlayer, flag) end

--- native
---@param whichUnit unit
---@param range number real
function SetUnitRescueRange (whichUnit, range) end

--- native
---@param whichHero unit
---@param newStr number integer
---@param permanent boolean
function SetHeroStr (whichHero, newStr, permanent) end

--- native
---@param whichHero unit
---@param newAgi number integer
---@param permanent boolean
function SetHeroAgi (whichHero, newAgi, permanent) end

--- native
---@param whichHero unit
---@param newInt number integer
---@param permanent boolean
function SetHeroInt (whichHero, newInt, permanent) end

--- native
---@param whichHero unit
---@param includeBonuses boolean
---@return number integer
function GetHeroStr (whichHero, includeBonuses) end

--- native
---@param whichHero unit
---@param includeBonuses boolean
---@return number integer
function GetHeroAgi (whichHero, includeBonuses) end

--- native
---@param whichHero unit
---@param includeBonuses boolean
---@return number integer
function GetHeroInt (whichHero, includeBonuses) end

--- native
---@param whichHero unit
---@param howManyLevels number integer
---@return boolean
function UnitStripHeroLevel (whichHero, howManyLevels) end

--- native
---@param whichHero unit
---@return number integer
function GetHeroXP (whichHero) end

--- native
---@param whichHero unit
---@param newXpVal number integer
---@param showEyeCandy boolean
function SetHeroXP (whichHero, newXpVal, showEyeCandy) end

--- native
---@param whichHero unit
---@return number integer
function GetHeroSkillPoints (whichHero) end

--- native
---@param whichHero unit
---@param skillPointDelta number integer
---@return boolean
function UnitModifySkillPoints (whichHero, skillPointDelta) end

--- native
---@param whichHero unit
---@param xpToAdd number integer
---@param showEyeCandy boolean
function AddHeroXP (whichHero, xpToAdd, showEyeCandy) end

--- native
---@param whichHero unit
---@param level number integer
---@param showEyeCandy boolean
function SetHeroLevel (whichHero, level, showEyeCandy) end

--- native
---@param whichHero unit
---@return number integer
function GetHeroLevel (whichHero) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitLevel (whichUnit) end

--- native
---@param whichHero unit
---@return string
function GetHeroProperName (whichHero) end

--- native
---@param whichHero unit
---@param flag boolean
function SuspendHeroXP (whichHero, flag) end

--- native
---@param whichHero unit
---@return boolean
function IsSuspendedXP (whichHero) end

--- native
---@param whichHero unit
---@param abilcode number integer
function SelectHeroSkill (whichHero, abilcode) end

--- native
---@param whichUnit unit
---@param abilcode number integer
---@return number integer
function GetUnitAbilityLevel (whichUnit, abilcode) end

--- native
---@param whichUnit unit
---@param abilcode number integer
---@return number integer
function DecUnitAbilityLevel (whichUnit, abilcode) end

--- native
---@param whichUnit unit
---@param abilcode number integer
---@return number integer
function IncUnitAbilityLevel (whichUnit, abilcode) end

--- native
---@param whichUnit unit
---@param abilcode number integer
---@param level number integer
---@return number integer
function SetUnitAbilityLevel (whichUnit, abilcode, level) end

--- native
---@param whichHero unit
---@param x number real
---@param y number real
---@param doEyecandy boolean
---@return boolean
function ReviveHero (whichHero, x, y, doEyecandy) end

--- native
---@param whichHero unit
---@param loc location
---@param doEyecandy boolean
---@return boolean
function ReviveHeroLoc (whichHero, loc, doEyecandy) end

--- native
---@param whichUnit unit
---@param exploded boolean
function SetUnitExploded (whichUnit, exploded) end

--- native
---@param whichUnit unit
---@param flag boolean
function SetUnitInvulnerable (whichUnit, flag) end

--- native
---@param whichUnit unit
---@param flag boolean
function PauseUnit (whichUnit, flag) end

--- native
---@param whichHero unit
---@return boolean
function IsUnitPaused (whichHero) end

--- native
---@param whichUnit unit
---@param flag boolean
function SetUnitPathing (whichUnit, flag) end

--- native
function ClearSelection () end

--- native
---@param whichUnit unit
---@param flag boolean
function SelectUnit (whichUnit, flag) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitPointValue (whichUnit) end

--- native
---@param unitType number integer
---@return number integer
function GetUnitPointValueByType (unitType) end

--- native
---@param whichUnit unit
---@param whichItem item
---@return boolean
function UnitAddItem (whichUnit, whichItem) end

--- native
---@param whichUnit unit
---@param itemId number integer
---@return item
function UnitAddItemById (whichUnit, itemId) end

--- native
---@param whichUnit unit
---@param itemId number integer
---@param itemSlot number integer
---@return boolean
function UnitAddItemToSlotById (whichUnit, itemId, itemSlot) end

--- native
---@param whichUnit unit
---@param whichItem item
function UnitRemoveItem (whichUnit, whichItem) end

--- native
---@param whichUnit unit
---@param itemSlot number integer
---@return item
function UnitRemoveItemFromSlot (whichUnit, itemSlot) end

--- native
---@param whichUnit unit
---@param whichItem item
---@return boolean
function UnitHasItem (whichUnit, whichItem) end

--- native
---@param whichUnit unit
---@param itemSlot number integer
---@return item
function UnitItemInSlot (whichUnit, itemSlot) end

--- native
---@param whichUnit unit
---@return number integer
function UnitInventorySize (whichUnit) end

--- native
---@param whichUnit unit
---@param whichItem item
---@param x number real
---@param y number real
---@return boolean
function UnitDropItemPoint (whichUnit, whichItem, x, y) end

--- native
---@param whichUnit unit
---@param whichItem item
---@param slot number integer
---@return boolean
function UnitDropItemSlot (whichUnit, whichItem, slot) end

--- native
---@param whichUnit unit
---@param whichItem item
---@param target widget
---@return boolean
function UnitDropItemTarget (whichUnit, whichItem, target) end

--- native
---@param whichUnit unit
---@param whichItem item
---@return boolean
function UnitUseItem (whichUnit, whichItem) end

--- native
---@param whichUnit unit
---@param whichItem item
---@param x number real
---@param y number real
---@return boolean
function UnitUseItemPoint (whichUnit, whichItem, x, y) end

--- native
---@param whichUnit unit
---@param whichItem item
---@param target widget
---@return boolean
function UnitUseItemTarget (whichUnit, whichItem, target) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitX (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitY (whichUnit) end

--- native
---@param whichUnit unit
---@return location
function GetUnitLoc (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitFacing (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitMoveSpeed (whichUnit) end

--- native
---@param whichUnit unit
---@return number real
function GetUnitDefaultMoveSpeed (whichUnit) end

--- native
---@param whichUnit unit
---@param whichUnitState unitstate
---@return number real
function GetUnitState (whichUnit, whichUnitState) end

--- native
---@param whichUnit unit
---@return player
function GetOwningPlayer (whichUnit) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitTypeId (whichUnit) end

--- native
---@param whichUnit unit
---@return race
function GetUnitRace (whichUnit) end

--- native
---@param whichUnit unit
---@return string
function GetUnitName (whichUnit) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitFoodUsed (whichUnit) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitFoodMade (whichUnit) end

--- native
---@param unitId number integer
---@return number integer
function GetFoodMade (unitId) end

--- native
---@param unitId number integer
---@return number integer
function GetFoodUsed (unitId) end

--- native
---@param whichUnit unit
---@param useFood boolean
function SetUnitUseFood (whichUnit, useFood) end

--- native
---@param whichUnit unit
---@return location
function GetUnitRallyPoint (whichUnit) end

--- native
---@param whichUnit unit
---@return unit
function GetUnitRallyUnit (whichUnit) end

--- native
---@param whichUnit unit
---@return destructable
function GetUnitRallyDestructable (whichUnit) end

--- native
---@param whichUnit unit
---@param whichGroup group
---@return boolean
function IsUnitInGroup (whichUnit, whichGroup) end

--- native
---@param whichUnit unit
---@param whichForce force
---@return boolean
function IsUnitInForce (whichUnit, whichForce) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitOwnedByPlayer (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitAlly (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitEnemy (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitVisible (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitDetected (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitInvisible (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitFogged (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitMasked (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@return boolean
function IsUnitSelected (whichUnit, whichPlayer) end

--- native
---@param whichUnit unit
---@param whichRace race
---@return boolean
function IsUnitRace (whichUnit, whichRace) end

--- native
---@param whichUnit unit
---@param whichUnitType unittype
---@return boolean
function IsUnitType (whichUnit, whichUnitType) end

--- native
---@param whichUnit unit
---@param whichSpecifiedUnit unit
---@return boolean
function IsUnit (whichUnit, whichSpecifiedUnit) end

--- native
---@param whichUnit unit
---@param otherUnit unit
---@param distance number real
---@return boolean
function IsUnitInRange (whichUnit, otherUnit, distance) end

--- native
---@param whichUnit unit
---@param x number real
---@param y number real
---@param distance number real
---@return boolean
function IsUnitInRangeXY (whichUnit, x, y, distance) end

--- native
---@param whichUnit unit
---@param whichLocation location
---@param distance number real
---@return boolean
function IsUnitInRangeLoc (whichUnit, whichLocation, distance) end

--- native
---@param whichUnit unit
---@return boolean
function IsUnitHidden (whichUnit) end

--- native
---@param whichUnit unit
---@return boolean
function IsUnitIllusion (whichUnit) end

--- native
---@param whichUnit unit
---@param whichTransport unit
---@return boolean
function IsUnitInTransport (whichUnit, whichTransport) end

--- native
---@param whichUnit unit
---@return boolean
function IsUnitLoaded (whichUnit) end

--- native
---@param unitId number integer
---@return boolean
function IsHeroUnitId (unitId) end

--- native
---@param unitId number integer
---@param whichUnitType unittype
---@return boolean
function IsUnitIdType (unitId, whichUnitType) end

--- native
---@param whichUnit unit
---@param whichPlayer player
---@param share boolean
function UnitShareVision (whichUnit, whichPlayer, share) end

--- native
---@param whichUnit unit
---@param suspend boolean
function UnitSuspendDecay (whichUnit, suspend) end

--- native
---@param whichUnit unit
---@param whichUnitType unittype
---@return boolean
function UnitAddType (whichUnit, whichUnitType) end

--- native
---@param whichUnit unit
---@param whichUnitType unittype
---@return boolean
function UnitRemoveType (whichUnit, whichUnitType) end

--- native
---@param whichUnit unit
---@param abilityId number integer
---@return boolean
function UnitAddAbility (whichUnit, abilityId) end

--- native
---@param whichUnit unit
---@param abilityId number integer
---@return boolean
function UnitRemoveAbility (whichUnit, abilityId) end

--- native
---@param whichUnit unit
---@param permanent boolean
---@param abilityId number integer
---@return boolean
function UnitMakeAbilityPermanent (whichUnit, permanent, abilityId) end

--- native
---@param whichUnit unit
---@param removePositive boolean
---@param removeNegative boolean
function UnitRemoveBuffs (whichUnit, removePositive, removeNegative) end

--- native
---@param whichUnit unit
---@param removePositive boolean
---@param removeNegative boolean
---@param magic boolean
---@param physical boolean
---@param timedLife boolean
---@param aura boolean
---@param autoDispel boolean
function UnitRemoveBuffsEx (whichUnit, removePositive, removeNegative, magic, physical, timedLife, aura, autoDispel) end

--- native
---@param whichUnit unit
---@param removePositive boolean
---@param removeNegative boolean
---@param magic boolean
---@param physical boolean
---@param timedLife boolean
---@param aura boolean
---@param autoDispel boolean
---@return boolean
function UnitHasBuffsEx (whichUnit, removePositive, removeNegative, magic, physical, timedLife, aura, autoDispel) end

--- native
---@param whichUnit unit
---@param removePositive boolean
---@param removeNegative boolean
---@param magic boolean
---@param physical boolean
---@param timedLife boolean
---@param aura boolean
---@param autoDispel boolean
---@return number integer
function UnitCountBuffsEx (whichUnit, removePositive, removeNegative, magic, physical, timedLife, aura, autoDispel) end

--- native
---@param whichUnit unit
---@param add boolean
function UnitAddSleep (whichUnit, add) end

--- native
---@param whichUnit unit
---@return boolean
function UnitCanSleep (whichUnit) end

--- native
---@param whichUnit unit
---@param add boolean
function UnitAddSleepPerm (whichUnit, add) end

--- native
---@param whichUnit unit
---@return boolean
function UnitCanSleepPerm (whichUnit) end

--- native
---@param whichUnit unit
---@return boolean
function UnitIsSleeping (whichUnit) end

--- native
---@param whichUnit unit
function UnitWakeUp (whichUnit) end

--- native
---@param whichUnit unit
---@param buffId number integer
---@param duration number real
function UnitApplyTimedLife (whichUnit, buffId, duration) end

--- native
---@param whichUnit unit
---@param flag boolean
---@return boolean
function UnitIgnoreAlarm (whichUnit, flag) end

--- native
---@param whichUnit unit
---@return boolean
function UnitIgnoreAlarmToggled (whichUnit) end

--- native
---@param whichUnit unit
function UnitResetCooldown (whichUnit) end

--- native
---@param whichUnit unit
---@param constructionPercentage number integer
function UnitSetConstructionProgress (whichUnit, constructionPercentage) end

--- native
---@param whichUnit unit
---@param upgradePercentage number integer
function UnitSetUpgradeProgress (whichUnit, upgradePercentage) end

--- native
---@param whichUnit unit
---@param flag boolean
function UnitPauseTimedLife (whichUnit, flag) end

--- native
---@param whichUnit unit
---@param flag boolean
function UnitSetUsesAltIcon (whichUnit, flag) end

--- native
---@param whichUnit unit
---@param delay number real
---@param radius number real
---@param x number real
---@param y number real
---@param amount number real
---@param attack boolean
---@param ranged boolean
---@param attackType attacktype
---@param damageType damagetype
---@param weaponType weapontype
---@return boolean
function UnitDamagePoint (whichUnit, delay, radius, x, y, amount, attack, ranged, attackType, damageType, weaponType) end

--- native
---@param whichUnit unit
---@param target widget
---@param amount number real
---@param attack boolean
---@param ranged boolean
---@param attackType attacktype
---@param damageType damagetype
---@param weaponType weapontype
---@return boolean
function UnitDamageTarget (whichUnit, target, amount, attack, ranged, attackType, damageType, weaponType) end

--- native
---@param whichUnit unit
---@param order string
---@return boolean
function IssueImmediateOrder (whichUnit, order) end

--- native
---@param whichUnit unit
---@param order number integer
---@return boolean
function IssueImmediateOrderById (whichUnit, order) end

--- native
---@param whichUnit unit
---@param order string
---@param x number real
---@param y number real
---@return boolean
function IssuePointOrder (whichUnit, order, x, y) end

--- native
---@param whichUnit unit
---@param order string
---@param whichLocation location
---@return boolean
function IssuePointOrderLoc (whichUnit, order, whichLocation) end

--- native
---@param whichUnit unit
---@param order number integer
---@param x number real
---@param y number real
---@return boolean
function IssuePointOrderById (whichUnit, order, x, y) end

--- native
---@param whichUnit unit
---@param order number integer
---@param whichLocation location
---@return boolean
function IssuePointOrderByIdLoc (whichUnit, order, whichLocation) end

--- native
---@param whichUnit unit
---@param order string
---@param targetWidget widget
---@return boolean
function IssueTargetOrder (whichUnit, order, targetWidget) end

--- native
---@param whichUnit unit
---@param order number integer
---@param targetWidget widget
---@return boolean
function IssueTargetOrderById (whichUnit, order, targetWidget) end

--- native
---@param whichUnit unit
---@param order string
---@param x number real
---@param y number real
---@param instantTargetWidget widget
---@return boolean
function IssueInstantPointOrder (whichUnit, order, x, y, instantTargetWidget) end

--- native
---@param whichUnit unit
---@param order number integer
---@param x number real
---@param y number real
---@param instantTargetWidget widget
---@return boolean
function IssueInstantPointOrderById (whichUnit, order, x, y, instantTargetWidget) end

--- native
---@param whichUnit unit
---@param order string
---@param targetWidget widget
---@param instantTargetWidget widget
---@return boolean
function IssueInstantTargetOrder (whichUnit, order, targetWidget, instantTargetWidget) end

--- native
---@param whichUnit unit
---@param order number integer
---@param targetWidget widget
---@param instantTargetWidget widget
---@return boolean
function IssueInstantTargetOrderById (whichUnit, order, targetWidget, instantTargetWidget) end

--- native
---@param whichPeon unit
---@param unitToBuild string
---@param x number real
---@param y number real
---@return boolean
function IssueBuildOrder (whichPeon, unitToBuild, x, y) end

--- native
---@param whichPeon unit
---@param unitId number integer
---@param x number real
---@param y number real
---@return boolean
function IssueBuildOrderById (whichPeon, unitId, x, y) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitToBuild string
---@return boolean
function IssueNeutralImmediateOrder (forWhichPlayer, neutralStructure, unitToBuild) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitId number integer
---@return boolean
function IssueNeutralImmediateOrderById (forWhichPlayer, neutralStructure, unitId) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitToBuild string
---@param x number real
---@param y number real
---@return boolean
function IssueNeutralPointOrder (forWhichPlayer, neutralStructure, unitToBuild, x, y) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitId number integer
---@param x number real
---@param y number real
---@return boolean
function IssueNeutralPointOrderById (forWhichPlayer, neutralStructure, unitId, x, y) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitToBuild string
---@param target widget
---@return boolean
function IssueNeutralTargetOrder (forWhichPlayer, neutralStructure, unitToBuild, target) end

--- native
---@param forWhichPlayer player
---@param neutralStructure unit
---@param unitId number integer
---@param target widget
---@return boolean
function IssueNeutralTargetOrderById (forWhichPlayer, neutralStructure, unitId, target) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitCurrentOrder (whichUnit) end

--- native
---@param whichUnit unit
---@param amount number integer
function SetResourceAmount (whichUnit, amount) end

--- native
---@param whichUnit unit
---@param amount number integer
function AddResourceAmount (whichUnit, amount) end

--- native
---@param whichUnit unit
---@return number integer
function GetResourceAmount (whichUnit) end

--- native
---@param waygate unit
---@return number real
function WaygateGetDestinationX (waygate) end

--- native
---@param waygate unit
---@return number real
function WaygateGetDestinationY (waygate) end

--- native
---@param waygate unit
---@param x number real
---@param y number real
function WaygateSetDestination (waygate, x, y) end

--- native
---@param waygate unit
---@param activate boolean
function WaygateActivate (waygate, activate) end

--- native
---@param waygate unit
---@return boolean
function WaygateIsActive (waygate) end

--- native
---@param itemId number integer
---@param currentStock number integer
---@param stockMax number integer
function AddItemToAllStock (itemId, currentStock, stockMax) end

--- native
---@param whichUnit unit
---@param itemId number integer
---@param currentStock number integer
---@param stockMax number integer
function AddItemToStock (whichUnit, itemId, currentStock, stockMax) end

--- native
---@param unitId number integer
---@param currentStock number integer
---@param stockMax number integer
function AddUnitToAllStock (unitId, currentStock, stockMax) end

--- native
---@param whichUnit unit
---@param unitId number integer
---@param currentStock number integer
---@param stockMax number integer
function AddUnitToStock (whichUnit, unitId, currentStock, stockMax) end

--- native
---@param itemId number integer
function RemoveItemFromAllStock (itemId) end

--- native
---@param whichUnit unit
---@param itemId number integer
function RemoveItemFromStock (whichUnit, itemId) end

--- native
---@param unitId number integer
function RemoveUnitFromAllStock (unitId) end

--- native
---@param whichUnit unit
---@param unitId number integer
function RemoveUnitFromStock (whichUnit, unitId) end

--- native
---@param slots number integer
function SetAllItemTypeSlots (slots) end

--- native
---@param slots number integer
function SetAllUnitTypeSlots (slots) end

--- native
---@param whichUnit unit
---@param slots number integer
function SetItemTypeSlots (whichUnit, slots) end

--- native
---@param whichUnit unit
---@param slots number integer
function SetUnitTypeSlots (whichUnit, slots) end

--- native
---@param whichUnit unit
---@return number integer
function GetUnitUserData (whichUnit) end

--- native
---@param whichUnit unit
---@param data number integer
function SetUnitUserData (whichUnit, data) end

--- native
---@param number number integer
---@return player
function Player (number) end

--- native
---@return player
function GetLocalPlayer () end

--- native
---@param whichPlayer player
---@param otherPlayer player
---@return boolean
function IsPlayerAlly (whichPlayer, otherPlayer) end

--- native
---@param whichPlayer player
---@param otherPlayer player
---@return boolean
function IsPlayerEnemy (whichPlayer, otherPlayer) end

--- native
---@param whichPlayer player
---@param whichForce force
---@return boolean
function IsPlayerInForce (whichPlayer, whichForce) end

--- native
---@param whichPlayer player
---@return boolean
function IsPlayerObserver (whichPlayer) end

--- native
---@param x number real
---@param y number real
---@param whichPlayer player
---@return boolean
function IsVisibleToPlayer (x, y, whichPlayer) end

--- native
---@param whichLocation location
---@param whichPlayer player
---@return boolean
function IsLocationVisibleToPlayer (whichLocation, whichPlayer) end

--- native
---@param x number real
---@param y number real
---@param whichPlayer player
---@return boolean
function IsFoggedToPlayer (x, y, whichPlayer) end

--- native
---@param whichLocation location
---@param whichPlayer player
---@return boolean
function IsLocationFoggedToPlayer (whichLocation, whichPlayer) end

--- native
---@param x number real
---@param y number real
---@param whichPlayer player
---@return boolean
function IsMaskedToPlayer (x, y, whichPlayer) end

--- native
---@param whichLocation location
---@param whichPlayer player
---@return boolean
function IsLocationMaskedToPlayer (whichLocation, whichPlayer) end

--- native
---@param whichPlayer player
---@return race
function GetPlayerRace (whichPlayer) end

--- native
---@param whichPlayer player
---@return number integer
function GetPlayerId (whichPlayer) end

--- native
---@param whichPlayer player
---@param includeIncomplete boolean
---@return number integer
function GetPlayerUnitCount (whichPlayer, includeIncomplete) end

--- native
---@param whichPlayer player
---@param unitName string
---@param includeIncomplete boolean
---@param includeUpgrades boolean
---@return number integer
function GetPlayerTypedUnitCount (whichPlayer, unitName, includeIncomplete, includeUpgrades) end

--- native
---@param whichPlayer player
---@param includeIncomplete boolean
---@return number integer
function GetPlayerStructureCount (whichPlayer, includeIncomplete) end

--- native
---@param whichPlayer player
---@param whichPlayerState playerstate
---@return number integer
function GetPlayerState (whichPlayer, whichPlayerState) end

--- native
---@param whichPlayer player
---@param whichPlayerScore playerscore
---@return number integer
function GetPlayerScore (whichPlayer, whichPlayerScore) end

--- native
---@param sourcePlayer player
---@param otherPlayer player
---@param whichAllianceSetting alliancetype
---@return boolean
function GetPlayerAlliance (sourcePlayer, otherPlayer, whichAllianceSetting) end

--- native
---@param whichPlayer player
---@return number real
function GetPlayerHandicap (whichPlayer) end

--- native
---@param whichPlayer player
---@return number real
function GetPlayerHandicapXP (whichPlayer) end

--- native
---@param whichPlayer player
---@param handicap number real
function SetPlayerHandicap (whichPlayer, handicap) end

--- native
---@param whichPlayer player
---@param handicap number real
function SetPlayerHandicapXP (whichPlayer, handicap) end

--- native
---@param whichPlayer player
---@param techid number integer
---@param maximum number integer
function SetPlayerTechMaxAllowed (whichPlayer, techid, maximum) end

--- native
---@param whichPlayer player
---@param techid number integer
---@return number integer
function GetPlayerTechMaxAllowed (whichPlayer, techid) end

--- native
---@param whichPlayer player
---@param techid number integer
---@param levels number integer
function AddPlayerTechResearched (whichPlayer, techid, levels) end

--- native
---@param whichPlayer player
---@param techid number integer
---@param setToLevel number integer
function SetPlayerTechResearched (whichPlayer, techid, setToLevel) end

--- native
---@param whichPlayer player
---@param techid number integer
---@param specificonly boolean
---@return boolean
function GetPlayerTechResearched (whichPlayer, techid, specificonly) end

--- native
---@param whichPlayer player
---@param techid number integer
---@param specificonly boolean
---@return number integer
function GetPlayerTechCount (whichPlayer, techid, specificonly) end

--- native
---@param whichPlayer player
---@param newOwner number integer
function SetPlayerUnitsOwner (whichPlayer, newOwner) end

--- native
---@param whichPlayer player
---@param toWhichPlayers force
---@param flag boolean
function CripplePlayer (whichPlayer, toWhichPlayers, flag) end

--- native
---@param whichPlayer player
---@param abilid number integer
---@param avail boolean
function SetPlayerAbilityAvailable (whichPlayer, abilid, avail) end

--- native
---@param whichPlayer player
---@param whichPlayerState playerstate
---@param value number integer
function SetPlayerState (whichPlayer, whichPlayerState, value) end

--- native
---@param whichPlayer player
---@param gameResult playergameresult
function RemovePlayer (whichPlayer, gameResult) end

--- native
---@param whichPlayer player
function CachePlayerHeroData (whichPlayer) end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param where rect
---@param useSharedVision boolean
function SetFogStateRect (forWhichPlayer, whichState, where, useSharedVision) end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param centerx number real
---@param centerY number real
---@param radius number real
---@param useSharedVision boolean
function SetFogStateRadius (forWhichPlayer, whichState, centerx, centerY, radius, useSharedVision) end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param center location
---@param radius number real
---@param useSharedVision boolean
function SetFogStateRadiusLoc (forWhichPlayer, whichState, center, radius, useSharedVision) end

--- native
---@param enable boolean
function FogMaskEnable (enable) end

--- native
---@return boolean
function IsFogMaskEnabled () end

--- native
---@param enable boolean
function FogEnable (enable) end

--- native
---@return boolean
function IsFogEnabled () end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param where rect
---@param useSharedVision boolean
---@param afterUnits boolean
---@return fogmodifier
function CreateFogModifierRect (forWhichPlayer, whichState, where, useSharedVision, afterUnits) end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param centerx number real
---@param centerY number real
---@param radius number real
---@param useSharedVision boolean
---@param afterUnits boolean
---@return fogmodifier
function CreateFogModifierRadius (forWhichPlayer, whichState, centerx, centerY, radius, useSharedVision, afterUnits) end

--- native
---@param forWhichPlayer player
---@param whichState fogstate
---@param center location
---@param radius number real
---@param useSharedVision boolean
---@param afterUnits boolean
---@return fogmodifier
function CreateFogModifierRadiusLoc (forWhichPlayer, whichState, center, radius, useSharedVision, afterUnits) end

--- native
---@param whichFogModifier fogmodifier
function DestroyFogModifier (whichFogModifier) end

--- native
---@param whichFogModifier fogmodifier
function FogModifierStart (whichFogModifier) end

--- native
---@param whichFogModifier fogmodifier
function FogModifierStop (whichFogModifier) end

--- native
---@return version
function VersionGet () end

--- native
---@param whichVersion version
---@return boolean
function VersionCompatible (whichVersion) end

--- native
---@param whichVersion version
---@return boolean
function VersionSupported (whichVersion) end

--- native
---@param doScoreScreen boolean
function EndGame (doScoreScreen) end

--- native
---@param newLevel string
---@param doScoreScreen boolean
function ChangeLevel (newLevel, doScoreScreen) end

--- native
---@param doScoreScreen boolean
function RestartGame (doScoreScreen) end

--- native
function ReloadGame () end

--- native
---@param r race
function SetCampaignMenuRace (r) end

--- native
---@param campaignIndex number integer
function SetCampaignMenuRaceEx (campaignIndex) end

--- native
function ForceCampaignSelectScreen () end

--- native
---@param saveFileName string
---@param doScoreScreen boolean
function LoadGame (saveFileName, doScoreScreen) end

--- native
---@param saveFileName string
function SaveGame (saveFileName) end

--- native
---@param sourceDirName string
---@param destDirName string
---@return boolean
function RenameSaveDirectory (sourceDirName, destDirName) end

--- native
---@param sourceDirName string
---@return boolean
function RemoveSaveDirectory (sourceDirName) end

--- native
---@param sourceSaveName string
---@param destSaveName string
---@return boolean
function CopySaveGame (sourceSaveName, destSaveName) end

--- native
---@param saveName string
---@return boolean
function SaveGameExists (saveName) end

--- native
function SyncSelections () end

--- native
---@param whichFloatGameState fgamestate
---@param value number real
function SetFloatGameState (whichFloatGameState, value) end

--- native
---@param whichFloatGameState fgamestate
---@return number real
function GetFloatGameState (whichFloatGameState) end

--- native
---@param whichIntegerGameState igamestate
---@param value number integer
function SetIntegerGameState (whichIntegerGameState, value) end

--- native
---@param whichIntegerGameState igamestate
---@return number integer
function GetIntegerGameState (whichIntegerGameState) end

--- native
---@param cleared boolean
function SetTutorialCleared (cleared) end

--- native
---@param campaignNumber number integer
---@param missionNumber number integer
---@param available boolean
function SetMissionAvailable (campaignNumber, missionNumber, available) end

--- native
---@param campaignNumber number integer
---@param available boolean
function SetCampaignAvailable (campaignNumber, available) end

--- native
---@param campaignNumber number integer
---@param available boolean
function SetOpCinematicAvailable (campaignNumber, available) end

--- native
---@param campaignNumber number integer
---@param available boolean
function SetEdCinematicAvailable (campaignNumber, available) end

--- native
---@return gamedifficulty
function GetDefaultDifficulty () end

--- native
---@param g gamedifficulty
function SetDefaultDifficulty (g) end

--- native
---@param whichButton number integer
---@param visible boolean
function SetCustomCampaignButtonVisible (whichButton, visible) end

--- native
---@param whichButton number integer
---@return boolean
function GetCustomCampaignButtonVisible (whichButton) end

--- native
function DoNotSaveReplay () end

--- native
---@return dialog
function DialogCreate () end

--- native
---@param whichDialog dialog
function DialogDestroy (whichDialog) end

--- native
---@param whichDialog dialog
function DialogClear (whichDialog) end

--- native
---@param whichDialog dialog
---@param messageText string
function DialogSetMessage (whichDialog, messageText) end

--- native
---@param whichDialog dialog
---@param buttonText string
---@param hotkey number integer
---@return button
function DialogAddButton (whichDialog, buttonText, hotkey) end

--- native
---@param whichDialog dialog
---@param doScoreScreen boolean
---@param buttonText string
---@param hotkey number integer
---@return button
function DialogAddQuitButton (whichDialog, doScoreScreen, buttonText, hotkey) end

--- native
---@param whichPlayer player
---@param whichDialog dialog
---@param flag boolean
function DialogDisplay (whichPlayer, whichDialog, flag) end

--- native
---@return boolean
function ReloadGameCachesFromDisk () end

--- native
---@param campaignFile string
---@return gamecache
function InitGameCache (campaignFile) end

--- native
---@param whichCache gamecache
---@return boolean
function SaveGameCache (whichCache) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param value number integer
function StoreInteger (cache, missionKey, key, value) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param value number real
function StoreReal (cache, missionKey, key, value) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param value boolean
function StoreBoolean (cache, missionKey, key, value) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param whichUnit unit
---@return boolean
function StoreUnit (cache, missionKey, key, whichUnit) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param value string
---@return boolean
function StoreString (cache, missionKey, key, value) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function SyncStoredInteger (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function SyncStoredReal (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function SyncStoredBoolean (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function SyncStoredUnit (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function SyncStoredString (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function HaveStoredInteger (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function HaveStoredReal (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function HaveStoredBoolean (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function HaveStoredUnit (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function HaveStoredString (cache, missionKey, key) end

--- native
---@param cache gamecache
function FlushGameCache (cache) end

--- native
---@param cache gamecache
---@param missionKey string
function FlushStoredMission (cache, missionKey) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function FlushStoredInteger (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function FlushStoredReal (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function FlushStoredBoolean (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function FlushStoredUnit (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
function FlushStoredString (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return number integer
function GetStoredInteger (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return number real
function GetStoredReal (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return boolean
function GetStoredBoolean (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@return string
function GetStoredString (cache, missionKey, key) end

--- native
---@param cache gamecache
---@param missionKey string
---@param key string
---@param forWhichPlayer player
---@param x number real
---@param y number real
---@param facing number real
---@return unit
function RestoreUnit (cache, missionKey, key, forWhichPlayer, x, y, facing) end

--- native
---@return hashtable
function InitHashtable () end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param value number integer
function SaveInteger (table, parentKey, childKey, value) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param value number real
function SaveReal (table, parentKey, childKey, value) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param value boolean
function SaveBoolean (table, parentKey, childKey, value) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param value string
---@return boolean
function SaveStr (table, parentKey, childKey, value) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichPlayer player
---@return boolean
function SavePlayerHandle (table, parentKey, childKey, whichPlayer) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichWidget widget
---@return boolean
function SaveWidgetHandle (table, parentKey, childKey, whichWidget) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichDestructable destructable
---@return boolean
function SaveDestructableHandle (table, parentKey, childKey, whichDestructable) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichItem item
---@return boolean
function SaveItemHandle (table, parentKey, childKey, whichItem) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichUnit unit
---@return boolean
function SaveUnitHandle (table, parentKey, childKey, whichUnit) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichAbility ability
---@return boolean
function SaveAbilityHandle (table, parentKey, childKey, whichAbility) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTimer timer
---@return boolean
function SaveTimerHandle (table, parentKey, childKey, whichTimer) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTrigger trigger
---@return boolean
function SaveTriggerHandle (table, parentKey, childKey, whichTrigger) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTriggercondition triggercondition
---@return boolean
function SaveTriggerConditionHandle (table, parentKey, childKey, whichTriggercondition) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTriggeraction triggeraction
---@return boolean
function SaveTriggerActionHandle (table, parentKey, childKey, whichTriggeraction) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichEvent event
---@return boolean
function SaveTriggerEventHandle (table, parentKey, childKey, whichEvent) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichForce force
---@return boolean
function SaveForceHandle (table, parentKey, childKey, whichForce) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichGroup group
---@return boolean
function SaveGroupHandle (table, parentKey, childKey, whichGroup) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichLocation location
---@return boolean
function SaveLocationHandle (table, parentKey, childKey, whichLocation) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichRect rect
---@return boolean
function SaveRectHandle (table, parentKey, childKey, whichRect) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichBoolexpr boolexpr
---@return boolean
function SaveBooleanExprHandle (table, parentKey, childKey, whichBoolexpr) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichSound sound
---@return boolean
function SaveSoundHandle (table, parentKey, childKey, whichSound) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichEffect effect
---@return boolean
function SaveEffectHandle (table, parentKey, childKey, whichEffect) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichUnitpool unitpool
---@return boolean
function SaveUnitPoolHandle (table, parentKey, childKey, whichUnitpool) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichItempool itempool
---@return boolean
function SaveItemPoolHandle (table, parentKey, childKey, whichItempool) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichQuest quest
---@return boolean
function SaveQuestHandle (table, parentKey, childKey, whichQuest) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichQuestitem questitem
---@return boolean
function SaveQuestItemHandle (table, parentKey, childKey, whichQuestitem) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichDefeatcondition defeatcondition
---@return boolean
function SaveDefeatConditionHandle (table, parentKey, childKey, whichDefeatcondition) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTimerdialog timerdialog
---@return boolean
function SaveTimerDialogHandle (table, parentKey, childKey, whichTimerdialog) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichLeaderboard leaderboard
---@return boolean
function SaveLeaderboardHandle (table, parentKey, childKey, whichLeaderboard) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichMultiboard multiboard
---@return boolean
function SaveMultiboardHandle (table, parentKey, childKey, whichMultiboard) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichMultiboarditem multiboarditem
---@return boolean
function SaveMultiboardItemHandle (table, parentKey, childKey, whichMultiboarditem) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTrackable trackable
---@return boolean
function SaveTrackableHandle (table, parentKey, childKey, whichTrackable) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichDialog dialog
---@return boolean
function SaveDialogHandle (table, parentKey, childKey, whichDialog) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichButton button
---@return boolean
function SaveButtonHandle (table, parentKey, childKey, whichButton) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichTexttag texttag
---@return boolean
function SaveTextTagHandle (table, parentKey, childKey, whichTexttag) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichLightning lightning
---@return boolean
function SaveLightningHandle (table, parentKey, childKey, whichLightning) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichImage image
---@return boolean
function SaveImageHandle (table, parentKey, childKey, whichImage) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichUbersplat ubersplat
---@return boolean
function SaveUbersplatHandle (table, parentKey, childKey, whichUbersplat) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichRegion region
---@return boolean
function SaveRegionHandle (table, parentKey, childKey, whichRegion) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichFogState fogstate
---@return boolean
function SaveFogStateHandle (table, parentKey, childKey, whichFogState) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichFogModifier fogmodifier
---@return boolean
function SaveFogModifierHandle (table, parentKey, childKey, whichFogModifier) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichAgent agent
---@return boolean
function SaveAgentHandle (table, parentKey, childKey, whichAgent) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@param whichHashtable hashtable
---@return boolean
function SaveHashtableHandle (table, parentKey, childKey, whichHashtable) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return number integer
function LoadInteger (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return number real
function LoadReal (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function LoadBoolean (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return string
function LoadStr (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return player
function LoadPlayerHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return widget
function LoadWidgetHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return destructable
function LoadDestructableHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return item
function LoadItemHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return unit
function LoadUnitHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return ability
function LoadAbilityHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return timer
function LoadTimerHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return trigger
function LoadTriggerHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return triggercondition
function LoadTriggerConditionHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return triggeraction
function LoadTriggerActionHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return event
function LoadTriggerEventHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return force
function LoadForceHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return group
function LoadGroupHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return location
function LoadLocationHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return rect
function LoadRectHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolexpr
function LoadBooleanExprHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return sound
function LoadSoundHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return effect
function LoadEffectHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return unitpool
function LoadUnitPoolHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return itempool
function LoadItemPoolHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return quest
function LoadQuestHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return questitem
function LoadQuestItemHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return defeatcondition
function LoadDefeatConditionHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return timerdialog
function LoadTimerDialogHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return leaderboard
function LoadLeaderboardHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return multiboard
function LoadMultiboardHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return multiboarditem
function LoadMultiboardItemHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return trackable
function LoadTrackableHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return dialog
function LoadDialogHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return button
function LoadButtonHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return texttag
function LoadTextTagHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return lightning
function LoadLightningHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return image
function LoadImageHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return ubersplat
function LoadUbersplatHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return region
function LoadRegionHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return fogstate
function LoadFogStateHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return fogmodifier
function LoadFogModifierHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return hashtable
function LoadHashtableHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function HaveSavedInteger (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function HaveSavedReal (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function HaveSavedBoolean (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function HaveSavedString (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
---@return boolean
function HaveSavedHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
function RemoveSavedInteger (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
function RemoveSavedReal (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
function RemoveSavedBoolean (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
function RemoveSavedString (table, parentKey, childKey) end

--- native
---@param table hashtable
---@param parentKey number integer
---@param childKey number integer
function RemoveSavedHandle (table, parentKey, childKey) end

--- native
---@param table hashtable
function FlushParentHashtable (table) end

--- native
---@param table hashtable
---@param parentKey number integer
function FlushChildHashtable (table, parentKey) end

--- native
---@param lowBound number integer
---@param highBound number integer
---@return number integer
function GetRandomInt (lowBound, highBound) end

--- native
---@param lowBound number real
---@param highBound number real
---@return number real
function GetRandomReal (lowBound, highBound) end

--- native
---@return unitpool
function CreateUnitPool () end

--- native
---@param whichPool unitpool
function DestroyUnitPool (whichPool) end

--- native
---@param whichPool unitpool
---@param unitId number integer
---@param weight number real
function UnitPoolAddUnitType (whichPool, unitId, weight) end

--- native
---@param whichPool unitpool
---@param unitId number integer
function UnitPoolRemoveUnitType (whichPool, unitId) end

--- native
---@param whichPool unitpool
---@param forWhichPlayer player
---@param x number real
---@param y number real
---@param facing number real
---@return unit
function PlaceRandomUnit (whichPool, forWhichPlayer, x, y, facing) end

--- native
---@return itempool
function CreateItemPool () end

--- native
---@param whichItemPool itempool
function DestroyItemPool (whichItemPool) end

--- native
---@param whichItemPool itempool
---@param itemId number integer
---@param weight number real
function ItemPoolAddItemType (whichItemPool, itemId, weight) end

--- native
---@param whichItemPool itempool
---@param itemId number integer
function ItemPoolRemoveItemType (whichItemPool, itemId) end

--- native
---@param whichItemPool itempool
---@param x number real
---@param y number real
---@return item
function PlaceRandomItem (whichItemPool, x, y) end

--- native
---@param level number integer
---@return number integer
function ChooseRandomCreep (level) end

--- native
---@return number integer
function ChooseRandomNPBuilding () end

--- native
---@param level number integer
---@return number integer
function ChooseRandomItem (level) end

--- native
---@param whichType itemtype
---@param level number integer
---@return number integer
function ChooseRandomItemEx (whichType, level) end

--- native
---@param seed number integer
function SetRandomSeed (seed) end

--- native
---@param a number real
---@param b number real
---@param c number real
---@param d number real
---@param e number real
function SetTerrainFog (a, b, c, d, e) end

--- native
function ResetTerrainFog () end

--- native
---@param a number real
---@param b number real
---@param c number real
---@param d number real
---@param e number real
function SetUnitFog (a, b, c, d, e) end

--- native
---@param style number integer
---@param zstart number real
---@param zend number real
---@param density number real
---@param red number real
---@param green number real
---@param blue number real
function SetTerrainFogEx (style, zstart, zend, density, red, green, blue) end

--- native
---@param toPlayer player
---@param x number real
---@param y number real
---@param message string
function DisplayTextToPlayer (toPlayer, x, y, message) end

--- native
---@param toPlayer player
---@param x number real
---@param y number real
---@param duration number real
---@param message string
function DisplayTimedTextToPlayer (toPlayer, x, y, duration, message) end

--- native
---@param toPlayer player
---@param x number real
---@param y number real
---@param duration number real
---@param message string
function DisplayTimedTextFromPlayer (toPlayer, x, y, duration, message) end

--- native
function ClearTextMessages () end

--- native
---@param terrainDNCFile string
---@param unitDNCFile string
function SetDayNightModels (terrainDNCFile, unitDNCFile) end

--- native
---@param skyModelFile string
function SetSkyModel (skyModelFile) end

--- native
---@param b boolean
function EnableUserControl (b) end

--- native
---@param b boolean
function EnableUserUI (b) end

--- native
---@param b boolean
function SuspendTimeOfDay (b) end

--- native
---@param r number real
function SetTimeOfDayScale (r) end

--- native
---@return number real
function GetTimeOfDayScale () end

--- native
---@param flag boolean
---@param fadeDuration number real
function ShowInterface (flag, fadeDuration) end

--- native
---@param flag boolean
function PauseGame (flag) end

--- native
---@param whichUnit unit
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function UnitAddIndicator (whichUnit, red, green, blue, alpha) end

--- native
---@param whichWidget widget
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function AddIndicator (whichWidget, red, green, blue, alpha) end

--- native
---@param x number real
---@param y number real
---@param duration number real
function PingMinimap (x, y, duration) end

--- native
---@param x number real
---@param y number real
---@param duration number real
---@param red number integer
---@param green number integer
---@param blue number integer
---@param extraEffects boolean
function PingMinimapEx (x, y, duration, red, green, blue, extraEffects) end

--- native
---@param flag boolean
function EnableOcclusion (flag) end

--- native
---@param introText string
function SetIntroShotText (introText) end

--- native
---@param introModelPath string
function SetIntroShotModel (introModelPath) end

--- native
---@param b boolean
function EnableWorldFogBoundary (b) end

--- native
---@param modelName string
function PlayModelCinematic (modelName) end

--- native
---@param movieName string
function PlayCinematic (movieName) end

--- native
---@param key string
function ForceUIKey (key) end

--- native
function ForceUICancel () end

--- native
function DisplayLoadDialog () end

--- native
---@param iconPath string
function SetAltMinimapIcon (iconPath) end

--- native
---@param flag boolean
function DisableRestartMission (flag) end

--- native
---@return texttag
function CreateTextTag () end

--- native
---@param t texttag
function DestroyTextTag (t) end

--- native
---@param t texttag
---@param s string
---@param height number real
function SetTextTagText (t, s, height) end

--- native
---@param t texttag
---@param x number real
---@param y number real
---@param heightOffset number real
function SetTextTagPos (t, x, y, heightOffset) end

--- native
---@param t texttag
---@param whichUnit unit
---@param heightOffset number real
function SetTextTagPosUnit (t, whichUnit, heightOffset) end

--- native
---@param t texttag
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetTextTagColor (t, red, green, blue, alpha) end

--- native
---@param t texttag
---@param xvel number real
---@param yvel number real
function SetTextTagVelocity (t, xvel, yvel) end

--- native
---@param t texttag
---@param flag boolean
function SetTextTagVisibility (t, flag) end

--- native
---@param t texttag
---@param flag boolean
function SetTextTagSuspended (t, flag) end

--- native
---@param t texttag
---@param flag boolean
function SetTextTagPermanent (t, flag) end

--- native
---@param t texttag
---@param age number real
function SetTextTagAge (t, age) end

--- native
---@param t texttag
---@param lifespan number real
function SetTextTagLifespan (t, lifespan) end

--- native
---@param t texttag
---@param fadepoint number real
function SetTextTagFadepoint (t, fadepoint) end

--- native
---@param reserved number integer
function SetReservedLocalHeroButtons (reserved) end

--- native
---@return number integer
function GetAllyColorFilterState () end

--- native
---@param state number integer
function SetAllyColorFilterState (state) end

--- native
---@return boolean
function GetCreepCampFilterState () end

--- native
---@param state boolean
function SetCreepCampFilterState (state) end

--- native
---@param enableAlly boolean
---@param enableCreep boolean
function EnableMinimapFilterButtons (enableAlly, enableCreep) end

--- native
---@param state boolean
---@param ui boolean
function EnableDragSelect (state, ui) end

--- native
---@param state boolean
---@param ui boolean
function EnablePreSelect (state, ui) end

--- native
---@param state boolean
---@param ui boolean
function EnableSelect (state, ui) end

--- native
---@param trackableModelPath string
---@param x number real
---@param y number real
---@param facing number real
---@return trackable
function CreateTrackable (trackableModelPath, x, y, facing) end

--- native
---@return quest
function CreateQuest () end

--- native
---@param whichQuest quest
function DestroyQuest (whichQuest) end

--- native
---@param whichQuest quest
---@param title string
function QuestSetTitle (whichQuest, title) end

--- native
---@param whichQuest quest
---@param description string
function QuestSetDescription (whichQuest, description) end

--- native
---@param whichQuest quest
---@param iconPath string
function QuestSetIconPath (whichQuest, iconPath) end

--- native
---@param whichQuest quest
---@param required boolean
function QuestSetRequired (whichQuest, required) end

--- native
---@param whichQuest quest
---@param completed boolean
function QuestSetCompleted (whichQuest, completed) end

--- native
---@param whichQuest quest
---@param discovered boolean
function QuestSetDiscovered (whichQuest, discovered) end

--- native
---@param whichQuest quest
---@param failed boolean
function QuestSetFailed (whichQuest, failed) end

--- native
---@param whichQuest quest
---@param enabled boolean
function QuestSetEnabled (whichQuest, enabled) end

--- native
---@param whichQuest quest
---@return boolean
function IsQuestRequired (whichQuest) end

--- native
---@param whichQuest quest
---@return boolean
function IsQuestCompleted (whichQuest) end

--- native
---@param whichQuest quest
---@return boolean
function IsQuestDiscovered (whichQuest) end

--- native
---@param whichQuest quest
---@return boolean
function IsQuestFailed (whichQuest) end

--- native
---@param whichQuest quest
---@return boolean
function IsQuestEnabled (whichQuest) end

--- native
---@param whichQuest quest
---@return questitem
function QuestCreateItem (whichQuest) end

--- native
---@param whichQuestItem questitem
---@param description string
function QuestItemSetDescription (whichQuestItem, description) end

--- native
---@param whichQuestItem questitem
---@param completed boolean
function QuestItemSetCompleted (whichQuestItem, completed) end

--- native
---@param whichQuestItem questitem
---@return boolean
function IsQuestItemCompleted (whichQuestItem) end

--- native
---@return defeatcondition
function CreateDefeatCondition () end

--- native
---@param whichCondition defeatcondition
function DestroyDefeatCondition (whichCondition) end

--- native
---@param whichCondition defeatcondition
---@param description string
function DefeatConditionSetDescription (whichCondition, description) end

--- native
function FlashQuestDialogButton () end

--- native
function ForceQuestDialogUpdate () end

--- native
---@param t timer
---@return timerdialog
function CreateTimerDialog (t) end

--- native
---@param whichDialog timerdialog
function DestroyTimerDialog (whichDialog) end

--- native
---@param whichDialog timerdialog
---@param title string
function TimerDialogSetTitle (whichDialog, title) end

--- native
---@param whichDialog timerdialog
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function TimerDialogSetTitleColor (whichDialog, red, green, blue, alpha) end

--- native
---@param whichDialog timerdialog
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function TimerDialogSetTimeColor (whichDialog, red, green, blue, alpha) end

--- native
---@param whichDialog timerdialog
---@param speedMultFactor number real
function TimerDialogSetSpeed (whichDialog, speedMultFactor) end

--- native
---@param whichDialog timerdialog
---@param display boolean
function TimerDialogDisplay (whichDialog, display) end

--- native
---@param whichDialog timerdialog
---@return boolean
function IsTimerDialogDisplayed (whichDialog) end

--- native
---@param whichDialog timerdialog
---@param timeRemaining number real
function TimerDialogSetRealTimeRemaining (whichDialog, timeRemaining) end

--- native
---@return leaderboard
function CreateLeaderboard () end

--- native
---@param lb leaderboard
function DestroyLeaderboard (lb) end

--- native
---@param lb leaderboard
---@param show boolean
function LeaderboardDisplay (lb, show) end

--- native
---@param lb leaderboard
---@return boolean
function IsLeaderboardDisplayed (lb) end

--- native
---@param lb leaderboard
---@return number integer
function LeaderboardGetItemCount (lb) end

--- native
---@param lb leaderboard
---@param count number integer
function LeaderboardSetSizeByItemCount (lb, count) end

--- native
---@param lb leaderboard
---@param label string
---@param value number integer
---@param p player
function LeaderboardAddItem (lb, label, value, p) end

--- native
---@param lb leaderboard
---@param index number integer
function LeaderboardRemoveItem (lb, index) end

--- native
---@param lb leaderboard
---@param p player
function LeaderboardRemovePlayerItem (lb, p) end

--- native
---@param lb leaderboard
function LeaderboardClear (lb) end

--- native
---@param lb leaderboard
---@param ascending boolean
function LeaderboardSortItemsByValue (lb, ascending) end

--- native
---@param lb leaderboard
---@param ascending boolean
function LeaderboardSortItemsByPlayer (lb, ascending) end

--- native
---@param lb leaderboard
---@param ascending boolean
function LeaderboardSortItemsByLabel (lb, ascending) end

--- native
---@param lb leaderboard
---@param p player
---@return boolean
function LeaderboardHasPlayerItem (lb, p) end

--- native
---@param lb leaderboard
---@param p player
---@return number integer
function LeaderboardGetPlayerIndex (lb, p) end

--- native
---@param lb leaderboard
---@param label string
function LeaderboardSetLabel (lb, label) end

--- native
---@param lb leaderboard
---@return string
function LeaderboardGetLabelText (lb) end

--- native
---@param toPlayer player
---@param lb leaderboard
function PlayerSetLeaderboard (toPlayer, lb) end

--- native
---@param toPlayer player
---@return leaderboard
function PlayerGetLeaderboard (toPlayer) end

--- native
---@param lb leaderboard
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function LeaderboardSetLabelColor (lb, red, green, blue, alpha) end

--- native
---@param lb leaderboard
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function LeaderboardSetValueColor (lb, red, green, blue, alpha) end

--- native
---@param lb leaderboard
---@param showLabel boolean
---@param showNames boolean
---@param showValues boolean
---@param showIcons boolean
function LeaderboardSetStyle (lb, showLabel, showNames, showValues, showIcons) end

--- native
---@param lb leaderboard
---@param whichItem number integer
---@param val number integer
function LeaderboardSetItemValue (lb, whichItem, val) end

--- native
---@param lb leaderboard
---@param whichItem number integer
---@param val string
function LeaderboardSetItemLabel (lb, whichItem, val) end

--- native
---@param lb leaderboard
---@param whichItem number integer
---@param showLabel boolean
---@param showValue boolean
---@param showIcon boolean
function LeaderboardSetItemStyle (lb, whichItem, showLabel, showValue, showIcon) end

--- native
---@param lb leaderboard
---@param whichItem number integer
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function LeaderboardSetItemLabelColor (lb, whichItem, red, green, blue, alpha) end

--- native
---@param lb leaderboard
---@param whichItem number integer
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function LeaderboardSetItemValueColor (lb, whichItem, red, green, blue, alpha) end

--- native
---@return multiboard
function CreateMultiboard () end

--- native
---@param lb multiboard
function DestroyMultiboard (lb) end

--- native
---@param lb multiboard
---@param show boolean
function MultiboardDisplay (lb, show) end

--- native
---@param lb multiboard
---@return boolean
function IsMultiboardDisplayed (lb) end

--- native
---@param lb multiboard
---@param minimize boolean
function MultiboardMinimize (lb, minimize) end

--- native
---@param lb multiboard
---@return boolean
function IsMultiboardMinimized (lb) end

--- native
---@param lb multiboard
function MultiboardClear (lb) end

--- native
---@param lb multiboard
---@param label string
function MultiboardSetTitleText (lb, label) end

--- native
---@param lb multiboard
---@return string
function MultiboardGetTitleText (lb) end

--- native
---@param lb multiboard
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function MultiboardSetTitleTextColor (lb, red, green, blue, alpha) end

--- native
---@param lb multiboard
---@return number integer
function MultiboardGetRowCount (lb) end

--- native
---@param lb multiboard
---@return number integer
function MultiboardGetColumnCount (lb) end

--- native
---@param lb multiboard
---@param count number integer
function MultiboardSetColumnCount (lb, count) end

--- native
---@param lb multiboard
---@param count number integer
function MultiboardSetRowCount (lb, count) end

--- native
---@param lb multiboard
---@param showValues boolean
---@param showIcons boolean
function MultiboardSetItemsStyle (lb, showValues, showIcons) end

--- native
---@param lb multiboard
---@param value string
function MultiboardSetItemsValue (lb, value) end

--- native
---@param lb multiboard
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function MultiboardSetItemsValueColor (lb, red, green, blue, alpha) end

--- native
---@param lb multiboard
---@param width number real
function MultiboardSetItemsWidth (lb, width) end

--- native
---@param lb multiboard
---@param iconPath string
function MultiboardSetItemsIcon (lb, iconPath) end

--- native
---@param lb multiboard
---@param row number integer
---@param column number integer
---@return multiboarditem
function MultiboardGetItem (lb, row, column) end

--- native
---@param mbi multiboarditem
function MultiboardReleaseItem (mbi) end

--- native
---@param mbi multiboarditem
---@param showValue boolean
---@param showIcon boolean
function MultiboardSetItemStyle (mbi, showValue, showIcon) end

--- native
---@param mbi multiboarditem
---@param val string
function MultiboardSetItemValue (mbi, val) end

--- native
---@param mbi multiboarditem
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function MultiboardSetItemValueColor (mbi, red, green, blue, alpha) end

--- native
---@param mbi multiboarditem
---@param width number real
function MultiboardSetItemWidth (mbi, width) end

--- native
---@param mbi multiboarditem
---@param iconFileName string
function MultiboardSetItemIcon (mbi, iconFileName) end

--- native
---@param flag boolean
function MultiboardSuppressDisplay (flag) end

--- native
---@param x number real
---@param y number real
function SetCameraPosition (x, y) end

--- native
---@param x number real
---@param y number real
function SetCameraQuickPosition (x, y) end

--- native
---@param x1 number real
---@param y1 number real
---@param x2 number real
---@param y2 number real
---@param x3 number real
---@param y3 number real
---@param x4 number real
---@param y4 number real
function SetCameraBounds (x1, y1, x2, y2, x3, y3, x4, y4) end

--- native
function StopCamera () end

--- native
---@param duration number real
function ResetToGameCamera (duration) end

--- native
---@param x number real
---@param y number real
function PanCameraTo (x, y) end

--- native
---@param x number real
---@param y number real
---@param duration number real
function PanCameraToTimed (x, y, duration) end

--- native
---@param x number real
---@param y number real
---@param zOffsetDest number real
function PanCameraToWithZ (x, y, zOffsetDest) end

--- native
---@param x number real
---@param y number real
---@param zOffsetDest number real
---@param duration number real
function PanCameraToTimedWithZ (x, y, zOffsetDest, duration) end

--- native
---@param cameraModelFile string
function SetCinematicCamera (cameraModelFile) end

--- native
---@param x number real
---@param y number real
---@param radiansToSweep number real
---@param duration number real
function SetCameraRotateMode (x, y, radiansToSweep, duration) end

--- native
---@param whichField camerafield
---@param value number real
---@param duration number real
function SetCameraField (whichField, value, duration) end

--- native
---@param whichField camerafield
---@param offset number real
---@param duration number real
function AdjustCameraField (whichField, offset, duration) end

--- native
---@param whichUnit unit
---@param xoffset number real
---@param yoffset number real
---@param inheritOrientation boolean
function SetCameraTargetController (whichUnit, xoffset, yoffset, inheritOrientation) end

--- native
---@param whichUnit unit
---@param xoffset number real
---@param yoffset number real
function SetCameraOrientController (whichUnit, xoffset, yoffset) end

--- native
---@return camerasetup
function CreateCameraSetup () end

--- native
---@param whichSetup camerasetup
---@param whichField camerafield
---@param value number real
---@param duration number real
function CameraSetupSetField (whichSetup, whichField, value, duration) end

--- native
---@param whichSetup camerasetup
---@param whichField camerafield
---@return number real
function CameraSetupGetField (whichSetup, whichField) end

--- native
---@param whichSetup camerasetup
---@param x number real
---@param y number real
---@param duration number real
function CameraSetupSetDestPosition (whichSetup, x, y, duration) end

--- native
---@param whichSetup camerasetup
---@return location
function CameraSetupGetDestPositionLoc (whichSetup) end

--- native
---@param whichSetup camerasetup
---@return number real
function CameraSetupGetDestPositionX (whichSetup) end

--- native
---@param whichSetup camerasetup
---@return number real
function CameraSetupGetDestPositionY (whichSetup) end

--- native
---@param whichSetup camerasetup
---@param doPan boolean
---@param panTimed boolean
function CameraSetupApply (whichSetup, doPan, panTimed) end

--- native
---@param whichSetup camerasetup
---@param zDestOffset number real
function CameraSetupApplyWithZ (whichSetup, zDestOffset) end

--- native
---@param whichSetup camerasetup
---@param doPan boolean
---@param forceDuration number real
function CameraSetupApplyForceDuration (whichSetup, doPan, forceDuration) end

--- native
---@param whichSetup camerasetup
---@param zDestOffset number real
---@param forceDuration number real
function CameraSetupApplyForceDurationWithZ (whichSetup, zDestOffset, forceDuration) end

--- native
---@param mag number real
---@param velocity number real
function CameraSetTargetNoise (mag, velocity) end

--- native
---@param mag number real
---@param velocity number real
function CameraSetSourceNoise (mag, velocity) end

--- native
---@param mag number real
---@param velocity number real
---@param vertOnly boolean
function CameraSetTargetNoiseEx (mag, velocity, vertOnly) end

--- native
---@param mag number real
---@param velocity number real
---@param vertOnly boolean
function CameraSetSourceNoiseEx (mag, velocity, vertOnly) end

--- native
---@param factor number real
function CameraSetSmoothingFactor (factor) end

--- native
---@param filename string
function SetCineFilterTexture (filename) end

--- native
---@param whichMode blendmode
function SetCineFilterBlendMode (whichMode) end

--- native
---@param whichFlags texmapflags
function SetCineFilterTexMapFlags (whichFlags) end

--- native
---@param minu number real
---@param minv number real
---@param maxu number real
---@param maxv number real
function SetCineFilterStartUV (minu, minv, maxu, maxv) end

--- native
---@param minu number real
---@param minv number real
---@param maxu number real
---@param maxv number real
function SetCineFilterEndUV (minu, minv, maxu, maxv) end

--- native
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetCineFilterStartColor (red, green, blue, alpha) end

--- native
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetCineFilterEndColor (red, green, blue, alpha) end

--- native
---@param duration number real
function SetCineFilterDuration (duration) end

--- native
---@param flag boolean
function DisplayCineFilter (flag) end

--- native
---@return boolean
function IsCineFilterDisplayed () end

--- native
---@param portraitUnitId number integer
---@param color playercolor
---@param speakerTitle string
---@param text string
---@param sceneDuration number real
---@param voiceoverDuration number real
function SetCinematicScene (portraitUnitId, color, speakerTitle, text, sceneDuration, voiceoverDuration) end

--- native
function EndCinematicScene () end

--- native
---@param flag boolean
function ForceCinematicSubtitles (flag) end

--- native
---@param whichMargin number integer
---@return number real
function GetCameraMargin (whichMargin) end

--- native
---@return number real
function GetCameraBoundMinX () end

--- native
---@return number real
function GetCameraBoundMinY () end

--- native
---@return number real
function GetCameraBoundMaxX () end

--- native
---@return number real
function GetCameraBoundMaxY () end

--- native
---@param whichField camerafield
---@return number real
function GetCameraField (whichField) end

--- native
---@return number real
function GetCameraTargetPositionX () end

--- native
---@return number real
function GetCameraTargetPositionY () end

--- native
---@return number real
function GetCameraTargetPositionZ () end

--- native
---@return location
function GetCameraTargetPositionLoc () end

--- native
---@return number real
function GetCameraEyePositionX () end

--- native
---@return number real
function GetCameraEyePositionY () end

--- native
---@return number real
function GetCameraEyePositionZ () end

--- native
---@return location
function GetCameraEyePositionLoc () end

--- native
---@param environmentName string
function NewSoundEnvironment (environmentName) end

--- native
---@param fileName string
---@param looping boolean
---@param is3D boolean
---@param stopwhenoutofrange boolean
---@param fadeInRate number integer
---@param fadeOutRate number integer
---@param eaxSetting string
---@return sound
function CreateSound (fileName, looping, is3D, stopwhenoutofrange, fadeInRate, fadeOutRate, eaxSetting) end

--- native
---@param fileName string
---@param looping boolean
---@param is3D boolean
---@param stopwhenoutofrange boolean
---@param fadeInRate number integer
---@param fadeOutRate number integer
---@param SLKEntryName string
---@return sound
function CreateSoundFilenameWithLabel (fileName, looping, is3D, stopwhenoutofrange, fadeInRate, fadeOutRate, SLKEntryName) end

--- native
---@param soundLabel string
---@param looping boolean
---@param is3D boolean
---@param stopwhenoutofrange boolean
---@param fadeInRate number integer
---@param fadeOutRate number integer
---@return sound
function CreateSoundFromLabel (soundLabel, looping, is3D, stopwhenoutofrange, fadeInRate, fadeOutRate) end

--- native
---@param soundLabel string
---@param fadeInRate number integer
---@param fadeOutRate number integer
---@return sound
function CreateMIDISound (soundLabel, fadeInRate, fadeOutRate) end

--- native
---@param soundHandle sound
---@param soundLabel string
function SetSoundParamsFromLabel (soundHandle, soundLabel) end

--- native
---@param soundHandle sound
---@param cutoff number real
function SetSoundDistanceCutoff (soundHandle, cutoff) end

--- native
---@param soundHandle sound
---@param channel number integer
function SetSoundChannel (soundHandle, channel) end

--- native
---@param soundHandle sound
---@param volume number integer
function SetSoundVolume (soundHandle, volume) end

--- native
---@param soundHandle sound
---@param pitch number real
function SetSoundPitch (soundHandle, pitch) end

--- native
---@param soundHandle sound
---@param millisecs number integer
function SetSoundPlayPosition (soundHandle, millisecs) end

--- native
---@param soundHandle sound
---@param minDist number real
---@param maxDist number real
function SetSoundDistances (soundHandle, minDist, maxDist) end

--- native
---@param soundHandle sound
---@param inside number real
---@param outside number real
---@param outsideVolume number integer
function SetSoundConeAngles (soundHandle, inside, outside, outsideVolume) end

--- native
---@param soundHandle sound
---@param x number real
---@param y number real
---@param z number real
function SetSoundConeOrientation (soundHandle, x, y, z) end

--- native
---@param soundHandle sound
---@param x number real
---@param y number real
---@param z number real
function SetSoundPosition (soundHandle, x, y, z) end

--- native
---@param soundHandle sound
---@param x number real
---@param y number real
---@param z number real
function SetSoundVelocity (soundHandle, x, y, z) end

--- native
---@param soundHandle sound
---@param whichUnit unit
function AttachSoundToUnit (soundHandle, whichUnit) end

--- native
---@param soundHandle sound
function StartSound (soundHandle) end

--- native
---@param soundHandle sound
---@param killWhenDone boolean
---@param fadeOut boolean
function StopSound (soundHandle, killWhenDone, fadeOut) end

--- native
---@param soundHandle sound
function KillSoundWhenDone (soundHandle) end

--- native
---@param musicName string
---@param random boolean
---@param index number integer
function SetMapMusic (musicName, random, index) end

--- native
function ClearMapMusic () end

--- native
---@param musicName string
function PlayMusic (musicName) end

--- native
---@param musicName string
---@param frommsecs number integer
---@param fadeinmsecs number integer
function PlayMusicEx (musicName, frommsecs, fadeinmsecs) end

--- native
---@param fadeOut boolean
function StopMusic (fadeOut) end

--- native
function ResumeMusic () end

--- native
---@param musicFileName string
function PlayThematicMusic (musicFileName) end

--- native
---@param musicFileName string
---@param frommsecs number integer
function PlayThematicMusicEx (musicFileName, frommsecs) end

--- native
function EndThematicMusic () end

--- native
---@param volume number integer
function SetMusicVolume (volume) end

--- native
---@param millisecs number integer
function SetMusicPlayPosition (millisecs) end

--- native
---@param millisecs number integer
function SetThematicMusicPlayPosition (millisecs) end

--- native
---@param soundHandle sound
---@param duration number integer
function SetSoundDuration (soundHandle, duration) end

--- native
---@param soundHandle sound
---@return number integer
function GetSoundDuration (soundHandle) end

--- native
---@param musicFileName string
---@return number integer
function GetSoundFileDuration (musicFileName) end

--- native
---@param vgroup volumegroup
---@param scale number real
function VolumeGroupSetVolume (vgroup, scale) end

--- native
function VolumeGroupReset () end

--- native
---@param soundHandle sound
---@return boolean
function GetSoundIsPlaying (soundHandle) end

--- native
---@param soundHandle sound
---@return boolean
function GetSoundIsLoading (soundHandle) end

--- native
---@param soundHandle sound
---@param byPosition boolean
---@param rectwidth number real
---@param rectheight number real
function RegisterStackedSound (soundHandle, byPosition, rectwidth, rectheight) end

--- native
---@param soundHandle sound
---@param byPosition boolean
---@param rectwidth number real
---@param rectheight number real
function UnregisterStackedSound (soundHandle, byPosition, rectwidth, rectheight) end

--- native
---@param where rect
---@param effectID number integer
---@return weathereffect
function AddWeatherEffect (where, effectID) end

--- native
---@param whichEffect weathereffect
function RemoveWeatherEffect (whichEffect) end

--- native
---@param whichEffect weathereffect
---@param enable boolean
function EnableWeatherEffect (whichEffect, enable) end

--- native
---@param x number real
---@param y number real
---@param radius number real
---@param depth number real
---@param duration number integer
---@param permanent boolean
---@return terraindeformation
function TerrainDeformCrater (x, y, radius, depth, duration, permanent) end

--- native
---@param x number real
---@param y number real
---@param radius number real
---@param depth number real
---@param duration number integer
---@param count number integer
---@param spaceWaves number real
---@param timeWaves number real
---@param radiusStartPct number real
---@param limitNeg boolean
---@return terraindeformation
function TerrainDeformRipple (x, y, radius, depth, duration, count, spaceWaves, timeWaves, radiusStartPct, limitNeg) end

--- native
---@param x number real
---@param y number real
---@param dirX number real
---@param dirY number real
---@param distance number real
---@param speed number real
---@param radius number real
---@param depth number real
---@param trailTime number integer
---@param count number integer
---@return terraindeformation
function TerrainDeformWave (x, y, dirX, dirY, distance, speed, radius, depth, trailTime, count) end

--- native
---@param x number real
---@param y number real
---@param radius number real
---@param minDelta number real
---@param maxDelta number real
---@param duration number integer
---@param updateInterval number integer
---@return terraindeformation
function TerrainDeformRandom (x, y, radius, minDelta, maxDelta, duration, updateInterval) end

--- native
---@param deformation terraindeformation
---@param duration number integer
function TerrainDeformStop (deformation, duration) end

--- native
function TerrainDeformStopAll () end

--- native
---@param modelName string
---@param x number real
---@param y number real
---@return effect
function AddSpecialEffect (modelName, x, y) end

--- native
---@param modelName string
---@param where location
---@return effect
function AddSpecialEffectLoc (modelName, where) end

--- native
---@param modelName string
---@param targetWidget widget
---@param attachPointName string
---@return effect
function AddSpecialEffectTarget (modelName, targetWidget, attachPointName) end

--- native
---@param whichEffect effect
function DestroyEffect (whichEffect) end

--- native
---@param abilityString string
---@param t effecttype
---@param x number real
---@param y number real
---@return effect
function AddSpellEffect (abilityString, t, x, y) end

--- native
---@param abilityString string
---@param t effecttype
---@param where location
---@return effect
function AddSpellEffectLoc (abilityString, t, where) end

--- native
---@param abilityId number integer
---@param t effecttype
---@param x number real
---@param y number real
---@return effect
function AddSpellEffectById (abilityId, t, x, y) end

--- native
---@param abilityId number integer
---@param t effecttype
---@param where location
---@return effect
function AddSpellEffectByIdLoc (abilityId, t, where) end

--- native
---@param modelName string
---@param t effecttype
---@param targetWidget widget
---@param attachPoint string
---@return effect
function AddSpellEffectTarget (modelName, t, targetWidget, attachPoint) end

--- native
---@param abilityId number integer
---@param t effecttype
---@param targetWidget widget
---@param attachPoint string
---@return effect
function AddSpellEffectTargetById (abilityId, t, targetWidget, attachPoint) end

--- native
---@param codeName string
---@param checkVisibility boolean
---@param x1 number real
---@param y1 number real
---@param x2 number real
---@param y2 number real
---@return lightning
function AddLightning (codeName, checkVisibility, x1, y1, x2, y2) end

--- native
---@param codeName string
---@param checkVisibility boolean
---@param x1 number real
---@param y1 number real
---@param z1 number real
---@param x2 number real
---@param y2 number real
---@param z2 number real
---@return lightning
function AddLightningEx (codeName, checkVisibility, x1, y1, z1, x2, y2, z2) end

--- native
---@param whichBolt lightning
---@return boolean
function DestroyLightning (whichBolt) end

--- native
---@param whichBolt lightning
---@param checkVisibility boolean
---@param x1 number real
---@param y1 number real
---@param x2 number real
---@param y2 number real
---@return boolean
function MoveLightning (whichBolt, checkVisibility, x1, y1, x2, y2) end

--- native
---@param whichBolt lightning
---@param checkVisibility boolean
---@param x1 number real
---@param y1 number real
---@param z1 number real
---@param x2 number real
---@param y2 number real
---@param z2 number real
---@return boolean
function MoveLightningEx (whichBolt, checkVisibility, x1, y1, z1, x2, y2, z2) end

--- native
---@param whichBolt lightning
---@return number real
function GetLightningColorA (whichBolt) end

--- native
---@param whichBolt lightning
---@return number real
function GetLightningColorR (whichBolt) end

--- native
---@param whichBolt lightning
---@return number real
function GetLightningColorG (whichBolt) end

--- native
---@param whichBolt lightning
---@return number real
function GetLightningColorB (whichBolt) end

--- native
---@param whichBolt lightning
---@param r number real
---@param g number real
---@param b number real
---@param a number real
---@return boolean
function SetLightningColor (whichBolt, r, g, b, a) end

--- native
---@param abilityString string
---@param t effecttype
---@param index number integer
---@return string
function GetAbilityEffect (abilityString, t, index) end

--- native
---@param abilityId number integer
---@param t effecttype
---@param index number integer
---@return string
function GetAbilityEffectById (abilityId, t, index) end

--- native
---@param abilityString string
---@param t soundtype
---@return string
function GetAbilitySound (abilityString, t) end

--- native
---@param abilityId number integer
---@param t soundtype
---@return string
function GetAbilitySoundById (abilityId, t) end

--- native
---@param x number real
---@param y number real
---@return number integer
function GetTerrainCliffLevel (x, y) end

--- native
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetWaterBaseColor (red, green, blue, alpha) end

--- native
---@param val boolean
function SetWaterDeforms (val) end

--- native
---@param x number real
---@param y number real
---@return number integer
function GetTerrainType (x, y) end

--- native
---@param x number real
---@param y number real
---@return number integer
function GetTerrainVariance (x, y) end

--- native
---@param x number real
---@param y number real
---@param terrainType number integer
---@param variation number integer
---@param area number integer
---@param shape number integer
function SetTerrainType (x, y, terrainType, variation, area, shape) end

--- native
---@param x number real
---@param y number real
---@param t pathingtype
---@return boolean
function IsTerrainPathable (x, y, t) end

--- native
---@param x number real
---@param y number real
---@param t pathingtype
---@param flag boolean
function SetTerrainPathable (x, y, t, flag) end

--- native
---@param file string
---@param sizeX number real
---@param sizeY number real
---@param sizeZ number real
---@param posX number real
---@param posY number real
---@param posZ number real
---@param originX number real
---@param originY number real
---@param originZ number real
---@param imageType number integer
---@return image
function CreateImage (file, sizeX, sizeY, sizeZ, posX, posY, posZ, originX, originY, originZ, imageType) end

--- native
---@param whichImage image
function DestroyImage (whichImage) end

--- native
---@param whichImage image
---@param flag boolean
function ShowImage (whichImage, flag) end

--- native
---@param whichImage image
---@param flag boolean
---@param height number real
function SetImageConstantHeight (whichImage, flag, height) end

--- native
---@param whichImage image
---@param x number real
---@param y number real
---@param z number real
function SetImagePosition (whichImage, x, y, z) end

--- native
---@param whichImage image
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
function SetImageColor (whichImage, red, green, blue, alpha) end

--- native
---@param whichImage image
---@param flag boolean
function SetImageRender (whichImage, flag) end

--- native
---@param whichImage image
---@param flag boolean
function SetImageRenderAlways (whichImage, flag) end

--- native
---@param whichImage image
---@param flag boolean
---@param useWaterAlpha boolean
function SetImageAboveWater (whichImage, flag, useWaterAlpha) end

--- native
---@param whichImage image
---@param imageType number integer
function SetImageType (whichImage, imageType) end

--- native
---@param x number real
---@param y number real
---@param name string
---@param red number integer
---@param green number integer
---@param blue number integer
---@param alpha number integer
---@param forcePaused boolean
---@param noBirthTime boolean
---@return ubersplat
function CreateUbersplat (x, y, name, red, green, blue, alpha, forcePaused, noBirthTime) end

--- native
---@param whichSplat ubersplat
function DestroyUbersplat (whichSplat) end

--- native
---@param whichSplat ubersplat
function ResetUbersplat (whichSplat) end

--- native
---@param whichSplat ubersplat
function FinishUbersplat (whichSplat) end

--- native
---@param whichSplat ubersplat
---@param flag boolean
function ShowUbersplat (whichSplat, flag) end

--- native
---@param whichSplat ubersplat
---@param flag boolean
function SetUbersplatRender (whichSplat, flag) end

--- native
---@param whichSplat ubersplat
---@param flag boolean
function SetUbersplatRenderAlways (whichSplat, flag) end

--- native
---@param whichPlayer player
---@param x number real
---@param y number real
---@param radius number real
---@param addBlight boolean
function SetBlight (whichPlayer, x, y, radius, addBlight) end

--- native
---@param whichPlayer player
---@param r rect
---@param addBlight boolean
function SetBlightRect (whichPlayer, r, addBlight) end

--- native
---@param whichPlayer player
---@param x number real
---@param y number real
---@param addBlight boolean
function SetBlightPoint (whichPlayer, x, y, addBlight) end

--- native
---@param whichPlayer player
---@param whichLocation location
---@param radius number real
---@param addBlight boolean
function SetBlightLoc (whichPlayer, whichLocation, radius, addBlight) end

--- native
---@param id player
---@param x number real
---@param y number real
---@param face number real
---@return unit
function CreateBlightedGoldmine (id, x, y, face) end

--- native
---@param x number real
---@param y number real
---@return boolean
function IsPointBlighted (x, y) end

--- native
---@param x number real
---@param y number real
---@param radius number real
---@param doodadID number integer
---@param nearestOnly boolean
---@param animName string
---@param animRandom boolean
function SetDoodadAnimation (x, y, radius, doodadID, nearestOnly, animName, animRandom) end

--- native
---@param r rect
---@param doodadID number integer
---@param animName string
---@param animRandom boolean
function SetDoodadAnimationRect (r, doodadID, animName, animRandom) end

--- native
---@param num player
---@param script string
function StartMeleeAI (num, script) end

--- native
---@param num player
---@param script string
function StartCampaignAI (num, script) end

--- native
---@param num player
---@param command number integer
---@param data number integer
function CommandAI (num, command, data) end

--- native
---@param p player
---@param pause boolean
function PauseCompAI (p, pause) end

--- native
---@param num player
---@return aidifficulty
function GetAIDifficulty (num) end

--- native
---@param hUnit unit
function RemoveGuardPosition (hUnit) end

--- native
---@param hUnit unit
function RecycleGuardPosition (hUnit) end

--- native
---@param num player
function RemoveAllGuardPositions (num) end

--- native
---@param cheatStr string
function Cheat (cheatStr) end

--- native
---@return boolean
function IsNoVictoryCheat () end

--- native
---@return boolean
function IsNoDefeatCheat () end

--- native
---@param filename string
function Preload (filename) end

--- native
---@param timeout number real
function PreloadEnd (timeout) end

--- native
function PreloadStart () end

--- native
function PreloadRefresh () end

--- native
function PreloadEndEx () end

--- native
function PreloadGenClear () end

--- native
function PreloadGenStart () end

--- native
---@param filename string
function PreloadGenEnd (filename) end

--- native
---@param filename string
function Preloader (filename) end

FALSE = false ---@type boolean constant
TRUE = true ---@type boolean constant
JASS_MAX_ARRAY_SIZE = 8192 ---@type number integer constant
PLAYER_NEUTRAL_PASSIVE = 15 ---@type number integer constant
PLAYER_NEUTRAL_AGGRESSIVE = 12 ---@type number integer constant
PLAYER_COLOR_RED = ConvertPlayerColor(0) ---@type playercolor constant
PLAYER_COLOR_BLUE = ConvertPlayerColor(1) ---@type playercolor constant
PLAYER_COLOR_CYAN = ConvertPlayerColor(2) ---@type playercolor constant
PLAYER_COLOR_PURPLE = ConvertPlayerColor(3) ---@type playercolor constant
PLAYER_COLOR_YELLOW = ConvertPlayerColor(4) ---@type playercolor constant
PLAYER_COLOR_ORANGE = ConvertPlayerColor(5) ---@type playercolor constant
PLAYER_COLOR_GREEN = ConvertPlayerColor(6) ---@type playercolor constant
PLAYER_COLOR_PINK = ConvertPlayerColor(7) ---@type playercolor constant
PLAYER_COLOR_LIGHT_GRAY = ConvertPlayerColor(8) ---@type playercolor constant
PLAYER_COLOR_LIGHT_BLUE = ConvertPlayerColor(9) ---@type playercolor constant
PLAYER_COLOR_AQUA = ConvertPlayerColor(10) ---@type playercolor constant
PLAYER_COLOR_BROWN = ConvertPlayerColor(11) ---@type playercolor constant
RACE_HUMAN = ConvertRace(1) ---@type race constant
RACE_ORC = ConvertRace(2) ---@type race constant
RACE_UNDEAD = ConvertRace(3) ---@type race constant
RACE_NIGHTELF = ConvertRace(4) ---@type race constant
RACE_DEMON = ConvertRace(5) ---@type race constant
RACE_OTHER = ConvertRace(7) ---@type race constant
PLAYER_GAME_RESULT_VICTORY = ConvertPlayerGameResult(0) ---@type playergameresult constant
PLAYER_GAME_RESULT_DEFEAT = ConvertPlayerGameResult(1) ---@type playergameresult constant
PLAYER_GAME_RESULT_TIE = ConvertPlayerGameResult(2) ---@type playergameresult constant
PLAYER_GAME_RESULT_NEUTRAL = ConvertPlayerGameResult(3) ---@type playergameresult constant
ALLIANCE_PASSIVE = ConvertAllianceType(0) ---@type alliancetype constant
ALLIANCE_HELP_REQUEST = ConvertAllianceType(1) ---@type alliancetype constant
ALLIANCE_HELP_RESPONSE = ConvertAllianceType(2) ---@type alliancetype constant
ALLIANCE_SHARED_XP = ConvertAllianceType(3) ---@type alliancetype constant
ALLIANCE_SHARED_SPELLS = ConvertAllianceType(4) ---@type alliancetype constant
ALLIANCE_SHARED_VISION = ConvertAllianceType(5) ---@type alliancetype constant
ALLIANCE_SHARED_CONTROL = ConvertAllianceType(6) ---@type alliancetype constant
ALLIANCE_SHARED_ADVANCED_CONTROL = ConvertAllianceType(7) ---@type alliancetype constant
ALLIANCE_RESCUABLE = ConvertAllianceType(8) ---@type alliancetype constant
ALLIANCE_SHARED_VISION_FORCED = ConvertAllianceType(9) ---@type alliancetype constant
VERSION_REIGN_OF_CHAOS = ConvertVersion(0) ---@type version constant
VERSION_FROZEN_THRONE = ConvertVersion(1) ---@type version constant
ATTACK_TYPE_NORMAL = ConvertAttackType(0) ---@type attacktype constant
ATTACK_TYPE_MELEE = ConvertAttackType(1) ---@type attacktype constant
ATTACK_TYPE_PIERCE = ConvertAttackType(2) ---@type attacktype constant
ATTACK_TYPE_SIEGE = ConvertAttackType(3) ---@type attacktype constant
ATTACK_TYPE_MAGIC = ConvertAttackType(4) ---@type attacktype constant
ATTACK_TYPE_CHAOS = ConvertAttackType(5) ---@type attacktype constant
ATTACK_TYPE_HERO = ConvertAttackType(6) ---@type attacktype constant
DAMAGE_TYPE_UNKNOWN = ConvertDamageType(0) ---@type damagetype constant
DAMAGE_TYPE_NORMAL = ConvertDamageType(4) ---@type damagetype constant
DAMAGE_TYPE_ENHANCED = ConvertDamageType(5) ---@type damagetype constant
DAMAGE_TYPE_FIRE = ConvertDamageType(8) ---@type damagetype constant
DAMAGE_TYPE_COLD = ConvertDamageType(9) ---@type damagetype constant
DAMAGE_TYPE_LIGHTNING = ConvertDamageType(10) ---@type damagetype constant
DAMAGE_TYPE_POISON = ConvertDamageType(11) ---@type damagetype constant
DAMAGE_TYPE_DISEASE = ConvertDamageType(12) ---@type damagetype constant
DAMAGE_TYPE_DIVINE = ConvertDamageType(13) ---@type damagetype constant
DAMAGE_TYPE_MAGIC = ConvertDamageType(14) ---@type damagetype constant
DAMAGE_TYPE_SONIC = ConvertDamageType(15) ---@type damagetype constant
DAMAGE_TYPE_ACID = ConvertDamageType(16) ---@type damagetype constant
DAMAGE_TYPE_FORCE = ConvertDamageType(17) ---@type damagetype constant
DAMAGE_TYPE_DEATH = ConvertDamageType(18) ---@type damagetype constant
DAMAGE_TYPE_MIND = ConvertDamageType(19) ---@type damagetype constant
DAMAGE_TYPE_PLANT = ConvertDamageType(20) ---@type damagetype constant
DAMAGE_TYPE_DEFENSIVE = ConvertDamageType(21) ---@type damagetype constant
DAMAGE_TYPE_DEMOLITION = ConvertDamageType(22) ---@type damagetype constant
DAMAGE_TYPE_SLOW_POISON = ConvertDamageType(23) ---@type damagetype constant
DAMAGE_TYPE_SPIRIT_LINK = ConvertDamageType(24) ---@type damagetype constant
DAMAGE_TYPE_SHADOW_STRIKE = ConvertDamageType(25) ---@type damagetype constant
DAMAGE_TYPE_UNIVERSAL = ConvertDamageType(26) ---@type damagetype constant
WEAPON_TYPE_WHOKNOWS = ConvertWeaponType(0) ---@type weapontype constant
WEAPON_TYPE_METAL_LIGHT_CHOP = ConvertWeaponType(1) ---@type weapontype constant
WEAPON_TYPE_METAL_MEDIUM_CHOP = ConvertWeaponType(2) ---@type weapontype constant
WEAPON_TYPE_METAL_HEAVY_CHOP = ConvertWeaponType(3) ---@type weapontype constant
WEAPON_TYPE_METAL_LIGHT_SLICE = ConvertWeaponType(4) ---@type weapontype constant
WEAPON_TYPE_METAL_MEDIUM_SLICE = ConvertWeaponType(5) ---@type weapontype constant
WEAPON_TYPE_METAL_HEAVY_SLICE = ConvertWeaponType(6) ---@type weapontype constant
WEAPON_TYPE_METAL_MEDIUM_BASH = ConvertWeaponType(7) ---@type weapontype constant
WEAPON_TYPE_METAL_HEAVY_BASH = ConvertWeaponType(8) ---@type weapontype constant
WEAPON_TYPE_METAL_MEDIUM_STAB = ConvertWeaponType(9) ---@type weapontype constant
WEAPON_TYPE_METAL_HEAVY_STAB = ConvertWeaponType(10) ---@type weapontype constant
WEAPON_TYPE_WOOD_LIGHT_SLICE = ConvertWeaponType(11) ---@type weapontype constant
WEAPON_TYPE_WOOD_MEDIUM_SLICE = ConvertWeaponType(12) ---@type weapontype constant
WEAPON_TYPE_WOOD_HEAVY_SLICE = ConvertWeaponType(13) ---@type weapontype constant
WEAPON_TYPE_WOOD_LIGHT_BASH = ConvertWeaponType(14) ---@type weapontype constant
WEAPON_TYPE_WOOD_MEDIUM_BASH = ConvertWeaponType(15) ---@type weapontype constant
WEAPON_TYPE_WOOD_HEAVY_BASH = ConvertWeaponType(16) ---@type weapontype constant
WEAPON_TYPE_WOOD_LIGHT_STAB = ConvertWeaponType(17) ---@type weapontype constant
WEAPON_TYPE_WOOD_MEDIUM_STAB = ConvertWeaponType(18) ---@type weapontype constant
WEAPON_TYPE_CLAW_LIGHT_SLICE = ConvertWeaponType(19) ---@type weapontype constant
WEAPON_TYPE_CLAW_MEDIUM_SLICE = ConvertWeaponType(20) ---@type weapontype constant
WEAPON_TYPE_CLAW_HEAVY_SLICE = ConvertWeaponType(21) ---@type weapontype constant
WEAPON_TYPE_AXE_MEDIUM_CHOP = ConvertWeaponType(22) ---@type weapontype constant
WEAPON_TYPE_ROCK_HEAVY_BASH = ConvertWeaponType(23) ---@type weapontype constant
PATHING_TYPE_ANY = ConvertPathingType(0) ---@type pathingtype constant
PATHING_TYPE_WALKABILITY = ConvertPathingType(1) ---@type pathingtype constant
PATHING_TYPE_FLYABILITY = ConvertPathingType(2) ---@type pathingtype constant
PATHING_TYPE_BUILDABILITY = ConvertPathingType(3) ---@type pathingtype constant
PATHING_TYPE_PEONHARVESTPATHING = ConvertPathingType(4) ---@type pathingtype constant
PATHING_TYPE_BLIGHTPATHING = ConvertPathingType(5) ---@type pathingtype constant
PATHING_TYPE_FLOATABILITY = ConvertPathingType(6) ---@type pathingtype constant
PATHING_TYPE_AMPHIBIOUSPATHING = ConvertPathingType(7) ---@type pathingtype constant
RACE_PREF_HUMAN = ConvertRacePref(1) ---@type racepreference constant
RACE_PREF_ORC = ConvertRacePref(2) ---@type racepreference constant
RACE_PREF_NIGHTELF = ConvertRacePref(4) ---@type racepreference constant
RACE_PREF_UNDEAD = ConvertRacePref(8) ---@type racepreference constant
RACE_PREF_DEMON = ConvertRacePref(16) ---@type racepreference constant
RACE_PREF_RANDOM = ConvertRacePref(32) ---@type racepreference constant
RACE_PREF_USER_SELECTABLE = ConvertRacePref(64) ---@type racepreference constant
MAP_CONTROL_USER = ConvertMapControl(0) ---@type mapcontrol constant
MAP_CONTROL_COMPUTER = ConvertMapControl(1) ---@type mapcontrol constant
MAP_CONTROL_RESCUABLE = ConvertMapControl(2) ---@type mapcontrol constant
MAP_CONTROL_NEUTRAL = ConvertMapControl(3) ---@type mapcontrol constant
MAP_CONTROL_CREEP = ConvertMapControl(4) ---@type mapcontrol constant
MAP_CONTROL_NONE = ConvertMapControl(5) ---@type mapcontrol constant
GAME_TYPE_MELEE = ConvertGameType(1) ---@type gametype constant
GAME_TYPE_FFA = ConvertGameType(2) ---@type gametype constant
GAME_TYPE_USE_MAP_SETTINGS = ConvertGameType(4) ---@type gametype constant
GAME_TYPE_BLIZ = ConvertGameType(8) ---@type gametype constant
GAME_TYPE_ONE_ON_ONE = ConvertGameType(16) ---@type gametype constant
GAME_TYPE_TWO_TEAM_PLAY = ConvertGameType(32) ---@type gametype constant
GAME_TYPE_THREE_TEAM_PLAY = ConvertGameType(64) ---@type gametype constant
GAME_TYPE_FOUR_TEAM_PLAY = ConvertGameType(128) ---@type gametype constant
MAP_FOG_HIDE_TERRAIN = ConvertMapFlag(1) ---@type mapflag constant
MAP_FOG_MAP_EXPLORED = ConvertMapFlag(2) ---@type mapflag constant
MAP_FOG_ALWAYS_VISIBLE = ConvertMapFlag(4) ---@type mapflag constant
MAP_USE_HANDICAPS = ConvertMapFlag(8) ---@type mapflag constant
MAP_OBSERVERS = ConvertMapFlag(16) ---@type mapflag constant
MAP_OBSERVERS_ON_DEATH = ConvertMapFlag(32) ---@type mapflag constant
MAP_FIXED_COLORS = ConvertMapFlag(128) ---@type mapflag constant
MAP_LOCK_RESOURCE_TRADING = ConvertMapFlag(256) ---@type mapflag constant
MAP_RESOURCE_TRADING_ALLIES_ONLY = ConvertMapFlag(512) ---@type mapflag constant
MAP_LOCK_ALLIANCE_CHANGES = ConvertMapFlag(1024) ---@type mapflag constant
MAP_ALLIANCE_CHANGES_HIDDEN = ConvertMapFlag(2048) ---@type mapflag constant
MAP_CHEATS = ConvertMapFlag(4096) ---@type mapflag constant
MAP_CHEATS_HIDDEN = ConvertMapFlag(8192) ---@type mapflag constant
MAP_LOCK_SPEED = ConvertMapFlag(8192 * 2) ---@type mapflag constant
MAP_LOCK_RANDOM_SEED = ConvertMapFlag(8192 * 4) ---@type mapflag constant
MAP_SHARED_ADVANCED_CONTROL = ConvertMapFlag(8192 * 8) ---@type mapflag constant
MAP_RANDOM_HERO = ConvertMapFlag(8192 * 16) ---@type mapflag constant
MAP_RANDOM_RACES = ConvertMapFlag(8192 * 32) ---@type mapflag constant
MAP_RELOADED = ConvertMapFlag(8192 * 64) ---@type mapflag constant
MAP_PLACEMENT_RANDOM = ConvertPlacement(0) ---@type placement constant
MAP_PLACEMENT_FIXED = ConvertPlacement(1) ---@type placement constant
MAP_PLACEMENT_USE_MAP_SETTINGS = ConvertPlacement(2) ---@type placement constant
MAP_PLACEMENT_TEAMS_TOGETHER = ConvertPlacement(3) ---@type placement constant
MAP_LOC_PRIO_LOW = ConvertStartLocPrio(0) ---@type startlocprio constant
MAP_LOC_PRIO_HIGH = ConvertStartLocPrio(1) ---@type startlocprio constant
MAP_LOC_PRIO_NOT = ConvertStartLocPrio(2) ---@type startlocprio constant
MAP_DENSITY_NONE = ConvertMapDensity(0) ---@type mapdensity constant
MAP_DENSITY_LIGHT = ConvertMapDensity(1) ---@type mapdensity constant
MAP_DENSITY_MEDIUM = ConvertMapDensity(2) ---@type mapdensity constant
MAP_DENSITY_HEAVY = ConvertMapDensity(3) ---@type mapdensity constant
MAP_DIFFICULTY_EASY = ConvertGameDifficulty(0) ---@type gamedifficulty constant
MAP_DIFFICULTY_NORMAL = ConvertGameDifficulty(1) ---@type gamedifficulty constant
MAP_DIFFICULTY_HARD = ConvertGameDifficulty(2) ---@type gamedifficulty constant
MAP_DIFFICULTY_INSANE = ConvertGameDifficulty(3) ---@type gamedifficulty constant
MAP_SPEED_SLOWEST = ConvertGameSpeed(0) ---@type gamespeed constant
MAP_SPEED_SLOW = ConvertGameSpeed(1) ---@type gamespeed constant
MAP_SPEED_NORMAL = ConvertGameSpeed(2) ---@type gamespeed constant
MAP_SPEED_FAST = ConvertGameSpeed(3) ---@type gamespeed constant
MAP_SPEED_FASTEST = ConvertGameSpeed(4) ---@type gamespeed constant
PLAYER_SLOT_STATE_EMPTY = ConvertPlayerSlotState(0) ---@type playerslotstate constant
PLAYER_SLOT_STATE_PLAYING = ConvertPlayerSlotState(1) ---@type playerslotstate constant
PLAYER_SLOT_STATE_LEFT = ConvertPlayerSlotState(2) ---@type playerslotstate constant
SOUND_VOLUMEGROUP_UNITMOVEMENT = ConvertVolumeGroup(0) ---@type volumegroup constant
SOUND_VOLUMEGROUP_UNITSOUNDS = ConvertVolumeGroup(1) ---@type volumegroup constant
SOUND_VOLUMEGROUP_COMBAT = ConvertVolumeGroup(2) ---@type volumegroup constant
SOUND_VOLUMEGROUP_SPELLS = ConvertVolumeGroup(3) ---@type volumegroup constant
SOUND_VOLUMEGROUP_UI = ConvertVolumeGroup(4) ---@type volumegroup constant
SOUND_VOLUMEGROUP_MUSIC = ConvertVolumeGroup(5) ---@type volumegroup constant
SOUND_VOLUMEGROUP_AMBIENTSOUNDS = ConvertVolumeGroup(6) ---@type volumegroup constant
SOUND_VOLUMEGROUP_FIRE = ConvertVolumeGroup(7) ---@type volumegroup constant
GAME_STATE_DIVINE_INTERVENTION = ConvertIGameState(0) ---@type igamestate constant
GAME_STATE_DISCONNECTED = ConvertIGameState(1) ---@type igamestate constant
GAME_STATE_TIME_OF_DAY = ConvertFGameState(2) ---@type fgamestate constant
PLAYER_STATE_GAME_RESULT = ConvertPlayerState(0) ---@type playerstate constant
PLAYER_STATE_RESOURCE_GOLD = ConvertPlayerState(1) ---@type playerstate constant
PLAYER_STATE_RESOURCE_LUMBER = ConvertPlayerState(2) ---@type playerstate constant
PLAYER_STATE_RESOURCE_HERO_TOKENS = ConvertPlayerState(3) ---@type playerstate constant
PLAYER_STATE_RESOURCE_FOOD_CAP = ConvertPlayerState(4) ---@type playerstate constant
PLAYER_STATE_RESOURCE_FOOD_USED = ConvertPlayerState(5) ---@type playerstate constant
PLAYER_STATE_FOOD_CAP_CEILING = ConvertPlayerState(6) ---@type playerstate constant
PLAYER_STATE_GIVES_BOUNTY = ConvertPlayerState(7) ---@type playerstate constant
PLAYER_STATE_ALLIED_VICTORY = ConvertPlayerState(8) ---@type playerstate constant
PLAYER_STATE_PLACED = ConvertPlayerState(9) ---@type playerstate constant
PLAYER_STATE_OBSERVER_ON_DEATH = ConvertPlayerState(10) ---@type playerstate constant
PLAYER_STATE_OBSERVER = ConvertPlayerState(11) ---@type playerstate constant
PLAYER_STATE_UNFOLLOWABLE = ConvertPlayerState(12) ---@type playerstate constant
PLAYER_STATE_GOLD_UPKEEP_RATE = ConvertPlayerState(13) ---@type playerstate constant
PLAYER_STATE_LUMBER_UPKEEP_RATE = ConvertPlayerState(14) ---@type playerstate constant
PLAYER_STATE_GOLD_GATHERED = ConvertPlayerState(15) ---@type playerstate constant
PLAYER_STATE_LUMBER_GATHERED = ConvertPlayerState(16) ---@type playerstate constant
PLAYER_STATE_NO_CREEP_SLEEP = ConvertPlayerState(25) ---@type playerstate constant
UNIT_STATE_LIFE = ConvertUnitState(0) ---@type unitstate constant
UNIT_STATE_MAX_LIFE = ConvertUnitState(1) ---@type unitstate constant
UNIT_STATE_MANA = ConvertUnitState(2) ---@type unitstate constant
UNIT_STATE_MAX_MANA = ConvertUnitState(3) ---@type unitstate constant
AI_DIFFICULTY_NEWBIE = ConvertAIDifficulty(0) ---@type aidifficulty constant
AI_DIFFICULTY_NORMAL = ConvertAIDifficulty(1) ---@type aidifficulty constant
AI_DIFFICULTY_INSANE = ConvertAIDifficulty(2) ---@type aidifficulty constant
PLAYER_SCORE_UNITS_TRAINED = ConvertPlayerScore(0) ---@type playerscore constant
PLAYER_SCORE_UNITS_KILLED = ConvertPlayerScore(1) ---@type playerscore constant
PLAYER_SCORE_STRUCT_BUILT = ConvertPlayerScore(2) ---@type playerscore constant
PLAYER_SCORE_STRUCT_RAZED = ConvertPlayerScore(3) ---@type playerscore constant
PLAYER_SCORE_TECH_PERCENT = ConvertPlayerScore(4) ---@type playerscore constant
PLAYER_SCORE_FOOD_MAXPROD = ConvertPlayerScore(5) ---@type playerscore constant
PLAYER_SCORE_FOOD_MAXUSED = ConvertPlayerScore(6) ---@type playerscore constant
PLAYER_SCORE_HEROES_KILLED = ConvertPlayerScore(7) ---@type playerscore constant
PLAYER_SCORE_ITEMS_GAINED = ConvertPlayerScore(8) ---@type playerscore constant
PLAYER_SCORE_MERCS_HIRED = ConvertPlayerScore(9) ---@type playerscore constant
PLAYER_SCORE_GOLD_MINED_TOTAL = ConvertPlayerScore(10) ---@type playerscore constant
PLAYER_SCORE_GOLD_MINED_UPKEEP = ConvertPlayerScore(11) ---@type playerscore constant
PLAYER_SCORE_GOLD_LOST_UPKEEP = ConvertPlayerScore(12) ---@type playerscore constant
PLAYER_SCORE_GOLD_LOST_TAX = ConvertPlayerScore(13) ---@type playerscore constant
PLAYER_SCORE_GOLD_GIVEN = ConvertPlayerScore(14) ---@type playerscore constant
PLAYER_SCORE_GOLD_RECEIVED = ConvertPlayerScore(15) ---@type playerscore constant
PLAYER_SCORE_LUMBER_TOTAL = ConvertPlayerScore(16) ---@type playerscore constant
PLAYER_SCORE_LUMBER_LOST_UPKEEP = ConvertPlayerScore(17) ---@type playerscore constant
PLAYER_SCORE_LUMBER_LOST_TAX = ConvertPlayerScore(18) ---@type playerscore constant
PLAYER_SCORE_LUMBER_GIVEN = ConvertPlayerScore(19) ---@type playerscore constant
PLAYER_SCORE_LUMBER_RECEIVED = ConvertPlayerScore(20) ---@type playerscore constant
PLAYER_SCORE_UNIT_TOTAL = ConvertPlayerScore(21) ---@type playerscore constant
PLAYER_SCORE_HERO_TOTAL = ConvertPlayerScore(22) ---@type playerscore constant
PLAYER_SCORE_RESOURCE_TOTAL = ConvertPlayerScore(23) ---@type playerscore constant
PLAYER_SCORE_TOTAL = ConvertPlayerScore(24) ---@type playerscore constant
EVENT_GAME_VICTORY = ConvertGameEvent(0) ---@type gameevent constant
EVENT_GAME_END_LEVEL = ConvertGameEvent(1) ---@type gameevent constant
EVENT_GAME_VARIABLE_LIMIT = ConvertGameEvent(2) ---@type gameevent constant
EVENT_GAME_STATE_LIMIT = ConvertGameEvent(3) ---@type gameevent constant
EVENT_GAME_TIMER_EXPIRED = ConvertGameEvent(4) ---@type gameevent constant
EVENT_GAME_ENTER_REGION = ConvertGameEvent(5) ---@type gameevent constant
EVENT_GAME_LEAVE_REGION = ConvertGameEvent(6) ---@type gameevent constant
EVENT_GAME_TRACKABLE_HIT = ConvertGameEvent(7) ---@type gameevent constant
EVENT_GAME_TRACKABLE_TRACK = ConvertGameEvent(8) ---@type gameevent constant
EVENT_GAME_SHOW_SKILL = ConvertGameEvent(9) ---@type gameevent constant
EVENT_GAME_BUILD_SUBMENU = ConvertGameEvent(10) ---@type gameevent constant
EVENT_PLAYER_STATE_LIMIT = ConvertPlayerEvent(11) ---@type playerevent constant
EVENT_PLAYER_ALLIANCE_CHANGED = ConvertPlayerEvent(12) ---@type playerevent constant
EVENT_PLAYER_DEFEAT = ConvertPlayerEvent(13) ---@type playerevent constant
EVENT_PLAYER_VICTORY = ConvertPlayerEvent(14) ---@type playerevent constant
EVENT_PLAYER_LEAVE = ConvertPlayerEvent(15) ---@type playerevent constant
EVENT_PLAYER_CHAT = ConvertPlayerEvent(16) ---@type playerevent constant
EVENT_PLAYER_END_CINEMATIC = ConvertPlayerEvent(17) ---@type playerevent constant
EVENT_PLAYER_UNIT_ATTACKED = ConvertPlayerUnitEvent(18) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_RESCUED = ConvertPlayerUnitEvent(19) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_DEATH = ConvertPlayerUnitEvent(20) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_DECAY = ConvertPlayerUnitEvent(21) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_DETECTED = ConvertPlayerUnitEvent(22) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_HIDDEN = ConvertPlayerUnitEvent(23) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SELECTED = ConvertPlayerUnitEvent(24) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_DESELECTED = ConvertPlayerUnitEvent(25) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_CONSTRUCT_START = ConvertPlayerUnitEvent(26) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_CONSTRUCT_CANCEL = ConvertPlayerUnitEvent(27) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_CONSTRUCT_FINISH = ConvertPlayerUnitEvent(28) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_UPGRADE_START = ConvertPlayerUnitEvent(29) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_UPGRADE_CANCEL = ConvertPlayerUnitEvent(30) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_UPGRADE_FINISH = ConvertPlayerUnitEvent(31) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_TRAIN_START = ConvertPlayerUnitEvent(32) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_TRAIN_CANCEL = ConvertPlayerUnitEvent(33) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_TRAIN_FINISH = ConvertPlayerUnitEvent(34) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_RESEARCH_START = ConvertPlayerUnitEvent(35) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_RESEARCH_CANCEL = ConvertPlayerUnitEvent(36) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_RESEARCH_FINISH = ConvertPlayerUnitEvent(37) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_ISSUED_ORDER = ConvertPlayerUnitEvent(38) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_ISSUED_POINT_ORDER = ConvertPlayerUnitEvent(39) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_ISSUED_TARGET_ORDER = ConvertPlayerUnitEvent(40) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_ISSUED_UNIT_ORDER = ConvertPlayerUnitEvent(40) ---@type playerunitevent constant
EVENT_PLAYER_HERO_LEVEL = ConvertPlayerUnitEvent(41) ---@type playerunitevent constant
EVENT_PLAYER_HERO_SKILL = ConvertPlayerUnitEvent(42) ---@type playerunitevent constant
EVENT_PLAYER_HERO_REVIVABLE = ConvertPlayerUnitEvent(43) ---@type playerunitevent constant
EVENT_PLAYER_HERO_REVIVE_START = ConvertPlayerUnitEvent(44) ---@type playerunitevent constant
EVENT_PLAYER_HERO_REVIVE_CANCEL = ConvertPlayerUnitEvent(45) ---@type playerunitevent constant
EVENT_PLAYER_HERO_REVIVE_FINISH = ConvertPlayerUnitEvent(46) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SUMMON = ConvertPlayerUnitEvent(47) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_DROP_ITEM = ConvertPlayerUnitEvent(48) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_PICKUP_ITEM = ConvertPlayerUnitEvent(49) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_USE_ITEM = ConvertPlayerUnitEvent(50) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_LOADED = ConvertPlayerUnitEvent(51) ---@type playerunitevent constant
EVENT_UNIT_DAMAGED = ConvertUnitEvent(52) ---@type unitevent constant
EVENT_UNIT_DEATH = ConvertUnitEvent(53) ---@type unitevent constant
EVENT_UNIT_DECAY = ConvertUnitEvent(54) ---@type unitevent constant
EVENT_UNIT_DETECTED = ConvertUnitEvent(55) ---@type unitevent constant
EVENT_UNIT_HIDDEN = ConvertUnitEvent(56) ---@type unitevent constant
EVENT_UNIT_SELECTED = ConvertUnitEvent(57) ---@type unitevent constant
EVENT_UNIT_DESELECTED = ConvertUnitEvent(58) ---@type unitevent constant
EVENT_UNIT_STATE_LIMIT = ConvertUnitEvent(59) ---@type unitevent constant
EVENT_UNIT_ACQUIRED_TARGET = ConvertUnitEvent(60) ---@type unitevent constant
EVENT_UNIT_TARGET_IN_RANGE = ConvertUnitEvent(61) ---@type unitevent constant
EVENT_UNIT_ATTACKED = ConvertUnitEvent(62) ---@type unitevent constant
EVENT_UNIT_RESCUED = ConvertUnitEvent(63) ---@type unitevent constant
EVENT_UNIT_CONSTRUCT_CANCEL = ConvertUnitEvent(64) ---@type unitevent constant
EVENT_UNIT_CONSTRUCT_FINISH = ConvertUnitEvent(65) ---@type unitevent constant
EVENT_UNIT_UPGRADE_START = ConvertUnitEvent(66) ---@type unitevent constant
EVENT_UNIT_UPGRADE_CANCEL = ConvertUnitEvent(67) ---@type unitevent constant
EVENT_UNIT_UPGRADE_FINISH = ConvertUnitEvent(68) ---@type unitevent constant
EVENT_UNIT_TRAIN_START = ConvertUnitEvent(69) ---@type unitevent constant
EVENT_UNIT_TRAIN_CANCEL = ConvertUnitEvent(70) ---@type unitevent constant
EVENT_UNIT_TRAIN_FINISH = ConvertUnitEvent(71) ---@type unitevent constant
EVENT_UNIT_RESEARCH_START = ConvertUnitEvent(72) ---@type unitevent constant
EVENT_UNIT_RESEARCH_CANCEL = ConvertUnitEvent(73) ---@type unitevent constant
EVENT_UNIT_RESEARCH_FINISH = ConvertUnitEvent(74) ---@type unitevent constant
EVENT_UNIT_ISSUED_ORDER = ConvertUnitEvent(75) ---@type unitevent constant
EVENT_UNIT_ISSUED_POINT_ORDER = ConvertUnitEvent(76) ---@type unitevent constant
EVENT_UNIT_ISSUED_TARGET_ORDER = ConvertUnitEvent(77) ---@type unitevent constant
EVENT_UNIT_HERO_LEVEL = ConvertUnitEvent(78) ---@type unitevent constant
EVENT_UNIT_HERO_SKILL = ConvertUnitEvent(79) ---@type unitevent constant
EVENT_UNIT_HERO_REVIVABLE = ConvertUnitEvent(80) ---@type unitevent constant
EVENT_UNIT_HERO_REVIVE_START = ConvertUnitEvent(81) ---@type unitevent constant
EVENT_UNIT_HERO_REVIVE_CANCEL = ConvertUnitEvent(82) ---@type unitevent constant
EVENT_UNIT_HERO_REVIVE_FINISH = ConvertUnitEvent(83) ---@type unitevent constant
EVENT_UNIT_SUMMON = ConvertUnitEvent(84) ---@type unitevent constant
EVENT_UNIT_DROP_ITEM = ConvertUnitEvent(85) ---@type unitevent constant
EVENT_UNIT_PICKUP_ITEM = ConvertUnitEvent(86) ---@type unitevent constant
EVENT_UNIT_USE_ITEM = ConvertUnitEvent(87) ---@type unitevent constant
EVENT_UNIT_LOADED = ConvertUnitEvent(88) ---@type unitevent constant
EVENT_WIDGET_DEATH = ConvertWidgetEvent(89) ---@type widgetevent constant
EVENT_DIALOG_BUTTON_CLICK = ConvertDialogEvent(90) ---@type dialogevent constant
EVENT_DIALOG_CLICK = ConvertDialogEvent(91) ---@type dialogevent constant
EVENT_GAME_LOADED = ConvertGameEvent(256) ---@type gameevent constant
EVENT_GAME_TOURNAMENT_FINISH_SOON = ConvertGameEvent(257) ---@type gameevent constant
EVENT_GAME_TOURNAMENT_FINISH_NOW = ConvertGameEvent(258) ---@type gameevent constant
EVENT_GAME_SAVE = ConvertGameEvent(259) ---@type gameevent constant
EVENT_PLAYER_ARROW_LEFT_DOWN = ConvertPlayerEvent(261) ---@type playerevent constant
EVENT_PLAYER_ARROW_LEFT_UP = ConvertPlayerEvent(262) ---@type playerevent constant
EVENT_PLAYER_ARROW_RIGHT_DOWN = ConvertPlayerEvent(263) ---@type playerevent constant
EVENT_PLAYER_ARROW_RIGHT_UP = ConvertPlayerEvent(264) ---@type playerevent constant
EVENT_PLAYER_ARROW_DOWN_DOWN = ConvertPlayerEvent(265) ---@type playerevent constant
EVENT_PLAYER_ARROW_DOWN_UP = ConvertPlayerEvent(266) ---@type playerevent constant
EVENT_PLAYER_ARROW_UP_DOWN = ConvertPlayerEvent(267) ---@type playerevent constant
EVENT_PLAYER_ARROW_UP_UP = ConvertPlayerEvent(268) ---@type playerevent constant
EVENT_PLAYER_UNIT_SELL = ConvertPlayerUnitEvent(269) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_CHANGE_OWNER = ConvertPlayerUnitEvent(270) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SELL_ITEM = ConvertPlayerUnitEvent(271) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SPELL_CHANNEL = ConvertPlayerUnitEvent(272) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SPELL_CAST = ConvertPlayerUnitEvent(273) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SPELL_EFFECT = ConvertPlayerUnitEvent(274) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SPELL_FINISH = ConvertPlayerUnitEvent(275) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_SPELL_ENDCAST = ConvertPlayerUnitEvent(276) ---@type playerunitevent constant
EVENT_PLAYER_UNIT_PAWN_ITEM = ConvertPlayerUnitEvent(277) ---@type playerunitevent constant
EVENT_UNIT_SELL = ConvertUnitEvent(286) ---@type unitevent constant
EVENT_UNIT_CHANGE_OWNER = ConvertUnitEvent(287) ---@type unitevent constant
EVENT_UNIT_SELL_ITEM = ConvertUnitEvent(288) ---@type unitevent constant
EVENT_UNIT_SPELL_CHANNEL = ConvertUnitEvent(289) ---@type unitevent constant
EVENT_UNIT_SPELL_CAST = ConvertUnitEvent(290) ---@type unitevent constant
EVENT_UNIT_SPELL_EFFECT = ConvertUnitEvent(291) ---@type unitevent constant
EVENT_UNIT_SPELL_FINISH = ConvertUnitEvent(292) ---@type unitevent constant
EVENT_UNIT_SPELL_ENDCAST = ConvertUnitEvent(293) ---@type unitevent constant
EVENT_UNIT_PAWN_ITEM = ConvertUnitEvent(294) ---@type unitevent constant
LESS_THAN = ConvertLimitOp(0) ---@type limitop constant
LESS_THAN_OR_EQUAL = ConvertLimitOp(1) ---@type limitop constant
EQUAL = ConvertLimitOp(2) ---@type limitop constant
GREATER_THAN_OR_EQUAL = ConvertLimitOp(3) ---@type limitop constant
GREATER_THAN = ConvertLimitOp(4) ---@type limitop constant
NOT_EQUAL = ConvertLimitOp(5) ---@type limitop constant
UNIT_TYPE_HERO = ConvertUnitType(0) ---@type unittype constant
UNIT_TYPE_DEAD = ConvertUnitType(1) ---@type unittype constant
UNIT_TYPE_STRUCTURE = ConvertUnitType(2) ---@type unittype constant
UNIT_TYPE_FLYING = ConvertUnitType(3) ---@type unittype constant
UNIT_TYPE_GROUND = ConvertUnitType(4) ---@type unittype constant
UNIT_TYPE_ATTACKS_FLYING = ConvertUnitType(5) ---@type unittype constant
UNIT_TYPE_ATTACKS_GROUND = ConvertUnitType(6) ---@type unittype constant
UNIT_TYPE_MELEE_ATTACKER = ConvertUnitType(7) ---@type unittype constant
UNIT_TYPE_RANGED_ATTACKER = ConvertUnitType(8) ---@type unittype constant
UNIT_TYPE_GIANT = ConvertUnitType(9) ---@type unittype constant
UNIT_TYPE_SUMMONED = ConvertUnitType(10) ---@type unittype constant
UNIT_TYPE_STUNNED = ConvertUnitType(11) ---@type unittype constant
UNIT_TYPE_PLAGUED = ConvertUnitType(12) ---@type unittype constant
UNIT_TYPE_SNARED = ConvertUnitType(13) ---@type unittype constant
UNIT_TYPE_UNDEAD = ConvertUnitType(14) ---@type unittype constant
UNIT_TYPE_MECHANICAL = ConvertUnitType(15) ---@type unittype constant
UNIT_TYPE_PEON = ConvertUnitType(16) ---@type unittype constant
UNIT_TYPE_SAPPER = ConvertUnitType(17) ---@type unittype constant
UNIT_TYPE_TOWNHALL = ConvertUnitType(18) ---@type unittype constant
UNIT_TYPE_ANCIENT = ConvertUnitType(19) ---@type unittype constant
UNIT_TYPE_TAUREN = ConvertUnitType(20) ---@type unittype constant
UNIT_TYPE_POISONED = ConvertUnitType(21) ---@type unittype constant
UNIT_TYPE_POLYMORPHED = ConvertUnitType(22) ---@type unittype constant
UNIT_TYPE_SLEEPING = ConvertUnitType(23) ---@type unittype constant
UNIT_TYPE_RESISTANT = ConvertUnitType(24) ---@type unittype constant
UNIT_TYPE_ETHEREAL = ConvertUnitType(25) ---@type unittype constant
UNIT_TYPE_MAGIC_IMMUNE = ConvertUnitType(26) ---@type unittype constant
ITEM_TYPE_PERMANENT = ConvertItemType(0) ---@type itemtype constant
ITEM_TYPE_CHARGED = ConvertItemType(1) ---@type itemtype constant
ITEM_TYPE_POWERUP = ConvertItemType(2) ---@type itemtype constant
ITEM_TYPE_ARTIFACT = ConvertItemType(3) ---@type itemtype constant
ITEM_TYPE_PURCHASABLE = ConvertItemType(4) ---@type itemtype constant
ITEM_TYPE_CAMPAIGN = ConvertItemType(5) ---@type itemtype constant
ITEM_TYPE_MISCELLANEOUS = ConvertItemType(6) ---@type itemtype constant
ITEM_TYPE_UNKNOWN = ConvertItemType(7) ---@type itemtype constant
ITEM_TYPE_ANY = ConvertItemType(8) ---@type itemtype constant
ITEM_TYPE_TOME = ConvertItemType(2) ---@type itemtype constant
CAMERA_FIELD_TARGET_DISTANCE = ConvertCameraField(0) ---@type camerafield constant
CAMERA_FIELD_FARZ = ConvertCameraField(1) ---@type camerafield constant
CAMERA_FIELD_ANGLE_OF_ATTACK = ConvertCameraField(2) ---@type camerafield constant
CAMERA_FIELD_FIELD_OF_VIEW = ConvertCameraField(3) ---@type camerafield constant
CAMERA_FIELD_ROLL = ConvertCameraField(4) ---@type camerafield constant
CAMERA_FIELD_ROTATION = ConvertCameraField(5) ---@type camerafield constant
CAMERA_FIELD_ZOFFSET = ConvertCameraField(6) ---@type camerafield constant
BLEND_MODE_NONE = ConvertBlendMode(0) ---@type blendmode constant
BLEND_MODE_DONT_CARE = ConvertBlendMode(0) ---@type blendmode constant
BLEND_MODE_KEYALPHA = ConvertBlendMode(1) ---@type blendmode constant
BLEND_MODE_BLEND = ConvertBlendMode(2) ---@type blendmode constant
BLEND_MODE_ADDITIVE = ConvertBlendMode(3) ---@type blendmode constant
BLEND_MODE_MODULATE = ConvertBlendMode(4) ---@type blendmode constant
BLEND_MODE_MODULATE_2X = ConvertBlendMode(5) ---@type blendmode constant
RARITY_FREQUENT = ConvertRarityControl(0) ---@type raritycontrol constant
RARITY_RARE = ConvertRarityControl(1) ---@type raritycontrol constant
TEXMAP_FLAG_NONE = ConvertTexMapFlags(0) ---@type texmapflags constant
TEXMAP_FLAG_WRAP_U = ConvertTexMapFlags(1) ---@type texmapflags constant
TEXMAP_FLAG_WRAP_V = ConvertTexMapFlags(2) ---@type texmapflags constant
TEXMAP_FLAG_WRAP_UV = ConvertTexMapFlags(3) ---@type texmapflags constant
FOG_OF_WAR_MASKED = ConvertFogState(1) ---@type fogstate constant
FOG_OF_WAR_FOGGED = ConvertFogState(2) ---@type fogstate constant
FOG_OF_WAR_VISIBLE = ConvertFogState(4) ---@type fogstate constant
CAMERA_MARGIN_LEFT = 0 ---@type number integer constant
CAMERA_MARGIN_RIGHT = 1 ---@type number integer constant
CAMERA_MARGIN_TOP = 2 ---@type number integer constant
CAMERA_MARGIN_BOTTOM = 3 ---@type number integer constant
EFFECT_TYPE_EFFECT = ConvertEffectType(0) ---@type effecttype constant
EFFECT_TYPE_TARGET = ConvertEffectType(1) ---@type effecttype constant
EFFECT_TYPE_CASTER = ConvertEffectType(2) ---@type effecttype constant
EFFECT_TYPE_SPECIAL = ConvertEffectType(3) ---@type effecttype constant
EFFECT_TYPE_AREA_EFFECT = ConvertEffectType(4) ---@type effecttype constant
EFFECT_TYPE_MISSILE = ConvertEffectType(5) ---@type effecttype constant
EFFECT_TYPE_LIGHTNING = ConvertEffectType(6) ---@type effecttype constant
SOUND_TYPE_EFFECT = ConvertSoundType(0) ---@type soundtype constant
SOUND_TYPE_EFFECT_LOOPED = ConvertSoundType(1) ---@type soundtype constant


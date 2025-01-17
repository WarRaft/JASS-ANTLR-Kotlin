globals
	constant real bj_PI_ = 3.14159
	constant real bj_E_ = 2.71828
	constant real bj_CELLWIDTH_ = 128.0
	constant real bj_CLIFFHEIGHT_ = 128.0
	constant real bj_UNIT_FACING_ = 270.0
	constant real bj_RADTODEG_ = 180.0 / bj_PI_
	constant real bj_DEGTORAD_ = bj_PI_ / 180.0
	constant real bj_TEXT_DELAY_QUEST_ = 20.00
	constant real bj_TEXT_DELAY_QUESTUPDATE_ = 20.00
	constant real bj_TEXT_DELAY_QUESTDONE_ = 20.00
	constant real bj_TEXT_DELAY_QUESTFAILED_ = 20.00
	constant real bj_TEXT_DELAY_QUESTREQUIREMENT_ = 20.00
	constant real bj_TEXT_DELAY_MISSIONFAILED_ = 20.00
	constant real bj_TEXT_DELAY_ALWAYSHINT_ = 12.00
	constant real bj_TEXT_DELAY_HINT_ = 12.00
	constant real bj_TEXT_DELAY_SECRET_ = 10.00
	constant real bj_TEXT_DELAY_UNITACQUIRED_ = 15.00
	constant real bj_TEXT_DELAY_UNITAVAILABLE_ = 10.00
	constant real bj_TEXT_DELAY_ITEMACQUIRED_ = 10.00
	constant real bj_TEXT_DELAY_WARNING_ = 12.00
	constant real bj_QUEUE_DELAY_QUEST_ = 5.00
	constant real bj_QUEUE_DELAY_HINT_ = 5.00
	constant real bj_QUEUE_DELAY_SECRET_ = 3.00
	constant real bj_HANDICAP_EASY_ = 60.00
	constant real bj_GAME_STARTED_THRESHOLD_ = 0.01
	constant real bj_WAIT_FOR_COND_MIN_INTERVAL_ = 0.10
	constant real bj_POLLED_WAIT_INTERVAL_ = 0.10
	constant real bj_POLLED_WAIT_SKIP_THRESHOLD_ = 2.00
	constant integer bj_MAX_INVENTORY_ = 6
	constant integer bj_MAX_PLAYERS_ = 12
	constant integer bj_PLAYER_NEUTRAL_VICTIM_ = 13
	constant integer bj_PLAYER_NEUTRAL_EXTRA_ = 14
	constant integer bj_MAX_PLAYER_SLOTS_ = 16
	constant integer bj_MAX_SKELETONS_ = 25
	constant integer bj_MAX_STOCK_ITEM_SLOTS_ = 11
	constant integer bj_MAX_STOCK_UNIT_SLOTS_ = 11
	constant integer bj_MAX_ITEM_LEVEL_ = 10
	constant real bj_TOD_DAWN_ = 6.00
	constant real bj_TOD_DUSK_ = 18.00
	constant real bj_MELEE_STARTING_TOD_ = 8.00
	constant integer bj_MELEE_STARTING_GOLD_V0_ = 750
	constant integer bj_MELEE_STARTING_GOLD_V1_ = 500
	constant integer bj_MELEE_STARTING_LUMBER_V0_ = 200
	constant integer bj_MELEE_STARTING_LUMBER_V1_ = 150
	constant integer bj_MELEE_STARTING_HERO_TOKENS_ = 1
	constant integer bj_MELEE_HERO_LIMIT_ = 3
	constant integer bj_MELEE_HERO_TYPE_LIMIT_ = 1
	constant real bj_MELEE_MINE_SEARCH_RADIUS_ = 2000
	constant real bj_MELEE_CLEAR_UNITS_RADIUS_ = 1500
	constant real bj_MELEE_CRIPPLE_TIMEOUT_ = 120.00
	constant real bj_MELEE_CRIPPLE_MSG_DURATION_ = 20.00
	constant integer bj_MELEE_MAX_TWINKED_HEROES_V0_ = 3
	constant integer bj_MELEE_MAX_TWINKED_HEROES_V1_ = 1
	constant real bj_CREEP_ITEM_DELAY_ = 0.50
	constant real bj_STOCK_RESTOCK_INITIAL_DELAY_ = 120
	constant real bj_STOCK_RESTOCK_INTERVAL_ = 30
	constant integer bj_STOCK_MAX_ITERATIONS_ = 20
	constant integer bj_MAX_DEST_IN_REGION_EVENTS_ = 64
	constant integer bj_CAMERA_MIN_FARZ_ = 100
	constant integer bj_CAMERA_DEFAULT_DISTANCE_ = 1650
	constant integer bj_CAMERA_DEFAULT_FARZ_ = 5000
	constant integer bj_CAMERA_DEFAULT_AOA_ = 304
	constant integer bj_CAMERA_DEFAULT_FOV_ = 70
	constant integer bj_CAMERA_DEFAULT_ROLL_ = 0
	constant integer bj_CAMERA_DEFAULT_ROTATION_ = 90
	constant real bj_RESCUE_PING_TIME_ = 2.00
	constant real bj_NOTHING_SOUND_DURATION_ = 5.00
	constant real bj_TRANSMISSION_PING_TIME_ = 1.00
	constant integer bj_TRANSMISSION_IND_RED_ = 255
	constant integer bj_TRANSMISSION_IND_BLUE_ = 255
	constant integer bj_TRANSMISSION_IND_GREEN_ = 255
	constant integer bj_TRANSMISSION_IND_ALPHA_ = 255
	constant real bj_TRANSMISSION_PORT_HANGTIME_ = 1.50
	constant real bj_CINEMODE_INTERFACEFADE_ = 0.50
	constant gamespeed bj_CINEMODE_GAMESPEED_ = MAP_SPEED_NORMAL_
	constant real bj_CINEMODE_VOLUME_UNITMOVEMENT_ = 0.40
	constant real bj_CINEMODE_VOLUME_UNITSOUNDS_ = 0.00
	constant real bj_CINEMODE_VOLUME_COMBAT_ = 0.40
	constant real bj_CINEMODE_VOLUME_SPELLS_ = 0.40
	constant real bj_CINEMODE_VOLUME_UI_ = 0.00
	constant real bj_CINEMODE_VOLUME_MUSIC_ = 0.55
	constant real bj_CINEMODE_VOLUME_AMBIENTSOUNDS_ = 1.00
	constant real bj_CINEMODE_VOLUME_FIRE_ = 0.60
	constant real bj_SPEECH_VOLUME_UNITMOVEMENT_ = 0.25
	constant real bj_SPEECH_VOLUME_UNITSOUNDS_ = 0.00
	constant real bj_SPEECH_VOLUME_COMBAT_ = 0.25
	constant real bj_SPEECH_VOLUME_SPELLS_ = 0.25
	constant real bj_SPEECH_VOLUME_UI_ = 0.00
	constant real bj_SPEECH_VOLUME_MUSIC_ = 0.55
	constant real bj_SPEECH_VOLUME_AMBIENTSOUNDS_ = 1.00
	constant real bj_SPEECH_VOLUME_FIRE_ = 0.60
	constant real bj_SMARTPAN_TRESHOLD_PAN_ = 500
	constant real bj_SMARTPAN_TRESHOLD_SNAP_ = 3500
	constant integer bj_MAX_QUEUED_TRIGGERS_ = 100
	constant real bj_QUEUED_TRIGGER_TIMEOUT_ = 180.00
	constant integer bj_CAMPAIGN_INDEX_T_ = 0
	constant integer bj_CAMPAIGN_INDEX_H_ = 1
	constant integer bj_CAMPAIGN_INDEX_U_ = 2
	constant integer bj_CAMPAIGN_INDEX_O_ = 3
	constant integer bj_CAMPAIGN_INDEX_N_ = 4
	constant integer bj_CAMPAIGN_INDEX_XN_ = 5
	constant integer bj_CAMPAIGN_INDEX_XH_ = 6
	constant integer bj_CAMPAIGN_INDEX_XU_ = 7
	constant integer bj_CAMPAIGN_INDEX_XO_ = 8
	constant integer bj_CAMPAIGN_OFFSET_T_ = 0
	constant integer bj_CAMPAIGN_OFFSET_H_ = 1
	constant integer bj_CAMPAIGN_OFFSET_U_ = 2
	constant integer bj_CAMPAIGN_OFFSET_O_ = 3
	constant integer bj_CAMPAIGN_OFFSET_N_ = 4
	constant integer bj_CAMPAIGN_OFFSET_XN_ = 0
	constant integer bj_CAMPAIGN_OFFSET_XH_ = 1
	constant integer bj_CAMPAIGN_OFFSET_XU_ = 2
	constant integer bj_CAMPAIGN_OFFSET_XO_ = 3
	constant integer bj_MISSION_INDEX_T00_ = bj_CAMPAIGN_OFFSET_T_ * 1000 + 0
	constant integer bj_MISSION_INDEX_T01_ = bj_CAMPAIGN_OFFSET_T_ * 1000 + 1
	constant integer bj_MISSION_INDEX_H00_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 0
	constant integer bj_MISSION_INDEX_H01_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 1
	constant integer bj_MISSION_INDEX_H02_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 2
	constant integer bj_MISSION_INDEX_H03_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 3
	constant integer bj_MISSION_INDEX_H04_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 4
	constant integer bj_MISSION_INDEX_H05_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 5
	constant integer bj_MISSION_INDEX_H06_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 6
	constant integer bj_MISSION_INDEX_H07_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 7
	constant integer bj_MISSION_INDEX_H08_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 8
	constant integer bj_MISSION_INDEX_H09_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 9
	constant integer bj_MISSION_INDEX_H10_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 10
	constant integer bj_MISSION_INDEX_H11_ = bj_CAMPAIGN_OFFSET_H_ * 1000 + 11
	constant integer bj_MISSION_INDEX_U00_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 0
	constant integer bj_MISSION_INDEX_U01_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 1
	constant integer bj_MISSION_INDEX_U02_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 2
	constant integer bj_MISSION_INDEX_U03_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 3
	constant integer bj_MISSION_INDEX_U05_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 4
	constant integer bj_MISSION_INDEX_U07_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 5
	constant integer bj_MISSION_INDEX_U08_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 6
	constant integer bj_MISSION_INDEX_U09_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 7
	constant integer bj_MISSION_INDEX_U10_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 8
	constant integer bj_MISSION_INDEX_U11_ = bj_CAMPAIGN_OFFSET_U_ * 1000 + 9
	constant integer bj_MISSION_INDEX_O00_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 0
	constant integer bj_MISSION_INDEX_O01_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 1
	constant integer bj_MISSION_INDEX_O02_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 2
	constant integer bj_MISSION_INDEX_O03_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 3
	constant integer bj_MISSION_INDEX_O04_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 4
	constant integer bj_MISSION_INDEX_O05_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 5
	constant integer bj_MISSION_INDEX_O06_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 6
	constant integer bj_MISSION_INDEX_O07_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 7
	constant integer bj_MISSION_INDEX_O08_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 8
	constant integer bj_MISSION_INDEX_O09_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 9
	constant integer bj_MISSION_INDEX_O10_ = bj_CAMPAIGN_OFFSET_O_ * 1000 + 10
	constant integer bj_MISSION_INDEX_N00_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 0
	constant integer bj_MISSION_INDEX_N01_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 1
	constant integer bj_MISSION_INDEX_N02_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 2
	constant integer bj_MISSION_INDEX_N03_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 3
	constant integer bj_MISSION_INDEX_N04_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 4
	constant integer bj_MISSION_INDEX_N05_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 5
	constant integer bj_MISSION_INDEX_N06_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 6
	constant integer bj_MISSION_INDEX_N07_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 7
	constant integer bj_MISSION_INDEX_N08_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 8
	constant integer bj_MISSION_INDEX_N09_ = bj_CAMPAIGN_OFFSET_N_ * 1000 + 9
	constant integer bj_MISSION_INDEX_XN00_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 0
	constant integer bj_MISSION_INDEX_XN01_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 1
	constant integer bj_MISSION_INDEX_XN02_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 2
	constant integer bj_MISSION_INDEX_XN03_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 3
	constant integer bj_MISSION_INDEX_XN04_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 4
	constant integer bj_MISSION_INDEX_XN05_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 5
	constant integer bj_MISSION_INDEX_XN06_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 6
	constant integer bj_MISSION_INDEX_XN07_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 7
	constant integer bj_MISSION_INDEX_XN08_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 8
	constant integer bj_MISSION_INDEX_XN09_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 9
	constant integer bj_MISSION_INDEX_XN10_ = bj_CAMPAIGN_OFFSET_XN_ * 1000 + 10
	constant integer bj_MISSION_INDEX_XH00_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 0
	constant integer bj_MISSION_INDEX_XH01_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 1
	constant integer bj_MISSION_INDEX_XH02_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 2
	constant integer bj_MISSION_INDEX_XH03_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 3
	constant integer bj_MISSION_INDEX_XH04_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 4
	constant integer bj_MISSION_INDEX_XH05_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 5
	constant integer bj_MISSION_INDEX_XH06_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 6
	constant integer bj_MISSION_INDEX_XH07_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 7
	constant integer bj_MISSION_INDEX_XH08_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 8
	constant integer bj_MISSION_INDEX_XH09_ = bj_CAMPAIGN_OFFSET_XH_ * 1000 + 9
	constant integer bj_MISSION_INDEX_XU00_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 0
	constant integer bj_MISSION_INDEX_XU01_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 1
	constant integer bj_MISSION_INDEX_XU02_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 2
	constant integer bj_MISSION_INDEX_XU03_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 3
	constant integer bj_MISSION_INDEX_XU04_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 4
	constant integer bj_MISSION_INDEX_XU05_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 5
	constant integer bj_MISSION_INDEX_XU06_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 6
	constant integer bj_MISSION_INDEX_XU07_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 7
	constant integer bj_MISSION_INDEX_XU08_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 8
	constant integer bj_MISSION_INDEX_XU09_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 9
	constant integer bj_MISSION_INDEX_XU10_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 10
	constant integer bj_MISSION_INDEX_XU11_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 11
	constant integer bj_MISSION_INDEX_XU12_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 12
	constant integer bj_MISSION_INDEX_XU13_ = bj_CAMPAIGN_OFFSET_XU_ * 1000 + 13
	constant integer bj_MISSION_INDEX_XO00_ = bj_CAMPAIGN_OFFSET_XO_ * 1000 + 0
	constant integer bj_CINEMATICINDEX_TOP_ = 0
	constant integer bj_CINEMATICINDEX_HOP_ = 1
	constant integer bj_CINEMATICINDEX_HED_ = 2
	constant integer bj_CINEMATICINDEX_OOP_ = 3
	constant integer bj_CINEMATICINDEX_OED_ = 4
	constant integer bj_CINEMATICINDEX_UOP_ = 5
	constant integer bj_CINEMATICINDEX_UED_ = 6
	constant integer bj_CINEMATICINDEX_NOP_ = 7
	constant integer bj_CINEMATICINDEX_NED_ = 8
	constant integer bj_CINEMATICINDEX_XOP_ = 9
	constant integer bj_CINEMATICINDEX_XED_ = 10
	constant integer bj_ALLIANCE_UNALLIED_ = 0
	constant integer bj_ALLIANCE_UNALLIED_VISION_ = 1
	constant integer bj_ALLIANCE_ALLIED_ = 2
	constant integer bj_ALLIANCE_ALLIED_VISION_ = 3
	constant integer bj_ALLIANCE_ALLIED_UNITS_ = 4
	constant integer bj_ALLIANCE_ALLIED_ADVUNITS_ = 5
	constant integer bj_ALLIANCE_NEUTRAL_ = 6
	constant integer bj_ALLIANCE_NEUTRAL_VISION_ = 7
	constant integer bj_KEYEVENTTYPE_DEPRESS_ = 0
	constant integer bj_KEYEVENTTYPE_RELEASE_ = 1
	constant integer bj_KEYEVENTKEY_LEFT_ = 0
	constant integer bj_KEYEVENTKEY_RIGHT_ = 1
	constant integer bj_KEYEVENTKEY_DOWN_ = 2
	constant integer bj_KEYEVENTKEY_UP_ = 3
	constant integer bj_TIMETYPE_ADD_ = 0
	constant integer bj_TIMETYPE_SET_ = 1
	constant integer bj_TIMETYPE_SUB_ = 2
	constant integer bj_CAMERABOUNDS_ADJUST_ADD_ = 0
	constant integer bj_CAMERABOUNDS_ADJUST_SUB_ = 1
	constant integer bj_QUESTTYPE_REQ_DISCOVERED_ = 0
	constant integer bj_QUESTTYPE_REQ_UNDISCOVERED_ = 1
	constant integer bj_QUESTTYPE_OPT_DISCOVERED_ = 2
	constant integer bj_QUESTTYPE_OPT_UNDISCOVERED_ = 3
	constant integer bj_QUESTMESSAGE_DISCOVERED_ = 0
	constant integer bj_QUESTMESSAGE_UPDATED_ = 1
	constant integer bj_QUESTMESSAGE_COMPLETED_ = 2
	constant integer bj_QUESTMESSAGE_FAILED_ = 3
	constant integer bj_QUESTMESSAGE_REQUIREMENT_ = 4
	constant integer bj_QUESTMESSAGE_MISSIONFAILED_ = 5
	constant integer bj_QUESTMESSAGE_ALWAYSHINT_ = 6
	constant integer bj_QUESTMESSAGE_HINT_ = 7
	constant integer bj_QUESTMESSAGE_SECRET_ = 8
	constant integer bj_QUESTMESSAGE_UNITACQUIRED_ = 9
	constant integer bj_QUESTMESSAGE_UNITAVAILABLE_ = 10
	constant integer bj_QUESTMESSAGE_ITEMACQUIRED_ = 11
	constant integer bj_QUESTMESSAGE_WARNING_ = 12
	constant integer bj_SORTTYPE_SORTBYVALUE_ = 0
	constant integer bj_SORTTYPE_SORTBYPLAYER_ = 1
	constant integer bj_SORTTYPE_SORTBYLABEL_ = 2
	constant integer bj_CINEFADETYPE_FADEIN_ = 0
	constant integer bj_CINEFADETYPE_FADEOUT_ = 1
	constant integer bj_CINEFADETYPE_FADEOUTIN_ = 2
	constant integer bj_REMOVEBUFFS_POSITIVE_ = 0
	constant integer bj_REMOVEBUFFS_NEGATIVE_ = 1
	constant integer bj_REMOVEBUFFS_ALL_ = 2
	constant integer bj_REMOVEBUFFS_NONTLIFE_ = 3
	constant integer bj_BUFF_POLARITY_POSITIVE_ = 0
	constant integer bj_BUFF_POLARITY_NEGATIVE_ = 1
	constant integer bj_BUFF_POLARITY_EITHER_ = 2
	constant integer bj_BUFF_RESIST_MAGIC_ = 0
	constant integer bj_BUFF_RESIST_PHYSICAL_ = 1
	constant integer bj_BUFF_RESIST_EITHER_ = 2
	constant integer bj_BUFF_RESIST_BOTH_ = 3
	constant integer bj_HEROSTAT_STR_ = 0
	constant integer bj_HEROSTAT_AGI_ = 1
	constant integer bj_HEROSTAT_INT_ = 2
	constant integer bj_MODIFYMETHOD_ADD_ = 0
	constant integer bj_MODIFYMETHOD_SUB_ = 1
	constant integer bj_MODIFYMETHOD_SET_ = 2
	constant integer bj_UNIT_STATE_METHOD_ABSOLUTE_ = 0
	constant integer bj_UNIT_STATE_METHOD_RELATIVE_ = 1
	constant integer bj_UNIT_STATE_METHOD_DEFAULTS_ = 2
	constant integer bj_UNIT_STATE_METHOD_MAXIMUM_ = 3
	constant integer bj_GATEOPERATION_CLOSE_ = 0
	constant integer bj_GATEOPERATION_OPEN_ = 1
	constant integer bj_GATEOPERATION_DESTROY_ = 2
	constant integer bj_GAMECACHE_BOOLEAN_ = 0
	constant integer bj_GAMECACHE_INTEGER_ = 1
	constant integer bj_GAMECACHE_REAL_ = 2
	constant integer bj_GAMECACHE_UNIT_ = 3
	constant integer bj_GAMECACHE_STRING_ = 4
	constant integer bj_HASHTABLE_BOOLEAN_ = 0
	constant integer bj_HASHTABLE_INTEGER_ = 1
	constant integer bj_HASHTABLE_REAL_ = 2
	constant integer bj_HASHTABLE_STRING_ = 3
	constant integer bj_HASHTABLE_HANDLE_ = 4
	constant integer bj_ITEM_STATUS_HIDDEN_ = 0
	constant integer bj_ITEM_STATUS_OWNED_ = 1
	constant integer bj_ITEM_STATUS_INVULNERABLE_ = 2
	constant integer bj_ITEM_STATUS_POWERUP_ = 3
	constant integer bj_ITEM_STATUS_SELLABLE_ = 4
	constant integer bj_ITEM_STATUS_PAWNABLE_ = 5
	constant integer bj_ITEMCODE_STATUS_POWERUP_ = 0
	constant integer bj_ITEMCODE_STATUS_SELLABLE_ = 1
	constant integer bj_ITEMCODE_STATUS_PAWNABLE_ = 2
	constant integer bj_MINIMAPPINGSTYLE_SIMPLE_ = 0
	constant integer bj_MINIMAPPINGSTYLE_FLASHY_ = 1
	constant integer bj_MINIMAPPINGSTYLE_ATTACK_ = 2
	constant real bj_CORPSE_MAX_DEATH_TIME_ = 8.00
	constant integer bj_CORPSETYPE_FLESH_ = 0
	constant integer bj_CORPSETYPE_BONE_ = 1
	constant integer bj_ELEVATOR_BLOCKER_CODE_ = 'DTep'
	constant integer bj_ELEVATOR_CODE01_ = 'DTrf'
	constant integer bj_ELEVATOR_CODE02_ = 'DTrx'
	constant integer bj_ELEVATOR_WALL_TYPE_ALL_ = 0
	constant integer bj_ELEVATOR_WALL_TYPE_EAST_ = 1
	constant integer bj_ELEVATOR_WALL_TYPE_NORTH_ = 2
	constant integer bj_ELEVATOR_WALL_TYPE_SOUTH_ = 3
	constant integer bj_ELEVATOR_WALL_TYPE_WEST_ = 4
	force bj_FORCE_ALL_PLAYERS_ = null
	force array bj_FORCE_PLAYER_
	integer bj_MELEE_MAX_TWINKED_HEROES_ = 0
	rect bj_mapInitialPlayableArea_ = null
	rect bj_mapInitialCameraBounds_ = null
	integer bj_forLoopAIndex_ = 0
	integer bj_forLoopBIndex_ = 0
	integer bj_forLoopAIndexEnd_ = 0
	integer bj_forLoopBIndexEnd_ = 0
	boolean bj_slotControlReady_ = false
	boolean array bj_slotControlUsed_
	mapcontrol array bj_slotControl_
	timer bj_gameStartedTimer_ = null
	boolean bj_gameStarted_ = false
	timer bj_volumeGroupsTimer_ = CreateTimer()
	boolean bj_isSinglePlayer_ = false
	trigger bj_dncSoundsDay_ = null
	trigger bj_dncSoundsNight_ = null
	sound bj_dayAmbientSound_ = null
	sound bj_nightAmbientSound_ = null
	trigger bj_dncSoundsDawn_ = null
	trigger bj_dncSoundsDusk_ = null
	sound bj_dawnSound_ = null
	sound bj_duskSound_ = null
	boolean bj_useDawnDuskSounds_ = true
	boolean bj_dncIsDaytime_ = false
	sound bj_rescueSound_ = null
	sound bj_questDiscoveredSound_ = null
	sound bj_questUpdatedSound_ = null
	sound bj_questCompletedSound_ = null
	sound bj_questFailedSound_ = null
	sound bj_questHintSound_ = null
	sound bj_questSecretSound_ = null
	sound bj_questItemAcquiredSound_ = null
	sound bj_questWarningSound_ = null
	sound bj_victoryDialogSound_ = null
	sound bj_defeatDialogSound_ = null
	trigger bj_stockItemPurchased_ = null
	timer bj_stockUpdateTimer_ = null
	boolean array bj_stockAllowedPermanent_
	boolean array bj_stockAllowedCharged_
	boolean array bj_stockAllowedArtifact_
	integer bj_stockPickedItemLevel_ = 0
	itemtype bj_stockPickedItemType_
	trigger bj_meleeVisibilityTrained_ = null
	boolean bj_meleeVisibilityIsDay_ = true
	boolean bj_meleeGrantHeroItems_ = false
	location bj_meleeNearestMineToLoc_ = null
	unit bj_meleeNearestMine_ = null
	real bj_meleeNearestMineDist_ = 0.00
	boolean bj_meleeGameOver_ = false
	boolean array bj_meleeDefeated_
	boolean array bj_meleeVictoried_
	unit array bj_ghoul_
	timer array bj_crippledTimer_
	timerdialog array bj_crippledTimerWindows_
	boolean array bj_playerIsCrippled_
	boolean array bj_playerIsExposed_
	boolean bj_finishSoonAllExposed_ = false
	timerdialog bj_finishSoonTimerDialog_ = null
	integer array bj_meleeTwinkedHeroes_
	trigger bj_rescueUnitBehavior_ = null
	boolean bj_rescueChangeColorUnit_ = true
	boolean bj_rescueChangeColorBldg_ = true
	timer bj_cineSceneEndingTimer_ = null
	sound bj_cineSceneLastSound_ = null
	trigger bj_cineSceneBeingSkipped_ = null
	gamespeed bj_cineModePriorSpeed_ = MAP_SPEED_NORMAL_
	boolean bj_cineModePriorFogSetting_ = false
	boolean bj_cineModePriorMaskSetting_ = false
	boolean bj_cineModeAlreadyIn_ = false
	boolean bj_cineModePriorDawnDusk_ = false
	integer bj_cineModeSavedSeed_ = 0
	timer bj_cineFadeFinishTimer_ = null
	timer bj_cineFadeContinueTimer_ = null
	real bj_cineFadeContinueRed_ = 0
	real bj_cineFadeContinueGreen_ = 0
	real bj_cineFadeContinueBlue_ = 0
	real bj_cineFadeContinueTrans_ = 0
	real bj_cineFadeContinueDuration_ = 0
	string bj_cineFadeContinueTex_ = ""
	integer bj_queuedExecTotal_ = 0
	trigger array bj_queuedExecTriggers_
	boolean array bj_queuedExecUseConds_
	timer bj_queuedExecTimeoutTimer_ = CreateTimer()
	trigger bj_queuedExecTimeout_ = null
	integer bj_destInRegionDiesCount_ = 0
	trigger bj_destInRegionDiesTrig_ = null
	integer bj_groupCountUnits_ = 0
	integer bj_forceCountPlayers_ = 0
	integer bj_groupEnumTypeId_ = 0
	player bj_groupEnumOwningPlayer_ = null
	group bj_groupAddGroupDest_ = null
	group bj_groupRemoveGroupDest_ = null
	integer bj_groupRandomConsidered_ = 0
	unit bj_groupRandomCurrentPick_ = null
	group bj_groupLastCreatedDest_ = null
	group bj_randomSubGroupGroup_ = null
	integer bj_randomSubGroupWant_ = 0
	integer bj_randomSubGroupTotal_ = 0
	real bj_randomSubGroupChance_ = 0
	integer bj_destRandomConsidered_ = 0
	destructable bj_destRandomCurrentPick_ = null
	destructable bj_elevatorWallBlocker_ = null
	destructable bj_elevatorNeighbor_ = null
	integer bj_itemRandomConsidered_ = 0
	item bj_itemRandomCurrentPick_ = null
	integer bj_forceRandomConsidered_ = 0
	player bj_forceRandomCurrentPick_ = null
	unit bj_makeUnitRescuableUnit_ = null
	boolean bj_makeUnitRescuableFlag_ = true
	boolean bj_pauseAllUnitsFlag_ = true
	location bj_enumDestructableCenter_ = null
	real bj_enumDestructableRadius_ = 0
	playercolor bj_setPlayerTargetColor_ = null
	boolean bj_isUnitGroupDeadResult_ = true
	boolean bj_isUnitGroupEmptyResult_ = true
	boolean bj_isUnitGroupInRectResult_ = true
	rect bj_isUnitGroupInRectRect_ = null
	boolean bj_changeLevelShowScores_ = false
	string bj_changeLevelMapName_ = null
	group bj_suspendDecayFleshGroup_ = CreateGroup()
	group bj_suspendDecayBoneGroup_ = CreateGroup()
	timer bj_delayedSuspendDecayTimer_ = CreateTimer()
	trigger bj_delayedSuspendDecayTrig_ = null
	integer bj_livingPlayerUnitsTypeId_ = 0
	widget bj_lastDyingWidget_ = null
	integer bj_randDistCount_ = 0
	integer array bj_randDistID_
	integer array bj_randDistChance_
	unit bj_lastCreatedUnit_ = null
	item bj_lastCreatedItem_ = null
	item bj_lastRemovedItem_ = null
	unit bj_lastHauntedGoldMine_ = null
	destructable bj_lastCreatedDestructable_ = null
	group bj_lastCreatedGroup_ = CreateGroup()
	fogmodifier bj_lastCreatedFogModifier_ = null
	effect bj_lastCreatedEffect_ = null
	weathereffect bj_lastCreatedWeatherEffect_ = null
	terraindeformation bj_lastCreatedTerrainDeformation_ = null
	quest bj_lastCreatedQuest_ = null
	questitem bj_lastCreatedQuestItem_ = null
	defeatcondition bj_lastCreatedDefeatCondition_ = null
	timer bj_lastStartedTimer_ = CreateTimer()
	timerdialog bj_lastCreatedTimerDialog_ = null
	leaderboard bj_lastCreatedLeaderboard_ = null
	multiboard bj_lastCreatedMultiboard_ = null
	sound bj_lastPlayedSound_ = null
	string bj_lastPlayedMusic_ = ""
	real bj_lastTransmissionDuration_ = 0
	gamecache bj_lastCreatedGameCache_ = null
	hashtable bj_lastCreatedHashtable_ = null
	unit bj_lastLoadedUnit_ = null
	button bj_lastCreatedButton_ = null
	unit bj_lastReplacedUnit_ = null
	texttag bj_lastCreatedTextTag_ = null
	lightning bj_lastCreatedLightning_ = null
	image bj_lastCreatedImage_ = null
	ubersplat bj_lastCreatedUbersplat_ = null
	boolexpr filterIssueHauntOrderAtLocBJ_ = null
	boolexpr filterEnumDestructablesInCircleBJ_ = null
	boolexpr filterGetUnitsInRectOfPlayer_ = null
	boolexpr filterGetUnitsOfTypeIdAll_ = null
	boolexpr filterGetUnitsOfPlayerAndTypeId_ = null
	boolexpr filterMeleeTrainedUnitIsHeroBJ_ = null
	boolexpr filterLivingPlayerUnitsOfTypeId_ = null
	boolean bj_wantDestroyGroup_ = false
endglobals

function BJDebugMsg takes string msg returns nothing
	local integer i = 0
	loop
		call DisplayTimedTextToPlayer(Player(i_), 0, 0, 60, msg_)
		set i_ = i_ + 1
		exitwhen i_ == bj_MAX_PLAYERS_
	endloop
endfunction

function RMinBJ takes real a, real b returns real
	if (a_ < b_) then
		return a_
	else
		return b_
	endif
endfunction

function RMaxBJ takes real a, real b returns real
	if (a_ < b_) then
		return b_
	else
		return a_
	endif
endfunction

function RAbsBJ takes real a returns real
	if (a_ >= 0) then
		return a_
	else
		return -a_
	endif
endfunction

function RSignBJ takes real a returns real
	if (a_ >= 0.0) then
		return 1.0
	else
		return -1.0
	endif
endfunction

function IMinBJ takes integer a, integer b returns integer
	if (a_ < b_) then
		return a_
	else
		return b_
	endif
endfunction

function IMaxBJ takes integer a, integer b returns integer
	if (a_ < b_) then
		return b_
	else
		return a_
	endif
endfunction

function IAbsBJ takes integer a returns integer
	if (a_ >= 0) then
		return a_
	else
		return -a_
	endif
endfunction

function ISignBJ takes integer a returns integer
	if (a_ >= 0) then
		return 1
	else
		return -1
	endif
endfunction

function SinBJ takes real degrees returns real
	return Sin(degrees_ * bj_DEGTORAD_)
endfunction

function CosBJ takes real degrees returns real
	return Cos(degrees_ * bj_DEGTORAD_)
endfunction

function TanBJ takes real degrees returns real
	return Tan(degrees_ * bj_DEGTORAD_)
endfunction

function AsinBJ takes real degrees returns real
	return Asin(degrees_) * bj_RADTODEG_
endfunction

function AcosBJ takes real degrees returns real
	return Acos(degrees_) * bj_RADTODEG_
endfunction

function AtanBJ takes real degrees returns real
	return Atan(degrees_) * bj_RADTODEG_
endfunction

function Atan2BJ takes real y, real x returns real
	return Atan2(y_, x_) * bj_RADTODEG_
endfunction

function AngleBetweenPoints takes location locA, location locB returns real
	return bj_RADTODEG_ * Atan2(GetLocationY(locB_) - GetLocationY(locA_), GetLocationX(locB_) - GetLocationX(locA_))
endfunction

function DistanceBetweenPoints takes location locA, location locB returns real
	local real dx = GetLocationX(locB_) - GetLocationX(locA_)
	local real dy = GetLocationY(locB_) - GetLocationY(locA_)
	return SquareRoot(dx_ * dx_ + dy_ * dy_)
endfunction

function PolarProjectionBJ takes location source, real dist, real angle returns location
	local real x = GetLocationX(source_) + dist_ * Cos(angle_ * bj_DEGTORAD_)
	local real y = GetLocationY(source_) + dist_ * Sin(angle_ * bj_DEGTORAD_)
	return Location(x_, y_)
endfunction

function GetRandomDirectionDeg takes nothing returns real
	return GetRandomReal(0, 360)
endfunction

function GetRandomPercentageBJ takes nothing returns real
	return GetRandomReal(0, 100)
endfunction

function GetRandomLocInRect takes rect whichRect returns location
	return Location(GetRandomReal(GetRectMinX(whichRect_), GetRectMaxX(whichRect_)), GetRandomReal(GetRectMinY(whichRect_), GetRectMaxY(whichRect_)))
endfunction

function ModuloInteger takes integer dividend, integer divisor returns integer
	local integer modulus = dividend_ - (dividend_ / divisor_) * divisor_
	if (modulus_ < 0) then
		set modulus_ = modulus_ + divisor_
	endif
	return modulus_
endfunction

function ModuloReal takes real dividend, real divisor returns real
	local real modulus = dividend_ - I2R(R2I(dividend_ / divisor_)) * divisor_
	if (modulus_ < 0) then
		set modulus_ = modulus_ + divisor_
	endif
	return modulus_
endfunction

function OffsetLocation takes location loc, real dx, real dy returns location
	return Location(GetLocationX(loc_) + dx_, GetLocationY(loc_) + dy_)
endfunction

function OffsetRectBJ takes rect r, real dx, real dy returns rect
	return Rect(GetRectMinX(r_) + dx_, GetRectMinY(r_) + dy_, GetRectMaxX(r_) + dx_, GetRectMaxY(r_) + dy_)
endfunction

function RectFromCenterSizeBJ takes location center, real width, real height returns rect
	local real x = GetLocationX(center_)
	local real y = GetLocationY(center_)
	return Rect(x_ - width_ * 0.5, y_ - height_ * 0.5, x_ + width_ * 0.5, y_ + height_ * 0.5)
endfunction

function RectContainsCoords takes rect r, real x, real y returns boolean
	return (GetRectMinX(r_) <= x_) and (x_ <= GetRectMaxX(r_)) and (GetRectMinY(r_) <= y_) and (y_ <= GetRectMaxY(r_))
endfunction

function RectContainsLoc takes rect r, location loc returns boolean
	return RectContainsCoords(r_, GetLocationX(loc_), GetLocationY(loc_))
endfunction

function RectContainsUnit takes rect r, unit whichUnit returns boolean
	return RectContainsCoords(r_, GetUnitX(whichUnit_), GetUnitY(whichUnit_))
endfunction

function RectContainsItem takes item whichItem, rect r returns boolean
	if (whichItem_ == null) then
		return false
	endif
	if (IsItemOwned(whichItem_)) then
		return false
	endif
	return RectContainsCoords(r_, GetItemX(whichItem_), GetItemY(whichItem_))
endfunction

function ConditionalTriggerExecute takes trigger trig returns nothing
	if TriggerEvaluate(trig_) then
		call TriggerExecute(trig_)
	endif
endfunction

function TriggerExecuteBJ takes trigger trig, boolean checkConditions returns boolean
	if checkConditions_ then
		if not (TriggerEvaluate(trig_)) then
			return false
		endif
	endif
	call TriggerExecute(trig_)
	return true
endfunction

function PostTriggerExecuteBJ takes trigger trig, boolean checkConditions returns boolean
	if checkConditions_ then
		if not (TriggerEvaluate(trig_)) then
			return false
		endif
	endif
	call TriggerRegisterTimerEvent(trig_, 0, false)
	return true
endfunction

function QueuedTriggerCheck takes nothing returns nothing
	local string s = "TrigQueue Check "
	local integer i
	set i_ = 0
	loop
		exitwhen i_ >= bj_queuedExecTotal_
		set s_ = s_ + "q[" + I2S(i_) + "]="
		if (bj_queuedExecTriggers_[i_] == null) then
			set s_ = s_ + "null "
		else
			set s_ = s_ + "x "
		endif
		set i_ = i_ + 1
	endloop
	set s_ = s_ + "(" + I2S(bj_queuedExecTotal_) + " total)"
	call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, 600, s_)
endfunction

function QueuedTriggerGetIndex takes trigger trig returns integer
	local integer index = 0
	loop
		exitwhen index_ >= bj_queuedExecTotal_
		if (bj_queuedExecTriggers_[index_] == trig_) then
			return index_
		endif
		set index_ = index_ + 1
	endloop
	return -1
endfunction

function QueuedTriggerRemoveByIndex takes integer trigIndex returns boolean
	local integer index
	if (trigIndex_ >= bj_queuedExecTotal_) then
		return false
	endif
	set bj_queuedExecTotal_ = bj_queuedExecTotal_ - 1
	set index_ = trigIndex_
	loop
		exitwhen index_ >= bj_queuedExecTotal_
		set bj_queuedExecTriggers_[index_] = bj_queuedExecTriggers_[index_ + 1]
		set bj_queuedExecUseConds_[index_] = bj_queuedExecUseConds_[index_ + 1]
		set index_ = index_ + 1
	endloop
	return true
endfunction

function QueuedTriggerAttemptExec takes nothing returns boolean
	loop
		exitwhen bj_queuedExecTotal_ == 0
		if TriggerExecuteBJ(bj_queuedExecTriggers_[0], bj_queuedExecUseConds_[0]) then
			call TimerStart(bj_queuedExecTimeoutTimer_, bj_QUEUED_TRIGGER_TIMEOUT_, false, null)
			return true
		endif
		call QueuedTriggerRemoveByIndex(0)
	endloop
	return false
endfunction

function QueuedTriggerAddBJ takes trigger trig, boolean checkConditions returns boolean
	if (bj_queuedExecTotal_ >= bj_MAX_QUEUED_TRIGGERS_) then
		return false
	endif
	set bj_queuedExecTriggers_[bj_queuedExecTotal_] = trig_
	set bj_queuedExecUseConds_[bj_queuedExecTotal_] = checkConditions_
	set bj_queuedExecTotal_ = bj_queuedExecTotal_ + 1
	if (bj_queuedExecTotal_ == 1) then
		call QueuedTriggerAttemptExec()
	endif
	return true
endfunction

function QueuedTriggerRemoveBJ takes trigger trig returns nothing
	local integer index
	local integer trigIndex
	local boolean trigExecuted
	set trigIndex_ = QueuedTriggerGetIndex(trig_)
	if (trigIndex_ == -1) then
		return
	endif
	call QueuedTriggerRemoveByIndex(trigIndex_)
	if (trigIndex_ == 0) then
		call PauseTimer(bj_queuedExecTimeoutTimer_)
		call QueuedTriggerAttemptExec()
	endif
endfunction

function QueuedTriggerDoneBJ takes nothing returns nothing
	local integer index
	if (bj_queuedExecTotal_ <= 0) then
		return
	endif
	call QueuedTriggerRemoveByIndex(0)
	call PauseTimer(bj_queuedExecTimeoutTimer_)
	call QueuedTriggerAttemptExec()
endfunction

function QueuedTriggerClearBJ takes nothing returns nothing
	call PauseTimer(bj_queuedExecTimeoutTimer_)
	set bj_queuedExecTotal_ = 0
endfunction

function QueuedTriggerClearInactiveBJ takes nothing returns nothing
	set bj_queuedExecTotal_ = IMinBJ(bj_queuedExecTotal_, 1)
endfunction

function QueuedTriggerCountBJ takes nothing returns integer
	return bj_queuedExecTotal_
endfunction

function IsTriggerQueueEmptyBJ takes nothing returns boolean
	return bj_queuedExecTotal_ <= 0
endfunction

function IsTriggerQueuedBJ takes trigger trig returns boolean
	return QueuedTriggerGetIndex(trig_) != -1
endfunction

function GetForLoopIndexA takes nothing returns integer
	return bj_forLoopAIndex_
endfunction

function SetForLoopIndexA takes integer newIndex returns nothing
	set bj_forLoopAIndex_ = newIndex_
endfunction

function GetForLoopIndexB takes nothing returns integer
	return bj_forLoopBIndex_
endfunction

function SetForLoopIndexB takes integer newIndex returns nothing
	set bj_forLoopBIndex_ = newIndex_
endfunction

function PolledWait takes real duration returns nothing
	local timer t
	local real timeRemaining
	if (duration_ > 0) then
		set t_ = CreateTimer()
		call TimerStart(t_, duration_, false, null)
		loop
			set timeRemaining_ = TimerGetRemaining(t_)
			exitwhen timeRemaining_ <= 0
			if (timeRemaining_ > bj_POLLED_WAIT_SKIP_THRESHOLD_) then
				call TriggerSleepAction(0.1 * timeRemaining_)
			else
				call TriggerSleepAction(bj_POLLED_WAIT_INTERVAL_)
			endif
		endloop
		call DestroyTimer(t_)
	endif
endfunction

function IntegerTertiaryOp takes boolean flag, integer valueA, integer valueB returns integer
	if flag_ then
		return valueA_
	else
		return valueB_
	endif
endfunction

function DoNothing takes nothing returns nothing
endfunction

function CommentString takes string commentString returns nothing
endfunction

function StringIdentity takes string theString returns string
	return GetLocalizedString(theString_)
endfunction

function GetBooleanAnd takes boolean valueA, boolean valueB returns boolean
	return valueA_ and valueB_
endfunction

function GetBooleanOr takes boolean valueA, boolean valueB returns boolean
	return valueA_ or valueB_
endfunction

function PercentToInt takes real percentage, integer max returns integer
	local integer result = R2I(percentage_ * I2R(max_) * 0.01)
	if (result_ < 0) then
		set result_ = 0
	elseif (result_ < 0) then
		set result_ = max_
	endif
	return result_
endfunction

function PercentTo255 takes real percentage returns integer
	return PercentToInt(percentage_, 255)
endfunction

function GetTimeOfDay takes nothing returns real
	return GetFloatGameState(GAME_STATE_TIME_OF_DAY_)
endfunction

function SetTimeOfDay takes real whatTime returns nothing
	call SetFloatGameState(GAME_STATE_TIME_OF_DAY_, whatTime_)
endfunction

function SetTimeOfDayScalePercentBJ takes real scalePercent returns nothing
	call SetTimeOfDayScale(scalePercent_ * 0.01)
endfunction

function GetTimeOfDayScalePercentBJ takes nothing returns real
	return GetTimeOfDayScale() * 100
endfunction

function PlaySound takes string soundName returns nothing
	local sound soundHandle = CreateSound(soundName_, false, false, true, 12700, 12700, "")
	call StartSound(soundHandle_)
	call KillSoundWhenDone(soundHandle_)
endfunction

function CompareLocationsBJ takes location A, location B returns boolean
	return GetLocationX(A_) == GetLocationX(B_) and GetLocationY(A_) == GetLocationY(B_)
endfunction

function CompareRectsBJ takes rect A, rect B returns boolean
	return GetRectMinX(A_) == GetRectMinX(B_) and GetRectMinY(A_) == GetRectMinY(B_) and GetRectMaxX(A_) == GetRectMaxX(B_) and GetRectMaxY(A_) == GetRectMaxY(B_)
endfunction

function GetRectFromCircleBJ takes location center, real radius returns rect
	local real centerX = GetLocationX(center_)
	local real centerY = GetLocationY(center_)
	return Rect(centerX_ - radius_, centerY_ - radius_, centerX_ + radius_, centerY_ + radius_)
endfunction

function GetCurrentCameraSetup takes nothing returns camerasetup
	local camerasetup theCam = CreateCameraSetup()
	local real duration = 0
	call CameraSetupSetField(theCam_, CAMERA_FIELD_TARGET_DISTANCE_, GetCameraField(CAMERA_FIELD_TARGET_DISTANCE_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_FARZ_, GetCameraField(CAMERA_FIELD_FARZ_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_ZOFFSET_, GetCameraField(CAMERA_FIELD_ZOFFSET_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_ANGLE_OF_ATTACK_, bj_RADTODEG_ * GetCameraField(CAMERA_FIELD_ANGLE_OF_ATTACK_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_FIELD_OF_VIEW_, bj_RADTODEG_ * GetCameraField(CAMERA_FIELD_FIELD_OF_VIEW_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_ROLL_, bj_RADTODEG_ * GetCameraField(CAMERA_FIELD_ROLL_), duration_)
	call CameraSetupSetField(theCam_, CAMERA_FIELD_ROTATION_, bj_RADTODEG_ * GetCameraField(CAMERA_FIELD_ROTATION_), duration_)
	call CameraSetupSetDestPosition(theCam_, GetCameraTargetPositionX(), GetCameraTargetPositionY(), duration_)
	return theCam_
endfunction

function CameraSetupApplyForPlayer takes boolean doPan, camerasetup whichSetup, player whichPlayer, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call CameraSetupApplyForceDuration(whichSetup_, doPan_, duration_)
	endif
endfunction

function CameraSetupGetFieldSwap takes camerafield whichField, camerasetup whichSetup returns real
	return CameraSetupGetField(whichSetup_, whichField_)
endfunction

function SetCameraFieldForPlayer takes player whichPlayer, camerafield whichField, real value, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraField(whichField_, value_, duration_)
	endif
endfunction

function SetCameraTargetControllerNoZForPlayer takes player whichPlayer, unit whichUnit, real xoffset, real yoffset, boolean inheritOrientation returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraTargetController(whichUnit_, xoffset_, yoffset_, inheritOrientation_)
	endif
endfunction

function SetCameraPositionForPlayer takes player whichPlayer, real x, real y returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraPosition(x_, y_)
	endif
endfunction

function SetCameraPositionLocForPlayer takes player whichPlayer, location loc returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraPosition(GetLocationX(loc_), GetLocationY(loc_))
	endif
endfunction

function RotateCameraAroundLocBJ takes real degrees, location loc, player whichPlayer, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraRotateMode(GetLocationX(loc_), GetLocationY(loc_), bj_DEGTORAD_ * degrees_, duration_)
	endif
endfunction

function PanCameraToForPlayer takes player whichPlayer, real x, real y returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PanCameraTo(x_, y_)
	endif
endfunction

function PanCameraToLocForPlayer takes player whichPlayer, location loc returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PanCameraTo(GetLocationX(loc_), GetLocationY(loc_))
	endif
endfunction

function PanCameraToTimedForPlayer takes player whichPlayer, real x, real y, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PanCameraToTimed(x_, y_, duration_)
	endif
endfunction

function PanCameraToTimedLocForPlayer takes player whichPlayer, location loc, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PanCameraToTimed(GetLocationX(loc_), GetLocationY(loc_), duration_)
	endif
endfunction

function PanCameraToTimedLocWithZForPlayer takes player whichPlayer, location loc, real zOffset, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PanCameraToTimedWithZ(GetLocationX(loc_), GetLocationY(loc_), zOffset_, duration_)
	endif
endfunction

function SmartCameraPanBJ takes player whichPlayer, location loc, real duration returns nothing
	local real dist
	if (GetLocalPlayer() == whichPlayer_) then
		set dist_ = DistanceBetweenPoints(loc_, GetCameraTargetPositionLoc())
		if (dist_ >= bj_SMARTPAN_TRESHOLD_SNAP_) then
			call PanCameraToTimed(GetLocationX(loc_), GetLocationY(loc_), 0)
		elseif (dist_ >= bj_SMARTPAN_TRESHOLD_SNAP_) then
			call PanCameraToTimed(GetLocationX(loc_), GetLocationY(loc_), duration_)
		else
		endif
	endif
endfunction

function SetCinematicCameraForPlayer takes player whichPlayer, string cameraModelFile returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCinematicCamera(cameraModelFile_)
	endif
endfunction

function ResetToGameCameraForPlayer takes player whichPlayer, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ResetToGameCamera(duration_)
	endif
endfunction

function CameraSetSourceNoiseForPlayer takes player whichPlayer, real magnitude, real velocity returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call CameraSetSourceNoise(magnitude_, velocity_)
	endif
endfunction

function CameraSetTargetNoiseForPlayer takes player whichPlayer, real magnitude, real velocity returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call CameraSetTargetNoise(magnitude_, velocity_)
	endif
endfunction

function CameraSetEQNoiseForPlayer takes player whichPlayer, real magnitude returns nothing
	local real richter = magnitude_
	if (richter_ > 5.0) then
		set richter_ = 5.0
	endif
	if (richter_ < 2.0) then
		set richter_ = 2.0
	endif
	if (GetLocalPlayer() == whichPlayer_) then
		call CameraSetTargetNoiseEx(magnitude_ * 2.0, magnitude_ * Pow(10, richter_), true)
		call CameraSetSourceNoiseEx(magnitude_ * 2.0, magnitude_ * Pow(10, richter_), true)
	endif
endfunction

function CameraClearNoiseForPlayer takes player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call CameraSetSourceNoise(0, 0)
		call CameraSetTargetNoise(0, 0)
	endif
endfunction

function GetCurrentCameraBoundsMapRectBJ takes nothing returns rect
	return Rect(GetCameraBoundMinX(), GetCameraBoundMinY(), GetCameraBoundMaxX(), GetCameraBoundMaxY())
endfunction

function GetCameraBoundsMapRect takes nothing returns rect
	return bj_mapInitialCameraBounds_
endfunction

function GetPlayableMapRect takes nothing returns rect
	return bj_mapInitialPlayableArea_
endfunction

function GetEntireMapRect takes nothing returns rect
	return GetWorldBounds()
endfunction

function SetCameraBoundsToRect takes rect r returns nothing
	local real minX = GetRectMinX(r_)
	local real minY = GetRectMinY(r_)
	local real maxX = GetRectMaxX(r_)
	local real maxY = GetRectMaxY(r_)
	call SetCameraBounds(minX_, minY_, minX_, maxY_, maxX_, maxY_, maxX_, minY_)
endfunction

function SetCameraBoundsToRectForPlayerBJ takes player whichPlayer, rect r returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraBoundsToRect(r_)
	endif
endfunction

function AdjustCameraBoundsBJ takes integer adjustMethod, real dxWest, real dxEast, real dyNorth, real dySouth returns nothing
	local real minX = 0
	local real minY = 0
	local real maxX = 0
	local real maxY = 0
	local real scale = 0
	if (adjustMethod_ == bj_CAMERABOUNDS_ADJUST_ADD_) then
		set scale_ = 1
	elseif (adjustMethod_ == bj_CAMERABOUNDS_ADJUST_ADD_) then
		set scale_ = -1
	else
		return
	endif
	set minX_ = GetCameraBoundMinX() - scale_ * dxWest_
	set maxX_ = GetCameraBoundMaxX() + scale_ * dxEast_
	set minY_ = GetCameraBoundMinY() - scale_ * dySouth_
	set maxY_ = GetCameraBoundMaxY() + scale_ * dyNorth_
	if (maxX_ < minX_) then
		set minX_ = (minX_ + maxX_) * 0.5
		set maxX_ = minX_
	endif
	if (maxY_ < minY_) then
		set minY_ = (minY_ + maxY_) * 0.5
		set maxY_ = minY_
	endif
	call SetCameraBounds(minX_, minY_, minX_, maxY_, maxX_, maxY_, maxX_, minY_)
endfunction

function AdjustCameraBoundsForPlayerBJ takes integer adjustMethod, player whichPlayer, real dxWest, real dxEast, real dyNorth, real dySouth returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call AdjustCameraBoundsBJ(adjustMethod_, dxWest_, dxEast_, dyNorth_, dySouth_)
	endif
endfunction

function SetCameraQuickPositionForPlayer takes player whichPlayer, real x, real y returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraQuickPosition(x_, y_)
	endif
endfunction

function SetCameraQuickPositionLocForPlayer takes player whichPlayer, location loc returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraQuickPosition(GetLocationX(loc_), GetLocationY(loc_))
	endif
endfunction

function SetCameraQuickPositionLoc takes location loc returns nothing
	call SetCameraQuickPosition(GetLocationX(loc_), GetLocationY(loc_))
endfunction

function StopCameraForPlayerBJ takes player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call StopCamera()
	endif
endfunction

function SetCameraOrientControllerForPlayerBJ takes player whichPlayer, unit whichUnit, real xoffset, real yoffset returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SetCameraOrientController(whichUnit_, xoffset_, yoffset_)
	endif
endfunction

function CameraSetSmoothingFactorBJ takes real factor returns nothing
	call CameraSetSmoothingFactor(factor_)
endfunction

function CameraResetSmoothingFactorBJ takes nothing returns nothing
	call CameraSetSmoothingFactor(0)
endfunction

function DisplayTextToForce takes force toForce, string message returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), toForce_)) then
		call DisplayTextToPlayer(GetLocalPlayer(), 0, 0, message_)
	endif
endfunction

function DisplayTimedTextToForce takes force toForce, real duration, string message returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), toForce_)) then
		call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, duration_, message_)
	endif
endfunction

function ClearTextMessagesBJ takes force toForce returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), toForce_)) then
		call ClearTextMessages()
	endif
endfunction

function SubStringBJ takes string source, integer start, integer end returns string
	return SubString(source_, start_ - 1, end_)
endfunction

function GetHandleIdBJ takes handle h returns integer
	return GetHandleId(h_)
endfunction

function StringHashBJ takes string s returns integer
	return StringHash(s_)
endfunction

function TriggerRegisterTimerEventPeriodic takes trigger trig, real timeout returns event
	return TriggerRegisterTimerEvent(trig_, timeout_, true)
endfunction

function TriggerRegisterTimerEventSingle takes trigger trig, real timeout returns event
	return TriggerRegisterTimerEvent(trig_, timeout_, false)
endfunction

function TriggerRegisterTimerExpireEventBJ takes trigger trig, timer t returns event
	return TriggerRegisterTimerExpireEvent(trig_, t_)
endfunction

function TriggerRegisterPlayerUnitEventSimple takes trigger trig, player whichPlayer, playerunitevent whichEvent returns event
	return TriggerRegisterPlayerUnitEvent(trig_, whichPlayer_, whichEvent_, null)
endfunction

function TriggerRegisterAnyUnitEventBJ takes trigger trig, playerunitevent whichEvent returns nothing
	local integer index
	set index_ = 0
	loop
		call TriggerRegisterPlayerUnitEvent(trig_, Player(index_), whichEvent_, null)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYER_SLOTS_
	endloop
endfunction

function TriggerRegisterPlayerSelectionEventBJ takes trigger trig, player whichPlayer, boolean selected returns event
	if selected_ then
		return TriggerRegisterPlayerUnitEvent(trig_, whichPlayer_, EVENT_PLAYER_UNIT_SELECTED_, null)
	else
		return TriggerRegisterPlayerUnitEvent(trig_, whichPlayer_, EVENT_PLAYER_UNIT_DESELECTED_, null)
	endif
endfunction

function TriggerRegisterPlayerKeyEventBJ takes trigger trig, player whichPlayer, integer keType, integer keKey returns event
	if (keType_ == bj_KEYEVENTTYPE_DEPRESS_) then
		if (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_LEFT_DOWN_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_RIGHT_DOWN_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_DOWN_DOWN_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_UP_DOWN_)
		else
			return null
		endif
	elseif (keType_ == bj_KEYEVENTTYPE_DEPRESS_) then
		if (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_LEFT_UP_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_RIGHT_UP_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_DOWN_UP_)
		elseif (keKey_ == bj_KEYEVENTKEY_LEFT_) then
			return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ARROW_UP_UP_)
		else
			return null
		endif
	else
		return null
	endif
endfunction

function TriggerRegisterPlayerEventVictory takes trigger trig, player whichPlayer returns event
	return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_VICTORY_)
endfunction

function TriggerRegisterPlayerEventDefeat takes trigger trig, player whichPlayer returns event
	return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_DEFEAT_)
endfunction

function TriggerRegisterPlayerEventLeave takes trigger trig, player whichPlayer returns event
	return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_LEAVE_)
endfunction

function TriggerRegisterPlayerEventAllianceChanged takes trigger trig, player whichPlayer returns event
	return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_ALLIANCE_CHANGED_)
endfunction

function TriggerRegisterPlayerEventEndCinematic takes trigger trig, player whichPlayer returns event
	return TriggerRegisterPlayerEvent(trig_, whichPlayer_, EVENT_PLAYER_END_CINEMATIC_)
endfunction

function TriggerRegisterGameStateEventTimeOfDay takes trigger trig, limitop opcode, real limitval returns event
	return TriggerRegisterGameStateEvent(trig_, GAME_STATE_TIME_OF_DAY_, opcode_, limitval_)
endfunction

function TriggerRegisterEnterRegionSimple takes trigger trig, region whichRegion returns event
	return TriggerRegisterEnterRegion(trig_, whichRegion_, null)
endfunction

function TriggerRegisterLeaveRegionSimple takes trigger trig, region whichRegion returns event
	return TriggerRegisterLeaveRegion(trig_, whichRegion_, null)
endfunction

function TriggerRegisterEnterRectSimple takes trigger trig, rect r returns event
	local region rectRegion = CreateRegion()
	call RegionAddRect(rectRegion_, r_)
	return TriggerRegisterEnterRegion(trig_, rectRegion_, null)
endfunction

function TriggerRegisterLeaveRectSimple takes trigger trig, rect r returns event
	local region rectRegion = CreateRegion()
	call RegionAddRect(rectRegion_, r_)
	return TriggerRegisterLeaveRegion(trig_, rectRegion_, null)
endfunction

function TriggerRegisterDistanceBetweenUnits takes trigger trig, unit whichUnit, boolexpr condition, real range returns event
	return TriggerRegisterUnitInRange(trig_, whichUnit_, range_, condition_)
endfunction

function TriggerRegisterUnitInRangeSimple takes trigger trig, real range, unit whichUnit returns event
	return TriggerRegisterUnitInRange(trig_, whichUnit_, range_, null)
endfunction

function TriggerRegisterUnitLifeEvent takes trigger trig, unit whichUnit, limitop opcode, real limitval returns event
	return TriggerRegisterUnitStateEvent(trig_, whichUnit_, UNIT_STATE_LIFE_, opcode_, limitval_)
endfunction

function TriggerRegisterUnitManaEvent takes trigger trig, unit whichUnit, limitop opcode, real limitval returns event
	return TriggerRegisterUnitStateEvent(trig_, whichUnit_, UNIT_STATE_MANA_, opcode_, limitval_)
endfunction

function TriggerRegisterDialogEventBJ takes trigger trig, dialog whichDialog returns event
	return TriggerRegisterDialogEvent(trig_, whichDialog_)
endfunction

function TriggerRegisterShowSkillEventBJ takes trigger trig returns event
	return TriggerRegisterGameEvent(trig_, EVENT_GAME_SHOW_SKILL_)
endfunction

function TriggerRegisterBuildSubmenuEventBJ takes trigger trig returns event
	return TriggerRegisterGameEvent(trig_, EVENT_GAME_BUILD_SUBMENU_)
endfunction

function TriggerRegisterGameLoadedEventBJ takes trigger trig returns event
	return TriggerRegisterGameEvent(trig_, EVENT_GAME_LOADED_)
endfunction

function TriggerRegisterGameSavedEventBJ takes trigger trig returns event
	return TriggerRegisterGameEvent(trig_, EVENT_GAME_SAVE_)
endfunction

function RegisterDestDeathInRegionEnum takes nothing returns nothing
	set bj_destInRegionDiesCount_ = bj_destInRegionDiesCount_ + 1
	if (bj_destInRegionDiesCount_ <= bj_MAX_DEST_IN_REGION_EVENTS_) then
		call TriggerRegisterDeathEvent(bj_destInRegionDiesTrig_, GetEnumDestructable())
	endif
endfunction

function TriggerRegisterDestDeathInRegionEvent takes trigger trig, rect r returns nothing
	set bj_destInRegionDiesTrig_ = trig_
	set bj_destInRegionDiesCount_ = 0
	call EnumDestructablesInRect(r_, null, function RegisterDestDeathInRegionEnum)
endfunction

function AddWeatherEffectSaveLast takes rect where, integer effectID returns weathereffect
	set bj_lastCreatedWeatherEffect_ = AddWeatherEffect(where_, effectID_)
	return bj_lastCreatedWeatherEffect_
endfunction

function GetLastCreatedWeatherEffect takes nothing returns weathereffect
	return bj_lastCreatedWeatherEffect_
endfunction

function RemoveWeatherEffectBJ takes weathereffect whichWeatherEffect returns nothing
	call RemoveWeatherEffect(whichWeatherEffect_)
endfunction

function TerrainDeformationCraterBJ takes real duration, boolean permanent, location where, real radius, real depth returns terraindeformation
	set bj_lastCreatedTerrainDeformation_ = TerrainDeformCrater(GetLocationX(where_), GetLocationY(where_), radius_, depth_, R2I(duration_ * 1000), permanent_)
	return bj_lastCreatedTerrainDeformation_
endfunction

function TerrainDeformationRippleBJ takes real duration, boolean limitNeg, location where, real startRadius, real endRadius, real depth, real wavePeriod, real waveWidth returns terraindeformation
	local real spaceWave
	local real timeWave
	local real radiusRatio
	if (endRadius_ <= 0 or waveWidth_ <= 0 or wavePeriod_ <= 0) then
		return null
	endif
	set timeWave_ = 2.0 * duration_ / wavePeriod_
	set spaceWave_ = 2.0 * endRadius_ / waveWidth_
	set radiusRatio_ = startRadius_ / endRadius_
	set bj_lastCreatedTerrainDeformation_ = TerrainDeformRipple(GetLocationX(where_), GetLocationY(where_), endRadius_, depth_, R2I(duration_ * 1000), 1, spaceWave_, timeWave_, radiusRatio_, limitNeg_)
	return bj_lastCreatedTerrainDeformation_
endfunction

function TerrainDeformationWaveBJ takes real duration, location source, location target, real radius, real depth, real trailDelay returns terraindeformation
	local real distance
	local real dirX
	local real dirY
	local real speed
	set distance_ = DistanceBetweenPoints(source_, target_)
	if (distance_ == 0 or duration_ <= 0) then
		return null
	endif
	set dirX_ = (GetLocationX(target_) - GetLocationX(source_)) / distance_
	set dirY_ = (GetLocationY(target_) - GetLocationY(source_)) / distance_
	set speed_ = distance_ / duration_
	set bj_lastCreatedTerrainDeformation_ = TerrainDeformWave(GetLocationX(source_), GetLocationY(source_), dirX_, dirY_, distance_, speed_, radius_, depth_, R2I(trailDelay_ * 1000), 1)
	return bj_lastCreatedTerrainDeformation_
endfunction

function TerrainDeformationRandomBJ takes real duration, location where, real radius, real minDelta, real maxDelta, real updateInterval returns terraindeformation
	set bj_lastCreatedTerrainDeformation_ = TerrainDeformRandom(GetLocationX(where_), GetLocationY(where_), radius_, minDelta_, maxDelta_, R2I(duration_ * 1000), R2I(updateInterval_ * 1000))
	return bj_lastCreatedTerrainDeformation_
endfunction

function TerrainDeformationStopBJ takes terraindeformation deformation, real duration returns nothing
	call TerrainDeformStop(deformation_, R2I(duration_ * 1000))
endfunction

function GetLastCreatedTerrainDeformation takes nothing returns terraindeformation
	return bj_lastCreatedTerrainDeformation_
endfunction

function AddLightningLoc takes string codeName, location where1, location where2 returns lightning
	set bj_lastCreatedLightning_ = AddLightningEx(codeName_, true, GetLocationX(where1_), GetLocationY(where1_), GetLocationZ(where1_), GetLocationX(where2_), GetLocationY(where2_), GetLocationZ(where2_))
	return bj_lastCreatedLightning_
endfunction

function DestroyLightningBJ takes lightning whichBolt returns boolean
	return DestroyLightning(whichBolt_)
endfunction

function MoveLightningLoc takes lightning whichBolt, location where1, location where2 returns boolean
	return MoveLightningEx(whichBolt_, true, GetLocationX(where1_), GetLocationY(where1_), GetLocationZ(where1_), GetLocationX(where2_), GetLocationY(where2_), GetLocationZ(where2_))
endfunction

function GetLightningColorABJ takes lightning whichBolt returns real
	return GetLightningColorA(whichBolt_)
endfunction

function GetLightningColorRBJ takes lightning whichBolt returns real
	return GetLightningColorR(whichBolt_)
endfunction

function GetLightningColorGBJ takes lightning whichBolt returns real
	return GetLightningColorG(whichBolt_)
endfunction

function GetLightningColorBBJ takes lightning whichBolt returns real
	return GetLightningColorB(whichBolt_)
endfunction

function SetLightningColorBJ takes lightning whichBolt, real r, real g, real b, real a returns boolean
	return SetLightningColor(whichBolt_, r_, g_, b_, a_)
endfunction

function GetLastCreatedLightningBJ takes nothing returns lightning
	return bj_lastCreatedLightning_
endfunction

function GetAbilityEffectBJ takes integer abilcode, effecttype t, integer index returns string
	return GetAbilityEffectById(abilcode_, t_, index_)
endfunction

function GetAbilitySoundBJ takes integer abilcode, soundtype t returns string
	return GetAbilitySoundById(abilcode_, t_)
endfunction

function GetTerrainCliffLevelBJ takes location where returns integer
	return GetTerrainCliffLevel(GetLocationX(where_), GetLocationY(where_))
endfunction

function GetTerrainTypeBJ takes location where returns integer
	return GetTerrainType(GetLocationX(where_), GetLocationY(where_))
endfunction

function GetTerrainVarianceBJ takes location where returns integer
	return GetTerrainVariance(GetLocationX(where_), GetLocationY(where_))
endfunction

function SetTerrainTypeBJ takes location where, integer terrainType, integer variation, integer area, integer shape returns nothing
	call SetTerrainType(GetLocationX(where_), GetLocationY(where_), terrainType_, variation_, area_, shape_)
endfunction

function IsTerrainPathableBJ takes location where, pathingtype t returns boolean
	return IsTerrainPathable(GetLocationX(where_), GetLocationY(where_), t_)
endfunction

function SetTerrainPathableBJ takes location where, pathingtype t, boolean flag returns nothing
	call SetTerrainPathable(GetLocationX(where_), GetLocationY(where_), t_, flag_)
endfunction

function SetWaterBaseColorBJ takes real red, real green, real blue, real transparency returns nothing
	call SetWaterBaseColor(PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function CreateFogModifierRectSimple takes player whichPlayer, fogstate whichFogState, rect r, boolean afterUnits returns fogmodifier
	set bj_lastCreatedFogModifier_ = CreateFogModifierRect(whichPlayer_, whichFogState_, r_, true, afterUnits_)
	return bj_lastCreatedFogModifier_
endfunction

function CreateFogModifierRadiusLocSimple takes player whichPlayer, fogstate whichFogState, location center, real radius, boolean afterUnits returns fogmodifier
	set bj_lastCreatedFogModifier_ = CreateFogModifierRadiusLoc(whichPlayer_, whichFogState_, center_, radius_, true, afterUnits_)
	return bj_lastCreatedFogModifier_
endfunction

function CreateFogModifierRectBJ takes boolean enabled, player whichPlayer, fogstate whichFogState, rect r returns fogmodifier
	set bj_lastCreatedFogModifier_ = CreateFogModifierRect(whichPlayer_, whichFogState_, r_, true, false)
	if enabled_ then
		call FogModifierStart(bj_lastCreatedFogModifier_)
	endif
	return bj_lastCreatedFogModifier_
endfunction

function CreateFogModifierRadiusLocBJ takes boolean enabled, player whichPlayer, fogstate whichFogState, location center, real radius returns fogmodifier
	set bj_lastCreatedFogModifier_ = CreateFogModifierRadiusLoc(whichPlayer_, whichFogState_, center_, radius_, true, false)
	if enabled_ then
		call FogModifierStart(bj_lastCreatedFogModifier_)
	endif
	return bj_lastCreatedFogModifier_
endfunction

function GetLastCreatedFogModifier takes nothing returns fogmodifier
	return bj_lastCreatedFogModifier_
endfunction

function FogEnableOn takes nothing returns nothing
	call FogEnable(true)
endfunction

function FogEnableOff takes nothing returns nothing
	call FogEnable(false)
endfunction

function FogMaskEnableOn takes nothing returns nothing
	call FogMaskEnable(true)
endfunction

function FogMaskEnableOff takes nothing returns nothing
	call FogMaskEnable(false)
endfunction

function UseTimeOfDayBJ takes boolean flag returns nothing
	call SuspendTimeOfDay(not flag_)
endfunction

function SetTerrainFogExBJ takes integer style, real zstart, real zend, real density, real red, real green, real blue returns nothing
	call SetTerrainFogEx(style_, zstart_, zend_, density_, red_ * 0.01, green_ * 0.01, blue_ * 0.01)
endfunction

function ResetTerrainFogBJ takes nothing returns nothing
	call ResetTerrainFog()
endfunction

function SetDoodadAnimationBJ takes string animName, integer doodadID, real radius, location center returns nothing
	call SetDoodadAnimation(GetLocationX(center_), GetLocationY(center_), radius_, doodadID_, false, animName_, false)
endfunction

function SetDoodadAnimationRectBJ takes string animName, integer doodadID, rect r returns nothing
	call SetDoodadAnimationRect(r_, doodadID_, animName_, false)
endfunction

function AddUnitAnimationPropertiesBJ takes boolean add, string animProperties, unit whichUnit returns nothing
	call AddUnitAnimationProperties(whichUnit_, animProperties_, add_)
endfunction

function CreateImageBJ takes string file, real size, location where, real zOffset, integer imageType returns image
	set bj_lastCreatedImage_ = CreateImage(file_, size_, size_, size_, GetLocationX(where_), GetLocationY(where_), zOffset_, 0, 0, 0, imageType_)
	return bj_lastCreatedImage_
endfunction

function ShowImageBJ takes boolean flag, image whichImage returns nothing
	call ShowImage(whichImage_, flag_)
endfunction

function SetImagePositionBJ takes image whichImage, location where, real zOffset returns nothing
	call SetImagePosition(whichImage_, GetLocationX(where_), GetLocationY(where_), zOffset_)
endfunction

function SetImageColorBJ takes image whichImage, real red, real green, real blue, real alpha returns nothing
	call SetImageColor(whichImage_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - alpha_))
endfunction

function GetLastCreatedImage takes nothing returns image
	return bj_lastCreatedImage_
endfunction

function CreateUbersplatBJ takes location where, string name, real red, real green, real blue, real alpha, boolean forcePaused, boolean noBirthTime returns ubersplat
	set bj_lastCreatedUbersplat_ = CreateUbersplat(GetLocationX(where_), GetLocationY(where_), name_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - alpha_), forcePaused_, noBirthTime_)
	return bj_lastCreatedUbersplat_
endfunction

function ShowUbersplatBJ takes boolean flag, ubersplat whichSplat returns nothing
	call ShowUbersplat(whichSplat_, flag_)
endfunction

function GetLastCreatedUbersplat takes nothing returns ubersplat
	return bj_lastCreatedUbersplat_
endfunction

function PlaySoundBJ takes sound soundHandle returns nothing
	set bj_lastPlayedSound_ = soundHandle_
	if (soundHandle_ != null) then
		call StartSound(soundHandle_)
	endif
endfunction

function StopSoundBJ takes sound soundHandle, boolean fadeOut returns nothing
	call StopSound(soundHandle_, false, fadeOut_)
endfunction

function SetSoundVolumeBJ takes sound soundHandle, real volumePercent returns nothing
	call SetSoundVolume(soundHandle_, PercentToInt(volumePercent_, 127))
endfunction

function SetSoundOffsetBJ takes real newOffset, sound soundHandle returns nothing
	call SetSoundPlayPosition(soundHandle_, R2I(newOffset_ * 1000))
endfunction

function SetSoundDistanceCutoffBJ takes sound soundHandle, real cutoff returns nothing
	call SetSoundDistanceCutoff(soundHandle_, cutoff_)
endfunction

function SetSoundPitchBJ takes sound soundHandle, real pitch returns nothing
	call SetSoundPitch(soundHandle_, pitch_)
endfunction

function SetSoundPositionLocBJ takes sound soundHandle, location loc, real z returns nothing
	call SetSoundPosition(soundHandle_, GetLocationX(loc_), GetLocationY(loc_), z_)
endfunction

function AttachSoundToUnitBJ takes sound soundHandle, unit whichUnit returns nothing
	call AttachSoundToUnit(soundHandle_, whichUnit_)
endfunction

function SetSoundConeAnglesBJ takes sound soundHandle, real inside, real outside, real outsideVolumePercent returns nothing
	call SetSoundConeAngles(soundHandle_, inside_, outside_, PercentToInt(outsideVolumePercent_, 127))
endfunction

function KillSoundWhenDoneBJ takes sound soundHandle returns nothing
	call KillSoundWhenDone(soundHandle_)
endfunction

function PlaySoundAtPointBJ takes sound soundHandle, real volumePercent, location loc, real z returns nothing
	call SetSoundPositionLocBJ(soundHandle_, loc_, z_)
	call SetSoundVolumeBJ(soundHandle_, volumePercent_)
	call PlaySoundBJ(soundHandle_)
endfunction

function PlaySoundOnUnitBJ takes sound soundHandle, real volumePercent, unit whichUnit returns nothing
	call AttachSoundToUnitBJ(soundHandle_, whichUnit_)
	call SetSoundVolumeBJ(soundHandle_, volumePercent_)
	call PlaySoundBJ(soundHandle_)
endfunction

function PlaySoundFromOffsetBJ takes sound soundHandle, real volumePercent, real startingOffset returns nothing
	call SetSoundVolumeBJ(soundHandle_, volumePercent_)
	call PlaySoundBJ(soundHandle_)
	call SetSoundOffsetBJ(startingOffset_, soundHandle_)
endfunction

function PlayMusicBJ takes string musicFileName returns nothing
	set bj_lastPlayedMusic_ = musicFileName_
	call PlayMusic(musicFileName_)
endfunction

function PlayMusicExBJ takes string musicFileName, real startingOffset, real fadeInTime returns nothing
	set bj_lastPlayedMusic_ = musicFileName_
	call PlayMusicEx(musicFileName_, R2I(startingOffset_ * 1000), R2I(fadeInTime_ * 1000))
endfunction

function SetMusicOffsetBJ takes real newOffset returns nothing
	call SetMusicPlayPosition(R2I(newOffset_ * 1000))
endfunction

function PlayThematicMusicBJ takes string musicName returns nothing
	call PlayThematicMusic(musicName_)
endfunction

function PlayThematicMusicExBJ takes string musicName, real startingOffset returns nothing
	call PlayThematicMusicEx(musicName_, R2I(startingOffset_ * 1000))
endfunction

function SetThematicMusicOffsetBJ takes real newOffset returns nothing
	call SetThematicMusicPlayPosition(R2I(newOffset_ * 1000))
endfunction

function EndThematicMusicBJ takes nothing returns nothing
	call EndThematicMusic()
endfunction

function StopMusicBJ takes boolean fadeOut returns nothing
	call StopMusic(fadeOut_)
endfunction

function ResumeMusicBJ takes nothing returns nothing
	call ResumeMusic()
endfunction

function SetMusicVolumeBJ takes real volumePercent returns nothing
	call SetMusicVolume(PercentToInt(volumePercent_, 127))
endfunction

function GetSoundDurationBJ takes sound soundHandle returns real
	if (soundHandle_ == null) then
		return bj_NOTHING_SOUND_DURATION_
	else
		return I2R(GetSoundDuration(soundHandle_)) * 0.001
	endif
endfunction

function GetSoundFileDurationBJ takes string musicFileName returns real
	return I2R(GetSoundFileDuration(musicFileName_)) * 0.001
endfunction

function GetLastPlayedSound takes nothing returns sound
	return bj_lastPlayedSound_
endfunction

function GetLastPlayedMusic takes nothing returns string
	return bj_lastPlayedMusic_
endfunction

function VolumeGroupSetVolumeBJ takes volumegroup vgroup, real percent returns nothing
	call VolumeGroupSetVolume(vgroup_, percent_ * 0.01)
endfunction

function SetCineModeVolumeGroupsImmediateBJ takes nothing returns nothing
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UNITMOVEMENT_, bj_CINEMODE_VOLUME_UNITMOVEMENT_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UNITSOUNDS_, bj_CINEMODE_VOLUME_UNITSOUNDS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_COMBAT_, bj_CINEMODE_VOLUME_COMBAT_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_SPELLS_, bj_CINEMODE_VOLUME_SPELLS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UI_, bj_CINEMODE_VOLUME_UI_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_MUSIC_, bj_CINEMODE_VOLUME_MUSIC_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_AMBIENTSOUNDS_, bj_CINEMODE_VOLUME_AMBIENTSOUNDS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_FIRE_, bj_CINEMODE_VOLUME_FIRE_)
endfunction

function SetCineModeVolumeGroupsBJ takes nothing returns nothing
	if bj_gameStarted_ then
		call SetCineModeVolumeGroupsImmediateBJ()
	else
		call TimerStart(bj_volumeGroupsTimer_, bj_GAME_STARTED_THRESHOLD_, false, function SetCineModeVolumeGroupsImmediateBJ)
	endif
endfunction

function SetSpeechVolumeGroupsImmediateBJ takes nothing returns nothing
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UNITMOVEMENT_, bj_SPEECH_VOLUME_UNITMOVEMENT_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UNITSOUNDS_, bj_SPEECH_VOLUME_UNITSOUNDS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_COMBAT_, bj_SPEECH_VOLUME_COMBAT_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_SPELLS_, bj_SPEECH_VOLUME_SPELLS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_UI_, bj_SPEECH_VOLUME_UI_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_MUSIC_, bj_SPEECH_VOLUME_MUSIC_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_AMBIENTSOUNDS_, bj_SPEECH_VOLUME_AMBIENTSOUNDS_)
	call VolumeGroupSetVolume(SOUND_VOLUMEGROUP_FIRE_, bj_SPEECH_VOLUME_FIRE_)
endfunction

function SetSpeechVolumeGroupsBJ takes nothing returns nothing
	if bj_gameStarted_ then
		call SetSpeechVolumeGroupsImmediateBJ()
	else
		call TimerStart(bj_volumeGroupsTimer_, bj_GAME_STARTED_THRESHOLD_, false, function SetSpeechVolumeGroupsImmediateBJ)
	endif
endfunction

function VolumeGroupResetImmediateBJ takes nothing returns nothing
	call VolumeGroupReset()
endfunction

function VolumeGroupResetBJ takes nothing returns nothing
	if bj_gameStarted_ then
		call VolumeGroupResetImmediateBJ()
	else
		call TimerStart(bj_volumeGroupsTimer_, bj_GAME_STARTED_THRESHOLD_, false, function VolumeGroupResetImmediateBJ)
	endif
endfunction

function GetSoundIsPlayingBJ takes sound soundHandle returns boolean
	return GetSoundIsLoading(soundHandle_) or GetSoundIsPlaying(soundHandle_)
endfunction

function WaitForSoundBJ takes sound soundHandle, real offset returns nothing
	call TriggerWaitForSound(soundHandle_, offset_)
endfunction

function SetMapMusicIndexedBJ takes string musicName, integer index returns nothing
	call SetMapMusic(musicName_, false, index_)
endfunction

function SetMapMusicRandomBJ takes string musicName returns nothing
	call SetMapMusic(musicName_, true, 0)
endfunction

function ClearMapMusicBJ takes nothing returns nothing
	call ClearMapMusic()
endfunction

function SetStackedSoundBJ takes boolean add, sound soundHandle, rect r returns nothing
	local real width = GetRectMaxX(r_) - GetRectMinX(r_)
	local real height = GetRectMaxY(r_) - GetRectMinY(r_)
	call SetSoundPosition(soundHandle_, GetRectCenterX(r_), GetRectCenterY(r_), 0)
	if add_ then
		call RegisterStackedSound(soundHandle_, true, width_, height_)
	else
		call UnregisterStackedSound(soundHandle_, true, width_, height_)
	endif
endfunction

function StartSoundForPlayerBJ takes player whichPlayer, sound soundHandle returns nothing
	if (whichPlayer_ == GetLocalPlayer()) then
		call StartSound(soundHandle_)
	endif
endfunction

function VolumeGroupSetVolumeForPlayerBJ takes player whichPlayer, volumegroup vgroup, real scale returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call VolumeGroupSetVolume(vgroup_, scale_)
	endif
endfunction

function EnableDawnDusk takes boolean flag returns nothing
	set bj_useDawnDuskSounds_ = flag_
endfunction

function IsDawnDuskEnabled takes nothing returns boolean
	return bj_useDawnDuskSounds_
endfunction

function SetAmbientDaySound takes string inLabel returns nothing
	local real ToD
	if (bj_dayAmbientSound_ != null) then
		call StopSound(bj_dayAmbientSound_, true, true)
	endif
	set bj_dayAmbientSound_ = CreateMIDISound(inLabel_, 20, 20)
	set ToD_ = GetTimeOfDay()
	if (ToD_ >= bj_TOD_DAWN_ and ToD_ < bj_TOD_DUSK_) then
		call StartSound(bj_dayAmbientSound_)
	endif
endfunction

function SetAmbientNightSound takes string inLabel returns nothing
	local real ToD
	if (bj_nightAmbientSound_ != null) then
		call StopSound(bj_nightAmbientSound_, true, true)
	endif
	set bj_nightAmbientSound_ = CreateMIDISound(inLabel_, 20, 20)
	set ToD_ = GetTimeOfDay()
	if (ToD_ < bj_TOD_DAWN_ or ToD_ >= bj_TOD_DUSK_) then
		call StartSound(bj_nightAmbientSound_)
	endif
endfunction

function AddSpecialEffectLocBJ takes location where, string modelName returns effect
	set bj_lastCreatedEffect_ = AddSpecialEffectLoc(modelName_, where_)
	return bj_lastCreatedEffect_
endfunction

function AddSpecialEffectTargetUnitBJ takes string attachPointName, widget targetWidget, string modelName returns effect
	set bj_lastCreatedEffect_ = AddSpecialEffectTarget(modelName_, targetWidget_, attachPointName_)
	return bj_lastCreatedEffect_
endfunction

function DestroyEffectBJ takes effect whichEffect returns nothing
	call DestroyEffect(whichEffect_)
endfunction

function GetLastCreatedEffectBJ takes nothing returns effect
	return bj_lastCreatedEffect_
endfunction

function GetItemLoc takes item whichItem returns location
	return Location(GetItemX(whichItem_), GetItemY(whichItem_))
endfunction

function GetItemLifeBJ takes widget whichWidget returns real
	return GetWidgetLife(whichWidget_)
endfunction

function SetItemLifeBJ takes widget whichWidget, real life returns nothing
	call SetWidgetLife(whichWidget_, life_)
endfunction

function AddHeroXPSwapped takes integer xpToAdd, unit whichHero, boolean showEyeCandy returns nothing
	call AddHeroXP(whichHero_, xpToAdd_, showEyeCandy_)
endfunction

function SetHeroLevelBJ takes unit whichHero, integer newLevel, boolean showEyeCandy returns nothing
	local integer oldLevel = GetHeroLevel(whichHero_)
	if (newLevel_ > oldLevel_) then
		call SetHeroLevel(whichHero_, newLevel_, showEyeCandy_)
	elseif (newLevel_ > oldLevel_) then
		call UnitStripHeroLevel(whichHero_, oldLevel_ - newLevel_)
	else
	endif
endfunction

function DecUnitAbilityLevelSwapped takes integer abilcode, unit whichUnit returns integer
	return DecUnitAbilityLevel(whichUnit_, abilcode_)
endfunction

function IncUnitAbilityLevelSwapped takes integer abilcode, unit whichUnit returns integer
	return IncUnitAbilityLevel(whichUnit_, abilcode_)
endfunction

function SetUnitAbilityLevelSwapped takes integer abilcode, unit whichUnit, integer level returns integer
	return SetUnitAbilityLevel(whichUnit_, abilcode_, level_)
endfunction

function GetUnitAbilityLevelSwapped takes integer abilcode, unit whichUnit returns integer
	return GetUnitAbilityLevel(whichUnit_, abilcode_)
endfunction

function UnitHasBuffBJ takes unit whichUnit, integer buffcode returns boolean
	return (GetUnitAbilityLevel(whichUnit_, buffcode_) > 0)
endfunction

function UnitRemoveBuffBJ takes integer buffcode, unit whichUnit returns boolean
	return UnitRemoveAbility(whichUnit_, buffcode_)
endfunction

function UnitAddItemSwapped takes item whichItem, unit whichHero returns boolean
	return UnitAddItem(whichHero_, whichItem_)
endfunction

function UnitAddItemByIdSwapped takes integer itemId, unit whichHero returns item
	set bj_lastCreatedItem_ = CreateItem(itemId_, GetUnitX(whichHero_), GetUnitY(whichHero_))
	call UnitAddItem(whichHero_, bj_lastCreatedItem_)
	return bj_lastCreatedItem_
endfunction

function UnitRemoveItemSwapped takes item whichItem, unit whichHero returns nothing
	set bj_lastRemovedItem_ = whichItem_
	call UnitRemoveItem(whichHero_, whichItem_)
endfunction

function UnitRemoveItemFromSlotSwapped takes integer itemSlot, unit whichHero returns item
	set bj_lastRemovedItem_ = UnitRemoveItemFromSlot(whichHero_, itemSlot_ - 1)
	return bj_lastRemovedItem_
endfunction

function CreateItemLoc takes integer itemId, location loc returns item
	set bj_lastCreatedItem_ = CreateItem(itemId_, GetLocationX(loc_), GetLocationY(loc_))
	return bj_lastCreatedItem_
endfunction

function GetLastCreatedItem takes nothing returns item
	return bj_lastCreatedItem_
endfunction

function GetLastRemovedItem takes nothing returns item
	return bj_lastRemovedItem_
endfunction

function SetItemPositionLoc takes item whichItem, location loc returns nothing
	call SetItemPosition(whichItem_, GetLocationX(loc_), GetLocationY(loc_))
endfunction

function GetLearnedSkillBJ takes nothing returns integer
	return GetLearnedSkill()
endfunction

function SuspendHeroXPBJ takes boolean flag, unit whichHero returns nothing
	call SuspendHeroXP(whichHero_, not flag_)
endfunction

function SetPlayerHandicapXPBJ takes player whichPlayer, real handicapPercent returns nothing
	call SetPlayerHandicapXP(whichPlayer_, handicapPercent_ * 0.01)
endfunction

function GetPlayerHandicapXPBJ takes player whichPlayer returns real
	return GetPlayerHandicapXP(whichPlayer_) * 100
endfunction

function SetPlayerHandicapBJ takes player whichPlayer, real handicapPercent returns nothing
	call SetPlayerHandicap(whichPlayer_, handicapPercent_ * 0.01)
endfunction

function GetPlayerHandicapBJ takes player whichPlayer returns real
	return GetPlayerHandicap(whichPlayer_) * 100
endfunction

function GetHeroStatBJ takes integer whichStat, unit whichHero, boolean includeBonuses returns integer
	if (whichStat_ == bj_HEROSTAT_STR_) then
		return GetHeroStr(whichHero_, includeBonuses_)
	elseif (whichStat_ == bj_HEROSTAT_STR_) then
		return GetHeroAgi(whichHero_, includeBonuses_)
	elseif (whichStat_ == bj_HEROSTAT_STR_) then
		return GetHeroInt(whichHero_, includeBonuses_)
	else
		return 0
	endif
endfunction

function SetHeroStat takes unit whichHero, integer whichStat, integer value returns nothing
	if (value_ <= 0) then
		return
	endif
	if (whichStat_ == bj_HEROSTAT_STR_) then
		call SetHeroStr(whichHero_, value_, true)
	elseif (whichStat_ == bj_HEROSTAT_STR_) then
		call SetHeroAgi(whichHero_, value_, true)
	elseif (whichStat_ == bj_HEROSTAT_STR_) then
		call SetHeroInt(whichHero_, value_, true)
	else
	endif
endfunction

function ModifyHeroStat takes integer whichStat, unit whichHero, integer modifyMethod, integer value returns nothing
	if (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		call SetHeroStat(whichHero_, whichStat_, GetHeroStatBJ(whichStat_, whichHero_, false) + value_)
	elseif (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		call SetHeroStat(whichHero_, whichStat_, GetHeroStatBJ(whichStat_, whichHero_, false) - value_)
	elseif (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		call SetHeroStat(whichHero_, whichStat_, value_)
	else
	endif
endfunction

function ModifyHeroSkillPoints takes unit whichHero, integer modifyMethod, integer value returns boolean
	if (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		return UnitModifySkillPoints(whichHero_, value_)
	elseif (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		return UnitModifySkillPoints(whichHero_, -value_)
	elseif (modifyMethod_ == bj_MODIFYMETHOD_ADD_) then
		return UnitModifySkillPoints(whichHero_, value_ - GetHeroSkillPoints(whichHero_))
	else
		return false
	endif
endfunction

function UnitDropItemPointBJ takes unit whichUnit, item whichItem, real x, real y returns boolean
	return UnitDropItemPoint(whichUnit_, whichItem_, x_, y_)
endfunction

function UnitDropItemPointLoc takes unit whichUnit, item whichItem, location loc returns boolean
	return UnitDropItemPoint(whichUnit_, whichItem_, GetLocationX(loc_), GetLocationY(loc_))
endfunction

function UnitDropItemSlotBJ takes unit whichUnit, item whichItem, integer slot returns boolean
	return UnitDropItemSlot(whichUnit_, whichItem_, slot_ - 1)
endfunction

function UnitDropItemTargetBJ takes unit whichUnit, item whichItem, widget target returns boolean
	return UnitDropItemTarget(whichUnit_, whichItem_, target_)
endfunction

function UnitUseItemDestructable takes unit whichUnit, item whichItem, widget target returns boolean
	return UnitUseItemTarget(whichUnit_, whichItem_, target_)
endfunction

function UnitUseItemPointLoc takes unit whichUnit, item whichItem, location loc returns boolean
	return UnitUseItemPoint(whichUnit_, whichItem_, GetLocationX(loc_), GetLocationY(loc_))
endfunction

function UnitItemInSlotBJ takes unit whichUnit, integer itemSlot returns item
	return UnitItemInSlot(whichUnit_, itemSlot_ - 1)
endfunction

function GetInventoryIndexOfItemTypeBJ takes unit whichUnit, integer itemId returns integer
	local integer index
	local item indexItem
	set index_ = 0
	loop
		set indexItem_ = UnitItemInSlot(whichUnit_, index_)
		if (indexItem_ != null) and (GetItemTypeId(indexItem_) == itemId_) then
			return index_ + 1
		endif
		set index_ = index_ + 1
		exitwhen index_ >= bj_MAX_INVENTORY_
	endloop
	return 0
endfunction

function GetItemOfTypeFromUnitBJ takes unit whichUnit, integer itemId returns item
	local integer index = GetInventoryIndexOfItemTypeBJ(whichUnit_, itemId_)
	if (index_ == 0) then
		return null
	else
		return UnitItemInSlot(whichUnit_, index_ - 1)
	endif
endfunction

function UnitHasItemOfTypeBJ takes unit whichUnit, integer itemId returns boolean
	return GetInventoryIndexOfItemTypeBJ(whichUnit_, itemId_) > 0
endfunction

function UnitInventoryCount takes unit whichUnit returns integer
	local integer index = 0
	local integer count = 0
	loop
		if (UnitItemInSlot(whichUnit_, index_) != null) then
			set count_ = count_ + 1
		endif
		set index_ = index_ + 1
		exitwhen index_ >= bj_MAX_INVENTORY_
	endloop
	return count_
endfunction

function UnitInventorySizeBJ takes unit whichUnit returns integer
	return UnitInventorySize(whichUnit_)
endfunction

function SetItemInvulnerableBJ takes item whichItem, boolean flag returns nothing
	call SetItemInvulnerable(whichItem_, flag_)
endfunction

function SetItemDropOnDeathBJ takes item whichItem, boolean flag returns nothing
	call SetItemDropOnDeath(whichItem_, flag_)
endfunction

function SetItemDroppableBJ takes item whichItem, boolean flag returns nothing
	call SetItemDroppable(whichItem_, flag_)
endfunction

function SetItemPlayerBJ takes item whichItem, player whichPlayer, boolean changeColor returns nothing
	call SetItemPlayer(whichItem_, whichPlayer_, changeColor_)
endfunction

function SetItemVisibleBJ takes boolean show, item whichItem returns nothing
	call SetItemVisible(whichItem_, show_)
endfunction

function IsItemHiddenBJ takes item whichItem returns boolean
	return not IsItemVisible(whichItem_)
endfunction

function ChooseRandomItemBJ takes integer level returns integer
	return ChooseRandomItem(level_)
endfunction

function ChooseRandomItemExBJ takes integer level, itemtype whichType returns integer
	return ChooseRandomItemEx(whichType_, level_)
endfunction

function ChooseRandomNPBuildingBJ takes nothing returns integer
	return ChooseRandomNPBuilding()
endfunction

function ChooseRandomCreepBJ takes integer level returns integer
	return ChooseRandomCreep(level_)
endfunction

function EnumItemsInRectBJ takes rect r, code actionFunc returns nothing
	call EnumItemsInRect(r_, null, actionFunc_)
endfunction

function RandomItemInRectBJEnum takes nothing returns nothing
	set bj_itemRandomConsidered_ = bj_itemRandomConsidered_ + 1
	if (GetRandomInt(1, bj_itemRandomConsidered_) == 1) then
		set bj_itemRandomCurrentPick_ = GetEnumItem()
	endif
endfunction

function RandomItemInRectBJ takes rect r, boolexpr filter returns item
	set bj_itemRandomConsidered_ = 0
	set bj_itemRandomCurrentPick_ = null
	call EnumItemsInRect(r_, filter_, function RandomItemInRectBJEnum)
	call DestroyBoolExpr(filter_)
	return bj_itemRandomCurrentPick_
endfunction

function RandomItemInRectSimpleBJ takes rect r returns item
	return RandomItemInRectBJ(r_, null)
endfunction

function CheckItemStatus takes item whichItem, integer status returns boolean
	if (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return not IsItemVisible(whichItem_)
	elseif (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return IsItemOwned(whichItem_)
	elseif (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return IsItemInvulnerable(whichItem_)
	elseif (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return IsItemPowerup(whichItem_)
	elseif (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return IsItemSellable(whichItem_)
	elseif (status_ == bj_ITEM_STATUS_HIDDEN_) then
		return IsItemPawnable(whichItem_)
	else
		return false
	endif
endfunction

function CheckItemcodeStatus takes integer itemId, integer status returns boolean
	if (status_ == bj_ITEMCODE_STATUS_POWERUP_) then
		return IsItemIdPowerup(itemId_)
	elseif (status_ == bj_ITEMCODE_STATUS_POWERUP_) then
		return IsItemIdSellable(itemId_)
	elseif (status_ == bj_ITEMCODE_STATUS_POWERUP_) then
		return IsItemIdPawnable(itemId_)
	else
		return false
	endif
endfunction

function UnitId2OrderIdBJ takes integer unitId returns integer
	return unitId_
endfunction

function String2UnitIdBJ takes string unitIdString returns integer
	return UnitId(unitIdString_)
endfunction

function UnitId2StringBJ takes integer unitId returns string
	local string unitString = UnitId2String(unitId_)
	if (unitString_ != null) then
		return unitString_
	endif
	return ""
endfunction

function String2OrderIdBJ takes string orderIdString returns integer
	local integer orderId
	set orderId_ = OrderId(orderIdString_)
	if (orderId_ != 0) then
		return orderId_
	endif
	set orderId_ = UnitId(orderIdString_)
	if (orderId_ != 0) then
		return orderId_
	endif
	return 0
endfunction

function OrderId2StringBJ takes integer orderId returns string
	local string orderString
	set orderString_ = OrderId2String(orderId_)
	if (orderString_ != null) then
		return orderString_
	endif
	set orderString_ = UnitId2String(orderId_)
	if (orderString_ != null) then
		return orderString_
	endif
	return ""
endfunction

function GetIssuedOrderIdBJ takes nothing returns integer
	return GetIssuedOrderId()
endfunction

function GetKillingUnitBJ takes nothing returns unit
	return GetKillingUnit()
endfunction

function CreateUnitAtLocSaveLast takes player id, integer unitid, location loc, real face returns unit
	if (unitid_ == 'ugol') then
		set bj_lastCreatedUnit_ = CreateBlightedGoldmine(id_, GetLocationX(loc_), GetLocationY(loc_), face_)
	else
		set bj_lastCreatedUnit_ = CreateUnitAtLoc(id_, unitid_, loc_, face_)
	endif
	return bj_lastCreatedUnit_
endfunction

function GetLastCreatedUnit takes nothing returns unit
	return bj_lastCreatedUnit_
endfunction

function CreateNUnitsAtLoc takes integer count, integer unitId, player whichPlayer, location loc, real face returns group
	call GroupClear(bj_lastCreatedGroup_)
	loop
		set count_ = count_ - 1
		exitwhen count_ < 0
		call CreateUnitAtLocSaveLast(whichPlayer_, unitId_, loc_, face_)
		call GroupAddUnit(bj_lastCreatedGroup_, bj_lastCreatedUnit_)
	endloop
	return bj_lastCreatedGroup_
endfunction

function CreateNUnitsAtLocFacingLocBJ takes integer count, integer unitId, player whichPlayer, location loc, location lookAt returns group
	return CreateNUnitsAtLoc(count_, unitId_, whichPlayer_, loc_, AngleBetweenPoints(loc_, lookAt_))
endfunction

function GetLastCreatedGroupEnum takes nothing returns nothing
	call GroupAddUnit(bj_groupLastCreatedDest_, GetEnumUnit())
endfunction

function GetLastCreatedGroup takes nothing returns group
	set bj_groupLastCreatedDest_ = CreateGroup()
	call ForGroup(bj_lastCreatedGroup_, function GetLastCreatedGroupEnum)
	return bj_groupLastCreatedDest_
endfunction

function CreateCorpseLocBJ takes integer unitid, player whichPlayer, location loc returns unit
	set bj_lastCreatedUnit_ = CreateCorpse(whichPlayer_, unitid_, GetLocationX(loc_), GetLocationY(loc_), GetRandomReal(0, 360))
	return bj_lastCreatedUnit_
endfunction

function UnitSuspendDecayBJ takes boolean suspend, unit whichUnit returns nothing
	call UnitSuspendDecay(whichUnit_, suspend_)
endfunction

function DelayedSuspendDecayStopAnimEnum takes nothing returns nothing
	local unit enumUnit = GetEnumUnit()
	if (GetUnitState(enumUnit_, UNIT_STATE_LIFE_) <= 0) then
		call SetUnitTimeScale(enumUnit_, 0.0001)
	endif
endfunction

function DelayedSuspendDecayBoneEnum takes nothing returns nothing
	local unit enumUnit = GetEnumUnit()
	if (GetUnitState(enumUnit_, UNIT_STATE_LIFE_) <= 0) then
		call UnitSuspendDecay(enumUnit_, true)
		call SetUnitTimeScale(enumUnit_, 0.0001)
	endif
endfunction

function DelayedSuspendDecayFleshEnum takes nothing returns nothing
	local unit enumUnit = GetEnumUnit()
	if (GetUnitState(enumUnit_, UNIT_STATE_LIFE_) <= 0) then
		call UnitSuspendDecay(enumUnit_, true)
		call SetUnitTimeScale(enumUnit_, 10.0)
		call SetUnitAnimation(enumUnit_, "decay flesh")
	endif
endfunction

function DelayedSuspendDecay takes nothing returns nothing
	local group boneGroup
	local group fleshGroup
	set boneGroup_ = bj_suspendDecayBoneGroup_
	set fleshGroup_ = bj_suspendDecayFleshGroup_
	set bj_suspendDecayBoneGroup_ = CreateGroup()
	set bj_suspendDecayFleshGroup_ = CreateGroup()
	call ForGroup(fleshGroup_, function DelayedSuspendDecayStopAnimEnum)
	call ForGroup(boneGroup_, function DelayedSuspendDecayStopAnimEnum)
	call TriggerSleepAction(bj_CORPSE_MAX_DEATH_TIME_)
	call ForGroup(fleshGroup_, function DelayedSuspendDecayFleshEnum)
	call ForGroup(boneGroup_, function DelayedSuspendDecayBoneEnum)
	call TriggerSleepAction(0.05)
	call ForGroup(fleshGroup_, function DelayedSuspendDecayStopAnimEnum)
	call DestroyGroup(boneGroup_)
	call DestroyGroup(fleshGroup_)
endfunction

function DelayedSuspendDecayCreate takes nothing returns nothing
	set bj_delayedSuspendDecayTrig_ = CreateTrigger()
	call TriggerRegisterTimerExpireEvent(bj_delayedSuspendDecayTrig_, bj_delayedSuspendDecayTimer_)
	call TriggerAddAction(bj_delayedSuspendDecayTrig_, function DelayedSuspendDecay)
endfunction

function CreatePermanentCorpseLocBJ takes integer style, integer unitid, player whichPlayer, location loc, real facing returns unit
	set bj_lastCreatedUnit_ = CreateCorpse(whichPlayer_, unitid_, GetLocationX(loc_), GetLocationY(loc_), facing_)
	call SetUnitBlendTime(bj_lastCreatedUnit_, 0)
	if (style_ == bj_CORPSETYPE_FLESH_) then
		call SetUnitAnimation(bj_lastCreatedUnit_, "decay flesh")
		call GroupAddUnit(bj_suspendDecayFleshGroup_, bj_lastCreatedUnit_)
	elseif (style_ == bj_CORPSETYPE_FLESH_) then
		call SetUnitAnimation(bj_lastCreatedUnit_, "decay bone")
		call GroupAddUnit(bj_suspendDecayBoneGroup_, bj_lastCreatedUnit_)
	else
		call SetUnitAnimation(bj_lastCreatedUnit_, "decay bone")
		call GroupAddUnit(bj_suspendDecayBoneGroup_, bj_lastCreatedUnit_)
	endif
	call TimerStart(bj_delayedSuspendDecayTimer_, 0.05, false, null)
	return bj_lastCreatedUnit_
endfunction

function GetUnitStateSwap takes unitstate whichState, unit whichUnit returns real
	return GetUnitState(whichUnit_, whichState_)
endfunction

function GetUnitStatePercent takes unit whichUnit, unitstate whichState, unitstate whichMaxState returns real
	local real value = GetUnitState(whichUnit_, whichState_)
	local real maxValue = GetUnitState(whichUnit_, whichMaxState_)
	if (whichUnit_ == null) or (maxValue_ == 0) then
		return 0.0
	endif
	return value_ / maxValue_ * 100.0
endfunction

function GetUnitLifePercent takes unit whichUnit returns real
	return GetUnitStatePercent(whichUnit_, UNIT_STATE_LIFE_, UNIT_STATE_MAX_LIFE_)
endfunction

function GetUnitManaPercent takes unit whichUnit returns real
	return GetUnitStatePercent(whichUnit_, UNIT_STATE_MANA_, UNIT_STATE_MAX_MANA_)
endfunction

function SelectUnitSingle takes unit whichUnit returns nothing
	call ClearSelection()
	call SelectUnit(whichUnit_, true)
endfunction

function SelectGroupBJEnum takes nothing returns nothing
	call SelectUnit(GetEnumUnit(), true)
endfunction

function SelectGroupBJ takes group g returns nothing
	call ClearSelection()
	call ForGroup(g_, function SelectGroupBJEnum)
endfunction

function SelectUnitAdd takes unit whichUnit returns nothing
	call SelectUnit(whichUnit_, true)
endfunction

function SelectUnitRemove takes unit whichUnit returns nothing
	call SelectUnit(whichUnit_, false)
endfunction

function ClearSelectionForPlayer takes player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ClearSelection()
	endif
endfunction

function SelectUnitForPlayerSingle takes unit whichUnit, player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ClearSelection()
		call SelectUnit(whichUnit_, true)
	endif
endfunction

function SelectGroupForPlayerBJ takes group g, player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ClearSelection()
		call ForGroup(g_, function SelectGroupBJEnum)
	endif
endfunction

function SelectUnitAddForPlayer takes unit whichUnit, player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SelectUnit(whichUnit_, true)
	endif
endfunction

function SelectUnitRemoveForPlayer takes unit whichUnit, player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call SelectUnit(whichUnit_, false)
	endif
endfunction

function SetUnitLifeBJ takes unit whichUnit, real newValue returns nothing
	call SetUnitState(whichUnit_, UNIT_STATE_LIFE_, RMaxBJ(0, newValue_))
endfunction

function SetUnitManaBJ takes unit whichUnit, real newValue returns nothing
	call SetUnitState(whichUnit_, UNIT_STATE_MANA_, RMaxBJ(0, newValue_))
endfunction

function SetUnitLifePercentBJ takes unit whichUnit, real percent returns nothing
	call SetUnitState(whichUnit_, UNIT_STATE_LIFE_, GetUnitState(whichUnit_, UNIT_STATE_MAX_LIFE_) * RMaxBJ(0, percent_) * 0.01)
endfunction

function SetUnitManaPercentBJ takes unit whichUnit, real percent returns nothing
	call SetUnitState(whichUnit_, UNIT_STATE_MANA_, GetUnitState(whichUnit_, UNIT_STATE_MAX_MANA_) * RMaxBJ(0, percent_) * 0.01)
endfunction

function IsUnitDeadBJ takes unit whichUnit returns boolean
	return GetUnitState(whichUnit_, UNIT_STATE_LIFE_) <= 0
endfunction

function IsUnitAliveBJ takes unit whichUnit returns boolean
	return not IsUnitDeadBJ(whichUnit_)
endfunction

function IsUnitGroupDeadBJEnum takes nothing returns nothing
	if not IsUnitDeadBJ(GetEnumUnit()) then
		set bj_isUnitGroupDeadResult_ = false
	endif
endfunction

function IsUnitGroupDeadBJ takes group g returns boolean
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_isUnitGroupDeadResult_ = true
	call ForGroup(g_, function IsUnitGroupDeadBJEnum)
	if (wantDestroy_) then
		call DestroyGroup(g_)
	endif
	return bj_isUnitGroupDeadResult_
endfunction

function IsUnitGroupEmptyBJEnum takes nothing returns nothing
	set bj_isUnitGroupEmptyResult_ = false
endfunction

function IsUnitGroupEmptyBJ takes group g returns boolean
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_isUnitGroupEmptyResult_ = true
	call ForGroup(g_, function IsUnitGroupEmptyBJEnum)
	if (wantDestroy_) then
		call DestroyGroup(g_)
	endif
	return bj_isUnitGroupEmptyResult_
endfunction

function IsUnitGroupInRectBJEnum takes nothing returns nothing
	if not RectContainsUnit(bj_isUnitGroupInRectRect_, GetEnumUnit()) then
		set bj_isUnitGroupInRectResult_ = false
	endif
endfunction

function IsUnitGroupInRectBJ takes group g, rect r returns boolean
	set bj_isUnitGroupInRectResult_ = true
	set bj_isUnitGroupInRectRect_ = r_
	call ForGroup(g_, function IsUnitGroupInRectBJEnum)
	return bj_isUnitGroupInRectResult_
endfunction

function IsUnitHiddenBJ takes unit whichUnit returns boolean
	return IsUnitHidden(whichUnit_)
endfunction

function ShowUnitHide takes unit whichUnit returns nothing
	call ShowUnit(whichUnit_, false)
endfunction

function ShowUnitShow takes unit whichUnit returns nothing
	if (IsUnitType(whichUnit_, UNIT_TYPE_HERO_) and IsUnitDeadBJ(whichUnit_)) then
		return
	endif
	call ShowUnit(whichUnit_, true)
endfunction

function IssueHauntOrderAtLocBJFilter takes nothing returns boolean
	return GetUnitTypeId(GetFilterUnit()) == 'ngol'
endfunction

function IssueHauntOrderAtLocBJ takes unit whichPeon, location loc returns boolean
	local group g = null
	local unit goldMine = null
	set g_ = CreateGroup()
	call GroupEnumUnitsInRangeOfLoc(g_, loc_, 2 * bj_CELLWIDTH_, filterIssueHauntOrderAtLocBJ_)
	set goldMine_ = FirstOfGroup(g_)
	call DestroyGroup(g_)
	if (goldMine_ == null) then
		return false
	endif
	return IssueTargetOrderById(whichPeon_, 'ugol', goldMine_)
endfunction

function IssueBuildOrderByIdLocBJ takes unit whichPeon, integer unitId, location loc returns boolean
	if (unitId_ == 'ugol') then
		return IssueHauntOrderAtLocBJ(whichPeon_, loc_)
	else
		return IssueBuildOrderById(whichPeon_, unitId_, GetLocationX(loc_), GetLocationY(loc_))
	endif
endfunction

function IssueTrainOrderByIdBJ takes unit whichUnit, integer unitId returns boolean
	return IssueImmediateOrderById(whichUnit_, unitId_)
endfunction

function GroupTrainOrderByIdBJ takes group g, integer unitId returns boolean
	return GroupImmediateOrderById(g_, unitId_)
endfunction

function IssueUpgradeOrderByIdBJ takes unit whichUnit, integer techId returns boolean
	return IssueImmediateOrderById(whichUnit_, techId_)
endfunction

function GetAttackedUnitBJ takes nothing returns unit
	return GetTriggerUnit()
endfunction

function SetUnitFlyHeightBJ takes unit whichUnit, real newHeight, real rate returns nothing
	call SetUnitFlyHeight(whichUnit_, newHeight_, rate_)
endfunction

function SetUnitTurnSpeedBJ takes unit whichUnit, real turnSpeed returns nothing
	call SetUnitTurnSpeed(whichUnit_, turnSpeed_)
endfunction

function SetUnitPropWindowBJ takes unit whichUnit, real propWindow returns nothing
	local real angle = propWindow_
	if (angle_ <= 0) then
		set angle_ = 1
	elseif (angle_ <= 0) then
		set angle_ = 359
	endif
	set angle_ = angle_ * bj_DEGTORAD_
	call SetUnitPropWindow(whichUnit_, angle_)
endfunction

function GetUnitPropWindowBJ takes unit whichUnit returns real
	return GetUnitPropWindow(whichUnit_) * bj_RADTODEG_
endfunction

function GetUnitDefaultPropWindowBJ takes unit whichUnit returns real
	return GetUnitDefaultPropWindow(whichUnit_)
endfunction

function SetUnitBlendTimeBJ takes unit whichUnit, real blendTime returns nothing
	call SetUnitBlendTime(whichUnit_, blendTime_)
endfunction

function SetUnitAcquireRangeBJ takes unit whichUnit, real acquireRange returns nothing
	call SetUnitAcquireRange(whichUnit_, acquireRange_)
endfunction

function UnitSetCanSleepBJ takes unit whichUnit, boolean canSleep returns nothing
	call UnitAddSleep(whichUnit_, canSleep_)
endfunction

function UnitCanSleepBJ takes unit whichUnit returns boolean
	return UnitCanSleep(whichUnit_)
endfunction

function UnitWakeUpBJ takes unit whichUnit returns nothing
	call UnitWakeUp(whichUnit_)
endfunction

function UnitIsSleepingBJ takes unit whichUnit returns boolean
	return UnitIsSleeping(whichUnit_)
endfunction

function WakePlayerUnitsEnum takes nothing returns nothing
	call UnitWakeUp(GetEnumUnit())
endfunction

function WakePlayerUnits takes player whichPlayer returns nothing
	local group g = CreateGroup()
	call GroupEnumUnitsOfPlayer(g_, whichPlayer_, null)
	call ForGroup(g_, function WakePlayerUnitsEnum)
	call DestroyGroup(g_)
endfunction

function EnableCreepSleepBJ takes boolean enable returns nothing
	call SetPlayerState(Player(PLAYER_NEUTRAL_AGGRESSIVE_), PLAYER_STATE_NO_CREEP_SLEEP_, IntegerTertiaryOp(enable_, 0, 1))
	if (not enable_) then
		call WakePlayerUnits(Player(PLAYER_NEUTRAL_AGGRESSIVE_))
	endif
endfunction

function UnitGenerateAlarms takes unit whichUnit, boolean generate returns boolean
	return UnitIgnoreAlarm(whichUnit_, not generate_)
endfunction

function DoesUnitGenerateAlarms takes unit whichUnit returns boolean
	return not UnitIgnoreAlarmToggled(whichUnit_)
endfunction

function PauseAllUnitsBJEnum takes nothing returns nothing
	call PauseUnit(GetEnumUnit(), bj_pauseAllUnitsFlag_)
endfunction

function PauseAllUnitsBJ takes boolean pause returns nothing
	local integer index
	local player indexPlayer
	local group g
	set bj_pauseAllUnitsFlag_ = pause_
	set g_ = CreateGroup()
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerController(indexPlayer_) == MAP_CONTROL_COMPUTER_) then
			call PauseCompAI(indexPlayer_, pause_)
		endif
		call GroupEnumUnitsOfPlayer(g_, indexPlayer_, null)
		call ForGroup(g_, function PauseAllUnitsBJEnum)
		call GroupClear(g_)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYER_SLOTS_
	endloop
	call DestroyGroup(g_)
endfunction

function PauseUnitBJ takes boolean pause, unit whichUnit returns nothing
	call PauseUnit(whichUnit_, pause_)
endfunction

function IsUnitPausedBJ takes unit whichUnit returns boolean
	return IsUnitPaused(whichUnit_)
endfunction

function UnitPauseTimedLifeBJ takes boolean flag, unit whichUnit returns nothing
	call UnitPauseTimedLife(whichUnit_, flag_)
endfunction

function UnitApplyTimedLifeBJ takes real duration, integer buffId, unit whichUnit returns nothing
	call UnitApplyTimedLife(whichUnit_, buffId_, duration_)
endfunction

function UnitShareVisionBJ takes boolean share, unit whichUnit, player whichPlayer returns nothing
	call UnitShareVision(whichUnit_, whichPlayer_, share_)
endfunction

function UnitRemoveBuffsBJ takes integer buffType, unit whichUnit returns nothing
	if (buffType_ == bj_REMOVEBUFFS_POSITIVE_) then
		call UnitRemoveBuffs(whichUnit_, true, false)
	elseif (buffType_ == bj_REMOVEBUFFS_POSITIVE_) then
		call UnitRemoveBuffs(whichUnit_, false, true)
	elseif (buffType_ == bj_REMOVEBUFFS_POSITIVE_) then
		call UnitRemoveBuffs(whichUnit_, true, true)
	elseif (buffType_ == bj_REMOVEBUFFS_POSITIVE_) then
		call UnitRemoveBuffsEx(whichUnit_, true, true, false, false, false, true, false)
	else
	endif
endfunction

function UnitRemoveBuffsExBJ takes integer polarity, integer resist, unit whichUnit, boolean bTLife, boolean bAura returns nothing
	local boolean bPos = (polarity_ == bj_BUFF_POLARITY_EITHER_) or (polarity_ == bj_BUFF_POLARITY_POSITIVE_)
	local boolean bNeg = (polarity_ == bj_BUFF_POLARITY_EITHER_) or (polarity_ == bj_BUFF_POLARITY_NEGATIVE_)
	local boolean bMagic = (resist_ == bj_BUFF_RESIST_BOTH_) or (resist_ == bj_BUFF_RESIST_MAGIC_)
	local boolean bPhys = (resist_ == bj_BUFF_RESIST_BOTH_) or (resist_ == bj_BUFF_RESIST_PHYSICAL_)
	call UnitRemoveBuffsEx(whichUnit_, bPos_, bNeg_, bMagic_, bPhys_, bTLife_, bAura_, false)
endfunction

function UnitCountBuffsExBJ takes integer polarity, integer resist, unit whichUnit, boolean bTLife, boolean bAura returns integer
	local boolean bPos = (polarity_ == bj_BUFF_POLARITY_EITHER_) or (polarity_ == bj_BUFF_POLARITY_POSITIVE_)
	local boolean bNeg = (polarity_ == bj_BUFF_POLARITY_EITHER_) or (polarity_ == bj_BUFF_POLARITY_NEGATIVE_)
	local boolean bMagic = (resist_ == bj_BUFF_RESIST_BOTH_) or (resist_ == bj_BUFF_RESIST_MAGIC_)
	local boolean bPhys = (resist_ == bj_BUFF_RESIST_BOTH_) or (resist_ == bj_BUFF_RESIST_PHYSICAL_)
	return UnitCountBuffsEx(whichUnit_, bPos_, bNeg_, bMagic_, bPhys_, bTLife_, bAura_, false)
endfunction

function UnitRemoveAbilityBJ takes integer abilityId, unit whichUnit returns boolean
	return UnitRemoveAbility(whichUnit_, abilityId_)
endfunction

function UnitAddAbilityBJ takes integer abilityId, unit whichUnit returns boolean
	return UnitAddAbility(whichUnit_, abilityId_)
endfunction

function UnitRemoveTypeBJ takes unittype whichType, unit whichUnit returns boolean
	return UnitRemoveType(whichUnit_, whichType_)
endfunction

function UnitAddTypeBJ takes unittype whichType, unit whichUnit returns boolean
	return UnitAddType(whichUnit_, whichType_)
endfunction

function UnitMakeAbilityPermanentBJ takes boolean permanent, integer abilityId, unit whichUnit returns boolean
	return UnitMakeAbilityPermanent(whichUnit_, permanent_, abilityId_)
endfunction

function SetUnitExplodedBJ takes unit whichUnit, boolean exploded returns nothing
	call SetUnitExploded(whichUnit_, exploded_)
endfunction

function ExplodeUnitBJ takes unit whichUnit returns nothing
	call SetUnitExploded(whichUnit_, true)
	call KillUnit(whichUnit_)
endfunction

function GetTransportUnitBJ takes nothing returns unit
	return GetTransportUnit()
endfunction

function GetLoadedUnitBJ takes nothing returns unit
	return GetLoadedUnit()
endfunction

function IsUnitInTransportBJ takes unit whichUnit, unit whichTransport returns boolean
	return IsUnitInTransport(whichUnit_, whichTransport_)
endfunction

function IsUnitLoadedBJ takes unit whichUnit returns boolean
	return IsUnitLoaded(whichUnit_)
endfunction

function IsUnitIllusionBJ takes unit whichUnit returns boolean
	return IsUnitIllusion(whichUnit_)
endfunction

function ReplaceUnitBJ takes unit whichUnit, integer newUnitId, integer unitStateMethod returns unit
	local unit oldUnit = whichUnit_
	local unit newUnit
	local boolean wasHidden
	local integer index
	local item indexItem
	local real oldRatio
	if (oldUnit_ == null) then
		set bj_lastReplacedUnit_ = oldUnit_
		return oldUnit_
	endif
	set wasHidden_ = IsUnitHidden(oldUnit_)
	call ShowUnit(oldUnit_, false)
	if (newUnitId_ == 'ugol') then
		set newUnit_ = CreateBlightedGoldmine(GetOwningPlayer(oldUnit_), GetUnitX(oldUnit_), GetUnitY(oldUnit_), GetUnitFacing(oldUnit_))
	else
		set newUnit_ = CreateUnit(GetOwningPlayer(oldUnit_), newUnitId_, GetUnitX(oldUnit_), GetUnitY(oldUnit_), GetUnitFacing(oldUnit_))
	endif
	if (unitStateMethod_ == bj_UNIT_STATE_METHOD_RELATIVE_) then
		if (GetUnitState(oldUnit_, UNIT_STATE_MAX_LIFE_) > 0) then
			set oldRatio_ = GetUnitState(oldUnit_, UNIT_STATE_LIFE_) / GetUnitState(oldUnit_, UNIT_STATE_MAX_LIFE_)
			call SetUnitState(newUnit_, UNIT_STATE_LIFE_, oldRatio_ * GetUnitState(newUnit_, UNIT_STATE_MAX_LIFE_))
		endif
		if (GetUnitState(oldUnit_, UNIT_STATE_MAX_MANA_) > 0) and (GetUnitState(newUnit_, UNIT_STATE_MAX_MANA_) > 0) then
			set oldRatio_ = GetUnitState(oldUnit_, UNIT_STATE_MANA_) / GetUnitState(oldUnit_, UNIT_STATE_MAX_MANA_)
			call SetUnitState(newUnit_, UNIT_STATE_MANA_, oldRatio_ * GetUnitState(newUnit_, UNIT_STATE_MAX_MANA_))
		endif
	elseif (unitStateMethod_ == bj_UNIT_STATE_METHOD_RELATIVE_) then
		call SetUnitState(newUnit_, UNIT_STATE_LIFE_, GetUnitState(oldUnit_, UNIT_STATE_LIFE_))
		if (GetUnitState(newUnit_, UNIT_STATE_MAX_MANA_) > 0) then
			call SetUnitState(newUnit_, UNIT_STATE_MANA_, GetUnitState(oldUnit_, UNIT_STATE_MANA_))
		endif
	elseif (unitStateMethod_ == bj_UNIT_STATE_METHOD_RELATIVE_) then
	elseif (unitStateMethod_ == bj_UNIT_STATE_METHOD_RELATIVE_) then
		call SetUnitState(newUnit_, UNIT_STATE_LIFE_, GetUnitState(newUnit_, UNIT_STATE_MAX_LIFE_))
		call SetUnitState(newUnit_, UNIT_STATE_MANA_, GetUnitState(newUnit_, UNIT_STATE_MAX_MANA_))
	else
	endif
	call SetResourceAmount(newUnit_, GetResourceAmount(oldUnit_))
	if (IsUnitType(oldUnit_, UNIT_TYPE_HERO_) and IsUnitType(newUnit_, UNIT_TYPE_HERO_)) then
		call SetHeroXP(newUnit_, GetHeroXP(oldUnit_), false)
		set index_ = 0
		loop
			set indexItem_ = UnitItemInSlot(oldUnit_, index_)
			if (indexItem_ != null) then
				call UnitRemoveItem(oldUnit_, indexItem_)
				call UnitAddItem(newUnit_, indexItem_)
			endif
			set index_ = index_ + 1
			exitwhen index_ >= bj_MAX_INVENTORY_
		endloop
	endif
	if wasHidden_ then
		call KillUnit(oldUnit_)
		call RemoveUnit(oldUnit_)
	else
		call RemoveUnit(oldUnit_)
	endif
	set bj_lastReplacedUnit_ = newUnit_
	return newUnit_
endfunction

function GetLastReplacedUnitBJ takes nothing returns unit
	return bj_lastReplacedUnit_
endfunction

function SetUnitPositionLocFacingBJ takes unit whichUnit, location loc, real facing returns nothing
	call SetUnitPositionLoc(whichUnit_, loc_)
	call SetUnitFacing(whichUnit_, facing_)
endfunction

function SetUnitPositionLocFacingLocBJ takes unit whichUnit, location loc, location lookAt returns nothing
	call SetUnitPositionLoc(whichUnit_, loc_)
	call SetUnitFacing(whichUnit_, AngleBetweenPoints(loc_, lookAt_))
endfunction

function AddItemToStockBJ takes integer itemId, unit whichUnit, integer currentStock, integer stockMax returns nothing
	call AddItemToStock(whichUnit_, itemId_, currentStock_, stockMax_)
endfunction

function AddUnitToStockBJ takes integer unitId, unit whichUnit, integer currentStock, integer stockMax returns nothing
	call AddUnitToStock(whichUnit_, unitId_, currentStock_, stockMax_)
endfunction

function RemoveItemFromStockBJ takes integer itemId, unit whichUnit returns nothing
	call RemoveItemFromStock(whichUnit_, itemId_)
endfunction

function RemoveUnitFromStockBJ takes integer unitId, unit whichUnit returns nothing
	call RemoveUnitFromStock(whichUnit_, unitId_)
endfunction

function SetUnitUseFoodBJ takes boolean enable, unit whichUnit returns nothing
	call SetUnitUseFood(whichUnit_, enable_)
endfunction

function UnitDamagePointLoc takes unit whichUnit, real delay, real radius, location loc, real amount, attacktype whichAttack, damagetype whichDamage returns boolean
	return UnitDamagePoint(whichUnit_, delay_, radius_, GetLocationX(loc_), GetLocationY(loc_), amount_, true, false, whichAttack_, whichDamage_, WEAPON_TYPE_WHOKNOWS_)
endfunction

function UnitDamageTargetBJ takes unit whichUnit, unit target, real amount, attacktype whichAttack, damagetype whichDamage returns boolean
	return UnitDamageTarget(whichUnit_, target_, amount_, true, false, whichAttack_, whichDamage_, WEAPON_TYPE_WHOKNOWS_)
endfunction

function CreateDestructableLoc takes integer objectid, location loc, real facing, real scale, integer variation returns destructable
	set bj_lastCreatedDestructable_ = CreateDestructable(objectid_, GetLocationX(loc_), GetLocationY(loc_), facing_, scale_, variation_)
	return bj_lastCreatedDestructable_
endfunction

function CreateDeadDestructableLocBJ takes integer objectid, location loc, real facing, real scale, integer variation returns destructable
	set bj_lastCreatedDestructable_ = CreateDeadDestructable(objectid_, GetLocationX(loc_), GetLocationY(loc_), facing_, scale_, variation_)
	return bj_lastCreatedDestructable_
endfunction

function GetLastCreatedDestructable takes nothing returns destructable
	return bj_lastCreatedDestructable_
endfunction

function ShowDestructableBJ takes boolean flag, destructable d returns nothing
	call ShowDestructable(d_, flag_)
endfunction

function SetDestructableInvulnerableBJ takes destructable d, boolean flag returns nothing
	call SetDestructableInvulnerable(d_, flag_)
endfunction

function IsDestructableInvulnerableBJ takes destructable d returns boolean
	return IsDestructableInvulnerable(d_)
endfunction

function GetDestructableLoc takes destructable whichDestructable returns location
	return Location(GetDestructableX(whichDestructable_), GetDestructableY(whichDestructable_))
endfunction

function EnumDestructablesInRectAll takes rect r, code actionFunc returns nothing
	call EnumDestructablesInRect(r_, null, actionFunc_)
endfunction

function EnumDestructablesInCircleBJFilter takes nothing returns boolean
	local location destLoc = GetDestructableLoc(GetFilterDestructable())
	local boolean result
	set result_ = DistanceBetweenPoints(destLoc_, bj_enumDestructableCenter_) <= bj_enumDestructableRadius_
	call RemoveLocation(destLoc_)
	return result_
endfunction

function IsDestructableDeadBJ takes destructable d returns boolean
	return GetDestructableLife(d_) <= 0
endfunction

function IsDestructableAliveBJ takes destructable d returns boolean
	return not IsDestructableDeadBJ(d_)
endfunction

function RandomDestructableInRectBJEnum takes nothing returns nothing
	set bj_destRandomConsidered_ = bj_destRandomConsidered_ + 1
	if (GetRandomInt(1, bj_destRandomConsidered_) == 1) then
		set bj_destRandomCurrentPick_ = GetEnumDestructable()
	endif
endfunction

function RandomDestructableInRectBJ takes rect r, boolexpr filter returns destructable
	set bj_destRandomConsidered_ = 0
	set bj_destRandomCurrentPick_ = null
	call EnumDestructablesInRect(r_, filter_, function RandomDestructableInRectBJEnum)
	call DestroyBoolExpr(filter_)
	return bj_destRandomCurrentPick_
endfunction

function RandomDestructableInRectSimpleBJ takes rect r returns destructable
	return RandomDestructableInRectBJ(r_, null)
endfunction

function EnumDestructablesInCircleBJ takes real radius, location loc, code actionFunc returns nothing
	local rect r
	if (radius_ >= 0) then
		set bj_enumDestructableCenter_ = loc_
		set bj_enumDestructableRadius_ = radius_
		set r_ = GetRectFromCircleBJ(loc_, radius_)
		call EnumDestructablesInRect(r_, filterEnumDestructablesInCircleBJ_, actionFunc_)
		call RemoveRect(r_)
	endif
endfunction

function SetDestructableLifePercentBJ takes destructable d, real percent returns nothing
	call SetDestructableLife(d_, GetDestructableMaxLife(d_) * percent_ * 0.01)
endfunction

function SetDestructableMaxLifeBJ takes destructable d, real max returns nothing
	call SetDestructableMaxLife(d_, max_)
endfunction

function ModifyGateBJ takes integer gateOperation, destructable d returns nothing
	if (gateOperation_ == bj_GATEOPERATION_CLOSE_) then
		if (GetDestructableLife(d_) <= 0) then
			call DestructableRestoreLife(d_, GetDestructableMaxLife(d_), true)
		endif
		call SetDestructableAnimation(d_, "stand")
	elseif (gateOperation_ == bj_GATEOPERATION_CLOSE_) then
		if (GetDestructableLife(d_) > 0) then
			call KillDestructable(d_)
		endif
		call SetDestructableAnimation(d_, "death alternate")
	elseif (gateOperation_ == bj_GATEOPERATION_CLOSE_) then
		if (GetDestructableLife(d_) > 0) then
			call KillDestructable(d_)
		endif
		call SetDestructableAnimation(d_, "death")
	else
	endif
endfunction

function GetElevatorHeight takes destructable d returns integer
	local integer height
	set height_ = 1 + R2I(GetDestructableOccluderHeight(d_) / bj_CLIFFHEIGHT_)
	if (height_ < 1) or (height_ > 3) then
		set height_ = 1
	endif
	return height_
endfunction

function ChangeElevatorHeight takes destructable d, integer newHeight returns nothing
	local integer oldHeight
	set newHeight_ = IMaxBJ(1, newHeight_)
	set newHeight_ = IMinBJ(3, newHeight_)
	set oldHeight_ = GetElevatorHeight(d_)
	call SetDestructableOccluderHeight(d_, bj_CLIFFHEIGHT_ * (newHeight_ - 1))
	if (newHeight_ == 1) then
		if (oldHeight_ == 2) then
			call SetDestructableAnimation(d_, "birth")
			call QueueDestructableAnimation(d_, "stand")
		elseif (oldHeight_ == 2) then
			call SetDestructableAnimation(d_, "birth third")
			call QueueDestructableAnimation(d_, "stand")
		else
			call SetDestructableAnimation(d_, "stand")
		endif
	elseif (newHeight_ == 1) then
		if (oldHeight_ == 1) then
			call SetDestructableAnimation(d_, "death")
			call QueueDestructableAnimation(d_, "stand second")
		elseif (oldHeight_ == 1) then
			call SetDestructableAnimation(d_, "birth second")
			call QueueDestructableAnimation(d_, "stand second")
		else
			call SetDestructableAnimation(d_, "stand second")
		endif
	elseif (newHeight_ == 1) then
		if (oldHeight_ == 1) then
			call SetDestructableAnimation(d_, "death third")
			call QueueDestructableAnimation(d_, "stand third")
		elseif (oldHeight_ == 1) then
			call SetDestructableAnimation(d_, "death second")
			call QueueDestructableAnimation(d_, "stand third")
		else
			call SetDestructableAnimation(d_, "stand third")
		endif
	else
	endif
endfunction

function NudgeUnitsInRectEnum takes nothing returns nothing
	local unit nudgee = GetEnumUnit()
	call SetUnitPosition(nudgee_, GetUnitX(nudgee_), GetUnitY(nudgee_))
endfunction

function NudgeItemsInRectEnum takes nothing returns nothing
	local item nudgee = GetEnumItem()
	call SetItemPosition(nudgee_, GetItemX(nudgee_), GetItemY(nudgee_))
endfunction

function NudgeObjectsInRect takes rect nudgeArea returns nothing
	local group g
	set g_ = CreateGroup()
	call GroupEnumUnitsInRect(g_, nudgeArea_, null)
	call ForGroup(g_, function NudgeUnitsInRectEnum)
	call DestroyGroup(g_)
	call EnumItemsInRect(nudgeArea_, null, function NudgeItemsInRectEnum)
endfunction

function NearbyElevatorExistsEnum takes nothing returns nothing
	local destructable d = GetEnumDestructable()
	local integer dType = GetDestructableTypeId(d_)
	if (dType_ == bj_ELEVATOR_CODE01_) or (dType_ == bj_ELEVATOR_CODE02_) then
		set bj_elevatorNeighbor_ = d_
	endif
endfunction

function NearbyElevatorExists takes real x, real y returns boolean
	local real findThreshold = 32
	local rect r
	set r_ = Rect(x_ - findThreshold_, y_ - findThreshold_, x_ + findThreshold_, y_ + findThreshold_)
	set bj_elevatorNeighbor_ = null
	call EnumDestructablesInRect(r_, null, function NearbyElevatorExistsEnum)
	call RemoveRect(r_)
	return bj_elevatorNeighbor_ != null
endfunction

function FindElevatorWallBlockerEnum takes nothing returns nothing
	set bj_elevatorWallBlocker_ = GetEnumDestructable()
endfunction

function ChangeElevatorWallBlocker takes real x, real y, real facing, boolean open returns nothing
	local destructable blocker = null
	local real findThreshold = 32
	local real nudgeLength = 4.25 * bj_CELLWIDTH_
	local real nudgeWidth = 1.25 * bj_CELLWIDTH_
	local rect r
	set r_ = Rect(x_ - findThreshold_, y_ - findThreshold_, x_ + findThreshold_, y_ + findThreshold_)
	set bj_elevatorWallBlocker_ = null
	call EnumDestructablesInRect(r_, null, function FindElevatorWallBlockerEnum)
	call RemoveRect(r_)
	set blocker_ = bj_elevatorWallBlocker_
	if (blocker_ == null) then
		set blocker_ = CreateDeadDestructable(bj_ELEVATOR_BLOCKER_CODE_, x_, y_, facing_, 1, 0)
	elseif (blocker_ == null) then
		return
	endif
	if (open_) then
		if (GetDestructableLife(blocker_) > 0) then
			call KillDestructable(blocker_)
		endif
	else
		if (GetDestructableLife(blocker_) <= 0) then
			call DestructableRestoreLife(blocker_, GetDestructableMaxLife(blocker_), false)
		endif
		if (facing_ == 0) then
			set r_ = Rect(x_ - nudgeWidth_ / 2, y_ - nudgeLength_ / 2, x_ + nudgeWidth_ / 2, y_ + nudgeLength_ / 2)
			call NudgeObjectsInRect(r_)
			call RemoveRect(r_)
		elseif (facing_ == 0) then
			set r_ = Rect(x_ - nudgeLength_ / 2, y_ - nudgeWidth_ / 2, x_ + nudgeLength_ / 2, y_ + nudgeWidth_ / 2)
			call NudgeObjectsInRect(r_)
			call RemoveRect(r_)
		else
		endif
	endif
endfunction

function ChangeElevatorWalls takes boolean open, integer walls, destructable d returns nothing
	local real x = GetDestructableX(d_)
	local real y = GetDestructableY(d_)
	local real distToBlocker = 192
	local real distToNeighbor = 256
	if (walls_ == bj_ELEVATOR_WALL_TYPE_ALL_) or (walls_ == bj_ELEVATOR_WALL_TYPE_EAST_) then
		if (not NearbyElevatorExists(x_ + distToNeighbor_, y_)) then
			call ChangeElevatorWallBlocker(x_ + distToBlocker_, y_, 0, open_)
		endif
	endif
	if (walls_ == bj_ELEVATOR_WALL_TYPE_ALL_) or (walls_ == bj_ELEVATOR_WALL_TYPE_NORTH_) then
		if (not NearbyElevatorExists(x_, y_ + distToNeighbor_)) then
			call ChangeElevatorWallBlocker(x_, y_ + distToBlocker_, 90, open_)
		endif
	endif
	if (walls_ == bj_ELEVATOR_WALL_TYPE_ALL_) or (walls_ == bj_ELEVATOR_WALL_TYPE_SOUTH_) then
		if (not NearbyElevatorExists(x_, y_ - distToNeighbor_)) then
			call ChangeElevatorWallBlocker(x_, y_ - distToBlocker_, 90, open_)
		endif
	endif
	if (walls_ == bj_ELEVATOR_WALL_TYPE_ALL_) or (walls_ == bj_ELEVATOR_WALL_TYPE_WEST_) then
		if (not NearbyElevatorExists(x_ - distToNeighbor_, y_)) then
			call ChangeElevatorWallBlocker(x_ - distToBlocker_, y_, 0, open_)
		endif
	endif
endfunction

function WaygateActivateBJ takes boolean activate, unit waygate returns nothing
	call WaygateActivate(waygate_, activate_)
endfunction

function WaygateIsActiveBJ takes unit waygate returns boolean
	return WaygateIsActive(waygate_)
endfunction

function WaygateSetDestinationLocBJ takes unit waygate, location loc returns nothing
	call WaygateSetDestination(waygate_, GetLocationX(loc_), GetLocationY(loc_))
endfunction

function WaygateGetDestinationLocBJ takes unit waygate returns location
	return Location(WaygateGetDestinationX(waygate_), WaygateGetDestinationY(waygate_))
endfunction

function UnitSetUsesAltIconBJ takes boolean flag, unit whichUnit returns nothing
	call UnitSetUsesAltIcon(whichUnit_, flag_)
endfunction

function ForceUIKeyBJ takes player whichPlayer, string key returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ForceUIKey(key_)
	endif
endfunction

function ForceUICancelBJ takes player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call ForceUICancel()
	endif
endfunction

function ForGroupBJ takes group whichGroup, code callback returns nothing
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	call ForGroup(whichGroup_, callback_)
	if (wantDestroy_) then
		call DestroyGroup(whichGroup_)
	endif
endfunction

function GroupAddUnitSimple takes unit whichUnit, group whichGroup returns nothing
	call GroupAddUnit(whichGroup_, whichUnit_)
endfunction

function GroupRemoveUnitSimple takes unit whichUnit, group whichGroup returns nothing
	call GroupRemoveUnit(whichGroup_, whichUnit_)
endfunction

function GroupAddGroupEnum takes nothing returns nothing
	call GroupAddUnit(bj_groupAddGroupDest_, GetEnumUnit())
endfunction

function GroupAddGroup takes group sourceGroup, group destGroup returns nothing
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_groupAddGroupDest_ = destGroup_
	call ForGroup(sourceGroup_, function GroupAddGroupEnum)
	if (wantDestroy_) then
		call DestroyGroup(sourceGroup_)
	endif
endfunction

function GroupRemoveGroupEnum takes nothing returns nothing
	call GroupRemoveUnit(bj_groupRemoveGroupDest_, GetEnumUnit())
endfunction

function GroupRemoveGroup takes group sourceGroup, group destGroup returns nothing
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_groupRemoveGroupDest_ = destGroup_
	call ForGroup(sourceGroup_, function GroupRemoveGroupEnum)
	if (wantDestroy_) then
		call DestroyGroup(sourceGroup_)
	endif
endfunction

function ForceAddPlayerSimple takes player whichPlayer, force whichForce returns nothing
	call ForceAddPlayer(whichForce_, whichPlayer_)
endfunction

function ForceRemovePlayerSimple takes player whichPlayer, force whichForce returns nothing
	call ForceRemovePlayer(whichForce_, whichPlayer_)
endfunction

function GroupPickRandomUnitEnum takes nothing returns nothing
	set bj_groupRandomConsidered_ = bj_groupRandomConsidered_ + 1
	if (GetRandomInt(1, bj_groupRandomConsidered_) == 1) then
		set bj_groupRandomCurrentPick_ = GetEnumUnit()
	endif
endfunction

function GroupPickRandomUnit takes group whichGroup returns unit
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_groupRandomConsidered_ = 0
	set bj_groupRandomCurrentPick_ = null
	call ForGroup(whichGroup_, function GroupPickRandomUnitEnum)
	if (wantDestroy_) then
		call DestroyGroup(whichGroup_)
	endif
	return bj_groupRandomCurrentPick_
endfunction

function ForcePickRandomPlayerEnum takes nothing returns nothing
	set bj_forceRandomConsidered_ = bj_forceRandomConsidered_ + 1
	if (GetRandomInt(1, bj_forceRandomConsidered_) == 1) then
		set bj_forceRandomCurrentPick_ = GetEnumPlayer()
	endif
endfunction

function ForcePickRandomPlayer takes force whichForce returns player
	set bj_forceRandomConsidered_ = 0
	set bj_forceRandomCurrentPick_ = null
	call ForForce(whichForce_, function ForcePickRandomPlayerEnum)
	return bj_forceRandomCurrentPick_
endfunction

function EnumUnitsSelected takes player whichPlayer, boolexpr enumFilter, code enumAction returns nothing
	local group g = CreateGroup()
	call SyncSelections()
	call GroupEnumUnitsSelected(g_, whichPlayer_, enumFilter_)
	call DestroyBoolExpr(enumFilter_)
	call ForGroup(g_, enumAction_)
	call DestroyGroup(g_)
endfunction

function GetUnitsInRectMatching takes rect r, boolexpr filter returns group
	local group g = CreateGroup()
	call GroupEnumUnitsInRect(g_, r_, filter_)
	call DestroyBoolExpr(filter_)
	return g_
endfunction

function GetUnitsInRectAll takes rect r returns group
	return GetUnitsInRectMatching(r_, null)
endfunction

function GetUnitsInRectOfPlayerFilter takes nothing returns boolean
	return GetOwningPlayer(GetFilterUnit()) == bj_groupEnumOwningPlayer_
endfunction

function GetUnitsInRectOfPlayer takes rect r, player whichPlayer returns group
	local group g = CreateGroup()
	set bj_groupEnumOwningPlayer_ = whichPlayer_
	call GroupEnumUnitsInRect(g_, r_, filterGetUnitsInRectOfPlayer_)
	return g_
endfunction

function GetUnitsInRangeOfLocMatching takes real radius, location whichLocation, boolexpr filter returns group
	local group g = CreateGroup()
	call GroupEnumUnitsInRangeOfLoc(g_, whichLocation_, radius_, filter_)
	call DestroyBoolExpr(filter_)
	return g_
endfunction

function GetUnitsInRangeOfLocAll takes real radius, location whichLocation returns group
	return GetUnitsInRangeOfLocMatching(radius_, whichLocation_, null)
endfunction

function GetUnitsOfTypeIdAllFilter takes nothing returns boolean
	return GetUnitTypeId(GetFilterUnit()) == bj_groupEnumTypeId_
endfunction

function GetUnitsOfTypeIdAll takes integer unitid returns group
	local group result = CreateGroup()
	local group g = CreateGroup()
	local integer index
	set index_ = 0
	loop
		set bj_groupEnumTypeId_ = unitid_
		call GroupClear(g_)
		call GroupEnumUnitsOfPlayer(g_, Player(index_), filterGetUnitsOfTypeIdAll_)
		call GroupAddGroup(g_, result_)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYER_SLOTS_
	endloop
	call DestroyGroup(g_)
	return result_
endfunction

function GetUnitsOfPlayerMatching takes player whichPlayer, boolexpr filter returns group
	local group g = CreateGroup()
	call GroupEnumUnitsOfPlayer(g_, whichPlayer_, filter_)
	call DestroyBoolExpr(filter_)
	return g_
endfunction

function GetUnitsOfPlayerAll takes player whichPlayer returns group
	return GetUnitsOfPlayerMatching(whichPlayer_, null)
endfunction

function GetUnitsOfPlayerAndTypeIdFilter takes nothing returns boolean
	return GetUnitTypeId(GetFilterUnit()) == bj_groupEnumTypeId_
endfunction

function GetUnitsOfPlayerAndTypeId takes player whichPlayer, integer unitid returns group
	local group g = CreateGroup()
	set bj_groupEnumTypeId_ = unitid_
	call GroupEnumUnitsOfPlayer(g_, whichPlayer_, filterGetUnitsOfPlayerAndTypeId_)
	return g_
endfunction

function GetUnitsSelectedAll takes player whichPlayer returns group
	local group g = CreateGroup()
	call SyncSelections()
	call GroupEnumUnitsSelected(g_, whichPlayer_, null)
	return g_
endfunction

function GetForceOfPlayer takes player whichPlayer returns force
	local force f = CreateForce()
	call ForceAddPlayer(f_, whichPlayer_)
	return f_
endfunction

function GetPlayersAll takes nothing returns force
	return bj_FORCE_ALL_PLAYERS_
endfunction

function GetPlayersByMapControl takes mapcontrol whichControl returns force
	local force f = CreateForce()
	local integer playerIndex
	local player indexPlayer
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if GetPlayerController(indexPlayer_) == whichControl_ then
			call ForceAddPlayer(f_, indexPlayer_)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYER_SLOTS_
	endloop
	return f_
endfunction

function GetPlayersAllies takes player whichPlayer returns force
	local force f = CreateForce()
	call ForceEnumAllies(f_, whichPlayer_, null)
	return f_
endfunction

function GetPlayersEnemies takes player whichPlayer returns force
	local force f = CreateForce()
	call ForceEnumEnemies(f_, whichPlayer_, null)
	return f_
endfunction

function GetPlayersMatching takes boolexpr filter returns force
	local force f = CreateForce()
	call ForceEnumPlayers(f_, filter_)
	call DestroyBoolExpr(filter_)
	return f_
endfunction

function CountUnitsInGroupEnum takes nothing returns nothing
	set bj_groupCountUnits_ = bj_groupCountUnits_ + 1
endfunction

function CountUnitsInGroup takes group g returns integer
	local boolean wantDestroy = bj_wantDestroyGroup_
	set bj_wantDestroyGroup_ = false
	set bj_groupCountUnits_ = 0
	call ForGroup(g_, function CountUnitsInGroupEnum)
	if (wantDestroy_) then
		call DestroyGroup(g_)
	endif
	return bj_groupCountUnits_
endfunction

function CountPlayersInForceEnum takes nothing returns nothing
	set bj_forceCountPlayers_ = bj_forceCountPlayers_ + 1
endfunction

function CountPlayersInForceBJ takes force f returns integer
	set bj_forceCountPlayers_ = 0
	call ForForce(f_, function CountPlayersInForceEnum)
	return bj_forceCountPlayers_
endfunction

function GetRandomSubGroupEnum takes nothing returns nothing
	if (bj_randomSubGroupWant_ > 0) then
		if (bj_randomSubGroupWant_ >= bj_randomSubGroupTotal_) or (GetRandomReal(0, 1) < bj_randomSubGroupChance_) then
			call GroupAddUnit(bj_randomSubGroupGroup_, GetEnumUnit())
			set bj_randomSubGroupWant_ = bj_randomSubGroupWant_ - 1
		endif
	endif
	set bj_randomSubGroupTotal_ = bj_randomSubGroupTotal_ - 1
endfunction

function GetRandomSubGroup takes integer count, group sourceGroup returns group
	local group g = CreateGroup()
	set bj_randomSubGroupGroup_ = g_
	set bj_randomSubGroupWant_ = count_
	set bj_randomSubGroupTotal_ = CountUnitsInGroup(sourceGroup_)
	if (bj_randomSubGroupWant_ <= 0 or bj_randomSubGroupTotal_ <= 0) then
		return g_
	endif
	set bj_randomSubGroupChance_ = I2R(bj_randomSubGroupWant_) / I2R(bj_randomSubGroupTotal_)
	call ForGroup(sourceGroup_, function GetRandomSubGroupEnum)
	return g_
endfunction

function LivingPlayerUnitsOfTypeIdFilter takes nothing returns boolean
	local unit filterUnit = GetFilterUnit()
	return IsUnitAliveBJ(filterUnit_) and GetUnitTypeId(filterUnit_) == bj_livingPlayerUnitsTypeId_
endfunction

function CountLivingPlayerUnitsOfTypeId takes integer unitId, player whichPlayer returns integer
	local group g
	local integer matchedCount
	set g_ = CreateGroup()
	set bj_livingPlayerUnitsTypeId_ = unitId_
	call GroupEnumUnitsOfPlayer(g_, whichPlayer_, filterLivingPlayerUnitsOfTypeId_)
	set matchedCount_ = CountUnitsInGroup(g_)
	call DestroyGroup(g_)
	return matchedCount_
endfunction

function ResetUnitAnimation takes unit whichUnit returns nothing
	call SetUnitAnimation(whichUnit_, "stand")
endfunction

function SetUnitTimeScalePercent takes unit whichUnit, real percentScale returns nothing
	call SetUnitTimeScale(whichUnit_, percentScale_ * 0.01)
endfunction

function SetUnitScalePercent takes unit whichUnit, real percentScaleX, real percentScaleY, real percentScaleZ returns nothing
	call SetUnitScale(whichUnit_, percentScaleX_ * 0.01, percentScaleY_ * 0.01, percentScaleZ_ * 0.01)
endfunction

function SetUnitVertexColorBJ takes unit whichUnit, real red, real green, real blue, real transparency returns nothing
	call SetUnitVertexColor(whichUnit_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function UnitAddIndicatorBJ takes unit whichUnit, real red, real green, real blue, real transparency returns nothing
	call AddIndicator(whichUnit_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function DestructableAddIndicatorBJ takes destructable whichDestructable, real red, real green, real blue, real transparency returns nothing
	call AddIndicator(whichDestructable_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function ItemAddIndicatorBJ takes item whichItem, real red, real green, real blue, real transparency returns nothing
	call AddIndicator(whichItem_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function SetUnitFacingToFaceLocTimed takes unit whichUnit, location target, real duration returns nothing
	local location unitLoc = GetUnitLoc(whichUnit_)
	call SetUnitFacingTimed(whichUnit_, AngleBetweenPoints(unitLoc_, target_), duration_)
	call RemoveLocation(unitLoc_)
endfunction

function SetUnitFacingToFaceUnitTimed takes unit whichUnit, unit target, real duration returns nothing
	local location unitLoc = GetUnitLoc(target_)
	call SetUnitFacingToFaceLocTimed(whichUnit_, unitLoc_, duration_)
	call RemoveLocation(unitLoc_)
endfunction

function QueueUnitAnimationBJ takes unit whichUnit, string whichAnimation returns nothing
	call QueueUnitAnimation(whichUnit_, whichAnimation_)
endfunction

function SetDestructableAnimationBJ takes destructable d, string whichAnimation returns nothing
	call SetDestructableAnimation(d_, whichAnimation_)
endfunction

function QueueDestructableAnimationBJ takes destructable d, string whichAnimation returns nothing
	call QueueDestructableAnimation(d_, whichAnimation_)
endfunction

function SetDestAnimationSpeedPercent takes destructable d, real percentScale returns nothing
	call SetDestructableAnimationSpeed(d_, percentScale_ * 0.01)
endfunction

function DialogDisplayBJ takes boolean flag, dialog whichDialog, player whichPlayer returns nothing
	call DialogDisplay(whichPlayer_, whichDialog_, flag_)
endfunction

function DialogSetMessageBJ takes dialog whichDialog, string message returns nothing
	call DialogSetMessage(whichDialog_, message_)
endfunction

function DialogAddButtonBJ takes dialog whichDialog, string buttonText returns button
	set bj_lastCreatedButton_ = DialogAddButton(whichDialog_, buttonText_, 0)
	return bj_lastCreatedButton_
endfunction

function DialogAddButtonWithHotkeyBJ takes dialog whichDialog, string buttonText, integer hotkey returns button
	set bj_lastCreatedButton_ = DialogAddButton(whichDialog_, buttonText_, hotkey_)
	return bj_lastCreatedButton_
endfunction

function DialogClearBJ takes dialog whichDialog returns nothing
	call DialogClear(whichDialog_)
endfunction

function GetLastCreatedButtonBJ takes nothing returns button
	return bj_lastCreatedButton_
endfunction

function GetClickedButtonBJ takes nothing returns button
	return GetClickedButton()
endfunction

function GetClickedDialogBJ takes nothing returns dialog
	return GetClickedDialog()
endfunction

function SetPlayerAllianceBJ takes player sourcePlayer, alliancetype whichAllianceSetting, boolean value, player otherPlayer returns nothing
	if (sourcePlayer_ == otherPlayer_) then
		return
	endif
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, whichAllianceSetting_, value_)
endfunction

function SetPlayerAllianceStateAllyBJ takes player sourcePlayer, player otherPlayer, boolean flag returns nothing
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_PASSIVE_, flag_)
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_HELP_REQUEST_, flag_)
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_HELP_RESPONSE_, flag_)
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_SHARED_XP_, flag_)
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_SHARED_SPELLS_, flag_)
endfunction

function SetPlayerAllianceStateVisionBJ takes player sourcePlayer, player otherPlayer, boolean flag returns nothing
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_SHARED_VISION_, flag_)
endfunction

function SetPlayerAllianceStateControlBJ takes player sourcePlayer, player otherPlayer, boolean flag returns nothing
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_SHARED_CONTROL_, flag_)
endfunction

function SetPlayerAllianceStateFullControlBJ takes player sourcePlayer, player otherPlayer, boolean flag returns nothing
	call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_SHARED_ADVANCED_CONTROL_, flag_)
endfunction

function SetPlayerAllianceStateBJ takes player sourcePlayer, player otherPlayer, integer allianceState returns nothing
	if (sourcePlayer_ == otherPlayer_) then
		return
	endif
	if allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, true)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_PASSIVE_, true)
	elseif allianceState_ == bj_ALLIANCE_UNALLIED_ then
		call SetPlayerAllianceStateAllyBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateVisionBJ(sourcePlayer_, otherPlayer_, true)
		call SetPlayerAllianceStateControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAllianceStateFullControlBJ(sourcePlayer_, otherPlayer_, false)
		call SetPlayerAlliance(sourcePlayer_, otherPlayer_, ALLIANCE_PASSIVE_, true)
	else
	endif
endfunction

function SetForceAllianceStateBJ takes force sourceForce, force targetForce, integer allianceState returns nothing
	local integer sourceIndex
	local integer targetIndex
	set sourceIndex_ = 0
	loop
		if (sourceForce_ == bj_FORCE_ALL_PLAYERS_ or IsPlayerInForce(Player(sourceIndex_), sourceForce_)) then
			set targetIndex_ = 0
			loop
				if (targetForce_ == bj_FORCE_ALL_PLAYERS_ or IsPlayerInForce(Player(targetIndex_), targetForce_)) then
					call SetPlayerAllianceStateBJ(Player(sourceIndex_), Player(targetIndex_), allianceState_)
				endif
				set targetIndex_ = targetIndex_ + 1
				exitwhen targetIndex_ == bj_MAX_PLAYER_SLOTS_
			endloop
		endif
		set sourceIndex_ = sourceIndex_ + 1
		exitwhen sourceIndex_ == bj_MAX_PLAYER_SLOTS_
	endloop
endfunction

function PlayersAreCoAllied takes player playerA, player playerB returns boolean
	if (playerA_ == playerB_) then
		return true
	endif
	if GetPlayerAlliance(playerA_, playerB_, ALLIANCE_PASSIVE_) then
		if GetPlayerAlliance(playerB_, playerA_, ALLIANCE_PASSIVE_) then
			return true
		endif
	endif
	return false
endfunction

function ShareEverythingWithTeamAI takes player whichPlayer returns nothing
	local integer playerIndex
	local player indexPlayer
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (PlayersAreCoAllied(whichPlayer_, indexPlayer_) and whichPlayer_ != indexPlayer_) then
			if (GetPlayerController(indexPlayer_) == MAP_CONTROL_COMPUTER_) then
				call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_VISION_, true)
				call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_CONTROL_, true)
				call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_ADVANCED_CONTROL_, true)
			endif
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
endfunction

function ShareEverythingWithTeam takes player whichPlayer returns nothing
	local integer playerIndex
	local player indexPlayer
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (PlayersAreCoAllied(whichPlayer_, indexPlayer_) and whichPlayer_ != indexPlayer_) then
			call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_VISION_, true)
			call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_CONTROL_, true)
			call SetPlayerAlliance(indexPlayer_, whichPlayer_, ALLIANCE_SHARED_CONTROL_, true)
			call SetPlayerAlliance(whichPlayer_, indexPlayer_, ALLIANCE_SHARED_ADVANCED_CONTROL_, true)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
endfunction

function ConfigureNeutralVictim takes nothing returns nothing
	local integer index
	local player indexPlayer
	local player neutralVictim = Player(bj_PLAYER_NEUTRAL_VICTIM_)
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		call SetPlayerAlliance(neutralVictim_, indexPlayer_, ALLIANCE_PASSIVE_, true)
		call SetPlayerAlliance(indexPlayer_, neutralVictim_, ALLIANCE_PASSIVE_, false)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	set indexPlayer_ = Player(PLAYER_NEUTRAL_AGGRESSIVE_)
	call SetPlayerAlliance(neutralVictim_, indexPlayer_, ALLIANCE_PASSIVE_, true)
	call SetPlayerAlliance(indexPlayer_, neutralVictim_, ALLIANCE_PASSIVE_, true)
	call SetPlayerState(neutralVictim_, PLAYER_STATE_GIVES_BOUNTY_, 0)
endfunction

function MakeUnitsPassiveForPlayerEnum takes nothing returns nothing
	call SetUnitOwner(GetEnumUnit(), Player(bj_PLAYER_NEUTRAL_VICTIM_), false)
endfunction

function MakeUnitsPassiveForPlayer takes player whichPlayer returns nothing
	local group playerUnits = CreateGroup()
	call CachePlayerHeroData(whichPlayer_)
	call GroupEnumUnitsOfPlayer(playerUnits_, whichPlayer_, null)
	call ForGroup(playerUnits_, function MakeUnitsPassiveForPlayerEnum)
	call DestroyGroup(playerUnits_)
endfunction

function MakeUnitsPassiveForTeam takes player whichPlayer returns nothing
	local integer playerIndex
	local player indexPlayer
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if PlayersAreCoAllied(whichPlayer_, indexPlayer_) then
			call MakeUnitsPassiveForPlayer(indexPlayer_)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
endfunction

function AllowVictoryDefeat takes playergameresult gameResult returns boolean
	if (gameResult_ == PLAYER_GAME_RESULT_VICTORY_) then
		return not IsNoVictoryCheat()
	endif
	if (gameResult_ == PLAYER_GAME_RESULT_DEFEAT_) then
		return not IsNoDefeatCheat()
	endif
	if (gameResult_ == PLAYER_GAME_RESULT_NEUTRAL_) then
		return (not IsNoVictoryCheat()) and (not IsNoDefeatCheat())
	endif
	return true
endfunction

function EndGameBJ takes nothing returns nothing
	call EndGame(true)
endfunction

function MeleeVictoryDialogBJ takes player whichPlayer, boolean leftGame returns nothing
	local trigger t = CreateTrigger()
	local dialog d = DialogCreate()
	local string formatString
	if (leftGame_) then
		set formatString_ = GetLocalizedString("PLAYER_LEFT_GAME")
	else
		set formatString_ = GetLocalizedString("PLAYER_VICTORIOUS")
	endif
	call DisplayTimedTextFromPlayer(whichPlayer_, 0, 0, 60, formatString_)
	call DialogSetMessage(d_, GetLocalizedString("GAMEOVER_VICTORY_MSG"))
	call DialogAddButton(d_, GetLocalizedString("GAMEOVER_CONTINUE_GAME"), GetLocalizedHotkey("GAMEOVER_CONTINUE_GAME"))
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddQuitButton(d_, true, GetLocalizedString("GAMEOVER_QUIT_GAME"), GetLocalizedHotkey("GAMEOVER_QUIT_GAME")))
	call DialogDisplay(whichPlayer_, d_, true)
	call StartSoundForPlayerBJ(whichPlayer_, bj_victoryDialogSound_)
endfunction

function MeleeDefeatDialogBJ takes player whichPlayer, boolean leftGame returns nothing
	local trigger t = CreateTrigger()
	local dialog d = DialogCreate()
	local string formatString
	if (leftGame_) then
		set formatString_ = GetLocalizedString("PLAYER_LEFT_GAME")
	else
		set formatString_ = GetLocalizedString("PLAYER_DEFEATED")
	endif
	call DisplayTimedTextFromPlayer(whichPlayer_, 0, 0, 60, formatString_)
	call DialogSetMessage(d_, GetLocalizedString("GAMEOVER_DEFEAT_MSG"))
	if (not bj_meleeGameOver_ and IsMapFlagSet(MAP_OBSERVERS_ON_DEATH_)) then
		call DialogAddButton(d_, GetLocalizedString("GAMEOVER_CONTINUE_OBSERVING"), GetLocalizedHotkey("GAMEOVER_CONTINUE_OBSERVING"))
	endif
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddQuitButton(d_, true, GetLocalizedString("GAMEOVER_QUIT_GAME"), GetLocalizedHotkey("GAMEOVER_QUIT_GAME")))
	call DialogDisplay(whichPlayer_, d_, true)
	call StartSoundForPlayerBJ(whichPlayer_, bj_defeatDialogSound_)
endfunction

function GameOverDialogBJ takes player whichPlayer, boolean leftGame returns nothing
	local trigger t = CreateTrigger()
	local dialog d = DialogCreate()
	local string s
	call DisplayTimedTextFromPlayer(whichPlayer_, 0, 0, 60, GetLocalizedString("PLAYER_LEFT_GAME"))
	if (GetIntegerGameState(GAME_STATE_DISCONNECTED_) != 0) then
		set s_ = GetLocalizedString("GAMEOVER_DISCONNECTED")
	else
		set s_ = GetLocalizedString("GAMEOVER_GAME_OVER")
	endif
	call DialogSetMessage(d_, s_)
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddQuitButton(d_, true, GetLocalizedString("GAMEOVER_OK"), GetLocalizedHotkey("GAMEOVER_OK")))
	call DialogDisplay(whichPlayer_, d_, true)
	call StartSoundForPlayerBJ(whichPlayer_, bj_defeatDialogSound_)
endfunction

function RemovePlayerPreserveUnitsBJ takes player whichPlayer, playergameresult gameResult, boolean leftGame returns nothing
	if AllowVictoryDefeat(gameResult_) then
		call RemovePlayer(whichPlayer_, gameResult_)
		if (gameResult_ == PLAYER_GAME_RESULT_VICTORY_) then
			call MeleeVictoryDialogBJ(whichPlayer_, leftGame_)
			return
		elseif (gameResult_ == PLAYER_GAME_RESULT_VICTORY_) then
			call MeleeDefeatDialogBJ(whichPlayer_, leftGame_)
		else
			call GameOverDialogBJ(whichPlayer_, leftGame_)
		endif
	endif
endfunction

function CustomVictoryOkBJ takes nothing returns nothing
	if bj_isSinglePlayer_ then
		call PauseGame(false)
		call SetGameDifficulty(GetDefaultDifficulty())
	endif
	if (bj_changeLevelMapName_ == null) then
		call EndGame(bj_changeLevelShowScores_)
	else
		call ChangeLevel(bj_changeLevelMapName_, bj_changeLevelShowScores_)
	endif
endfunction

function CustomVictoryQuitBJ takes nothing returns nothing
	if bj_isSinglePlayer_ then
		call PauseGame(false)
		call SetGameDifficulty(GetDefaultDifficulty())
	endif
	call EndGame(bj_changeLevelShowScores_)
endfunction

function CustomVictoryDialogBJ takes player whichPlayer returns nothing
	local trigger t = CreateTrigger()
	local dialog d = DialogCreate()
	call DialogSetMessage(d_, GetLocalizedString("GAMEOVER_VICTORY_MSG"))
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_CONTINUE"), GetLocalizedHotkey("GAMEOVER_CONTINUE")))
	call TriggerAddAction(t_, function CustomVictoryOkBJ)
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_QUIT_MISSION"), GetLocalizedHotkey("GAMEOVER_QUIT_MISSION")))
	call TriggerAddAction(t_, function CustomVictoryQuitBJ)
	if (GetLocalPlayer() == whichPlayer_) then
		call EnableUserControl(true)
		if bj_isSinglePlayer_ then
			call PauseGame(true)
		endif
		call EnableUserUI(false)
	endif
	call DialogDisplay(whichPlayer_, d_, true)
	call VolumeGroupSetVolumeForPlayerBJ(whichPlayer_, SOUND_VOLUMEGROUP_UI_, 1.0)
	call StartSoundForPlayerBJ(whichPlayer_, bj_victoryDialogSound_)
endfunction

function CustomVictorySkipBJ takes player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		if bj_isSinglePlayer_ then
			call SetGameDifficulty(GetDefaultDifficulty())
		endif
		if (bj_changeLevelMapName_ == null) then
			call EndGame(bj_changeLevelShowScores_)
		else
			call ChangeLevel(bj_changeLevelMapName_, bj_changeLevelShowScores_)
		endif
	endif
endfunction

function CustomVictoryBJ takes player whichPlayer, boolean showDialog, boolean showScores returns nothing
	if AllowVictoryDefeat(PLAYER_GAME_RESULT_VICTORY_) then
		call RemovePlayer(whichPlayer_, PLAYER_GAME_RESULT_VICTORY_)
		if not bj_isSinglePlayer_ then
			call DisplayTimedTextFromPlayer(whichPlayer_, 0, 0, 60, GetLocalizedString("PLAYER_VICTORIOUS"))
		endif
		if (GetPlayerController(whichPlayer_) == MAP_CONTROL_USER_) then
			set bj_changeLevelShowScores_ = showScores_
			if showDialog_ then
				call CustomVictoryDialogBJ(whichPlayer_)
			else
				call CustomVictorySkipBJ(whichPlayer_)
			endif
		endif
	endif
endfunction

function CustomDefeatRestartBJ takes nothing returns nothing
	call PauseGame(false)
	call RestartGame(true)
endfunction

function CustomDefeatReduceDifficultyBJ takes nothing returns nothing
	local gamedifficulty diff = GetGameDifficulty()
	call PauseGame(false)
	if (diff_ == MAP_DIFFICULTY_EASY_) then
	elseif (diff_ == MAP_DIFFICULTY_EASY_) then
		call SetGameDifficulty(MAP_DIFFICULTY_EASY_)
	elseif (diff_ == MAP_DIFFICULTY_EASY_) then
		call SetGameDifficulty(MAP_DIFFICULTY_NORMAL_)
	else
	endif
	call RestartGame(true)
endfunction

function CustomDefeatLoadBJ takes nothing returns nothing
	call PauseGame(false)
	call DisplayLoadDialog()
endfunction

function CustomDefeatQuitBJ takes nothing returns nothing
	if bj_isSinglePlayer_ then
		call PauseGame(false)
	endif
	call SetGameDifficulty(GetDefaultDifficulty())
	call EndGame(true)
endfunction

function CustomDefeatDialogBJ takes player whichPlayer, string message returns nothing
	local trigger t = CreateTrigger()
	local dialog d = DialogCreate()
	call DialogSetMessage(d_, message_)
	if bj_isSinglePlayer_ then
		set t_ = CreateTrigger()
		call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_RESTART"), GetLocalizedHotkey("GAMEOVER_RESTART")))
		call TriggerAddAction(t_, function CustomDefeatRestartBJ)
		if (GetGameDifficulty() != MAP_DIFFICULTY_EASY_) then
			set t_ = CreateTrigger()
			call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_REDUCE_DIFFICULTY"), GetLocalizedHotkey("GAMEOVER_REDUCE_DIFFICULTY")))
			call TriggerAddAction(t_, function CustomDefeatReduceDifficultyBJ)
		endif
		set t_ = CreateTrigger()
		call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_LOAD"), GetLocalizedHotkey("GAMEOVER_LOAD")))
		call TriggerAddAction(t_, function CustomDefeatLoadBJ)
	endif
	set t_ = CreateTrigger()
	call TriggerRegisterDialogButtonEvent(t_, DialogAddButton(d_, GetLocalizedString("GAMEOVER_QUIT_MISSION"), GetLocalizedHotkey("GAMEOVER_QUIT_MISSION")))
	call TriggerAddAction(t_, function CustomDefeatQuitBJ)
	if (GetLocalPlayer() == whichPlayer_) then
		call EnableUserControl(true)
		if bj_isSinglePlayer_ then
			call PauseGame(true)
		endif
		call EnableUserUI(false)
	endif
	call DialogDisplay(whichPlayer_, d_, true)
	call VolumeGroupSetVolumeForPlayerBJ(whichPlayer_, SOUND_VOLUMEGROUP_UI_, 1.0)
	call StartSoundForPlayerBJ(whichPlayer_, bj_defeatDialogSound_)
endfunction

function CustomDefeatBJ takes player whichPlayer, string message returns nothing
	if AllowVictoryDefeat(PLAYER_GAME_RESULT_DEFEAT_) then
		call RemovePlayer(whichPlayer_, PLAYER_GAME_RESULT_DEFEAT_)
		if not bj_isSinglePlayer_ then
			call DisplayTimedTextFromPlayer(whichPlayer_, 0, 0, 60, GetLocalizedString("PLAYER_DEFEATED"))
		endif
		if (GetPlayerController(whichPlayer_) == MAP_CONTROL_USER_) then
			call CustomDefeatDialogBJ(whichPlayer_, message_)
		endif
	endif
endfunction

function SetNextLevelBJ takes string nextLevel returns nothing
	if (nextLevel_ == "") then
		set bj_changeLevelMapName_ = null
	else
		set bj_changeLevelMapName_ = nextLevel_
	endif
endfunction

function SetPlayerOnScoreScreenBJ takes boolean flag, player whichPlayer returns nothing
	call SetPlayerOnScoreScreen(whichPlayer_, flag_)
endfunction

function CreateQuestBJ takes integer questType, string title, string description, string iconPath returns quest
	local boolean required = (questType_ == bj_QUESTTYPE_REQ_DISCOVERED_) or (questType_ == bj_QUESTTYPE_REQ_UNDISCOVERED_)
	local boolean discovered = (questType_ == bj_QUESTTYPE_REQ_DISCOVERED_) or (questType_ == bj_QUESTTYPE_OPT_DISCOVERED_)
	set bj_lastCreatedQuest_ = CreateQuest()
	call QuestSetTitle(bj_lastCreatedQuest_, title_)
	call QuestSetDescription(bj_lastCreatedQuest_, description_)
	call QuestSetIconPath(bj_lastCreatedQuest_, iconPath_)
	call QuestSetRequired(bj_lastCreatedQuest_, required_)
	call QuestSetDiscovered(bj_lastCreatedQuest_, discovered_)
	call QuestSetCompleted(bj_lastCreatedQuest_, false)
	return bj_lastCreatedQuest_
endfunction

function DestroyQuestBJ takes quest whichQuest returns nothing
	call DestroyQuest(whichQuest_)
endfunction

function QuestSetEnabledBJ takes boolean enabled, quest whichQuest returns nothing
	call QuestSetEnabled(whichQuest_, enabled_)
endfunction

function QuestSetTitleBJ takes quest whichQuest, string title returns nothing
	call QuestSetTitle(whichQuest_, title_)
endfunction

function QuestSetDescriptionBJ takes quest whichQuest, string description returns nothing
	call QuestSetDescription(whichQuest_, description_)
endfunction

function QuestSetCompletedBJ takes quest whichQuest, boolean completed returns nothing
	call QuestSetCompleted(whichQuest_, completed_)
endfunction

function QuestSetFailedBJ takes quest whichQuest, boolean failed returns nothing
	call QuestSetFailed(whichQuest_, failed_)
endfunction

function QuestSetDiscoveredBJ takes quest whichQuest, boolean discovered returns nothing
	call QuestSetDiscovered(whichQuest_, discovered_)
endfunction

function GetLastCreatedQuestBJ takes nothing returns quest
	return bj_lastCreatedQuest_
endfunction

function CreateQuestItemBJ takes quest whichQuest, string description returns questitem
	set bj_lastCreatedQuestItem_ = QuestCreateItem(whichQuest_)
	call QuestItemSetDescription(bj_lastCreatedQuestItem_, description_)
	call QuestItemSetCompleted(bj_lastCreatedQuestItem_, false)
	return bj_lastCreatedQuestItem_
endfunction

function QuestItemSetDescriptionBJ takes questitem whichQuestItem, string description returns nothing
	call QuestItemSetDescription(whichQuestItem_, description_)
endfunction

function QuestItemSetCompletedBJ takes questitem whichQuestItem, boolean completed returns nothing
	call QuestItemSetCompleted(whichQuestItem_, completed_)
endfunction

function GetLastCreatedQuestItemBJ takes nothing returns questitem
	return bj_lastCreatedQuestItem_
endfunction

function CreateDefeatConditionBJ takes string description returns defeatcondition
	set bj_lastCreatedDefeatCondition_ = CreateDefeatCondition()
	call DefeatConditionSetDescription(bj_lastCreatedDefeatCondition_, description_)
	return bj_lastCreatedDefeatCondition_
endfunction

function DestroyDefeatConditionBJ takes defeatcondition whichCondition returns nothing
	call DestroyDefeatCondition(whichCondition_)
endfunction

function DefeatConditionSetDescriptionBJ takes defeatcondition whichCondition, string description returns nothing
	call DefeatConditionSetDescription(whichCondition_, description_)
endfunction

function GetLastCreatedDefeatConditionBJ takes nothing returns defeatcondition
	return bj_lastCreatedDefeatCondition_
endfunction

function FlashQuestDialogButtonBJ takes nothing returns nothing
	call FlashQuestDialogButton()
endfunction

function QuestMessageBJ takes force f, integer messageType, string message returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), f_)) then
		if (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUEST_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUEST_, message_)
			call StartSound(bj_questDiscoveredSound_)
			call FlashQuestDialogButton()
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTUPDATE_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTUPDATE_, message_)
			call StartSound(bj_questUpdatedSound_)
			call FlashQuestDialogButton()
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTDONE_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTDONE_, message_)
			call StartSound(bj_questCompletedSound_)
			call FlashQuestDialogButton()
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTFAILED_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTFAILED_, message_)
			call StartSound(bj_questFailedSound_)
			call FlashQuestDialogButton()
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_QUESTREQUIREMENT_, message_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_MISSIONFAILED_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_MISSIONFAILED_, message_)
			call StartSound(bj_questFailedSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_HINT_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_HINT_, message_)
			call StartSound(bj_questHintSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_ALWAYSHINT_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_ALWAYSHINT_, message_)
			call StartSound(bj_questHintSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_SECRET_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_SECRET_, message_)
			call StartSound(bj_questSecretSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_UNITACQUIRED_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_UNITACQUIRED_, message_)
			call StartSound(bj_questHintSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_UNITAVAILABLE_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_UNITAVAILABLE_, message_)
			call StartSound(bj_questHintSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_ITEMACQUIRED_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_ITEMACQUIRED_, message_)
			call StartSound(bj_questItemAcquiredSound_)
		elseif (messageType_ == bj_QUESTMESSAGE_DISCOVERED_) then
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_WARNING_, " ")
			call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_TEXT_DELAY_WARNING_, message_)
			call StartSound(bj_questWarningSound_)
		else
		endif
	endif
endfunction

function StartTimerBJ takes timer t, boolean periodic, real timeout returns timer
	set bj_lastStartedTimer_ = t_
	call TimerStart(t_, timeout_, periodic_, null)
	return bj_lastStartedTimer_
endfunction

function CreateTimerBJ takes boolean periodic, real timeout returns timer
	set bj_lastStartedTimer_ = CreateTimer()
	call TimerStart(bj_lastStartedTimer_, timeout_, periodic_, null)
	return bj_lastStartedTimer_
endfunction

function DestroyTimerBJ takes timer whichTimer returns nothing
	call DestroyTimer(whichTimer_)
endfunction

function PauseTimerBJ takes boolean pause, timer whichTimer returns nothing
	if pause_ then
		call PauseTimer(whichTimer_)
	else
		call ResumeTimer(whichTimer_)
	endif
endfunction

function GetLastCreatedTimerBJ takes nothing returns timer
	return bj_lastStartedTimer_
endfunction

function CreateTimerDialogBJ takes timer t, string title returns timerdialog
	set bj_lastCreatedTimerDialog_ = CreateTimerDialog(t_)
	call TimerDialogSetTitle(bj_lastCreatedTimerDialog_, title_)
	call TimerDialogDisplay(bj_lastCreatedTimerDialog_, true)
	return bj_lastCreatedTimerDialog_
endfunction

function DestroyTimerDialogBJ takes timerdialog td returns nothing
	call DestroyTimerDialog(td_)
endfunction

function TimerDialogSetTitleBJ takes timerdialog td, string title returns nothing
	call TimerDialogSetTitle(td_, title_)
endfunction

function TimerDialogSetTitleColorBJ takes timerdialog td, real red, real green, real blue, real transparency returns nothing
	call TimerDialogSetTitleColor(td_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function TimerDialogSetTimeColorBJ takes timerdialog td, real red, real green, real blue, real transparency returns nothing
	call TimerDialogSetTimeColor(td_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function TimerDialogSetSpeedBJ takes timerdialog td, real speedMultFactor returns nothing
	call TimerDialogSetSpeed(td_, speedMultFactor_)
endfunction

function TimerDialogDisplayForPlayerBJ takes boolean show, timerdialog td, player whichPlayer returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call TimerDialogDisplay(td_, show_)
	endif
endfunction

function TimerDialogDisplayBJ takes boolean show, timerdialog td returns nothing
	call TimerDialogDisplay(td_, show_)
endfunction

function GetLastCreatedTimerDialogBJ takes nothing returns timerdialog
	return bj_lastCreatedTimerDialog_
endfunction

function LeaderboardResizeBJ takes leaderboard lb returns nothing
	local integer size = LeaderboardGetItemCount(lb_)
	if (LeaderboardGetLabelText(lb_) == "") then
		set size_ = size_ - 1
	endif
	call LeaderboardSetSizeByItemCount(lb_, size_)
endfunction

function LeaderboardSetPlayerItemValueBJ takes player whichPlayer, leaderboard lb, integer val returns nothing
	call LeaderboardSetItemValue(lb_, LeaderboardGetPlayerIndex(lb_, whichPlayer_), val_)
endfunction

function LeaderboardSetPlayerItemLabelBJ takes player whichPlayer, leaderboard lb, string val returns nothing
	call LeaderboardSetItemLabel(lb_, LeaderboardGetPlayerIndex(lb_, whichPlayer_), val_)
endfunction

function LeaderboardSetPlayerItemStyleBJ takes player whichPlayer, leaderboard lb, boolean showLabel, boolean showValue, boolean showIcon returns nothing
	call LeaderboardSetItemStyle(lb_, LeaderboardGetPlayerIndex(lb_, whichPlayer_), showLabel_, showValue_, showIcon_)
endfunction

function LeaderboardSetPlayerItemLabelColorBJ takes player whichPlayer, leaderboard lb, real red, real green, real blue, real transparency returns nothing
	call LeaderboardSetItemLabelColor(lb_, LeaderboardGetPlayerIndex(lb_, whichPlayer_), PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function LeaderboardSetPlayerItemValueColorBJ takes player whichPlayer, leaderboard lb, real red, real green, real blue, real transparency returns nothing
	call LeaderboardSetItemValueColor(lb_, LeaderboardGetPlayerIndex(lb_, whichPlayer_), PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function LeaderboardSetLabelColorBJ takes leaderboard lb, real red, real green, real blue, real transparency returns nothing
	call LeaderboardSetLabelColor(lb_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function LeaderboardSetValueColorBJ takes leaderboard lb, real red, real green, real blue, real transparency returns nothing
	call LeaderboardSetValueColor(lb_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function LeaderboardSetLabelBJ takes leaderboard lb, string label returns nothing
	call LeaderboardSetLabel(lb_, label_)
	call LeaderboardResizeBJ(lb_)
endfunction

function LeaderboardSetStyleBJ takes leaderboard lb, boolean showLabel, boolean showNames, boolean showValues, boolean showIcons returns nothing
	call LeaderboardSetStyle(lb_, showLabel_, showNames_, showValues_, showIcons_)
endfunction

function LeaderboardGetItemCountBJ takes leaderboard lb returns integer
	return LeaderboardGetItemCount(lb_)
endfunction

function LeaderboardHasPlayerItemBJ takes leaderboard lb, player whichPlayer returns boolean
	return LeaderboardHasPlayerItem(lb_, whichPlayer_)
endfunction

function ForceSetLeaderboardBJ takes leaderboard lb, force toForce returns nothing
	local integer index
	local player indexPlayer
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if IsPlayerInForce(indexPlayer_, toForce_) then
			call PlayerSetLeaderboard(indexPlayer_, lb_)
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function CreateLeaderboardBJ takes force toForce, string label returns leaderboard
	set bj_lastCreatedLeaderboard_ = CreateLeaderboard()
	call LeaderboardSetLabel(bj_lastCreatedLeaderboard_, label_)
	call ForceSetLeaderboardBJ(bj_lastCreatedLeaderboard_, toForce_)
	call LeaderboardDisplay(bj_lastCreatedLeaderboard_, true)
	return bj_lastCreatedLeaderboard_
endfunction

function DestroyLeaderboardBJ takes leaderboard lb returns nothing
	call DestroyLeaderboard(lb_)
endfunction

function LeaderboardDisplayBJ takes boolean show, leaderboard lb returns nothing
	call LeaderboardDisplay(lb_, show_)
endfunction

function LeaderboardAddItemBJ takes player whichPlayer, leaderboard lb, string label, integer value returns nothing
	if (LeaderboardHasPlayerItem(lb_, whichPlayer_)) then
		call LeaderboardRemovePlayerItem(lb_, whichPlayer_)
	endif
	call LeaderboardAddItem(lb_, label_, value_, whichPlayer_)
	call LeaderboardResizeBJ(lb_)
endfunction

function LeaderboardRemovePlayerItemBJ takes player whichPlayer, leaderboard lb returns nothing
	call LeaderboardRemovePlayerItem(lb_, whichPlayer_)
	call LeaderboardResizeBJ(lb_)
endfunction

function LeaderboardSortItemsBJ takes leaderboard lb, integer sortType, boolean ascending returns nothing
	if (sortType_ == bj_SORTTYPE_SORTBYVALUE_) then
		call LeaderboardSortItemsByValue(lb_, ascending_)
	elseif (sortType_ == bj_SORTTYPE_SORTBYVALUE_) then
		call LeaderboardSortItemsByPlayer(lb_, ascending_)
	elseif (sortType_ == bj_SORTTYPE_SORTBYVALUE_) then
		call LeaderboardSortItemsByLabel(lb_, ascending_)
	else
	endif
endfunction

function LeaderboardSortItemsByPlayerBJ takes leaderboard lb, boolean ascending returns nothing
	call LeaderboardSortItemsByPlayer(lb_, ascending_)
endfunction

function LeaderboardSortItemsByLabelBJ takes leaderboard lb, boolean ascending returns nothing
	call LeaderboardSortItemsByLabel(lb_, ascending_)
endfunction

function LeaderboardGetPlayerIndexBJ takes player whichPlayer, leaderboard lb returns integer
	return LeaderboardGetPlayerIndex(lb_, whichPlayer_) + 1
endfunction

function LeaderboardGetIndexedPlayerBJ takes integer position, leaderboard lb returns player
	local integer index
	local player indexPlayer
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (LeaderboardGetPlayerIndex(lb_, indexPlayer_) == position_ - 1) then
			return indexPlayer_
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	return Player(PLAYER_NEUTRAL_PASSIVE_)
endfunction

function PlayerGetLeaderboardBJ takes player whichPlayer returns leaderboard
	return PlayerGetLeaderboard(whichPlayer_)
endfunction

function GetLastCreatedLeaderboard takes nothing returns leaderboard
	return bj_lastCreatedLeaderboard_
endfunction

function CreateMultiboardBJ takes integer cols, integer rows, string title returns multiboard
	set bj_lastCreatedMultiboard_ = CreateMultiboard()
	call MultiboardSetRowCount(bj_lastCreatedMultiboard_, rows_)
	call MultiboardSetColumnCount(bj_lastCreatedMultiboard_, cols_)
	call MultiboardSetTitleText(bj_lastCreatedMultiboard_, title_)
	call MultiboardDisplay(bj_lastCreatedMultiboard_, true)
	return bj_lastCreatedMultiboard_
endfunction

function DestroyMultiboardBJ takes multiboard mb returns nothing
	call DestroyMultiboard(mb_)
endfunction

function GetLastCreatedMultiboard takes nothing returns multiboard
	return bj_lastCreatedMultiboard_
endfunction

function MultiboardDisplayBJ takes boolean show, multiboard mb returns nothing
	call MultiboardDisplay(mb_, show_)
endfunction

function MultiboardMinimizeBJ takes boolean minimize, multiboard mb returns nothing
	call MultiboardMinimize(mb_, minimize_)
endfunction

function MultiboardSetTitleTextColorBJ takes multiboard mb, real red, real green, real blue, real transparency returns nothing
	call MultiboardSetTitleTextColor(mb_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function MultiboardAllowDisplayBJ takes boolean flag returns nothing
	call MultiboardSuppressDisplay(not flag_)
endfunction

function MultiboardSetItemStyleBJ takes multiboard mb, integer col, integer row, boolean showValue, boolean showIcon returns nothing
	local integer curRow = 0
	local integer curCol = 0
	local integer numRows = MultiboardGetRowCount(mb_)
	local integer numCols = MultiboardGetColumnCount(mb_)
	local multiboarditem mbitem = null
	loop
		set curRow_ = curRow_ + 1
		exitwhen curRow_ > numRows_
		if (row_ == 0 or row_ == curRow_) then
			set curCol_ = 0
			loop
				set curCol_ = curCol_ + 1
				exitwhen curCol_ > numCols_
				if (col_ == 0 or col_ == curCol_) then
					set mbitem_ = MultiboardGetItem(mb_, curRow_ - 1, curCol_ - 1)
					call MultiboardSetItemStyle(mbitem_, showValue_, showIcon_)
					call MultiboardReleaseItem(mbitem_)
				endif
			endloop
		endif
	endloop
endfunction

function MultiboardSetItemValueBJ takes multiboard mb, integer col, integer row, string val returns nothing
	local integer curRow = 0
	local integer curCol = 0
	local integer numRows = MultiboardGetRowCount(mb_)
	local integer numCols = MultiboardGetColumnCount(mb_)
	local multiboarditem mbitem = null
	loop
		set curRow_ = curRow_ + 1
		exitwhen curRow_ > numRows_
		if (row_ == 0 or row_ == curRow_) then
			set curCol_ = 0
			loop
				set curCol_ = curCol_ + 1
				exitwhen curCol_ > numCols_
				if (col_ == 0 or col_ == curCol_) then
					set mbitem_ = MultiboardGetItem(mb_, curRow_ - 1, curCol_ - 1)
					call MultiboardSetItemValue(mbitem_, val_)
					call MultiboardReleaseItem(mbitem_)
				endif
			endloop
		endif
	endloop
endfunction

function MultiboardSetItemColorBJ takes multiboard mb, integer col, integer row, real red, real green, real blue, real transparency returns nothing
	local integer curRow = 0
	local integer curCol = 0
	local integer numRows = MultiboardGetRowCount(mb_)
	local integer numCols = MultiboardGetColumnCount(mb_)
	local multiboarditem mbitem = null
	loop
		set curRow_ = curRow_ + 1
		exitwhen curRow_ > numRows_
		if (row_ == 0 or row_ == curRow_) then
			set curCol_ = 0
			loop
				set curCol_ = curCol_ + 1
				exitwhen curCol_ > numCols_
				if (col_ == 0 or col_ == curCol_) then
					set mbitem_ = MultiboardGetItem(mb_, curRow_ - 1, curCol_ - 1)
					call MultiboardSetItemValueColor(mbitem_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
					call MultiboardReleaseItem(mbitem_)
				endif
			endloop
		endif
	endloop
endfunction

function MultiboardSetItemWidthBJ takes multiboard mb, integer col, integer row, real width returns nothing
	local integer curRow = 0
	local integer curCol = 0
	local integer numRows = MultiboardGetRowCount(mb_)
	local integer numCols = MultiboardGetColumnCount(mb_)
	local multiboarditem mbitem = null
	loop
		set curRow_ = curRow_ + 1
		exitwhen curRow_ > numRows_
		if (row_ == 0 or row_ == curRow_) then
			set curCol_ = 0
			loop
				set curCol_ = curCol_ + 1
				exitwhen curCol_ > numCols_
				if (col_ == 0 or col_ == curCol_) then
					set mbitem_ = MultiboardGetItem(mb_, curRow_ - 1, curCol_ - 1)
					call MultiboardSetItemWidth(mbitem_, width_ / 100.0)
					call MultiboardReleaseItem(mbitem_)
				endif
			endloop
		endif
	endloop
endfunction

function MultiboardSetItemIconBJ takes multiboard mb, integer col, integer row, string iconFileName returns nothing
	local integer curRow = 0
	local integer curCol = 0
	local integer numRows = MultiboardGetRowCount(mb_)
	local integer numCols = MultiboardGetColumnCount(mb_)
	local multiboarditem mbitem = null
	loop
		set curRow_ = curRow_ + 1
		exitwhen curRow_ > numRows_
		if (row_ == 0 or row_ == curRow_) then
			set curCol_ = 0
			loop
				set curCol_ = curCol_ + 1
				exitwhen curCol_ > numCols_
				if (col_ == 0 or col_ == curCol_) then
					set mbitem_ = MultiboardGetItem(mb_, curRow_ - 1, curCol_ - 1)
					call MultiboardSetItemIcon(mbitem_, iconFileName_)
					call MultiboardReleaseItem(mbitem_)
				endif
			endloop
		endif
	endloop
endfunction

function TextTagSize2Height takes real size returns real
	return size_ * 0.023 / 10
endfunction

function TextTagSpeed2Velocity takes real speed returns real
	return speed_ * 0.071 / 128
endfunction

function SetTextTagColorBJ takes texttag tt, real red, real green, real blue, real transparency returns nothing
	call SetTextTagColor(tt_, PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100.0 - transparency_))
endfunction

function SetTextTagVelocityBJ takes texttag tt, real speed, real angle returns nothing
	local real vel = TextTagSpeed2Velocity(speed_)
	local real xvel = vel_ * Cos(angle_ * bj_DEGTORAD_)
	local real yvel = vel_ * Sin(angle_ * bj_DEGTORAD_)
	call SetTextTagVelocity(tt_, xvel_, yvel_)
endfunction

function SetTextTagTextBJ takes texttag tt, string s, real size returns nothing
	local real textHeight = TextTagSize2Height(size_)
	call SetTextTagText(tt_, s_, textHeight_)
endfunction

function SetTextTagPosBJ takes texttag tt, location loc, real zOffset returns nothing
	call SetTextTagPos(tt_, GetLocationX(loc_), GetLocationY(loc_), zOffset_)
endfunction

function SetTextTagPosUnitBJ takes texttag tt, unit whichUnit, real zOffset returns nothing
	call SetTextTagPosUnit(tt_, whichUnit_, zOffset_)
endfunction

function SetTextTagSuspendedBJ takes texttag tt, boolean flag returns nothing
	call SetTextTagSuspended(tt_, flag_)
endfunction

function SetTextTagPermanentBJ takes texttag tt, boolean flag returns nothing
	call SetTextTagPermanent(tt_, flag_)
endfunction

function SetTextTagAgeBJ takes texttag tt, real age returns nothing
	call SetTextTagAge(tt_, age_)
endfunction

function SetTextTagLifespanBJ takes texttag tt, real lifespan returns nothing
	call SetTextTagLifespan(tt_, lifespan_)
endfunction

function SetTextTagFadepointBJ takes texttag tt, real fadepoint returns nothing
	call SetTextTagFadepoint(tt_, fadepoint_)
endfunction

function CreateTextTagLocBJ takes string s, location loc, real zOffset, real size, real red, real green, real blue, real transparency returns texttag
	set bj_lastCreatedTextTag_ = CreateTextTag()
	call SetTextTagTextBJ(bj_lastCreatedTextTag_, s_, size_)
	call SetTextTagPosBJ(bj_lastCreatedTextTag_, loc_, zOffset_)
	call SetTextTagColorBJ(bj_lastCreatedTextTag_, red_, green_, blue_, transparency_)
	return bj_lastCreatedTextTag_
endfunction

function CreateTextTagUnitBJ takes string s, unit whichUnit, real zOffset, real size, real red, real green, real blue, real transparency returns texttag
	set bj_lastCreatedTextTag_ = CreateTextTag()
	call SetTextTagTextBJ(bj_lastCreatedTextTag_, s_, size_)
	call SetTextTagPosUnitBJ(bj_lastCreatedTextTag_, whichUnit_, zOffset_)
	call SetTextTagColorBJ(bj_lastCreatedTextTag_, red_, green_, blue_, transparency_)
	return bj_lastCreatedTextTag_
endfunction

function DestroyTextTagBJ takes texttag tt returns nothing
	call DestroyTextTag(tt_)
endfunction

function ShowTextTagForceBJ takes boolean show, texttag tt, force whichForce returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call SetTextTagVisibility(tt_, show_)
	endif
endfunction

function GetLastCreatedTextTag takes nothing returns texttag
	return bj_lastCreatedTextTag_
endfunction

function PauseGameOn takes nothing returns nothing
	call PauseGame(true)
endfunction

function PauseGameOff takes nothing returns nothing
	call PauseGame(false)
endfunction

function SetUserControlForceOn takes force whichForce returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call EnableUserControl(true)
	endif
endfunction

function SetUserControlForceOff takes force whichForce returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call EnableUserControl(false)
	endif
endfunction

function ShowInterfaceForceOn takes force whichForce, real fadeDuration returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call ShowInterface(true, fadeDuration_)
	endif
endfunction

function ShowInterfaceForceOff takes force whichForce, real fadeDuration returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call ShowInterface(false, fadeDuration_)
	endif
endfunction

function PingMinimapForForce takes force whichForce, real x, real y, real duration returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		call PingMinimap(x_, y_, duration_)
	endif
endfunction

function PingMinimapLocForForce takes force whichForce, location loc, real duration returns nothing
	call PingMinimapForForce(whichForce_, GetLocationX(loc_), GetLocationY(loc_), duration_)
endfunction

function PingMinimapForPlayer takes player whichPlayer, real x, real y, real duration returns nothing
	if (GetLocalPlayer() == whichPlayer_) then
		call PingMinimap(x_, y_, duration_)
	endif
endfunction

function PingMinimapLocForPlayer takes player whichPlayer, location loc, real duration returns nothing
	call PingMinimapForPlayer(whichPlayer_, GetLocationX(loc_), GetLocationY(loc_), duration_)
endfunction

function PingMinimapForForceEx takes force whichForce, real x, real y, real duration, integer style, real red, real green, real blue returns nothing
	local integer red255 = PercentTo255(red_)
	local integer green255 = PercentTo255(green_)
	local integer blue255 = PercentTo255(blue_)
	if (IsPlayerInForce(GetLocalPlayer(), whichForce_)) then
		if (red255_ == 255) and (green255_ == 0) and (blue255_ == 0) then
			set red255_ = 254
		endif
		if (style_ == bj_MINIMAPPINGSTYLE_SIMPLE_) then
			call PingMinimapEx(x_, y_, duration_, red255_, green255_, blue255_, false)
		elseif (style_ == bj_MINIMAPPINGSTYLE_SIMPLE_) then
			call PingMinimapEx(x_, y_, duration_, red255_, green255_, blue255_, true)
		elseif (style_ == bj_MINIMAPPINGSTYLE_SIMPLE_) then
			call PingMinimapEx(x_, y_, duration_, 255, 0, 0, false)
		else
		endif
	endif
endfunction

function PingMinimapLocForForceEx takes force whichForce, location loc, real duration, integer style, real red, real green, real blue returns nothing
	call PingMinimapForForceEx(whichForce_, GetLocationX(loc_), GetLocationY(loc_), duration_, style_, red_, green_, blue_)
endfunction

function EnableWorldFogBoundaryBJ takes boolean enable, force f returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), f_)) then
		call EnableWorldFogBoundary(enable_)
	endif
endfunction

function EnableOcclusionBJ takes boolean enable, force f returns nothing
	if (IsPlayerInForce(GetLocalPlayer(), f_)) then
		call EnableOcclusion(enable_)
	endif
endfunction

function CancelCineSceneBJ takes nothing returns nothing
	call StopSoundBJ(bj_cineSceneLastSound_, true)
	call EndCinematicScene()
endfunction

function TryInitCinematicBehaviorBJ takes nothing returns nothing
	local integer index
	if (bj_cineSceneBeingSkipped_ == null) then
		set bj_cineSceneBeingSkipped_ = CreateTrigger()
		set index_ = 0
		loop
			call TriggerRegisterPlayerEvent(bj_cineSceneBeingSkipped_, Player(index_), EVENT_PLAYER_END_CINEMATIC_)
			set index_ = index_ + 1
			exitwhen index_ == bj_MAX_PLAYERS_
		endloop
		call TriggerAddAction(bj_cineSceneBeingSkipped_, function CancelCineSceneBJ)
	endif
endfunction

function SetCinematicSceneBJ takes sound soundHandle, integer portraitUnitId, playercolor color, string speakerTitle, string text, real sceneDuration, real voiceoverDuration returns nothing
	set bj_cineSceneLastSound_ = soundHandle_
	call PlaySoundBJ(soundHandle_)
	call SetCinematicScene(portraitUnitId_, color_, speakerTitle_, text_, sceneDuration_, voiceoverDuration_)
endfunction

function GetTransmissionDuration takes sound soundHandle, integer timeType, real timeVal returns real
	local real duration
	if (timeType_ == bj_TIMETYPE_ADD_) then
		set duration_ = GetSoundDurationBJ(soundHandle_) + timeVal_
	elseif (timeType_ == bj_TIMETYPE_ADD_) then
		set duration_ = timeVal_
	elseif (timeType_ == bj_TIMETYPE_ADD_) then
		set duration_ = GetSoundDurationBJ(soundHandle_) - timeVal_
	else
		set duration_ = GetSoundDurationBJ(soundHandle_)
	endif
	if (duration_ < 0) then
		set duration_ = 0
	endif
	return duration_
endfunction

function WaitTransmissionDuration takes sound soundHandle, integer timeType, real timeVal returns nothing
	if (timeType_ == bj_TIMETYPE_SET_) then
		call TriggerSleepAction(timeVal_)
	elseif (timeType_ == bj_TIMETYPE_SET_) then
		call TriggerSleepAction(bj_NOTHING_SOUND_DURATION_)
	elseif (timeType_ == bj_TIMETYPE_SET_) then
		call WaitForSoundBJ(soundHandle_, timeVal_)
	elseif (timeType_ == bj_TIMETYPE_SET_) then
		call WaitForSoundBJ(soundHandle_, 0)
		call TriggerSleepAction(timeVal_)
	else
	endif
endfunction

function DoTransmissionBasicsXYBJ takes integer unitId, playercolor color, real x, real y, sound soundHandle, string unitName, string message, real duration returns nothing
	call SetCinematicSceneBJ(soundHandle_, unitId_, color_, unitName_, message_, duration_ + bj_TRANSMISSION_PORT_HANGTIME_, duration_)
	if (unitId_ != 0) then
		call PingMinimap(x_, y_, bj_TRANSMISSION_PING_TIME_)
	endif
endfunction

function TransmissionFromUnitWithNameBJ takes force toForce, unit whichUnit, string unitName, sound soundHandle, string message, integer timeType, real timeVal, boolean wait returns nothing
	call TryInitCinematicBehaviorBJ()
	set timeVal_ = RMaxBJ(timeVal_, 0)
	set bj_lastTransmissionDuration_ = GetTransmissionDuration(soundHandle_, timeType_, timeVal_)
	set bj_lastPlayedSound_ = soundHandle_
	if (IsPlayerInForce(GetLocalPlayer(), toForce_)) then
		if (whichUnit_ == null) then
			call DoTransmissionBasicsXYBJ(0, PLAYER_COLOR_RED_, 0, 0, soundHandle_, unitName_, message_, bj_lastTransmissionDuration_)
		else
			call DoTransmissionBasicsXYBJ(GetUnitTypeId(whichUnit_), GetPlayerColor(GetOwningPlayer(whichUnit_)), GetUnitX(whichUnit_), GetUnitY(whichUnit_), soundHandle_, unitName_, message_, bj_lastTransmissionDuration_)
			if (not IsUnitHidden(whichUnit_)) then
				call UnitAddIndicator(whichUnit_, bj_TRANSMISSION_IND_RED_, bj_TRANSMISSION_IND_BLUE_, bj_TRANSMISSION_IND_GREEN_, bj_TRANSMISSION_IND_ALPHA_)
			endif
		endif
	endif
	if wait_ and (bj_lastTransmissionDuration_ > 0) then
		call WaitTransmissionDuration(soundHandle_, timeType_, timeVal_)
	endif
endfunction

function TransmissionFromUnitTypeWithNameBJ takes force toForce, player fromPlayer, integer unitId, string unitName, location loc, sound soundHandle, string message, integer timeType, real timeVal, boolean wait returns nothing
	call TryInitCinematicBehaviorBJ()
	set timeVal_ = RMaxBJ(timeVal_, 0)
	set bj_lastTransmissionDuration_ = GetTransmissionDuration(soundHandle_, timeType_, timeVal_)
	set bj_lastPlayedSound_ = soundHandle_
	if (IsPlayerInForce(GetLocalPlayer(), toForce_)) then
		call DoTransmissionBasicsXYBJ(unitId_, GetPlayerColor(fromPlayer_), GetLocationX(loc_), GetLocationY(loc_), soundHandle_, unitName_, message_, bj_lastTransmissionDuration_)
	endif
	if wait_ and (bj_lastTransmissionDuration_ > 0) then
		call WaitTransmissionDuration(soundHandle_, timeType_, timeVal_)
	endif
endfunction

function GetLastTransmissionDurationBJ takes nothing returns real
	return bj_lastTransmissionDuration_
endfunction

function ForceCinematicSubtitlesBJ takes boolean flag returns nothing
	call ForceCinematicSubtitles(flag_)
endfunction

function CinematicModeExBJ takes boolean cineMode, force forForce, real interfaceFadeTime returns nothing
	if (not bj_gameStarted_) then
		set interfaceFadeTime_ = 0
	endif
	if (cineMode_) then
		if (not bj_cineModeAlreadyIn_) then
			set bj_cineModeAlreadyIn_ = true
			set bj_cineModePriorSpeed_ = GetGameSpeed()
			set bj_cineModePriorFogSetting_ = IsFogEnabled()
			set bj_cineModePriorMaskSetting_ = IsFogMaskEnabled()
			set bj_cineModePriorDawnDusk_ = IsDawnDuskEnabled()
			set bj_cineModeSavedSeed_ = GetRandomInt(0, 1000000)
		endif
		if (IsPlayerInForce(GetLocalPlayer(), forForce_)) then
			call ClearTextMessages()
			call ShowInterface(false, interfaceFadeTime_)
			call EnableUserControl(false)
			call EnableOcclusion(false)
			call SetCineModeVolumeGroupsBJ()
		endif
		call SetGameSpeed(bj_CINEMODE_GAMESPEED_)
		call SetMapFlag(MAP_LOCK_SPEED_, true)
		call FogMaskEnable(false)
		call FogEnable(false)
		call EnableWorldFogBoundary(false)
		call EnableDawnDusk(false)
		call SetRandomSeed(0)
	else
		set bj_cineModeAlreadyIn_ = false
		if (IsPlayerInForce(GetLocalPlayer(), forForce_)) then
			call ShowInterface(true, interfaceFadeTime_)
			call EnableUserControl(true)
			call EnableOcclusion(true)
			call VolumeGroupReset()
			call EndThematicMusic()
			call CameraResetSmoothingFactorBJ()
		endif
		call SetMapFlag(MAP_LOCK_SPEED_, false)
		call SetGameSpeed(bj_cineModePriorSpeed_)
		call FogMaskEnable(bj_cineModePriorMaskSetting_)
		call FogEnable(bj_cineModePriorFogSetting_)
		call EnableWorldFogBoundary(true)
		call EnableDawnDusk(bj_cineModePriorDawnDusk_)
		call SetRandomSeed(bj_cineModeSavedSeed_)
	endif
endfunction

function CinematicModeBJ takes boolean cineMode, force forForce returns nothing
	call CinematicModeExBJ(cineMode_, forForce_, bj_CINEMODE_INTERFACEFADE_)
endfunction

function DisplayCineFilterBJ takes boolean flag returns nothing
	call DisplayCineFilter(flag_)
endfunction

function CinematicFadeCommonBJ takes real red, real green, real blue, real duration, string tex, real startTrans, real endTrans returns nothing
	if (duration_ == 0) then
		set startTrans_ = endTrans_
	endif
	call EnableUserUI(false)
	call SetCineFilterTexture(tex_)
	call SetCineFilterBlendMode(BLEND_MODE_BLEND_)
	call SetCineFilterTexMapFlags(TEXMAP_FLAG_NONE_)
	call SetCineFilterStartUV(0, 0, 1, 1)
	call SetCineFilterEndUV(0, 0, 1, 1)
	call SetCineFilterStartColor(PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100 - startTrans_))
	call SetCineFilterEndColor(PercentTo255(red_), PercentTo255(green_), PercentTo255(blue_), PercentTo255(100 - endTrans_))
	call SetCineFilterDuration(duration_)
	call DisplayCineFilter(true)
endfunction

function FinishCinematicFadeBJ takes nothing returns nothing
	call DestroyTimer(bj_cineFadeFinishTimer_)
	set bj_cineFadeFinishTimer_ = null
	call DisplayCineFilter(false)
	call EnableUserUI(true)
endfunction

function FinishCinematicFadeAfterBJ takes real duration returns nothing
	set bj_cineFadeFinishTimer_ = CreateTimer()
	call TimerStart(bj_cineFadeFinishTimer_, duration_, false, function FinishCinematicFadeBJ)
endfunction

function ContinueCinematicFadeBJ takes nothing returns nothing
	call DestroyTimer(bj_cineFadeContinueTimer_)
	set bj_cineFadeContinueTimer_ = null
	call CinematicFadeCommonBJ(bj_cineFadeContinueRed_, bj_cineFadeContinueGreen_, bj_cineFadeContinueBlue_, bj_cineFadeContinueDuration_, bj_cineFadeContinueTex_, bj_cineFadeContinueTrans_, 100)
endfunction

function ContinueCinematicFadeAfterBJ takes real duration, real red, real green, real blue, real trans, string tex returns nothing
	set bj_cineFadeContinueRed_ = red_
	set bj_cineFadeContinueGreen_ = green_
	set bj_cineFadeContinueBlue_ = blue_
	set bj_cineFadeContinueTrans_ = trans_
	set bj_cineFadeContinueDuration_ = duration_
	set bj_cineFadeContinueTex_ = tex_
	set bj_cineFadeContinueTimer_ = CreateTimer()
	call TimerStart(bj_cineFadeContinueTimer_, duration_, false, function ContinueCinematicFadeBJ)
endfunction

function AbortCinematicFadeBJ takes nothing returns nothing
	if (bj_cineFadeContinueTimer_ != null) then
		call DestroyTimer(bj_cineFadeContinueTimer_)
	endif
	if (bj_cineFadeFinishTimer_ != null) then
		call DestroyTimer(bj_cineFadeFinishTimer_)
	endif
endfunction

function CinematicFadeBJ takes integer fadetype, real duration, string tex, real red, real green, real blue, real trans returns nothing
	if (fadetype_ == bj_CINEFADETYPE_FADEOUT_) then
		call AbortCinematicFadeBJ()
		call CinematicFadeCommonBJ(red_, green_, blue_, duration_, tex_, 100, trans_)
	elseif (fadetype_ == bj_CINEFADETYPE_FADEOUT_) then
		call AbortCinematicFadeBJ()
		call CinematicFadeCommonBJ(red_, green_, blue_, duration_, tex_, trans_, 100)
		call FinishCinematicFadeAfterBJ(duration_)
	elseif (fadetype_ == bj_CINEFADETYPE_FADEOUT_) then
		if (duration_ > 0) then
			call AbortCinematicFadeBJ()
			call CinematicFadeCommonBJ(red_, green_, blue_, duration_ * 0.5, tex_, 100, trans_)
			call ContinueCinematicFadeAfterBJ(duration_ * 0.5, red_, green_, blue_, trans_, tex_)
			call FinishCinematicFadeAfterBJ(duration_)
		endif
	else
	endif
endfunction

function CinematicFilterGenericBJ takes real duration, blendmode bmode, string tex, real red0, real green0, real blue0, real trans0, real red1, real green1, real blue1, real trans1 returns nothing
	call AbortCinematicFadeBJ()
	call SetCineFilterTexture(tex_)
	call SetCineFilterBlendMode(bmode_)
	call SetCineFilterTexMapFlags(TEXMAP_FLAG_NONE_)
	call SetCineFilterStartUV(0, 0, 1, 1)
	call SetCineFilterEndUV(0, 0, 1, 1)
	call SetCineFilterStartColor(PercentTo255(red0_), PercentTo255(green0_), PercentTo255(blue0_), PercentTo255(100 - trans0_))
	call SetCineFilterEndColor(PercentTo255(red1_), PercentTo255(green1_), PercentTo255(blue1_), PercentTo255(100 - trans1_))
	call SetCineFilterDuration(duration_)
	call DisplayCineFilter(true)
endfunction

function RescueUnitBJ takes unit whichUnit, player rescuer, boolean changeColor returns nothing
	if IsUnitDeadBJ(whichUnit_) or (GetOwningPlayer(whichUnit_) == rescuer_) then
		return
	endif
	call StartSound(bj_rescueSound_)
	call SetUnitOwner(whichUnit_, rescuer_, changeColor_)
	call UnitAddIndicator(whichUnit_, 0, 255, 0, 255)
	call PingMinimapForPlayer(rescuer_, GetUnitX(whichUnit_), GetUnitY(whichUnit_), bj_RESCUE_PING_TIME_)
endfunction

function TriggerActionUnitRescuedBJ takes nothing returns nothing
	local unit theUnit = GetTriggerUnit()
	if IsUnitType(theUnit_, UNIT_TYPE_STRUCTURE_) then
		call RescueUnitBJ(theUnit_, GetOwningPlayer(GetRescuer()), bj_rescueChangeColorBldg_)
	else
		call RescueUnitBJ(theUnit_, GetOwningPlayer(GetRescuer()), bj_rescueChangeColorUnit_)
	endif
endfunction

function TryInitRescuableTriggersBJ takes nothing returns nothing
	local integer index
	if (bj_rescueUnitBehavior_ == null) then
		set bj_rescueUnitBehavior_ = CreateTrigger()
		set index_ = 0
		loop
			call TriggerRegisterPlayerUnitEvent(bj_rescueUnitBehavior_, Player(index_), EVENT_PLAYER_UNIT_RESCUED_, null)
			set index_ = index_ + 1
			exitwhen index_ == bj_MAX_PLAYER_SLOTS_
		endloop
		call TriggerAddAction(bj_rescueUnitBehavior_, function TriggerActionUnitRescuedBJ)
	endif
endfunction

function SetRescueUnitColorChangeBJ takes boolean changeColor returns nothing
	set bj_rescueChangeColorUnit_ = changeColor_
endfunction

function SetRescueBuildingColorChangeBJ takes boolean changeColor returns nothing
	set bj_rescueChangeColorBldg_ = changeColor_
endfunction

function MakeUnitRescuableToForceBJEnum takes nothing returns nothing
	call TryInitRescuableTriggersBJ()
	call SetUnitRescuable(bj_makeUnitRescuableUnit_, GetEnumPlayer(), bj_makeUnitRescuableFlag_)
endfunction

function MakeUnitRescuableToForceBJ takes unit whichUnit, boolean isRescuable, force whichForce returns nothing
	set bj_makeUnitRescuableUnit_ = whichUnit_
	set bj_makeUnitRescuableFlag_ = isRescuable_
	call ForForce(whichForce_, function MakeUnitRescuableToForceBJEnum)
endfunction

function InitRescuableBehaviorBJ takes nothing returns nothing
	local integer index
	set index_ = 0
	loop
		if (GetPlayerController(Player(index_)) == MAP_CONTROL_RESCUABLE_) then
			call TryInitRescuableTriggersBJ()
			return
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function SetPlayerTechResearchedSwap takes integer techid, integer levels, player whichPlayer returns nothing
	call SetPlayerTechResearched(whichPlayer_, techid_, levels_)
endfunction

function SetPlayerTechMaxAllowedSwap takes integer techid, integer maximum, player whichPlayer returns nothing
	call SetPlayerTechMaxAllowed(whichPlayer_, techid_, maximum_)
endfunction

function SetPlayerMaxHeroesAllowed takes integer maximum, player whichPlayer returns nothing
	call SetPlayerTechMaxAllowed(whichPlayer_, 'HERO', maximum_)
endfunction

function GetPlayerTechCountSimple takes integer techid, player whichPlayer returns integer
	return GetPlayerTechCount(whichPlayer_, techid_, true)
endfunction

function GetPlayerTechMaxAllowedSwap takes integer techid, player whichPlayer returns integer
	return GetPlayerTechMaxAllowed(whichPlayer_, techid_)
endfunction

function SetPlayerAbilityAvailableBJ takes boolean avail, integer abilid, player whichPlayer returns nothing
	call SetPlayerAbilityAvailable(whichPlayer_, abilid_, avail_)
endfunction

function SetCampaignMenuRaceBJ takes integer campaignNumber returns nothing
	if (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRace(RACE_OTHER_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRace(RACE_HUMAN_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRace(RACE_UNDEAD_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRace(RACE_ORC_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRace(RACE_NIGHTELF_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRaceEx(bj_CAMPAIGN_OFFSET_XN_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRaceEx(bj_CAMPAIGN_OFFSET_XH_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRaceEx(bj_CAMPAIGN_OFFSET_XU_)
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_T_) then
		call SetCampaignMenuRaceEx(bj_CAMPAIGN_OFFSET_XO_)
	else
	endif
endfunction

function SetMissionAvailableBJ takes boolean available, integer missionIndex returns nothing
	local integer campaignNumber = missionIndex_ / 1000
	local integer missionNumber = missionIndex_ - campaignNumber_ * 1000
	call SetMissionAvailable(campaignNumber_, missionNumber_, available_)
endfunction

function SetCampaignAvailableBJ takes boolean available, integer campaignNumber returns nothing
	local integer campaignOffset
	if (campaignNumber_ == bj_CAMPAIGN_INDEX_H_) then
		call SetTutorialCleared(true)
	endif
	if (campaignNumber_ == bj_CAMPAIGN_INDEX_XN_) then
		set campaignOffset_ = bj_CAMPAIGN_OFFSET_XN_
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_XN_) then
		set campaignOffset_ = bj_CAMPAIGN_OFFSET_XH_
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_XN_) then
		set campaignOffset_ = bj_CAMPAIGN_OFFSET_XU_
	elseif (campaignNumber_ == bj_CAMPAIGN_INDEX_XN_) then
		set campaignOffset_ = bj_CAMPAIGN_OFFSET_XO_
	else
		set campaignOffset_ = campaignNumber_
	endif
	call SetCampaignAvailable(campaignOffset_, available_)
	call SetCampaignMenuRaceBJ(campaignNumber_)
	call ForceCampaignSelectScreen()
endfunction

function SetCinematicAvailableBJ takes boolean available, integer cinematicIndex returns nothing
	if (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetOpCinematicAvailable(bj_CAMPAIGN_INDEX_T_, available_)
		call PlayCinematic("TutorialOp")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetOpCinematicAvailable(bj_CAMPAIGN_INDEX_H_, available_)
		call PlayCinematic("HumanOp")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_H_, available_)
		call PlayCinematic("HumanEd")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetOpCinematicAvailable(bj_CAMPAIGN_INDEX_O_, available_)
		call PlayCinematic("OrcOp")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_O_, available_)
		call PlayCinematic("OrcEd")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_U_, available_)
		call PlayCinematic("UndeadOp")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_U_, available_)
		call PlayCinematic("UndeadEd")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_N_, available_)
		call PlayCinematic("NightElfOp")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_INDEX_N_, available_)
		call PlayCinematic("NightElfEd")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetOpCinematicAvailable(bj_CAMPAIGN_OFFSET_XN_, available_)
		call PlayCinematic("IntroX")
	elseif (cinematicIndex_ == bj_CINEMATICINDEX_TOP_) then
		call SetEdCinematicAvailable(bj_CAMPAIGN_OFFSET_XU_, available_)
		call PlayCinematic("OutroX")
	else
	endif
endfunction

function InitGameCacheBJ takes string campaignFile returns gamecache
	set bj_lastCreatedGameCache_ = InitGameCache(campaignFile_)
	return bj_lastCreatedGameCache_
endfunction

function SaveGameCacheBJ takes gamecache cache returns boolean
	return SaveGameCache(cache_)
endfunction

function GetLastCreatedGameCacheBJ takes nothing returns gamecache
	return bj_lastCreatedGameCache_
endfunction

function InitHashtableBJ takes nothing returns hashtable
	set bj_lastCreatedHashtable_ = InitHashtable()
	return bj_lastCreatedHashtable_
endfunction

function GetLastCreatedHashtableBJ takes nothing returns hashtable
	return bj_lastCreatedHashtable_
endfunction

function StoreRealBJ takes real value, string key, string missionKey, gamecache cache returns nothing
	call StoreReal(cache_, missionKey_, key_, value_)
endfunction

function StoreIntegerBJ takes integer value, string key, string missionKey, gamecache cache returns nothing
	call StoreInteger(cache_, missionKey_, key_, value_)
endfunction

function StoreBooleanBJ takes boolean value, string key, string missionKey, gamecache cache returns nothing
	call StoreBoolean(cache_, missionKey_, key_, value_)
endfunction

function StoreStringBJ takes string value, string key, string missionKey, gamecache cache returns boolean
	return StoreString(cache_, missionKey_, key_, value_)
endfunction

function StoreUnitBJ takes unit whichUnit, string key, string missionKey, gamecache cache returns boolean
	return StoreUnit(cache_, missionKey_, key_, whichUnit_)
endfunction

function SaveRealBJ takes real value, integer key, integer missionKey, hashtable table returns nothing
	call SaveReal(table_, missionKey_, key_, value_)
endfunction

function SaveIntegerBJ takes integer value, integer key, integer missionKey, hashtable table returns nothing
	call SaveInteger(table_, missionKey_, key_, value_)
endfunction

function SaveBooleanBJ takes boolean value, integer key, integer missionKey, hashtable table returns nothing
	call SaveBoolean(table_, missionKey_, key_, value_)
endfunction

function SaveStringBJ takes string value, integer key, integer missionKey, hashtable table returns boolean
	return SaveStr(table_, missionKey_, key_, value_)
endfunction

function SavePlayerHandleBJ takes player whichPlayer, integer key, integer missionKey, hashtable table returns boolean
	return SavePlayerHandle(table_, missionKey_, key_, whichPlayer_)
endfunction

function SaveWidgetHandleBJ takes widget whichWidget, integer key, integer missionKey, hashtable table returns boolean
	return SaveWidgetHandle(table_, missionKey_, key_, whichWidget_)
endfunction

function SaveDestructableHandleBJ takes destructable whichDestructable, integer key, integer missionKey, hashtable table returns boolean
	return SaveDestructableHandle(table_, missionKey_, key_, whichDestructable_)
endfunction

function SaveItemHandleBJ takes item whichItem, integer key, integer missionKey, hashtable table returns boolean
	return SaveItemHandle(table_, missionKey_, key_, whichItem_)
endfunction

function SaveUnitHandleBJ takes unit whichUnit, integer key, integer missionKey, hashtable table returns boolean
	return SaveUnitHandle(table_, missionKey_, key_, whichUnit_)
endfunction

function SaveAbilityHandleBJ takes ability whichAbility, integer key, integer missionKey, hashtable table returns boolean
	return SaveAbilityHandle(table_, missionKey_, key_, whichAbility_)
endfunction

function SaveTimerHandleBJ takes timer whichTimer, integer key, integer missionKey, hashtable table returns boolean
	return SaveTimerHandle(table_, missionKey_, key_, whichTimer_)
endfunction

function SaveTriggerHandleBJ takes trigger whichTrigger, integer key, integer missionKey, hashtable table returns boolean
	return SaveTriggerHandle(table_, missionKey_, key_, whichTrigger_)
endfunction

function SaveTriggerConditionHandleBJ takes triggercondition whichTriggercondition, integer key, integer missionKey, hashtable table returns boolean
	return SaveTriggerConditionHandle(table_, missionKey_, key_, whichTriggercondition_)
endfunction

function SaveTriggerActionHandleBJ takes triggeraction whichTriggeraction, integer key, integer missionKey, hashtable table returns boolean
	return SaveTriggerActionHandle(table_, missionKey_, key_, whichTriggeraction_)
endfunction

function SaveTriggerEventHandleBJ takes event whichEvent, integer key, integer missionKey, hashtable table returns boolean
	return SaveTriggerEventHandle(table_, missionKey_, key_, whichEvent_)
endfunction

function SaveForceHandleBJ takes force whichForce, integer key, integer missionKey, hashtable table returns boolean
	return SaveForceHandle(table_, missionKey_, key_, whichForce_)
endfunction

function SaveGroupHandleBJ takes group whichGroup, integer key, integer missionKey, hashtable table returns boolean
	return SaveGroupHandle(table_, missionKey_, key_, whichGroup_)
endfunction

function SaveLocationHandleBJ takes location whichLocation, integer key, integer missionKey, hashtable table returns boolean
	return SaveLocationHandle(table_, missionKey_, key_, whichLocation_)
endfunction

function SaveRectHandleBJ takes rect whichRect, integer key, integer missionKey, hashtable table returns boolean
	return SaveRectHandle(table_, missionKey_, key_, whichRect_)
endfunction

function SaveBooleanExprHandleBJ takes boolexpr whichBoolexpr, integer key, integer missionKey, hashtable table returns boolean
	return SaveBooleanExprHandle(table_, missionKey_, key_, whichBoolexpr_)
endfunction

function SaveSoundHandleBJ takes sound whichSound, integer key, integer missionKey, hashtable table returns boolean
	return SaveSoundHandle(table_, missionKey_, key_, whichSound_)
endfunction

function SaveEffectHandleBJ takes effect whichEffect, integer key, integer missionKey, hashtable table returns boolean
	return SaveEffectHandle(table_, missionKey_, key_, whichEffect_)
endfunction

function SaveUnitPoolHandleBJ takes unitpool whichUnitpool, integer key, integer missionKey, hashtable table returns boolean
	return SaveUnitPoolHandle(table_, missionKey_, key_, whichUnitpool_)
endfunction

function SaveItemPoolHandleBJ takes itempool whichItempool, integer key, integer missionKey, hashtable table returns boolean
	return SaveItemPoolHandle(table_, missionKey_, key_, whichItempool_)
endfunction

function SaveQuestHandleBJ takes quest whichQuest, integer key, integer missionKey, hashtable table returns boolean
	return SaveQuestHandle(table_, missionKey_, key_, whichQuest_)
endfunction

function SaveQuestItemHandleBJ takes questitem whichQuestitem, integer key, integer missionKey, hashtable table returns boolean
	return SaveQuestItemHandle(table_, missionKey_, key_, whichQuestitem_)
endfunction

function SaveDefeatConditionHandleBJ takes defeatcondition whichDefeatcondition, integer key, integer missionKey, hashtable table returns boolean
	return SaveDefeatConditionHandle(table_, missionKey_, key_, whichDefeatcondition_)
endfunction

function SaveTimerDialogHandleBJ takes timerdialog whichTimerdialog, integer key, integer missionKey, hashtable table returns boolean
	return SaveTimerDialogHandle(table_, missionKey_, key_, whichTimerdialog_)
endfunction

function SaveLeaderboardHandleBJ takes leaderboard whichLeaderboard, integer key, integer missionKey, hashtable table returns boolean
	return SaveLeaderboardHandle(table_, missionKey_, key_, whichLeaderboard_)
endfunction

function SaveMultiboardHandleBJ takes multiboard whichMultiboard, integer key, integer missionKey, hashtable table returns boolean
	return SaveMultiboardHandle(table_, missionKey_, key_, whichMultiboard_)
endfunction

function SaveMultiboardItemHandleBJ takes multiboarditem whichMultiboarditem, integer key, integer missionKey, hashtable table returns boolean
	return SaveMultiboardItemHandle(table_, missionKey_, key_, whichMultiboarditem_)
endfunction

function SaveTrackableHandleBJ takes trackable whichTrackable, integer key, integer missionKey, hashtable table returns boolean
	return SaveTrackableHandle(table_, missionKey_, key_, whichTrackable_)
endfunction

function SaveDialogHandleBJ takes dialog whichDialog, integer key, integer missionKey, hashtable table returns boolean
	return SaveDialogHandle(table_, missionKey_, key_, whichDialog_)
endfunction

function SaveButtonHandleBJ takes button whichButton, integer key, integer missionKey, hashtable table returns boolean
	return SaveButtonHandle(table_, missionKey_, key_, whichButton_)
endfunction

function SaveTextTagHandleBJ takes texttag whichTexttag, integer key, integer missionKey, hashtable table returns boolean
	return SaveTextTagHandle(table_, missionKey_, key_, whichTexttag_)
endfunction

function SaveLightningHandleBJ takes lightning whichLightning, integer key, integer missionKey, hashtable table returns boolean
	return SaveLightningHandle(table_, missionKey_, key_, whichLightning_)
endfunction

function SaveImageHandleBJ takes image whichImage, integer key, integer missionKey, hashtable table returns boolean
	return SaveImageHandle(table_, missionKey_, key_, whichImage_)
endfunction

function SaveUbersplatHandleBJ takes ubersplat whichUbersplat, integer key, integer missionKey, hashtable table returns boolean
	return SaveUbersplatHandle(table_, missionKey_, key_, whichUbersplat_)
endfunction

function SaveRegionHandleBJ takes region whichRegion, integer key, integer missionKey, hashtable table returns boolean
	return SaveRegionHandle(table_, missionKey_, key_, whichRegion_)
endfunction

function SaveFogStateHandleBJ takes fogstate whichFogState, integer key, integer missionKey, hashtable table returns boolean
	return SaveFogStateHandle(table_, missionKey_, key_, whichFogState_)
endfunction

function SaveFogModifierHandleBJ takes fogmodifier whichFogModifier, integer key, integer missionKey, hashtable table returns boolean
	return SaveFogModifierHandle(table_, missionKey_, key_, whichFogModifier_)
endfunction

function SaveAgentHandleBJ takes agent whichAgent, integer key, integer missionKey, hashtable table returns boolean
	return SaveAgentHandle(table_, missionKey_, key_, whichAgent_)
endfunction

function SaveHashtableHandleBJ takes hashtable whichHashtable, integer key, integer missionKey, hashtable table returns boolean
	return SaveHashtableHandle(table_, missionKey_, key_, whichHashtable_)
endfunction

function GetStoredRealBJ takes string key, string missionKey, gamecache cache returns real
	return GetStoredReal(cache_, missionKey_, key_)
endfunction

function GetStoredIntegerBJ takes string key, string missionKey, gamecache cache returns integer
	return GetStoredInteger(cache_, missionKey_, key_)
endfunction

function GetStoredBooleanBJ takes string key, string missionKey, gamecache cache returns boolean
	return GetStoredBoolean(cache_, missionKey_, key_)
endfunction

function GetStoredStringBJ takes string key, string missionKey, gamecache cache returns string
	local string s
	set s_ = GetStoredString(cache_, missionKey_, key_)
	if (s_ == null) then
		return ""
	else
		return s_
	endif
endfunction

function LoadRealBJ takes integer key, integer missionKey, hashtable table returns real
	return LoadReal(table_, missionKey_, key_)
endfunction

function LoadIntegerBJ takes integer key, integer missionKey, hashtable table returns integer
	return LoadInteger(table_, missionKey_, key_)
endfunction

function LoadBooleanBJ takes integer key, integer missionKey, hashtable table returns boolean
	return LoadBoolean(table_, missionKey_, key_)
endfunction

function LoadStringBJ takes integer key, integer missionKey, hashtable table returns string
	local string s
	set s_ = LoadStr(table_, missionKey_, key_)
	if (s_ == null) then
		return ""
	else
		return s_
	endif
endfunction

function LoadPlayerHandleBJ takes integer key, integer missionKey, hashtable table returns player
	return LoadPlayerHandle(table_, missionKey_, key_)
endfunction

function LoadWidgetHandleBJ takes integer key, integer missionKey, hashtable table returns widget
	return LoadWidgetHandle(table_, missionKey_, key_)
endfunction

function LoadDestructableHandleBJ takes integer key, integer missionKey, hashtable table returns destructable
	return LoadDestructableHandle(table_, missionKey_, key_)
endfunction

function LoadItemHandleBJ takes integer key, integer missionKey, hashtable table returns item
	return LoadItemHandle(table_, missionKey_, key_)
endfunction

function LoadUnitHandleBJ takes integer key, integer missionKey, hashtable table returns unit
	return LoadUnitHandle(table_, missionKey_, key_)
endfunction

function LoadAbilityHandleBJ takes integer key, integer missionKey, hashtable table returns ability
	return LoadAbilityHandle(table_, missionKey_, key_)
endfunction

function LoadTimerHandleBJ takes integer key, integer missionKey, hashtable table returns timer
	return LoadTimerHandle(table_, missionKey_, key_)
endfunction

function LoadTriggerHandleBJ takes integer key, integer missionKey, hashtable table returns trigger
	return LoadTriggerHandle(table_, missionKey_, key_)
endfunction

function LoadTriggerConditionHandleBJ takes integer key, integer missionKey, hashtable table returns triggercondition
	return LoadTriggerConditionHandle(table_, missionKey_, key_)
endfunction

function LoadTriggerActionHandleBJ takes integer key, integer missionKey, hashtable table returns triggeraction
	return LoadTriggerActionHandle(table_, missionKey_, key_)
endfunction

function LoadTriggerEventHandleBJ takes integer key, integer missionKey, hashtable table returns event
	return LoadTriggerEventHandle(table_, missionKey_, key_)
endfunction

function LoadForceHandleBJ takes integer key, integer missionKey, hashtable table returns force
	return LoadForceHandle(table_, missionKey_, key_)
endfunction

function LoadGroupHandleBJ takes integer key, integer missionKey, hashtable table returns group
	return LoadGroupHandle(table_, missionKey_, key_)
endfunction

function LoadLocationHandleBJ takes integer key, integer missionKey, hashtable table returns location
	return LoadLocationHandle(table_, missionKey_, key_)
endfunction

function LoadRectHandleBJ takes integer key, integer missionKey, hashtable table returns rect
	return LoadRectHandle(table_, missionKey_, key_)
endfunction

function LoadBooleanExprHandleBJ takes integer key, integer missionKey, hashtable table returns boolexpr
	return LoadBooleanExprHandle(table_, missionKey_, key_)
endfunction

function LoadSoundHandleBJ takes integer key, integer missionKey, hashtable table returns sound
	return LoadSoundHandle(table_, missionKey_, key_)
endfunction

function LoadEffectHandleBJ takes integer key, integer missionKey, hashtable table returns effect
	return LoadEffectHandle(table_, missionKey_, key_)
endfunction

function LoadUnitPoolHandleBJ takes integer key, integer missionKey, hashtable table returns unitpool
	return LoadUnitPoolHandle(table_, missionKey_, key_)
endfunction

function LoadItemPoolHandleBJ takes integer key, integer missionKey, hashtable table returns itempool
	return LoadItemPoolHandle(table_, missionKey_, key_)
endfunction

function LoadQuestHandleBJ takes integer key, integer missionKey, hashtable table returns quest
	return LoadQuestHandle(table_, missionKey_, key_)
endfunction

function LoadQuestItemHandleBJ takes integer key, integer missionKey, hashtable table returns questitem
	return LoadQuestItemHandle(table_, missionKey_, key_)
endfunction

function LoadDefeatConditionHandleBJ takes integer key, integer missionKey, hashtable table returns defeatcondition
	return LoadDefeatConditionHandle(table_, missionKey_, key_)
endfunction

function LoadTimerDialogHandleBJ takes integer key, integer missionKey, hashtable table returns timerdialog
	return LoadTimerDialogHandle(table_, missionKey_, key_)
endfunction

function LoadLeaderboardHandleBJ takes integer key, integer missionKey, hashtable table returns leaderboard
	return LoadLeaderboardHandle(table_, missionKey_, key_)
endfunction

function LoadMultiboardHandleBJ takes integer key, integer missionKey, hashtable table returns multiboard
	return LoadMultiboardHandle(table_, missionKey_, key_)
endfunction

function LoadMultiboardItemHandleBJ takes integer key, integer missionKey, hashtable table returns multiboarditem
	return LoadMultiboardItemHandle(table_, missionKey_, key_)
endfunction

function LoadTrackableHandleBJ takes integer key, integer missionKey, hashtable table returns trackable
	return LoadTrackableHandle(table_, missionKey_, key_)
endfunction

function LoadDialogHandleBJ takes integer key, integer missionKey, hashtable table returns dialog
	return LoadDialogHandle(table_, missionKey_, key_)
endfunction

function LoadButtonHandleBJ takes integer key, integer missionKey, hashtable table returns button
	return LoadButtonHandle(table_, missionKey_, key_)
endfunction

function LoadTextTagHandleBJ takes integer key, integer missionKey, hashtable table returns texttag
	return LoadTextTagHandle(table_, missionKey_, key_)
endfunction

function LoadLightningHandleBJ takes integer key, integer missionKey, hashtable table returns lightning
	return LoadLightningHandle(table_, missionKey_, key_)
endfunction

function LoadImageHandleBJ takes integer key, integer missionKey, hashtable table returns image
	return LoadImageHandle(table_, missionKey_, key_)
endfunction

function LoadUbersplatHandleBJ takes integer key, integer missionKey, hashtable table returns ubersplat
	return LoadUbersplatHandle(table_, missionKey_, key_)
endfunction

function LoadRegionHandleBJ takes integer key, integer missionKey, hashtable table returns region
	return LoadRegionHandle(table_, missionKey_, key_)
endfunction

function LoadFogStateHandleBJ takes integer key, integer missionKey, hashtable table returns fogstate
	return LoadFogStateHandle(table_, missionKey_, key_)
endfunction

function LoadFogModifierHandleBJ takes integer key, integer missionKey, hashtable table returns fogmodifier
	return LoadFogModifierHandle(table_, missionKey_, key_)
endfunction

function LoadHashtableHandleBJ takes integer key, integer missionKey, hashtable table returns hashtable
	return LoadHashtableHandle(table_, missionKey_, key_)
endfunction

function RestoreUnitLocFacingAngleBJ takes string key, string missionKey, gamecache cache, player forWhichPlayer, location loc, real facing returns unit
	set bj_lastLoadedUnit_ = RestoreUnit(cache_, missionKey_, key_, forWhichPlayer_, GetLocationX(loc_), GetLocationY(loc_), facing_)
	return bj_lastLoadedUnit_
endfunction

function RestoreUnitLocFacingPointBJ takes string key, string missionKey, gamecache cache, player forWhichPlayer, location loc, location lookAt returns unit
	return RestoreUnitLocFacingAngleBJ(key_, missionKey_, cache_, forWhichPlayer_, loc_, AngleBetweenPoints(loc_, lookAt_))
endfunction

function GetLastRestoredUnitBJ takes nothing returns unit
	return bj_lastLoadedUnit_
endfunction

function FlushGameCacheBJ takes gamecache cache returns nothing
	call FlushGameCache(cache_)
endfunction

function FlushStoredMissionBJ takes string missionKey, gamecache cache returns nothing
	call FlushStoredMission(cache_, missionKey_)
endfunction

function FlushParentHashtableBJ takes hashtable table returns nothing
	call FlushParentHashtable(table_)
endfunction

function FlushChildHashtableBJ takes integer missionKey, hashtable table returns nothing
	call FlushChildHashtable(table_, missionKey_)
endfunction

function HaveStoredValue takes string key, integer valueType, string missionKey, gamecache cache returns boolean
	if (valueType_ == bj_GAMECACHE_BOOLEAN_) then
		return HaveStoredBoolean(cache_, missionKey_, key_)
	elseif (valueType_ == bj_GAMECACHE_BOOLEAN_) then
		return HaveStoredInteger(cache_, missionKey_, key_)
	elseif (valueType_ == bj_GAMECACHE_BOOLEAN_) then
		return HaveStoredReal(cache_, missionKey_, key_)
	elseif (valueType_ == bj_GAMECACHE_BOOLEAN_) then
		return HaveStoredUnit(cache_, missionKey_, key_)
	elseif (valueType_ == bj_GAMECACHE_BOOLEAN_) then
		return HaveStoredString(cache_, missionKey_, key_)
	else
		return false
	endif
endfunction

function HaveSavedValue takes integer key, integer valueType, integer missionKey, hashtable table returns boolean
	if (valueType_ == bj_HASHTABLE_BOOLEAN_) then
		return HaveSavedBoolean(table_, missionKey_, key_)
	elseif (valueType_ == bj_HASHTABLE_BOOLEAN_) then
		return HaveSavedInteger(table_, missionKey_, key_)
	elseif (valueType_ == bj_HASHTABLE_BOOLEAN_) then
		return HaveSavedReal(table_, missionKey_, key_)
	elseif (valueType_ == bj_HASHTABLE_BOOLEAN_) then
		return HaveSavedString(table_, missionKey_, key_)
	elseif (valueType_ == bj_HASHTABLE_BOOLEAN_) then
		return HaveSavedHandle(table_, missionKey_, key_)
	else
		return false
	endif
endfunction

function ShowCustomCampaignButton takes boolean show, integer whichButton returns nothing
	call SetCustomCampaignButtonVisible(whichButton_ - 1, show_)
endfunction

function IsCustomCampaignButtonVisibile takes integer whichButton returns boolean
	return GetCustomCampaignButtonVisible(whichButton_ - 1)
endfunction

function LoadGameBJ takes string loadFileName, boolean doScoreScreen returns nothing
	call LoadGame(loadFileName_, doScoreScreen_)
endfunction

function SaveAndChangeLevelBJ takes string saveFileName, string newLevel, boolean doScoreScreen returns nothing
	call SaveGame(saveFileName_)
	call ChangeLevel(newLevel_, doScoreScreen_)
endfunction

function SaveAndLoadGameBJ takes string saveFileName, string loadFileName, boolean doScoreScreen returns nothing
	call SaveGame(saveFileName_)
	call LoadGame(loadFileName_, doScoreScreen_)
endfunction

function RenameSaveDirectoryBJ takes string sourceDirName, string destDirName returns boolean
	return RenameSaveDirectory(sourceDirName_, destDirName_)
endfunction

function RemoveSaveDirectoryBJ takes string sourceDirName returns boolean
	return RemoveSaveDirectory(sourceDirName_)
endfunction

function CopySaveGameBJ takes string sourceSaveName, string destSaveName returns boolean
	return CopySaveGame(sourceSaveName_, destSaveName_)
endfunction

function GetPlayerStartLocationX takes player whichPlayer returns real
	return GetStartLocationX(GetPlayerStartLocation(whichPlayer_))
endfunction

function GetPlayerStartLocationY takes player whichPlayer returns real
	return GetStartLocationY(GetPlayerStartLocation(whichPlayer_))
endfunction

function GetPlayerStartLocationLoc takes player whichPlayer returns location
	return GetStartLocationLoc(GetPlayerStartLocation(whichPlayer_))
endfunction

function GetRectCenter takes rect whichRect returns location
	return Location(GetRectCenterX(whichRect_), GetRectCenterY(whichRect_))
endfunction

function IsPlayerSlotState takes player whichPlayer, playerslotstate whichState returns boolean
	return GetPlayerSlotState(whichPlayer_) == whichState_
endfunction

function GetFadeFromSeconds takes real seconds returns integer
	if (seconds_ != 0) then
		return 128 / R2I(seconds_)
	endif
	return 10000
endfunction

function GetFadeFromSecondsAsReal takes real seconds returns real
	if (seconds_ != 0) then
		return 128.00 / seconds_
	endif
	return 10000.00
endfunction

function AdjustPlayerStateSimpleBJ takes player whichPlayer, playerstate whichPlayerState, integer delta returns nothing
	call SetPlayerState(whichPlayer_, whichPlayerState_, GetPlayerState(whichPlayer_, whichPlayerState_) + delta_)
endfunction

function AdjustPlayerStateBJ takes integer delta, player whichPlayer, playerstate whichPlayerState returns nothing
	if (delta_ > 0) then
		if (whichPlayerState_ == PLAYER_STATE_RESOURCE_GOLD_) then
			call AdjustPlayerStateSimpleBJ(whichPlayer_, PLAYER_STATE_GOLD_GATHERED_, delta_)
		elseif (whichPlayerState_ == PLAYER_STATE_RESOURCE_GOLD_) then
			call AdjustPlayerStateSimpleBJ(whichPlayer_, PLAYER_STATE_LUMBER_GATHERED_, delta_)
		endif
	endif
	call AdjustPlayerStateSimpleBJ(whichPlayer_, whichPlayerState_, delta_)
endfunction

function SetPlayerStateBJ takes player whichPlayer, playerstate whichPlayerState, integer value returns nothing
	local integer oldValue = GetPlayerState(whichPlayer_, whichPlayerState_)
	call AdjustPlayerStateBJ(value_ - oldValue_, whichPlayer_, whichPlayerState_)
endfunction

function SetPlayerFlagBJ takes playerstate whichPlayerFlag, boolean flag, player whichPlayer returns nothing
	call SetPlayerState(whichPlayer_, whichPlayerFlag_, IntegerTertiaryOp(flag_, 1, 0))
endfunction

function SetPlayerTaxRateBJ takes integer rate, playerstate whichResource, player sourcePlayer, player otherPlayer returns nothing
	call SetPlayerTaxRate(sourcePlayer_, otherPlayer_, whichResource_, rate_)
endfunction

function GetPlayerTaxRateBJ takes playerstate whichResource, player sourcePlayer, player otherPlayer returns integer
	return GetPlayerTaxRate(sourcePlayer_, otherPlayer_, whichResource_)
endfunction

function IsPlayerFlagSetBJ takes playerstate whichPlayerFlag, player whichPlayer returns boolean
	return GetPlayerState(whichPlayer_, whichPlayerFlag_) == 1
endfunction

function AddResourceAmountBJ takes integer delta, unit whichUnit returns nothing
	call AddResourceAmount(whichUnit_, delta_)
endfunction

function GetConvertedPlayerId takes player whichPlayer returns integer
	return GetPlayerId(whichPlayer_) + 1
endfunction

function ConvertedPlayer takes integer convertedPlayerId returns player
	return Player(convertedPlayerId_ - 1)
endfunction

function GetRectWidthBJ takes rect r returns real
	return GetRectMaxX(r_) - GetRectMinX(r_)
endfunction

function GetRectHeightBJ takes rect r returns real
	return GetRectMaxY(r_) - GetRectMinY(r_)
endfunction

function BlightGoldMineForPlayerBJ takes unit goldMine, player whichPlayer returns unit
	local real mineX
	local real mineY
	local integer mineGold
	local unit newMine
	if GetUnitTypeId(goldMine_) != 'ngol' then
		return null
	endif
	set mineX_ = GetUnitX(goldMine_)
	set mineY_ = GetUnitY(goldMine_)
	set mineGold_ = GetResourceAmount(goldMine_)
	call RemoveUnit(goldMine_)
	set newMine_ = CreateBlightedGoldmine(whichPlayer_, mineX_, mineY_, bj_UNIT_FACING_)
	call SetResourceAmount(newMine_, mineGold_)
	return newMine_
endfunction

function BlightGoldMineForPlayer takes unit goldMine, player whichPlayer returns unit
	set bj_lastHauntedGoldMine_ = BlightGoldMineForPlayerBJ(goldMine_, whichPlayer_)
	return bj_lastHauntedGoldMine_
endfunction

function GetLastHauntedGoldMine takes nothing returns unit
	return bj_lastHauntedGoldMine_
endfunction

function IsPointBlightedBJ takes location where returns boolean
	return IsPointBlighted(GetLocationX(where_), GetLocationY(where_))
endfunction

function SetPlayerColorBJEnum takes nothing returns nothing
	call SetUnitColor(GetEnumUnit(), bj_setPlayerTargetColor_)
endfunction

function SetPlayerColorBJ takes player whichPlayer, playercolor color, boolean changeExisting returns nothing
	local group g
	call SetPlayerColor(whichPlayer_, color_)
	if changeExisting_ then
		set bj_setPlayerTargetColor_ = color_
		set g_ = CreateGroup()
		call GroupEnumUnitsOfPlayer(g_, whichPlayer_, null)
		call ForGroup(g_, function SetPlayerColorBJEnum)
		call DestroyGroup(g_)
	endif
endfunction

function SetPlayerUnitAvailableBJ takes integer unitId, boolean allowed, player whichPlayer returns nothing
	if allowed_ then
		call SetPlayerTechMaxAllowed(whichPlayer_, unitId_, -1)
	else
		call SetPlayerTechMaxAllowed(whichPlayer_, unitId_, 0)
	endif
endfunction

function LockGameSpeedBJ takes nothing returns nothing
	call SetMapFlag(MAP_LOCK_SPEED_, true)
endfunction

function UnlockGameSpeedBJ takes nothing returns nothing
	call SetMapFlag(MAP_LOCK_SPEED_, false)
endfunction

function IssueTargetOrderBJ takes unit whichUnit, string order, widget targetWidget returns boolean
	return IssueTargetOrder(whichUnit_, order_, targetWidget_)
endfunction

function IssuePointOrderLocBJ takes unit whichUnit, string order, location whichLocation returns boolean
	return IssuePointOrderLoc(whichUnit_, order_, whichLocation_)
endfunction

function IssueTargetDestructableOrder takes unit whichUnit, string order, widget targetWidget returns boolean
	return IssueTargetOrder(whichUnit_, order_, targetWidget_)
endfunction

function IssueTargetItemOrder takes unit whichUnit, string order, widget targetWidget returns boolean
	return IssueTargetOrder(whichUnit_, order_, targetWidget_)
endfunction

function IssueImmediateOrderBJ takes unit whichUnit, string order returns boolean
	return IssueImmediateOrder(whichUnit_, order_)
endfunction

function GroupTargetOrderBJ takes group whichGroup, string order, widget targetWidget returns boolean
	return GroupTargetOrder(whichGroup_, order_, targetWidget_)
endfunction

function GroupPointOrderLocBJ takes group whichGroup, string order, location whichLocation returns boolean
	return GroupPointOrderLoc(whichGroup_, order_, whichLocation_)
endfunction

function GroupImmediateOrderBJ takes group whichGroup, string order returns boolean
	return GroupImmediateOrder(whichGroup_, order_)
endfunction

function GroupTargetDestructableOrder takes group whichGroup, string order, widget targetWidget returns boolean
	return GroupTargetOrder(whichGroup_, order_, targetWidget_)
endfunction

function GroupTargetItemOrder takes group whichGroup, string order, widget targetWidget returns boolean
	return GroupTargetOrder(whichGroup_, order_, targetWidget_)
endfunction

function GetDyingDestructable takes nothing returns destructable
	return GetTriggerDestructable()
endfunction

function SetUnitRallyPoint takes unit whichUnit, location targPos returns nothing
	call IssuePointOrderLocBJ(whichUnit_, "setrally", targPos_)
endfunction

function SetUnitRallyUnit takes unit whichUnit, unit targUnit returns nothing
	call IssueTargetOrder(whichUnit_, "setrally", targUnit_)
endfunction

function SetUnitRallyDestructable takes unit whichUnit, destructable targDest returns nothing
	call IssueTargetOrder(whichUnit_, "setrally", targDest_)
endfunction

function SaveDyingWidget takes nothing returns nothing
	set bj_lastDyingWidget_ = GetTriggerWidget()
endfunction

function SetBlightRectBJ takes boolean addBlight, player whichPlayer, rect r returns nothing
	call SetBlightRect(whichPlayer_, r_, addBlight_)
endfunction

function SetBlightRadiusLocBJ takes boolean addBlight, player whichPlayer, location loc, real radius returns nothing
	call SetBlightLoc(whichPlayer_, loc_, radius_, addBlight_)
endfunction

function GetAbilityName takes integer abilcode returns string
	return GetObjectName(abilcode_)
endfunction

function MeleeStartingVisibility takes nothing returns nothing
	call SetFloatGameState(GAME_STATE_TIME_OF_DAY_, bj_MELEE_STARTING_TOD_)
endfunction

function MeleeStartingResources takes nothing returns nothing
	local integer index
	local player indexPlayer
	local version v
	local integer startingGold
	local integer startingLumber
	set v_ = VersionGet()
	if (v_ == VERSION_REIGN_OF_CHAOS_) then
		set startingGold_ = bj_MELEE_STARTING_GOLD_V0_
		set startingLumber_ = bj_MELEE_STARTING_LUMBER_V0_
	else
		set startingGold_ = bj_MELEE_STARTING_GOLD_V1_
		set startingLumber_ = bj_MELEE_STARTING_LUMBER_V1_
	endif
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerSlotState(indexPlayer_) == PLAYER_SLOT_STATE_PLAYING_) then
			call SetPlayerState(indexPlayer_, PLAYER_STATE_RESOURCE_GOLD_, startingGold_)
			call SetPlayerState(indexPlayer_, PLAYER_STATE_RESOURCE_LUMBER_, startingLumber_)
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function ReducePlayerTechMaxAllowed takes player whichPlayer, integer techId, integer limit returns nothing
	local integer oldMax = GetPlayerTechMaxAllowed(whichPlayer_, techId_)
	if (oldMax_ < 0 or oldMax_ > limit_) then
		call SetPlayerTechMaxAllowed(whichPlayer_, techId_, limit_)
	endif
endfunction

function MeleeStartingHeroLimit takes nothing returns nothing
	local integer index
	set index_ = 0
	loop
		call SetPlayerMaxHeroesAllowed(bj_MELEE_HERO_LIMIT_, Player(index_))
		call ReducePlayerTechMaxAllowed(Player(index_), 'Hamg', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Hmkg', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Hpal', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Hblm', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Obla', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ofar', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Otch', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Oshd', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Edem', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ekee', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Emoo', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ewar', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Udea', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Udre', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ulic', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ucrl', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Npbm', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nbrn', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nngs', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nplh', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nbst', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nalc', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Ntin', bj_MELEE_HERO_TYPE_LIMIT_)
		call ReducePlayerTechMaxAllowed(Player(index_), 'Nfir', bj_MELEE_HERO_TYPE_LIMIT_)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeTrainedUnitIsHeroBJFilter takes nothing returns boolean
	return IsUnitType(GetFilterUnit(), UNIT_TYPE_HERO_)
endfunction

function MeleeGrantItemsToHero takes unit whichUnit returns nothing
	local integer owner = GetPlayerId(GetOwningPlayer(whichUnit_))
	if (bj_meleeTwinkedHeroes_[owner_] < bj_MELEE_MAX_TWINKED_HEROES_) then
		call UnitAddItemById(whichUnit_, 'stwp')
		set bj_meleeTwinkedHeroes_[owner_] = bj_meleeTwinkedHeroes_[owner_] + 1
	endif
endfunction

function MeleeGrantItemsToTrainedHero takes nothing returns nothing
	call MeleeGrantItemsToHero(GetTrainedUnit())
endfunction

function MeleeGrantItemsToHiredHero takes nothing returns nothing
	call MeleeGrantItemsToHero(GetSoldUnit())
endfunction

function MeleeGrantHeroItems takes nothing returns nothing
	local integer index
	local trigger trig
	set index_ = 0
	loop
		set bj_meleeTwinkedHeroes_[index_] = 0
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYER_SLOTS_
	endloop
	set index_ = 0
	loop
		set trig_ = CreateTrigger()
		call TriggerRegisterPlayerUnitEvent(trig_, Player(index_), EVENT_PLAYER_UNIT_TRAIN_FINISH_, filterMeleeTrainedUnitIsHeroBJ_)
		call TriggerAddAction(trig_, function MeleeGrantItemsToTrainedHero)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	set trig_ = CreateTrigger()
	call TriggerRegisterPlayerUnitEvent(trig_, Player(PLAYER_NEUTRAL_PASSIVE_), EVENT_PLAYER_UNIT_SELL_, filterMeleeTrainedUnitIsHeroBJ_)
	call TriggerAddAction(trig_, function MeleeGrantItemsToHiredHero)
	set bj_meleeGrantHeroItems_ = true
endfunction

function MeleeClearExcessUnit takes nothing returns nothing
	local unit theUnit = GetEnumUnit()
	local integer owner = GetPlayerId(GetOwningPlayer(theUnit_))
	if (owner_ == PLAYER_NEUTRAL_AGGRESSIVE_) then
		call RemoveUnit(GetEnumUnit())
	elseif (owner_ == PLAYER_NEUTRAL_AGGRESSIVE_) then
		if not IsUnitType(theUnit_, UNIT_TYPE_STRUCTURE_) then
			call RemoveUnit(GetEnumUnit())
		endif
	endif
endfunction

function MeleeClearNearbyUnits takes real x, real y, real range returns nothing
	local group nearbyUnits
	set nearbyUnits_ = CreateGroup()
	call GroupEnumUnitsInRange(nearbyUnits_, x_, y_, range_, null)
	call ForGroup(nearbyUnits_, function MeleeClearExcessUnit)
	call DestroyGroup(nearbyUnits_)
endfunction

function MeleeClearExcessUnits takes nothing returns nothing
	local integer index
	local real locX
	local real locY
	local player indexPlayer
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerSlotState(indexPlayer_) == PLAYER_SLOT_STATE_PLAYING_) then
			set locX_ = GetStartLocationX(GetPlayerStartLocation(indexPlayer_))
			set locY_ = GetStartLocationY(GetPlayerStartLocation(indexPlayer_))
			call MeleeClearNearbyUnits(locX_, locY_, bj_MELEE_CLEAR_UNITS_RADIUS_)
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeEnumFindNearestMine takes nothing returns nothing
	local unit enumUnit = GetEnumUnit()
	local real dist
	local location unitLoc
	if (GetUnitTypeId(enumUnit_) == 'ngol') then
		set unitLoc_ = GetUnitLoc(enumUnit_)
		set dist_ = DistanceBetweenPoints(unitLoc_, bj_meleeNearestMineToLoc_)
		call RemoveLocation(unitLoc_)
		if (bj_meleeNearestMineDist_ < 0) or (dist_ < bj_meleeNearestMineDist_) then
			set bj_meleeNearestMine_ = enumUnit_
			set bj_meleeNearestMineDist_ = dist_
		endif
	endif
endfunction

function MeleeFindNearestMine takes location src, real range returns unit
	local group nearbyMines
	set bj_meleeNearestMine_ = null
	set bj_meleeNearestMineDist_ = -1
	set bj_meleeNearestMineToLoc_ = src_
	set nearbyMines_ = CreateGroup()
	call GroupEnumUnitsInRangeOfLoc(nearbyMines_, src_, range_, null)
	call ForGroup(nearbyMines_, function MeleeEnumFindNearestMine)
	call DestroyGroup(nearbyMines_)
	return bj_meleeNearestMine_
endfunction

function MeleeRandomHeroLoc takes player p, integer id1, integer id2, integer id3, integer id4, location loc returns unit
	local unit hero = null
	local integer roll
	local integer pick
	local version v
	set v_ = VersionGet()
	if (v_ == VERSION_REIGN_OF_CHAOS_) then
		set roll_ = GetRandomInt(1, 3)
	else
		set roll_ = GetRandomInt(1, 4)
	endif
	if roll_ == 1 then
		set pick_ = id1_
	elseif roll_ == 1 then
		set pick_ = id2_
	elseif roll_ == 1 then
		set pick_ = id3_
	elseif roll_ == 1 then
		set pick_ = id4_
	else
		set pick_ = id1_
	endif
	set hero_ = CreateUnitAtLoc(p_, pick_, loc_, bj_UNIT_FACING_)
	if bj_meleeGrantHeroItems_ then
		call MeleeGrantItemsToHero(hero_)
	endif
	return hero_
endfunction

function MeleeGetProjectedLoc takes location src, location targ, real distance, real deltaAngle returns location
	local real srcX = GetLocationX(src_)
	local real srcY = GetLocationY(src_)
	local real direction = Atan2(GetLocationY(targ_) - srcY_, GetLocationX(targ_) - srcX_) + deltaAngle_
	return Location(srcX_ + distance_ * Cos(direction_), srcY_ + distance_ * Sin(direction_))
endfunction

function MeleeGetNearestValueWithin takes real val, real minVal, real maxVal returns real
	if (val_ < minVal_) then
		return minVal_
	elseif (val_ < minVal_) then
		return maxVal_
	else
		return val_
	endif
endfunction

function MeleeGetLocWithinRect takes location src, rect r returns location
	local real withinX = MeleeGetNearestValueWithin(GetLocationX(src_), GetRectMinX(r_), GetRectMaxX(r_))
	local real withinY = MeleeGetNearestValueWithin(GetLocationY(src_), GetRectMinY(r_), GetRectMaxY(r_))
	return Location(withinX_, withinY_)
endfunction

function MeleeStartingUnitsHuman takes player whichPlayer, location startLoc, boolean doHeroes, boolean doCamera, boolean doPreload returns nothing
	local boolean useRandomHero = IsMapFlagSet(MAP_RANDOM_HERO_)
	local real unitSpacing = 64.00
	local unit nearestMine
	local location nearMineLoc
	local location heroLoc
	local real peonX
	local real peonY
	local unit townHall = null
	if (doPreload_) then
		call Preloader("scripts\\HumanMelee.pld")
	endif
	set nearestMine_ = MeleeFindNearestMine(startLoc_, bj_MELEE_MINE_SEARCH_RADIUS_)
	if (nearestMine_ != null) then
		set townHall_ = CreateUnitAtLoc(whichPlayer_, 'htow', startLoc_, bj_UNIT_FACING_)
		set nearMineLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 320, 0)
		set peonX_ = GetLocationX(nearMineLoc_)
		set peonY_ = GetLocationY(nearMineLoc_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 0.00 * unitSpacing_, peonY_ + 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 0.60 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ - 0.60 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 384, 45)
	else
		set townHall_ = CreateUnitAtLoc(whichPlayer_, 'htow', startLoc_, bj_UNIT_FACING_)
		set peonX_ = GetLocationX(startLoc_)
		set peonY_ = GetLocationY(startLoc_) - 224.00
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ + 0.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'hpea', peonX_ - 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = Location(peonX_, peonY_ - 2.00 * unitSpacing_)
	endif
	if (townHall_ != null) then
		call UnitAddAbilityBJ('Amic', townHall_)
		call UnitMakeAbilityPermanentBJ(true, 'Amic', townHall_)
	endif
	if (doHeroes_) then
		if useRandomHero_ then
			call MeleeRandomHeroLoc(whichPlayer_, 'Hamg', 'Hmkg', 'Hpal', 'Hblm', heroLoc_)
		else
			call SetPlayerState(whichPlayer_, PLAYER_STATE_RESOURCE_HERO_TOKENS_, bj_MELEE_STARTING_HERO_TOKENS_)
		endif
	endif
	if (doCamera_) then
		call SetCameraPositionForPlayer(whichPlayer_, peonX_, peonY_)
		call SetCameraQuickPositionForPlayer(whichPlayer_, peonX_, peonY_)
	endif
endfunction

function MeleeStartingUnitsOrc takes player whichPlayer, location startLoc, boolean doHeroes, boolean doCamera, boolean doPreload returns nothing
	local boolean useRandomHero = IsMapFlagSet(MAP_RANDOM_HERO_)
	local real unitSpacing = 64.00
	local unit nearestMine
	local location nearMineLoc
	local location heroLoc
	local real peonX
	local real peonY
	if (doPreload_) then
		call Preloader("scripts\\OrcMelee.pld")
	endif
	set nearestMine_ = MeleeFindNearestMine(startLoc_, bj_MELEE_MINE_SEARCH_RADIUS_)
	if (nearestMine_ != null) then
		call CreateUnitAtLoc(whichPlayer_, 'ogre', startLoc_, bj_UNIT_FACING_)
		set nearMineLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 320, 0)
		set peonX_ = GetLocationX(nearMineLoc_)
		set peonY_ = GetLocationY(nearMineLoc_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 0.00 * unitSpacing_, peonY_ + 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 0.60 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ - 0.60 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 384, 45)
	else
		call CreateUnitAtLoc(whichPlayer_, 'ogre', startLoc_, bj_UNIT_FACING_)
		set peonX_ = GetLocationX(startLoc_)
		set peonY_ = GetLocationY(startLoc_) - 224.00
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ + 0.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'opeo', peonX_ - 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = Location(peonX_, peonY_ - 2.00 * unitSpacing_)
	endif
	if (doHeroes_) then
		if useRandomHero_ then
			call MeleeRandomHeroLoc(whichPlayer_, 'Obla', 'Ofar', 'Otch', 'Oshd', heroLoc_)
		else
			call SetPlayerState(whichPlayer_, PLAYER_STATE_RESOURCE_HERO_TOKENS_, bj_MELEE_STARTING_HERO_TOKENS_)
		endif
	endif
	if (doCamera_) then
		call SetCameraPositionForPlayer(whichPlayer_, peonX_, peonY_)
		call SetCameraQuickPositionForPlayer(whichPlayer_, peonX_, peonY_)
	endif
endfunction

function MeleeStartingUnitsUndead takes player whichPlayer, location startLoc, boolean doHeroes, boolean doCamera, boolean doPreload returns nothing
	local boolean useRandomHero = IsMapFlagSet(MAP_RANDOM_HERO_)
	local real unitSpacing = 64.00
	local unit nearestMine
	local location nearMineLoc
	local location nearTownLoc
	local location heroLoc
	local real peonX
	local real peonY
	local real ghoulX
	local real ghoulY
	if (doPreload_) then
		call Preloader("scripts\\UndeadMelee.pld")
	endif
	set nearestMine_ = MeleeFindNearestMine(startLoc_, bj_MELEE_MINE_SEARCH_RADIUS_)
	if (nearestMine_ != null) then
		call CreateUnitAtLoc(whichPlayer_, 'unpl', startLoc_, bj_UNIT_FACING_)
		set nearestMine_ = BlightGoldMineForPlayerBJ(nearestMine_, whichPlayer_)
		set nearTownLoc_ = MeleeGetProjectedLoc(startLoc_, GetUnitLoc(nearestMine_), 288, 0)
		set ghoulX_ = GetLocationX(nearTownLoc_)
		set ghoulY_ = GetLocationY(nearTownLoc_)
		set bj_ghoul_[GetPlayerId(whichPlayer_)] = CreateUnit(whichPlayer_, 'ugho', ghoulX_ + 0.00 * unitSpacing_, ghoulY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		set nearMineLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 320, 0)
		set peonX_ = GetLocationX(nearMineLoc_)
		set peonY_ = GetLocationY(nearMineLoc_)
		call CreateUnit(whichPlayer_, 'uaco', peonX_ + 0.00 * unitSpacing_, peonY_ + 0.50 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'uaco', peonX_ + 0.65 * unitSpacing_, peonY_ - 0.50 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'uaco', peonX_ - 0.65 * unitSpacing_, peonY_ - 0.50 * unitSpacing_, bj_UNIT_FACING_)
		call SetBlightLoc(whichPlayer_, nearMineLoc_, 768, true)
		set heroLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 384, 45)
	else
		call CreateUnitAtLoc(whichPlayer_, 'unpl', startLoc_, bj_UNIT_FACING_)
		set peonX_ = GetLocationX(startLoc_)
		set peonY_ = GetLocationY(startLoc_) - 224.00
		call CreateUnit(whichPlayer_, 'uaco', peonX_ - 1.50 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'uaco', peonX_ - 0.50 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'uaco', peonX_ + 0.50 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ugho', peonX_ + 1.50 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call SetBlightLoc(whichPlayer_, startLoc_, 768, true)
		set heroLoc_ = Location(peonX_, peonY_ - 2.00 * unitSpacing_)
	endif
	if (doHeroes_) then
		if useRandomHero_ then
			call MeleeRandomHeroLoc(whichPlayer_, 'Udea', 'Udre', 'Ulic', 'Ucrl', heroLoc_)
		else
			call SetPlayerState(whichPlayer_, PLAYER_STATE_RESOURCE_HERO_TOKENS_, bj_MELEE_STARTING_HERO_TOKENS_)
		endif
	endif
	if (doCamera_) then
		call SetCameraPositionForPlayer(whichPlayer_, peonX_, peonY_)
		call SetCameraQuickPositionForPlayer(whichPlayer_, peonX_, peonY_)
	endif
endfunction

function MeleeStartingUnitsNightElf takes player whichPlayer, location startLoc, boolean doHeroes, boolean doCamera, boolean doPreload returns nothing
	local boolean useRandomHero = IsMapFlagSet(MAP_RANDOM_HERO_)
	local real unitSpacing = 64.00
	local real minTreeDist = 3.50 * bj_CELLWIDTH_
	local real minWispDist = 1.75 * bj_CELLWIDTH_
	local unit nearestMine
	local location nearMineLoc
	local location wispLoc
	local location heroLoc
	local real peonX
	local real peonY
	local unit tree
	if (doPreload_) then
		call Preloader("scripts\\NightElfMelee.pld")
	endif
	set nearestMine_ = MeleeFindNearestMine(startLoc_, bj_MELEE_MINE_SEARCH_RADIUS_)
	if (nearestMine_ != null) then
		set nearMineLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 650, 0)
		set nearMineLoc_ = MeleeGetLocWithinRect(nearMineLoc_, GetRectFromCircleBJ(GetUnitLoc(nearestMine_), minTreeDist_))
		set tree_ = CreateUnitAtLoc(whichPlayer_, 'etol', nearMineLoc_, bj_UNIT_FACING_)
		call IssueTargetOrder(tree_, "entangleinstant", nearestMine_)
		set wispLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 320, 0)
		set wispLoc_ = MeleeGetLocWithinRect(wispLoc_, GetRectFromCircleBJ(GetUnitLoc(nearestMine_), minWispDist_))
		set peonX_ = GetLocationX(wispLoc_)
		set peonY_ = GetLocationY(wispLoc_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 0.00 * unitSpacing_, peonY_ + 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.15 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 0.58 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ - 0.58 * unitSpacing_, peonY_ - 1.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = MeleeGetProjectedLoc(GetUnitLoc(nearestMine_), startLoc_, 384, 45)
	else
		call CreateUnitAtLoc(whichPlayer_, 'etol', startLoc_, bj_UNIT_FACING_)
		set peonX_ = GetLocationX(startLoc_)
		set peonY_ = GetLocationY(startLoc_) - 224.00
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ - 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ - 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 0.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 1.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		call CreateUnit(whichPlayer_, 'ewsp', peonX_ + 2.00 * unitSpacing_, peonY_ + 0.00 * unitSpacing_, bj_UNIT_FACING_)
		set heroLoc_ = Location(peonX_, peonY_ - 2.00 * unitSpacing_)
	endif
	if (doHeroes_) then
		if useRandomHero_ then
			call MeleeRandomHeroLoc(whichPlayer_, 'Edem', 'Ekee', 'Emoo', 'Ewar', heroLoc_)
		else
			call SetPlayerState(whichPlayer_, PLAYER_STATE_RESOURCE_HERO_TOKENS_, bj_MELEE_STARTING_HERO_TOKENS_)
		endif
	endif
	if (doCamera_) then
		call SetCameraPositionForPlayer(whichPlayer_, peonX_, peonY_)
		call SetCameraQuickPositionForPlayer(whichPlayer_, peonX_, peonY_)
	endif
endfunction

function MeleeStartingUnitsUnknownRace takes player whichPlayer, location startLoc, boolean doHeroes, boolean doCamera, boolean doPreload returns nothing
	local integer index
	if (doPreload_) then
	endif
	set index_ = 0
	loop
		call CreateUnit(whichPlayer_, 'nshe', GetLocationX(startLoc_) + GetRandomReal(-256, 256), GetLocationY(startLoc_) + GetRandomReal(-256, 256), GetRandomReal(0, 360))
		set index_ = index_ + 1
		exitwhen index_ == 12
	endloop
	if (doHeroes_) then
		call SetPlayerState(whichPlayer_, PLAYER_STATE_RESOURCE_HERO_TOKENS_, bj_MELEE_STARTING_HERO_TOKENS_)
	endif
	if (doCamera_) then
		call SetCameraPositionLocForPlayer(whichPlayer_, startLoc_)
		call SetCameraQuickPositionLocForPlayer(whichPlayer_, startLoc_)
	endif
endfunction

function MeleeStartingUnits takes nothing returns nothing
	local integer index
	local player indexPlayer
	local location indexStartLoc
	local race indexRace
	call Preloader("scripts\\SharedMelee.pld")
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerSlotState(indexPlayer_) == PLAYER_SLOT_STATE_PLAYING_) then
			set indexStartLoc_ = GetStartLocationLoc(GetPlayerStartLocation(indexPlayer_))
			set indexRace_ = GetPlayerRace(indexPlayer_)
			if (indexRace_ == RACE_HUMAN_) then
				call MeleeStartingUnitsHuman(indexPlayer_, indexStartLoc_, true, true, true)
			elseif (indexRace_ == RACE_HUMAN_) then
				call MeleeStartingUnitsOrc(indexPlayer_, indexStartLoc_, true, true, true)
			elseif (indexRace_ == RACE_HUMAN_) then
				call MeleeStartingUnitsUndead(indexPlayer_, indexStartLoc_, true, true, true)
			elseif (indexRace_ == RACE_HUMAN_) then
				call MeleeStartingUnitsNightElf(indexPlayer_, indexStartLoc_, true, true, true)
			else
				call MeleeStartingUnitsUnknownRace(indexPlayer_, indexStartLoc_, true, true, true)
			endif
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeStartingUnitsForPlayer takes race whichRace, player whichPlayer, location loc, boolean doHeroes returns nothing
	if (whichRace_ == RACE_HUMAN_) then
		call MeleeStartingUnitsHuman(whichPlayer_, loc_, doHeroes_, false, false)
	elseif (whichRace_ == RACE_HUMAN_) then
		call MeleeStartingUnitsOrc(whichPlayer_, loc_, doHeroes_, false, false)
	elseif (whichRace_ == RACE_HUMAN_) then
		call MeleeStartingUnitsUndead(whichPlayer_, loc_, doHeroes_, false, false)
	elseif (whichRace_ == RACE_HUMAN_) then
		call MeleeStartingUnitsNightElf(whichPlayer_, loc_, doHeroes_, false, false)
	else
	endif
endfunction

function PickMeleeAI takes player num, string s1, string s2, string s3 returns nothing
	local integer pick
	if GetAIDifficulty(num_) == AI_DIFFICULTY_NEWBIE_ then
		call StartMeleeAI(num_, s1_)
		return
	endif
	if s2_ == null then
		set pick_ = 1
	elseif s2_ == null then
		set pick_ = GetRandomInt(1, 2)
	else
		set pick_ = GetRandomInt(1, 3)
	endif
	if pick_ == 1 then
		call StartMeleeAI(num_, s1_)
	elseif pick_ == 1 then
		call StartMeleeAI(num_, s2_)
	else
		call StartMeleeAI(num_, s3_)
	endif
endfunction

function MeleeStartingAI takes nothing returns nothing
	local integer index
	local player indexPlayer
	local race indexRace
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerSlotState(indexPlayer_) == PLAYER_SLOT_STATE_PLAYING_) then
			set indexRace_ = GetPlayerRace(indexPlayer_)
			if (GetPlayerController(indexPlayer_) == MAP_CONTROL_COMPUTER_) then
				if (indexRace_ == RACE_HUMAN_) then
					call PickMeleeAI(indexPlayer_, "human.ai", null, null)
				elseif (indexRace_ == RACE_HUMAN_) then
					call PickMeleeAI(indexPlayer_, "orc.ai", null, null)
				elseif (indexRace_ == RACE_HUMAN_) then
					call PickMeleeAI(indexPlayer_, "undead.ai", null, null)
					call RecycleGuardPosition(bj_ghoul_[index_])
				elseif (indexRace_ == RACE_HUMAN_) then
					call PickMeleeAI(indexPlayer_, "elf.ai", null, null)
				else
				endif
				call ShareEverythingWithTeamAI(indexPlayer_)
			endif
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function LockGuardPosition takes unit targ returns nothing
	call SetUnitCreepGuard(targ_, true)
endfunction

function MeleePlayerIsOpponent takes integer playerIndex, integer opponentIndex returns boolean
	local player thePlayer = Player(playerIndex_)
	local player theOpponent = Player(opponentIndex_)
	if (playerIndex_ == opponentIndex_) then
		return false
	endif
	if (GetPlayerSlotState(theOpponent_) != PLAYER_SLOT_STATE_PLAYING_) then
		return false
	endif
	if (bj_meleeDefeated_[opponentIndex_]) then
		return false
	endif
	if GetPlayerAlliance(thePlayer_, theOpponent_, ALLIANCE_PASSIVE_) then
		if GetPlayerAlliance(theOpponent_, thePlayer_, ALLIANCE_PASSIVE_) then
			if (GetPlayerState(thePlayer_, PLAYER_STATE_ALLIED_VICTORY_) == 1) then
				if (GetPlayerState(theOpponent_, PLAYER_STATE_ALLIED_VICTORY_) == 1) then
					return false
				endif
			endif
		endif
	endif
	return true
endfunction

function MeleeGetAllyStructureCount takes player whichPlayer returns integer
	local integer playerIndex
	local integer buildingCount
	local player indexPlayer
	set buildingCount_ = 0
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (PlayersAreCoAllied(whichPlayer_, indexPlayer_)) then
			set buildingCount_ = buildingCount_ + GetPlayerStructureCount(indexPlayer_, true)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	return buildingCount_
endfunction

function MeleeGetAllyCount takes player whichPlayer returns integer
	local integer playerIndex
	local integer playerCount
	local player indexPlayer
	set playerCount_ = 0
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if PlayersAreCoAllied(whichPlayer_, indexPlayer_) and not bj_meleeDefeated_[playerIndex_] and (whichPlayer_ != indexPlayer_) then
			set playerCount_ = playerCount_ + 1
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	return playerCount_
endfunction

function MeleeGetAllyKeyStructureCount takes player whichPlayer returns integer
	local integer playerIndex
	local player indexPlayer
	local integer keyStructs
	set keyStructs_ = 0
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (PlayersAreCoAllied(whichPlayer_, indexPlayer_)) then
			set keyStructs_ = keyStructs_ + GetPlayerTypedUnitCount(indexPlayer_, "townhall", true, true)
			set keyStructs_ = keyStructs_ + GetPlayerTypedUnitCount(indexPlayer_, "greathall", true, true)
			set keyStructs_ = keyStructs_ + GetPlayerTypedUnitCount(indexPlayer_, "treeoflife", true, true)
			set keyStructs_ = keyStructs_ + GetPlayerTypedUnitCount(indexPlayer_, "necropolis", true, true)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	return keyStructs_
endfunction

function MeleeDoDrawEnum takes nothing returns nothing
	local player thePlayer = GetEnumPlayer()
	call CachePlayerHeroData(thePlayer_)
	call RemovePlayerPreserveUnitsBJ(thePlayer_, PLAYER_GAME_RESULT_TIE_, false)
endfunction

function MeleeDoVictoryEnum takes nothing returns nothing
	local player thePlayer = GetEnumPlayer()
	local integer playerIndex = GetPlayerId(thePlayer_)
	if (not bj_meleeVictoried_[playerIndex_]) then
		set bj_meleeVictoried_[playerIndex_] = true
		call CachePlayerHeroData(thePlayer_)
		call RemovePlayerPreserveUnitsBJ(thePlayer_, PLAYER_GAME_RESULT_VICTORY_, false)
	endif
endfunction

function MeleeDoDefeat takes player whichPlayer returns nothing
	set bj_meleeDefeated_[GetPlayerId(whichPlayer_)] = true
	call RemovePlayerPreserveUnitsBJ(whichPlayer_, PLAYER_GAME_RESULT_DEFEAT_, false)
endfunction

function MeleeDoDefeatEnum takes nothing returns nothing
	local player thePlayer = GetEnumPlayer()
	call CachePlayerHeroData(thePlayer_)
	call MakeUnitsPassiveForTeam(thePlayer_)
	call MeleeDoDefeat(thePlayer_)
endfunction

function MeleeDoLeave takes player whichPlayer returns nothing
	if (GetIntegerGameState(GAME_STATE_DISCONNECTED_) != 0) then
		call GameOverDialogBJ(whichPlayer_, true)
	else
		set bj_meleeDefeated_[GetPlayerId(whichPlayer_)] = true
		call RemovePlayerPreserveUnitsBJ(whichPlayer_, PLAYER_GAME_RESULT_DEFEAT_, true)
	endif
endfunction

function MeleeRemoveObservers takes nothing returns nothing
	local integer playerIndex
	local player indexPlayer
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (IsPlayerObserver(indexPlayer_)) then
			call RemovePlayerPreserveUnitsBJ(indexPlayer_, PLAYER_GAME_RESULT_NEUTRAL_, false)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeCheckForVictors takes nothing returns force
	local integer playerIndex
	local integer opponentIndex
	local force opponentlessPlayers = CreateForce()
	local boolean gameOver = false
	set playerIndex_ = 0
	loop
		if (not bj_meleeDefeated_[playerIndex_]) then
			set opponentIndex_ = 0
			loop
				if MeleePlayerIsOpponent(playerIndex_, opponentIndex_) then
					return CreateForce()
				endif
				set opponentIndex_ = opponentIndex_ + 1
				exitwhen opponentIndex_ == bj_MAX_PLAYERS_
			endloop
			call ForceAddPlayer(opponentlessPlayers_, Player(playerIndex_))
			set gameOver_ = true
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	set bj_meleeGameOver_ = gameOver_
	return opponentlessPlayers_
endfunction

function MeleeCheckForLosersAndVictors takes nothing returns nothing
	local integer playerIndex
	local player indexPlayer
	local force defeatedPlayers = CreateForce()
	local force victoriousPlayers
	local boolean gameOver = false
	if (bj_meleeGameOver_) then
		return
	endif
	if (GetIntegerGameState(GAME_STATE_DISCONNECTED_) != 0) then
		set bj_meleeGameOver_ = true
		return
	endif
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (not bj_meleeDefeated_[playerIndex_] and not bj_meleeVictoried_[playerIndex_]) then
			if (MeleeGetAllyStructureCount(indexPlayer_) <= 0) then
				call ForceAddPlayer(defeatedPlayers_, Player(playerIndex_))
				set bj_meleeDefeated_[playerIndex_] = true
			endif
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	set victoriousPlayers_ = MeleeCheckForVictors()
	call ForForce(defeatedPlayers_, function MeleeDoDefeatEnum)
	call ForForce(victoriousPlayers_, function MeleeDoVictoryEnum)
	if (bj_meleeGameOver_) then
		call MeleeRemoveObservers()
	endif
endfunction

function MeleeGetCrippledWarningMessage takes player whichPlayer returns string
	local race r = GetPlayerRace(whichPlayer_)
	if (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_WARNING_HUMAN")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_WARNING_ORC")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_WARNING_NIGHTELF")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_WARNING_UNDEAD")
	else
		return ""
	endif
endfunction

function MeleeGetCrippledTimerMessage takes player whichPlayer returns string
	local race r = GetPlayerRace(whichPlayer_)
	if (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_TIMER_HUMAN")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_TIMER_ORC")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_TIMER_NIGHTELF")
	elseif (r_ == RACE_HUMAN_) then
		return GetLocalizedString("CRIPPLE_TIMER_UNDEAD")
	else
		return ""
	endif
endfunction

function MeleeGetCrippledRevealedMessage takes player whichPlayer returns string
	return GetLocalizedString("CRIPPLE_REVEALING_PREFIX") + GetPlayerName(whichPlayer_) + GetLocalizedString("CRIPPLE_REVEALING_POSTFIX")
endfunction

function MeleeExposePlayer takes player whichPlayer, boolean expose returns nothing
	local integer playerIndex
	local player indexPlayer
	local force toExposeTo = CreateForce()
	call CripplePlayer(whichPlayer_, toExposeTo_, false)
	set bj_playerIsExposed_[GetPlayerId(whichPlayer_)] = expose_
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		if (not PlayersAreCoAllied(whichPlayer_, indexPlayer_)) then
			call ForceAddPlayer(toExposeTo_, indexPlayer_)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	call CripplePlayer(whichPlayer_, toExposeTo_, expose_)
	call DestroyForce(toExposeTo_)
endfunction

function MeleeExposeAllPlayers takes nothing returns nothing
	local integer playerIndex
	local player indexPlayer
	local integer playerIndex2
	local player indexPlayer2
	local force toExposeTo = CreateForce()
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		call ForceClear(toExposeTo_)
		call CripplePlayer(indexPlayer_, toExposeTo_, false)
		set playerIndex2_ = 0
		loop
			set indexPlayer2_ = Player(playerIndex2_)
			if playerIndex_ != playerIndex2_ then
				if (not PlayersAreCoAllied(indexPlayer_, indexPlayer2_)) then
					call ForceAddPlayer(toExposeTo_, indexPlayer2_)
				endif
			endif
			set playerIndex2_ = playerIndex2_ + 1
			exitwhen playerIndex2_ == bj_MAX_PLAYERS_
		endloop
		call CripplePlayer(indexPlayer_, toExposeTo_, true)
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	call DestroyForce(toExposeTo_)
endfunction

function MeleeCrippledPlayerTimeout takes nothing returns nothing
	local timer expiredTimer = GetExpiredTimer()
	local integer playerIndex
	local player exposedPlayer
	set playerIndex_ = 0
	loop
		if (bj_crippledTimer_[playerIndex_] == expiredTimer_) then
			exitwhen true
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
	if (playerIndex_ == bj_MAX_PLAYERS_) then
		return
	endif
	set exposedPlayer_ = Player(playerIndex_)
	if (GetLocalPlayer() == exposedPlayer_) then
		call TimerDialogDisplay(bj_crippledTimerWindows_[playerIndex_], false)
	endif
	call DisplayTimedTextToPlayer(GetLocalPlayer(), 0, 0, bj_MELEE_CRIPPLE_MSG_DURATION_, MeleeGetCrippledRevealedMessage(exposedPlayer_))
	call MeleeExposePlayer(exposedPlayer_, true)
endfunction

function MeleePlayerIsCrippled takes player whichPlayer returns boolean
	local integer allyStructures = MeleeGetAllyStructureCount(whichPlayer_)
	local integer allyKeyStructures = MeleeGetAllyKeyStructureCount(whichPlayer_)
	return (allyStructures_ > 0) and (allyKeyStructures_ <= 0)
endfunction

function MeleeCheckForCrippledPlayers takes nothing returns nothing
	local integer playerIndex
	local player indexPlayer
	local force crippledPlayers = CreateForce()
	local boolean isNowCrippled
	local race indexRace
	if bj_finishSoonAllExposed_ then
		return
	endif
	set playerIndex_ = 0
	loop
		set indexPlayer_ = Player(playerIndex_)
		set isNowCrippled_ = MeleePlayerIsCrippled(indexPlayer_)
		if (not bj_playerIsCrippled_[playerIndex_] and isNowCrippled_) then
			set bj_playerIsCrippled_[playerIndex_] = true
			call TimerStart(bj_crippledTimer_[playerIndex_], bj_MELEE_CRIPPLE_TIMEOUT_, false, function MeleeCrippledPlayerTimeout)
			if (GetLocalPlayer() == indexPlayer_) then
				call TimerDialogDisplay(bj_crippledTimerWindows_[playerIndex_], true)
				call DisplayTimedTextToPlayer(indexPlayer_, 0, 0, bj_MELEE_CRIPPLE_MSG_DURATION_, MeleeGetCrippledWarningMessage(indexPlayer_))
			endif
		elseif (not bj_playerIsCrippled_[playerIndex_] and isNowCrippled_) then
			set bj_playerIsCrippled_[playerIndex_] = false
			call PauseTimer(bj_crippledTimer_[playerIndex_])
			if (GetLocalPlayer() == indexPlayer_) then
				call TimerDialogDisplay(bj_crippledTimerWindows_[playerIndex_], false)
				if (MeleeGetAllyStructureCount(indexPlayer_) > 0) then
					if (bj_playerIsExposed_[playerIndex_]) then
						call DisplayTimedTextToPlayer(indexPlayer_, 0, 0, bj_MELEE_CRIPPLE_MSG_DURATION_, GetLocalizedString("CRIPPLE_UNREVEALED"))
					else
						call DisplayTimedTextToPlayer(indexPlayer_, 0, 0, bj_MELEE_CRIPPLE_MSG_DURATION_, GetLocalizedString("CRIPPLE_UNCRIPPLED"))
					endif
				endif
			endif
			call MeleeExposePlayer(indexPlayer_, false)
		endif
		set playerIndex_ = playerIndex_ + 1
		exitwhen playerIndex_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeCheckLostUnit takes unit lostUnit returns nothing
	local player lostUnitOwner = GetOwningPlayer(lostUnit_)
	if (GetPlayerStructureCount(lostUnitOwner_, true) <= 0) then
		call MeleeCheckForLosersAndVictors()
	endif
	call MeleeCheckForCrippledPlayers()
endfunction

function MeleeCheckAddedUnit takes unit addedUnit returns nothing
	local player addedUnitOwner = GetOwningPlayer(addedUnit_)
	if (bj_playerIsCrippled_[GetPlayerId(addedUnitOwner_)]) then
		call MeleeCheckForCrippledPlayers()
	endif
endfunction

function MeleeTriggerActionConstructCancel takes nothing returns nothing
	call MeleeCheckLostUnit(GetCancelledStructure())
endfunction

function MeleeTriggerActionUnitDeath takes nothing returns nothing
	if (IsUnitType(GetDyingUnit(), UNIT_TYPE_STRUCTURE_)) then
		call MeleeCheckLostUnit(GetDyingUnit())
	endif
endfunction

function MeleeTriggerActionUnitConstructionStart takes nothing returns nothing
	call MeleeCheckAddedUnit(GetConstructingStructure())
endfunction

function MeleeTriggerActionPlayerDefeated takes nothing returns nothing
	local player thePlayer = GetTriggerPlayer()
	call CachePlayerHeroData(thePlayer_)
	if (MeleeGetAllyCount(thePlayer_) > 0) then
		call ShareEverythingWithTeam(thePlayer_)
		if (not bj_meleeDefeated_[GetPlayerId(thePlayer_)]) then
			call MeleeDoDefeat(thePlayer_)
		endif
	else
		call MakeUnitsPassiveForTeam(thePlayer_)
		if (not bj_meleeDefeated_[GetPlayerId(thePlayer_)]) then
			call MeleeDoDefeat(thePlayer_)
		endif
	endif
	call MeleeCheckForLosersAndVictors()
endfunction

function MeleeTriggerActionPlayerLeft takes nothing returns nothing
	local player thePlayer = GetTriggerPlayer()
	if (IsPlayerObserver(thePlayer_)) then
		call RemovePlayerPreserveUnitsBJ(thePlayer_, PLAYER_GAME_RESULT_NEUTRAL_, false)
		return
	endif
	call CachePlayerHeroData(thePlayer_)
	if (MeleeGetAllyCount(thePlayer_) > 0) then
		call ShareEverythingWithTeam(thePlayer_)
		call MeleeDoLeave(thePlayer_)
	else
		call MakeUnitsPassiveForTeam(thePlayer_)
		call MeleeDoLeave(thePlayer_)
	endif
	call MeleeCheckForLosersAndVictors()
endfunction

function MeleeTriggerActionAllianceChange takes nothing returns nothing
	call MeleeCheckForLosersAndVictors()
	call MeleeCheckForCrippledPlayers()
endfunction

function MeleeTriggerTournamentFinishSoon takes nothing returns nothing
	local integer playerIndex
	local player indexPlayer
	local real timeRemaining = GetTournamentFinishSoonTimeRemaining()
	if not bj_finishSoonAllExposed_ then
		set bj_finishSoonAllExposed_ = true
		set playerIndex_ = 0
		loop
			set indexPlayer_ = Player(playerIndex_)
			if bj_playerIsCrippled_[playerIndex_] then
				set bj_playerIsCrippled_[playerIndex_] = false
				call PauseTimer(bj_crippledTimer_[playerIndex_])
				if (GetLocalPlayer() == indexPlayer_) then
					call TimerDialogDisplay(bj_crippledTimerWindows_[playerIndex_], false)
				endif
			endif
			set playerIndex_ = playerIndex_ + 1
			exitwhen playerIndex_ == bj_MAX_PLAYERS_
		endloop
		call MeleeExposeAllPlayers()
	endif
	call TimerDialogDisplay(bj_finishSoonTimerDialog_, true)
	call TimerDialogSetRealTimeRemaining(bj_finishSoonTimerDialog_, timeRemaining_)
endfunction

function MeleeWasUserPlayer takes player whichPlayer returns boolean
	local playerslotstate slotState
	if (GetPlayerController(whichPlayer_) != MAP_CONTROL_USER_) then
		return false
	endif
	set slotState_ = GetPlayerSlotState(whichPlayer_)
	return (slotState_ == PLAYER_SLOT_STATE_PLAYING_ or slotState_ == PLAYER_SLOT_STATE_LEFT_)
endfunction

function MeleeTournamentFinishNowRuleA takes integer multiplier returns nothing
	local integer playerScore
	local integer teamScore
	local force teamForce
	local integer teamCount
	local integer index
	local player indexPlayer
	local integer index2
	local player indexPlayer2
	local integer bestTeam
	local integer bestScore
	local boolean draw
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if MeleeWasUserPlayer(indexPlayer_) then
			set playerScore_[index_] = GetTournamentScore(indexPlayer_)
			if playerScore_[index_] <= 0 then
				set playerScore_[index_] = 1
			endif
		else
			set playerScore_[index_] = 0
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	set teamCount_ = 0
	set index_ = 0
	loop
		if playerScore_[index_] != 0 then
			set indexPlayer_ = Player(index_)
			set teamScore_[teamCount_] = 0
			set teamForce_[teamCount_] = CreateForce()
			set index2_ = index_
			loop
				if playerScore_[index2_] != 0 then
					set indexPlayer2_ = Player(index2_)
					if PlayersAreCoAllied(indexPlayer_, indexPlayer2_) then
						set teamScore_[teamCount_] = teamScore_[teamCount_] + playerScore_[index2_]
						call ForceAddPlayer(teamForce_[teamCount_], indexPlayer2_)
						set playerScore_[index2_] = 0
					endif
				endif
				set index2_ = index2_ + 1
				exitwhen index2_ == bj_MAX_PLAYERS_
			endloop
			set teamCount_ = teamCount_ + 1
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	set bj_meleeGameOver_ = true
	if teamCount_ != 0 then
		set bestTeam_ = -1
		set bestScore_ = -1
		set index_ = 0
		loop
			if teamScore_[index_] > bestScore_ then
				set bestTeam_ = index_
				set bestScore_ = teamScore_[index_]
			endif
			set index_ = index_ + 1
			exitwhen index_ == teamCount_
		endloop
		set draw_ = false
		set index_ = 0
		loop
			if index_ != bestTeam_ then
				if bestScore_ < (multiplier_ * teamScore_[index_]) then
					set draw_ = true
				endif
			endif
			set index_ = index_ + 1
			exitwhen index_ == teamCount_
		endloop
		if draw_ then
			set index_ = 0
			loop
				call ForForce(teamForce_[index_], function MeleeDoDrawEnum)
				set index_ = index_ + 1
				exitwhen index_ == teamCount_
			endloop
		else
			set index_ = 0
			loop
				if index_ != bestTeam_ then
					call ForForce(teamForce_[index_], function MeleeDoDefeatEnum)
				endif
				set index_ = index_ + 1
				exitwhen index_ == teamCount_
			endloop
			call ForForce(teamForce_[bestTeam_], function MeleeDoVictoryEnum)
		endif
	endif
endfunction

function MeleeTriggerTournamentFinishNow takes nothing returns nothing
	local integer rule = GetTournamentFinishNowRule()
	if bj_meleeGameOver_ then
		return
	endif
	if (rule_ == 1) then
		call MeleeTournamentFinishNowRuleA(1)
	else
		call MeleeTournamentFinishNowRuleA(3)
	endif
	call MeleeRemoveObservers()
endfunction

function MeleeInitVictoryDefeat takes nothing returns nothing
	local trigger trig
	local integer index
	local player indexPlayer
	set bj_finishSoonTimerDialog_ = CreateTimerDialog(null)
	set trig_ = CreateTrigger()
	call TriggerRegisterGameEvent(trig_, EVENT_GAME_TOURNAMENT_FINISH_SOON_)
	call TriggerAddAction(trig_, function MeleeTriggerTournamentFinishSoon)
	set trig_ = CreateTrigger()
	call TriggerRegisterGameEvent(trig_, EVENT_GAME_TOURNAMENT_FINISH_NOW_)
	call TriggerAddAction(trig_, function MeleeTriggerTournamentFinishNow)
	set index_ = 0
	loop
		set indexPlayer_ = Player(index_)
		if (GetPlayerSlotState(indexPlayer_) == PLAYER_SLOT_STATE_PLAYING_) then
			set bj_meleeDefeated_[index_] = false
			set bj_meleeVictoried_[index_] = false
			set bj_playerIsCrippled_[index_] = false
			set bj_playerIsExposed_[index_] = false
			set bj_crippledTimer_[index_] = CreateTimer()
			set bj_crippledTimerWindows_[index_] = CreateTimerDialog(bj_crippledTimer_[index_])
			call TimerDialogSetTitle(bj_crippledTimerWindows_[index_], MeleeGetCrippledTimerMessage(indexPlayer_))
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerUnitEvent(trig_, indexPlayer_, EVENT_PLAYER_UNIT_CONSTRUCT_CANCEL_, null)
			call TriggerAddAction(trig_, function MeleeTriggerActionConstructCancel)
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerUnitEvent(trig_, indexPlayer_, EVENT_PLAYER_UNIT_DEATH_, null)
			call TriggerAddAction(trig_, function MeleeTriggerActionUnitDeath)
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerUnitEvent(trig_, indexPlayer_, EVENT_PLAYER_UNIT_CONSTRUCT_START_, null)
			call TriggerAddAction(trig_, function MeleeTriggerActionUnitConstructionStart)
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerEvent(trig_, indexPlayer_, EVENT_PLAYER_DEFEAT_)
			call TriggerAddAction(trig_, function MeleeTriggerActionPlayerDefeated)
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerEvent(trig_, indexPlayer_, EVENT_PLAYER_LEAVE_)
			call TriggerAddAction(trig_, function MeleeTriggerActionPlayerLeft)
			set trig_ = CreateTrigger()
			call TriggerRegisterPlayerAllianceChange(trig_, indexPlayer_, ALLIANCE_PASSIVE_)
			call TriggerRegisterPlayerStateEvent(trig_, indexPlayer_, PLAYER_STATE_ALLIED_VICTORY_, EQUAL_, 1)
			call TriggerAddAction(trig_, function MeleeTriggerActionAllianceChange)
		else
			set bj_meleeDefeated_[index_] = true
			set bj_meleeVictoried_[index_] = false
			if (IsPlayerObserver(indexPlayer_)) then
				set trig_ = CreateTrigger()
				call TriggerRegisterPlayerEvent(trig_, indexPlayer_, EVENT_PLAYER_LEAVE_)
				call TriggerAddAction(trig_, function MeleeTriggerActionPlayerLeft)
			endif
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
	call TimerStart(CreateTimer(), 2.0, false, function MeleeTriggerActionAllianceChange)
endfunction

function CheckInitPlayerSlotAvailability takes nothing returns nothing
	local integer index
	if (not bj_slotControlReady_) then
		set index_ = 0
		loop
			set bj_slotControlUsed_[index_] = false
			set bj_slotControl_[index_] = MAP_CONTROL_USER_
			set index_ = index_ + 1
			exitwhen index_ == bj_MAX_PLAYERS_
		endloop
		set bj_slotControlReady_ = true
	endif
endfunction

function SetPlayerSlotAvailable takes player whichPlayer, mapcontrol control returns nothing
	local integer playerIndex = GetPlayerId(whichPlayer_)
	call CheckInitPlayerSlotAvailability()
	set bj_slotControlUsed_[playerIndex_] = true
	set bj_slotControl_[playerIndex_] = control_
endfunction

function TeamInitPlayerSlots takes integer teamCount returns nothing
	local integer index
	local player indexPlayer
	local integer team
	call SetTeams(teamCount_)
	call CheckInitPlayerSlotAvailability()
	set index_ = 0
	set team_ = 0
	loop
		if (bj_slotControlUsed_[index_]) then
			set indexPlayer_ = Player(index_)
			call SetPlayerTeam(indexPlayer_, team_)
			set team_ = team_ + 1
			if (team_ >= teamCount_) then
				set team_ = 0
			endif
		endif
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function MeleeInitPlayerSlots takes nothing returns nothing
	call TeamInitPlayerSlots(bj_MAX_PLAYERS_)
endfunction

function FFAInitPlayerSlots takes nothing returns nothing
	call TeamInitPlayerSlots(bj_MAX_PLAYERS_)
endfunction

function OneOnOneInitPlayerSlots takes nothing returns nothing
	call SetTeams(2)
	call SetPlayers(2)
	call TeamInitPlayerSlots(2)
endfunction

function InitGenericPlayerSlots takes nothing returns nothing
	local gametype gType = GetGameTypeSelected()
	if (gType_ == GAME_TYPE_MELEE_) then
		call MeleeInitPlayerSlots()
	elseif (gType_ == GAME_TYPE_MELEE_) then
		call FFAInitPlayerSlots()
	elseif (gType_ == GAME_TYPE_MELEE_) then
	elseif (gType_ == GAME_TYPE_MELEE_) then
		call OneOnOneInitPlayerSlots()
	elseif (gType_ == GAME_TYPE_MELEE_) then
		call TeamInitPlayerSlots(2)
	elseif (gType_ == GAME_TYPE_MELEE_) then
		call TeamInitPlayerSlots(3)
	elseif (gType_ == GAME_TYPE_MELEE_) then
		call TeamInitPlayerSlots(4)
	else
	endif
endfunction

function SetDNCSoundsDawn takes nothing returns nothing
	if bj_useDawnDuskSounds_ then
		call StartSound(bj_dawnSound_)
	endif
endfunction

function SetDNCSoundsDusk takes nothing returns nothing
	if bj_useDawnDuskSounds_ then
		call StartSound(bj_duskSound_)
	endif
endfunction

function SetDNCSoundsDay takes nothing returns nothing
	local real ToD = GetTimeOfDay()
	if (ToD_ >= bj_TOD_DAWN_ and ToD_ < bj_TOD_DUSK_) and not bj_dncIsDaytime_ then
		set bj_dncIsDaytime_ = true
		call StopSound(bj_nightAmbientSound_, false, true)
		call StartSound(bj_dayAmbientSound_)
	endif
endfunction

function SetDNCSoundsNight takes nothing returns nothing
	local real ToD = GetTimeOfDay()
	if (ToD_ < bj_TOD_DAWN_ or ToD_ >= bj_TOD_DUSK_) and bj_dncIsDaytime_ then
		set bj_dncIsDaytime_ = false
		call StopSound(bj_dayAmbientSound_, false, true)
		call StartSound(bj_nightAmbientSound_)
	endif
endfunction

function InitDNCSounds takes nothing returns nothing
	set bj_dawnSound_ = CreateSoundFromLabel("RoosterSound", false, false, false, 10000, 10000)
	set bj_duskSound_ = CreateSoundFromLabel("WolfSound", false, false, false, 10000, 10000)
	set bj_dncSoundsDawn_ = CreateTrigger()
	call TriggerRegisterGameStateEvent(bj_dncSoundsDawn_, GAME_STATE_TIME_OF_DAY_, EQUAL_, bj_TOD_DAWN_)
	call TriggerAddAction(bj_dncSoundsDawn_, function SetDNCSoundsDawn)
	set bj_dncSoundsDusk_ = CreateTrigger()
	call TriggerRegisterGameStateEvent(bj_dncSoundsDusk_, GAME_STATE_TIME_OF_DAY_, EQUAL_, bj_TOD_DUSK_)
	call TriggerAddAction(bj_dncSoundsDusk_, function SetDNCSoundsDusk)
	set bj_dncSoundsDay_ = CreateTrigger()
	call TriggerRegisterGameStateEvent(bj_dncSoundsDay_, GAME_STATE_TIME_OF_DAY_, GREATER_THAN_OR_EQUAL_, bj_TOD_DAWN_)
	call TriggerRegisterGameStateEvent(bj_dncSoundsDay_, GAME_STATE_TIME_OF_DAY_, LESS_THAN_, bj_TOD_DUSK_)
	call TriggerAddAction(bj_dncSoundsDay_, function SetDNCSoundsDay)
	set bj_dncSoundsNight_ = CreateTrigger()
	call TriggerRegisterGameStateEvent(bj_dncSoundsNight_, GAME_STATE_TIME_OF_DAY_, LESS_THAN_, bj_TOD_DAWN_)
	call TriggerRegisterGameStateEvent(bj_dncSoundsNight_, GAME_STATE_TIME_OF_DAY_, GREATER_THAN_OR_EQUAL_, bj_TOD_DUSK_)
	call TriggerAddAction(bj_dncSoundsNight_, function SetDNCSoundsNight)
endfunction

function InitBlizzardGlobals takes nothing returns nothing
	local integer index
	local integer userControlledPlayers
	local version v
	set filterIssueHauntOrderAtLocBJ_ = Filter(function IssueHauntOrderAtLocBJFilter)
	set filterEnumDestructablesInCircleBJ_ = Filter(function EnumDestructablesInCircleBJFilter)
	set filterGetUnitsInRectOfPlayer_ = Filter(function GetUnitsInRectOfPlayerFilter)
	set filterGetUnitsOfTypeIdAll_ = Filter(function GetUnitsOfTypeIdAllFilter)
	set filterGetUnitsOfPlayerAndTypeId_ = Filter(function GetUnitsOfPlayerAndTypeIdFilter)
	set filterMeleeTrainedUnitIsHeroBJ_ = Filter(function MeleeTrainedUnitIsHeroBJFilter)
	set filterLivingPlayerUnitsOfTypeId_ = Filter(function LivingPlayerUnitsOfTypeIdFilter)
	set index_ = 0
	loop
		exitwhen index_ == bj_MAX_PLAYER_SLOTS_
		set bj_FORCE_PLAYER_[index_] = CreateForce()
		call ForceAddPlayer(bj_FORCE_PLAYER_[index_], Player(index_))
		set index_ = index_ + 1
	endloop
	set bj_FORCE_ALL_PLAYERS_ = CreateForce()
	call ForceEnumPlayers(bj_FORCE_ALL_PLAYERS_, null)
	set bj_cineModePriorSpeed_ = GetGameSpeed()
	set bj_cineModePriorFogSetting_ = IsFogEnabled()
	set bj_cineModePriorMaskSetting_ = IsFogMaskEnabled()
	set index_ = 0
	loop
		exitwhen index_ >= bj_MAX_QUEUED_TRIGGERS_
		set bj_queuedExecTriggers_[index_] = null
		set bj_queuedExecUseConds_[index_] = false
		set index_ = index_ + 1
	endloop
	set bj_isSinglePlayer_ = false
	set userControlledPlayers_ = 0
	set index_ = 0
	loop
		exitwhen index_ >= bj_MAX_PLAYERS_
		if (GetPlayerController(Player(index_)) == MAP_CONTROL_USER_ and GetPlayerSlotState(Player(index_)) == PLAYER_SLOT_STATE_PLAYING_) then
			set userControlledPlayers_ = userControlledPlayers_ + 1
		endif
		set index_ = index_ + 1
	endloop
	set bj_isSinglePlayer_ = (userControlledPlayers_ == 1)
	set bj_rescueSound_ = CreateSoundFromLabel("Rescue", false, false, false, 10000, 10000)
	set bj_questDiscoveredSound_ = CreateSoundFromLabel("QuestNew", false, false, false, 10000, 10000)
	set bj_questUpdatedSound_ = CreateSoundFromLabel("QuestUpdate", false, false, false, 10000, 10000)
	set bj_questCompletedSound_ = CreateSoundFromLabel("QuestCompleted", false, false, false, 10000, 10000)
	set bj_questFailedSound_ = CreateSoundFromLabel("QuestFailed", false, false, false, 10000, 10000)
	set bj_questHintSound_ = CreateSoundFromLabel("Hint", false, false, false, 10000, 10000)
	set bj_questSecretSound_ = CreateSoundFromLabel("SecretFound", false, false, false, 10000, 10000)
	set bj_questItemAcquiredSound_ = CreateSoundFromLabel("ItemReward", false, false, false, 10000, 10000)
	set bj_questWarningSound_ = CreateSoundFromLabel("Warning", false, false, false, 10000, 10000)
	set bj_victoryDialogSound_ = CreateSoundFromLabel("QuestCompleted", false, false, false, 10000, 10000)
	set bj_defeatDialogSound_ = CreateSoundFromLabel("QuestFailed", false, false, false, 10000, 10000)
	call DelayedSuspendDecayCreate()
	set v_ = VersionGet()
	if (v_ == VERSION_REIGN_OF_CHAOS_) then
		set bj_MELEE_MAX_TWINKED_HEROES_ = bj_MELEE_MAX_TWINKED_HEROES_V0_
	else
		set bj_MELEE_MAX_TWINKED_HEROES_ = bj_MELEE_MAX_TWINKED_HEROES_V1_
	endif
endfunction

function InitQueuedTriggers takes nothing returns nothing
	set bj_queuedExecTimeout_ = CreateTrigger()
	call TriggerRegisterTimerExpireEvent(bj_queuedExecTimeout_, bj_queuedExecTimeoutTimer_)
	call TriggerAddAction(bj_queuedExecTimeout_, function QueuedTriggerDoneBJ)
endfunction

function InitMapRects takes nothing returns nothing
	set bj_mapInitialPlayableArea_ = Rect(GetCameraBoundMinX() - GetCameraMargin(CAMERA_MARGIN_LEFT_), GetCameraBoundMinY() - GetCameraMargin(CAMERA_MARGIN_BOTTOM_), GetCameraBoundMaxX() + GetCameraMargin(CAMERA_MARGIN_RIGHT_), GetCameraBoundMaxY() + GetCameraMargin(CAMERA_MARGIN_TOP_))
	set bj_mapInitialCameraBounds_ = GetCurrentCameraBoundsMapRectBJ()
endfunction

function InitSummonableCaps takes nothing returns nothing
	local integer index
	set index_ = 0
	loop
		if (not GetPlayerTechResearched(Player(index_), 'Rhrt', true)) then
			call SetPlayerTechMaxAllowed(Player(index_), 'hrtt', 0)
		endif
		if (not GetPlayerTechResearched(Player(index_), 'Robk', true)) then
			call SetPlayerTechMaxAllowed(Player(index_), 'otbk', 0)
		endif
		call SetPlayerTechMaxAllowed(Player(index_), 'uske', bj_MAX_SKELETONS_)
		set index_ = index_ + 1
		exitwhen index_ == bj_MAX_PLAYERS_
	endloop
endfunction

function UpdateStockAvailability takes item whichItem returns nothing
	local itemtype iType = GetItemType(whichItem_)
	local integer iLevel = GetItemLevel(whichItem_)
	if (iType_ == ITEM_TYPE_PERMANENT_) then
		set bj_stockAllowedPermanent_[iLevel_] = true
	elseif (iType_ == ITEM_TYPE_PERMANENT_) then
		set bj_stockAllowedCharged_[iLevel_] = true
	elseif (iType_ == ITEM_TYPE_PERMANENT_) then
		set bj_stockAllowedArtifact_[iLevel_] = true
	else
	endif
endfunction

function UpdateEachStockBuildingEnum takes nothing returns nothing
	local integer iteration = 0
	local integer pickedItemId
	loop
		set pickedItemId_ = ChooseRandomItemEx(bj_stockPickedItemType_, bj_stockPickedItemLevel_)
		exitwhen IsItemIdSellable(pickedItemId_)
		set iteration_ = iteration_ + 1
		if (iteration_ > bj_STOCK_MAX_ITERATIONS_) then
			return
		endif
	endloop
	call AddItemToStock(GetEnumUnit(), pickedItemId_, 1, 1)
endfunction

function UpdateEachStockBuilding takes itemtype iType, integer iLevel returns nothing
	local group g
	set bj_stockPickedItemType_ = iType_
	set bj_stockPickedItemLevel_ = iLevel_
	set g_ = CreateGroup()
	call GroupEnumUnitsOfType(g_, "marketplace", null)
	call ForGroup(g_, function UpdateEachStockBuildingEnum)
	call DestroyGroup(g_)
endfunction

function PerformStockUpdates takes nothing returns nothing
	local integer pickedItemId
	local itemtype pickedItemType
	local integer pickedItemLevel = 0
	local integer allowedCombinations = 0
	local integer iLevel
	set iLevel_ = 1
	loop
		if (bj_stockAllowedPermanent_[iLevel_]) then
			set allowedCombinations_ = allowedCombinations_ + 1
			if (GetRandomInt(1, allowedCombinations_) == 1) then
				set pickedItemType_ = ITEM_TYPE_PERMANENT_
				set pickedItemLevel_ = iLevel_
			endif
		endif
		if (bj_stockAllowedCharged_[iLevel_]) then
			set allowedCombinations_ = allowedCombinations_ + 1
			if (GetRandomInt(1, allowedCombinations_) == 1) then
				set pickedItemType_ = ITEM_TYPE_CHARGED_
				set pickedItemLevel_ = iLevel_
			endif
		endif
		if (bj_stockAllowedArtifact_[iLevel_]) then
			set allowedCombinations_ = allowedCombinations_ + 1
			if (GetRandomInt(1, allowedCombinations_) == 1) then
				set pickedItemType_ = ITEM_TYPE_ARTIFACT_
				set pickedItemLevel_ = iLevel_
			endif
		endif
		set iLevel_ = iLevel_ + 1
		exitwhen iLevel_ > bj_MAX_ITEM_LEVEL_
	endloop
	if (allowedCombinations_ == 0) then
		return
	endif
	call UpdateEachStockBuilding(pickedItemType_, pickedItemLevel_)
endfunction

function StartStockUpdates takes nothing returns nothing
	call PerformStockUpdates()
	call TimerStart(bj_stockUpdateTimer_, bj_STOCK_RESTOCK_INTERVAL_, true, function PerformStockUpdates)
endfunction

function RemovePurchasedItem takes nothing returns nothing
	call RemoveItemFromStock(GetSellingUnit(), GetItemTypeId(GetSoldItem()))
endfunction

function InitNeutralBuildings takes nothing returns nothing
	local integer iLevel
	set iLevel_ = 0
	loop
		set bj_stockAllowedPermanent_[iLevel_] = false
		set bj_stockAllowedCharged_[iLevel_] = false
		set bj_stockAllowedArtifact_[iLevel_] = false
		set iLevel_ = iLevel_ + 1
		exitwhen iLevel_ > bj_MAX_ITEM_LEVEL_
	endloop
	call SetAllItemTypeSlots(bj_MAX_STOCK_ITEM_SLOTS_)
	call SetAllUnitTypeSlots(bj_MAX_STOCK_UNIT_SLOTS_)
	set bj_stockUpdateTimer_ = CreateTimer()
	call TimerStart(bj_stockUpdateTimer_, bj_STOCK_RESTOCK_INITIAL_DELAY_, false, function StartStockUpdates)
	set bj_stockItemPurchased_ = CreateTrigger()
	call TriggerRegisterPlayerUnitEvent(bj_stockItemPurchased_, Player(PLAYER_NEUTRAL_PASSIVE_), EVENT_PLAYER_UNIT_SELL_ITEM_, null)
	call TriggerAddAction(bj_stockItemPurchased_, function RemovePurchasedItem)
endfunction

function MarkGameStarted takes nothing returns nothing
	set bj_gameStarted_ = true
	call DestroyTimer(bj_gameStartedTimer_)
endfunction

function DetectGameStarted takes nothing returns nothing
	set bj_gameStartedTimer_ = CreateTimer()
	call TimerStart(bj_gameStartedTimer_, bj_GAME_STARTED_THRESHOLD_, false, function MarkGameStarted)
endfunction

function InitBlizzard takes nothing returns nothing
	call ConfigureNeutralVictim()
	call InitBlizzardGlobals()
	call InitQueuedTriggers()
	call InitRescuableBehaviorBJ()
	call InitDNCSounds()
	call InitMapRects()
	call InitSummonableCaps()
	call InitNeutralBuildings()
	call DetectGameStarted()
endfunction

function RandomDistReset takes nothing returns nothing
	set bj_randDistCount_ = 0
endfunction

function RandomDistAddItem takes integer inID, integer inChance returns nothing
	set bj_randDistID_[bj_randDistCount_] = inID_
	set bj_randDistChance_[bj_randDistCount_] = inChance_
	set bj_randDistCount_ = bj_randDistCount_ + 1
endfunction

function RandomDistChoose takes nothing returns integer
	local integer sum = 0
	local integer chance = 0
	local integer index
	local integer foundID = -1
	local boolean done
	if (bj_randDistCount_ == 0) then
		return -1
	endif
	set index_ = 0
	loop
		set sum_ = sum_ + bj_randDistChance_[index_]
		set index_ = index_ + 1
		exitwhen index_ == bj_randDistCount_
	endloop
	set chance_ = GetRandomInt(1, sum_)
	set index_ = 0
	set sum_ = 0
	set done_ = false
	loop
		set sum_ = sum_ + bj_randDistChance_[index_]
		if (chance_ <= sum_) then
			set foundID_ = bj_randDistID_[index_]
			set done_ = true
		endif
		set index_ = index_ + 1
		if (index_ == bj_randDistCount_) then
			set done_ = true
		endif
		exitwhen done_ == true
	endloop
	return foundID_
endfunction

function UnitDropItem takes unit inUnit, integer inItemID returns item
	local real x
	local real y
	local real radius = 32
	local real unitX
	local real unitY
	local item droppedItem
	if (inItemID_ == -1) then
		return null
	endif
	set unitX_ = GetUnitX(inUnit_)
	set unitY_ = GetUnitY(inUnit_)
	set x_ = GetRandomReal(unitX_ - radius_, unitX_ + radius_)
	set y_ = GetRandomReal(unitY_ - radius_, unitY_ + radius_)
	set droppedItem_ = CreateItem(inItemID_, x_, y_)
	call SetItemDropID(droppedItem_, GetUnitTypeId(inUnit_))
	call UpdateStockAvailability(droppedItem_)
	return droppedItem_
endfunction

function WidgetDropItem takes widget inWidget, integer inItemID returns item
	local real x
	local real y
	local real radius = 32
	local real widgetX
	local real widgetY
	if (inItemID_ == -1) then
		return null
	endif
	set widgetX_ = GetWidgetX(inWidget_)
	set widgetY_ = GetWidgetY(inWidget_)
	set x_ = GetRandomReal(widgetX_ - radius_, widgetX_ + radius_)
	set y_ = GetRandomReal(widgetY_ - radius_, widgetY_ + radius_)
	return CreateItem(inItemID_, x_, y_)
endfunction
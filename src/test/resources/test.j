function HaveStoredValue1 takes string key, integer valueType, string missionKey, gamecache cache returns boolean
    call PauseGame( false )

    if (valueType == bj_GAMECACHE_BOOLEAN) then
        return HaveStoredBoolean(cache, missionKey, key)
    elseif (valueType == bj_GAMECACHE_INTEGER) then
        return HaveStoredInteger(cache, missionKey, key)
    elseif (valueType == bj_GAMECACHE_REAL) then
        return HaveStoredReal(cache, missionKey, key)
    elseif (valueType == bj_GAMECACHE_UNIT) then
        return HaveStoredUnit(cache, missionKey, key)
    elseif (valueType == bj_GAMECACHE_STRING) then
        return HaveStoredString(cache, missionKey, key)
    else
        // Unrecognized value type - ignore the request.
        return false
    endif
endfunction

function QueuedTriggerRemoveByIndex1 takes integer trigIndex returns boolean
    local integer index

        // If the to-be-removed index is out of range, fail.
    if (trigIndex >= bj_queuedExecTotal) then
        return false
    endif

        // Shift all queue entries down to fill in the gap.
    set bj_queuedExecTotal = bj_queuedExecTotal - 1
    set index = trigIndex
    loop
        exitwhen index >= bj_queuedExecTotal
        set bj_queuedExecTriggers[index] = bj_queuedExecTriggers[index + 1]
        set bj_queuedExecUseConds[index] = bj_queuedExecUseConds[index + 1]
        set index = index + 1
    endloop
    return true
endfunction

function SinBJ1 takes real degrees returns real
    return Sin(degrees * bj_DEGTORAD)
endfunction

function RectContainsCoords1 takes rect r, real x, real y returns boolean
    return (GetRectMinX(r) <= x) and (x <= GetRectMaxX(r)) and (GetRectMinY(r) <= y) and (y <= GetRectMaxY(r))
endfunction

function BJDebugMsg1 takes string msg returns nothing
    local integer i = 0
    loop
        call DisplayTimedTextToPlayer(Player(i), 0, 0, 60, msg)
        set i = i + 1
        exitwhen i == bj_MAX_PLAYERS
    endloop
endfunction

function main takes real end returns nothing
    local real a = 22
    local real b = 44
    local integer end

    set end = "a1"

    loop

    exitwhen true

    exitwhen 1 > 2 == 3 != 4 and true or false

        set end = "a2"

            loop
            set end = 23
            set end = 25 + 12

                return false

            endloop

    endloop


    if true then

        if 2 + 3 > 0 then

            set end = 33

        endif

    else

    endif

    return 22
    return a
    return b


endfunction



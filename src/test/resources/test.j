// - not unary
// array

type rect extends handle
type player extends handle

globals
    integer b = 1 + 2 - - (3)
    handle h = null

    real bj_DEGTORAD = 12

    integer array a

    integer t = a[12]

constant integer bj_MAX_PLAYERS = 12

endglobals

native DisplayTimedTextToPlayer     takes player toPlayer, real x, real y, real duration, string message returns nothing

function QueuedTriggerRemoveByIndex takes integer trigIndex returns boolean
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

function SinBJ takes real degrees returns real
    return Sin(degrees * bj_DEGTORAD)
endfunction

function RectContainsCoords takes rect r, real x, real y returns boolean
    return (GetRectMinX(r) <= x) and (x <= GetRectMaxX(r)) and (GetRectMinY(r) <= y) and (y <= GetRectMaxY(r))
endfunction

function BJDebugMsg takes string msg returns nothing
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

            set w = 33

        endif

    else

    endif

    return 22
    return a
    return b


endfunction



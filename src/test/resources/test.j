globals
    integer b = 1 + 2 - 3.
constant integer bj_MAX_PLAYERS = 12

endglobals

native DisplayTimedTextToPlayer     takes player toPlayer, real x, real y, real duration, string message returns nothing

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



type anal extends handle

globals
    boolean b = "a" != null
    integer a = 22
    real b = 33.3
    string s = "a" + "b"
endglobals

native UnitAlive takes unit u returns unit


function A takes real a returns real
    local integer b = 33

    if a > b then
        set s = s + "e"
    endif

    loop
        set s = s + "g"
        exitwhen b > a
    endloop

    call UnitAlive(null)

    return a * b

endfunction

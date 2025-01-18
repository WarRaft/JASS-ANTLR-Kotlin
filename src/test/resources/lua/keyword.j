globals
    real do = 1
    real do_ = 2
    real keyword = 2
endglobals

function end takes real until returns real
    local real in = do + until + keyword
    return in
endfunction

function main takes nothing returns nothing
    local real repeat = end(do) + end(keyword)
endfunction

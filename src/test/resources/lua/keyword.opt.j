globals
	real a = 1
	real b = 2
	real c = 2
endglobals

function d takes real f returns real
	local real e = a + f + c
	return e
endfunction

function g takes nothing returns nothing
	local real h = d(a) + d(c)
endfunction
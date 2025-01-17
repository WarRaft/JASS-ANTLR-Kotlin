globals
	real a = 1
	real b = 2
endglobals

function c takes real e returns real
	local real d = a + e + b
	return d
endfunction

function f takes nothing returns nothing
	local real g = c(a) + c(b)
endfunction
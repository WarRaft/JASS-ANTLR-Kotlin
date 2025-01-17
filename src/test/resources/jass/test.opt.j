native Deg2Rad1 takes real h returns real

native Deg2Rad2 takes nothing returns nothing

globals
	real array b
	integer c = 1
	integer d = 1
	real e = 2
	real g = 2
endglobals

function i takes nothing returns nothing
	set c = 2
	set e = 2
	set g = 3
endfunction

function j takes real l, real l, real n returns real
	local integer l
	local string l
	local integer k
	set l = 2
	set k = l + k
	set e = 4
	set g = 4
	call j()
	call i(j(), ((j())))
endfunction
type handle
type anal extends handle


native UnitAlive takes unit u returns unit

globals
	integer a = 22
	real b = 33.3
	string s = "a" + "b"
endglobals


function A takes real a returns real
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
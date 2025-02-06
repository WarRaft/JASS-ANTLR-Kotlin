type anal extends handle


native UnitAlive takes unit u returns unit

globals
	hashtable HT = InitHashtable()
	boolean s1 = "a" != null
	boolean s2 = null == "a"
	boolean s3 = null == LoadStr(HT, 0, 0)
	boolean b1 = 1 == null
	integer array a
	real b = 33.3
	integer hex = $A
	integer hex1 = 0xA
	integer raw = 'A'
	string s = "a" + "b"
endglobals


function Ba takes nothing returns nothing
endfunction

function A takes real a, code d returns real
	call TimerStart(15., true, function Ba)
	set s[0] = "00"
	set s[1] = "11"
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
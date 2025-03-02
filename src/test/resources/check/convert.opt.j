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
	call TimerStart(t, 15., true, function Ba)
	if a > b then
	endif
	loop
		exitwhen b > a
	endloop
	call UnitAlive(null)
	return a * b
endfunction
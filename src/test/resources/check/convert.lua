---@class anal:handle


--- native
---@param u unit
---@return unit
function UnitAlive(u)
end

HT = InitHashtable() ---@type hashtable
s1 = "a" != nil ---@type boolean
s2 = nil == "a" ---@type boolean
s3 = nil == LoadStr(HT, 0, 0) ---@type boolean
b1 = 1 == nil ---@type boolean
a = {} ---@type number[] integer
b = 33.3 ---@type number real
hex = $A ---@type number integer
hex1 = 0xA ---@type number integer
raw = FourCC('A') ---@type number integer
s = "a" .. "b" ---@type string


function Ba()
end

---@param a number real
---@param d function
---@return number real
function A(a, d)
	TimerStart(15., true, Ba)
	s["00"] = "00"
	s["11"] = "11"
	if a > b then
		s[s .. "e"] = s .. "e"
	end
	while(true) do
		s[s .. "g"] = s .. "g"
		if (b > a) then break end
	end
	UnitAlive(nil)
	return a * b
end
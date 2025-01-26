---@class handle
---@class anal:handle


--- native
---@param u unit
---@return unit
function UnitAlive(u)
end

a = 22 ---@type number integer
b = 33.3 ---@type number real
s = "a" .. "b" ---@type string


---@param a number real
---@return number real
function A(a)
	if a > b then
		s = s .. "e"
	end
	while(true) do
		s = s .. "g"
		if (b > a) then break end
	end
	UnitAlive(nil)
	return a * b
end
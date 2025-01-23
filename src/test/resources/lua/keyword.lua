a = 1 ---@type number real
b = 2 ---@type number real
c = 2 ---@type number real


---@param f number real
---@return number real
function d(f)
	local e = a + f + c ---@type number real
	return e
end

function g()
	local h = d(a) + d(c) ---@type number real
end
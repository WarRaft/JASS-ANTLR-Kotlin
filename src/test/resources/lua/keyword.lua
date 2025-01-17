a = 1 ---@type number real
keyword = 2 ---@type number real


---@param e number real
---@return number real
function c(e)
	local d = a + e + keyword ---@type number real
	return d
end

function main()
	local g = c(a) + c(keyword) ---@type number real
end
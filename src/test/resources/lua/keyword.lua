a = 1 ---@type number real
do_ = 2 ---@type number real
keyword = 2 ---@type number real


---@param f number real
---@return number real
function d(f)
	local e = a + f + keyword ---@type number real
	return e
end

function main()
	local h = d(a) + d(keyword) ---@type number real
end
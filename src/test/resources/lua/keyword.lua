---@param until real
function end(until)
	local in = do + until + keyword ---@type real
	return in
end

function main()
	local repeat = end(do) .. end(keyword) ---@type real
end
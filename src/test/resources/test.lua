---@param key string
---@param valueType number integer
---@param missionKey string
---@param cache gamecache
---@return boolean
function HaveStoredValue1 (key, valueType, missionKey, cache)
end

---@param trigIndex number integer
---@return boolean
function QueuedTriggerRemoveByIndex1 (trigIndex)
	local index ---@type number integer
	bj_queuedExecTotal = bj_queuedExecTotal - 1
	index = trigIndex
	while(true) do
		if (index >= bj_queuedExecTotal) then break end
		bj_queuedExecTriggers[index] = bj_queuedExecTriggers[index + 1]
		bj_queuedExecUseConds[index] = bj_queuedExecUseConds[index + 1]
		index = index + 1
	end
	return true
end

---@param degrees number real
---@return number real
function SinBJ1 (degrees)
	return Sin(degrees * bj_DEGTORAD)
end

---@param r rect
---@param x number real
---@param y number real
---@return boolean
function RectContainsCoords1 (r, x, y)
	return (GetRectMinX(r) <= x) and (x <= GetRectMaxX(r)) and (GetRectMinY(r) <= y) and (y <= GetRectMaxY(r))
end

---@param msg string
function BJDebugMsg1 (msg)
	local i = 0 ---@type number integer
	while(true) do
		i = i + 1
		if (i == bj_MAX_PLAYERS) then break end
	end
end

---@param end_anal number real
function main (end_anal)
	local a = 22 ---@type number real
	local b = 44 ---@type number real
	local end_anal ---@type number integer
	end_anal = "a1"
	while(true) do
		if (true) then break end
		if (1 > 2 == 3 ~= 4 and true or false) then break end
		end_anal = "a2"
		while(true) do
			end_anal = 23
			end_anal = 25 + 12
			return false
		end
	end
	return 22
	return a
	return b
end
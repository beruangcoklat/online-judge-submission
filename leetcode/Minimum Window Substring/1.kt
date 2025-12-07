class Solution {
    fun minWindow(s: String, t: String): String {
        val tMap = t.toCharArray().groupBy { it }.map { it.key to it.value.size }.toMap()

        var startIdx = 0
        var currIdx = 0
        var currMap = mutableMapOf<Char, Int>()
        var result = ""

        while (currIdx < s.length) {
            val c = s[currIdx]
            if (tMap.contains(c)) {
                currMap[c] = (currMap[c] ?: 0) + 1
            }
            if (ok(currMap, tMap)) {
                var currResult = s.substring(startIdx, currIdx + 1)
                if (result == "" || result.length > currResult.length) {
                    result = currResult
                }

                while (true) {
                    currMap[s[startIdx]] = (currMap[s[startIdx]] ?: 0) - 1
                    startIdx++
                    if (!ok(currMap, tMap)) {
                        startIdx--
                        currMap[s[startIdx]] = currMap[s[startIdx]]!! + 1
                        break
                    } else {
                        var currResult = s.substring(startIdx, currIdx + 1)
                        if (result == "" || result.length > currResult.length) {
                            result = currResult
                        }
                    }
                }
            }
            currIdx++
        }
        if (ok(currMap, tMap)) {
            var currResult = s.substring(startIdx, currIdx)
            if (result == "" || result.length > currResult.length) {
                result = currResult
            }
        }
        return result
    }

    private fun ok(curr: Map<Char, Int>, target: Map<Char, Int>): Boolean {
        return target.entries.all { entry ->
            val v = curr[entry.key] ?: 0
            v >= entry.value
        }
    }
}
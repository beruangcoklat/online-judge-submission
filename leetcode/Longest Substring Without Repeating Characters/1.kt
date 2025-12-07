class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charMap = mutableMapOf<Char, Int>()
        var curr = 0
        var max = 0
        var startIdx = 0
        for (i in s.indices) {
            val c = s[i]

            if (charMap[c] == null || charMap[c] == 0) {
                curr++
                charMap[c] = 1
            } else {
                while (charMap[c] != null && charMap[c]!! > 0) {
                    charMap[s[startIdx]] = charMap[s[startIdx]]!! - 1
                    startIdx++
                    curr--
                }
                curr++
                charMap[c] = 1
            }

            max = Math.max(max, curr)
        }
        return max
    }
}
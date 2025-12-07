class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var startIdx = 0
        var curr = 0
        var max = 0
        val charMap = mutableMapOf<Char, Int>()
        var maxFreq = 0
        for (i in s.indices) {
            charMap[s[i]] = (charMap[s[i]] ?: 0) + 1
            curr++
            maxFreq = Math.max(maxFreq, charMap[s[i]]!!)

            val replacementNeeded = curr - maxFreq
            if (replacementNeeded > k) {
                charMap[s[startIdx]] = charMap[s[startIdx]]!! - 1
                curr--
                startIdx++
            }

            max = Math.max(max, curr)
        }
        return max
    }
}
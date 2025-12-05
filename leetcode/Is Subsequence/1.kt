class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIdx = 0
        var tIdx = 0

        while (sIdx < s.length && tIdx < t.length) {
            if (s[sIdx] == t[tIdx]) {
                sIdx++
                tIdx++
            } else {
                tIdx++
            }
        }
        return sIdx == s.length
    }
}
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var idx = 0
        while (true) {
            if (idx >= strs[0].length) break

            val c = strs[0][idx]
            var isBreak = false
            for (str in strs) {
                if (idx >= str.length || str[idx] != c) {
                    isBreak = true
                    break
                }
            }
            if (isBreak) break
            idx++
        }
        return strs[0].substring(0, idx)
    }
}
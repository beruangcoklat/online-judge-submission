class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            val a = s[left]
            while (left < s.length && !s[left].isLetterOrDigit()) {
                left++
            }
            while (right >= 0 && !s[right].isLetterOrDigit()) {
                right--
            }
            if (left >= right) break

            if (s[left].lowercase() == s[right].lowercase()) {
                left++
                right--
            } else return false
        }
        return true
    }
}
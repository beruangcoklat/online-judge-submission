class Solution {
    fun hammingWeight(n: Int): Int {
        var result = 0
        var mutableN = n
        while (mutableN > 0) {
            result += mutableN % 2
            mutableN = mutableN shr 1
        }
        return result
    }
}
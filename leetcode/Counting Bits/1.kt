class Solution {
    fun countBits(n: Int): IntArray {
        return IntArray(n + 1).mapIndexed { idx, i -> numberOf1Bits(idx) }.toIntArray()
    }

    private fun numberOf1Bits(n: Int): Int {
        var mutableN = n
        var result = 0
        while (mutableN > 0) {
            result += mutableN % 2
            mutableN = mutableN shr 1
        }
        return result
    }
}
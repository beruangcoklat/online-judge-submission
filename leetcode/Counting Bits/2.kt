class Solution {
    fun countBits(n: Int): IntArray {
        val cache: MutableMap<Int, Int> = mutableMapOf()
        return IntArray(n + 1).mapIndexed { idx, i ->
            val nonLeastSignificantBit = idx shr 1

            val result = if (cache.containsKey(nonLeastSignificantBit)) {
                (cache[nonLeastSignificantBit] ?: 0) + (idx % 2)
            } else numberOf1Bits(idx)

            cache[idx] = result
            result
        }.toIntArray()
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
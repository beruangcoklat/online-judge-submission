class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var allXor = nums.fold(0) { acc, i -> acc.xor(i) }

        var shiftCount = 0
        while (allXor % 2 == 0) {
            allXor = allXor shr 1
            shiftCount++
        }

        val groups = intArrayOf(0, 0)
        nums.forEach { num ->
            val idx = ((num shr shiftCount) % 2).absoluteValue
            groups[idx] = groups[idx].xor(num)
        }

        return groups
    }
}
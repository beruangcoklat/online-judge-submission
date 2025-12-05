class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        val list = mutableListOf<Long>()
        var curr = 0L
        var start = false
        for (i in nums.indices) {
            if (nums[i] == 0) {
                curr++
                start = true
            } else {
                if (start) {
                    start = false
                    list.add(curr)
                }
                curr = 0
            }
        }
        if (start) {
            list.add(curr)
        }
        return list.map { n -> sumFrom1ToN(n) }.sum()
    }

    private fun sumFrom1ToN(n: Long): Long {
        return n * (n + 1) / 2
    }
}
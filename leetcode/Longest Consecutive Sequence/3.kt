class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        val startOfSequenceNums = mutableListOf<Int>()
        for (num in nums) {
            if (!set.contains(num - 1)) {
                startOfSequenceNums.add(num)
            }
        }

        return startOfSequenceNums.map { startNum ->
            var result = 0
            var i = startNum
            while (set.contains(i)) {
                result++
                i++
            }
            result
        }.maxOrNull() ?: 0
    }
}
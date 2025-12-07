class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numMap = nums.map { it to null }.toMap()

        val startOfSequenceNums = mutableListOf<Int>()
        for (num in nums) {
            if (!numMap.containsKey(num - 1)) {
                startOfSequenceNums.add(num)
            }
        }

        return startOfSequenceNums.map { startNum ->
            var result = 0
            var i = startNum
            while (numMap.containsKey(i)) {
                i++
                result++
            }
            result
        }.maxOrNull() ?: 0
    }
}
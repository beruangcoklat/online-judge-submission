class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        nums.sort()
        val result = mutableListOf<Int>()
        for (i in 0 until nums.size) {
            val leftSame = if (i - 1 >= 0) {
                nums[i] != nums[i - 1]
            } else true
            val rightSame = if (i + 1 < nums.size) {
                nums[i] != nums[i + 1]
            } else true

            if (leftSame && rightSame) {
                result.add(nums[i])
            }
        }
        return result.toIntArray()
    }
}
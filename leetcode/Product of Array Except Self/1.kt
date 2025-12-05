class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val multiplyFromLeft = IntArray(nums.size) { 1 }
        val multiplyFromRight = IntArray(nums.size) { 1 }

        multiplyFromLeft[0] = nums[0]
        multiplyFromRight[nums.size - 1] = nums[nums.size - 1]

        for (i in 1 until nums.size) {
            multiplyFromLeft[i] = nums[i] * multiplyFromLeft[i - 1]
            multiplyFromRight[nums.size - 1 - i] = nums[nums.size - 1 - i] * multiplyFromRight[nums.size - i]
        }

        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            result[i] = when (i) {
                0 -> multiplyFromRight[1]
                nums.size - 1 -> multiplyFromLeft[nums.size - 2]
                else -> multiplyFromLeft[i - 1] * multiplyFromRight[i + 1]
            }
        }

        return result
    }
}
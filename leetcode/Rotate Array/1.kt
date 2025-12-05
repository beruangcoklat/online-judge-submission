class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            val idx = (i + k) % nums.size
            result[idx] = nums[i]
        }
        for (i in nums.indices) {
            nums[i] = result[i]
        }
    }
}
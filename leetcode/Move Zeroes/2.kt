class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        for (a in 0..nums.size) {
            for (i in nums.size - 1 downTo 1) {
                if (nums[i] != 0 && nums[i - 1] == 0) {
                    val temp = nums[i]
                    nums[i] = nums[i - 1]
                    nums[i - 1] = temp   
                }
            }
        }
    }
}
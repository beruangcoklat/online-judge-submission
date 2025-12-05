class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        var idx = 0
        while (idx < nums.size) {
            val n = nums[idx]
            if (n <= 0 || n > nums.size || n == idx + 1 || nums[n - 1] == nums[idx]) {
                idx++
                continue
            }

            val temp = nums[n - 1]
            nums[n - 1] = nums[idx]
            nums[idx] = temp
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }
        return nums.size + 1
    }
}
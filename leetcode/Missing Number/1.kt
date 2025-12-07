class Solution {
    fun missingNumber(nums: IntArray): Int {
        var idx = 0
        while (idx < nums.size) {
            val n = nums[idx]
            if (idx == n || n >= nums.size) {
                idx++
                continue
            }

            val temp = nums[idx]
            nums[idx] = nums[n]
            nums[n] = temp
        }

        for (i in nums.indices) {
            if (i == nums[i]) continue
            return i
        }
        return nums.size
    }
}
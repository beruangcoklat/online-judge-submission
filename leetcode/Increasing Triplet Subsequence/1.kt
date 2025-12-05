class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        val maxFromRight = IntArray(nums.size)
        val minFromLeft = IntArray(nums.size)
        maxFromRight[nums.size - 1] = nums[nums.size - 1]
        minFromLeft[0] = nums[0]

        for (i in nums.size - 2 downTo 0) {
            maxFromRight[i] = Math.max(nums[i], maxFromRight[i + 1])
        }

        for (i in 1..nums.size - 1) {
            minFromLeft[i] = Math.min(nums[i], minFromLeft[i - 1])
        }

        for (i in 1..nums.size - 2) {
            if (minFromLeft[i - 1] < nums[i] && nums[i] < maxFromRight[i + 1]) {
                return true
            }
        }
        return false
    }
}
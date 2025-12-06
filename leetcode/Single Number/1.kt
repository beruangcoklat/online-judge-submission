class Solution {
    fun singleNumber(nums: IntArray): Int {
        nums.sort()
        var count = 1
        var prev = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] == prev) {
                count++
            } else if (count == 1) {
                return prev
            } else {
                prev = nums[i]
                count = 1
            }
        }
        return nums[nums.size - 1]
    }
}
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) return 0
        nums.sort()
        var curr = 1
        var max = 1
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) continue
            if (nums[i] == nums[i - 1] + 1) {
                curr++
            } else {
                curr = 1
            }
            max = Math.max(max, curr)
        }
        return max
    }
}
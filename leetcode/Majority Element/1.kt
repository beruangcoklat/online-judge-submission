class Solution {
    fun majorityElement(nums: IntArray): Int {
        val countMap = mutableMapOf<Int, Int>()
        for (n in nums) {
            val count = (countMap[n] ?: 0) + 1
            countMap[n] = count
            if (count > nums.size / 2) return n
        }
        return 0
    }
}
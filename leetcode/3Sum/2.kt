class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            twoSum(nums, i + 1, -nums[i]).let { resp ->
                if (resp.isNotEmpty()) {
                    result.addAll(resp)
                }
            }
        }
        return result
    }

    private fun twoSum(nums: IntArray, startIdx: Int, sum: Int): MutableList<List<Int>> {
        var results = mutableListOf<List<Int>>()
        var left = startIdx
        var right = nums.size - 1
        while (left < right) {
            val total = nums[left] + nums[right]
            if (total == sum) {
                if (results.isEmpty() || results[results.size - 1][1] != nums[left]) {
                    results.add(listOf(nums[startIdx - 1], nums[left], nums[right]))
                }
                left++
            } else if (total < sum) {
                left++
            } else {
                right--
            }
        }
        return results
    }
}
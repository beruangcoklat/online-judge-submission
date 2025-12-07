class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var keys = mutableSetOf<String>()
        for (i in nums.indices) {
            twoSum(nums, i + 1, -nums[i], keys).let { resp ->
                if (resp.isNotEmpty()) {
                    result.addAll(resp)
                }
            }
        }
        return result
    }

    private fun twoSum(nums: IntArray, startIdx: Int, sum: Int, keys: MutableSet<String>): MutableList<List<Int>> {
        val set = mutableSetOf<Int>()
        var results = mutableListOf<List<Int>>()
        for (i in startIdx until nums.size) {
            if (set.contains(sum - nums[i])) {
                var result = listOf(nums[startIdx - 1], sum - nums[i], nums[i])
                val key = getKey(result)
                if (!keys.contains(key)) {
                    keys.add(key)
                    results.add(result)
                }
            }
            set.add(nums[i])
        }
        return results
    }

    private fun getKey(nums: List<Int>): String {
        return nums.sorted().joinToString(" ") { it.toString() }
    }
}
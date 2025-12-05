class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var pointerToSet = 0
        var k = 0
        val map = mutableMapOf<Int, Boolean>()

        for (i in 0 until nums.size) {
            if (map.containsKey(nums[i])) continue

            map[nums[i]] = true
            nums[pointerToSet++] = nums[i]
            k++
        }
        return k
    }
}
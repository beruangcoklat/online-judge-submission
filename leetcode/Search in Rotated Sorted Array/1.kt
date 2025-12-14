class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val mid = findMid(nums)
        val a = doSearch(nums, target, 0, mid - 1)
        if (a != -1) return a
        val b = doSearch(nums, target, mid, nums.size - 1)
        if (b != -1) return b
        return -1
    }

    fun doSearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        var left = left
        var right = right
        while (left <= right) {
            val mid = (left + right) / 2
            if (target == nums[mid]) return mid
            else if (target > nums[mid]) left = mid + 1
            else if (target < nums[mid]) right = mid - 1
        }
        return -1
    }

    fun findMid(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (mid + 1 < nums.size && nums[mid + 1] < nums[mid]) {
                return mid + 1
            }
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return mid
            }

            val leftValid = nums[mid] >= nums[left]
            val rightValid = nums[right] >= nums[mid]

            if (!leftValid) right = mid - 1
            else if (!rightValid) left = mid + 1
            else break
        }
        return left
    }
}
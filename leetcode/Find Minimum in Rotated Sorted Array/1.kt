class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = (left + right) / 2

            if (mid + 1 < nums.size && nums[mid + 1] < nums[mid])
                return nums[mid + 1]

            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                return nums[mid]

            val leftValid = nums[left] < nums[mid]
            val rightValid = nums[right] > nums[mid]

            if (!rightValid) {
                left = mid + 1
            } else if (!leftValid) {
                right = mid - 1
            } else {
                return nums[left]
            }
        }
        return nums[0]
    }
}
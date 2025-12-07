class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0

        while (left < right) {
            val curr = (right - left) * Math.min(height[left], height[right])
            max = Math.max(max, curr)

            if (height[left] < height[right]) left++
            else right--
        }
        return max
    }
}
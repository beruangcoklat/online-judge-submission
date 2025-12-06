class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var mutableLeft = left
        var mutableRight = right
        var shiftCount = 0
        while (mutableLeft != mutableRight) {
            mutableLeft = mutableLeft shr 1
            mutableRight = mutableRight shr 1
            shiftCount++
        }
        return mutableLeft shl shiftCount
    }
}
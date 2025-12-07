class Solution {
    fun getSum(a: Int, b: Int): Int {
        var result = a.xor(b)
        var shiftCount = 0

        var mutableA = a
        var mutableB = b

        while (mutableA > 0 && mutableB > 0) {
            val lsbA = (mutableA % 2).absoluteValue
            val lsbB = (mutableB % 2).absoluteValue

            if (lsbA == 1 && lsbB == 1) {
                var carrier = 1 shl shiftCount + 1
                result = result or carrier
            }

            shiftCount++
            mutableA = mutableA shr 1
            mutableB = mutableB shr 1
        }
        return result
    }
}
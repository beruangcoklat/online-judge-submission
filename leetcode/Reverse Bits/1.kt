class Solution {
    fun reverseBits(n: Int): Int {
        val list = IntArray(32) { 0 }
        var listIdx = 0
        var mutableN = n
        while (mutableN > 0) {
            list[listIdx++] = mutableN % 2
            mutableN = mutableN shr 1
        }

        var result = 0
        for (i in list.size - 1 downTo 0) {
            if (list[i] == 0) continue
            result += 2.0.pow((list.size - 1 - i).toDouble()).toInt()
        }
        return result
    }
}
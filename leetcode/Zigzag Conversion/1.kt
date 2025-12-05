class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        
        val list = Array(numRows) { "" }
        var idx = 0
        var isUp = true
        for (c in s) {
            list[idx] = list[idx] + c
            when (isUp) {
                true ->
                    if (idx == numRows - 1) {
                        isUp = false
                        idx--
                    } else idx++

                false ->
                    if (idx == 0) {
                        isUp = true
                        idx++
                    } else idx--
            }
        }

        return list.fold("") { acc, i -> acc + i }
    }
}
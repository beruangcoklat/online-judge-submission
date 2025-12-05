class Solution {
    fun reverseWords(s: String): String {
        val list = mutableListOf<String>()
        var from = -1
        for (i in 0 until s.length) {
            if (s[i] != ' ') {
                if (from == -1) {
                    from = i
                }
            } else if (from != -1) {
                list.add(s.substring(from, i))
                from = -1
            }
        }
        if (from != -1)
            list.add(s.substring(from))

        return list.reversed().joinToString(" ")
    }
}

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     fun guess(word: String): Int {}
 * }
 */
class Solution {
    fun findSecretWord(words: Array<String>, master: Master) {
        var potentialWords: List<String> = words.toList()
        while (potentialWords.isNotEmpty()) {
            var bestWord = potentialWords[0]
            var lowest = potentialWords.size

            for (word in potentialWords) {
                val groups = potentialWords.groupBy { getSimilarityScore(it, word) }
                // get the worst case scenario
                val groupWithHighestPossibility = groups.values.maxOf { it.size }

                // find the best among the worst
                if (groupWithHighestPossibility < lowest) {
                    lowest = groupWithHighestPossibility
                    bestWord = word
                }
            }

            val similarity = master.guess(bestWord)
            if (similarity == 6) return

            potentialWords = potentialWords.filter { getSimilarityScore(bestWord, it) == similarity }
        }
    }

    private fun getSimilarityScore(a: String, b: String): Int {
        var result = 0
        for (i in 0 until a.length) {
            result += if (a[i] == b[i]) 1 else 0
        }
        return result
    }
}
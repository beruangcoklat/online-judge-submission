class Solution {
    fun maxProfit(prices: IntArray): Int {
        var totalGain = 0
        var idx = 0
        while (true) {
            while (idx + 1 < prices.size && prices[idx + 1] <= prices[idx]) {
                idx++
            }
            val lowestIdx = idx

            while (idx + 1 < prices.size && prices[idx + 1] >= prices[idx]) {
                idx++
            }
            val highestIdx = idx

            if (prices[highestIdx] > prices[lowestIdx]) {
                totalGain += prices[highestIdx] - prices[lowestIdx]
            } else break
        }
        return totalGain
    }
}
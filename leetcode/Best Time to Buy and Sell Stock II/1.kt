class Solution {
    fun maxProfit(prices: IntArray): Int {
        var hold: Int? = null
        var totalGain = 0
        for (i in 0 until prices.size) {
            if (hold != null && prices[i] > hold) {
                val gain = prices[i] - hold
                hold = null
                totalGain += gain
            }

            if (hold == null && i + 1 < prices.size && prices[i + 1] > prices[i]) {
                hold = prices[i]
            }
        }
        return totalGain
    }
}
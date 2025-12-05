class Solution {
    fun maxProfit(prices: IntArray): Int {
        val maxFromRight = IntArray(prices.size) { -1 }
        maxFromRight[prices.size - 1] = prices[prices.size - 1]

        for (i in prices.size - 2 downTo 0) {
            maxFromRight[i] = if (maxFromRight[i + 1] > prices[i]) maxFromRight[i + 1] else prices[i]
        }

        var maxGain = 0
        for (i in 0 until prices.size - 1) {
            val gain = maxFromRight[i + 1] - prices[i]
            maxGain = if (gain > maxGain) gain else maxGain
        }
        return maxGain
    }
}
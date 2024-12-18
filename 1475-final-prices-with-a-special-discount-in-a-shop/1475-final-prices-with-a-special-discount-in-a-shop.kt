class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        return prices.mapIndexed { index, price ->
            var discountPrice = price
            for (j in index + 1 until prices.size) {
                if (prices[j] <= price) {
                    discountPrice -= prices[j]
                    break
                }
            }
            return@mapIndexed discountPrice
        }.toIntArray()
    }
}
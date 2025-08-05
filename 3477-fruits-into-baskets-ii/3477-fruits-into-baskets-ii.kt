class Solution {
    fun numOfUnplacedFruits(
        fruits: IntArray,
        baskets: IntArray,
    ): Int {
        var remained = 0
        val basketsList = baskets.toMutableList()
        fruits.forEach {
            val find =
                basketsList
                    .find { basket -> basket >= it }
                    .also { basketsList.remove(it) }
            if (find == null) {
                remained += 1
            }
        }
        
        return remained
    }
}

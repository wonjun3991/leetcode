class Solution {
    fun numOfUnplacedFruits(
        fruits: IntArray,
        baskets: IntArray,
    ): Int {
        var max = Int.MAX_VALUE
        var remained = 0
        var lastIndex = 0
        var lastFruit = 0
        val basketsList = baskets.toMutableList()
        fruits.forEach {
            if (it >= max) {
                remained += 1
                return@forEach
            }

            if (it < lastFruit) {
                for (i in 0 until lastIndex) {
                    if (basketsList[i] >= it) {
                        basketsList.removeAt(i)
                        lastIndex = i
                        lastFruit = it
                        return@forEach
                    }
                }
                for (j in lastIndex until basketsList.size) {
                    if (basketsList[j] >= it) {
                        basketsList.removeAt(j)
                        lastIndex = j
                        lastFruit = it
                        return@forEach
                    }
                }
            } else {
                for (j in lastIndex until basketsList.size) {
                    if (basketsList[j] >= it) {
                        basketsList.removeAt(j)
                        lastIndex = j
                        lastFruit = it
                        return@forEach
                    }
                }
                for (i in 0 until lastIndex) {
                    if (basketsList[i] >= it) {
                        basketsList.removeAt(i)
                        lastIndex = i
                        lastFruit = it
                        return@forEach
                    }
                }
            }
            remained += 1
            max = it
        }

        return remained
    }
}

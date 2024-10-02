class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val ranking: MutableMap<Int, Int> = mutableMapOf()

        var count = 1
        arr.sortedArray().forEach {
            if (ranking.containsKey(it)) {
                return@forEach
            }
            ranking[it] = count++
        }



        return arr.map { ranking[it]!! }.toIntArray()
    }
}
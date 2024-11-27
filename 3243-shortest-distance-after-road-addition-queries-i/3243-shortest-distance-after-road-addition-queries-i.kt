import kotlin.math.min

class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val pathMap = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0..<n -1) {
            pathMap[i] = mutableListOf(i + 1)
        }

        return queries.map {
            pathMap.getOrDefault(it[0], mutableListOf()).add(it[1])
            return@map getShortestDistance(pathMap, n)
        }.toIntArray()
    }

    fun getShortestDistance(pathMap: MutableMap<Int, MutableList<Int>>, destination: Int): Int {
        val distanceArray = IntArray(destination) { Int.MAX_VALUE }
        distanceArray[0] = 0

        for (i in 0..<destination) {
            val pathList = pathMap.getOrDefault(i, mutableListOf())
            pathList.forEach {
                distanceArray[it] = min(distanceArray[i] + 1 , distanceArray[it])
            }
        }

        return distanceArray[destination - 1]
    }
}
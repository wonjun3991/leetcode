import java.util.*
import kotlin.math.min


class Solution {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val minCost = Array(n) { Long.MAX_VALUE }
        val pathCount = Array(n) { 0 }
        val adjacencyList = Array<MutableList<Pair<Int, Long>>>(n) { mutableListOf() }

        roads.forEach {
            adjacencyList[it[0]].add(Pair(it[1], it[2].toLong()))
            adjacencyList[it[1]].add(Pair(it[0], it[2].toLong()))
        }

        val pq = PriorityQueue<Pair<Int,Long>>(compareBy{it.second})

        pq.add(Pair(0, 0))
        minCost[0] = 0
        pathCount[0] = 1
        while (pq.isNotEmpty()) {
            val current = pq.poll()

            if(current.second > minCost[current.first]) {
                continue
            }

            adjacencyList[current.first].forEach{
                if(current.second + it.second < minCost[it.first]){
                    minCost[it.first] = current.second + it.second
                    pathCount[it.first] = pathCount[current.first]
                    pq.add(Pair(it.first, it.second + current.second))
                } else if(current.second + it.second == minCost[it.first]){
                    pathCount[it.first] = (pathCount[it.first] + pathCount[current.first]) % mod
                }
            }
        }

        return pathCount[n-1]
    }
}
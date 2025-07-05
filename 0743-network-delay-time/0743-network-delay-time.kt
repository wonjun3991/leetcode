import java.util.*
import kotlin.math.max

class Solution {
    fun networkDelayTime(
        times: Array<IntArray>,
        n: Int,
        k: Int,
    ): Int {
        val adj = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        // adj[k] = [(2,5), (3,5)]
        times.forEach {
            adj.getOrPut(it[0]) { mutableListOf() }.add(Pair(it[1], it[2]))
        }

        val distance = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        distance[k] = 0
        adj.getOrDefault(k, mutableListOf()).forEach {
            pq.add(it)
        }

        while (pq.isNotEmpty()) {
            val current = pq.poll()
            val end = current.first
            val dis = current.second

            if (distance[end] <= dis) {
                continue
            }

            distance[end] = dis
            adj.getOrDefault(end, mutableListOf()).forEach {
                pq.add(Pair(it.first, dis + it.second))
            }
        }

        var result = 0
        for (i in 1..n) {
            result = max(result, distance[i])
        }

        if (result == Int.MAX_VALUE) {
            return -1
        }

        return result
    }
}

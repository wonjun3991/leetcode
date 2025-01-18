import java.util.*

class Solution {
    fun minCost(grid: Array<IntArray>): Int {
        val rowSize = grid.size
        val colSize = grid[0].size
        val edge = mapOf(1 to Pair(0, 1), 2 to Pair(0, -1), 3 to Pair(1, 0), 4 to Pair(-1, 0))
        val shortDistance = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE } }

        val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>> { o1, o2 -> o1.second - o2.second }
        pq.add(Pair(Pair(0, 0), 0))
        while (!pq.isEmpty()) {
            val curQueue = pq.poll()
            val current: Pair<Int, Int> = curQueue.first
            val curDistance = curQueue.second
            if (curQueue.second < shortDistance[current.first][current.second]) {
                shortDistance[current.first][current.second] = curQueue.second
                edge.forEach { (key: Int, xy: Pair<Int, Int>) ->
                    val distance = if (key == grid[current.first][current.second]) 0 else 1
                    val to = Pair(current.first + xy.first, current.second + xy.second)
                    if (isValid(to, rowSize, colSize)) {
                        pq.add(Pair(to, curDistance + distance))
                    }
                }
            }
        }

        return shortDistance[grid.size - 1][grid[0].size - 1]
    }

    fun isValid(to: Pair<Int, Int>, rowSize: Int, colSize: Int): Boolean {
        if (to.first >= rowSize || to.first < 0) {
            return false
        }

        if (to.second >= colSize || to.second < 0) {
            return false
        }

        return true
    }
}
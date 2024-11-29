import java.util.*
import kotlin.math.max

class Solution {
    val directions: Array<Pair<Int, Int>> = arrayOf(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, -1),
        Pair(0, 1),
    )

    fun minimumTime(grid: Array<IntArray>): Int {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1
        }

        val rowSize = grid.size
        val colSize = grid[0].size

        val visited: Array<BooleanArray> = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        val pq = PriorityQueue<Pair<Int, Pair<Int, Int>>> { a, b -> a.first - b.first }

        pq.add(Pair(0, Pair(0, 0)))

        while (!pq.isEmpty()) {
            val mostPq = pq.poll()
            val current: Pair<Int, Int> = mostPq.second
            val minTime: Int = mostPq.first

            if (current.first == rowSize - 1 && current.second == colSize - 1) {
                return minTime
            }

            if (visited[current.first][current.second]) {
                continue
            }

            visited[current.first][current.second] = true

            directions.forEach {
                val row = current.first + it.first
                val col = current.second + it.second

                if (row >= rowSize || row < 0) {
                    return@forEach
                }

                if (col >= colSize || col < 0) {
                    return@forEach
                }

                if (visited[row][col]) {
                    return@forEach
                }

                val waitTime = if ((grid[row][col] - minTime) % 2 == 0) 1 else 0
                val nextTime = max(grid[row][col] + waitTime, minTime + 1)
                pq.add(Pair(nextTime, Pair(row, col)))
            }
        }

        return -1
    }
}
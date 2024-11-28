import java.util.*

class Solution {
    private val directions: Array<Pair<Int, Int>> = arrayOf(
        Pair(0, -1),
        Pair(0, 1),
        Pair(-1, 0),
        Pair(1, 0),
    )

    fun minimumObstacles(grid: Array<IntArray>): Int {
        val rowSize = grid.size
        val colSize = grid[0].size

        val minObstacles: Array<IntArray> = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE } }
        val pq = PriorityQueue<Pair<Int, Pair<Int, Int>>> { o1, o2 -> o1.first.compareTo(o2.first) }

        minObstacles[0][0] = grid[0][0]
        pq.add(Pair(minObstacles[0][0], Pair(0, 0)))

        while (pq.isNotEmpty()) {
            val currentQueue = pq.poll()
            val obstacles: Int = currentQueue.first
            val current: Pair<Int, Int> = currentQueue.second

            if (current.first == grid.size - 1 && current.second == grid[0].size - 1) {
                return obstacles
            }

            this.directions.forEach {
                val nextRow = current.first + it.first
                val nextColumn = current.second + it.second


                if (nextRow >= rowSize || nextRow < 0) {
                    return@forEach
                }

                if (nextColumn >= colSize || nextColumn < 0) {
                    return@forEach
                }
                val nextMinObstacles = obstacles + grid[nextRow][nextColumn]

                if (nextMinObstacles < minObstacles[nextRow][nextColumn]) {
                    minObstacles[nextRow][nextColumn] = nextMinObstacles
                    pq.add(Pair(nextMinObstacles, Pair(nextRow, nextColumn)))
                }
            }
        }
        return minObstacles[rowSize - 1][colSize - 1]
    }
}
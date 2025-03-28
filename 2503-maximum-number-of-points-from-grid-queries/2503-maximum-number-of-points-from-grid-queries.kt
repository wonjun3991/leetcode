import java.util.*

class Solution {
    private val directions = arrayOf(Pair(0, -1), Pair(0, 1), Pair(1, 0), Pair(-1, 0))

    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val pq = PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy { it.first })
        val visited = mutableSetOf<Pair<Int, Int>>()
        val sortedQueries = queries.sorted()
        val queryToSortedMap = mutableMapOf<Int, Int>()

        pq.add(Pair(grid[0][0], Pair(0, 0)))

        sortedQueries.forEach { query ->
            while(pq.peek() != null && pq.peek().first < query){
                val current = pq.poll().second

                if (visited.contains(current)) {
                    continue
                }

                visited.add(current)

                directions.forEach {
                    val row = current.first + it.first
                    val col = current.second + it.second

                    if (row >= grid.size || row < 0) {
                        return@forEach
                    }

                    if (col >= grid[0].size || col < 0) {
                        return@forEach
                    }

                    pq.add(Pair(grid[row][col], Pair(row, col)))
                }
            }
            queryToSortedMap[query] = visited.size
        }

        return queries.map { queryToSortedMap[it]!! }.toIntArray()
    }
}
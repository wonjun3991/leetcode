import kotlin.math.max

class Solution {
    private val directions: Array<Pair<Int, Int>> = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

    fun findMaxFish(grid: Array<IntArray>): Int {
        var maxFish = 0
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }

        grid.indices.forEach { row ->
            grid[row].indices.forEach { col ->
                maxFish = max(maxFish, dfs(grid, visited, Pair(row, col)))
            }
        }

        return maxFish
    }

    private fun dfs(grid: Array<IntArray>, visited: Array<BooleanArray>, current: Pair<Int, Int>): Int {
        if(current.first < 0 || current.first >= grid.size || current.second < 0 || current.second >= grid[0].size){
            return 0
        }

        if (visited[current.first][current.second]) {
            return 0
        }
        
        if(grid[current.first][current.second] == 0) {
            return 0
        }

        visited[current.first][current.second] = true

        return directions.sumOf {
            dfs(grid, visited, Pair(current.first + it.first, current.second + it.second))
        } + grid[current.first][current.second]
    }
}
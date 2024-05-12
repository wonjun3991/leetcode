class Solution {
    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val directions = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 0,0 to 1, 1 to -1, 1 to 0, 1 to 1)


        val result = Array<IntArray>(grid.size - 2) { intArrayOf() }
        for(i in 1 until grid.size- 1){
            println("i $i")
            val rows = IntArray(grid.size - 2){0}
            for(j in 1 until grid.size - 1){
                println("j $j")
                rows[j - 1] = directions.map { grid[i + it.first][j + it.second] }.max()
            }
            result[i - 1] = rows
        }

        return result
    }
}

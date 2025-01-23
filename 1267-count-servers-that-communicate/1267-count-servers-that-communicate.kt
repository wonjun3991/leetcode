class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val rowSize = grid.size
        val colSize = grid[0].size

        val connectedMap =  Array(rowSize) { BooleanArray(colSize){false} }
        var count= 0

        grid.forEachIndexed { row, array ->
            val rows = mutableListOf<Pair<Int, Int>>()
            array.forEachIndexed { col, value ->
                if(value == 1){
                    rows.add(Pair(row, col))
                }
            }
            if(rows.size >= 2){
                rows.forEach {
                    connectedMap[it.first][it.second] = true
                    count++
                }
            }
        }

        grid[0].forEachIndexed { col, heights ->
            val cols = mutableListOf<Pair<Int, Int>>()
            for(row in 0 until rowSize){
                if(grid[row][col] == 1){
                    cols.add(Pair(row, col))
                }
            }
            if(cols.size >= 2){
                cols.forEach {
                    if(connectedMap[it.first][it.second] == false){
                        count++
                    }
                }
            }
        }

        return count
    }

}
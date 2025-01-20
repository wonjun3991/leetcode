class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val locationMap = mutableMapOf<Int, Pair<Int, Int>>()
        mat.forEachIndexed { i, row ->
            row.forEachIndexed { j, value -> locationMap[value] = Pair(i, j) }
        }
        val rowMap = Array(mat.size) { BooleanArray(mat[0].size) { false } }
        val colMap = Array(mat[0].size) { BooleanArray(mat.size) { false } }

        arr.forEachIndexed{ index, value ->
            val location: Pair<Int, Int> = locationMap[value]!!
            rowMap[location.first][location.second] = true
            if(rowMap[location.first].all { it }){
                return index
            }
            colMap[location.second][location.first] = true
            if(colMap[location.second].all { it }){
                return index
            }
        }

        return 0
    }
}
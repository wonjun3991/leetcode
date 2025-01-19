import java.util.*
import kotlin.math.max

internal class Solution {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val directions: Array<Pair<Int, Int>> = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        val rowSize = heightMap.size
        val colSize = heightMap[0].size

        val visited = Array(rowSize) { BooleanArray(colSize) { false } }
        val boundary = PriorityQueue<Pair<Pair<Int, Int>, Int>>() { q1, q2 -> q1.second - q2.second }

        for (i in 0 until rowSize) {
            boundary.offer(Pair(Pair(i, 0), heightMap[i][0]))
            boundary.offer(Pair(Pair(i, colSize - 1), heightMap[i][colSize - 1]))
            visited[i][colSize - 1] = true
            visited[i][0] = true
        }

        for (i in 0 until colSize) {
            boundary.offer(Pair(Pair(0, i), heightMap[0][i]))
            boundary.offer(Pair(Pair(rowSize - 1, i), heightMap[rowSize - 1][i]))
            visited[rowSize - 1][i] = true
            visited[0][i] = true
        }

        var totalWaterVolume = 0

        while (!boundary.isEmpty()) {
            val currentCell = boundary.poll()

            val currentRow = currentCell.first.first
            val currentCol = currentCell.first.second
            val minBoundaryHeight = currentCell.second

            for (direction in directions) {
                val neighborRow = currentRow + direction.first
                val neighborCol = currentCol + direction.second

                if (isValidCell(neighborRow, neighborCol, rowSize, colSize) && !visited[neighborRow][neighborCol]) {
                    val neighborHeight = heightMap[neighborRow][neighborCol]
                    if (neighborHeight < minBoundaryHeight) {
                        totalWaterVolume += minBoundaryHeight - neighborHeight
                    }
                    val maxHeight = max(neighborHeight, minBoundaryHeight)
                    val nextBoundary = Pair(Pair(neighborRow, neighborCol), maxHeight)

                    boundary.offer(nextBoundary)
                    visited[neighborRow][neighborCol] = true
                }
            }
        }
        return totalWaterVolume
    }

    private fun isValidCell(row: Int, col: Int, numOfRows: Int, numOfCols: Int): Boolean {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols
    }
}
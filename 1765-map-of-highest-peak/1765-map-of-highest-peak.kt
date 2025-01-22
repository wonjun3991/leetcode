class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val direction = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
        var count = 0

        val rowSize = isWater.size
        val colSize = isWater[0].size
        val highestPeak = Array(rowSize) { IntArray(colSize) { Integer.MIN_VALUE } }

        isWater.forEachIndexed { row, array ->
            array.forEachIndexed { col, int ->
                if (int == 1) queue.add(Pair(row, col))
            }
        }

        while (queue.isNotEmpty()) {

            val nextQueue: MutableList<Pair<Int, Int>> = mutableListOf()

            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                if(highestPeak[current.first][current.second] != Integer.MIN_VALUE) {
                    continue
                }
                highestPeak[current.first][current.second] = count

                direction.forEach {
                    val nextRow = current.first + it.first
                    val nextCol = current.second + it.second
                    if (isValid(
                            nextRow,
                            nextCol,
                            rowSize,
                            colSize
                        ) && highestPeak[nextRow][nextCol] == Integer.MIN_VALUE
                    ) {
                        nextQueue.add(Pair(nextRow, nextCol))
                    }
                }
            }

            if (nextQueue.isNotEmpty()) {
                queue.addAll(nextQueue)
                count++
            }
        }

        return highestPeak
    }

    fun isValid(row: Int, col: Int, rowSize: Int, colSize: Int): Boolean {
        if (row < 0 || col < 0) {
            return false
        }
        if (row >= rowSize || col >= colSize) {
            return false
        }
        return true
    }
}
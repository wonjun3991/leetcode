class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) {
            return emptyList()
        }
        val pascalsTriangle = mutableListOf(listOf(1))
        for (i in 1 until numRows) {
            val context = pascalsTriangle[i - 1]
            val newTriangle = mutableListOf<Int>()
            context.fold(0) { acc, number ->
                newTriangle.add(acc + number)
                return@fold  number
            }
            newTriangle.add(1)
            pascalsTriangle.add(newTriangle)
        }
        return pascalsTriangle
    }
}

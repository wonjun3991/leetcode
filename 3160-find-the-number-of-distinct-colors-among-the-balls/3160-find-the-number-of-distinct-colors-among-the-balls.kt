class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val ballColorMap = HashMap<Int,Int>()
        val colorCountMap = HashMap<Int, Int>()
        var count = 0

        return queries.map {

            if(ballColorMap.containsKey(it[0])) {
                val prevColor: Int = ballColorMap[it[0]]!!
                if(colorCountMap[prevColor] == 1){
                    colorCountMap.remove(prevColor)
                    count--
                } else{
                    colorCountMap[prevColor] = colorCountMap[prevColor]!! - 1
                }
            }
            ballColorMap[it[0]] = it[1]
            val beforeColorCount = colorCountMap.getOrDefault(it[1], 0)
            colorCountMap[it[1]] = beforeColorCount + 1
            if(beforeColorCount == 0) count++
            return@map count
        }.toIntArray()
    }
}
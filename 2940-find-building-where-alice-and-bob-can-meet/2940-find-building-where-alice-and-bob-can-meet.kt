import java.util.*
import kotlin.math.max

class Solution {
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val storeQueries: MutableList<MutableList<List<Int>>> = ArrayList(
            heights.size
        )
        for (i in heights.indices) storeQueries.add(
            ArrayList()
        )
        val maxIndex = PriorityQueue { a: List<Int>, b: List<Int> ->
            a[0] - b[0]
        }
        val result = IntArray(queries.size)
        Arrays.fill(result, -1)

        for (currQuery in queries.indices) {
            val a = queries[currQuery][0]
            val b = queries[currQuery][1]
            if (a < b && heights[a] < heights[b]) {
                result[currQuery] = b
            } else if (a > b && heights[a] > heights[b]) {
                result[currQuery] = a
            } else if (a == b) {
                result[currQuery] = a
            } else {
                storeQueries[max(a, b)]
                    .add(
                        Arrays.asList(
                            max(heights[a], heights[b]),
                            currQuery
                        )
                    )
            }
        }

        for (index in heights.indices) {
            while (!maxIndex.isEmpty() && maxIndex.peek()[0] < heights[index]
            ) {
                result[maxIndex.peek()[1]] = index
                maxIndex.poll()
            }
            
            for (element in storeQueries[index]) {
                maxIndex.offer(element)
            }
        }
        return result
    }
}
import kotlin.math.max

class Solution {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        val prefixSumArray = IntArray(nums.size + 1) { 0 }
        var sum = 0
        var queryCount = 0

        nums.forEachIndexed { index, num ->

            while (sum + prefixSumArray[index] < nums[index]) {
                queryCount++

                if (queryCount > queries.size) {
                    return -1
                }

                val query = queries[queryCount - 1]
                
                if(query[1] >= index){
                    prefixSumArray[max(index, query[0])] += query[2]
                    prefixSumArray[query[1] + 1] -= query[2]
                }
            }
            sum += prefixSumArray[index]    
        }

        return queryCount
    }
}
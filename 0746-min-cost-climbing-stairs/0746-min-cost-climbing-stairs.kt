import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val size = cost.size

        if (size == 0) {
            return 0
        }

        val dynamicTable = IntArray(cost.size + 1)

        dynamicTable[size] = 0
        dynamicTable[size - 1] = cost[size - 1]

        for (i in size - 2 downTo 0) {
            dynamicTable[i] = min(
                dynamicTable[i + 1] + cost[i],
                dynamicTable[i + 2] + cost[i]
            )
        }
        return min(dynamicTable[0], dynamicTable[1])
    }
}
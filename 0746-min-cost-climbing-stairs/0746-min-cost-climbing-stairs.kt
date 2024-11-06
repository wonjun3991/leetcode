import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val N = cost.size

        if (N == 0) {
            return 0
        }

        val maxRobbedAmount = IntArray(cost.size + 1)

        maxRobbedAmount[N] = 0
        maxRobbedAmount[N - 1] = cost[N - 1]

        for (i in N - 2 downTo 0) {
            maxRobbedAmount[i] = min(
                maxRobbedAmount[i + 1] + cost[i],
                maxRobbedAmount[i + 2] + cost[i]
            )
        }
        return min(maxRobbedAmount[0], maxRobbedAmount[1])
    }
}
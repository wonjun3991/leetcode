import java.util.*

class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val heap = PriorityQueue(compareBy<Pair<Int, Int>>({ it.first }, { it.second }))
        var k = k

        nums.forEachIndexed { index: Int, num: Int ->
            heap.add(Pair(num, index))
        }

        while (k-- > 0) {
            val current = heap.poll()
            val multiply = current.first * multiplier
            heap.add(Pair(multiply, current.second))
            nums[current.second] = multiply
        }

        return nums
    }
}
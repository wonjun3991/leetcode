import java.util.PriorityQueue

class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Long>()
        var count = 0

        nums.forEach { pq.add(it.toLong()) }
        
        while (pq.peek() != null && pq.peek() < k) {
            if (pq.count() < 2) {
                return count
            }
            val first = pq.poll()
            val second = pq.poll()

            pq.add(first * 2 + second)
            count++
        }
        return count
    }
}
import java.util.*
import kotlin.math.max

class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val pq = PriorityQueue<Pair<Int,Int>>{ o1, o2 -> o1.first.compareTo(o2.first)}
        val sortedEvents = events.sortedBy { it[0] }

        var maxValue = 0
        var maxSum = 0


        sortedEvents.forEach { event ->
            while(!pq.isEmpty() && pq.peek().first < event[0]){
                maxValue = max(maxValue, pq.peek().second)
                pq.poll()
            }
            maxSum = max(maxSum, maxValue + event[2])
            pq.add(Pair(event[1],event[2]))
        }
        return maxSum
    }
}

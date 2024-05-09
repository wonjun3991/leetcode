import java.util.PriorityQueue

class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int> { a, b -> b.compareTo(a) }
        happiness.forEach { pq.add(it) }
        var sum = 0L
        for(i in 0 until k){
            val poll = pq.poll()
            if(poll - i < 0){
                continue
            }
            sum = sum + poll - i
        }

        return sum
    }
}

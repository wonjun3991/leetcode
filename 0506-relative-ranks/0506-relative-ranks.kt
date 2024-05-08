import java.util.*

class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val pq = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
        val list = ArrayDeque(listOf("Gold Medal", "Silver Medal", "Bronze Medal"))

        val map: MutableMap<Int, String> = mutableMapOf()
        score.forEach {
            pq.add(it)
        }

        var count = 1

        while (pq.isNotEmpty()) {
            map.set(pq.poll(), if(count <= 3) list.removeFirst() else count.toString())
            count += 1
        }

        return score.map { map.get(it).toString() }.toTypedArray()
    }
}

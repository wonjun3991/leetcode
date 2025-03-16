import java.util.*

class Solution {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        val pq = PriorityQueue<Pair<Int, Pair<Int, Long>>> { o1, o2 ->
            val o1Value = nextValue(o1.first, o1.second.first + 1)
            val o2Value = nextValue(o2.first, o2.second.first + 1)
            return@PriorityQueue o1Value.compareTo(o2Value)
        }

        ranks.sortedDescending().forEach {
            println(it)
            pq.add(Pair(it, Pair(0, 0L)))
        }

        for (i in 0 until cars) {
            val curr = pq.poll()
            val carCount = curr.second.first + 1
            pq.add(Pair(curr.first, Pair(carCount, curr.first.toLong() * carCount * carCount)))
        }

        println("pq")
        println(pq)

        return pq.last().second.second
    }

    fun nextValue(rank:Int, nextCount:Int) = rank.toLong() * nextCount * nextCount
}
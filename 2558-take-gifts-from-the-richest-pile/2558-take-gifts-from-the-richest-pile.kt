import java.util.*
import kotlin.math.sqrt


class Solution {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue<Long>{ o1, o2 -> (o2 - o1).toInt() }
        gifts.forEach {
            pq.offer(it.toLong())
        }

        for (i in 0 until k){
            val max = pq.poll()
            println(max)
            pq.offer(sqrt(max.toDouble()).toLong())
        }

        return pq.sum().toLong()
    }
}
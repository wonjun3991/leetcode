import java.util.PriorityQueue

class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val pq = PriorityQueue<Pair<Int, Int>>
        { a, b -> (a.first * b.second).compareTo(a.second * b.first ) }

        for(i in arr.indices){
            for(j in i + 1 until arr.size){
                pq.add(arr[i] to arr[j])
            }
        }
        var count = k
        while(count != 1) {
            pq.poll()
            count = count - 1
        }

        val poll = pq.poll()

        return intArrayOf(poll.first, poll.second)
    }
}

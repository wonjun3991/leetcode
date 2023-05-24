class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val pairs = emptyList<Pair<Int, Int>>().toMutableList()

        for (i in nums1.indices) {
            pairs.add(Pair(nums1[i], nums2[i]))
        }
        pairs.sortWith(Comparator { a, b ->  b.second - a.second})

        val topKHeap = PriorityQueue<Int>(k, Comparator { a, b -> a - b })
        var topKSum = 0L;

        for(i in (0 until k)){
            topKSum += pairs[i].first
            topKHeap.add(pairs[i].first)
        }

        var answer = topKSum  * pairs[k - 1].second.toLong()

        for(i in (k until nums1.size)){
            topKSum += pairs[i].first - topKHeap.poll()
            topKHeap.add(pairs[i].first)

            answer = answer.coerceAtLeast(topKSum * pairs[i].second.toLong())
        }

        return answer
    }
}
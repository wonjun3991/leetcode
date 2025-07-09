class Solution {
    fun maxFreeTime(
        eventTime: Int,
        k: Int,
        startTime: IntArray,
        endTime: IntArray,
    ): Int {
        val counts = mutableListOf<Int>()
        counts.add(startTime.first() - 0)
        for (i in 0 until endTime.size - 1) {
            counts.add(startTime[i + 1] - endTime[i])
        }
        counts.add(eventTime - endTime.last())

        var max = 0
        for (i in 0 until counts.size - k) {
            max = maxOf(max, counts.slice(i .. i + k).sum())
        }

        return max
    }
}

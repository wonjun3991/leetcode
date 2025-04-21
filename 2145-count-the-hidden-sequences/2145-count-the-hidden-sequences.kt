class Solution {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var current = 0L
        var min = 0L
        var max = 0L
        differences.forEach {
            current += it
            if (current < min) {
                min = current
            }
            if (current > max) {
                max = current
            }
        }
        val prefix = (upper - max)
        max = max + prefix
        min = min + prefix
        var count = 0

        while (min >= lower && max <= upper) {
            count+=1
            max -= 1
            min -= 1
        }
        return count
    }
}
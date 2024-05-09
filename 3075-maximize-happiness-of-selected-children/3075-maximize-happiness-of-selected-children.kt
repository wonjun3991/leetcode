
class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sort()
        val n = happiness.size
        var i = n - 1
        var sum = 0L

        while (i >= 0) {
            val offset = n - 1 - i

            val score = maxOf(0, (happiness[i] - offset))
            sum += score

            val collected = n - i
            if (score == 0 || collected == k) break //we cannot score more, lower elements will be 0 only

            i--
        }

        return sum
    }
}

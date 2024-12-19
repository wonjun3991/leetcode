import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        val n = arr.size
        val prefixMax = arr.clone()
        val suffixMin = arr.clone()

        for (i in 1 until n) {
            prefixMax[i] = max(prefixMax[i - 1], prefixMax[i])
        }

        for (i in n - 2 downTo 0) {
            suffixMin[i] = min(suffixMin[i + 1], suffixMin[i])
        }

        var chunks = 0
        for (i in 0 until n) {
            if (i == 0 || suffixMin[i] > prefixMax[i - 1]) {
                chunks++
            }
        }

        return chunks
    }
}
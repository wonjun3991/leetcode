
import java.util.*

internal class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        // Create a priority queue to store pairs of fractions
        var k = k
        val pq = PriorityQueue { a: DoubleArray, b: DoubleArray ->
            java.lang.Double.compare(
                b[0],
                a[0]
            )
        }

        // Push the fractions formed by dividing each element by
        // the largest element into the priority queue
        for (i in arr.indices) {
            pq.offer(
                doubleArrayOf(
                    -1.0 * arr[i] / arr[arr.size - 1],
                    i.toDouble(),
                    (arr.size - 1).toDouble()
                )
            )
        }

        // Iteratively remove the top element (smallest fraction) 
        // and replace it with the next smallest fraction
        while (--k > 0) {
            val cur = pq.poll()
            val numeratorIndex = cur[1].toInt()
            val denominatorIndex = cur[2].toInt() - 1
            if (denominatorIndex > numeratorIndex) {
                pq.offer(
                    doubleArrayOf(
                        -1.0 * arr[numeratorIndex] / arr[denominatorIndex],
                        numeratorIndex.toDouble(),
                        denominatorIndex.toDouble()
                    )
                )
            }
        }

        // Retrieve the kth smallest fraction from 
        // the top of the priority queue
        val result = pq.poll()
        return intArrayOf(arr[result[1].toInt()], arr[result[2].toInt()])
    }
}
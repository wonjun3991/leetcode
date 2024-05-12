import java.util.*

internal class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size
        var totalCost = Double.MAX_VALUE
        var currentTotalQuality = 0.0
        val wageToQualityRatio: MutableList<Pair<Double, Int>> = ArrayList()

        // Calculate wage-to-quality ratio for each worker
        for (i in 0 until n) {
            wageToQualityRatio.add(
                Pair(wage[i].toDouble() / quality[i], quality[i])
            )
        }

        // Sort workers based on their wage-to-quality ratio
        Collections.sort(
            wageToQualityRatio,
            Comparator.comparingDouble<Pair<Double, Int>> { it.first }
        )

        // Use a priority queue to keep track of the highest quality workers
        val highestQualityWorkers = PriorityQueue(
            Collections.reverseOrder<Int>()
        )

        // Iterate through workers
        for (i in 0 until n) {
            highestQualityWorkers.add(wageToQualityRatio[i].second)
            currentTotalQuality += wageToQualityRatio[i].second

            // If we have more than k workers,
            // remove the one with the highest quality
            if (highestQualityWorkers.size > k) {
                currentTotalQuality -= highestQualityWorkers.poll().toDouble()
            }

            // If we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (highestQualityWorkers.size == k) {
                totalCost = Math.min(
                    totalCost, currentTotalQuality *
                            wageToQualityRatio[i].first
                )
            }
        }
        return totalCost
    }
}

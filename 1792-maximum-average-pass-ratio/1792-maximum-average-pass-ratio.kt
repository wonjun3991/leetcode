import java.util.*

class Solution {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        var extraStudents = extraStudents
        val maxHeap = PriorityQueue<Pair<Double, Pair<Int, Int>>> { o1, o2 -> o2.first.compareTo(o1.first) }

        classes.forEach {
            val pass = it[0]
            val total = it[1]
            val classPair = Pair(pass, total)
            maxHeap.offer(Pair(calculateGain(pass, total), classPair))
        }

        while (extraStudents-- > 0) {
            val current = maxHeap.poll()
            val passes = current.second.first
            val totalStudents = current.second.second
            maxHeap.offer(
                Pair(
                    calculateGain(passes + 1, totalStudents + 1),
                    Pair(
                        passes + 1,
                        totalStudents + 1
                    )
                )
            )
        }

        var totalPassRatio = 0.0
        while (!maxHeap.isEmpty()) {
            val current = maxHeap.poll()
            val passes = current.second.first
            val totalStudents = current.second.second
            totalPassRatio += passes.toDouble() / totalStudents.toDouble()
        }

        return totalPassRatio / classes.size
    }

    private fun calculateGain(pass: Int, total: Int): Double {
        return ((pass + 1).toDouble() / (total + 1) -
                pass.toDouble() / total
                )
    }
}
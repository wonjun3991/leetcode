import java.util.*

internal class Solution {
    fun canChange(start: String, target: String): Boolean {
        val startQueue: Queue<Pair<Char, Int>> = LinkedList()
        val targetQueue: Queue<Pair<Char, Int>> = LinkedList()

        for (i in start.indices) {
            if (start[i] != '_') {
                startQueue.add(Pair(start[i], i))
            }
            if (target[i] != '_') {
                targetQueue.add(Pair(target[i], i))
            }
        }

        if (startQueue.size != targetQueue.size) return false

        while (!startQueue.isEmpty()) {
            val startPair = startQueue.poll()
            val targetPair = targetQueue.poll()

            val startChar: Char = startPair.first
            val startIndex: Int = startPair.second
            val targetChar: Char = targetPair.first
            val targetIndex: Int = targetPair.second

            if (startChar != targetChar ||
                (startChar == 'L' && startIndex < targetIndex) ||
                (startChar == 'R' && startIndex > targetIndex)
            ) {
                return false
            }
        }

        return true
    }
}
class Solution {
    fun matchPlayersAndTrainers(
        players: IntArray,
        trainers: IntArray,
    ): Int {
        val trainersQueue = trainers.sortedArray().toMutableList()
        var count = 0
        players.forEach { player ->
            val matchedTrainer = trainersQueue.find { it >= player }
            if (matchedTrainer != null) {
                trainersQueue.remove(matchedTrainer)
                count++
            }
        }

        return count
    }
}

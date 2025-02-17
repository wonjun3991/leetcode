internal class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val sequences: MutableSet<String> = HashSet()
        val len = tiles.length
        val used = BooleanArray(len)
        
        generateSequences(tiles, "", used, sequences)
        
        return sequences.size - 1
    }

    fun generateSequences(
        tiles: String,
        current: String,
        used: BooleanArray,
        sequences: MutableSet<String>
    ) {
        sequences.add(current)
        
        for (pos in 0 until tiles.length) {
            if (!used[pos]) {
                used[pos] = true
                generateSequences(
                    tiles,
                    current + tiles[pos],
                    used,
                    sequences
                )
                used[pos] = false
            }
        }
    }
}
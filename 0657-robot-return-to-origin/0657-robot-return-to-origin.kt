class Solution {
    fun judgeCircle(moves: String): Boolean {
        var r = 0
        var c = 0
        moves.forEach {ch ->
          when (ch) {
            'R' -> c++
            'L' -> c--
            'U' -> r--
            'D' -> r++
          }
        }
        return r == 0 && c == 0
    }
}
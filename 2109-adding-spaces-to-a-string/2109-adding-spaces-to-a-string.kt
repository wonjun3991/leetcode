class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        val sb = StringBuilder()
        var cursor = 0

        s.forEachIndexed { index, c ->
            if (cursor < spaces.size && index == spaces[cursor]){
                cursor = cursor + 1
                sb.append(" ")
            }
            sb.append(c)
        }
        return sb.toString()
    }
}
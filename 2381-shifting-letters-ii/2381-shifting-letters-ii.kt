class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val chars = s.toCharArray()

        shifts.forEach {
            for(i in it[0] .. it[1]){
                if (it[2] == 0) {
                    chars[i] = chars[i].minus(1)
                }
                if (it[2] == 1) {
                    chars[i] = chars[i].plus(1)
                }
            }
        }

        return chars.joinToString("")
    }
}
internal class Solution {
    fun kthCharacter(
        k: Long,
        operations: IntArray,
    ): Char {
        var k = k
        var ans = 0
        var t: Int
        while (k != 1L) {
            t = 63 - java.lang.Long.numberOfLeadingZeros(k)
            if ((1L shl t) == k) {
                t--
            }
            k = k - (1L shl t)
            if (operations[t] != 0) {
                ans++
            }
        }
        return ('a'.code + (ans % 26)).toChar()
    }
}

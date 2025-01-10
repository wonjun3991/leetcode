
import kotlin.math.max

class Solution {
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String?> {
        val bmax = count("")
        for (b in B) {
            val bCount = count(b)
            for (i in 0..25) bmax[i] = max(bmax[i].toDouble(), bCount[i].toDouble()).toInt()
        }

        val ans: MutableList<String> = ArrayList()
        search@ for (a in A) {
            val aCount = count(a)
            for (i in 0..25) if (aCount[i] < bmax[i]) continue@search
            ans.add(a)
        }

        return ans
    }

    fun count(S: String): IntArray {
        val ans = IntArray(26)
        for (c in S.toCharArray()) ans[c.code - 'a'.code]++
        return ans
    }
}
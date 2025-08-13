import kotlin.math.pow

class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n < 0) {
            return false
        }

        if (n == 1) {
            return true
        }

        val three = 3.toDouble()
        var pow = 1
        var threeOfPower = three.pow(pow).toLong()
        while (threeOfPower <= n) {
            if (threeOfPower.equals(n.toLong())) {
                return true
            }
            pow += 1
            threeOfPower = three.pow(pow).toLong()
        }

        return false
    }
}

class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n < 0) {
            return false
        }
        var num = n
        while (num >= 4) {
            if (num % 4 != 0) {
                return false
            }
            num /= 4
        }

        if (num == 1) {
            return true
        }

        return false
    }
}

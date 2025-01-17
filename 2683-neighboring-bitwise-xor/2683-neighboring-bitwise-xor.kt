class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var bitCount = 0
        for (i in 0 until derived.size - 1) {
            if(derived[i] == 1) bitCount++
        }

        return bitCount % 2 == derived.last()
    }
}
import kotlin.math.pow

class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val booleanArray = BooleanArray(2.0.pow(nums.size).toInt()) { true }

        for (num in nums) {
            booleanArray[num.toInt(2)] = false
        }

        booleanArray.forEachIndexed { index, b ->
            if (b) {
                val binary = index.toString(2)
                if (binary.length < nums.size) {
                    return "0".repeat(nums.size - binary.length) + binary
                }

                return binary
            }
        }

        return ""
    }
}
import kotlin.math.abs

class Solution {
    fun minOperations(boxes: String): IntArray {
        val charArray = boxes.toCharArray()
        val hasBall = mutableListOf<Int>()
        charArray.forEachIndexed { i, c ->
            if (c == '1') {
                hasBall.add(i)
            }
        }

        return charArray.mapIndexed{ i, c ->
            hasBall.sumOf { abs(it - i) }
        }.toIntArray()
    }
}
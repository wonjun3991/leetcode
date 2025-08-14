import kotlin.math.max

class Solution {
    fun largestGoodInteger(num: String): String {
        var maxNumber = -1
        val window = mutableListOf<Int>(num[0].digitToInt(), num[1].digitToInt(), num[2].digitToInt())
        println(window)
        if (window[0] == window[1] && window[1] == window[2]) {
            maxNumber = max(maxNumber, window[0])
        }
        for (i in 3 until num.length) {
            window.removeFirst()
            window.add(num[i].digitToInt())
            println(window)
            if (window[0] == window[1] && window[1] == window[2]) {
                maxNumber = max(maxNumber, window[0])
            }
        }

        if (maxNumber == -1) {
            return ""
        }
        return "${maxNumber}${maxNumber}$maxNumber"
    }
}

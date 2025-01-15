import kotlin.math.max

class Solution {
    fun minimizeXor(num1: Int, num2: Int): Int {
        // int to binary
        var bitCount = Integer.toBinaryString(num2).toCharArray().count { it == '1' }
        val num1Bin = Integer.toBinaryString(num1).toCharArray()
        val zeroIndexes = ArrayDeque<Int>()
        val result = CharArray(num1Bin.size)

        for (i in 0 until num1Bin.size ) {
            if (num1Bin[i] == '1') {
                if(bitCount > 0){
                    result[i] = '1'
                    bitCount--
                } else{
                    result[i] = '0'
                }
            } else{
                zeroIndexes.add(i)
                result[i] = num1Bin[i]
            }
        }
        println(result.joinToString(""))

        while(bitCount > 0 && zeroIndexes.isNotEmpty()){
            val index = zeroIndexes.removeLast()
            result[index] = '1'
            bitCount--
        }
        var resultString = result.joinToString("")
        println(resultString)


        while(bitCount >0){
            resultString = "1$resultString"
            bitCount--
        }

        return resultString.toInt(2)
    }
}
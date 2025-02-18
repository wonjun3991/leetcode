import java.util.*

class Solution {
    fun smallestNumber(pattern: String): String {
        val string = StringBuilder()
        val stack = Stack<Int>()
        for(i in 0 until pattern.length + 1){
            stack.add(i + 1)

            if(pattern.length == i || pattern[i] == 'I'){
                while(stack.isNotEmpty()){
                    string.append(stack.pop())
                }
            }
        }
        return string.toString()
    }
}
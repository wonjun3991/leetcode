import java.util.Stack

class Solution {
    fun clearDigits(s: String): String {
        val stack = Stack<Char>()

        for(char in s.toCharArray()){
            if(char.isDigit()){
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        return stack.joinToString("")
    }
}
class Solution {
    fun checkValidString(s: String): Boolean {
        val stack = Stack<Int>()
        val starStack = Stack<Int>()
        for(i in 0 until s.length){
            if(s[i] == '('){
                stack.push(i)
            }else if(s[i] == '*'){
                starStack.push(i)
            }else{
                if(stack.isEmpty() && starStack.isEmpty()){
                    return false
                }
                if(!stack.isEmpty()){
                    stack.pop()
                }else{
                    starStack.pop()
                }
            }
        }
        while(!stack.isEmpty() && !starStack.isEmpty()){
            if(stack.peek() > starStack.peek()){
                return false
            }
            stack.pop()
            starStack.pop()
        }
        return stack.isEmpty()
    }
}
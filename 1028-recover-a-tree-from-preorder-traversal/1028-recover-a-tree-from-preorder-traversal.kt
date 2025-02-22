class Solution {
    fun recoverFromPreorder(traversal: String): TreeNode {
        val stack = Stack<TreeNode>()
        var index = 0

        while(index < traversal.length) {
            var depth = 0

            // - 일때 depth와 index 증가
            while(index < traversal.length && traversal[index] == '-') {
                depth++
                index++
            }

            // 숫자일 때 계산
            var number = 0
            while(index < traversal.length && traversal[index].isDigit()) {
                number = number * 10 + traversal[index].digitToInt()
                index++
            }

            val node = TreeNode(number)

            while (stack.size > depth) {
                stack.pop()
            }

            if(stack.isNotEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = node
                } else{
                    stack.peek().right = node
                }
            }
            stack.push(node)
        }

        return stack.first()
    }
}
import java.util.Stack

class Solution {
    fun removeNodes(head: ListNode?): ListNode? {
        var current = head
        var stack : Stack<ListNode> = Stack<ListNode>()
        while(current != null){
            stack.push(current)
            current = current.next
        }

        current = stack.pop()
        var maximum = current.`val`
        var resultList = ListNode(maximum) 

        while (stack.isNotEmpty()){
            current = stack.pop()
            if(current.`val` < maximum){
                continue
            }
            
            val newNode = ListNode(current.`val`)
            newNode.next = resultList
            resultList = newNode
            maximum = current.`val`
        }

        return resultList
    }
}
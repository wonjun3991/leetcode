class Solution {
    fun doubleIt(head: ListNode?): ListNode? {
        var current = head
        val nodeList = mutableListOf<ListNode>()

        while(current != null){
            nodeList.add(current)
            current = current.next
        }

        var add: Int = 0
        nodeList.reversed().forEach{
            val double = it.`val` * 2 % 10 + add
            add = (it.`val` * 2) / 10
            it.`val` = double
        }

        if(add != 0){
            val newNode = ListNode(add)
            newNode.next = head
            return newNode
        }

        return head
    }
}

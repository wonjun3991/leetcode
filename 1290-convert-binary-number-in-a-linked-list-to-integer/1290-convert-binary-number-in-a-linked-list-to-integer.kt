class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        val list = mutableListOf<Int>()
        var current = head
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }

        val joinToString = list.joinToString("")
        return joinToString.toInt(2)
    }
}
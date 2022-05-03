/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list = ListNode(0)
        var result = list
        var l1 = list1
        var l2 = list2
        
        while(l1 != null && l2 != null){
            if(l1.`val`<= l2.`val`){
                list.next = l1
                list = list.next
                l1 = l1.next
            } else{
                list.next = l2
                list = list.next
                l2 = l2.next
            }
        }
        
        if(l1 == null){
            list.next = l2
        } else{
            list.next = l1
        }
        
        return result.next
    }
}
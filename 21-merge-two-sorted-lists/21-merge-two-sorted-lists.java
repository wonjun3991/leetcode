/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        var result = list;
        var l1 = list1;
        var l2 = list2;
        
        while(l1 != null && l2 != null){
            if(l1.val<= l2.val){
                list.next = l1;
                list = list.next;
                l1 = l1.next;
            } else{
                list.next = l2;
                list = list.next;
                l2 = l2.next;
            }
        }
        
        if(l1 == null){
            list.next = l2;
        } else{
            list.next = l1;
        }
        
        return result.next;
    }
}
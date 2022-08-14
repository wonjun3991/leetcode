/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    while(headA !== null){
        let b = headB;
        while(b !== null){
            if(headA == b){
                return headA
            }
            b = b.next
        }
        headA = headA.next
    }
    
    return null
};
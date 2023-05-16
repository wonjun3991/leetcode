/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    let cursor = head;
    
    while(cursor !== null && cursor.next !== null){
        let temp = cursor.val;
        cursor.val = cursor.next.val;
        cursor.next.val = temp;
        cursor = cursor.next.next;
    }

    return head;
};
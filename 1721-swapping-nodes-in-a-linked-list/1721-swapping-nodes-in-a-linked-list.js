/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function(head, k) {
    const node = [];
    let cursor = head;
    let count = 1;
    while(cursor !== null){
        node.push(cursor);
        cursor = cursor.next;
        count = count + 1;
    }
    if(count == 1){
        return head;
    }
    let temp = node[k-1].val;
    node[k-1].val = node[node.length - k].val;
    node[node.length - k].val = temp;
    
    return head;
};
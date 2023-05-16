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
  // node가 끝날때 까지 2개씩 노드를 조회한다
    let cursor = head;
    console.log(head);
    while(cursor !== null && cursor.next !== null){
        let temp = cursor.val;
        cursor.val = cursor.next.val;
        cursor.next.val = temp;
        cursor = cursor.next.next;
    }
    // 노드가 두개가 아니라면 취소한다
    // 노드가 두개면 두개의 노드의 val를 변경한다
    return head;
};
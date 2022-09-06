/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    const nodes = [];
    let point = new ListNode(0);
    let head = point;
    
    for(node of lists){
        while(node){
            nodes.push(node.val);
            node = node.next;
        }
    }
    
    for(nodeVal of nodes.sort(function (a, b) {  return a - b;  })){
        point.next = new ListNode(nodeVal);
        point = point.next
    }
    return head.next;
};
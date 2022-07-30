/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    var result = []

    function circuit(head){
        result.push(head.val);
        if(head.next){
            circuit(head.next)
        }
    }
    circuit(head)
    
    console.log(result)
    return result.join() === result.reverse().join()
};


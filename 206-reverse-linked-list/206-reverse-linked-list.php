/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val = 0, $next = null) {
 *         $this->val = $val;
 *         $this->next = $next;
 *     }
 * }
 */
class Solution {

    /**
     * @param ListNode $head
     * @return ListNode
     */
    function reverseList($head) {
        $node = null;
        while($head != null){
            $temp = $head;
            $head = $head->next;
            $temp->next = $node;
            $node = $temp;
        }
        return $node;
    }
}
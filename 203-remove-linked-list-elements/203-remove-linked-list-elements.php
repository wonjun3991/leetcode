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
     * @param Integer $val
     * @return ListNode
     */
    function removeElements($head, $val) {
        while($head->val == $val){
                $head = $head->next;
            }
        
        $node = $head;
        $temp = $node;
        
        while($head->next != null){
            $head = $head->next;
            while($head->val == $val){
                $head = $head->next;
            }
            $temp->next = $head;
            $temp = $head;
        }
        return $node;
    }
}
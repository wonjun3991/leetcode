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
    function deleteDuplicates($head) {
        $now = new ListNode($head->val);
        $point = $now;
        while($head != null){
            if($point->val != $head->val){
                $point->next= new ListNode($head->val);
                $point = $point->next;
            }
            $head = $head->next;
        }
        return $now;
    }
}
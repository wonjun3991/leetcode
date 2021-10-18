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
    function swapPairs($head) {
        $cursor = $head;
        
        
        while($cursor->next !=null){
            $firstVal = $cursor->val;
            $secondVal = $cursor->next->val;
            $cursor->val = $secondVal;
            $cursor->next->val = $firstVal;
            $cursor = $cursor->next->next;
        }
        return $head;
    }
}
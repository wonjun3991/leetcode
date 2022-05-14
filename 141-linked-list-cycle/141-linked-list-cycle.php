/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */

class Solution {
    /**
     * @param ListNode $head
     * @return Boolean
     */
    function hasCycle($head) {
        $travelList = [];
        while($head != null){
            if(in_array($head, $travelList, true)){
                return true;
            }
            $travelList[] = $head;
            $head = $head->next;
        }   
        return false;
    }
}
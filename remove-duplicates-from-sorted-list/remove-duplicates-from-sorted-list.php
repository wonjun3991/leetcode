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
  $current = $head;
        while(!is_null($current) && !is_null($current->next)) {
            if ($current->next->val == $current->val) {
                $current->next = $current->next->next;
            } else {
                $current = $current->next;
            }
        }
        return $head;
    }
}
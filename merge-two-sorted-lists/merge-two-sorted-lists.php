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
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        if(empty($l1) && empty($l2)){
            return null;
        }
        $listNode = new ListNode();
        $startNode = $listNode;
        while($l1 != null && $l2 != null){
            if($l1->val <= $l2->val){
                $listNode->val = $l1->val;
                $l1 = $l1->next;
            }else{
                $listNode->val = $l2->val;
                $l2 = $l2->next;
            }
            $listNode->next = new ListNode();
            $listNode = $listNode->next;
        }
        if($l1 == null){
            while($l2 != null){
                $listNode->val = $l2->val;
                if($l2->next != null){
                    $listNode->next = new ListNode();
                    $listNode = $listNode->next;
                }
                $l2 = $l2->next;
            }
        }
        else{
            while($l1 != null){
                $listNode->val = $l1->val;
                if($l1->next != null){
                    $listNode->next = new ListNode();
                    $listNode = $listNode->next;
                }
                $l1 = $l1->next;
            }
        }
        return $startNode;
    }
}
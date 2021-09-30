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
    function addTwoNumbers($l1, $l2) {
        $listNode = new ListNode(0,null);
        $addNum = 0;
        $iteratorNode = $listNode;
        
        while($l1 != null || $l2 != null){
            $sum = $l1->val + $l2->val + $iteratorNode->val;
            print_r($sum);
            $addNum = 0;
            $result = $sum % 10;
            $addNum =  intval($sum / 10);
            $iteratorNode->val = $result;
            $l1 = $l1->next;
            $l2 = $l2->next;
            if(($l1 == null && $l2 == null) && $addNum == 0){
                break;
            }
            $iteratorNode->next = new ListNode($addNum,null) ;
            $iteratorNode = $iteratorNode->next;
        }
        return $listNode;
    }
}
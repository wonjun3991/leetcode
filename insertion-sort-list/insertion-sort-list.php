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
    function insertionSortList($head) {
        $node = null;
        
        while($head !== null){
            if($node === null){
                $tempHead = clone $head;
                $tempHead->next = null;
                $node =$tempHead;
                //저장해놓은 노드의 값이 헤드 노드의 값보다 크거나 같으면
                //헤드의 넥스트에 기존 노드를 연결
            }elseif($node->val >= $head->val){
                $tempHead = clone $head;
                $tempHead -> next = $node;
                $node =  $tempHead;
                //저장해놓은 노드의 값이 헤드 노드의 값보다 작으면
                //타고들어가서 노드의 값이 헤드노드보다 클때까지 검색
                //
                
            }elseif($node->val < $head->val){
                if($node->next == null){
                    $tempHeadNode =clone $head;
                    $tempHeadNode -> next = null;
                    $node->next = $tempHeadNode;
                }else{
                    $tempNode = $node;
                    $beforeNode = null;
                    while($tempNode != null){
                        if($tempNode->val >= $head->val){
                            $tempHeadNode = clone $head;
                            $beforeNode->next = $tempHeadNode;
                            $tempHeadNode ->next = $tempNode;
                            break;
                        }
                        $beforeNode = $tempNode;  
                        $tempNode = $tempNode ->next;
                        if($tempNode == null){
                             $tempHeadNode =clone $head;
                            $tempHeadNode -> next = null;
                           
                            $beforeNode->next = $tempHeadNode;
                        }
                    }
                }
                
            }
           $head = $head->next;
        }
            return $node;
    }
}
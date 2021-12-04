/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {

    /**
     * @param TreeNode $p
     * @param TreeNode $q
     * @return Boolean
     */
    function isSameTree($p, $q) {
        if(!$p || !$q){
            if($p === $q){
                return true;
            }
            return false;
        }
        
        $pArray = [];
        $qArray = [];
        $this->inorder($p, $pArray);
        $this->inorder($q, $qArray);
        print_r($qArray);
        print_r($pArray);
        return $pArray === $qArray;
    }
    
    function inorder($root, &$array){
            array_push($array,$root->val);
            if($root->left != null){
                $this->inorder($root->left,$array);
            } else {
                array_push($array, $root->left);
            }
            
            if($root->right != null){
                $this->inorder($root->right, $array);
            } else {
                array_push($array, $root->right);
            }
    }
}
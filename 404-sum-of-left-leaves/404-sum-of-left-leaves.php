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

    public int $leaves = 0;
    /**
     * @param TreeNode $root
     * @return Integer
     */
    function sumOfLeftLeaves($root) {
        $this->searchLeftLeaves($root);
        return $this->leaves;
    }
    
    function searchLeftLeaves($root){
        if($root->left != null){
            $this->leftNode($root->left);
        }
        if($root->right != null){
            $this->searchLeftLeaves($root->right);
        }
    }
    
    function leftNode($root){
        if($root->left != null){
            $this->leftNode($root->left);
        }
        
        if($root->right != null){
            $this->searchLeftLeaves($root->right);
        }
        
        if($root->right == null && $root->left == null){
            $this->leaves = $this->leaves + $root->val;
        }
    }
}
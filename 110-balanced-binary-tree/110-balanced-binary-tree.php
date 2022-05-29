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
     * @param TreeNode $root
     * @return Boolean
     */
    function isBalanced($root) {
        if($root == null){
            return true;
        }
        
        return abs($this->height($root->left) - $this->height($root->right)) < 2
            && $this->isBalanced($root->left)
            && $this->isBalanced($root->right);
    }
    
    function height($root){
        if($root == null){
            return -1;
        }
        return 1 + max($this->height($root->left), $this->height($root->right));
    }
}
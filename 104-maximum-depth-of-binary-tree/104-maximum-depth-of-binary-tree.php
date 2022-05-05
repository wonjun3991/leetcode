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
    public int $count = 0;
    
    function maxDepth($root) {
        if($root === null){
            return 0;
        }
        
        $this->inOrder($root);
        return $this->count;
    }
    
    function inOrder($root, $count = 0){
        $count = $count + 1;
        if($root->left != null){
            $this->inOrder($root->left,$count);    
        }
        
        if($root->right != null){
            $this->inOrder($root->right,$count);
        }
        
        if($count > $this->count){
            $this->count = $count;
        }
    }
}
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
    public array $left = [];
    public array $right = [];
    /**
     * @param TreeNode $root
     * @return Boolean
     */
    function isSymmetric($root) {
        if($root->left == null && $root->right == null){
            return true;
        }
        
        
        $this->inOrderLeft($root->left);
        $this->inOrderRight($root->right);
        
        print_r($this->left);
        print_r($this->right);
        
        return $this->left === $this->right;
    }
    
    function inOrderLeft($root){
        $this->left[] = $root->val;
        
        if($root->left != null){
            $this->inOrderLeft($root->left);
        } else {
            $this->left[] = null;
        }
        
        if($root->right != null){
            $this->inOrderLeft($root->right);
        } else {
            $this->left[] = null;
        }
    }
    
    function inOrderRight($root){
        $this->right[] = $root->val;
        
        if($root->right != null){
            $this->inOrderRight($root->right);
        }    else {
            $this->right[] = null;
        } 
        
        if($root->left != null){
            $this->inOrderRight($root->left);
        }     else {
            $this->right[] = null;
        }
    }
}
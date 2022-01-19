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
     * @return Integer[]
     */
    function postorderTraversal($root) {
        $array = [];
        $this->tree($array, $root);
        return $array;
    
    }
    
    function tree(&$array, $root){
        echo $root->val;
        array_unshift($array, $root->val);
        
        if($root->right != null){
            $rightRoot = $root->right;
            $this->tree($array,$rightRoot);    
        }
        
        if($root->left != null){
            $leftRoot = $root->left;
            $this->tree($array,$leftRoot);    
        }
        
    }
}
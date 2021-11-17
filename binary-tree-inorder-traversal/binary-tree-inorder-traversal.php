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
    function inorderTraversal($root) {
        $array = [];
        $this->inorder($root,$array);
        return $array;
    }
    
    function inorder($root, &$array){
        if($root->val != null){
            if($root->left != null){
                $this->inorder($root->left,$array);
            }
            array_push($array,$root->val);
            if($root->right != null){
                $this->inorder($root->right, $array);
            }
        }
    }
}
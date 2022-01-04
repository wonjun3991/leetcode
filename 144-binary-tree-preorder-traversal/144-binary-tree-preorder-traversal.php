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
    function preorderTraversal($root) {
        $array = [$root->val];
        $this->readRoot($array, $root);
        return $array;
    }
    
    function readRoot(&$array, $tree){
        $leftTree = $tree->left;
        if($leftTree->val !== null){
            $array[] = $leftTree->val;
            $this->readRoot($array,$leftTree);
        }
        $rightTree = $tree->right;
        if($rightTree->val !== null){
            $array[] = $rightTree->val;
            $this->readRoot($array,$rightTree);
        }
    }
}
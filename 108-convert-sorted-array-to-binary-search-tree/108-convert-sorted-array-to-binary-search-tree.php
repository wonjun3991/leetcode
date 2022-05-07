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
    private array $nums = [];
    /**
     * @param Integer[] $nums
     * @return TreeNode
     */
    function sortedArrayToBST($nums) {
        $this->nums = $nums;
        return $this->inOrder(0, count($nums) - 1);
    }
    
    function inOrder(int $left, int $right){
        if($left > $right){
            return null;
        }
        
        $index = floor(($left + $right) / 2);
        
        $root = new TreeNode($this->nums[$index]);
        $root->left = $this->inOrder($left, $index - 1);
        $root->right = $this->inOrder($index + 1, $right);
        return $root;
    }
}
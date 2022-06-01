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
    public int $minimum = 0;
    /**
     * @param TreeNode $root
     * @return Integer
     */
    function minDepth($root) {
        if($root == null){
            return 0;
        }
        
        $this->height($root, 0);
        return $this->minimum;
    }
    
    function height($root, $height){
        $height = $height + 1;
        
        if($root->left != null){
            $this->height($root->left,$height);
        } 
        
        if($root->right != null){
            $this->height($root->right,$height);
        } 
        
        if($root->right == null && $root->left == null){
            $this->getMinimum($height);
        }
    }
    
    function getMinimum($height){
        if($this->minimum == 0){
            $this->minimum = $height;
        }
        
        if($height < $this->minimum){
            $this->minimum = $height;
        }
    }
}
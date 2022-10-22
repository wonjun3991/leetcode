/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    function maxHeight(root){
        if(!root){
            return 0;
        }
        
        const left = maxHeight(root.left);
        const right = maxHeight(root.right);
        
        return Math.max(left,right) + 1;
    }
    return maxHeight(root);
};
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
var findTilt = function(root) {
    
    
    const inOrder = function (root){
        if(root === null){
            return 0;
        }
        
        const leftSum = inOrder(root.left);
        const rightSum= inOrder(root.right);
        const tilt = Math.abs(leftSum - rightSum);
        
        result += tilt;
        
        return root.val + leftSum + rightSum;
    }
        
    let result = 0;
    inOrder(root);

    return result;
};


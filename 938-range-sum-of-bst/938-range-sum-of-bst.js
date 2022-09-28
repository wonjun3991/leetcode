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
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function(root, low, high) {
    const list = [];
    
    function inOrder(root){
        list.push(root.val);
        
        if(root.left){
            inOrder(root.left);
        }
        
        if(root.right){
            inOrder(root.right);
        }
    }
    
    inOrder(root);
    
    const sumWithInitial = list.filter((num)=> num >= low)
        .filter((num) => num <= high)
        .reduce((previousValue, currentValue) => previousValue + currentValue,0);
    
    return sumWithInitial;
};
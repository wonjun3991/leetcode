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
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    var array = [];
    inOrder(root, array);
    return array;
};

function inOrder(root, array) {
    if(root != null){
        inOrder(root.left, array);
        array.push(root.val);
        inOrder(root.right, array);
    }
}
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
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    let paths = [];
    inOrder(root, "" , paths)
    return paths;
};

function inOrder(root, path, paths){
    if(root != null){
        path = path + root.val;
        
        if((root.left == null) && (root.right == null)){
            paths.push(path)
        } else{
            path = path + "->"
            inOrder(root.left, path, paths)
            inOrder(root.right, path, paths)
        }
    }
}
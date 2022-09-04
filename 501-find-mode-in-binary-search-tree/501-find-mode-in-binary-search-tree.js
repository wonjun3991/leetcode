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
var findMode = function(root) {
    const result = [];
    const inorder = function(root){
        result.push(root.val);
        if(root.left !== null){
            inorder(root.left);
        }
        if(root.right !== null){
            inorder(root.right)
        }
    }
    
    inorder(root)
    const map = {};
    for (number of result){
        if(map[number] === undefined){
            map[number] = 0;    
        } 
        map[number] = map[number] + 1;
    }
    
    const result2= [];
    let max = Math.max(...Object.values(map));
    for (const [key, value] of Object.entries(map)) {
        if(value === max){
            result2.push(key);
        }
    }
    return result2;
};

/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */
var postorder = function(root) {
    if(root === null){
        return [];
    }
    
    const stack = [];
    const result = [];
    
    stack.push(root)
    
    while(stack.length !== 0){
        const node = stack.pop();
        result.push(node.val);
        stack.push(...node.children)
    }
    return result.reverse();    
};
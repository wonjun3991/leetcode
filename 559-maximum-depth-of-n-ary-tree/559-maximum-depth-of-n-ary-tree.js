/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number}
 */
var maxDepth = function(root) {
    const stack = [];
    let depth = 0;
    
    if(root === null){
        return 0;
    }
    
    stack.push([1,root])
    
    while(stack.length !== 0){
        const [currentDepth, root] = stack.pop();
        if(root){
            depth = Math.max(depth, currentDepth);
            for(child of root.children){
                stack.push([currentDepth + 1, child])
            }
        }
    }
    
    return depth;
};
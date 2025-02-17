/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        // int[] results = new int[size(root)];
        // BSTtoArray(root, results, 0);
        
        return root;
    }
    private int size(TreeNode node) {
        if (node == null) return (0);
        else {
            return (size(node.left) + 1 + size(node.right));
        }
    }
    public int BSTtoArray(TreeNode n, int[] results, int index) {
        if (n.left != null) {
            index = BSTtoArray(n.left, results, index);
        }

        if (n.right != null) {
            index = BSTtoArray(n.right, results, index);
        }

        results[index] = n.val;
        System.out.println(Arrays.toString(results));
        return index + 1;
    }
}
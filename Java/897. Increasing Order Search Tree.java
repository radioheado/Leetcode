/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = null, prev = null;
        
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            /* get the new root */
            if (newRoot == null) {
                newRoot = root;
            }
            
            if (prev != null) {
                root.left = null;
                prev.right = root;
            }
            
            prev = root;
            root = root.right;
        }
        
        return newRoot;
    }
}
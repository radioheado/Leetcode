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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode new_root = stack.peek();

        while (stack.size() > 1) {
            root = stack.pop();
            TreeNode parent = stack.peek();
            TreeNode right = parent.right;

            parent.left = null;
            parent.right = null;

            root.left = right;
            root.right = parent;
        }

        return new_root;
    }
}
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
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node.val == 0 || node.val == 1) {
            return node.val == 1;
        }
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if (node.val == 2) {
            return left || right;
        } else if (node.val == 3) {
            return left && right;
        }

        return false;
    }
}
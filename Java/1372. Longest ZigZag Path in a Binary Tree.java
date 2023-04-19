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
    private int ans;

    public int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return ans;
    }

    private void dfs(TreeNode node, boolean left, int path) {
        if (node != null) {
            ans = Math.max(ans, path);
            if (left) {
                dfs(node.right, false, path + 1);
                dfs(node.left, true, 1);
            } else {
                dfs(node.left, true, path + 1);
                dfs(node.right, false, 1);
            }
        }
    }
}
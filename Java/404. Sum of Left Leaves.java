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
    private int ans = 0;
    private static final int l = 0;
    private static final int r = 1;
    
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, r);
        return ans;
    }
    
    private void dfs (TreeNode root, int d) {
        if (root == null)   return;
        if (root.left == null && root.right == null && d == l) {
            ans += root.val;
            return;
        }
        dfs(root.left, l);
        dfs(root.right, r);
    }
}
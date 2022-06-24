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
    public int minCameraCover(TreeNode root) {
        int[] ans = dfs(root);
        return Math.min(ans[1], ans[2]);
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0, 99999};
        }
        int[] L = dfs(node.left);
        int[] R = dfs(node.right);
        
        int dp0 = L[1] + R[1];
        int dp1 = Math.min(L[2] + Math.min(R[1], R[2]), R[2] + Math.min(L[1], L[2]));
        int dp2 = 1 + Math.min(L[0], Math.min(L[1], L[2])) + Math.min(R[0], Math.min(R[1], R[2]));
        
        return new int[]{dp0, dp1, dp2};
    }
}
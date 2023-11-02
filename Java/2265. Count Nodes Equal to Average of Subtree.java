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
    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[2];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int total = left[0] + right[0] + node.val, count = left[1] + right[1] + 1;
        if (node.val == total / count) {
            return new int[]{total, count, left[2] + right[2] + 1};
        }
        return new int[]{total, count, left[2] + right[2]};
    }
}
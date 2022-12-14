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
    private int totalSum = 0;
    private long prod = 0;

    public int maxProduct(TreeNode root) {
        this.totalSum = treeSum(root);
        dfs(root);
        return (int)(prod % 1000000007);
    }

    private int treeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeSum(node.left);
        int right = treeSum(node.right);
        return left + right + node.val;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int subSum = left + right + node.val;
        long subProd = (long)(totalSum - subSum) * subSum;
        this.prod = Math.max(this.prod, subProd);
        return subSum;
    }
}
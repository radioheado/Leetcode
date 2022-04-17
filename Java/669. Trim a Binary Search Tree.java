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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    
    private TreeNode dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return node;
        }
        
        if (node.val < low) {
            return dfs(node.right, low, high);
        } else if (node.val > high) {
            return dfs(node.left, low, high);
        } else {
            node.left = dfs(node.left, low, high);
            node.right = dfs(node.right, low, high);
            return node;
        }
    }
}
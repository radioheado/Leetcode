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
    public int maxPathSum(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE)[1];
    }
    
    private int[] dfs(TreeNode node, int max){
        int[] res = new int[2];
        
        if(node == null){
            res[0] = 0;
            res[1] = max;
            return res;
        }
        
        int[] left = dfs(node.left, max);
        int[] right = dfs(node.right, max);
        
        int max_path = Math.max(node.val, Math.max(left[0], right[0])+node.val);
        int max_sum = Math.max(Math.max(Math.max(left[1], right[1]), Math.max(max_path, max)), left[0]+right[0]+node.val);
        
        res[0] = max_path;
        res[1] = max_sum;
        
        return res;
    }
}
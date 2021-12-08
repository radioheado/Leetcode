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
    
    public int findTilt(TreeNode root) {
        int[] answer = dfs(root);
        return answer[1];
    }
    
    private int[] dfs(TreeNode node){
        /**
         * [sum, cumulative tilt]
         */
        if(node == null){
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int cumu_tilts = left[1] + right[1] + Math.abs(left[0]-right[0]);
        int cur_sum = left[0] + right[0] + node.val;
        
        return new int[]{cur_sum, cumu_tilts};
    }
}
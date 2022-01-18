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
    boolean valid;
    
    public boolean isBalanced(TreeNode root) {
        valid = true;
        nodeDepth(root);
        return valid;
    }
    
    private int nodeDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        
        if(node.left == null && node.right == null){
            return 1;
        }
        
        int left = nodeDepth(node.left);
        int right = nodeDepth(node.right);
        
        if(Math.abs(left-right) > 1){
            valid = false;
        }
        
        return Math.max(left+1, right+1);
    }
}
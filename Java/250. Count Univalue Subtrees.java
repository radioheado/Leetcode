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
    
    private int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        counts(root);
        return count;
    }
    
    private boolean counts(TreeNode root){
        // leaf node is a univalued subtree, increment count
        if(root.left == null && root.right == null){
            count++;
            return true;
        }
        
        boolean subUni = true;
        
        // check left subtree
        if(root.left != null){
            subUni = counts(root.left) && subUni && (root.val == root.left.val);
        }
        
        // check right subtree
        if(root.right != null){
            subUni = counts(root.right) && subUni && (root.val == root.right.val);
        }
        
        if(subUni){
            count++;
            return true;
        }else{
            return false;
        }
        
    }
}
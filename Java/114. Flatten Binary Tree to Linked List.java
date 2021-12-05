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
    public void flatten(TreeNode root) {
        this.flat(root);
    }
    
    private TreeNode flat(TreeNode node){
        if(node == null){
            return null;
        }
        
        if(node.left == null && node.right == null){
            return node;
        }
        
        TreeNode left = this.flat(node.left);
        TreeNode right = this.flat(node.right);
        
        if(left != null){
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return right == null ? left : right;
    }
}


/**
 * O(N) time, O(1) space
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        TreeNode node = root;
        while(node != null){
            if(node.left != null){
                TreeNode rightmost = node.left;
                while(rightmost.right != null){
                    rightmost = rightmost.right;
                }
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
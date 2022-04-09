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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            if (right == null) {
                root = left;
                return root;
            }
            
            if (left == null) {
                root = right;
                return root;
            }
            
            TreeNode pred = left;
            while (pred.right != null) {
                pred = pred.right;
            }
            
            pred.right = right;
            root = left;
            return root;
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } 
        else {
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
}
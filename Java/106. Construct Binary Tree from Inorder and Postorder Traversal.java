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
    
    int postIndex;
    Map<Integer, Integer> mapping;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        mapping = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            mapping.put(inorder[i], i);
        }
        
        return arrayTree(postorder, 0, inorder.length-1);
    }
    
    
    private TreeNode arrayTree(int[] postorder, int left, int right){
        if(left > right){
            return null;
        }
        
        int value = postorder[postIndex--];
        int index = mapping.get(value);
        
        TreeNode root = new TreeNode(value);
        
        /**
         * Since post order records nodes from Left -> Right -> Root
         * When we visit the postorder list from its end to its start
         * the next node to visit is the right subtree's root
         * Thus, we need to traverse its right subtree before left subtree
         * This is opposed to what we did for preorder list
         */
        root.right = arrayTree(postorder, index+1, right);
        root.left = arrayTree(postorder, left, index-1);
        
        
        return root;
    }
}
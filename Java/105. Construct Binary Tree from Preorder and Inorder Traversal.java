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
    
    Map<Integer, Integer> mapping;
    // use this variable to record the root's index
    int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        mapping = new HashMap<>();
        // add the mapping between value and its index for quick lookup
        for(int i=0; i<inorder.length; i++){
            mapping.put(inorder[i], i);
        }
        
        return arrayTree(preorder, 0, preorder.length-1);
        
    }
    
    private TreeNode arrayTree(int[] preorder, int left, int right){
        // visited all nodes
        if(left > right){
            return null;
        }
        
        // get the root's value and its index in inorder
        int value = preorder[preIndex++];
        int index = mapping.get(value);
            
        TreeNode root = new TreeNode(value);
        root.left = arrayTree(preorder, left, index-1);
        root.right = arrayTree(preorder, index+1, right);
        
        return root;
    }
}

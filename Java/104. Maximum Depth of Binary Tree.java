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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        
        if(root == null){
            return depth;
        }
        
        stack.push(root);
        level.push(1);
        
        while(!stack.isEmpty()){
            root = stack.pop();
            int d = level.pop();
            
            if(root != null){
                depth = Math.max(depth, d);
                stack.push(root.left);
                level.push(d+1);
                stack.push(root.right);
                level.push(d+1);
            }
        }
        
        return depth;
        
    }
}
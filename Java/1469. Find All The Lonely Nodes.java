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
    public List<Integer> getLonelyNodes(TreeNode root) {
        return dfs(root, new ArrayList<Integer>());
    }
    
    private List<Integer> dfs(TreeNode node, List<Integer> lonely){
        if(node.left == null && node.right == null){
            return new ArrayList<Integer>();
        }
        
        if(node.left != null && node.right != null){
            dfs(node.left, lonely);
            dfs(node.right, lonely);
            return lonely;
        }
        
        if(node.left != null){
            lonely.add(node.left.val);
            dfs(node.left, lonely);
        }
        
        if(node.right != null){
            lonely.add(node.right.val);
            dfs(node.right, lonely);
        }
        
        return lonely;
    }
}
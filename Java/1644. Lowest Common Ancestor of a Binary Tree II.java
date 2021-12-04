/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode answer;
    TreeNode p;
    TreeNode q;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pp, TreeNode qq) {
        p = pp;
        q = qq;
        dfs(root);
        return answer;
    }
    
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        // left recursion
        int left = dfs(node.left);
        
        // right recursion
        int right = dfs(node.right);
        
        // check for current node
        int cur = 0;
        if(node==p || node==q){
            cur = 1;
        }
        
        if(left+right+cur >= 2){
            answer = node;
        }
        
        return (left+right+cur)>0 ? 1 : 0;
    }
}
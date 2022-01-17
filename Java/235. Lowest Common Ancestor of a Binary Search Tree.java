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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }
        
        while(root != null){
            if(p.val > root.val){
                root = root.right;
            }else if(q.val < root.val){
                root = root.left;
            }else{
                break;
            }
        }
        
        return root;
    }
}
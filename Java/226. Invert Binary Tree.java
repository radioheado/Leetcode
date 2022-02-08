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
    public TreeNode invertTree(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            TreeNode root = q.poll();
            if(root == null){
                continue;
            }
            TreeNode cur = root.left;
            root.left = root.right;
            root.right = cur;
            q.offer(root.left);
            q.offer(root.right);
        }
        
        return node;
    }
}
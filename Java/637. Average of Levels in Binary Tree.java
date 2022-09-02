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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        long size, sum;
        while (!q.isEmpty()) {
            size = q.size();
            sum = 0;
            
            for (int i=0; i<size; i++) {
                root = q.poll();
                sum += root.val;
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            
            ans.add(sum * 1.0 / size);
        }
        
        return ans;
    }
}
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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 1, max_sum = Integer.MIN_VALUE, max_level = 1;
        while (!q.isEmpty()) {
            int size = q.size(), level_sum = 0;
            while (size-- > 0) {
                root = q.poll();
                level_sum += root.val;
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            if (max_sum < level_sum) {
                max_sum = level_sum;
                max_level = level;
            }
            level++;
        }

        return max_level;
    }
}
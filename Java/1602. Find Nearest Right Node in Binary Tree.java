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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int size;
        boolean target = false;

        while (!q.isEmpty()) {
            target = false;
            size = q.size();

            for (int i = 0; i < size; i++) {
                root = q.poll();

                if (target) {
                    return root;
                }

                if (root == u) {
                    target = true;
                }

                if (root.left != null) {
                    q.offer(root.left);
                }

                if (root.right != null) {
                    q.offer(root.right);
                }
            }
        }

        return null;
        
    }
}
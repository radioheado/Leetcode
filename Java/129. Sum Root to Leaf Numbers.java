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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        q.offer(new Pair(root, 0));
        int ans = 0, path;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            root = (TreeNode) pair.getKey();
            path = (int) pair.getValue() * 10 + root.val;

            if (root.left == null && root.right == null) {
                ans += path;
            }

            if (root.left != null) {
                q.offer(new Pair(root.left, path));
            }

            if (root.right != null) {
                q.offer(new Pair(root.right, path));
            }
        }

        return ans;
    }
}
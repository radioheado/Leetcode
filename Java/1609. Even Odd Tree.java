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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            if (level % 2 == 0) {
                if (!checkEven(q)) {
                    return false;
                }
            } else {
                if (!checkOdd(q)) {
                    return false;
                }
            }
            level++;
        }
        return true;
    }

    private boolean checkOdd(Queue<TreeNode> q) {
        int size = q.size(), pre = Integer.MAX_VALUE;

        // odd level, nums must be even and decreasing
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            if (node.val % 2 == 1 || node.val >= pre) {
                return false;
            }
            pre = node.val;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return true;
    }

    private boolean checkEven(Queue<TreeNode> q) {
        int size = q.size(), pre = 0;

        // odd level, nums must be even and decreasing
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            if (node.val % 2 == 0 || node.val <= pre) {
                return false;
            }
            pre = node.val;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return true;
    }
}
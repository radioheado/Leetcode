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
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        int prev = -200000, ans = 100000;
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans = Math.min(ans, root.val - prev);
            prev = root.val;
            root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        return ans;
    }
}
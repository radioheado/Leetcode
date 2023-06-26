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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();

        while (root1 != null) {
            s1.push(root1);
            root1 = root1.left;
        }

        while (root2 != null) {
            s2.push(root2);
            root2 = root2.right;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            root1 = s1.peek();
            root2 = s2.peek();
            if (root1.val + root2.val == target) {
                return true;
            } else if (root1.val + root2.val < target) {
                root1 = s1.pop().right;
                while (root1 != null) {
                    s1.push(root1);
                    root1 = root1.left;
                }
            } else {
                root2 = s2.pop().left;
                while (root2 != null) {
                    s2.push(root2);
                    root2 = root2.right;
                }
            }
        }

        return false;
    }
}
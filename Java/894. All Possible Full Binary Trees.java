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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(new TreeNode());
            return ans;
        }
        
        for (int i = 1; i < n; i+= 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(0, l, r);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
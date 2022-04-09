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
    List<List<Integer>> ans = new ArrayList<>();
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        target = targetSum;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        
        dfs(root, temp, root.val);
        return ans;
    }
    
    private void dfs(TreeNode node, List<Integer> path, int sum) {
        if (node.left == null && node.right == null) {
            if (sum == target) {
                ans.add(path);
            }
        }
        
        if (node.left != null) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(node.left.val);
            dfs(node.left, temp, sum + node.left.val);
        }
        if (node.right != null) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(node.right.val);
            dfs(node.right, temp, sum + node.right.val);
        }
        
    }
}
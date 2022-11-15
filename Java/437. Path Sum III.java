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
    private int target, ans;
    private Map<Long, Integer> prefix;
    
    public int pathSum(TreeNode root, int targetSum) {
        prefix = new HashMap();
        target = targetSum;
        ans = 0;
        dfs(root, 0L);
        return ans;
    }
    
    private void dfs(TreeNode node, long pathSum) {
        if (node == null) {
            return;
        }
        
        pathSum += node.val;
        if (pathSum == target) {
            ans++;
        }
        
        ans += prefix.getOrDefault(pathSum - target, 0);
        prefix.put(pathSum, prefix.getOrDefault(pathSum, 0) + 1);
        
        dfs(node.left, pathSum);
        dfs(node.right, pathSum);
        
        prefix.put(pathSum, prefix.get(pathSum) - 1);
    }
}
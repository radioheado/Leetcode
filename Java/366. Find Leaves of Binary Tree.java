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
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        getLevel(root);
        return ans;
    }
    
    private int getLevel(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        int left = getLevel(root.left);
        int right = getLevel(root.right);
        int cur = Math.max(left, right) + 1;
        
        if(ans.size() == cur) {
            ans.add(new ArrayList<>());
        }
        
        ans.get(cur).add(root.val);
        return cur;
    }
}
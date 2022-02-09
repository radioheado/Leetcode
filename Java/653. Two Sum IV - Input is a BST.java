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
    List<Integer> nums;
    
    public boolean findTarget(TreeNode root, int k) {
        nums = new ArrayList<>();
        
        inorder(root);
        int left = 0, right = nums.size()-1;
        while(left < right){
            if(nums.get(left)+nums.get(right) > k){
                right--;
            }else if(nums.get(left)+nums.get(right) < k){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        inorder(node.left);
        nums.add(node.val);
        inorder(node.right);
    }
}
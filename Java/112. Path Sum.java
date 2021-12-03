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


/**
 * Recursive Solution
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    
    private boolean dfs(TreeNode node, int target){
        // if node does not exist, the target is not satisfied
        if(node == null){
            return false;
        }
        
        target -= node.val;
        // if node is a leaf, return true if the updated target equals to 0
        if(node.left == null && node.right == null){
            return target==0;
        }
        
        return dfs(node.left, target) || dfs(node.right, target);
        
    }
}


/**
 * Iterative Solution
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // use nodes to store the tree nodes, and target to store the target value accordingly
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> target = new Stack<>();
        
        if(root == null){
            return false;
        }
        
        nodes.push(root);
        target.push(targetSum);
        
        while(!nodes.isEmpty()){
            root = nodes.pop();
            targetSum = target.pop()-root.val;  
               
            if(root.left == null && root.right == null && targetSum == 0){
                return true;
            }
            
            if(root.right != null){
                nodes.push(root.right);
                target.push(targetSum);
            }
            if(root.left != null){
                nodes.push(root.left);
                target.push(targetSum);
            }
            
        }
        
        return false;
    }
}
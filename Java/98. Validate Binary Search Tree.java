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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer high, Integer low){
        if(root == null){
            return true;
        }
        
        if((high != null && root.val >= high) || (low != null && root.val <= low)){
            return false;
        }
        
        return isValid(root.left, root.val, low) && isValid(root.right, high, root.val);
        
    }
}

/**
 * Iterative Solution
 */
class Solution {
    
    LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    LinkedList<Integer> high = new LinkedList<Integer>();
    LinkedList<Integer> low = new LinkedList<Integer>();
    
    private void stackPush(TreeNode root, Integer h, Integer l){
        nodes.add(root);
        high.add(h);
        low.add(l);
    }
    
    public boolean isValidBST(TreeNode root) {
        
        stackPush(root, null, null);
        
        while(!nodes.isEmpty()){
            root = nodes.pollLast();
            Integer h = high.pollLast();
            Integer l = low.pollLast();
            
            if(root == null){
                continue;
            }
            
            if((h != null && root.val >= h) || (l != null && root.val <= l)){
                return false;
            }
            
            stackPush(root.left, root.val, l);
            stackPush(root.right, h, root.val);
        }
        
        return true;
    }
}
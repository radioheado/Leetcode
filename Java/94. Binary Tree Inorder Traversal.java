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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root!=null){
            /**
             * push all left children into the stack
             */
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            answer.add(root.val);
            root = root.right;
        }
        
        return answer;
    }
}
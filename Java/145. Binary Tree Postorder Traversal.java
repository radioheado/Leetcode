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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            answer.add(root.val);
            
            if(root.left != null){
                stack.push(root.left);
            }
            
            if(root.right != null){
                stack.push(root.right);
            }
        }
        
        Collections.reverse(answer);
        return answer;
        
    }
}
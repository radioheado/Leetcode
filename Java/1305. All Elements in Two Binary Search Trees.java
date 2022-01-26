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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        
        while(root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()){
            /* add all left nodes to the stacks
             * then add their right child
             * so it's inorder traverse
             */
            while(root1 != null){
                s1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                s2.push(root2);
                root2 = root2.left;
            }
            
            /* pop and add the smaller number to the result array
             * and visit it's right child
             */
            if(s2.isEmpty() || !s1.isEmpty() && s1.peek().val <= s2.peek().val){
                root1 = s1.pop();
                nums.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = s2.pop();
                nums.add(root2.val);
                root2 = root2.right;
            }
        }
        
        return nums;
    }
}
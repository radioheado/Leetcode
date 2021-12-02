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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null){
            return answer;
        }
        
        Queue<List<TreeNode>> queue = new LinkedList<List<TreeNode>>();
        List<TreeNode> start = new ArrayList<>();
        start.add(root);
        queue.add(start);
        
        while(!queue.isEmpty()){
            List<TreeNode> children = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            List<TreeNode> roots = queue.poll();
            
            for(TreeNode node: roots){
                values.add(node.val);
                if(node.left != null){
                    children.add(node.left);
                }
                if(node.right != null){
                    children.add(node.right);
                }
            }
            
            if(!children.isEmpty()){
                queue.add(children);
            }
            if(!values.isEmpty()){
                answer.add(values);
            }
        }
        
        return answer;
    }
}
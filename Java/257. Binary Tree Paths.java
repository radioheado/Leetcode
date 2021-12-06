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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<String> paths = new LinkedList<>();
        nodes.add(root);
        paths.add(Integer.toString(root.val));
        List<String> answer = new ArrayList<>();
        
        while(!nodes.isEmpty()){
            root = nodes.pollLast();
            String path = paths.pollLast();
            
            if(root.left == null && root.right == null){
                answer.add(path);
            }
            
            if(root.right != null){
                nodes.add(root.right);
                paths.add(path + "->" + Integer.toString(root.right.val));
            }
            
            if(root.left != null){
                nodes.add(root.left);
                paths.add(path + "->" + Integer.toString(root.left.val));
            }
        }
        
        return answer;
    }
    
}
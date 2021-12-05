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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        if(root == null){
            return answer;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                root = q.poll();
                
                if(root.left != null){
                    q.add(root.left);
                }
                
                if(root.right != null){
                    q.add(root.right);
                }
                
                if(i == size-1){
                    answer.add(root.val);
                }
                
            }
        }
        
        return answer;
    }
}
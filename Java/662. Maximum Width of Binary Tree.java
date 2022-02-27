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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int ans = 0;
        
        while(!q.isEmpty()) {
            int level = q.size();
            Pair cur = q.peek();
            int first = (int)cur.getValue();
            
            for(int i=0; i<level; i++) {
                cur = q.poll();
                root = (TreeNode)cur.getKey();
                int width = (int)cur.getValue();
                ans = Math.max(ans, width-first+1);
                if(root.left != null) {
                    q.offer(new Pair<>(root.left, width*2));
                }
                
                if(root.right != null) {
                    q.offer(new Pair<>(root.right, width*2+1));
                }
            }
        }
        return ans;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<Pair<TreeNode, TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(original, cloned));
        TreeNode ori, clo;
        
        while (!q.isEmpty()) {
            Pair<TreeNode, TreeNode> pair = q.poll();
            ori = pair.getKey();
            clo = pair.getValue();
            
            if (ori == target) {
                return clo;
            }
            
            if (ori.left != null) {
                q.offer(new Pair<>(ori.left, clo.left));
            }
            
            if (ori.right != null) {
                q.offer(new Pair<>(ori.right, clo.right));
            }
        }
        
        return null;
    }
}
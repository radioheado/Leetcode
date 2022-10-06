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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode new_root = new TreeNode(val);
            new_root.left = root;
            return new_root;
        }
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        q.offer(new Pair<TreeNode, Integer>(root, 1));
        int level;
        TreeNode cur;
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            cur = pair.getKey();
            level = pair.getValue();
            if (level == depth - 1) {
                TreeNode new_left = new TreeNode(val);
                TreeNode new_right = new TreeNode(val);
                new_left.left = cur.left;
                new_right.right = cur.right;
                cur.left = new_left;
                cur.right = new_right;
                continue;
            }
            if (cur.left != null) {
                q.offer(new Pair<TreeNode, Integer>(cur.left, level+1));
            }
            
            if (cur.right != null) {
                q.offer(new Pair<TreeNode, Integer>(cur.right, level+1));
            }
        }
        
        return root;
    }
}
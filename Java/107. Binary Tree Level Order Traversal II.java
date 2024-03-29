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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        List<Integer> level = new ArrayList();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                root = q.poll();
                level.add(root.val);
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            ans.add(0, new ArrayList<>(level));
            level.clear();
        }

        //Collections.reverse(ans);
        return ans;
    }
}
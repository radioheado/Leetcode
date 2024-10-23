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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int next_sum = 0;
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size(), cur_sum = next_sum;
            next_sum = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) q.poll();
                TreeNode node = (TreeNode) pair.getKey();
                int sibling_sum = (int) pair.getValue();
                node.val = cur_sum - sibling_sum;
                
                int l = node.left != null ? node.left.val : 0;
                int r = node.right != null ? node.right.val : 0;
                next_sum += l + r;

                if (node.left != null) {
                    q.add(new Pair(node.left, l + r));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, l + r));
                }
            }  
        }
        return root;
    }
}
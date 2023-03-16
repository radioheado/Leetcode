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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap();
        Set<Integer> parents = new HashSet();
        Set<Integer> children = new HashSet();

        for (int[] des: descriptions) {
            int p = des[0], c = des[1], d = des[2];

            if (!nodes.containsKey(p)) {
                nodes.put(p, new TreeNode(p));
            } 
            if (!nodes.containsKey(c)) {
                nodes.put(c, new TreeNode(c));
            } 

            TreeNode parent = nodes.get(p), child = nodes.get(c);
            if (d == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            parents.add(des[0]);
            children.add(des[1]);
        }

        parents.removeAll(children);
        int root_val = 0;
        for (int r: parents) {
            root_val = r;
        }

        return nodes.get(root_val);
    }
}
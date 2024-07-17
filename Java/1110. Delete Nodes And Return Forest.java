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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete = new HashSet<>();
        for (int val: to_delete) {
            delete.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        root = dfs(root, forest, delete);
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode dfs(TreeNode node, List<TreeNode> forest, Set<Integer> delete) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, forest, delete);
        node.right = dfs(node.right, forest, delete);

        if (delete.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }

        return node;
    }
}
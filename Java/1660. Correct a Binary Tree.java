import java.util.HashSet;

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
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        LinkedList<Pair<TreeNode, TreeNode>> q = new LinkedList();
        q.add(new Pair(root, null));
        while (!q.isEmpty()) {
            Pair pair = q.pollFirst();
            root = pair.getKey();
            Set<TreeNode> seen = new HashSet<>();
            
        }
    }
}
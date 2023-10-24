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
            int size = q.size();
            Set<TreeNode> seen = new HashSet<>();

            for (int i = 0; i < size; i++) {
                Pair pair = q.poll();
                TreeNode node = (TreeNode)pair.getKey();

                if (seen.contains(node.right)) {
                    TreeNode parent = (TreeNode)pair.getValue();
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    break;
                }

                seen.add(node);
                
                if (node.right != null) {
                    q.offer(new Pair(node.right, node));
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, node));
                }
                
            }
        }
        return root;
    }
}
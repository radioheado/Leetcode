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
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.left.val);
                graph.computeIfAbsent(node.left.val, v -> new ArrayList<>()).add(node.val);
            }
            if (node.right != null) {
                q.add(node.right);
                graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.right.val);
                graph.computeIfAbsent(node.right.val, v -> new ArrayList<>()).add(node.val);
            }
        }

        int minutes = -1;
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int n = queue.poll();
                if (graph.containsKey(n)) {
                    for (int child: graph.get(n)) {
                        if (!visited.contains(child)) {
                            visited.add(child);
                            queue.add(child);
                        }
                    }
                }
            }
            minutes++;
        }

        return minutes;
    }
}
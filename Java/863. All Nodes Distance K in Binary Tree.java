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
    Map<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap();
        dfs(root, null);

        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        q.offer(new Pair(target, 0));

        Set<TreeNode> visited = new HashSet();
        visited.add(target);

        List<Integer> ans = new ArrayList();
        TreeNode node = null;
        int d = 0;

        while (!q.isEmpty()) {
            if (q.peek().getValue() == k) {
                for (Pair pair: q) {
                    node = (TreeNode)pair.getKey();
                    ans.add(node.val);
                }
                return ans;
            }

            Pair<TreeNode, Integer> pair = q.poll();
            node = pair.getKey();
            d = pair.getValue() + 1;

            if (node.left != null && !visited.contains(node.left)) {
                q.offer(new Pair(node.left, d));
                visited.add(node.left);
            } 
            if (node.right != null && !visited.contains(node.right)) {
                q.offer(new Pair(node.right, d));
                visited.add(node.right);
            } 
            if (parents.get(node) != null && !visited.contains(parents.get(node))) {
                q.offer(new Pair(parents.get(node), d));
                visited.add(parents.get(node));
            } 
        }

        return ans;
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parents.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<Node, Integer>> q = new LinkedList();
        q.offer(new Pair(root, 1));
        int ans = 0, depth;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            root = (Node)pair.getKey();
            depth = (int)pair.getValue();

            for (Node c: root.children) {
                q.offer(new Pair(c, depth + 1));
            }
            ans = Math.max(ans, depth);
        }

        return ans;
    }
}
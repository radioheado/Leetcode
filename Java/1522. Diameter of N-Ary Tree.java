/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int ans = 0;

    public int diameter(Node root) {
        dfs(root);
        return ans;
    }

    private int dfs(Node node) {
        if (node == null || node.children == null) {
            return 0;
        }
        
        int first = 0, second = 0;
        for (Node c: node.children) {
            int depth = dfs(c) + 1;
            if (depth >= first) {
                second = first;
                first = depth;
            } else if (depth >= second) {
                second = depth;
            }
        }
        
        ans = Math.max(first + second, ans);
        return first;
    }
}
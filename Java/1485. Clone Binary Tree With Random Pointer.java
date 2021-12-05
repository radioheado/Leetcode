/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    Map<Node, NodeCopy> visited;
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        visited = new HashMap<>();
        return dfs(root);
    }
    
    private NodeCopy dfs(Node node){
        if(node == null){
            return null;
        }
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        NodeCopy cur = new NodeCopy(node.val, null, null, null);
        visited.put(node, cur);
        
        cur.left = dfs(node.left);
        cur.right = dfs(node.right);
        cur.random = dfs(node.random);
        
        return cur;
        
    }
}
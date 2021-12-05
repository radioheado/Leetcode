/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Map<Node, Node> visited;
    
    public Node cloneGraph(Node node) {
        visited = new HashMap<>();
        return dfs(node);
    }
    
    private Node dfs(Node node){
        if(node == null){
            return node;
        }
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        Node cur = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cur);
        
        
        for(Node nei: node.neighbors){
            cur.neighbors.add(dfs(nei));
        }
        
        
        return cur;
        
    }
}
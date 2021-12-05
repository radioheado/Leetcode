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
    Map<Node, Node> visited;
    
    public Node cloneTree(Node root) {
        visited = new HashMap<>();
        return cloneNode(root);
    }
    
    private Node cloneNode(Node node){
        if(node == null){
            return null;
        }
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        Node root = new Node(node.val, new ArrayList<Node>());
        visited.put(node, root);
        for(Node c: node.children){
            root.children.add(cloneNode(c));
        }
        
        return root;
    }
}
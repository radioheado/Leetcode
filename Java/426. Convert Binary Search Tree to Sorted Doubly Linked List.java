/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    List<Node> nodes;
    
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        
        nodes = new ArrayList<>();  
        inorder(root);
        Node prev = nodes.get(nodes.size()-1);
        
        for(Node node: nodes){
            prev.right = node;
            node.left = prev;
            prev = node;
        }
        
        return prev.right;
    }
    
    private void inorder(Node node) {
        if(node == null){
            return;
        }
        
        inorder(node.left);
        nodes.add(node);
        inorder(node.right);
    }
}
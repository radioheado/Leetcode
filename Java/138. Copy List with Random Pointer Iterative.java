/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        
        // make a new node old to iterate
        Node old = head;
        
        // make a new node neww to clone the nodes
        Node neww = new Node(old.val);
        this.visited.put(old, neww);
        
        // iterate
        while(old != null){
            neww.random = this.getClonedNode(old.random);
            neww.next = this.getClonedNode(old.next);
            
            old = old.next;
            neww = neww.next;
        }
        
        return this.visited.get(head);
    }
    
    private Node getClonedNode(Node node){
        if(node == null){
            return null;
        }
        
        // add node to visited
        this.visited.putIfAbsent(node, new Node(node.val, null, null))  ;
        return this.visited.get(node);
    }
}
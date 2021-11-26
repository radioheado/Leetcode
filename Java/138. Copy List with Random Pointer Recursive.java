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
            return null;
        }
        
        // if head is in visited, simply return it
        if(this.visited.containsKey(head)){
            return this.visited.get(head);
        }
        
        // if head is not in visited, create a new node and add it to visited
        Node cur = new Node(head.val, null, null);
        this.visited.put(head, cur);
        
        cur.next = this.copyRandomList(head.next);
        cur.random = this.copyRandomList(head.random);
        
        return cur;
    }
}
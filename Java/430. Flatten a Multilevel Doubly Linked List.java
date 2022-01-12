// Recursive Solution
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        // special case
        if(head == null){
            return head;
        }
        
        // a pseudo head points to the real head
        Node pseudo = new Node(0, null, head, null);
        
        dfs(pseudo, head);
        
        // detach the pseudo head from the real head
        pseudo.next.prev = null;
        return pseudo.next;
        
    }
    
    private Node dfs(Node pre, Node cur){
        // cur node reaches the null children of the pre node
        // which means pre is the tail node 
        if(cur == null){
            return pre;
        }
        
        cur.prev = pre;
        pre.next = cur;
        
        // keep a copy of the .next node
        Node nextNode = cur.next;
        
        // flatten the child node first
        Node nextChild = dfs(cur, cur.child);
        cur.child = null;
        
        // the child node
        return dfs(nextChild, nextNode);
    }
}
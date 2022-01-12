/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // special case 1:  empty list
        if(head == null){
            Node fake = new Node(0);
            head = new Node(insertVal);
            head.next = head;
            fake.next = head;
            return fake.next;
        }
        
        Node prev = head;
        Node cur = head.next;
        boolean insert = false;
        
        do{
            if(prev.val <= insertVal && insertVal <= cur.val){
                insert = true;
            }else if(prev.val > cur.val){
                if(insertVal >= prev.val || insertVal <= cur.val){
                    insert = true;
                }
            }
            
            if(insert){
                prev.next = new Node(insertVal, cur);
                return head;
            }
            
            prev = cur;
            cur = cur.next;
            
        }while (prev != head);
        
        // finishes a cycle, which means all nodes have the same value
        prev.next = new Node(insertVal, cur);
        return head;
    }
}
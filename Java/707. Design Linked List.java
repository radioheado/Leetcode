class MyLinkedList {
    int size;
    ListNode head;
    
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        // if the index is invalid
        if(index < 0 || index >= size){
            return -1;
        }
        
        ListNode cur = head;
        // get the wanted node
        for(int i=0; i<index+1; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        // if index is invalid
        if(index < 0 || index > size){
            return;
        }
        
        size++;
        // get the previous node
        ListNode prev = head;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        
        ListNode insert = new ListNode(val);
        insert.next = prev.next;
        prev.next = insert;
    }
    
    public void deleteAtIndex(int index) {
        // if index is invalid
        if(index < 0 || index >= size){
            return;
        }
        
        size--;
        // get the previous node
        ListNode prev = head;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = head;
        
        // special case: head is negative
        if(head.val < 0) {
            pre = head;
            cur = head.next;
        }
        
        while(cur != null) {
            ListNode temp = cur.next;
            
            if(cur.val < 0) {
                head = insertHead(head, pre);
            } else {
                pre = cur;
            }
            cur = temp;
        }
        
        return head;
    }
    
    private ListNode insertHead(ListNode head, ListNode pre) {
        ListNode node = pre.next;
        ListNode next = node != null ? node.next : node;
        pre.next = next;
        node.next = head;
        return node;
    }
}
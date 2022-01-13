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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        int total = 0;
        ListNode cur = head;
        
        while(cur != null){
            cur = cur.next;
            total++;
        }
        
        k %= total;
        
        /* special case */
        if(k == 0){
            return head;
        }
        
        cur = head;
        ListNode newHead = head.next;
        // get the new tail 
        for(int i=1; i<total-k; i++){
            cur = cur.next;
            newHead = newHead.next;
        }
        
        /* cut off the new tail from the new head */
        cur.next = null;
        
        /* record the new head */
        cur = newHead;
        
        while(cur.next != null){
            cur = cur.next;
        }
        
        cur.next = head;
        
        return newHead;
        
        
    }
}
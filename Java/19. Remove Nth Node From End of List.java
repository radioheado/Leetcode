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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, cur = dummy;
        
        for(int i=0; i<=n; i++){
            cur = cur.next;
        }
        
        while(cur != null){
            cur = cur.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        return dummy.next;
    }
}
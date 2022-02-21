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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        
        // count k nodes to reverse, notice that cur will be the next head
        while(count < k && cur != null) {
            cur = cur.next;
            count++;
        }
        
        // have k nodes to reverse, get the new head
        // notice that the head is modified to the end of the reversed list
        if(count == k) {
            ListNode newHead = reverse(head, k);
            head.next = reverseKGroup(cur, k);
            return newHead;
        }
        return head;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        while(k > 0) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            k--;
        }
        return pre;
    }
}
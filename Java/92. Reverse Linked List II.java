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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null)  return head;
        
        ListNode prev = null;
        ListNode cur = head, next;
        
        // reach to the left position
        while (left > 1) {
            left--;
            right--;
            prev = cur;
            cur = cur.next;
        }
        
        ListNode l = cur, p = prev;
        while (right > 0) {
            right--;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        if (p != null) {
            p.next = prev;
        } else {
            head = prev;
        }
        
        l.next = cur;
        return head;
    }
}
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
    public ListNode partition(ListNode head, int x) {
        // to link nodes less than x
        ListNode l = new ListNode(), lhead = l;
        
        // to link nodes greater than or equal to x
        ListNode g = new ListNode(), ghead = g;
        
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                g.next = head;
                g = g.next;
            }
            head = head.next;
        }
        
        // finish this link or there will be cycle
        g.next = null;
        l.next = ghead.next;
        
        return lhead.next;
    }
}
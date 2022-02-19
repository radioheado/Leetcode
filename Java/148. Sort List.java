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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode pre = null;
        while(head != null && head.next != null) {
            pre = pre == null ? head : pre.next;
            head = head.next.next;
        }
        ListNode mid = pre.next;
        pre.next = null;
        return mid;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        cur.next = n1 == null ? n2 : n1;
        return dummy.next;
    }
}
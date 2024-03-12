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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        Map<Integer, ListNode> prefix = new HashMap<>();
        prefix.put(0, dummy);
        int psum = 0;

        while (cur != null) {
            psum += cur.val;
            prefix.put(psum, cur);
            cur = cur.next;
        }

        psum = 0;
        cur = dummy;

        while (cur != null) {
            psum += cur.val;
            cur.next = prefix.get(psum).next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
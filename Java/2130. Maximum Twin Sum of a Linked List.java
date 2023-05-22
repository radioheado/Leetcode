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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        // find the middle node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse the second half
        ListNode pre =  null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        int ans = 0;
        while (pre != null) {
            ans = Math.max(ans, pre.val + head.val);
            head = head.next;
            pre = pre.next;
        }

        return ans;
    }
}
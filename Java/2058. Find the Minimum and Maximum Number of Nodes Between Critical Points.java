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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first_strict = -1, prev_strict = -1, cur_pos = 1, pre_val = head.val;
        int[] ans = new int[]{Integer.MAX_VALUE, -1};

        head = head.next;
        while (head.next != null) {
            if (
                (pre_val < head.val && head.val > head.next.val) ||
                (pre_val > head.val && head.val < head.next.val)
            ) {
                if (first_strict == -1) {
                    first_strict = cur_pos;
                } else {
                    ans[1] = Math.max(ans[1], cur_pos - first_strict);
                }

                if (prev_strict != -1) {
                    ans[0] = Math.min(ans[0], cur_pos - prev_strict);
                }

                prev_strict = cur_pos;
            }
            pre_val = head.val;
            head = head.next;
            cur_pos++;
        }
        if (ans[0] != Integer.MAX_VALUE) {
            return ans;
        } else {
            return new int[]{-1, -1};
        }
    }
}
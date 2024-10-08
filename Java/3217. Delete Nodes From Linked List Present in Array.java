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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        ListNode dummy = new ListNode(), cur = dummy;
        while (head != null) {
            if (set.contains(head.val)) {
                cur.next = null;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
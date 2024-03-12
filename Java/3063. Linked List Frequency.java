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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> freqs = new HashMap<>();
        while (head != null) {
            freqs.put(head.val, freqs.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v: freqs.values()) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return dummy.next;
    }
}
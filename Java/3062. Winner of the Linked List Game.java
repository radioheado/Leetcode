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
    public String gameResult(ListNode head) {
        int points = 0;
        while (head != null && head.next != null) {
            if (head.val > head.next.val) {
                points++;
            } else {
                points--;
            }
            head = head.next.next;
        }
        
        if (points > 0) {
            return "Even";
        } else if (points < 0) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}
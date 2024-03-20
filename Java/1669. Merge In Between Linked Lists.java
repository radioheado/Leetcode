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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1, a1 = list1;
        int count = 0;

        while (count < a) {
            a1 = cur;
            count++;
            cur = cur.next;
        }

        while (count <= b) {
            count++;
            cur = cur.next;
        }

        a1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = cur;
        return list1;
    }
}
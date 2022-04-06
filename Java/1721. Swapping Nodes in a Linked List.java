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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        ListNode front = new ListNode();
        ListNode end = new ListNode();
        
        while (cur != null) {
            count++;
            if (end != null) {
                end = end.next;
            }
            
            if (count == k) {
                front = cur;
                end = head;
            }
            cur = cur.next;
        }
        
        int temp = front.val;
        front.val = end.val;
        end.val = temp;
        
        return head;
    }
}
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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head; 
        ListNode not_nine = dummy;
        
        // find the rightmost node that's not 9
        while (head != null) {
            if (head.val != 9) {
                not_nine = head;
            }
            head = head.next;
        }
        
        // increment the rightmost node that's not 9
        // then change all nodes after it to 0
        not_nine.val += 1;
        not_nine = not_nine.next;    
        
        while (not_nine != null) {
            not_nine.val = 0;
            not_nine = not_nine.next;
        }
        
        return dummy.val == 1 ? dummy : dummy.next;
    }
    
}
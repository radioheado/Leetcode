/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // special cases
        if(head == null || head.next == null){
            return null;
        }
        
        /* Step 1: find the intersection where two pointers meet
         *         if fast reaches null or fast.next reaches null
         *         then it means there is no cycles
         */
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        // deal with the situation if there are no cycles
        if(fast == null || fast.next == null){
            return null;
        }
        
        /* step 2: find the entrance of the cycle
         *         set slow pointer to the head again
         *         and make slow and fast pointers move 1 step at the same time
         */
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
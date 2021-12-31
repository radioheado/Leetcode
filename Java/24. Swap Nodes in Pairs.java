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

 // Iterative Solution
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode prev = ans;
        
        while(head != null && head.next != null){
            ListNode second = head.next;
            
            prev.next = second;
            head.next = second.next;
            second.next = head;
            
            prev = head;
            head = head.next;
        }
        
        return ans.next;
    }
}
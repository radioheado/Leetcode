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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println(slow.next.val);
        // reverse the second half
        ListNode tail = reverseList(slow);
        
        // start comparing
        while(tail != null && head != null && tail != head){
            //System.out.println(tail.val);
            //System.out.println(head.val);
            if(tail.val != head.val){
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
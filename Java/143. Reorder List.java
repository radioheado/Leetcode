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
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode prev = reverseList(mid);
        
        mergeLists(head, prev);
    }
    
    // find the middle node
    private ListNode midNode(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // reverse the second part of the list
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
    
    // merge the two parts
    private void mergeLists(ListNode head, ListNode prev){
        ListNode first = head;
        ListNode second = prev;
        
        while(second.next != null){
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
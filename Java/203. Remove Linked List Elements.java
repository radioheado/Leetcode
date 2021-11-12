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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        
        ListNode last = new ListNode();
        last.next = head;
        ListNode cur = new ListNode();
        cur = last.next;
        
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
                last.next = cur;
            }
            else{
                cur = cur.next;
                last = last.next;
            }
        }
        
        return head;
    }
}
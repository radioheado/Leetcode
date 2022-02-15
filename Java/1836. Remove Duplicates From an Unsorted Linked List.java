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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        
        // count all numbers
        ListNode cur = head;
        while(cur != null) {
            count.put(cur.val, count.getOrDefault(cur.val, 0)+1);
            cur = cur.next;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null) {
            // found duplicate
            if(count.get(head.val) > 1) {
                pre.next = head.next;
            }else{
                pre = pre.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}
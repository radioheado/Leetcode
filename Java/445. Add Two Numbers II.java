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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        return reverseList(addLists(l1, l2));
    }
    
    // the helper function to reverse a linked list
    private ListNode reverseList(ListNode node){
        ListNode prev = null;
        
        while(node != null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        
        return prev;
    }
    
    // the helper function to add two linked list
    private ListNode addLists(ListNode n1, ListNode n2){
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;
        
        while(n1 != null || n2 != null){
            cur.next = new ListNode();
            cur = cur.next;
            
            if(n1 != null && n2 != null){
                int sum = carry + n1.val + n2.val;
                carry = sum/10;
                int rem = sum%10;
                cur.val = rem;
                n1 = n1.next;
                n2 = n2.next;
            }else if(n1 != null){
                int sum = carry + n1.val;
                carry = sum/10;
                int rem = sum%10;
                cur.val = rem;
                n1 = n1.next;
                
                if(carry == 0){
                    cur.next = n1;
                }
                
            }else if(n2 != null){
                int sum = carry + n2.val;
                carry = sum/10;
                int rem = sum%10;
                cur.val = rem;
                n2 = n2.next;
                
                if(carry == 0){
                    cur.next = n2;
                }
            }  
        }
        
        // if there is a carry
        if(carry > 0){
            cur.next = new ListNode();
            cur = cur.next;
            cur.val = carry;
        }
        
        return head.next;
    }
}
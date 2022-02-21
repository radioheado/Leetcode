# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        count = 0
        cur = head
        
        # count k nodes to reverse
        while count < k and cur:
            cur = cur.next
            count += 1
            
        # have k nodes to reverse, return the reversed head
        if count == k:
            newHead = self.reverse(head, k)
            head.next = self.reverseKGroup(cur, k)
            return newHead
        
        # not enough nodes to reverse, return the original head
        return head
    
    # a helper function to reverse k nodes in the linked list
    # returns the new head
    def reverse(self, head, k) -> ListNode:
        pre, cur = None, head
        while k:
            pre, cur.next, cur = cur, pre, cur.next
            k -= 1
            
        return pre
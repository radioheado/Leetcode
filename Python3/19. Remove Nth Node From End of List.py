# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        prev, cur = dummy, dummy
        
        for i in range(n+1):
            cur = cur.next
            
        while cur:
            prev = prev.next
            cur = cur.next
            
        # reaches the (n-1)th node from the end of the list
        #print(prev.val)
        
        prev.next = prev.next.next
        
            
        return dummy.next
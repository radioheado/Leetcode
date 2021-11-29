# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Iterative solution
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
               
        prev = None
        cur = head
        
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
            
        return prev
        

# Recursive solution
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        prev = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        
        return prev        
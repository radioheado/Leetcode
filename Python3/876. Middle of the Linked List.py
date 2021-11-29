# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        total = 0
        cur = head
        
        while cur:
            total += 1
            cur = cur.next
            
        total = total//2
        
        cur = head
        while total:
            cur = cur.next
            total -= 1
        
        return cur
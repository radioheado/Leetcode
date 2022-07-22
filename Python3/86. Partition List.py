# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        # to link nodes less than x
        l = lhead = ListNode()
        
        # to link nodes greater than or equal to x
        g = ghead = ListNode()
        
        while head:
            if head.val < x:
                l.next = head
                l = l.next
            else:
                g.next = head
                g = g.next
            head = head.next
        
        # finish this list or there will be a cycle
        g.next = None
        l.next = ghead.next
        
        return lhead.next
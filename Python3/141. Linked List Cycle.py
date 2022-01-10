# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # special case 
        if not head:
            return False
        
        slow = head
        fast = head.next
        
        while slow != fast:
            # fast pointer reaches the end null or its next is the end null
            if not fast or not fast.next:
                return False
            slow = slow.next
            fast = fast.next.next
            
        return True
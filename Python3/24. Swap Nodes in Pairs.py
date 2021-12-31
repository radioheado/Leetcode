# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Recursive Solution
class Solution:
    def swapPairs(self, first: Optional[ListNode]) -> Optional[ListNode]:
        
        if not first or not first.next:
            return first
        
        second = first.next
        
        # before: first -> second -> second.next
        # after:  second -> first -> second.next
        second.next, first.next = first, self.swapPairs(second.next)
        
        return second
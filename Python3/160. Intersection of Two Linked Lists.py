# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # loop over two lists until they meet
        pa = headA
        pb = headB
        
        while pa != pb:
            pa = headB if not pa else pa.next
            pb = headA if not pb else pb.next
                
        return pa
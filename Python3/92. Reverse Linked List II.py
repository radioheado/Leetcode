# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == right:
            return head
        
        prev = ListNode()
        prev.next = head
        ph = prev
        cur = head
        count = 1
        
        while count < left:
            prev, cur = cur, cur.next
            count += 1
            
        tail = cur
        prev.next, end = self.reverse(cur, right-count)
        tail.next = end
        return ph.next
        
    def reverse(self, left: ListNode, right: int):
        prev = None
        cur = left
        count = 0
        while left and count < right:
            prev, left.next, left = left, prev, left.next
            count += 1
            
        # now left points to right value's node
        nxt = left.next
        left.next = prev
        return left, nxt
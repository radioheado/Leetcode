# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur, nxt = head, head.next
        while cur and nxt:
            val = gcd(cur.val, cur.next.val)
            cur.next = ListNode(val, nxt)
            cur, nxt = nxt, nxt.next
        return head
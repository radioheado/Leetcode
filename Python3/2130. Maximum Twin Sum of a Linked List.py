# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow, fast = head, head

        # find the middle node
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half
        cur, pre = slow, None
        while cur:
            cur.next, pre, cur = pre, cur, cur.next

        ans = 0
        while pre:
            ans = max(ans, head.val + pre.val)
            pre = pre.next
            head = head.next

        return ans
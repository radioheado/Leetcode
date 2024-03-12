# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        cur = dummy
        psum = 0
        prefix = {0: dummy}

        # duplicate prefix sums will be replaced by the last one
        while cur:
            psum += cur.val
            prefix[psum] = cur
            cur = cur.next

        psum = 0
        cur = dummy

        # delete the subsequences that have the same sum
        while cur:
            psum += cur.val
            cur.next = prefix[psum].next
            cur = cur.next

        return dummy.next

        
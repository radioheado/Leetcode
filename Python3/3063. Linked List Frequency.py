# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def frequenciesOfElements(self, head: Optional[ListNode]) -> Optional[ListNode]:
        freqs = collections.defaultdict(int)
        while head:
            freqs[head.val] += 1
            head = head.next

        dummy = ListNode(0)
        cur = dummy

        for v in freqs.values():
            cur.next = ListNode(v)
            cur = cur.next

        return dummy.next
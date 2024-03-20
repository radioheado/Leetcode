# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        dummy = ListNode(0, list1)
        cur = dummy
        count = -1

        while count < a and cur:
            a1 = cur
            cur = cur.next
            count += 1

        while count <= b and cur:
            cur = cur.next
            count += 1

        a1.next = list2
        while list2 and list2.next:
            list2 = list2.next

        list2.next = cur
        return dummy.next


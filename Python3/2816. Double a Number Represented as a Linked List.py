# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverseList(head):
            pre, cur = None, head
            while cur:
                cur.next, cur, pre = pre, cur.next, cur
            return pre

        head = reverseList(head)
        carry = 0
        cur = head
        while cur:
            carry, cur.val = divmod(carry + cur.val * 2, 10)
            cur = cur.next
        
        head = reverseList(head)
        new_head = None
        if carry:
            new_head = ListNode(1, head)

        return new_head if new_head else head

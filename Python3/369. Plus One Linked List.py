# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def plusOne(self, head: ListNode) -> ListNode:
        # reverse the list
        head = self.reverse(head)
        
        # start processing the increment
        cur = head
        carry = 1
        while cur:
            carry, rem = divmod(carry+cur.val, 10)
            cur.val = rem
            cur = cur.next
        
        # reverse the list back
        head = self.reverse(head)
        
        # need to add a new list node to the head
        if carry:
            cur = ListNode(carry)
            cur.next = head
            return cur
        
        return head
            
        
    def reverse(self, cur: ListNode) -> ListNode:
        pre = None
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
            
        return pre
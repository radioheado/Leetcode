# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseList(self, head):
        prev = None
        while head:
            head.next, head, prev = prev, head.next, head
        return prev
        
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # find the middle node
        slow = fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        tail = self.reverseList(slow)
        
        # start comparing
        while tail and head and tail != head:
            #print(tail)
            if tail.val != head.val:
                return False
            tail = tail.next
            head = head.next
        
        return True
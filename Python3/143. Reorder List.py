# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    # find the middle node
    def midNode(self, node):
        slow, fast = node, node
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    # reverse the LinkedList 
    # use this method to reverse the second part of the LinkedList
    def reverseList(self, node):
        prev = None
        cur = node
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev
    
    # merge n2 to n1 without returning anything
    def mergeLists(self, head, prev):
        first = head
        second = prev
        
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        mid = self.midNode(head)
        prev = self.reverseList(mid)
        self.mergeLists(head, prev)
        
        
        
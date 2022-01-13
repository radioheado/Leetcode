# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    # a helper function to reverse the linked list
    def reverseList(self, head: ListNode, rotate: int):
        prev = None
        for _ in range(rotate):
            head.next, prev, head = prev, head, head.next
        return prev
    
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # special case 1 and 2
        if not head or not head.next:
            return head
        
        # count the total nodes in the linked list
        total = 0
        cur = head
        while cur:
            cur = cur.next
            total += 1
        
        k %= total
        # special case 3
        if k == 0:
            return head
        
        # reverse the whole list
        head = self.reverseList(head, total)
        
        # get the starting node of the second half
        second = head
        for _ in range(k):
            second = second.next
        
        second = self.reverseList(second, total-k)
        #print("head = ", head)
        #print(second)
        # reverse the first half, and cut off the first node
        # because it's duplicate
        first = self.reverseList(head, k)
        #print("first = ", first)
        
        head = first
        
        #print("head = ", head)
        
        # link the first half and the second half
        while first.next:
            first = first.next
            
        first.next = second
        
        return head
        
        
        
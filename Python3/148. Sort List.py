# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        mid = self.findMid(head)
        left = self.sortList(head)
        right = self.sortList(mid)
        return self.merge(left, right)
        
    # return the mid node given a head
    def findMid(self, head) -> ListNode:
        pre = None
        while head and head.next:
            pre = head if not pre else pre.next
            head = head.next.next
        mid = pre.next
        pre.next = None
        return mid
    
    # merge two linked lists
    def merge(self, n1, n2):
        dummy = ListNode()
        cur = dummy
        while n1 and n2:
            if n1.val > n2.val:
                cur.next = n2
                n2 = n2.next
                cur = cur.next
            else:
                cur.next = n1
                n1 = n1.next
                cur = cur.next
        
        cur.next = n1 if n1 else n2
        return dummy.next
        
    
    
        
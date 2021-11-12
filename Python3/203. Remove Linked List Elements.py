# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        
        while head and head.val == val:
            head = head.next
        
        last = ListNode(None)
        last.next = head
        cur = last.next
        
        while cur:
            
            #print(cur.val, last.val)
            if cur.val == val:
                cur = cur.next
                last.next = cur
            else:
                cur = cur.next
                last = last.next
            #print("head = ", head.val)
            
        return head
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        cur = head
        
        # get the previous node of the k-th node
        for i in range(1, k):
            cur = cur.next
        #print(cur.val)    
        first = cur
        pre = head
        
        # get the previous node of the backwards k-th node
        while cur.next:
            pre = pre.next
            cur = cur.next
        
        first.val, pre.val = pre.val, first.val
        return head
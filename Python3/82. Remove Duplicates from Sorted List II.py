# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        pre = dummy
        
        while head:
            # found duplicates, skip the whole sublist
            if head.next and head.val == head.next.val:
                while head.next and head.val == head.next.val:
                    head = head.next
                pre.next = head.next
                
            # no duplicates here, move pre pointer
            else:
                pre = pre.next
                
            head = head.next
                
        return dummy.next
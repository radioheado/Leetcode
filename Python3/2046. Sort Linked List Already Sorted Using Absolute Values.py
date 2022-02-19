# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortLinkedList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre = ListNode()
        pre.next = head
        cur = head
        while cur:
            temp = cur.next
            if cur.val < 0:
                oldHead= head
                head = self.insertHead(head, pre)
                # the head is negative
                if oldHead == head:
                    pre = head
            else:
                pre = cur
            cur = temp
        return head
        
        
    def insertHead(self, head, pre):
        if pre.next == head:
            return head
        
        #dummy = ListNode()
        #dummy.next = node
        node = pre.next
        nxt = node.next if node else node
        pre.next = nxt
        node.next = head
        return node
        
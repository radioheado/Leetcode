# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1 = self.reverseList(l1)
        l2 = self.reverseList(l2)
        
        return self.reverseList(self.addLists(l1, l2))
        
    # reverse a linked list    
    def reverseList(self, node: ListNode) -> ListNode:
        prev = None
        
        while node:
            temp = node.next
            node.next = prev
            prev = node
            node = temp
            
        return prev
    
    
    # add two lists
    def addLists(self, n1: ListNode, n2: ListNode) -> ListNode:
        head = ListNode()
        cur = head
        carry = 0
        
        while n1 or n2:
            cur.next = ListNode()
            cur = cur.next
            
            # if both n1 and n2 have values
            if n1 and n2:
                carry, rem = divmod(carry + n1.val + n2.val, 10)
                cur.val = rem
                n1 = n1.next
                n2 = n2.next
            # if n1 is longer than n2
            elif n1:
                carry, rem = divmod(carry + n1.val, 10)
                cur.val = rem
                n1 = n1.next
                
                if not carry:
                    cur.next = n1
            
            elif n2:
                carry, rem = divmod(carry + n2.val, 10)
                cur.val = rem
                n2 = n2.next
                
                if not carry:
                    cur.next = n2
        
        # if there is still a carry needs to be added to the linked list
        if carry:
            cur.next = ListNode()
            cur = cur.next
            cur.val = carry
            
        return head.next
        
        
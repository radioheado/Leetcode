# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # special case
        if not head or not head.next:
            return None
        
        # step 1: find the intersection where two pointers meet
        #         if fast reaches null or fast.next reaches null
        #         then it means there is no cycles
        slow = head 
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            #print("slow = %d, fast = %d" %(slow.val, fast.val))
            if fast == slow:
                break
                
        # deal with the situation if there are no cycles
        if not fast or not fast.next:
            return None
        
        #print("found inter, slow = %d, fast = %d" %(slow.val, fast.val))    
        # step 2: find the entrance of the cycle
        #         set slow pointer to the head again
        #         and make slow and fast pointers move 1 step at the same time
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
            
        return slow
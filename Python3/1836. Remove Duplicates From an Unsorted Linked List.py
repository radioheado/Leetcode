# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicatesUnsorted(self, head: ListNode) -> ListNode:
        nums = []
        cur = head
        while cur:
            nums.append(cur.val)
            cur = cur.next
        
        # get counts
        nums = Counter(nums)
        
        dummy = ListNode()
        dummy.next = head
        pre = dummy
        
        while head:
            # found duplicates
            if nums[head.val] > 1:
                pre.next = head.next
            else:
                pre = pre.next
            head = head.next
            
        return dummy.next
        
    
        
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.head = head

    def getRandom(self) -> int:
        cur = self.head
        chosen = 0
        scope = 1

        while cur:
            if random.random() < 1/scope:
                chosen = cur.val
            cur = cur.next
            scope += 1
        
        return chosen


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()
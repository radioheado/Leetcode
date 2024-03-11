# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def gameResult(self, head: Optional[ListNode]) -> str:
        # increment if even wins
        # decrement if odd wins
        points = 0

        while head:
            if head.val > head.next.val:
                points += 1
            else:
                points -= 1
            head = head.next.next

        if points > 0:
            return 'Even'
        elif points < 0:
            return 'Odd'
        else:
            return 'Tie'
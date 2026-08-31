# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        first_strict = prev_strict = -1
        cur_pos = 1
        ans = [inf, -1]

        pre_val = head.val
        head = head.next
        while head:
            if head.next:
                # Local minima or maxima
                if (pre_val < head.val and head.val > head.next.val) or \
                (pre_val > head.val and head.val < head.next.val):
                    if prev_strict != -1:
                        ans[0] = min(ans[0], cur_pos - prev_strict)

                    if first_strict == -1:
                        first_strict = cur_pos
                    else:
                        ans[1] = max(ans[1], cur_pos - first_strict)

                    prev_strict = cur_pos

            cur_pos += 1
            pre_val = head.val
            head = head.next
        
        if ans[0] == inf:
            return [-1, -1]
        return ans
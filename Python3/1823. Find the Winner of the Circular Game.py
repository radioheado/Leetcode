class Node:
    def __init__(self, val = 0, nxt = None):
        self.val = val
        self.next = nxt

class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        if k == 1:
            return n
        
        head = Node(1)
        cur = head
        # make a cyclic linked list
        for i in range(2, n+1):
            cur.next = Node(i)
            cur = cur.next
        cur.next = head
        
        count = 1
        while head != head.next:
            # delete the next node
            if k-count == 1:
                count = 1
                head.next = head.next.next
            else:
                count += 1
            head = head.next
            
        return head.val
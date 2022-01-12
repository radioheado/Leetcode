"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        # special case 1: empty list
        #                 make a pseudo head that points to head
        #                 also make head.next points to itself
        if not head:
            fake = Node()
            head = Node(insertVal)
            fake.next = head
            head.next = head
            return fake.next
        
        # special case 2: only one node exists
        #                 directly add the new node the head's next
        if head.next == head:
            new = Node(insertVal)
            head.next = new
            new.next = head
            return head
        
        # common cases:  more than two nodes
        prev = head
        cur = head.next
        new = Node(insertVal)

        while cur:
            # case 1: 1 -> 2 -> 3 -> 3 (points to 1), insert = 3
            #         prev = 2, cur = 3, satisfies this if
            # case 2: insert >= prev >= cur, 
            #         3 -> 4 -> 1 -> 2 (points to 3), insert = 5
            #         prev = 4, cur = 1
            if cur.val >= insertVal >= prev.val or insertVal >= prev.val > cur.val or prev.val > cur.val >= insertVal:
                #print("prev = %d, cur = %d" %(prev.val, cur.val))
                prev.next = new
                new.next = cur
                break
            
            
            prev = cur
            cur = cur.next
            #print("out prev = %d, cur = %d" %(prev.val, cur.val))
            
            # end condition if the prev node reaches the head again
            if prev == head:
                #print("equals prev = %d, cur = %d" %(prev.val, cur.val))
                prev.next = new
                new.next = cur
                break
                
        return head
            
            
            
            
                
                
            
        
            
# Definition for polynomial singly-linked list.
# class PolyNode:
#     def __init__(self, x=0, y=0, next=None):
#         self.coefficient = x
#         self.power = y
#         self.next = next

class Solution:
    def addPoly(self, poly1: 'PolyNode', poly2: 'PolyNode') -> 'PolyNode':
        head = PolyNode()
        cur = head
        
        while poly1 and poly2:
            # add poly1 to the result
            if poly1.power > poly2.power:
                cur.next = PolyNode(poly1.coefficient, poly1.power)
                poly1 = poly1.next
                cur = cur.next
            
            # add poly2 to the result
            elif poly2.power > poly1.power:
                cur.next = PolyNode(poly2.coefficient, poly2.power)
                poly2 = poly2.next
                cur = cur.next
                
            # add the combination of poly1 and poly2 to the result
            else: 
                # only update this if the new coefficient is not 0
                # NOTE: we don't move cur to the next position if we don't update it
                if poly1.coefficient + poly2.coefficient != 0:
                    cur.next = PolyNode(poly1.coefficient + poly2.coefficient, poly1.power) 
                    cur = cur.next
                    
                poly1 = poly1.next
                poly2 = poly2.next
                
        # add remaining if any
        if poly1:
            cur.next = poly1
        elif poly2:
            cur.next = poly2
            
        return head.next
# Iterative Solution
"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # special case
        if not head:
            return head
        
        # dfs using stack
        stack = deque([head])
        
        # use a pseudo pred to save the predecessor (the last node)
        pseudo = Node(0, None, head, None)
        pred = pseudo
        
        while stack:
            # pop the current node
            node = stack.pop()
            
            # link the predecessor and current node
            pred.next = node
            
            # update it's prev
            node.prev = pred
            
            # push the node's next to the stack first
            if node.next:
                stack.append(node.next)
            
            # if the node has child, push its child to the stack 
            if node.child:
                stack.append(node.child)
                
                # update its child to None
                node.child = None
                
            pred = node
        
        # detach the pseudo head node from the result
        # because initially it has a value 0
        pseudo.next.prev = None
        return pseudo.next
                
        
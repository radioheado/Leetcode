"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def inorderSuccessor(self, node: 'Node') -> 'Optional[Node]':
        
        # case 1: return leftmost child in node's right subtree 
        if node.right:
            node = node.right
            while node.left:
                node = node.left
            return node
        
        # case 2: node is the root and has no right subtree
        if node.parent:
            succ = node.parent
        else:
            return node.parent
        
        while succ:
            # case 3: node is a left child and has no right subtree
            if succ.val > node.val:
                return succ
            
            # case 4: first right child of the node's ancestor 
            succ = succ.parent
        
        return succ
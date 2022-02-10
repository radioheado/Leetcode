"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        
        first, prev = None, None
        
        def dfs(node = root):
            nonlocal first, prev
            if node:
                # get to the leftmost child
                dfs(node.left)
                
                # add links between prev and current node
                if prev:
                    prev.right = node
                    node.left = prev
                
                # if prev is still None, then it means we haven't
                # reached the smallest node
                else:
                    first = node
                
                prev = node
                dfs(node.right)
                
        dfs()
        prev.right = first
        first.left = prev
        
        return first
            
            
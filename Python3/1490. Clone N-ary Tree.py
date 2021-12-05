"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []
"""

class Solution:
    
    def __init__(self):
        self.visited = {}
        
    def cloneTree(self, root: 'Node') -> 'Node':
        if not root:
            return None
        
        if root in self.visited:
            return self.visited[root]
        
        node = Node(root.val, [])
        self.visited[root] = node
        
        node.children = [self.cloneTree(x) for x in root.children]
        
        return node
        
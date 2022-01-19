"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        
        s = deque([root])
        ans = []
        
        while s:
            root = s.pop()
            ans.append(root.val)
            
            for c in root.children:
                s.append(c)
        
        ans.reverse()
        return ans
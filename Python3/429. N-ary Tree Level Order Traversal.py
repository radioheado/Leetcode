"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        
        q = deque([root])
        ans = []
        
        while q:
            size = len(q)
            level = []
            
            # pop the same level
            for i in range(size):
                root = q.popleft()
                level.append(root.val)
                
                # push all children
                for c in root.children:
                    q.append(c)
            
            # add all nodes in the same level
            ans.append(level)
                
        return ans
        
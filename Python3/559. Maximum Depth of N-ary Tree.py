"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if not root:
            return 0

        q = deque([(root, 1)])
        ans = 0

        while q:
            root, depth = q.popleft()
            for c in root.children:
                q.append((c, depth + 1))
            ans = max(ans, depth)

        return ans
            
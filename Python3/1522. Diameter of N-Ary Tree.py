"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []
"""

class Solution:
    def diameter(self, root: 'Node') -> int:
        """
        :type root: 'Node'
        :rtype: int
        """
        ans = 0

        def dfs(node = root):
            if not node:
                return

            if not node.children:
                return 0

            first = second = 0

            for c in node.children:
                depth = dfs(c) + 1
                if depth >= first:
                    second = first
                    first = depth
                elif depth >= second:
                    second = depth

            nonlocal ans
            ans = max(ans, first + second) 
            return first   

        dfs()
        return ans
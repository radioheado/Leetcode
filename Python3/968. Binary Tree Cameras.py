# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return 0, 0, inf
            L = dfs(node.left)
            R = dfs(node.right)
            
            # Strict state: all nodes below are covered, not this one
            dp0 = L[1] + R[1]
            # Normal state: all nodes below and this one are covered, no camera here
            dp1 = min(L[2] + min(R[1:]), R[2] + min(L[1:]))
            # Placed state: all nodes below and this one are covered, place camera here
            dp2 = 1 + min(L) + min(R)
            
            return dp0, dp1, dp2
        
        return min(dfs(root)[1:])
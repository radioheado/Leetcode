# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        stack = []
        depth = 0
        
        if not root:
            return depth
        
        # the number indicates its depth
        stack.append((1, root))
        
        while stack:
            cur_depth, root = stack.pop()
            if root:
                depth = max(depth, cur_depth)
                stack.append((cur_depth+1, root.left))
                stack.append((cur_depth+1, root.right))
                
        return depth
        
                
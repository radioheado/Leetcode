# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        self.ans = float('inf')
        
        def dfs(node):
            if not node:
                return 
            
            if abs(node.val-target) < abs(self.ans-target):
                self.ans = node.val
            
            # visit left
            if node.val > target:
                dfs(node.left)
            # visit right
            else:
                dfs(node.right)
            
        dfs(root)
        return self.ans
                
            
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        self.ans = None
        
        def dfs(node):
            if not node:
                return False
            
            # left recursion
            left = dfs(node.left)
            
            # right recursion
            right = dfs(node.right)
            
            # if the current node is p or q
            current = node==p or node==q
            
            if left+right+current >= 2:
                self.ans = node
                
            return left or right or current
        
        dfs(root)
        return self.ans
            
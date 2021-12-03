# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Solution
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        
        def dfs(node, target):
            if not node:
                return False
            
            target -= node.val
            if not node.left and not node.right:
                return target == 0
            
            return dfs(node.left, target) or dfs(node.right, target)
        
        return dfs(root, targetSum)

# Iterative Solution
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        
        stack = [(root, targetSum)]
        
        while stack:
            root, target = stack.pop()
            target -= root.val
            
            # root is a leaf node
            if not root.left and not root.right and target == 0:
                return True
            
            if root.right:
                stack.append((root.right, target))
            if root.left:
                stack.append((root.left, target))
            
                
        return False
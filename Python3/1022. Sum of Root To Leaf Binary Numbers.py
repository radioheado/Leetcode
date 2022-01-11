# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Solution
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        self.total = 0
        
        def dfs(node, path):
            # if node is null
            if not node:
                return
            
            # update the path sum from top to this node
            path = path*2 + node.val
            
            # if node is a leaf node
            if not node.left and not node.right:
                self.total += path
                
            dfs(node.left, path)
            dfs(node.right, path)
            
        dfs(root, 0)
        return self.total
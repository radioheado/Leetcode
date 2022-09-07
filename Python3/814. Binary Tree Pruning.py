# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pruneTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        
        def dfs(node = root):
            if not node:
                return 0
            
            cur = node.val
            left = dfs(node.left)
            right = dfs(node.right)
            
            if left == 0:
                node.left = None
            if right == 0:
                node.right = None
            
            if cur + left + right > 0:
                return 1
            else:
                return 0
            
        total = dfs()
        if total == 0:
            return None
        return root
            
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        vals = []
        
        def dfs(node = root):
            if not node.left and not node.right:
                vals.append(node.val)
                return
            
            if node.left:
                dfs(node.left)
            vals.append(node.val)
            if node.right:
                dfs(node.right)
                
        dfs()
        return vals[k-1]
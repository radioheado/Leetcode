# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        value = root.val
        q = deque([root])
        
        while q:
            root = q.pop()
            
            if root.val != value:
                return False
            
            if root.left:
                q.append(root.left)
            
            if root.right:
                q.append(root.right)
                
            
        return True
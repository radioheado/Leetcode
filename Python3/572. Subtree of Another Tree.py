# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root:
            return self.dfs(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
            
        
    def dfs(self, root, subRoot):
        # both are empty
        if not root and not subRoot:
            return True
        
        # one is not empty
        if not root or not subRoot:
            return False
        
        # different values, move down from root
        if root.val != subRoot.val:
            return False
        
        # same value, recurse
        return self.dfs(root.left, subRoot.left) and self.dfs(root.right, subRoot.right)
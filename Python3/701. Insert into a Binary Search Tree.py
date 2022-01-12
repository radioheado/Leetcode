# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative Solutionß
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        
        node = root
        
        while root:
            if root.val < val:
                if not root.right:
                    root.right = TreeNode(val)
                    return node
                else:
                    root = root.right
            
            else:
                if not root.left:
                    root.left = TreeNode(val)
                    return node
                else:
                    root = root.left
                    
        # if root is null, make a TreeNode
        return TreeNode(val)

# Recursive Solution
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return TreeNode(val)
        
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)
            
        else:
            root.left = self.insertIntoBST(root.left, val)
                      
        return root
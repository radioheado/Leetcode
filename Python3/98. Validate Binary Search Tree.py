# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Solution
class Solution:
    
    def isValid(self, root, high=float("inf"), low=float("-inf")):
        # empty trees are valild BSTs
        if not root:
            return True
        
        # if the value is out of the range, it's not a BST
        if root.val <= low or root.val >= high:
            return False
        
        return self.isValid(root.left, root.val, low) and self.isValid(root.right, high, root.val)    
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        '''
            logic:
                root.val > root.left.val and root.val < root.right.val and isValidBST(root.left) and isValidBST(root.right)
        '''
        
        return self.isValid(root)
            

# Iterative Solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        stack = [(root, float("inf"), float("-inf"))]
        
        while stack:
            root, high, low = stack.pop()
            if not root:
                continue
                
            if root.val <= low or root.val >= high:
                return False
            
            stack.append((root.left, root.val, low))
            stack.append((root.right, high, root.val))
            
        return True
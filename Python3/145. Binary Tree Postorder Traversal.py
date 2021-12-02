# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = [root]
        ans = []
        
        while stack:
            root = stack.pop()
            if not root:
                break
                
            ans.append(root.val)
            
            if root.left:
                stack.append(root.left)
                
            if root.right:
                stack.append(root.right)
                
        return ans[::-1]
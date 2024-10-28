# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if (not root1 and root2) or (not root2 and root1):
            return False
        elif not root1 and not root2:
            return True

        if root1.val == root2.val:
            return self.flipEquiv(root1.left, root2.left) and \
                   self.flipEquiv(root1.right, root2.right) or \
                   self.flipEquiv(self.reverseTree(root1).left, root2.left) and \
                   self.flipEquiv(root1.right, root2.right)
        else:
            return False


    def reverseTree(self, root: Optional[TreeNode]) -> TreeNode:
        l, r = root.left, root.right
        root.left = r
        root.right = l
        return root
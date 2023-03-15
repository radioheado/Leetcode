# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:

        def dfs(node: Optional[TreeNode]) -> bool:
            # leaf node
            if node.val == 0 or node.val == 1:
                return node.val == 1

            left = dfs(node.left)
            right = dfs(node.right)

            # OR function
            if node.val == 2:
                return left or right

            # AND function
            elif node.val == 3:
                return left and right

        return dfs(root)
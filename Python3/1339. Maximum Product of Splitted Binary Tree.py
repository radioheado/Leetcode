# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:

        def treeSum(root):
            if not root:
                return 0

            left = treeSum(root.left)
            right = treeSum(root.right)
            return left + right + root.val

        total = treeSum(root)
        prod = 0
        MOD = 10**9 + 7
        
        def dfs(node):
            if not node:
                return 0

            nonlocal prod
            left = dfs(node.left)
            right = dfs(node.right)

            prod = max(prod, (total - left) * left, (total - right) * right)
            return left + right + node.val

        dfs(root)
        return prod % MOD

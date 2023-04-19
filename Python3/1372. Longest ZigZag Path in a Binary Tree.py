# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        self.path = 0

        def dfs(node, left, path):
            if node:
                self.path = max(self.path, path)

                # current node is left node
                if left:
                    dfs(node.right, False, path + 1)
                    dfs(node.left, True, 1)

                # current node is right node
                else:
                    dfs(node.left, True, path + 1)
                    dfs(node.right, False, 1)

        dfs(root, False, 0)
        dfs(root, True, 0)
        return self.path
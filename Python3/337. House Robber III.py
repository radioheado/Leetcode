# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(node = root):
            if not node:
                return 0, 0

            lRob, lSkip = dfs(node.left)
            rRob, rSkip = dfs(node.right)

            # if rob this node, we need to skip both its children
            Rob = node.val + lSkip + rSkip
            
            # if skip this node, we can either skip or rob any of its children
            # so pick the higher one from each
            Skip = max(lRob, lSkip) + max(rRob, rSkip)
            nonlocal ans
            ans = max(Rob, Skip)

            return Rob, Skip

        dfs()
        return ans

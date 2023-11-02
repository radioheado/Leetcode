# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        
        # returns: total, count, answer
        def dfs(node: Optional[TreeNode]) -> List[int]:
            # base case
            if not node:
                return [0, 0, 0]

            left = dfs(node.left)
            right = dfs(node.right)

            total = left[0] + right[0] + node.val
            count = left[1] + right[1] + 1
            if node.val == total // count:
                return [total, count, left[2] + right[2] + 1]

            return [total, count, left[2] + right[2]]

        return dfs(root)[2]
            
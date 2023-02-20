# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        stack = deque()
        while root:
            stack.append(root)
            root = root.left

        prev = -300000
        ans = 100000
        while stack:
            node = stack.pop()
            ans = min(ans, node.val - prev)
            prev = node.val
            node = node.right
            while node:
                stack.append(node)
                node = node.left

        return ans
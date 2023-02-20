# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
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
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        q = deque([(root, 0)])
        ans = 0

        while q:
            root, path = q.popleft()
            path = path * 10 + root.val

            if not root.left and not root.right:
                ans += path

            if root.left:
                q.append((root.left, path))

            if root.right:
                q.append((root.right, path))

        return ans
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        q = collections.deque([root])
        max_sum = -math.inf
        max_level = 1
        level = 1

        while q:
            size = len(q)
            level_sum = 0
            for _ in range(size):
                node = q.popleft()
                level_sum += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            if max_sum < level_sum:
                max_level = level
                max_sum = level_sum

            level += 1    

        return max_level

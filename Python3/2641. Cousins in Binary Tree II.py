# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q = deque([(root, 0)])
        next_sum = 0

        while q:
            size = len(q)
            cur_sum = next_sum
            next_sum = 0
            for _ in range(size):
                node, sibling_sum = q.popleft()
                node.val = cur_sum - sibling_sum

                l = node.left.val if node.left else 0
                r = node.right.val if node.right else 0
                next_sum += l + r

                if node.left:
                    q.append((node.left, l + r))
                if node.right:
                    q.append((node.right, l + r))

        return root

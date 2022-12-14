# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        leaf1 = []
        leaf2 = []

        q1 = deque([root1])
        q2 = deque([root2])

        while q1:
            root1 = q1.pop()

            # leaf node
            if not root1.left and not root1.right:
                leaf1.append(root1.val)

            if root1.right:
                q1.append(root1.right)
            if root1.left:
                q1.append(root1.left)
            

        p1 = 0
        while q2:
            root2 = q2.pop()
            # leaf node
            if not root2.left and not root2.right:
                leaf2.append(root2.val)

            if root2.right:
                q2.append(root2.right)
            if root2.left:
                q2.append(root2.left)
            

        return leaf1 == leaf2


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def twoSumBSTs(self, root1: Optional[TreeNode], root2: Optional[TreeNode], target: int) -> bool:
        s1, s2 = [], []
        while root1:
            s1.append(root1)
            root1 = root1.left

        while root2:
            s2.append(root2)
            root2 = root2.right

        while s1 and s2:
            root1 = s1[-1]
            root2 = s2[-1]
            if root1.val + root2.val == target:
                return True
            elif root1.val + root2.val < target:
                root1 = s1.pop().right
                while root1:
                    s1.append(root1)
                    root1 = root1.left
            else:
                root2 = s2.pop().left
                while root2:
                    s2.append(root2)
                    root2 = root2.right

        return False

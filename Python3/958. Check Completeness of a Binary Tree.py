# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        q = deque([root])
        complete = True

        while q:
            root = q.popleft()
            if not root:
                complete = False
            else:
                if not complete:
                    return False
                q.append(root.left)
                q.append(root.right)

        return True
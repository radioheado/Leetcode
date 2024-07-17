# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        self.ans = []
        delete = set(to_delete)

        def dfs(node):
            if not node:
                return None

            node.left = dfs(node.left)
            node.right = dfs(node.right)
            if node.val in delete:
                if node.left:
                    self.ans.append(node.left)
                if node.right:
                    self.ans.append(node.right)
                return None

            return node

        root = dfs(root)
        if root:
            self.ans.append(root)
        return self.ans
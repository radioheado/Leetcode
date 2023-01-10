# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:

        def dfs(node = root, parent = None, child = ''):
            if not node:
                return

            dfs(node.left, node, 'l')
            dfs(node.right, node, 'r')

            if not node.left and not node.right and node.val == target:
                if child == 'l':
                    parent.left = None
                elif child == 'r':
                    parent.right = None

        dfs()
        if not root.left and not root.right and root.val == target:
            return None
            
        return root
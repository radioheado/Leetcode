# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getLonelyNodes(self, root: Optional[TreeNode]) -> List[int]:
        
        
        def dfs(node, lonely):
            if not node.left and not node.right:
                return []
            
            if node.left and node.right:
                dfs(node.left, lonely)
                dfs(node.right, lonely)
                return lonely
            
            if node.left:
                lonely.append(node.left.val)
                dfs(node.left, lonely)
            elif node.right:
                lonely.append(node.right.val)
                dfs(node.right, lonely)
            
            return lonely
        
        return dfs(root, [])
        
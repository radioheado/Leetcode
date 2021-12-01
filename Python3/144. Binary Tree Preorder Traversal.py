# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        # order: node -> left -> right
        def dfs(node, l):
            if not node:
                return 
            
            # add node.val to the list
            l.append(node.val)
            
            if node.left:
                dfs(node.left, l)
            if node.right:
                dfs(node.right, l)
                
        
        ans = []
        dfs(root, ans)
        return ans
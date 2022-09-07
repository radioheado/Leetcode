# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        res = ''
        
        def dfs(node = root):
            nonlocal res
            
            res += str(node.val)
            if node.right:
                if not node.left:
                    res += '()'
                else:
                    res += '(' 
                    dfs(node.left) 
                    res += ')'
                    
                res += '('
                dfs(node.right) 
                res += ')'
            
            elif node.left:
                res += '(' 
                dfs(node.left) 
                res += ')'
            
        dfs()
        return res
                
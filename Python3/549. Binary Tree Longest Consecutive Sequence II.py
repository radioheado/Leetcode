# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        ans = 0
        
        # cons = [inr, dec]
        def dfs(node = root):
            if not root:
                return [0, 0]
            
            inc = dec = 1
            
            nonlocal ans
            
            if node.left:
                left = dfs(node.left)
                # decreasing path
                if node.val == node.left.val + 1:
                    dec = left[1] + 1
                
                # increasing path
                elif node.val == node.left.val - 1:
                    inc = left[0] + 1
                    
            if node.right:
                right = dfs(node.right)
                # decreasing path
                if node.val == node.right.val + 1:
                    dec = max(dec, right[1] + 1)
                
                # increasing path
                elif node.val == node.right.val - 1:
                    inc = max(inc, right[0] + 1)
                    
            ans = max(ans, inc + dec - 1)
                    
            return [inc, dec]
                
        dfs()      
        return ans
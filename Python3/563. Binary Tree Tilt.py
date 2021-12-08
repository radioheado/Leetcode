# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node):
            if not node:
                return 0, 0
            
            left_sum, left_tilts = dfs(node.left)
            right_sum, right_tilts = dfs(node.right)
            cumu_tilts = left_tilts + right_tilts + abs(left_sum - right_sum)
            cur_sum = left_sum + right_sum + node.val
            
            return cur_sum, cumu_tilts
        
        total_sum, total_tilts = dfs(root)
        return total_tilts
        
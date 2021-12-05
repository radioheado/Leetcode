# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        
        def dfs(node, max_sum):
            
            if not node:
                return 0, max_sum
            
            left_path, left_sum = dfs(node.left, max_sum)
            #print("left: \t", left_path, left_sum)
            
            right_path, right_sum = dfs(node.right, max_sum)
            #print("right: \t", right_path, right_sum)
            
            # the path has the largest value should be one of left+cur
            # or right+cur, or cur itself
            max_path = max(left_path+node.val, right_path+node.val, node.val)
            max_sum = max(left_path+right_path+node.val, max_path, max_sum, left_sum, right_sum)
            #print("max: \t", max_path, max_sum)
            return max_path, max_sum
        
        path, m = dfs(root, float('-inf'))
        
        return m
                
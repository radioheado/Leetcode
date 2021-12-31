# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node, maxx, minn):
            if not node:
                return maxx - minn
            
            maxx = max(maxx, node.val)
            minn = min(minn, node.val)
            
            #print("cur = %d, maxx = %d, minn = %d" %(node.val, maxx, minn))
            # get results from left and right subtree
            left = dfs(node.left, maxx, minn)
            right = dfs(node.right, maxx, minn)
            
            return max(left, right)
        
        
        return dfs(root, root.val, root.val)
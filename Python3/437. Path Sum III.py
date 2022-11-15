# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix = defaultdict(int)
        ans = 0
        
        def dfs(node = root, pathSum = 0):
            nonlocal ans
            
            if not node:
                return
            
            pathSum += node.val
            if pathSum == targetSum:
                ans += 1
                
            ans += prefix[pathSum - targetSum]
            prefix[pathSum] += 1
            
            dfs(node.left, pathSum)
            dfs(node.right, pathSum)
            
            prefix[pathSum] -= 1
            
        dfs()
        return ans
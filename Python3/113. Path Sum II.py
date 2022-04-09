# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        
        self.ans = []
        
        def dfs(node = root, path = [root.val], s = root.val):
            # leaf node
            if not node.left and not node.right:
                if s == targetSum:
                    self.ans.append(path)
                    return
                
            if node.left:    
                dfs(node.left, path + [node.left.val], s+node.left.val)
            if node.right:
                dfs(node.right, path + [node.right.val], s+node.right.val)
            
        dfs()
        return self.ans
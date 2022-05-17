# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        q = deque([root])
        while q:
            level = len(q)
            _sum = 0
            
            for _ in range(level):
                root = q.popleft()
                _sum += root.val
                
                if root.left:
                    q.append(root.left)
                    
                if root.right:
                    q.append(root.right)
        
        return _sum
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        ans = []
        
        if not root:
            return ans
        
        q = deque([root])
        while q:
            size = len(q)
            _sum = 0
            
            for _ in range(size):
                root = q.popleft()
                _sum += root.val
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
            
            ans.append(_sum / size)
            
        return ans
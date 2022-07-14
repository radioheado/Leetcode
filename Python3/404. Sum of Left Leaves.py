# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        ans = 0
        if not root:
            return ans
        
        queue = deque([(root, 'r')])
        while queue:
            root, d = queue.popleft()
            if not root.left and not root.right and d == 'l':
                ans += root.val
                continue
                
            if root.left:
                queue.append((root.left, 'l'))
            
            if root.right:
                queue.append((root.right, 'r'))
            
        return ans
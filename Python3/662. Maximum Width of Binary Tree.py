# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        q = deque([(root, 0)])
        ans = 0
        
        while q:
            level = len(q)
            first = q[0][1]
            # if cur is not the last node in this level
            # count all empty child
            for i in range(level):
                root, width = q.popleft()
                ans = max(ans, width-first+1)
                if root.left:
                    q.append((root.left, width*2))
                if root.right:
                    q.append((root.right, width*2+1))
            
        return ans     
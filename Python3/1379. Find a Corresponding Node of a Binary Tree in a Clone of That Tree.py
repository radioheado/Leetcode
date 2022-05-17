# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        
        q = deque([(original, cloned)])
        
        while q:
            ori, clo = q.popleft()
            if ori == target:
                return clo
            
            if ori.left:
                q.append((ori.left, clo.left))
                
            if clo.right:
                q.append((ori.right, clo.right))
        
        
        
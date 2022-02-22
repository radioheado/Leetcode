# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        
        parent = self.lowestCommonAncestor(root, startValue, destValue)
        
        stack = deque([(parent, "")])
        while stack:
            root, path = stack.pop()
            if root.val == startValue:
                start = path
            
            if root.val == destValue:
                dest = path
                
            if root.left:
                stack.append((root.left, path+"L"))
                
            if root.right:
                stack.append((root.right, path+"R"))
                
        # now i is the first char that differs
        ans = ""
        ans += "U"*(len(start))
        ans += dest
        
        return ans;
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: int, q: int) -> 'TreeNode':
        
        self.ans = None
        
        def dfs(node):
            if not node:
                return False
            
            # left recursion
            left = dfs(node.left)
            
            # right recursion
            right = dfs(node.right)
            
            # if the current node is p or q
            current = node.val==p or node.val==q
            
            if left+right+current >= 2:
                self.ans = node
                
            return left or right or current
        
        dfs(root)
        return self.ans
            
        
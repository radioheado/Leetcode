# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Solution
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
               
        def isMirror(n1, n2):
            if not n1 and not n2:
                return True
            if not n1 or not n2:
                return False
            
            # two nodes must have the same values
            # and their children should be symmetric
            return (n1.val==n2.val) and isMirror(n1.left, n2.right) and isMirror(n1.right, n2.left)
        
        return isMirror(root, root)

# Interative Solution
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = [root, root]
        
        while queue:
            n1 = queue.pop(0)
            n2 = queue.pop(0)
            
            # if both nodes are None, continue the loop for remaining nodes
            if not n1 and not n2:
                continue
            
            # one of the nodes is None
            if not n1 or not n2:
                return False
            
            # values are different
            if n1.val != n2.val:
                return False
            
            queue.append(n1.left)
            queue.append(n2.right)
            queue.append(n1.right)
            queue.append(n2.left)
            
        return True
            
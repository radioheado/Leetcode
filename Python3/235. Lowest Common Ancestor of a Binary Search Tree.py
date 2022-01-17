# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # make p.val < q.val for easier rules
        if(p.val > q.val):
            return self.lowestCommonAncestor(root, q, p)
        
        # if root is between p and q, then it's the desired parent
        # if p.val > root.val, then q.val > root.val, visit right
        # otherwise, visit left
        while root:
            if p.val > root.val:
                root = root.right
            elif q.val < root.val:
                root = root.left
            else:
                return root
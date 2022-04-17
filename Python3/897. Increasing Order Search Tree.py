# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        
        stack = deque()
        newRoot = None
        prev = None
        
        while stack or root:
            while root:
                stack.append(root)
                #print(root.val)
                root = root.left
            
            root = stack.pop()
            # new root
            if newRoot == None:
                newRoot = root
                
            # update prev relationship
            if prev != None:
                root.left = None
                prev.right = root
                
            prev = root
            root = root.right
        
        return newRoot
            
                
            
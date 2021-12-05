# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def flattenTree(self, node):
        if not node:
            return None
        
        # for leaf node, return itself because we don't need to do anything for it
        if not node.left and not node.right:
            return node
        
        # recursively flatten the left subtree, returned is the tail
        left = self.flattenTree(node.left)
        
        # recursively flatten the right subtree, returned is the tail
        right = self.flattenTree(node.right)
        
        if left:
            left.right = node.right
            node.right = node.left
            node.left = None
            
        return right if right else left
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.flattenTree(root)


# O(N) time, O(1) space
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        
        node = root
        
        while node:
            print("current node = ", node.val)
            if node.left:
                rightmost = node.left
                
                # find the rightmost node of node.left
                # then modify it to make its right to node.right
                while rightmost.right:
                    
                    rightmost = rightmost.right
                
                print("rightmost = ", rightmost.val)
                rightmost.right = node.right
                node.right = node.left
                node.left = None
                
            node = node.right
        
        
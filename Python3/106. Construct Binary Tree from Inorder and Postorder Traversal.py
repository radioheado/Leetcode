# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return None
        
        # get the current root node's value
        val = postorder[-1]
        
        # find the value in inorder, 
        # thus inorder[:index] contains its left subtree
        # and inorder[index+1:] contains its right subtree
        index = inorder.index(val)
        
        # make a TreeNode object
        root = TreeNode(val)
        root.left = self.buildTree(inorder[:index], postorder[:index])
        root.right = self.buildTree(inorder[index+1:], postorder[index:-1])
        
        return root
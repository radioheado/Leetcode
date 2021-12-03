# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        # the first element in preorder is the root node
        value = preorder[0]
        
        index = inorder.index(value)
        #print(value,index)
        
        root = TreeNode(value)
        root.left = self.buildTree(preorder[1:1+index], inorder[:index])
        root.right = self.buildTree(preorder[1+index:], inorder[index+1:])
        
        return root

# Solution 2
# O(N) time and O(N) space
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        mapping = {}
        for i in range(len(inorder)):
            mapping[inorder[i]] = i
        
        
        def arrayTree(left, right):
            if left > right:
                return None
            
            # the first element in preorder is the root node
            value = preorder.pop(0)
            
            # get the index of the root through the dict, O(1)
            index = mapping[value]
            #print(value,index)

            root = TreeNode(value)
            root.left = arrayTree(left, index-1)
            root.right = arrayTree(index+1, right)
        
            return root
        
        return arrayTree(0, len(preorder)-1)
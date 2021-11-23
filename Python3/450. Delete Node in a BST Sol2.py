# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        
        if not root:
            return None
        
        # current node is the key
        if root.val == key:
            left  = root.left
            right = root.right
            
            # if root has no right subtree
            # make root its left child, no modification needed
            if not right:
                root = left
                return root
            
            # if root has no left subtree
            # make root its right child, no modification needed
            if not left:
                root = right
                return root
            
            # if root has both left and right subtree
            # find its predecessor, and "attach" its right to the predecessor
            # the predecessor is the largest number that is smaller than root
            # thus root.right are all greater than the predecessor
            # and any other nodes to the left of root are smaller than the predecessor and root.right
            # then make root its left child
            # the structure is:
            #               root                            left
            #              /    \                          /    \
            #           left    right           ->          predecessor
            #           /   \                                    \
            #            predecessor                            right
            
            predecessor = left
            # make sure the condition is in this way so predecessor will never be None
            while predecessor.right:
                predecessor = predecessor.right
                
            predecessor.right = right
            root = left
            return root
        
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
            
        else:
            root.right = self.deleteNode(root.right, key)
            
        return root
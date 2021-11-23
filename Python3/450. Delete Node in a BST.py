# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # The helper function to search for the successor of the node that needs to be deleted
    # The successor is the left-most node to the right of the current node
    # Visit right first, then goes as deep as possible to its left
    def successor(self, root):
        root = root.right
        while root.left:
            root = root.left
        return root.val
    
    
    # The helper function to search for the predecessor of the node that needs to be deleted
    # The predecessor is the right-most node to the left of the current node
    # Visit left first, then goes as deep as possible to its right
    def predecessor(self, root):
        root = root.left
        while root.right:
            root = root.right
        return root.val
    
    
    
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        
        if not root:
            return None
        
        # The key is in the right subtree of the root
        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        
        # The key is in the left subtree of the root   
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        
        # The key is the current node (root)
        else:
            
            # Situation 1: the node to delete is a leaf node
            # root.left = None and root.right = None
            # No need to modify the BST, just delete the current node (root)
            # Make root None
            if not root.left and not root.right:
                root = None
                
            # Situation 2: the node to delete is not a leaf node 
            # and has right subtree
            # Make root.val to its successor
            # And delete the successor recursively
            elif root.right:
                root.val = self.successor(root)
                root.right = self.deleteNode(root.right, root.val)
                
            # Situation 3: the node to delete is not a leaf node
            # and has left subtree
            # Make root.val to its predecessor
            # And delete the predecessor recursively
            else:
                root.val = self.predecessor(root)
                root.left = self.deleteNode(root.left, root.val)
                
        return root
            
            
        
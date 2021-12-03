# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# without using global variables
class Solution:
    def countUnivalSubtrees(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        def count(node, level):
            
            # if node is a leaf
            if not node.left and not node.right:
                # return the node's value for comparison
                return node.val, 1

            flag1, flag2, total1, total2 = True, True, 0, 0
            
            # check if the subtrees are univalued before counting this node
            if node.left:
                # get the leaf node's value and the count
                value, total1 = count(node.left, level+1) 
                
                # update flag1 if the values are equal
                flag1 = (node.left.val == node.val == value)
                
            if node.right:
                value, total2 = count(node.right, level+1)
                
                flag2 = (node.right.val == node.val == value)
            
            '''
            print("current node:\t", node.val) 
            print("current level:\t", level)
            print("node.left: \t", value1, total1, flag1)
            print("node.right: \t", value2, total2, flag2)
            '''
            
            # if its left and right subtrees both exist and are univalued
            # add up total counts and increment extra 1 because they together form a new subtree
            if flag1 and flag2:
                #print("total:\t", total1+total2+1)
                return value, total1+total2+1

            # other situation is just: flag1 and flag2 are both False!
            # only return the total counts from the subtrees
            else:
                #print("total:\t", total1+total2)
                return value, total1+total2
    
        _, total = count(root, 1)
        return total
            
        
            
        